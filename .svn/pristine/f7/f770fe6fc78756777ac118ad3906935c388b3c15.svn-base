/**
 * 
 */
package com.schooltrix.daos;

import java.io.Serializable;
import java.util.List;

import com.schooltrix.hibernate.ParentDetails;

/**
 * @author bhanu
 *
 */
public interface ParentDetailsDAO extends Serializable {
	
	public boolean save(ParentDetails transientInstance) throws Exception ;
	
	public boolean update(ParentDetails transientInstance)throws Exception ;
	
	public boolean delete(ParentDetails persistentInstance)throws Exception ;
	
	public ParentDetails findById(java.lang.Long id)throws Exception ;
	
	public ParentDetails findByProperty(final String filed,final String value)throws Exception ;

	public ParentDetails findByProperty(final String filed,final Long value)throws Exception ;
	
	public List findByPropertyList(final String filed,final String value)throws Exception ;
	
	public List findAll()throws Exception ;
}
