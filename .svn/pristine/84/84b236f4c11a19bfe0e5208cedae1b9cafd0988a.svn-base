/**	
 * <br>
 * Copyright 2013 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.iflytek.support.jdbc.transform <br>
 * FileName: AliasToBeanResultTransformer.java <br>
 * <br>
 * @version
 * @author xkfeng@iflytek.com
 * @created 2013-11-13
 * @last Modified 
 * @history
 */

package com.xiongwu.utils;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.PropertyNotFoundException;
import org.hibernate.property.ChainedPropertyAccessor;
import org.hibernate.property.PropertyAccessor;
import org.hibernate.property.PropertyAccessorFactory;
import org.hibernate.property.Setter;
import org.hibernate.transform.ResultTransformer;

import com.iflytek.uaac.service.support.jdbc.AliasUtils;


/**
 * hibernate ResultTransformer实现 AliasToBean
 * alias to java Field,如：COLUMN_NAME -> columnName
 *  
 *  @author xkfeng@iflytek.com
 */

public class AliasToBeanResultTransformer implements ResultTransformer {
	
	private static final long serialVersionUID = 2375909349054599319L;

	/**
	 * 转换类
	 */
	private final Class<?> resultClass;
	
	private final PropertyAccessor propertyAccessor;
	
	/**
	 * bean setters
	 */
	private Setter[] setters;

	/**
	 * 构造器
	 *  @param resultClass 结果Class
	 *  @author xkfeng@iflytek.com
	 *  @created 2013-12-10 上午09:38:18
	 *  @lastModified       
	 *  @history
	 */
	public AliasToBeanResultTransformer(Class<?> resultClass) {
		if ( resultClass == null ) {
			throw new IllegalArgumentException( "resultClass cannot be null" );
		}
		this.resultClass = resultClass;
		propertyAccessor = new ChainedPropertyAccessor(
				new PropertyAccessor[] {
						PropertyAccessorFactory.getPropertyAccessor( resultClass, null ),
						PropertyAccessorFactory.getPropertyAccessor( "field" )
				}
		);
	}

	/**
	 *  结果转换 aliases to tuple
	 *  @param tuple tuple
	 *  @param aliases aliases
	 *  @return java bean
	 *  @author xkfeng@iflytek.com
	 *  @created 2013-12-10 上午09:36:32
	 *  @lastModified
	 *  @history
	 */
	public Object transformTuple(Object[] tuple, String[] aliases) {
		Object result;

		try {
			if ( setters == null ) {
				setters = new Setter[aliases.length];
				for ( int i = 0; i < aliases.length; i++ ) {
					String alias = aliases[i];
					if ( alias != null ) {
						try {
							setters[i] = propertyAccessor.getSetter( resultClass, AliasUtils.getFieldName(alias) );
						} catch (PropertyNotFoundException e) {
							setters[i] = null;
						}
					}
				}
			}
			result = resultClass.newInstance();

			for ( int i = 0; i < aliases.length; i++ ) {
				if ( setters[i] != null ) {
					if(setters[i].getMethod().getParameterTypes()[0].equals(Long.class)
							&& tuple[i] !=null &&tuple[i].getClass().equals(BigDecimal.class)){
						tuple[i] = ((BigDecimal) tuple[i]).longValue();
					}
					setters[i].set( result, tuple[i], null );
				}
			}
		}
		catch ( InstantiationException e ) {
			throw new HibernateException( "Could not instantiate resultclass: " + resultClass.getName() );
		}
		catch ( IllegalAccessException e ) {
			throw new HibernateException( "Could not instantiate resultclass: " + resultClass.getName() );
		}

		return result;
	}

	/**
	 * 转换列表
	 *  @param collection 列表
	 *  @return 需要转换的列表
	 *  @author xkfeng@iflytek.com
	 *  @created 2013-12-10 上午09:37:35
	 *  @lastModified      
	 *  @history
	 */
	@SuppressWarnings("rawtypes")
	public List transformList(List collection) {
		return collection;
	}

	/**
	 * hashCode
	 *  @return hashCode
	 *  @author xkfeng@iflytek.com
	 *  @created 2013-12-10 上午09:37:56
	 *  @lastModified      
	 *  @history
	 */
	public int hashCode() {
		int result;
		result = resultClass.hashCode();
		result = 31 * result + propertyAccessor.hashCode();
		return result;
	}
}
