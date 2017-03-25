package jp.example.samplesystem.dataproc.pdf;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
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
	/**
	 * 正常系テスト
	 * 
	 * @param expectName 氏名の期待値
	 * @param actualName 氏名の設定値
	 * @param expectBirth 生年月日の期待値
	 * @param actualBirth 生年月日の設定値
	 */
	@Test(dataProvider = "dp")
	public void testPdf(String expectName, String actualName, String expectBirth, String actualBirth) {
		PdfData actual = new PdfData();
		actual.setName(actualName);
		actual.setBirthday(actualBirth);
		try {
			new PdfAdapter().execute(actual);
			
			AssertJUnit.assertEquals(expectName, actual.getName());
			AssertJUnit.assertEquals(expectBirth, actual.getBirthday());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	
	/**
	 * 異常系テスト
	 * 
	 * <pre>
	 * アノテーションなしのフィールドのデータで実行する
	 * データは正常系と同じデータでExceptionが出ることをテスト
	 * </pre>
	 * 
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws ParseException
	 */
	@Test(expectedExceptions = { NullPointerException.class }, dataProvider = "dp")
	public void testException(String expectName, String actualName, String expectBirth, String actualBirth)
			throws IllegalArgumentException, IllegalAccessException, ParseException {
		PdfExceptionData actual = new PdfExceptionData();
		actual.setName(actualName);
		actual.setBirthday(actualBirth);
		
		new PdfAdapter().execute(actual);
	}
	
	@DataProvider
	public Object[][] dp() throws ParseException {
		return new Object[][] { new Object[] { "１２３４５６７８９０", "１２３４５６７８９０切られる部分", "1968年10月14日", "19681014" },
				new Object[] { "１２３４５６７８９０", "１２３４５６７８９０切られる部分", "1968年02月29日", "19680229" }, new Object[] { "１２３４５６７８９０", "１２３４５６７８９０切られる部分", "1969年03月01日", "19690301" }, };
	}
	
	@BeforeTest
	public void beforeTest() {
	}
	
	@AfterTest
	public void afterTest() {
	}
}
