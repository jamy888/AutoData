package cmt.db.po;

import cmt.db.po.base.BaseTblAdmOprInfo;



public class TblAdmOprInfo extends BaseTblAdmOprInfo {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public TblAdmOprInfo () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TblAdmOprInfo (java.lang.String oprId) {
		super(oprId);
	}

	/**
	 * Constructor for required fields
	 */
	public TblAdmOprInfo (
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

		super (
			oprId,
			oprType,
			roleId,
			oprNm,
			oprPwd,
			oprCardId,
			brhId,
			brhName,
			oprStat,
			oprLevel,
			oprContTelno,
			brhCont,
			oprStartDt,
			oprEndDt,
			lastUpdOprId,
			lastUpdTxnId,
			lastUpdTs);
	}

/*[CONSTRUCTOR MARKER END]*/


}