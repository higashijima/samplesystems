package jp.example.samplesystem.dataproc.common;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
/**
 * データの書式を設定するアノテーション
 * @author M.H
 *
 */
public @interface DataFormat {
	/** 文字列の最大長 */
	int maxLen() default 0;
	/** 最大長を超えた場合に末尾を削除する */
	boolean delEnd() default false;
}
