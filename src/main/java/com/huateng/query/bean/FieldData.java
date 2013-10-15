/**
 * Project: CMETPortal
 */
package com.huateng.query.bean;

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
public class FieldData {
    /** memeber variable: orig data. */
    private String orig = null;
    /** memeber variable: opr data. */
    private String opr = null;

    public FieldData(String orig,String opr){
        this.orig = orig;
        this.opr = opr;
    }

    public String getOpr() {
        return opr;
    }
    public void setOpr(String opr) {
        this.opr = opr;
    }
    public String getOrig() {
        return orig;
    }
    public void setOrig(String orig) {
        this.orig = orig;
    }
}
