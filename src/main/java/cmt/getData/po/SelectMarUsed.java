package cmt.getData.po;

import java.io.Serializable;

public class SelectMarUsed implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4227077438309105815L;
	private String MOBILE_NO;
	private String ACCOUNT_DT;
	private String SUMUSE_AMT;
	public String getMOBILE_NO() {
		return MOBILE_NO;
	}
	public void setMOBILE_NO(String mOBILE_NO) {
		MOBILE_NO = mOBILE_NO;
	}
	public String getACCOUNT_DT() {
		return ACCOUNT_DT;
	}
	public void setACCOUNT_DT(String aCCOUNT_DT) {
		ACCOUNT_DT = aCCOUNT_DT;
	}
	public String getSUMUSE_AMT() {
		return SUMUSE_AMT;
	}
	public void setSUMUSE_AMT(String sUMUSE_AMT) {
		SUMUSE_AMT = sUMUSE_AMT;
	}
}
