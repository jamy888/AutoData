/**
 * Project: CMETPortal
 */
package com.huateng.query.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.huateng.query.bean.Result;

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
public interface ICommQueryObj {

    /**
     * Execute a query.
     *
     * @param query
     *            a query expressed in Hibernate's query language
     * @return a distinct list of instances (or arrays of instances)
     */
    public abstract java.util.List find(String query);

    /**
     * 通过 SQL name 查询
     *
     * @param name
     *            the name of a query defined externally
     * @return Query
     */
    public abstract java.util.List findByNamedQuery(String name);

    public abstract java.util.List findByNamedQuery(final String name, final int begin, final int count);

    /**
     * Obtain an instance of Query for a named query string defined in the
     * mapping file. Use the parameters given.
     *
     * @param name
     *            the name of a query defined externally
     * @param params
     *            the parameter Map
     * @return Query
     */
    public abstract java.util.List findByNamedQuery(final String name, final Map params);

    public abstract java.util.List findByNamedQuery(final String name, final Map params, final int begin, final int count);

    /**
     * 通过 SQL 查询
     *
     * @param sql
     *            SQL Statement
     * @param begin
     * @param count
     * @return
     */
    public abstract java.util.List findBySQLQuery(final String sql, final int begin, final int count);

    /**
     * Obtain an instance of Query for a sql string.
     *
     * @param sql
     * @param countSql
     * @param begin
     * @param count
     * @return
     */
    public abstract Result findBySQLQuery(final String sql, final String countSql, final int begin, final int count);

    /**
     * Obtain an instance of Query for a sql string.
     *
     * @param countSql
     * @return
     */
    public abstract String findCountBySQLQuery(final String countSql);

    /**
     * Obtain an instance of Query for a sql string.
     * @param sql
     * @return
     */
    public abstract List findBySQLQuery(final String sql);

    /**
     * Obtain an instance of Query for a named query string defined in the
     * mapping file. Use the parameters given.
     *
     * @param name
     *            the name of a query defined externally
     * @param params
     *            the parameter array
     * @return Query
     */
    public abstract java.util.List findByNamedQuery(final String name, final Serializable[] params);

    public abstract java.util.List findByNamedQuery(final String name, final Serializable[] params, final int begin, final int count);

    /**
     *
     */
    public abstract List findByHQLQuery(final String hql);

    /**
     * 通过 HQL 查询
     * Obtain an instance of Query for a hql string.
     *
     * @param hql
     * @param begin
     * @param count
     * @return
     */
    public abstract java.util.List findByHQLQuery(final String hql, final int begin, final int count);

    /**
     * 通过HQL查询
     * Obtain an instance of Query for a hql string.
     *
     * @param hql
     * @param countSql
     * @param begin
     * @param count
     * @return
     */
    public abstract Result findByHQLQuery(final String hql, final String countSql, final int begin, final int count);

}
