/**
 * 
 */
package jp.example.samplesystem.dataproc.common;

import java.lang.reflect.Field;

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
	 */
	public void execute(AbstractBean bean) throws IllegalArgumentException, IllegalAccessException {
		// フィールドの取得
		// privateフィールドを取得するのでgetDeclaredFieldを使う
		Field[] fields = bean.getClass().getDeclaredFields();
		
		for (Field field : fields) {
			// privateフィールドにアクセスできるようにする
			field.setAccessible(true);
			// アノテーションの取得
			DataFormat format = field.getAnnotation(DataFormat.class);
			// アノテーションを読み取って処理する
			if (format.delEnd()) {
				String string = (String)field.get(bean);
				string = string == null?"" : string.length() > format.maxLen()?string.substring(0, format.maxLen()) : string;
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
