package jp.example.samplesystem.dataproc.pdf;

import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class PdfAdapterTest {
	@Test(dataProvider = "dp")
	public void testPdf(String expectName, String actualName, String expectBirth, String actualBirth) {
		PdfData actual = new PdfData();
		actual.setName(actualName);
		actual.setBirthday(actualBirth);
		try {
			new PdfAdapter().execute(actual);
			
			assertEquals(expectName, actual.getName());
			assertEquals(expectBirth, actual.getBirthday());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] dp() throws ParseException {
		return new Object[][] { new Object[] { "１２３４５６７８９０", "１２３４５６７８９０切られる部分", "1968年10月14日", "19681014" }, };
	}
	
	@BeforeTest
	public void beforeTest() {
	}
	
	@AfterTest
	public void afterTest() {
	}
}
