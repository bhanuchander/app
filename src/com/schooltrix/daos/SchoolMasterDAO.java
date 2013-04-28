/**
 * 
 */
package com.schooltrix.daos;

import java.io.Serializable;
import java.util.List;

import com.schooltrix.hibernate.SchoolMaster;

/**
 * @author bhanu
 *
 */
public interface SchoolMasterDAO extends Serializable {

	public boolean save(SchoolMaster transientInstance) throws Exception ;
	
	public boolean update(SchoolMaster transientInstance)throws Exception ;
	
	public boolean delete(SchoolMaster persistentInstance)throws Exception ;
	
	public SchoolMaster findById(java.lang.Long id)throws Exception ;
	
	public SchoolMaster findByProperty(final String filed,final String value)throws Exception ;
	
	public List findByPropertyList(final String filed,final String value)throws Exception ;

	public List getSchoolList(final String filed,final Long value) throws Exception ;
	
	public List findAll()throws Exception ;
	
	public List getFranchiseList(final String filed,final String value)throws Exception ;
}
