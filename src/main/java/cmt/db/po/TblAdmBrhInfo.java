package cmt.db.po;

import cmt.db.po.base.BaseTblAdmBrhInfo;



public class TblAdmBrhInfo extends BaseTblAdmBrhInfo {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public TblAdmBrhInfo () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TblAdmBrhInfo (java.lang.String brhId) {
		super(brhId);
	}

	/**
	 * Constructor for required fields
	 */
	public TblAdmBrhInfo (
		java.lang.String brhId,
		java.lang.String brhNm,
		java.lang.String brhNms,
		java.lang.String brhStat,
		java.lang.String brhLevel,
		java.lang.String supBrhId,
		java.lang.String stlFlag,
		java.lang.String stlBankId,
		java.lang.String stlBankAccId,
		java.lang.String brhAddr,
		java.lang.String postCd,
		java.lang.String brhCont,
		java.lang.String telNo,
		java.lang.String locNo,
		java.lang.String brhValidDt,
		java.lang.String brhEndDt,
		java.lang.String modFlg,
		java.lang.String synFlg,
		java.lang.String lastUpdOprId,
		java.lang.String lastUpdTxnId,
		java.lang.String lastUpdTs) {

		super (
			brhId,
			brhNm,
			brhNms,
			brhStat,
			brhLevel,
			supBrhId,
			stlFlag,
			stlBankId,
			stlBankAccId,
			brhAddr,
			postCd,
			brhCont,
			telNo,
			locNo,
			brhValidDt,
			brhEndDt,
			modFlg,
			synFlg,
			lastUpdOprId,
			lastUpdTxnId,
			lastUpdTs);
	}

/*[CONSTRUCTOR MARKER END]*/


}