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

import java.util.ArrayList;
import java.util.List;


import com.huateng.common.Module;
import com.huateng.common.Rescode;
import com.huateng.commonQry.bean.Page;
import com.huateng.commonQry.bean.RowData;
import com.huateng.exception.ComException;

public class Result {
    /** memeber variable: page object. */
    private Page page;
    /** memeber variable: orig data. */
    private List content;
    /** memeber variable: oper data. */
    private List data;

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }


    public void addRow(RowData rowData){
        data.add(rowData);
    }

    /**
     * get row
     * @param index
     * @return
     * @throws ComException
     */
    public RowData getRow(int index)throws ComException{
        RowData rowData = (RowData)data.get(index);
        if(rowData == null){
            throw new ComException(Module.SYSTEM_MODULE,
                    Rescode.DEFAULT_RESCODE,
                    "row number " + index + " no exist!");
        }
        return rowData;
    }

    /**
     * get field orig data
     * @param index
     * @param fId
     * @return
     * @throws ComException
     */
    public String getOrigData(int index,String fId)throws ComException{
        RowData rowData = getRow(index);
        return rowData.getField(fId).getOrig();
    }

    /**
     * get field opr data
     * @param index
     * @param fId
     * @return
     * @throws ComException
     */
    public String getOprData(int index,String fId)throws ComException{
        RowData rowData = getRow(index);
        return rowData.getField(fId).getOpr();
    }

    /**
     * The default constructor
     */
    public Result() {
        super();
        this.data = new ArrayList();
    }

    /**
     * The constructor using fields
     *
     * @param page
     * @param content
     */
    public Result(Page page, List content) {
        this.page = page;
        this.content = content;
        this.data = new ArrayList();
    }

    /**
     * @return Returns the content.
     */
    public List getContent() {
        return content;
    }

    /**
     * @return Returns the page.
     */
    public Page getPage() {
        return page;
    }

    /**
     * @param content
     *            The content to set.
     */
    public void setContent(List content) {
        this.content = content;
    }

    /**
     * @param page
     *            The page to set.
     */
    public void setPage(Page page) {
        this.page = page;
    }
}

