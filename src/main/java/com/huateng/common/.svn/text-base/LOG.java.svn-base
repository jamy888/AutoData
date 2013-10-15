package com.huateng.common;

import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;

/**
 * <p>
 * <strong> Description:</strong> 监控日志
 * </p>
 * <p>
 * <strong> Copyright:</strong>&copy2009 Huateng
 * </p>
 * <p>
 * <strong> Company:</strong>上海华腾软件系统有限公司
 * </p>
 *
 * @author 李伟
 * @version 1.0
 */
public class LOG {

    /**
     * 是否转码标志(UTF-8)
     */
    private static final int TRAN_FLAG = 0;

    /**
     * 操作员日志记录器
     */
    private static Logger MNTLOG = Logger.getLogger("CMTMNT");
    /**
     * 祝福日志
     */
    private static Logger WISHLOG = Logger.getLogger("WISH");

    /**
     * 记录全局通用日志
     *
     * @param arg0
     */
    public static void MNTINFO(String arg0) {
        if (TRAN_FLAG == 1) {
            try {
                MNTLOG.info(new String(arg0.getBytes(), "UTF-8"));
            } catch (UnsupportedEncodingException unex) {
                MNTLOG.info(arg0);
            }
        } else {
            MNTLOG.info(arg0);
        }
    }

    /**
     * 记录全局通用日志、异常
     *
     * @param arg0
     * @param arg1
     */
    public static void MNTINFO(String arg0, Throwable arg1) {
        if (TRAN_FLAG == 1) {
            try {
                MNTLOG.info(new String(arg0.getBytes(), "UTF-8"), arg1);
            } catch (UnsupportedEncodingException unex) {
                MNTLOG.info(arg0, arg1);
            }
        } else {
            MNTLOG.info(arg0, arg1);
        }
    }
    
    /**
     * 记录全局通用日志
     *
     * @param arg0
     */
    public static void WISHINFO(String arg0) {
        if (TRAN_FLAG == 1) {
            try {
            	WISHLOG.info(new String(arg0.getBytes(), "UTF-8"));
            } catch (UnsupportedEncodingException unex) {
            	WISHLOG.info(arg0);
            }
        } else {
        	WISHLOG.info(arg0);
        }
    }
}
