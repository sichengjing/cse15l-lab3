package searchEngine20221015;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import transfer.ArrayGL;
import transfer.LinkedGL;
import transfer.MyList;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class TestLists {


	public static Collection<Object[]> LISTNUMS =
			Arrays.asList(new Object[][] { {"Linked"}, {"Array"} });

	@Parameterized.Parameters(name = "{0}List")
	public static Collection<Object[]> bags() {
		return LISTNUMS;
	}


	private String listType;

	public TestLists(String listType) {
		super();
		this.listType = listType;
	}


	private StringChecker makeCheck() {
		switch (this.listType) {
			case "Linked":
				return new StringChecker() {
					@Override
					public boolean checkString(String s) {
						return false;
					}
				};
			case "Array":
				return new StringChecker() {
					@Override
					public boolean checkString(String s) {
						return false;
					}
				};
		}
		return null;
	}



	@Test
	public void testSimpleToArray() {
		List<String>  test = Arrays.asList("Linked", "Array");
		List<String> filter = ListExamples.filter(test, makeCheck());
		//预期结果
		String[] expect = new String[]{};
		assertArrayEquals(expect,filter.size() == 0 ?new String[] {}:filter.toArray());
	}

}