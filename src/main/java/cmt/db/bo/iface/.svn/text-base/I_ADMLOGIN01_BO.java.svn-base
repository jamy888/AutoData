package cmt.db.bo.iface;

import java.util.List;

import com.huateng.exception.ComException;

import cmt.db.po.TblAdmBrhInfo;
import cmt.db.po.TblAdmOprInfo;
import cmt.db.po.TblAdmRoleInfo;
import cmt.db.po.TblAdmTxnInfo;

public interface I_ADMLOGIN01_BO {
	/**
     * 通过机构编号获取机构信息
     * @param brhId
     * @return
     */
    public TblAdmBrhInfo getBrhInfoByBrhId(String brhId);

    /**
     * 通过操作员编号获取操作员信息
     * @param oprId
     * @return
     */
    public TblAdmOprInfo getOprInfoByOprId(String oprId);
    
    /**
     * 修改用户信息
     * @param oprId
     * @return
     */
    public void updateOprInfo(TblAdmOprInfo oprInfo);
    
    /**
     * 修改机构信息
     * @param brhId
     * @return
     */
    public void updateBrhInfo(TblAdmBrhInfo brhInfo);
    
    /**
     * 删除用户信息
     * @param oprId
     * @return
     */
    public void deleteOprInfo(String oprId);
    /**
     * 获取所有交易信息
     * @return
     */
    public List<TblAdmTxnInfo> loadAllTxnInfo();
    /**
     * 通过角色编号获取交易信息
     * @param roldId
     * @return
     */
    public List<TblAdmTxnInfo> loadTxnInfoByRoleId(String roleId);
    /**
     * 保存角色交易表
     * @param txnIds
     * @param flags
     * @param roldId
     * @throws ComException
     */
    public void saveRoleTxnMap(String txnIds, String flags, String roldId) throws ComException;
    /**
     * 获取roleInfo
     * @param roleId
     * @return
     * @throws ComException
     */
    public TblAdmRoleInfo getRoleInfo(String roleId) throws ComException;
    /**
     * 更新roleInfo
     * @param roleInfo
     * @throws ComException
     */
    public void updateRoleInfo(TblAdmRoleInfo roleInfo) throws ComException;
}