/**
 * 
 */
package jp.example.samplesystem.dataproc.common;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * データ加工の親クラス
 * 
 * @author M.H
 *
 */
public abstract class AbstractProc {
	/**
	 * データを加工して出力処理に渡す
	 * 
	 * @param bean データオブジェクト
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws ParseException 
	 */
	public void execute(AbstractBean bean) throws IllegalArgumentException, IllegalAccessException, ParseException {
		// フィールドの取得
		// privateフィールドを取得するのでgetDeclaredFieldを使う
		Field[] fields = bean.getClass().getDeclaredFields();
		
		for (Field field : fields) {
			// privateフィールドにアクセスできるようにする
			field.setAccessible(true);
			// アノテーションの取得
			DataFormat format = field.getAnnotation(DataFormat.class);
			// アノテーションを読み取って処理する
			String string = (String)field.get(bean);
			// 末尾を切り捨てる処理
			if (format.delEnd()) {
				string = string == null?"" : string.length() > format.maxLen()?string.substring(0, format.maxLen()) : string;
				field.set(bean, string);
			}

			// 日付書式を変換する処理
			if (!"".equals(format.dateFormat())) {
				string = new SimpleDateFormat(format.dateFormat()).format(new SimpleDateFormat("yyyyMMdd").parse(string));
				field.set(bean, string);
			}
		}
		
		// 出力処理
		output(bean);
	}

	/**
	 * 出力用抽象メソッド
	 * @param bean 加工後のデータ
	 */
	protected abstract void output(AbstractBean bean);
}
