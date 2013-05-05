/**
 * 
 */
package com.schooltrix.daos;

import java.io.Serializable;
import java.util.List;

import com.schooltrix.hibernate.StaffDetails;

/**
 * @author bhanu
 *
 */
public interface StaffDetailsDAO extends Serializable {
	
	public boolean save(StaffDetails transientInstance) throws Exception ;
	
	public boolean update(StaffDetails transientInstance)throws Exception ;
	
	public boolean delete(StaffDetails persistentInstance)throws Exception ;
	
	public StaffDetails findById(java.lang.Long id)throws Exception ;
	
	public StaffDetails findByProperty(final String filed,final String value)throws Exception ;
	
	public StaffDetails findByProperty(final String filed,final Long value)throws Exception ;

	public List findByPropertyList(final String filed,final String value)throws Exception ;
	
	public List emailCheck(String email,Long im_id) throws Exception;
	
	public List findAll()throws Exception ;
}
