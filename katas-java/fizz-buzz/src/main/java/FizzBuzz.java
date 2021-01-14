import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.IntStream;

public class FizzBuzz {

  public static List<String> getFizzBuzzList() {

    return IntStream.range(1, 101)
      .mapToObj(i -> {

        var result = "";
        var sInt = "" + i;
        if (i % 3 == 0 || sInt.contains("3")) {
          result += "Fizz";
        }

        if (i % 5 == 0 || sInt.contains("5")) {
          result += "Buzz";
        }

        // JID:

        // JID: return result?
        return (result.isEmpty()) ? "" + i : result;
      })
      .collect(toList());
  }
}
