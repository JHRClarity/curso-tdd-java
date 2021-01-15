package tirepressuremonitoringsystem;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

public class AlarmTest {

  @Test
  public void checkAlarmIsActiveWhenLowPressure() {

    var sensor = new StubSensor(15);
    var printer = new SpyPrinter();
    var alarm = new Alarm(sensor, printer);

    alarm.check();

    assertThat(true, is(printer.isActivated()));
  }

  @Test
  public void checkAlarmIsActiveWhenHighPressure() {
    var sensor = new StubSensor(28);
    var printer = new SpyPrinter();
    var alarm = new Alarm(sensor, printer);

    alarm.check();

    assertThat(true, is(printer.isActivated()));
  }

  @Test
  public void checkAlarmIsNotActiveWhenNormalPressure() {
    var sensor = new StubSensor(20);
    var printer = new SpyPrinter();
    var alarm = new Alarm(sensor, printer);

    alarm.check();

    assertThat(false, is(printer.isActivated()));
  }

  @Test
  public void checkAlarmIsNotActiveWhenPressureIsRestored() {

    var sensor = new StubSensor(2);
    var printer = new SpyPrinter();
    var alarm = new Alarm(sensor, printer);
    alarm.check();
    sensor.setPressure(20);

    alarm.check();

    assertThat(false, is(printer.isActivated()));
  }

  private static class StubSensor implements ISensor {

    private double pressure;

    public StubSensor(double pressure) {
      this.pressure = pressure;
    }

    @Override
    public double popNextPressurePsiValue() {
      return pressure;
    }

    public void setPressure(double pressure) {
      this.pressure = pressure;
    }
  }

  private static class SpyPrinter implements IPrinter {

    private boolean activated;

    @Override
    public void print(String s) {

      if ("Alarm activated!".equals(s)) {
        activated = true;
      } else if ("Alarm deactivated!".equals(s)) {
        activated = false;
      }

    }

    public boolean isActivated() {
      return activated;
    }
  }
}

