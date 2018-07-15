package com.manage.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.manage.model.BaseModel;
import com.manage.model.SqlParams;
import com.manage.vo.PageData;




@Repository
public class BaseDao{

	@Resource
	public SqlSessionTemplate sqlTemplate;
	
	
	/**
	 * 传入一个Model对象并保存，
	 * 	superModel是所有所有Model的父类，所有的model请继承BaseModel,使用时传入子类对象
	 * @param ns nameSpace 命名空间 ,如没有传""
	 * @param sqlId sqlId
	 * @param superModel 实体类对象
	 * @return int 保存对象的条数
	 */
	public int save(String ns,String sqlId, BaseModel superModel ){
		return sqlTemplate.insert(ns+sqlId, superModel);
	}
	
	/**
	 * 传入一个SqlParams保存
	 * @param ns nameSpace 命名空间,如没有传""
	 * @param sqlId sqlId
	 * @param parmas SqlParams 参数对象
	 * @return int 保存对象的条数
	 */
	public int save(String ns,String sqlId, SqlParams params){
		return sqlTemplate.insert(ns+sqlId, params.getParams());
	}
	
	public int saveBatch(String ns,String sqlId, List list){
		return sqlTemplate.insert(ns+sqlId, list);
	}
	
	/**
	 * 传入一个Model对象并更新
	 * @param ns nameSpace 命名空间,如没有传""
	 * @param sqlId sqlId
	 * @param superModel 实体类对象
	 * @return int 更新对象的条数
	 */
	public int update(String ns,String sqlId, BaseModel superModel ){
		return sqlTemplate.update(ns+sqlId, superModel);
	}
	
	/**
	 * 传入一个SqlParams更新
	 * @param ns nameSpace 命名空间,如没有传""
	 * @param sqlId sqlId
	 * @param params SqlParams 参数对象
	 * @return 更新对象的条数 
	 */
	public int update(String ns,String sqlId, SqlParams params ){
		return sqlTemplate.update(ns+sqlId,  params.getParams());
	}
	
	/**
	 * 批量更新
	 * @param ns
	 * @param sqlId
	 * @param list
	 * @return
	 */
	public int updateBatch(String ns,String sqlId,List list){
		return sqlTemplate.update(ns+sqlId, list);
	}
	
	
	/**
	 * 根据mybatis映射文件中parameterType="int||string..."中的值删除对象
	 * @param ns nameSpace 命名空间,如没有传""
	 * @param sqlId sqlId
	 * @param key mybatis映射文件中parameterType="int||string..."中的值
	 * @return int 删除对象的条数
	 */
	public int delete(String ns,String sqlId, Serializable key ){
		return sqlTemplate.delete(ns+sqlId, key);
	}
	
	/**
	 * 传入一个Model对象删除
	 * @param ns nameSpace 命名空间,如没有传""
	 * @param sqlId sqlId
	 * @param superModel 实体类对象
	 * @return int 删除对象的条数
	 */
	public int delete(String ns,String sqlId, BaseModel superModel ){
		return sqlTemplate.delete(ns+sqlId, superModel);
	}
	
	/**
	 * 传入一个SqlParams执行删除
	 * @param ns nameSpace 命名空间,如没有传""
	 * @param sqlId sqlId
	 * @param params SqlParams 参数对象
	 * @return 删除对象的条数 
	 */
	public int delete(String ns,String sqlId, SqlParams params){
		return sqlTemplate.delete(ns+sqlId,  params.getParams());
	}
	
	/**
	 * 根据mybatis映射文件中parameterType="int||string..."中的值查询一个对象
	 * @param ns nameSpace 命名空间,如没有传""
	 * @param sqlId sqlId
	 * @param key mybatis映射文件中parameterType="int||string..."中的值
	 * @return 实体类对象
	 */
	public <T> T getOne(String ns, String  sqlId,Serializable key){
		
		return sqlTemplate.selectOne(ns+sqlId, key);
	}
	
	/**
	 * 传入一个Model对象查询这个对象
	 * @param ns nameSpace 命名空间,如没有传""
	 * @param sqlId sqlId
	 * @param superModel  实体类对象
	 * @return 实体类对象
	 */
	public <T> T getOne(String ns, String  sqlId,BaseModel superModel){
		
		return sqlTemplate.selectOne(ns+sqlId, superModel);
	}
	
	/**
	 * 传入一个SqlParams查询一个Model对象
	 * @param ns nameSpace 命名空间,如没有传""
	 * @param sqlId sqlId
	 * @param params  SqlParams 参数对象
	 * @return 实体类对象
	 */
	public <T> T getOne(String ns,String  sqlId,SqlParams params){
		
		return sqlTemplate.selectOne(ns+sqlId,  params.getParams());
	}
	
	/**
	 * 根据mybatis映射文件中parameterType="int||string..."中的值 查询,如：count(*),sum(*)等
	 * @param ns nameSpace 命名空间,如没有传""
	 * @param sqlId sqlId
	 * @param key  key mybatis映射文件中parameterType="int||string..."中的值
	 * @return long
	 */
	public long getCount(String ns,String sqlId,Serializable key){
		Long count =  sqlTemplate.selectOne(ns+sqlId, key);
		return count==null?0:count;
	}
	
	/**
	 * 传入一个Model对象查询,如：count(*),sum(*)等
	 * @param ns nameSpace 命名空间,如没有传""
	 * @param sqlId sqlId
	 * @param superModel 实体类对象
	 * @return long
	 */
	public long getCount(String ns,String sqlId,BaseModel superModel){
		Long count =  sqlTemplate.selectOne(ns+sqlId, superModel);
		return count==null?0:count;
	}
	
	/**
	 * 传入一个SqlParams查询,如：count(*),sum(*)等
	 * @param ns nameSpace 命名空间,如没有传""
	 * @param sqlId sqlId
	 * @param params SqlParams 参数对象
	 * @return long
	 */
	public long getCount(String ns,String sqlId,SqlParams params){
		Long count =  sqlTemplate.selectOne(ns+sqlId,  params.getParams());
		return count==null?0:count;
	}
	
	/**
	 * 根据mybatis映射文件中parameterType="int||string..."中的值 查询实体类对象集合
	 * @param ns nameSpace 命名空间,如没有传""
	 * @param sqlId sqlId
	 * @param key mybatis映射文件中parameterType="int||string..."中的值
	 * @return 实体类对象集合
	 */
	public <T> List<T> getList(String ns, String  sqlId,Serializable key){
		return sqlTemplate.selectList(ns+sqlId, key);
	}
	
	/**
	 * 传入一个Model对象查询实体类对象集合
	 * @param ns nameSpace 命名空间,如没有传""
	 * @param sqlId sqlId
	 * @param superModel  实体类对象
	 * @return 实体类对象集合
	 */
	public <T> List<T> getList(String ns, String  sqlId,BaseModel superModel){
		return sqlTemplate.selectList(ns+sqlId, superModel);
	}
	
	/**
	 * 传入一个SqlParams查询实体类对象集合
	 * @param ns nameSpace 命名空间,如没有传""
	 * @param sqlId sqlId
	 * @param params  SqlParams 参数对象， 可为null
	 * @return 实体类对象集合
	 */
	public <T> List<T> getList(String ns,String  sqlId,SqlParams params){
		if (null==params) {
			return sqlTemplate.selectList(ns+sqlId);
		}
		return sqlTemplate.selectList(ns+sqlId,  params.getParams());
	}
	
	
	public Map<String,Object> getMap(String ns,String  sqlId,SqlParams params){
		if (null==params) {
			return sqlTemplate.selectOne(ns+sqlId);
		}
		return sqlTemplate.selectOne(ns+sqlId,  params.getParams());
	}
	
	public List<Map<String,Object>> getMapList(String ns,String  sqlId,SqlParams params){
		if (null==params) {
			return sqlTemplate.selectList(ns+sqlId);
		}
		return sqlTemplate.selectList(ns+sqlId,  params.getParams());
	}
	
	public <E> PageData<E> findResult(String ns,String listSqlId,String countSqlId,SqlParams params,Integer pageNo,Integer pageSize){
		Long c = null;
		if(params == null){
			c = sqlTemplate.selectOne(ns + countSqlId);
		}else{
			c = sqlTemplate.selectOne(ns + countSqlId,params.getParams());
		}
		c = c == null ? 0 : c;
		PageData<E> result = new PageData<E>();
		if(c == 0){
			result.setData(null);
			result.setCount(c);
		}else{
			if(pageNo == null || pageNo < 1) pageNo = 1;
			int begin = (pageNo - 1)*pageSize;
			params.addParam("pageSize", pageSize).addParam("begin", begin);
			List<E> selectList = sqlTemplate.selectList(ns + listSqlId, params.getParams());
			result.setData(selectList);
			result.setCount(c);
		}
		return result;
	}
	
}
