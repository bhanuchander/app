/**
 * 
 */
package com.schooltrix.daos;

import java.io.Serializable;
import java.util.List;

import com.schooltrix.hibernate.ParentStudentMap;
import com.schooltrix.hibernate.StudentDetails;
import com.schooltrix.hibernate.StudentSectionMap;
import com.schooltrix.hibernate.StudentxlErrorTemp;

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

	public ParentStudentMap getStudentParentMap(final String field,final String pd_id) throws Exception ;//may use both parent and student

	public boolean insertStudentSectionMap(StudentSectionMap ssm) ;

	public StudentSectionMap getStudentSectionMap(final String filed,final String value) throws Exception;

	public boolean insertStudentErrorLog(StudentxlErrorTemp setemp) throws Exception;
	
	public List getStudentErrorLog(final String um_id) throws Exception;
	
	public int deleteStudentErrorLog(final String um_id) throws Exception;

}
