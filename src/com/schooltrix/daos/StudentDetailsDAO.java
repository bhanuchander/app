/**
 * 
 */
package com.schooltrix.daos;

import java.io.Serializable;
import java.util.List;

import com.schooltrix.hibernate.ParentStudentMap;
import com.schooltrix.hibernate.StudentDetails;
import com.schooltrix.hibernate.StudentSectionMap;

/**
 * @author bhanu
 *
 */
public interface StudentDetailsDAO extends Serializable {
	
	public boolean save(StudentDetails transientInstance) throws Exception ;
	
	public boolean update(StudentDetails transientInstance)throws Exception ;
	
	public boolean delete(StudentDetails persistentInstance)throws Exception ;
	
	public StudentDetails findById(java.lang.Long id)throws Exception ;
	
	public StudentDetails findByProperty(final String filed,final String value)throws Exception ;

	public StudentDetails findByProperty(final String filed,final Long value)throws Exception ;
	
	public List findByPropertyList(final String filed,final String value)throws Exception ;
	
	public List findAll()throws Exception ;

	public boolean saveStudentParentMap(ParentStudentMap transientInstance) throws Exception ;

	public boolean insertStudentSectionMap(StudentSectionMap ssm);
	

}
