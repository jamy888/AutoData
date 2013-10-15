package cmt.db.po.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the TBL_ADM_ROLE_INFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="TBL_ADM_ROLE_INFO"
 */

public abstract class BaseTblAdmRoleInfo  implements Serializable {

	public static String REF = "TblAdmRoleInfo";
	public static String PROP_SUB_KEY_CD3 = "SubKeyCd3";
	public static String PROP_ROLE_DESC = "RoleDesc";
	public static String PROP_LAST_UPD_TS = "LastUpdTs";
	public static String PROP_LAST_UPD_TXN_ID = "LastUpdTxnId";
	public static String PROP_MISC_TX = "MiscTx";
	public static String PROP_SUB_KEY_CD2 = "SubKeyCd2";
	public static String PROP_SUB_KEY_CD1 = "SubKeyCd1";
	public static String PROP_ROLE_NM = "RoleNm";
	public static String PROP_ROLE_ID = "RoleId";
	public static String PROP_LAST_UPD_OPR_ID = "LastUpdOprId";


	// constructors
	public BaseTblAdmRoleInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTblAdmRoleInfo (java.lang.String roleId) {
		this.setRoleId(roleId);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTblAdmRoleInfo (
		java.lang.String roleId,
		java.lang.String roleNm,
		java.lang.String roleDesc,
		java.lang.String lastUpdOprId,
		java.lang.String lastUpdTxnId,
		java.lang.String lastUpdTs) {

		this.setRoleId(roleId);
		this.setRoleNm(roleNm);
		this.setRoleDesc(roleDesc);
		this.setLastUpdOprId(lastUpdOprId);
		this.setLastUpdTxnId(lastUpdTxnId);
		this.setLastUpdTs(lastUpdTs);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String roleId;

	// fields
	private java.lang.String roleNm;
	private java.lang.String roleDesc;
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
     *  column="ROLE_ID"
     */
	public java.lang.String getRoleId () {
		return roleId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param roleId the new ID
	 */
	public void setRoleId (java.lang.String roleId) {
		this.roleId = roleId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: ROLE_NM
	 */
	public java.lang.String getRoleNm () {
		return roleNm;
	}

	/**
	 * Set the value related to the column: ROLE_NM
	 * @param roleNm the ROLE_NM value
	 */
	public void setRoleNm (java.lang.String roleNm) {
		this.roleNm = roleNm;
	}



	/**
	 * Return the value associated with the column: ROLE_DESC
	 */
	public java.lang.String getRoleDesc () {
		return roleDesc;
	}

	/**
	 * Set the value related to the column: ROLE_DESC
	 * @param roleDesc the ROLE_DESC value
	 */
	public void setRoleDesc (java.lang.String roleDesc) {
		this.roleDesc = roleDesc;
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
		if (!(obj instanceof cmt.db.po.TblAdmRoleInfo)) return false;
		else {
			cmt.db.po.TblAdmRoleInfo tblAdmRoleInfo = (cmt.db.po.TblAdmRoleInfo) obj;
			if (null == this.getRoleId() || null == tblAdmRoleInfo.getRoleId()) return false;
			else return (this.getRoleId().equals(tblAdmRoleInfo.getRoleId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getRoleId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getRoleId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}