package cmt.db.po.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the TBL_ADM_TXN_INFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="TBL_ADM_TXN_INFO"
 */

public abstract class BaseTblAdmTxnInfo  implements Serializable {

	public static String REF = "TblAdmTxnInfo";
	public static String PROP_SUB_KEY_CD3 = "SubKeyCd3";
	public static String PROP_TXN_ID = "TxnId";
	public static String PROP_LAST_UPD_TS = "LastUpdTs";
	public static String PROP_LAST_UPD_TXN_ID = "LastUpdTxnId";
	public static String PROP_TXN_DESC = "TxnDesc";
	public static String PROP_TXN_NM = "TxnNm";
	public static String PROP_MISC_TX = "MiscTx";
	public static String PROP_SUB_KEY_CD2 = "SubKeyCd2";
	public static String PROP_SUB_KEY_CD1 = "SubKeyCd1";
	public static String PROP_LAST_UPD_OPR_ID = "LastUpdOprId";


	// constructors
	public BaseTblAdmTxnInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTblAdmTxnInfo (java.lang.String txnId) {
		this.setTxnId(txnId);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTblAdmTxnInfo (
		java.lang.String txnId,
		java.lang.String txnNm,
		java.lang.String txnDesc,
		java.lang.String lastUpdOprId,
		java.lang.String lastUpdTxnId,
		java.lang.String lastUpdTs) {

		this.setTxnId(txnId);
		this.setTxnNm(txnNm);
		this.setTxnDesc(txnDesc);
		this.setLastUpdOprId(lastUpdOprId);
		this.setLastUpdTxnId(lastUpdTxnId);
		this.setLastUpdTs(lastUpdTs);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String txnId;

	// fields
	private java.lang.String txnNm;
	private java.lang.String txnDesc;
	private java.lang.String subKeyCd1;
	private java.lang.String subKeyCd2;
	private java.lang.String subKeyCd3;
	private java.lang.String miscTx;
	private java.lang.String lastUpdOprId;
	private java.lang.String lastUpdTxnId;
	private java.lang.String lastUpdTs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="TXN_ID"
     */
	public java.lang.String getTxnId () {
		return txnId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param txnId the new ID
	 */
	public void setTxnId (java.lang.String txnId) {
		this.txnId = txnId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: TXN_NM
	 */
	public java.lang.String getTxnNm () {
		return txnNm;
	}

	/**
	 * Set the value related to the column: TXN_NM
	 * @param txnNm the TXN_NM value
	 */
	public void setTxnNm (java.lang.String txnNm) {
		this.txnNm = txnNm;
	}



	/**
	 * Return the value associated with the column: TXN_DESC
	 */
	public java.lang.String getTxnDesc () {
		return txnDesc;
	}

	/**
	 * Set the value related to the column: TXN_DESC
	 * @param txnDesc the TXN_DESC value
	 */
	public void setTxnDesc (java.lang.String txnDesc) {
		this.txnDesc = txnDesc;
	}



	/**
	 * Return the value associated with the column: SUB_KEY_CD1
	 */
	public java.lang.String getSubKeyCd1 () {
		return subKeyCd1;
	}

	/**
	 * Set the value related to the column: SUB_KEY_CD1
	 * @param subKeyCd1 the SUB_KEY_CD1 value
	 */
	public void setSubKeyCd1 (java.lang.String subKeyCd1) {
		this.subKeyCd1 = subKeyCd1;
	}



	/**
	 * Return the value associated with the column: SUB_KEY_CD2
	 */
	public java.lang.String getSubKeyCd2 () {
		return subKeyCd2;
	}

	/**
	 * Set the value related to the column: SUB_KEY_CD2
	 * @param subKeyCd2 the SUB_KEY_CD2 value
	 */
	public void setSubKeyCd2 (java.lang.String subKeyCd2) {
		this.subKeyCd2 = subKeyCd2;
	}



	/**
	 * Return the value associated with the column: SUB_KEY_CD3
	 */
	public java.lang.String getSubKeyCd3 () {
		return subKeyCd3;
	}

	/**
	 * Set the value related to the column: SUB_KEY_CD3
	 * @param subKeyCd3 the SUB_KEY_CD3 value
	 */
	public void setSubKeyCd3 (java.lang.String subKeyCd3) {
		this.subKeyCd3 = subKeyCd3;
	}



	/**
	 * Return the value associated with the column: MISC_TX
	 */
	public java.lang.String getMiscTx () {
		return miscTx;
	}

	/**
	 * Set the value related to the column: MISC_TX
	 * @param miscTx the MISC_TX value
	 */
	public void setMiscTx (java.lang.String miscTx) {
		this.miscTx = miscTx;
	}



	/**
	 * Return the value associated with the column: LAST_UPD_OPR_ID
	 */
	public java.lang.String getLastUpdOprId () {
		return lastUpdOprId;
	}

	/**
	 * Set the value related to the column: LAST_UPD_OPR_ID
	 * @param lastUpdOprId the LAST_UPD_OPR_ID value
	 */
	public void setLastUpdOprId (java.lang.String lastUpdOprId) {
		this.lastUpdOprId = lastUpdOprId;
	}



	/**
	 * Return the value associated with the column: LAST_UPD_TXN_ID
	 */
	public java.lang.String getLastUpdTxnId () {
		return lastUpdTxnId;
	}

	/**
	 * Set the value related to the column: LAST_UPD_TXN_ID
	 * @param lastUpdTxnId the LAST_UPD_TXN_ID value
	 */
	public void setLastUpdTxnId (java.lang.String lastUpdTxnId) {
		this.lastUpdTxnId = lastUpdTxnId;
	}



	/**
	 * Return the value associated with the column: LAST_UPD_TS
	 */
	public java.lang.String getLastUpdTs () {
		return lastUpdTs;
	}

	/**
	 * Set the value related to the column: LAST_UPD_TS
	 * @param lastUpdTs the LAST_UPD_TS value
	 */
	public void setLastUpdTs (java.lang.String lastUpdTs) {
		this.lastUpdTs = lastUpdTs;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cmt.db.po.TblAdmTxnInfo)) return false;
		else {
			cmt.db.po.TblAdmTxnInfo tblAdmTxnInfo = (cmt.db.po.TblAdmTxnInfo) obj;
			if (null == this.getTxnId() || null == tblAdmTxnInfo.getTxnId()) return false;
			else return (this.getTxnId().equals(tblAdmTxnInfo.getTxnId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getTxnId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getTxnId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}