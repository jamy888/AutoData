/**
 * Project: CMETMonitor
 */
package com.huateng.common;




/**
 * <p><strong>
 * Description:</strong>
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
public class ComCons {

    public static String rootPath = null;

    public static final String SLASH = "/";
    /** member variabel: space. */
    public static final String SPACE = " ";
    /** memeber variable: point. */
    public final static String POINT = ".";
    /** memeber variable: colon. */
    public final static String COLON = "|";
    /** memeber variable: number zero. */
    public static final int NZERO = 0;
    /** memeber varibale: star. */
    public static final String STAR = "*";
    /** memeber variable: blank. */
    public static final String BLANK = "";
    /** memeber variable: comma. */
    public final static String COMMA = ",";
    /** memeber variable: JSON. */
    public final static String JSON = ".json";
    /** memeber variable: String ZERO. */
    public static final String ZERO = "0";
    /** memeber variable: string false. */
    public static final String FALSE_STRING = "false";
    /** memeber variable: equal mark. */
    public static final String EQUAL = "=";
    /** memeber variable: operation ne. */
    public static final String NE = "!=";
    /** memeber variable: operation le. */
    public static final String LE = "<=";
    /** memeber variable: operation ge. */
    public static final String GE = ">=";
    /** memeber variable: operation lt. */
    public static final String LT = "<";
    /** memeber variable: operation gt. */
    public static final String GT = ">";

    public static final String TCP_FORMAT = "format";

    public static final String BUF_VALUE = "value";

    public static final String CONTEXT_PATH = "contextPath";

    public static final String RESOURCE_PATH = "resourcePath";

    public static final String SYSTEM_STRAT_UP_LOG = "SystemStartup";

    public static final String XML_DB = "XmlDB";

    public static final String XMLDB_LOCATION="xmlDBLocation";

    public static final String LOGDIR = "LogDir";

    public static final String LOGFILE = "LogFile";
    /** param_id = AS02(ƽ̨�����(��д)). */
    public final static String PARAM_ID_AS02 = "AS02";
    /** param_id = AS02 magic_id = 0012(��־�ļ�Ŀ¼��ȫ·����). */
    public final static String MAGIC_ID_AS02_0012 = "0012";
    /** memeber variable: number six. */
    public static final int NUM_SIX = 6;
    /** memeber variable: string true. */
    public static final String TRUE_STRING = "true";

    public static final String STATICS = "statics";

    public static final String TRANCE_INFO_PREFEX = "********************";

    public static final String TRANCE_INFO_TAIL = "********************";

    public static String traceInfo(String info){
        return TRANCE_INFO_PREFEX + info + TRANCE_INFO_TAIL;
    }
    
    /** 签到状态: 0-未签到 **/
    public static final String OPR_LOG_STA_0 = "0";

    /**
     * 登录session标识
     */
    public static final String USER_SESSION_INFO = "userSessionInfo";

    /**
     * 操作员登录状态
     */
    public static final String OPR_LOGIN_STATUS = "OPR_LOGIN_STATUS";

    /**
     * 操作员签到
     */
    public static final String OPR_STATUS_ON = "1";

    /**
     * 操作员签退
     */
    public static final String OPR_STATUS_OFF = "0";
    
    /** 报表服务中的指定分隔符 . */
    public static final String REPORT_SEPARATOR = "/";
    /** 报表服务中的报表类型 */
    public static final String REPORT_RPTMODE = "rptMode";
    public static final String REPORT_PDFMODE = "rptpdf";
    public static final String REPORT_RTFMODE = "rptrtf";
    public static final String REPORT_EXCELMODE = "rptexcel";
    public static final String REPORT_HTMLMODE = "rpthtml";
    public static final String REPORT_TXTMODE = "rpttext";
    public static final String REPORT_XMLMODE = "rptxml";
    public static final String PDF_MARK = "p";
    public static final String EXCEL_MARK = "e";
    public static final String HTML_MARK = "h";
    public static final String XML_MARK = "x";
    /** 通用标志: 0-否 **/
    public static final String FLG_N = "0";
    /** 通用标志: 1-是 **/
    public static final String FLG_Y = "1";
    /** 终端库存状态:00-库存(机构);01-在途(机构);02-出库(商户) */
    public static final String TERM_STO_STA_00 = "00";
    public static final String TERM_STO_STA_01 = "01";
    public static final String TERM_STO_STA_02 = "02";
    /** 终端使用状态:99-未注册;00-已注册;01-已初始化;02-已开通;03-已注销;04-未签到;05-正常工作状态;06-已锁定;07-已冻结;08-强制签到; */
    public static final String TERM_AP_STA_99 = "99";
    public static final String TERM_AP_STA_00 = "00";
    public static final String TERM_AP_STA_01 = "01";
    public static final String TERM_AP_STA_02 = "02";
    public static final String TERM_AP_STA_03 = "03";
    public static final String TERM_AP_STA_04 = "04";
    public static final String TERM_AP_STA_05 = "05";
    public static final String TERM_AP_STA_06 = "06";
    public static final String TERM_AP_STA_07 = "07";
    public static final String TERM_AP_STA_08 = "08";
    /** 修改标志:0-新增，1-删除，2-修改 */
    public static final String TERM_MOD_FLG_0 = "0";
    public static final String TERM_MOD_FLG_1 = "1";
    public static final String TERM_MOD_FLG_2 = "2";
    /** 同步标志:0-已同步;1-未同步 */
    public static final String TERM_SYN_FLG_0 = "0";
    public static final String TERM_SYN_FLG_1 = "1";
    /** 调拨类型:00-采购入库;01-出库在途(机构之间);02-出库使用(机构到商户);03-撤销(商户到机构) */
    public static final String STO_TP_00 = "00";
    public static final String STO_TP_01 = "01";
    public static final String STO_TP_02 = "02";
    public static final String STO_TP_03 = "03";
    /** 调拨状态:00-已发出待接收;01-已接收 */
    public static final String STO_STA_00 = "00";
    public static final String STO_STA_01 = "01";
}
