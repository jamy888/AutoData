/**
 * Project: CMPOSPConsole
 */
package com.huateng.exception;


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
public class ComException extends Exception{

    /**
     *
     */
    private static final long serialVersionUID = 3901299923749285983L;

    protected String moduleName = null;
    protected String errCode = null;
    protected String errorPage = null;
    protected String errMessage = null;

    public ComException() {
    	super();
    }

    public ComException(String message) {
        super(message);
    }

    public ComException(String moduleName, String errCode) {
        this(moduleName, errCode, null, null);
    }

    public ComException(String moduleName, String errCode, String message) {
        this(moduleName,errCode,message,null);
    }

    public ComException(String moduleName, String errCode, Exception exception) {
        this(moduleName, errCode, null, exception);
    }

    public ComException(String moduleName, String errCode, String message, Exception exception) {
        super(message,exception);
        this.moduleName = moduleName;
        this.errCode = errCode;
        this.errMessage = message;
    }

    public ComException(String moduleName, String errCode, String message, String errorPage, Exception exception) {
        this(moduleName, errCode, message, exception);
        this.errorPage = errorPage;
    }

    public String getErrCd() {
        if (moduleName == null || errCode == null) {
            return "9999";
        }
        return moduleName + errCode;
    }

    public String getErrMessage() {
        if (this.errMessage == null)
            return "操作失败";
        return this.errMessage;
    }
}
