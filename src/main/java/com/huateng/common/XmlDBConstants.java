package com.huateng.common;

/**
 * Title: xmlDB常量定义
 *
 * Description:
 *
 * Copyright: Copyright (c) 2006
 *
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 *
 * @author robertbao
 *
 * @version 1.0, 2007-1-09
 */
public class XmlDBConstants{

	//xmlDBMeta.xml文件路径
    public static final String XMLDB_LOCATION="xmlDBLocation";

    //xmlDB表
    public static final String SYS_DIC_FILE="/WEB-INF/xmlDB/SysDic.xml";
    public static final String PRM_DEF_FILE="/WEB-INF/xmlDB/PrmDef.xml";
    public static final String SYS_PRM_FILE="/WEB-INF/xmlDB/SysPrm.xml";

	public final static String META_ROOT = "META";
	public final static String META_TABLE = "Table";
    public final static String META_TABLE_ID = "id";
    public final static String META_TABLE_PATH = "path";


    public final static String TABLE_ROOT = "results";
    public final static String TABLE_ROW = "row";

    public final static String EDITABLE = "AS00";
    public final static String READONLY = "AS01";
    public final static String CHANGEABLE = "AS02";


    //SysDic表
    public final static String SYS_DIC__LENTH = "7";
    public final static String SYS_DIC_TBL_NM = "TBL_NM";
    public final static String SYS_DIC_FLD_NM = "FLD_NM";
    public final static String SYS_DIC_FLD_VAL = "FLD_VAL";
    public final static String SYS_DIC_FLD_DESC = "FLD_DESC";
    public final static String SYS_DIC_LAST_UPD_OPR_ID = "LAST_UPD_OPR_ID";
    public final static String SYS_DIC_LAST_UPD_TXN_ID = "LAST_UPD_TXN_ID";
    public final static String SYS_DIC_LAST_UPD_TS = "LAST_UPD_TS";

    //SysPrm表
    public final static String SYS_PRM_LENTH = "6";
    public final static String SYS_PRM_PARAM_ID = "PARAM_ID";
    public final static String SYS_PRM_MAGIC_ID = "MAGIC_ID";
    public final static String SYS_PRM_PARAM_VALUE_TX = "PARAM_VALUE_TX";
    public final static String SYS_PRM_LAST_UPD_OPR_ID = "LAST_UPD_OPR_ID";
    public final static String SYS_PRM_LAST_UPD_TXN_ID = "LAST_UPD_TXN_ID";
    public final static String SYS_PRM_LAST_UPD_TS = "LAST_UPD_TS";

    //PrmDef表
    public final static String PRM_DEF_LENTH = "10";
    public final static String PRM_DEF_PARAM_ID = "PARAM_ID";
    public final static String PRM_DEF_PARAM_NM = "PARAM_NM";
    public final static String PRM_DEF_PARAM_CLASS_CD = "PARAM_CLASS_CD";
    public final static String PRM_DEF_PARAM_TYPE_CD = "PARAM_TYPE_CD";
    public final static String PRM_DEF_DEFAULT_VAL_TX = "DEFAULT_VAL_TX";
    public final static String PRM_DEF_PARAM_DESC_TX = "PARAM_DESC_TX";
    public final static String PRM_DEF_FRACTION_QT = "FRACTION_QT";
    public final static String PRM_DEF_LAST_UPD_OPR_ID = "LAST_UPD_OPR_ID";
    public final static String PRM_DEF_LAST_UPD_TXN_ID = "LAST_UPD_TXN_ID";
    public final static String PRM_DEF_LAST_UPD_TS = "LAST_UPD_TS";

}
