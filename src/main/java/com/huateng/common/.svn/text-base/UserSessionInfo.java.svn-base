package com.huateng.common;

import java.sql.Date;
import java.util.Hashtable;

import javax.security.auth.Subject;

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
public class UserSessionInfo {

    private String oprId = "" ;         //柜员号
    private String cmetOprId = "" ;     //世博柜员号
    private String oprNm = "" ;         //柜员名称
    private String oprType = "";        //柜员类型
    private String brhId = "" ;         //机构号
    private String cmetBrhId = "" ;     //世博机构号
    private String brhNm = "";          //机构名称
    private String brhLevel = "";       //机构级别
    private String supBrhId = "";       //上级机构号
    private String prvCd = "";          //机构省份
    private String platFlg = "";        //登录平台标志
    private String roleId = "";         //用户角色编号
    private String roleNm = "";         //用户角色名称
    //private Vector userRoles;         //用户角色信息
    private Hashtable<String, String> userFunctions; //用户功能权限信息
    private Subject subject = null; //Subject
    private Date txDate = null; //会计日期
    private String lastLoginTime = "" ;//最近登陆时间
    private String lastLogoutTime = "" ;//最近退出时间
    private String ip = "" ;//IP
    private String oprContTelno = "";// 扩展信息-操作员联系电话

    public UserSessionInfo() {
        roleId = new String();
        userFunctions = new Hashtable<String, String>();
    }

    public Hashtable<String, String> getUserFunctions() {
        return userFunctions;
    }

    public void setUserFunctions(Hashtable<String, String> hashtable) {
        userFunctions = hashtable;
    }

    public void addUserFunctionsItem(String obj) {
        userFunctions.put(obj,obj);
    }

    public void removeUserFunctionsItem(Object obj) {
        userFunctions.remove(obj);
    }

    public void clearFunctionsItems() {
        userFunctions.clear() ;
    }

    public boolean isExistUserFunctionsItems(Object obj) {
        Object lobj = userFunctions.get(obj);
        return null!=lobj ;
    }

    /**
     * @return the oprId
     */
    public String getOprId() {
        return oprId;
    }

    /**
     * @param oprId the oprId to set
     */
    public void setOprId(String oprId) {
        this.oprId = oprId;
    }

    /**
     * @return the cmetOprId
     */
    public String getCmetOprId() {
        return cmetOprId;
    }

    /**
     * @param cmetOprId the cmetOprId to set
     */
    public void setCmetOprId(String cmetOprId) {
        this.cmetOprId = cmetOprId;
    }

    /**
     * @return the oprNm
     */
    public String getOprNm() {
        return oprNm;
    }

    /**
     * @param oprNm the oprNm to set
     */
    public void setOprNm(String oprNm) {
        this.oprNm = oprNm;
    }

    /**
     * @return the oprType
     */
    public String getOprType() {
        return oprType;
    }

    /**
     * @param oprType the oprType to set
     */
    public void setOprType(String oprType) {
        this.oprType = oprType;
    }

    /**
     * @return the brhId
     */
    public String getBrhId() {
        return brhId;
    }

    /**
     * @param brhId the brhId to set
     */
    public void setBrhId(String brhId) {
        this.brhId = brhId;
    }

    /**
     * @return the cmetBrhId
     */
    public String getCmetBrhId() {
        return cmetBrhId;
    }

    /**
     * @param cmetBrhId the cmetBrhId to set
     */
    public void setCmetBrhId(String cmetBrhId) {
        this.cmetBrhId = cmetBrhId;
    }

    /**
     * @return the brhNm
     */
    public String getBrhNm() {
        return brhNm;
    }

    /**
     * @param brhNm the brhNm to set
     */
    public void setBrhNm(String brhNm) {
        this.brhNm = brhNm;
    }

    /**
     * @return the brhLevel
     */
    public String getBrhLevel() {
        return brhLevel;
    }

    /**
     * @param brhLevel the brhLevel to set
     */
    public void setBrhLevel(String brhLevel) {
        this.brhLevel = brhLevel;
    }

    /**
     * @return the supBrhId
     */
    public String getSupBrhId() {
        return supBrhId;
    }

    /**
     * @param supBrhId the supBrhId to set
     */
    public void setSupBrhId(String supBrhId) {
        this.supBrhId = supBrhId;
    }

    /**
     * @return the roleId
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * @param roleId the roleId to set
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * @return the roleNm
     */
    public String getRoleNm() {
        return roleNm;
    }

    /**
     * @param roleNm the roleNm to set
     */
    public void setRoleNm(String roleNm) {
        this.roleNm = roleNm;
    }

    /**
     * @return the subject
     */
    public Subject getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    /**
     * @return the txDate
     */
    public Date getTxDate() {
        return txDate;
    }

    /**
     * @param txDate the txDate to set
     */
    public void setTxDate(Date txDate) {
        this.txDate = txDate;
    }

    /**
     * @return the lastLoginTime
     */
    public String getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * @param lastLoginTime the lastLoginTime to set
     */
    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * @return the lastLogoutTime
     */
    public String getLastLogoutTime() {
        return lastLogoutTime;
    }

    /**
     * @param lastLogoutTime the lastLogoutTime to set
     */
    public void setLastLogoutTime(String lastLogoutTime) {
        this.lastLogoutTime = lastLogoutTime;
    }

    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip the ip to set
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @return the oprContTelno
     */
    public String getOprContTelno() {
        return oprContTelno;
    }

    /**
     * @param oprContTelno the oprContTelno to set
     */
    public void setOprContTelno(String oprContTelno) {
        this.oprContTelno = oprContTelno;
    }
    /**
     * @param prvCd the prvCd to set
     */
    public String getPrvCd() {
        return prvCd;
    }
    /**
     * @return the prvCd
     */
    public void setPrvCd(String prvCd) {
        this.prvCd = prvCd;
    }

    /**
     * @return the platFlg
     */
    public String getPlatFlg() {
        return platFlg;
    }

    /**
     * @param platFlg the platFlg to set
     */
    public void setPlatFlg(String platFlg) {
        this.platFlg = platFlg;
    }


}
