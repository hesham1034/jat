package com.scommon.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

@Component
public class HibernateBaseDao<T> extends HibernateDaoSupport {
	protected Class<T> clazz;
	
	Log log = LogFactory.getLog(HibernateBaseDao.class);

	public HibernateBaseDao() {
		clazz = getGenericType(0);
	}

	/**
	 * return parameter type of generic T
	 * 
	 * @param index
	 * @return
	 */
	public Class getGenericType(int index) {
		// get parameter class of generic eg:<Integer extends Number>
		Type genericType = getClass().getGenericSuperclass();
		// genericType is not ParameterizedType ,or said generic have not
		// parameter
		// so return object.class
		if (!(genericType instanceof ParameterizedType)) {
			return Object.class;
		}
		// get all generic's parameter
		Type[] params = ((ParameterizedType) genericType)
				.getActualTypeArguments();
		if (index >= params.length || index < 0) {
			log.error(this.getClass()
					+ ": getGenericType(index)-index outof bounds.");
		}
		// generic's parameter is not Class type
		if (!(params[index] instanceof Class)) {
			return Object.class;
		}
		return (Class) params[index];
	}
	
	/**
	 * IO sessionFactory to superclass HibernateDaoSupport
	 */
	@Resource(name = "sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	public static void main(String[] args) {
		HibernateBaseDao<Integer> hbd = new HibernateBaseDao<Integer>();
		System.out.println(hbd.getGenericType(0));
	}
}
