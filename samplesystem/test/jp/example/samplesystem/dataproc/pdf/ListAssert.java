/**
 * 
 */
package jp.example.samplesystem.dataproc.pdf;

import java.util.List;

import org.testng.AssertJUnit;

/**
 * リストを比較する
 * @author M.H
 *
 */
public class ListAssert extends AssertJUnit {
	public static <T> void assertEquals(String message, List<T>expect, List<T>actual) {
		// リストの内容を比較する
		for (int i=0; i<expect.size(); i++) {
			assertEquals(message+"row=["+i+"]", expect.get(i), actual.get(i));
		}
	}
}
