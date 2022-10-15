import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class ListTests{
  @Test
  public void testfilter() {
    String[] expect = new String[]{"Linked", "Array"};
    List<String> test = Arrays.asList("Linked", "Array");
    List<String> filter = ListExamples.filter(test, new AllTrueFilter());
    String[] objects = filter.size() == 0 ? new String[]{} : filter.toArray(new String[filter.size()]);
    assertArrayEquals(expect, objects);
  }
}