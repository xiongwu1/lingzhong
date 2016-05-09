package com.xiongwu.utils;

import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.util.Assert;

import com.iflytek.iframework.orm.Page;
import com.iflytek.iframework.orm.hibernate.HibernateGenericDao;

/**
 * 	HibernateUtil工具类
 *  
 *  @param <T>
 *  @author xiongwu@iflytek.com
 *  @created 2016年1月20日 下午1:09:47
 *  @lastModified       
 *  @history
 */
public class HibernateUtil<T> extends HibernateGenericDao {

    /**
     * 重写findSqlPage方法,支持驼峰规则命名的规则变量
     * @param page
     * @param sql
     * @param cl
     * @param values
     * @param <T>
     * @return
     */
	public  <T> Page<T> findSqlPage(Page<T> page, String sql, Class cl, Object... values) {
        Assert.notNull(page, "page不能为空");
        SQLQuery q = createSqlQuery(sql, values);
        if(page.isAutoCount()) {
            long result = this.countSqlResult(sql, values);
            page.setTotalCount(result);
        }

        this.setSqlPageParameter(q, page);
        List result1 = q.setResultTransformer(ResultTransformers.aliasToBean(cl)).list();
        page.setResult(result1);
        return page;
    }
    
    /**
     * 查询结果列表，支持驼峰规则命名的规则变量
     * @param sql
     * @param cl
     * @param values
     * @param <T>
     * @return
     */
    public  <T> List<T> findSqlList( String sql, Class cl, Object... values) {
        SQLQuery q = createSqlQuery(sql, values);
        List result = q.setResultTransformer(ResultTransformers.aliasToBean(cl)).list();
        return result;
    }
}
