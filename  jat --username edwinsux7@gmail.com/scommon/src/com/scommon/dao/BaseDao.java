package com.scommon.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import net.sf.json.JSONArray;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.util.Assert;

import com.scommon.exception.SaveException;
import com.scommon.exception.UpdateException;
import com.scommon.util.PagingBean;

public class BaseDao<T> extends HibernateBaseDao<T> {
	/**
	 * 保存实体
	 * @param entity
	 */
	public void save(Object entity){
		try{
			this.getHibernateTemplate().save(entity);
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			throw new SaveException(e);
		}
	}
	/**
	 * 保存或更新某个实例
	 * 
	 * @param entity
	 */
	public boolean saveOrUpdate(Object entity) {
		try{
			this.getHibernateTemplate().saveOrUpdate(entity);
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * 删除某个实例
	 * 
	 * @param entity
	 */
	public void delete(Object entity) {
		this.getHibernateTemplate().delete(entity);
	}

	/**
	 * 依据id删除实体
	 * 
	 * @param <T>
	 * @param clazz
	 * @param id
	 */
	@SuppressWarnings("unchecked")
	public <T> boolean deleteById(Serializable id) {
		try{
			this.delete(this.get(id));
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * merge()方法，会根据对象是否进行了实质性修改，来决定是否执行相应的update/delete/update语句，
	 * 而upate()则不会进行比较，只用给定的对象信息覆盖原有信息
	 * 合并后的entity实例仍然是一个脱管态，而save或saveOrUpdate执行后变为持久态
	 * 
	 * @param entity
	 */
	public void update(Object entity){
		try{
			this.getHibernateTemplate().merge(entity);
		}catch(Exception e){
			log.error(e.getMessage());
			throw new UpdateException(e);
		}
	}

	/**
	 * 返回所给id的实体类持久化实例，如果实例不存在则返回null。 该方法不会返回没有初始化的实例。
	 * 
	 * @param <T>
	 * @param clazz
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T get(Serializable id) {
		return (T) this.getHibernateTemplate().get(clazz, id);
	}

	/**
	 * 懒加载 返回所给id的实体类持久化实例，假定该实例存在。该方法可能返回一个代理实例， 这个代理实例在非id的方法被访问的时候根据需要初始化。
	 * 如果查找的实例不存在，抛出异常。
	 * 
	 * @param <T>
	 * @param clazz
	 * @param id
	 * @return
	 */
	public <T> T load(Serializable id) {
		return (T) this.getHibernateTemplate().load(clazz, id);
	}

	/**
	 * 直接查询所有数据 当数据大时易产生性能问题
	 * 
	 * @param <T>
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> findAll() {
		return (List<T>) this.getHibernateTemplate().loadAll(clazz);
	}

	/**
	 * 依据属性按序查询出所有 当数据大时易产生性能问题
	 * 
	 * @param <T>
	 * @param clazz
	 * @param orderBy
	 * @param isAsc
	 * @return List<T>
	 * @see DetachedCriteria用于有大量的动态条件查询,是一种离线的查询 不需要session创建，需Critteria正相反
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> findAll(String orderBy, boolean isAsc) {
		Assert.hasText(orderBy);
		if (isAsc) {
			return this.getHibernateTemplate().findByCriteria(
					DetachedCriteria.forClass(clazz).addOrder(
							Order.asc(orderBy)));
		} else {
			return this.getHibernateTemplate().findByCriteria(
					DetachedCriteria.forClass(clazz).addOrder(
							Order.desc(orderBy)));
		}
	}

	/**
	 * 强制Session冲刷。将当前Session中所有维持在内存中的保存、更新和删除持久化状态同步到数据库。
	 * 该方法必须在事务提交和Session关闭之前调用
	 * 。建议只在相同的事务内后续操作依赖于之前操作对数据库的改变时使用，一般情况建议依赖于事务提交时的自动冲刷即可，无需手动调用此方法。
	 */
	public void flush() {
		this.getHibernateTemplate().flush();
	}

	/**
	 * 从Session的缓存中移除该实例。该实例所有的更改将不会被同步到数据库。
	 * 
	 * @param entity
	 */
	public void evict(Object entity) {
		this.getHibernateTemplate().evict(entity);
	}

	/**
	 * 清除Session中缓存的所有对象，并取消当前Session中所有维持在内存中的保存、更新和删除持久化状态。
	 * 该方法不会关闭已经打开的迭代器或ScrollableResults实例。
	 */
	public void clear() {
		this.getHibernateTemplate().clear();
	}

	/**
	 * 根据hql和value查询
	 * 
	 * @param hql
	 * @param values
	 * @return
	 */
	public List findByHQLAndValue(String hql, Object... values) {
		try{
			return this.getHibernateTemplate().find(hql, values);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据hql查询
	 * @param hql
	 * @return
	 */
	public List findByHQL(String hql) {
		return this.getHibernateTemplate().find(hql);
	}
	/**
	 * 根据clazz propertyName value进行查询
	 * 
	 * @param <T>
	 * @param clazz
	 * @param propertyName
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> findByProperty(
			final String propertyName, final Object value) {
		Assert.hasText(propertyName);
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				return createCriteria(session,
						Restrictions.eq(propertyName, value)).list();
			}
		});
	}

	/**
	 * 创建一个criteria 一个中介类 Criterion是个接口，其实例可以由Restritions来创建
	 * 
	 * @param <T>
	 * @param clazz
	 * @param session
	 * @param values
	 * @return
	 */
	public <T> Criteria createCriteria(Session session,
			Criterion... values) {
		Criteria criteria = session.createCriteria(clazz);
		for (Criterion value : values) {
			criteria.add(value);
		}
		return criteria;
	}

	/**
	 * 按属性查询且排序
	 * 
	 * @param <T>
	 * @param clazz
	 * @param propertyName
	 * @param value
	 * @param orderBy
	 * @param isAsc
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> findByProperty(
			final String propertyName, final Object value,
			final String orderBy, final boolean isAsc) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				return createCriteria(session, orderBy, isAsc,
						Restrictions.eq(propertyName, value)).list();
			}

		});
	}

	/**
	 * 创建带排序条件的criteria
	 * 
	 * @param <T>
	 * @param clazz
	 * @param session
	 * @param orderBy
	 * @param isAsc
	 * @param values
	 * @return
	 */
	public <T> Criteria createCriteria(Session session,
			String orderBy, boolean isAsc, Criterion... values) {
		Assert.hasText(orderBy);
		Criteria criteria = this.createCriteria(session, values);
		if (isAsc) {
			criteria.addOrder(Order.asc(orderBy));
		} else {
			criteria.addOrder(Order.desc(orderBy));
		}
		return criteria;
	}

	/**
	 * 按属性查询唯一值
	 * @param <T>
	 * @param clazz
	 * @param propertyName
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T findUniqueByProperty(
			final String propertyName, final Object value) {
		Assert.hasText(propertyName);
		return (T) this.getHibernateTemplate().executeWithNativeSession(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						return createCriteria(session,
								Restrictions.eq(propertyName, value))
								.uniqueResult();
					}

				});
	}
	/**
	 * 分页
	 * @param hql
	 * @param offset
	 * @param length
	 * @return
	 */
	public List findByPage(final String hql, final int offset, final int length){
		try{
			List list = getHibernateTemplate().executeFind(new HibernateCallback(){

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(hql);
					query.setFirstResult(offset);
					query.setMaxResults(length);
					List list = query.list();
					return list;
				}
				
			});
			return list;
		}catch(Exception e){
			e.printStackTrace();
			log.info("page for '" + hql + "' is failed!");
		}
		return null;
	}
	/**
	 * 
	 * findTotal:查询总记录数
	 *   
	 * @param  @param <T>
	 * @param  @return    设定文件   
	 * @return int    DOM对象   
	 * @throws    
	 * @since  scommon1.0
	 */
	public<T> int findTotal(){
		List<T> list = this.findAll();
		return list.size();
	}
	/**
	 * 
	 * findResultByPageParam:查询出分页结果Bean   
	 *   
	 * @param  @param pageParamBean
	 * @param  @param hql
	 * @param  @return    设定文件   
	 * @return PageResultBean    DOM对象   
	 * @throws    
	 * @since  scommon1.0
	 */
	public PagingBean findStringByPage(String hql, int start, int limit){
		List<T> root = findByPage(hql, start, limit);
		int totalProperty = findTotal();
		return new PagingBean(totalProperty, root);
	}
	/**
	 * 
	 * getCurrentSession:获取当前session
	 * 应该用getCurrentSession(),但总报没加入事务中，找个时间改下  
	 * @param  @return    设定文件   
	 * @return Session    DOM对象   
	 * @throws    
	 * @since  scommon1.0
	 */
	public Session getCurrentSession(){
		try{
			return this.getHibernateTemplate().getSessionFactory().openSession();
		}catch(Exception e){
			e.printStackTrace();
			log.info(e.getMessage());
		}
		return null;
	}
	/**
	 * 
	 * findBySQL:sql查询 
	 *   
	 * @param  @param sql
	 * @param  @param values
	 * @param  @return    设定文件   
	 * @return List    DOM对象   
	 * @throws    
	 * @since  scommon1.0
	 */
	public List findBySQL(String sql , Object... values){
		Query query = this.getCurrentSession().createSQLQuery(sql).setCacheable(false);
		setParameters(query, values);
		return query.list();
	}
	
	/**
	 * 
	 * setParameters:设置参数值  
	 *   
	 * @param  @param query
	 * @param  @param values    设定文件   
	 * @return void    DOM对象   
	 * @throws    
	 * @since  scommon1.0
	 */
	public void setParameters(Query query, Object... values){
		for(int i = 0; i < values.length; i++){
			query.setParameter(i, values[i]);
		}
	}
}
