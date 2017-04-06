package jp.example.samplesystem.dataproc.pdf;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;
public class ListAssertTest {
  @Test(dataProvider="dp")
  public void assertEqualsTest(Object[] expects, Object[] actuals) {
	  List<Object>expectList = new ArrayList<>();
	  List<Object>actualList = new ArrayList<>();
	  for(Object expect: expects) {
		  expectList.add(expect);
	  }
	  for(Object actual: actuals) {
		  actualList.add(actual);
	  }
	  ListAssert.assertEquals("test", expectList, actualList);
  }

  @DataProvider
  public Object[][] dp() {
	  return new Object[][] {
		  new Object[]{(Object)new String[]{"a", "b", "c"}, (Object)new String[]{"a", "b", "c"}},
		  new Object[]{(Object)new Integer[]{1, 2, 3}, (Object)new Integer[]{1, 2, 3}},
	  };
  }

  @Test
  public void assertEqualsFail() {
	  List<Object>expectList = new ArrayList<Object>(){{add("a"); add("b"); add("c");}};
	  List<Object>actualList = new ArrayList<Object>(){{add("a"); add("b"); add("d");}};

	  ListAssert.assertEquals("test", expectList, actualList);
	  
  }
}
