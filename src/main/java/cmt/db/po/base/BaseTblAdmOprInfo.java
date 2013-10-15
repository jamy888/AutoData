package cmt.db.po.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the TBL_ADM_OPR_INFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="TBL_ADM_OPR_INFO"
 */

public abstract class BaseTblAdmOprInfo  implements Serializable {

	public static String REF = "TblAdmOprInfo";
	public static String PROP_SUB_KEY_CD3 = "SubKeyCd3";
	public static String PROP_BRH_ID = "BrhId";
	public static String PROP_LAST_UPD_TS = "LastUpdTs";
	public static String PROP_OPR_NM = "OprNm";
	public static String PROP_OPR_ID = "OprId";
	public static String PROP_LAST_UPD_TXN_ID = "LastUpdTxnId";
	public static String PROP_OPR_PWD = "OprPwd";
	public static String PROP_MISC_TX = "MiscTx";
	public static String PROP_SUB_KEY_CD2 = "SubKeyCd2";
	public static String PROP_BRH_CONT = "BrhCont";
	public static String PROP_OPR_LEVEL = "OprLevel";
	public static String PROP_OPR_CONT_TELNO = "OprContTelno";
	public static String PROP_OPR_END_DT = "OprEndDt";
	public static String PROP_OPR_TYPE = "OprType";
	public static String PROP_BRH_NAME = "BrhName";
	public static String PROP_OPR_STAT = "OprStat";
	public static String PROP_SUB_KEY_CD1 = "SubKeyCd1";
	public static String PROP_OPR_CARD_ID = "OprCardId";
	public static String PROP_OPR_START_DT = "OprStartDt";
	public static String PROP_LAST_UPD_OPR_ID = "LastUpdOprId";
	public static String PROP_ROLE_ID = "RoleId";


	// constructors
	public BaseTblAdmOprInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTblAdmOprInfo (java.lang.String oprId) {
		this.setOprId(oprId);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTblAdmOprInfo (
		java.lang.String oprId,
		java.lang.String oprType,
		java.lang.String roleId,
		java.lang.String oprNm,
		java.lang.String oprPwd,
		java.lang.String oprCardId,
		java.lang.String brhId,
		java.lang.String brhName,
		java.lang.String oprStat,
		java.lang.String oprLevel,
		java.lang.String oprContTelno,
		java.lang.String brhCont,
		java.lang.String oprStartDt,
		java.lang.String oprEndDt,
		java.lang.String lastUpdOprId,
		java.lang.String lastUpdTxnId,
		java.lang.String lastUpdTs) {

		this.setOprId(oprId);
		this.setOprType(oprType);
		this.setRoleId(roleId);
		this.setOprNm(oprNm);
		this.setOprPwd(oprPwd);
		this.setOprCardId(oprCardId);
		this.setBrhId(brhId);
		this.setBrhName(brhName);
		this.setOprStat(oprStat);
		this.setOprLevel(oprLevel);
		this.setOprContTelno(oprContTelno);
		this.setBrhCont(brhCont);
		this.setOprStartDt(oprStartDt);
		this.setOprEndDt(oprEndDt);
		this.setLastUpdOprId(lastUpdOprId);
		this.setLastUpdTxnId(lastUpdTxnId);
		this.setLastUpdTs(lastUpdTs);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String oprId;

	// fields
	private java.lang.String oprType;
	private java.lang.String roleId;
	private java.lang.String oprNm;
	private java.lang.String oprPwd;
	private java.lang.String oprCardId;
	private java.lang.String brhId;
	private java.lang.String brhName;
	private java.lang.String oprStat;
	private java.lang.String oprLevel;
	private java.lang.String oprContTelno;
	private java.lang.String brhCont;
	private java.lang.String oprStartDt;
	private java.lang.String oprEndDt;
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
     *  column="OPR_ID"
     */
	public java.lang.String getOprId () {
		return oprId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param oprId the new ID
	 */
	public void setOprId (java.lang.String oprId) {
		this.oprId = oprId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: OPR_TYPE
	 */
	public java.lang.String getOprType () {
		return oprType;
	}

	/**
	 * Set the value related to the column: OPR_TYPE
	 * @param oprType the OPR_TYPE value
	 */
	public void setOprType (java.lang.String oprType) {
		this.oprType = oprType;
	}



	/**
	 * Return the value associated with the column: ROLE_ID
	 */
	public java.lang.String getRoleId () {
		return roleId;
	}

	/**
	 * Set the value related to the column: ROLE_ID
	 * @param roleId the ROLE_ID value
	 */
	public void setRoleId (java.lang.String roleId) {
		this.roleId = roleId;
	}



	/**
	 * Return the value associated with the column: OPR_NM
	 */
	public java.lang.String getOprNm () {
		return oprNm;
	}

	/**
	 * Set the value related to the column: OPR_NM
	 * @param oprNm the OPR_NM value
	 */
	public void setOprNm (java.lang.String oprNm) {
		this.oprNm = oprNm;
	}



	/**
	 * Return the value associated with the column: OPR_PWD
	 */
	public java.lang.String getOprPwd () {
		return oprPwd;
	}

	/**
	 * Set the value related to the column: OPR_PWD
	 * @param oprPwd the OPR_PWD value
	 */
	public void setOprPwd (java.lang.String oprPwd) {
		this.oprPwd = oprPwd;
	}



	/**
	 * Return the value associated with the column: OPR_CARD_ID
	 */
	public java.lang.String getOprCardId () {
		return oprCardId;
	}

	/**
	 * Set the value related to the column: OPR_CARD_ID
	 * @param oprCardId the OPR_CARD_ID value
	 */
	public void setOprCardId (java.lang.String oprCardId) {
		this.oprCardId = oprCardId;
	}



	/**
	 * Return the value associated with the column: BRH_ID
	 */
	public java.lang.String getBrhId () {
		return brhId;
	}

	/**
	 * Set the value related to the column: BRH_ID
	 * @param brhId the BRH_ID value
	 */
	public void setBrhId (java.lang.String brhId) {
		this.brhId = brhId;
	}



	/**
	 * Return the value associated with the column: BRH_NAME
	 */
	public java.lang.String getBrhName () {
		return brhName;
	}

	/**
	 * Set the value related to the column: BRH_NAME
	 * @param brhName the BRH_NAME value
	 */
	public void setBrhName (java.lang.String brhName) {
		this.brhName = brhName;
	}



	/**
	 * Return the value associated with the column: OPR_STAT
	 */
	public java.lang.String getOprStat () {
		return oprStat;
	}

	/**
	 * Set the value related to the column: OPR_STAT
	 * @param oprStat the OPR_STAT value
	 */
	public void setOprStat (java.lang.String oprStat) {
		this.oprStat = oprStat;
	}



	/**
	 * Return the value associated with the column: OPR_LEVEL
	 */
	public java.lang.String getOprLevel () {
		return oprLevel;
	}

	/**
	 * Set the value related to the column: OPR_LEVEL
	 * @param oprLevel the OPR_LEVEL value
	 */
	public void setOprLevel (java.lang.String oprLevel) {
		this.oprLevel = oprLevel;
	}



	/**
	 * Return the value associated with the column: OPR_CONT_TELNO
	 */
	public java.lang.String getOprContTelno () {
		return oprContTelno;
	}

	/**
	 * Set the value related to the column: OPR_CONT_TELNO
	 * @param oprContTelno the OPR_CONT_TELNO value
	 */
	public void setOprContTelno (java.lang.String oprContTelno) {
		this.oprContTelno = oprContTelno;
	}



	/**
	 * Return the value associated with the column: BRH_CONT
	 */
	public java.lang.String getBrhCont () {
		return brhCont;
	}

	/**
	 * Set the value related to the column: BRH_CONT
	 * @param brhCont the BRH_CONT value
	 */
	public void setBrhCont (java.lang.String brhCont) {
		this.brhCont = brhCont;
	}



	/**
	 * Return the value associated with the column: OPR_START_DT
	 */
	public java.lang.String getOprStartDt () {
		return oprStartDt;
	}

	/**
	 * Set the value related to the column: OPR_START_DT
	 * @param oprStartDt the OPR_START_DT value
	 */
	public void setOprStartDt (java.lang.String oprStartDt) {
		this.oprStartDt = oprStartDt;
	}



	/**
	 * Return the value associated with the column: OPR_END_DT
	 */
	public java.lang.String getOprEndDt () {
		return oprEndDt;
	}

	/**
	 * Set the value related to the column: OPR_END_DT
	 * @param oprEndDt the OPR_END_DT value
	 */
	public void setOprEndDt (java.lang.String oprEndDt) {
		this.oprEndDt = oprEndDt;
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
		if (!(obj instanceof cmt.db.po.TblAdmOprInfo)) return false;
		else {
			cmt.db.po.TblAdmOprInfo tblAdmOprInfo = (cmt.db.po.TblAdmOprInfo) obj;
			if (null == this.getOprId() || null == tblAdmOprInfo.getOprId()) return false;
			else return (this.getOprId().equals(tblAdmOprInfo.getOprId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getOprId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getOprId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}