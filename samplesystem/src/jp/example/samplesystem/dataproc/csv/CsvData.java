/**
 * 
 */
package jp.example.samplesystem.dataproc.csv;

import jp.example.samplesystem.dataproc.common.AbstractBean;
import jp.example.samplesystem.dataproc.common.DataFormat;

/**
 * @author M.H
 *
 */
public class CsvData extends AbstractBean {
	/** 名前 */
	@DataFormat(maxLen=10, delEnd=true)
	private String name;
	/** 住所 */
	@DataFormat(maxLen=15, delEnd=true)
	private String address;
}
