import static org.junit.Assert.*;
import org.junit.*;

public class ListTests{
  @Test
  public void testfilter(){
    String[] contents1 = {"a1", "b", "a2", "a3", "c"};
    String[] contents2 = {"a1", "a2", "a3"};
    List<String> list1 = new ArrayList<>(contents1);
    List<String> list2 = new ArrayList<>(contents2);
    assertArrayEquals(list2, ListExamples.filter(list1, sc.filter(new checka())));
  }
}