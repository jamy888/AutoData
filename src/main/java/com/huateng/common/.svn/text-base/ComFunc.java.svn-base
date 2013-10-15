/**
 * Project: CMPOSPConsole
 */
package com.huateng.common;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import sun.net.TelnetOutputStream;

import com.huateng.exception.ComException;
import com.huateng.query.dao.ICommQueryDAO;
import com.huateng.util.ContextUtil;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * <p>
 * <strong> Description:</strong> 公用方法集
 * </p>
 * <p>
 * <strong> Copyright:</strong>&copy2009 Huateng
 * </p>
 * <p>
 * <strong> Company:</strong>上海华腾软件系统有限公司
 * </p>
 *
 * @author Roger.li
 * @version 1.0
 */
public class ComFunc {

    private static ICommQueryDAO dao = null;

    private static SimpleDateFormat datefmt = new SimpleDateFormat("yyyyMMdd");
    
    private static SimpleDateFormat datefmtShow = new SimpleDateFormat("yyyy-MM-dd");

    private static SimpleDateFormat timefmtChinese = new SimpleDateFormat("HH'时'mm'分'ss'秒'");

    private static SimpleDateFormat time6fmt = new SimpleDateFormat("HHmmss");
    
    private static SimpleDateFormat time6fmtShow = new SimpleDateFormat("HH:mm:ss");

    private static SimpleDateFormat datefmtChinese = new SimpleDateFormat("yyyy'年'MM'月'dd'日'");
    
	/** 大写数字 */
	private static final String[] NUMBERS = { "零", "壹", "贰", "叁", "肆", "伍", "陆",
	"柒", "捌", "玖" };
	/** 整数部分的单位 */
	private static final String[] IUNIT = { "元", "拾", "佰", "仟", "万", "拾", "佰",
	"仟", "亿", "拾", "佰", "仟", "万", "拾", "佰", "仟" };
	/** 小数部分的单位 */
	private static final String[] DUNIT = { "角", "分", "厘" };
    
    private static SimpleDateFormat dateTime14Fmt = new SimpleDateFormat(
            "yyyyMMddHHmmss");

    public static ICommQueryDAO getDao() throws ComException {
        if (dao == null) {
            dao = (ICommQueryDAO) ContextUtil.getBean("commQueryDAO");
        }
        return dao;
    }

    public static String getLocalDate() {
        return datefmt.format(Calendar.getInstance().getTime());
    }

    public static String getLocalDateTime14() {
        return dateTime14Fmt.format(Calendar.getInstance().getTime());
    }

    public static String convToDataTime14(Calendar cal) {
        return dateTime14Fmt.format(cal.getTime());
    }
    
    

    /**
     * 获取当月的最后一天
     * @throws ParseException 
     */
    public static String getLastDayOfMonth(String yearMonth) throws ParseException{
    	Calendar cal = Calendar.getInstance(); 
    	cal.setTime(datefmt.parse(yearMonth+"01")); 
    	int value = cal.getActualMaximum(Calendar.DAY_OF_MONTH); 
    	cal.set(Calendar.DAY_OF_MONTH, value); 
    	return datefmt.format(cal.getTime());
    }
    
    /**
     * 字符串填充函数
     *
     * @param string
     * @param filler
     * @param totalLength
     * @param atEnd
     * @return
     */
    public static String fillString(String string, char filler,
            int totalLength, boolean atEnd) {
        byte[] tempbyte = (string == null ? "" : string).getBytes();
        int currentLength = tempbyte.length;
        int delta = totalLength - currentLength;
        for (int i = 0; i < delta; i++) {
            if (atEnd) {
                string += filler;
            } else {
                string = filler + string;
            }
        }
        return string;
    }

    /**
     * 传递request中的参数到下一页面
     *
     * @param request
     */
    @SuppressWarnings("unchecked")
    public static void passRequestParams(HttpServletRequest request) {
        Map params = request.getParameterMap();
        if (params == null || params.isEmpty()) {
            return;
        }

        Iterator it = params.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            request.setAttribute(key, request.getParameter(key));
        }
    }

    /**
     * 检查是否是数字
     *
     * @param Value
     * @return
     */
    public static boolean isNumeric(String Value) {
        String tmpValue = Value.trim();
        int i = 0, PointCount = 0;
        char OneByte = tmpValue.charAt(0);
        if (OneByte == '-') {
            i = 1;
        }
        for (; i < tmpValue.length(); i++) {
            if (OneByte == '.') {
                PointCount = PointCount + 1;
                if (PointCount > 1) {
                    return false;
                }
            }
            else if ((OneByte > '9' || OneByte < '0')) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查字符串为空或者长度为零
     *
     * @param string
     * @return
     */
    public static boolean stringNullEmpty(String string) {
        if (string == null || string.length() == 0) {
            return true;
        }
        return false;
    }
    /**
     * 转换字符串为指定小数格式
     *
     * @param i
     * @param format
     * @param n
     * @return
     * @throws HuatengException
     */
    public static String TxnAtFormat(String i, String format, int n)
            throws ComException {
        if (!isNumeric(i)) {
            throw new ComException("非数字:" + i);
        }
        double txn = Double.parseDouble(i);
        txn = txn * Math.pow(10, n);
        DecimalFormat formatter = new DecimalFormat(format);
        return formatter.format(txn);
    }
    
    public static SimpleDateFormat datefmtShow(){
    	return datefmtShow;
    }

    public static SimpleDateFormat datefmtChinese(){
        return datefmtChinese;
    }

    public static SimpleDateFormat getDatefmt(){
        return datefmt;
    }

    public static SimpleDateFormat timefmtChinese(){
        return timefmtChinese;
    }

    public static SimpleDateFormat getTime6fmt(){
        return time6fmt;
    }
    
    public static SimpleDateFormat getTime6fmtShow(){
    	return time6fmtShow;
    }
    
    /**
     * 将元转换成分
     * @param disAmt
     * @return
     */
    public static String fmtDisAmtToDBAmt(String disAmt){
        if (disAmt == null || disAmt.trim().equals("")) {
            return "-";
        }
        BigDecimal disAmtStr = new BigDecimal(disAmt);
        disAmtStr = disAmtStr.movePointRight(2);
        return disAmtStr.toString();
    }
    
    /**
     * 将分转换成元
     * @param dbAmt
     * @return
     */
    public static String fmtDBAmtToDisAmt(String dbAmt){
        if (dbAmt == null || dbAmt.trim().equals("") || dbAmt.trim().equals("-")) {
            return "-";
        }
        BigDecimal DdbAmtStr = new BigDecimal(dbAmt);
        DdbAmtStr = DdbAmtStr.movePointLeft(2);
        return DdbAmtStr.toString();
    }
    
    public static String formatDate(String dateOrTime)throws ComException{
    	String result = null;
    	int length = dateOrTime.length();
		if (length == 8) {
			try {
				result = ComFunc.datefmtShow().format(
						(ComFunc.getDatefmt().parse(dateOrTime)));
			} catch (ParseException e) {
				throw new ComException("日期格式化出错");
			}
		} else if (length == 6) {
			try {
				result = ComFunc.getTime6fmtShow().format(
						(ComFunc.getTime6fmt().parse(dateOrTime)));
			} catch (ParseException e) {
				throw new ComException("时间格式化出错");
			}

		} else if(length == 14){
		    try {
                result = ComFunc.datefmtShow().format((ComFunc.getDatefmt().parse(dateOrTime.substring(0, 8))))+" "
                        +ComFunc.getTime6fmtShow().format(ComFunc.getTime6fmt().parse(dateOrTime.substring(8)));
            } catch (ParseException e) {
                throw new ComException("日期时间格式化出错");
            }
		} else{
			result = dateOrTime;
		}
		return result;
    }

	public static void encodeJPG(InputStream inSource,OutputStream outTarget,float quality) {
		try {
			BufferedImage sourcePic = ImageIO.read(inSource);
			BufferedImage tag = new BufferedImage(sourcePic.getTileWidth(),sourcePic.getTileHeight(),BufferedImage.TYPE_INT_RGB);
		    tag.getGraphics().drawImage(sourcePic,0,0,sourcePic.getTileWidth(),sourcePic.getTileHeight(),null);//绘制缩小后的图
		    JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(outTarget);
		    JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(tag);
		    param.setQuality(quality, false);
		    encoder.encode(tag);
		    outTarget.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @author Tiffany.deng
	 * 计算字符串的字节数目
	 * @param str
	 * @return
	 */
	public static int strlen(String str){
        try{
             return (new String(str.getBytes("gb2312"),"ISO-8859-1")).length();
        }catch(Exception e){
        	e.printStackTrace();
            return -1;
        }
	}
	/**
	 * 数字转中文
	 * @param str
	 * @return
	 */
	public static String toChinese(String str) {
	    str = str.replaceAll(",", "");// 去掉","
	    String integerStr;// 整数部分数字
	    String decimalStr;// 小数部分数字
	// 初始化：分离整数部分和小数部分
	if (str.indexOf(".") > 0) {
	      integerStr = str.substring(0, str.indexOf("."));
	      decimalStr = str.substring(str.indexOf(".") + 1);
	    } else if (str.indexOf(".") == 0) {
	      integerStr = "";
	      decimalStr = str.substring(1);
	    } else {
	      integerStr = str;
	      decimalStr = "";
	    }
	// integerStr去掉首0，不必去掉decimalStr的尾0(超出部分舍去)
	if (!integerStr.equals("")) {
	      integerStr = Long.toString(Long.parseLong(integerStr));
	if (integerStr.equals("0")) {
	        integerStr = "";
	      }
	    }
	// overflow超出处理能力，直接返回
	if (integerStr.length() > IUNIT.length) {
	      System.out.println(str + ":超出处理能力");
	return str;
	    }
	int[] integers = toArray(integerStr);// 整数部分数字
	boolean isMust5 = isMust5(integerStr);// 设置万单位
	int[] decimals = toArray(decimalStr);// 小数部分数字
	return getChineseInteger(integers, isMust5) + getChineseDecimal(decimals);
	  }
	/**
	   * 整数部分和小数部分转换为数组，从高位至低位
	*/
	private static int[] toArray(String number) {
	int[] array = new int[number.length()];
	for (int i = 0; i < number.length(); i++) {
	      array[i] = Integer.parseInt(number.substring(i, i + 1));
	    }
	return array;
	  }
	/**
	   * 判断第5位数字的单位"万"是否应加。
	*/
	private static boolean isMust5(String integerStr) {
	int length = integerStr.length();
	if (length > 4) {
	      String subInteger = "";
	if (length > 8) {
	// 取得从低位数，第5到第8位的字串
	        subInteger = integerStr.substring(length - 8, length - 4);
	      } else {
	        subInteger = integerStr.substring(0, length - 4);
	      }
	return Integer.parseInt(subInteger) > 0;
	    } else {
	return false;
	    }
	  }
	/**
	   * 得到中文金额的整数部分。
	*/
	private static String getChineseInteger(int[] integers, boolean isMust5) {
	    StringBuffer chineseInteger = new StringBuffer("");
	int length = integers.length;
	for (int i = 0; i < length; i++) {
	// 0出现在关键位置：1234(万)5678(亿)9012(万)3456(元)
	// 特殊情况：10(拾元、壹拾元、壹拾万元、拾万元)
	      String key = "";
	if (integers[i] == 0) {
	if ((length - i) == 13)// 万(亿)(必填)
	          key = IUNIT[4];
	else if ((length - i) == 9)// 亿(必填)
	          key = IUNIT[8];
	else if ((length - i) == 5 && isMust5)// 万(不必填)
	          key = IUNIT[4];
	else if ((length - i) == 1)// 元(必填)
	          key = IUNIT[0];
	// 0遇非0时补零，不包含最后一位
	if ((length - i) > 1 && integers[i + 1] != 0)
	          key += NUMBERS[0];
	      }
	      chineseInteger.append(integers[i] == 0 ? key
	          : (NUMBERS[integers[i]] + IUNIT[length - i - 1]));
	    }
	return chineseInteger.toString();
	  }
	/**
	   * 得到中文金额的小数部分。
	*/
	private static String getChineseDecimal(int[] decimals) {
	    StringBuffer chineseDecimal = new StringBuffer("");
	for (int i = 0; i < decimals.length; i++) {
	// 舍去3位小数之后的
	if (i == 3)
	break;
	      chineseDecimal.append(decimals[i] == 0 ? ""
	          : (NUMBERS[decimals[i]] + DUNIT[i]));
	    }
	return chineseDecimal.toString();
	  }
}
