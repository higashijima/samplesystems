package jp.example.samplesystem.dataproc.pdf;

import jp.example.samplesystem.dataproc.common.AbstractBean;
import jp.example.samplesystem.dataproc.common.DataFormat;

/**
 * @author M.H
 *
 */
public class PdfData extends AbstractBean {
	/** 氏名 */
	@DataFormat(maxLen=10, delEnd=true)
	private String name;

	/** 生年月日 */
	@DataFormat(dateFormat="yyyy年MM月dd日")
	private String birthday;

	/**
	 * 氏名のgetter
	 * @return name 氏名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 生年月日のgetter
	 * @return birthday 生年月日
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * 氏名のsetter
	 * @param name 氏名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 生年月日のsetter
	 * @param birthday 生年月日
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
}
