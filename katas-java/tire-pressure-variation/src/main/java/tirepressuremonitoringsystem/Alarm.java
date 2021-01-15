package tirepressuremonitoringsystem;

public class Alarm {

  private final double LowPressureThreshold = 17;
  private final double HighPressureThreshold = 21;

  private ISensor sensor = new Sensor();

  private IPrinter printer = new Printer();

  private boolean alarmOn = false;

  public Alarm() {
  }

  public Alarm(ISensor sensor, IPrinter printer) {
    this.sensor = sensor;
    this.printer = printer;
  }

  public void check() {
    double psiPressureValue = sensor.popNextPressurePsiValue();

    if (psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue) {
      if (!isAlarmOn()) {
        alarmOn = true;
        printer.print("Alarm activated!");
      }
    } else {
      if (isAlarmOn()) {
        alarmOn = false;
        printer.print("Alarm deactivated!");
      }
    }
  }

  private boolean isAlarmOn() {
    return alarmOn;
  }
}
