/**
 * Project: CMETPortal
 */
package com.huateng.common;


/**
 * <p><strong>
 * Description:</strong> 应答码
 * </p>
 * <p><strong>
 * Copyright:</strong>&copy2009 Huateng
 * </p>
 * <p><strong>
 * Company:</strong>上海华腾软件系统有限公司
 * </p>
 * @author Roger.li
 * @version 1.0
 */
public class Rescode {
    /** 默认错误.*/
    public static final String DEFAULT_RESCODE = "9999";
    /** 表单不能重复提交.*/
    public static final String RES_1000 = "1000";
    /** 会话超时，请重新登录.*/
    public static final String RES_1001 = "1001";
    /** 终端数量与终端起止序号不符合.*/
    public static final String RES_2001 = "2001";
    /** 厂商或终端类型不符合.*/
    public static final String RES_2002 = "2002";
    /** 终端信息不存在.*/
    public static final String RES_2003 = "2003";
    /** 终端库存状态不正确.*/
    public static final String RES_2004 = "2004";
    /** 调拨状态不正确.*/
    public static final String RES_2005 = "2005";
    /** 不能出库不属于本机构的终端.*/
    public static final String RES_2006 = "2006";
    /** 终端信息已存在.*/
    public static final String RES_2007 = "2007";
    /** 只有未注册并且绑定商户的终端才能进行注册.*/
    public static final String RES_2008 = "2008";
    /** 该终端已经和商户绑定，不能再进行绑定.*/
    public static final String RES_2009 = "2009";
    /** 终端开通前必须先注册并初始化，已开通的终端不能重复开通.*/
    public static final String RES_2010 = "2010";
    /** 只有已开通或未签到或正在工作状态中的终端才能冻结.*/
    public static final String RES_2011 = "2011";
    /** 只有冻结中的终端才能解冻.*/
    public static final String RES_2012 = "2012";
    /** 终端报修前必须先冻结.*/
    public static final String RES_2013 = "2013";
    /** 只有报修中的终端才能返还.*/
    public static final String RES_2014 = "2014";
    /** 终端挂失前必须先冻结.*/
    public static final String RES_2015 = "2015";
    /** 只有挂失中的终端才能解挂失.*/
    public static final String RES_2016 = "2016";
    /** 终端报废前必须先冻结.*/
    public static final String RES_2017 = "2017";
    /** 终端注销前必须先冻结.*/
    public static final String RES_2018 = "2018";
    /** 起止终端号类型不一致.*/
    public static final String RES_2019 = "2019";
    /** 操作成功.*/
    public static final String RES_SUCCESS = "0000";
    /** 操作失败.*/
    public static final String RES_FAILURE = "9999";
    
    /** 系统参数前缀.*/
    public static final String SYS_PARAM_PREFIX = "SP";
    /** com.huateng.util.SysPrmUnit :: getParamValueTxNoDef param_id no existed. */
    public final static String SYSPRMUNIT_GETPARAM_NODEF_NO_PARAM_ID = SYS_PARAM_PREFIX + "01";
    /** com.huateng.util.SysPrmUnit :: getParamValueTxNoDef magic_id no existed. */
    public final static String SYSPRMUNIT_GETPARAM_NODEF_NO_MAGIC_ID = SYS_PARAM_PREFIX + "02";
    /** com.huateng.util.SysPrmUnit :: getParamValueTx magic_id no existed. */
    public final static String SYSPRMUNIT_GETPARAM_NO_MAGIC_ID = SYS_PARAM_PREFIX + "03";
    /** com.huateng.util.SysPrmUnit :: getParamValueTx param_id no existed. */
    public final static String SYSPRMUNIT_GETPARAM_NO_PARAM_ID = SYS_PARAM_PREFIX + "04";

    /** XmlDB */
    public final static String XMLDB_PREFIX = "XD";
    /** as.huateng.startup.XmlDBUnit::initMeta error. */
    public final static String XMLDBUTIL_INIT_META_FILE_NOEXISTS= XMLDB_PREFIX + "01";
    /** as.huateng.startup.XmlDBUnit::initMeta error. */
    public final static String XMLDBUTIL_INIT_META_PARSE_TABLE_ID_ERROR= XMLDB_PREFIX + "02";
    /** as.huateng.startup.XmlDBUnit::initMeta error. */
    public final static String XMLDBUTIL_INIT_META_PARSE_TABLE_PATH_ERROR= XMLDB_PREFIX + "03";
    /** as.huateng.startup.XmlDBUnit::initMeta error. */
    public final static String XMLDBUTIL_INIT_META_PARSE_FILE_ERROR= XMLDB_PREFIX + "04";
    /** as.huateng.startup.XmlDBUnit::initMeta error. */
    public final static String XMLDBUTIL_INIT_CONFIG_FILE_NOEXISTS= XMLDB_PREFIX + "05";
    /** com.huateng.util.XmlDBParser::parseSysDic error. */
    public final static String XMLDBUTIL_INIT_CONFIG_FILE_FIELD_NOEXISTS= XMLDB_PREFIX + "06";
    /** com.huateng.util.XmlDBParser::writeSysDic error. */
    public final static String XMLDBUTIL_WRITE_XMLDB_ERROR= XMLDB_PREFIX + "07";
    /** com.huateng.util.XmlDBParser::readXmlDBList error. */
    public final static String XMLDBUTIL_READ_XMLDB_ERROR= XMLDB_PREFIX + "08";

    /** 页面配置模块错误码前缀. */
    public final static String FM_PREFIX = "FM";
    /** as.huateng.freemarker.method.FreeMarkerConfiguration :: getConfigVal Class Not Found error. */
    public final static String FM_CONFIG_GET_VAL_NO_CLASS = FM_PREFIX + "01";
    /** as.huateng.freemarker.method.FreeMarkerConfiguration :: getConfigVal Key Not Found error. */
    public final static String FM_CONFIG_GET_VAL_KEY_NO_FOUND = FM_PREFIX + "02";
    /** as.huateng.freemarker.method.FreeMarkerConfiguration :: getConfigVal New Class Error error. */
    public final static String FM_CONFIG_GET_VAL_NEW_INSTANCE_ERROR = FM_PREFIX + "03";
    /** as.huateng.servlet.ASFreemarkerServlet :: initConfiguration Config SetSharedVariable Error. */
    public final static String FM_SERVLET_INIT_CONFIG_SETSV_ERROR = FM_PREFIX + "04";

    /** Common Query Error Code. */
    /** Common Query Error Prefix. */
    public static final String CQ_PREFIX = "CQ";
    /** com.huateng.commquery.config.bean.base.CommonQueryBean getField not found field. */
    public static final String COMMONQUERYBEAN_FIELD_NOT_FOUND = CQ_PREFIX + "01";
    /** com.huateng.commquery.config.bean.base.CommonQueryBean getWhereElement not found element. */
    public static final String COMMONQUERYBEAN_ELEMENT_NOT_FOUND = CQ_PREFIX + "02";
    /** com.huateng.commquery.config.CommonQueryUtil  initMeta config file not exist. */
    public static final String COMMONQUERYUTIL_INIT_META_FILE_NOEXISTS = CQ_PREFIX + "03";
    /** com.huateng.commquery.config.CommonQueryUtil  initMeta parse config file error. */
    public static final String COMMONQUERYUTIL_INIT_META_PARSE_FILE_ERROR = CQ_PREFIX + "04";
    /** com.huateng.commquery.config.CommonQueryUtil  initMeta parse file Element: Query id error. */
    public static final String COMMONQUERYUTIL_INIT_META_PARSE_QUERY_ID_ERROR = CQ_PREFIX + "05";
    /** com.huateng.commquery.config.CommonQueryUtil  initMeta parse file Element: Query path error. */
    public static final String COMMONQUERYUTIL_INIT_META_PARSE_QUERY_PATH_ERROR = CQ_PREFIX + "06";
    /** com.huateng.commquery.config.CommonQueryUtil  initConfFile error. */
    public static final String COMMONQUERYUTIL_INIT_CONFIG_FILE_ERROR = CQ_PREFIX + "07";
    /** com.huateng.commquery.config.CommonQueryUtil  initConfFile config file not exist. */
    public static final String COMMONQUERYUTIL_INIT_CONFIG_FILE_NOEXISTS = CQ_PREFIX + "08";
    /** com.huateng.commquery.config.parser.CommonQueryParser.parse CommQry/@title error. */
    public static final String COMMONQUERYPARSER_PARSE_COMMQRY_TITLE_ERROR = CQ_PREFIX + "09";
    /** com.huateng.commquery.config.parser.CommonQueryParser.parse CommQry//DataAccessObjects error. */
    public static final String COMMONQUERYPARSER_PARSE_COMMQRY_PARAM_DAO_ERROR = CQ_PREFIX + "10";
    /** com.huateng.commquery.config.parser.CommonQueryParser.parse  error. */
    public static final String COMMONQUERYPARSER_PARSE_ERROR = CQ_PREFIX + "11";
    /** com.huateng.commquery.config.parser.CommonQueryParser.parseDataAccessObjects  error. */
    public static final String COMMONQUERYPARSER_PARSE_DAO_ERROR = CQ_PREFIX + "12";
    /** com.huateng.commquery.config.parser.CommonQueryParser.parseViewAdapter error. */
    public static final String COMMONQUERYPARSER_PARSE_VIEW_ADAPTER_ERROR = CQ_PREFIX + "13";
    /** com.huateng.commquery.config.parser.CommonQueryParser.parseViewAdapter CommQry//ViewApater error. */
    public static final String COMMONQUERYPARSER_PARSE_COMMQRY_PARAM_VIEW_ADAPTER_ERROR = CQ_PREFIX + "14";
    /** com.huateng.commquery.config.parser.CommonQueryParser.parseInterfaceViewParam error. */
    public static final String COMMONQUERYPARSER_PARSE_INTERFACE_VIEW_PARAM_ERROR = CQ_PREFIX + "15";
    /** com.huateng.commquery.config.parser.CommonQueryParser.parseInterfaceViewParam CommQry//InterfaceViewParam error. */
    public static final String COMMONQUERYPARSER_PARSE_COMMQRY_PARAM_INTERFACE_VIEW_PARAM_ERROR = CQ_PREFIX + "16";
    /** com.huateng.commquery.config.parser.CommonQueryParser.parseResultViewParam error. */
    public static final String COMMONQUERYPARSER_PARSE_RESULT_VIEW_PARAM_ERROR = CQ_PREFIX + "17";
    /** com.huateng.commquery.config.parser.CommonQueryParser.parseResultViewParam CommQry//ResultViewParam error. */
    public static final String COMMONQUERYPARSER_PARSE_COMMQRY_PARAM_RESULT_VIEW_PARAM_ERROR = CQ_PREFIX + "18";
    /** com.huateng.commquery.config.parser.CommonQueryParser.parseFields CommQry//Fields error. */
    public static final String COMMONQUERYPARSER_PARSE_COMMQRY_PARAM_FIELDS_ERROR = CQ_PREFIX + "19";
    /** com.huateng.commquery.config.parser.CommonQueryParser.parseFields error. */
    public static final String COMMONQUERYPARSER_PARSE_FIELDS_ERROR = CQ_PREFIX + "20";
    /** com.huateng.commquery.config.parser.CommonQueryParser.parseWhere error. */
    public static final String COMMONQUERYPARSER_PARSE_WHERE_ERROR = CQ_PREFIX + "21";
    /** com.huateng.commquery.config.bean.base.CommonQueryBean getWhereElementParser not found whereElementParser. */
    public static final String COMMONQUERYBEAN_WEP_NOT_FOUND = CQ_PREFIX + "22";
    /** com.huateng.commquery.config.parser.CommonQueryParser.parseWhereElementParser error. */
    public static final String COMMONQUERYPARSER_PARSE_WHERE_ELEMENT_PARSER_PARAM_ERROR = CQ_PREFIX + "23";
    /** com.huateng.commquery.config.parser.CommonQueryParser.parseWhereElementParser Param attribute error. */
    public static final String COMMONQUERYPARSER_PARAM_ATTRIBUTE_ERROR = CQ_PREFIX + "24";
    /** com.huateng.commquery.config.parser.CommonQueryParser.parseWhere element parser class not found. */
    public static final String COMMONQUERYPARSER_PARSERWhERE_ELEMENTPARSER_CLASS_NOT_FOUND = CQ_PREFIX + "25";
    /** com.huateng.commquery.config.parser.CommonQueryParser.parseWhere error. */
    public static final String COMMONQUERYPARSER_PARSERWHERE_ERROR = CQ_PREFIX + "26";
    /** com.huateng.commquery.config.parser.CommonQueryParser.parseSQL Sql error. */
    public static final String COMMONQUERYPARSER_PARSE_COMMQRY_PARAM_SQL_ERROR = CQ_PREFIX + "27";
    /** com.huateng.commquery.config.parser.CommonQueryParser.parseSQL error. */
    public static final String COMMONQUERYPARSER_PARSE_SQL_ERROR = CQ_PREFIX + "28";
    /** com.huateng.commquery.config.getCommonQueryBean bean not found error. */
    public static final String COMMONQUERYUTIL_GETCOMMONQUERYBEAN_NOTEXIST_ERROR = CQ_PREFIX + "29";
    /** com.huateng.commquery.config.bean.getOption not found error. */
    public static final String OPTIONELEMENT_GETOPTION_NULL_ERROR = CQ_PREFIX + "30";
    /** com.huateng.commquery.config.bean.getOption Value/@value or Value/@name error. */
    public static final String OPTIONELEMENT_GETOPTION_VALUE_PARAM_ERROR = CQ_PREFIX + "31";
    /** com.huateng.commquery.config.adapter.FreemarkerViewAdapter genInterfaceView error. */
    public static final String FREEMARKER_ADAPTER_GENINTERFACEVIEW_ERROR = CQ_PREFIX + "32";
    /** com.huateng.commquery.config.adapter.FreemarkerViewAdapter genInterfaceView Template File No Exist. */
    public static final String FREEMARKER_ADAPTER_GENINTERFACEVIEW_TEMPLATE_FILE_NOEXIST = CQ_PREFIX + "33";
    /** com.huateng.commquery.config.adapter.FreemarkerViewAdapter genInterfaceView template generator page fail. */
    public static final String FREEMARKER_ADAPTER_GENINTERFACEVIEW_TEMPLATE_GEN_PAGE_ERROR = CQ_PREFIX + "34";
    /** com.huateng.commquery.process.base._InterfaceViewProcess process ViewAdapter Class Not Found. */
    public static final String INTERFACEVIEWPPROCESS_PROCESS_VIEWADAPTER_CLASS_NOT_FOUND = CQ_PREFIX + "35";
    /** com.huateng.commquery.process.base._InterfaceViewProcess process fail. */
    public static final String INTERFACEVIEWPPROCESS_PROCESS_ERROR = CQ_PREFIX + "36";
    /** com.huateng.commquery.config.bean.base._CommonQueryBean putField  the id of field is null. */
    public static final String COMMONQUERYBEAN_PUTFIELD_ID_NULL = CQ_PREFIX + "37";
    /** com.huateng.commquery.config.bean.base._CommonQueryBean putWhereElement the id of where element is null. */
    public static final String COMMONQUERYBEAN_PUTWHEREELEMENT_ID_NULL = CQ_PREFIX + "38";
    /** com.huateng.commquery.config.bean.base._CommonQueryBean putWhereElementParser id or class is null. */
    public static final String COMMONQUERYBEAN_PUTWHEREELEMENTPARSER_ID_OR_CLASS_NULL = CQ_PREFIX + "39";
    /** com.huateng.commquery.config.bean.base._CommonQueryBean putOperationsParserMap id or class is null. */
    public static final String COMMONQUERYBEAN_PUTOPERATIONSPARSERMAP_ID_OR_CLASS_NULL = CQ_PREFIX + "40";
    /** com.huateng.commquery.config.bean.base._CommonQueryBean getOperationsParserMap not found. */
    public static final String COMMONQUERYBEAN_GETOPERATIONSPARSERMAP_NOT_FOUND = CQ_PREFIX + "41";
    /** com.huateng.commquery.config.bean.base._CommonQueryBean getOperationsElement not found. */
    public static final String COMMONQUERYBEAN_GETOPERATIONELEMENT_NOT_FOUND = CQ_PREFIX + "42";
    /** com.huateng.commquery.config.bean.base._CommonQueryBean putOperationsElement not found. */
    public static final String COMMONQUERYBEAN_PUTOPERATIONSELEMENT_ID_NULL = CQ_PREFIX + "43";
    /** com.huateng.commquery.config.parser.CommonQueryParser.parseOperationsParser Param attribute error. */
    public static final String COMMONQUERYPARSER_OPERATIONS_PARAM_ATTRIBUTE_ERROR = CQ_PREFIX + "44";
    /** com.huateng.commquery.config.parser.CommonQueryParser.parseOperationsParser error. */
    public static final String COMMONQUERYPARSER_PARSEOPERATIONSPARSER_ERROR = CQ_PREFIX + "45";
    /** com.huateng.commquery.config.parser.CommonQueryParser.parseOperations error. */
    public static final String COMMONQUERYPARSER_PARSE_OPERATIONS_ERROR = CQ_PREFIX + "46";
    /** com.huateng.commquery.config.parser.CommonQueryParser.parseOperations element parser class not found. */
    public static final String COMMONQUERYPARSER_PARSEOPERATIONS_ELEMENTPARSER_CLASS_NOT_FOUND = CQ_PREFIX + "47";
    /** com.huateng.commquery.config.parser.CommonQueryParser.parseSQL Sql Struct error. */
    public static final String COMMONQUERYPARSER_PARSE_COMMQRY_PARAM_SQL_STRUCT_ERROR = CQ_PREFIX + "48";
    /** com.huateng.commquery.process.base._ResultViewProcess process fail. */
    public static final String RESULTVIEWPROCESS_PROCESS_ERROR = CQ_PREFIX + "49";
    /** com.huateng.commquery.process.base._ResultViewProcess process ViewAdapter Class Not Found. */
    public static final String RESULTVIEWPROCESS_PROCESS_VIEWADAPTER_CLASS_NOT_FOUND = CQ_PREFIX + "50";
    /** com.huateng.commquery.process.base._ResultViewProcess genSQL error. */
    public static final String RESULTVIEWPROCESS_GENSQL_ERROR = CQ_PREFIX + "51";
    /** com.huateng.commquery.config.bean.base._CommonQueryBean getOrderElement not found. */
    public static final String COMMONQUERYBEAN_GETORDERELEMENT_NOT_FOUND = CQ_PREFIX + "52";
    /** com.huateng.commquery.config.bean.base._CommonQueryBean putOrderElement not found. */
    public static final String COMMONQUERYBEAN_PUTORDERELEMENT_ID_NULL = CQ_PREFIX + "53";
    /** com.huateng.commquery.config.bean.base._CommonQueryBean getGroupElement not found. */
    public static final String COMMONQUERYBEAN_GETGROUPELEMENT_NOT_FOUND = CQ_PREFIX + "54";
    /** com.huateng.commquery.config.bean.base._CommonQueryBean putGroupElement not found. */
    public static final String COMMONQUERYBEAN_PUTGROUPELEMENT_ID_NULL = CQ_PREFIX + "55";
    /** com.huateng.commquery.config.bean.base._CommonQueryBean addElementList param index error. */
    public static final String COMMONQUERYBEAN_ADDELEMENTLIST_INDEX_ERROR = CQ_PREFIX + "56";
    /** com.huateng.commquery.config.bean.base._CommonQueryBean removeElementList entity no existed. */
    public static final String COMMONQUERYBEAN_REMOVEELEMENTLIST_ENTITY_NOEXIST = CQ_PREFIX + "57";
    /** com.huateng.commquery.config.parser.CommonQueryParser.parseOrder error. */
    public static final String COMMONQUERYPARSER_PARSE_ORDER_ERROR = CQ_PREFIX + "58";
    /** com.huateng.commquery.config.parser.CommonQueryParser.parseOrder element parser class not found. */
    public static final String COMMONQUERYPARSER_PARSERORDER_ELEMENTPARSER_CLASS_NOT_FOUND = CQ_PREFIX + "59";
    /** com.huateng.commquery.config.parser.CommonQueryParser.parseOrder error. */
    public static final String COMMONQUERYPARSER_PARSERORDER_ERROR = CQ_PREFIX + "60";
    /** com.huateng.commquery.config.parser.CommonQueryParser.parseGroup error. */
    public static final String COMMONQUERYPARSER_PARSE_GROUP_ERROR = CQ_PREFIX + "61";
    /** com.huateng.commquery.config.parser.CommonQueryParser.parseGroup element parser class not found. */
    public static final String COMMONQUERYPARSER_PARSERGROUP_ELEMENTPARSER_CLASS_NOT_FOUND = CQ_PREFIX + "62";
    /** com.huateng.commquery.config.parser.CommonQueryParser.parseGroup error. */
    public static final String COMMONQUERYPARSER_PARSERGROUP_ERROR = CQ_PREFIX + "63";
    /** com.huateng.commquery.config.gensql.GenSqlElementOperation :: genWhereElement error. */
    public static final String GENSQLELEMENTOPERATION_GENWHEREELEMENT_ERROR = CQ_PREFIX + "64";
    /** com.huateng.commquery.result.RowData::getField no existed error. */
    public static final String ROWDATA_GETFILED_NO_EXISTED = CQ_PREFIX + "65";
    /** com.huateng.commquery.result.Result::getRow no existed error. */
    public static final String RESULT_GETROW_NO_EXIST = CQ_PREFIX + "66";
    /** com.huateng.commquery.config.adapter.FreemarkerViewAdapter genResultView Template File No Exist. */
    public static final String FREEMARKER_ADAPTER_GENRESULTVIEW_TEMPLATE_FILE_NOEXIST = CQ_PREFIX + "67";
    /** com.huateng.commquery.config.adapter.FreemarkerViewAdapter genResultView template generator page fail. */
    public static final String FREEMARKER_ADAPTER_GENRESULTVIEW_TEMPLATE_GEN_PAGE_ERROR = CQ_PREFIX + "68";
    /** com.huateng.commquery.config.adapter.FreemarkerViewAdapter genResultView error. */
    public static final String FREEMARKER_ADAPTER_GENRESULTVIEW_ERROR = CQ_PREFIX + "69";
    /** com.huateng.commquery.process.FieldValueProcess::processMT error. */
    public static final String FIELDVALUEPROCESS_PRCESSMT_ERROR = CQ_PREFIX + "70";
    /** com.huateng.commquery.config.parser.CommonQueryParser.parseEmptyResultViewParam CommQry//EmptyResultViewParam error. */
    public static final String COMMONQUERYPARSER_PARSE_COMMQRY_PARAM_EMPTY_RESULT_VIEW_PARAM_ERROR = CQ_PREFIX + "71";
    /** com.huateng.commquery.config.parser.CommonQueryParser.parseEmptyResultViewParam error. */
    public static final String COMMONQUERYPARSER_PARSE_EMPTY_RESULT_VIEW_PARAM_ERROR = CQ_PREFIX + "72";
    /** com.huateng.commquery.config.adapter.FreemarkerViewAdapter genEmptyResultView Template File No Exist. */
    public static final String FREEMARKER_ADAPTER_GENEMPTYRESULTVIEW_TEMPLATE_FILE_NOEXIST = CQ_PREFIX + "73";
    /** com.huateng.commquery.config.adapter.FreemarkerViewAdapter genEmptyResultView template generator page fail. */
    public static final String FREEMARKER_ADAPTER_GENEMPTYRESULTVIEW_TEMPLATE_GEN_PAGE_ERROR = CQ_PREFIX + "74";
    /** com.huateng.commquery.config.adapter.FreemarkerViewAdapter genEmptyResultView error. */
    public static final String FREEMARKER_ADAPTER_GENEMPTYRESULTVIEW_ERROR = CQ_PREFIX + "75";
    /** com.huateng.commquery.config.CommonQueryUtil  initIncludeMeta parse file Element: Include id error. */
    public static final String COMMONQUERYUTIL_INIT_INCLUDE_META_PARSE_INCLUDE_ID_ERROR = CQ_PREFIX + "76";
    /** com.huateng.commquery.config.CommonQueryUtil  initIncludeMeta parse file Element: Include path error. */
    public static final String COMMONQUERYUTIL_INIT_INCLUDE_META_PARSE_INCLUDE_PATH_ERROR = CQ_PREFIX + "77";
    /** com.huateng.commquery.config.bean.base._CommonQueryIncludeBean putOperationsParserMap id or class is null. */
    public static final String COMMONQUERYINCLUDEBEAN_PUTOPERATIONSPARSERMAP_ID_OR_CLASS_NULL = CQ_PREFIX + "78";
    /** com.huateng.commquery.config.parser.CommonQueryIncludeParser.parse  error. */
    public static final String COMMONQUERYINCLUDEPARSER_PARSE_ERROR = CQ_PREFIX + "79";
    /** com.huateng.commquery.config.parser.CommonQueryIncludeParser.parseDataAccessObjects  error. */
    public static final String COMMONQUERYINCLUDEPARSER_PARSE_DAO_ERROR = CQ_PREFIX + "80";
    /** com.huateng.commquery.config.parser.CommonQueryIncludeParser.parseViewAdapter ConfigParam//ViewApater error. */
    public static final String COMMONQUERYINCLUDEPARSER_PARSE_COMMQRY_PARAM_VIEW_ADAPTER_ERROR = CQ_PREFIX + "81";
    /** com.huateng.commquery.config.parser.CommonQueryIncludeParser.parseViewAdapter error. */
    public static final String COMMONQUERYINCLUDEPARSER_PARSE_VIEW_ADAPTER_ERROR = CQ_PREFIX + "82";
    /** com.huateng.commquery.config.parser.CommonQueryIncludeParser.parseInterfaceViewParam ConfigParam//InterfaceViewParam error. */
    public static final String COMMONQUERYINCLUDEPARSER_PARSE_COMMQRY_PARAM_INTERFACE_VIEW_PARAM_ERROR = CQ_PREFIX + "83";
    /** com.huateng.commquery.config.parser.CommonQueryIncludeParser.parseInterfaceViewParam error. */
    public static final String COMMONQUERYINCLUDEPARSER_PARSE_INTERFACE_VIEW_PARAM_ERROR = CQ_PREFIX + "84";
    /** com.huateng.commquery.config.parser.CommonQueryIncludeParser.parseResultViewParam ConfigParam//ResultViewParam error. */
    public static final String COMMONQUERYINCLUDEPARSER_PARSE_COMMQRY_PARAM_RESULT_VIEW_PARAM_ERROR = CQ_PREFIX + "85";
    /** com.huateng.commquery.config.parser.CommonQueryIncludeParser.parseResultViewParam error. */
    public static final String COMMONQUERYINCLUDEPARSER_PARSE_RESULT_VIEW_PARAM_ERROR = CQ_PREFIX + "86";
    /** com.huateng.commquery.config.parser.CommonQueryIncludeParser.parseEmptyResultViewParam ConfigParam//EmptyResultViewParam error. */
    public static final String COMMONQUERYINCLUDEPARSER_PARSE_COMMQRY_PARAM_EMPTY_RESULT_VIEW_PARAM_ERROR = CQ_PREFIX + "71";
    /** com.huateng.commquery.config.parser.CommonQueryIncludeParser.parseEmptyResultViewParam error. */
    public static final String COMMONQUERYINCLUDEPARSER_PARSE_EMPTY_RESULT_VIEW_PARAM_ERROR = CQ_PREFIX + "88";
    /** com.huateng.commquery.config.parser.CommonQueryIncludeParser.parseWhereElementParser Param attribute error. */
    public static final String COMMONQUERYINCLUDEPARSER_PARAM_ATTRIBUTE_ERROR = CQ_PREFIX + "89";
    /** com.huateng.commquery.config.parser.CommonQueryIncludeParser.parseWhereElementParser error. */
    public static final String COMMONQUERYINCLUDEPARSER_PARSE_WHERE_ELEMENT_PARSER_PARAM_ERROR = CQ_PREFIX + "90";
    /** com.huateng.commquery.config.parser.CommonQueryIncludeParser.parseOperationsParser Param attribute error. */
    public static final String COMMONQUERYINCLUDEPARSER_OPERATIONS_PARAM_ATTRIBUTE_ERROR = CQ_PREFIX + "91";
    /** com.huateng.commquery.config.parser.CommonQueryIncludeParser.parseOperationsParser error. */
    public static final String COMMONQUERYINCLUDEPARSER_PARSEOPERATIONSPARSER_ERROR = CQ_PREFIX + "92";
    /** com.huateng.commquery.config.CommonQueryUtil  initIncludeFile include file not exist. */
    public static final String COMMONQUERYUTIL_INIT_INCLUDE_FILE_NOEXISTS = CQ_PREFIX + "93";
    /** com.huateng.commquery.config.CommonQueryUtil  initIncludeFile parse include file error. */
    public static final String COMMONQUERYUTIL_INIT_INCLUDE_FILE_ERROR = CQ_PREFIX + "94";
    /** com.huateng.commquery.config.getCommonQueryIncludeBean bean not found error. */
    public static final String COMMONQUERYUTIL_GETCOMMONQUERYINCLUDEBEAN_NOTEXIST_ERROR = CQ_PREFIX + "95";
    /** com.huateng.commquery.config.parser.CommonQueryParser.parseInclude: id is null. */
    public static final String COMMONQUERYPARSER_PARSE_INCLUDE_ID_NULL = CQ_PREFIX + "96";
    /** com.huateng.commquery.config.parser.CommonQueryParser.checkConfig: DataAccessObjects is null or empty. */
    public static final String COMMONQUERYPARSER_CHECK_DATAACCESSOBJECTS_ERROR = CQ_PREFIX + "97";
    /** com.huateng.commquery.config.parser.CommonQueryParser.checkConfig: ViewAdapter is null or empty. */
    public static final String COMMONQUERYPARSER_CHECK_VIEWADAPTER_ERROR = CQ_PREFIX + "98";
    /** com.huateng.commquery.config.parser.CommonQueryParser.checkConfig: InterfaceViewParam is null or empty. */
    public static final String COMMONQUERYPARSER_CHECK_INTERFACEVIEWPARAM_ERROR = CQ_PREFIX + "99";
    /** com.huateng.commquery.config.parser.CommonQueryParser.checkConfig: ResultViewParam is null or empty. */
    public static final String COMMONQUERYPARSER_CHECK_RESULTVIEWPARAM_ERROR = CQ_PREFIX + "A0";
    /** com.huateng.commquery.config.parser.CommonQueryParser.checkConfig: EmptyResultViewParam is null or empty. */
    public static final String COMMONQUERYPARSER_CHECK_EMPTYRESULTVIEWPARAM_ERROR = CQ_PREFIX + "A1";
    /** com.huateng.commquery.config.parser.CommonQueryIncludeParser.parse ConfigParam//DataAccessObjects error. */
    public static final String COMMONQUERYINCLUDEPARSER_PARSE_CONFIGPARAM_PARAM_DAO_ERROR = CQ_PREFIX + "A2";
    /** com.huateng.commquery.config.parser.CommonQueryParser.parseScript SCRIPT error. */
    public static final String COMMONQUERYPARSER_PARSE_COMMQRY_PARAM_SCRIPT_ERROR = CQ_PREFIX + "A3";
    /** com.huateng.commquery.config.parser.CommonQueryParser.parseScript error. */
    public static final String COMMONQUERYPARSER_PARSE_SCRIPT_ERROR = CQ_PREFIX + "A4";
    /** com.huateng.commquery.config.parser.CommonQueryParser.parseRedundancy error. */
    public static final String COMMONQUERYPARSER_PARSE_REDUNDANCY_ERROR = CQ_PREFIX + "A5";
    /** com.huateng.commquery.config.parser.CommonQueryParser.parseRedundancy element parser class not found. */
    public static final String COMMONQUERYPARSER_PARSERREDUNDANCY_ELEMENTPARSER_CLASS_NOT_FOUND = CQ_PREFIX + "A6";
    /** com.huateng.commquery.config.parser.CommonQueryParser.parseRedundancy error. */
    public static final String COMMONQUERYPARSER_PARSERREDUNDANCY_ERROR = CQ_PREFIX + "A7";
    /** com.huateng.commquery.config.parser.CommonQueryParser.parseOperations error. */
    public static final String COMMONQUERYPARSER_PARSEROPERATIONS_ERROR = CQ_PREFIX + "A8";

    /** SQL Error Prefix. */
    public static final String SQL_PREFIX = "SQ";
    /** com.huateng.sql.HTSQLFactory :: fillSqlEntity sql statement miss select of from error. */
    public static final String HTSQLFACTORY_FILLSQLENTITY_PARAM_SELECT_OR_FROM_ERROR = SQL_PREFIX + "01";
    /** com.huateng.sql.parser.SelectParser :: parse fail. */
    public static final String SELECTPARSER_PARSE_FAIL = SQL_PREFIX + "02";
    /** com.huateng.sql.parser.SQLParser :: parse fail. */
    public static final String SQLPARSER_PARSE_FAIL = SQL_PREFIX + "03";
    /** com.huateng.sql.parser.WhereParser :: parse fail. */
    public static final String WHEREPARSER_PARSE_FAIL = SQL_PREFIX + "04";
    /** com.huateng.sql.parser.FromParser :: parse fail. */
    public static final String FROMPARSER_PARSE_FAIL = SQL_PREFIX + "05";
    /** com.huateng.sql.parser.OrderParser :: parse fail. */
    public static final String ORDERPARSER_PARSE_FAIL = SQL_PREFIX + "06";
    /** com.huateng.sql.parser.GroupParser :: parse fail. */
    public static final String GROUPPARSER_PARSE_FAIL = SQL_PREFIX + "07";
    /** 系统异常 */
    public static final String SE_PREFIX = "SE";
    /** 指定路径的buffer域未找到 */
    public static final String BUFFER_FILED_NOT_FOUND = SE_PREFIX + "03";    
    /*** 当前会话失效    */
    public static final String OPR_0111 = "请登录";
    /*** 不能通过URL直接操作     */
    public static final String OPR_0112 = "请重新登录";
}
