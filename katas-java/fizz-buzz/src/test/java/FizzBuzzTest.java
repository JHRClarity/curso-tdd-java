import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

public class FizzBuzzTest {

  @Test
  public void checkFirstElementIsOne() {

    List<String> result = FizzBuzz.getFizzBuzzList();

    assertEquals("1", result.get(0));
  }

  @Test
  public void checkSecondElementIsTwo() {

    List<String> result = FizzBuzz.getFizzBuzzList();

    assertEquals("2", result.get(1));
  }

  @Test
  public void checkThirdElementIsFizz() {

    List<String> result = FizzBuzz.getFizzBuzzList();

    assertEquals("Fizz", result.get(2));
  }

  @Test
  public void checkFourthElementIsFour() {

    List<String> result = FizzBuzz.getFizzBuzzList();

    assertEquals("4", result.get(3));
  }

  @Test
  public void checkFifthElementIsBuzz() {

    List<String> result = FizzBuzz.getFizzBuzzList();

    assertEquals("Buzz", result.get(4));
  }

  @Test
  public void check15thElementIsFizzBuzz() {

    List<String> result = FizzBuzz.getFizzBuzzList();

    assertEquals("FizzBuzz", result.get(14));
  }

  @Test
  public void checkResultHas100Elements() {

    List<String> result = FizzBuzz.getFizzBuzzList();

    assertEquals(100, result.size());
  }

  @Test
  public void checkIfNumberHasA3IsFizz() {

    List<String> result = FizzBuzz.getFizzBuzzList();

    assertEquals("Fizz", result.get(12));
    assertEquals("Fizz", result.get(30));
  }

  @Test
  public void checkIfNumberHasA5_IsFizz() {

    List<String> result = FizzBuzz.getFizzBuzzList();

    assertEquals("Buzz", result.get(51));
    assertEquals("Buzz", result.get(57));
  }

  @Test
  public void checkIfNumberHasA3orA5_IsFizzBuzz() {

    List<String> result = FizzBuzz.getFizzBuzzList();

    assertEquals("FizzBuzz", result.get(14));
    assertEquals("FizzBuzz", result.get(50));
  }
}
