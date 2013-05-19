package com.schooltrix.daos;

import java.io.Serializable;
import java.util.List;

import com.schooltrix.hibernate.BranchMaster;
/**
 * @author bhanu
 *
 */
public interface BranchMasterDAO extends Serializable {
	
	public boolean save(BranchMaster transientInstance) throws Exception ;
	
	public boolean update(BranchMaster transientInstance)throws Exception ;
	
	public boolean delete(BranchMaster persistentInstance)throws Exception ;
	
	public BranchMaster findById(java.lang.Long id)throws Exception ;
	
	public BranchMaster findByProperty(final String filed,final String value)throws Exception ;
	
	public List findByPropertyList(final String filed,final String value)throws Exception ;
	
	public List getBranchList(final String filed,final String value,final String filed1,final Long value1)throws Exception ; 
	
	public List getMultiBranchList(final String im_id,final String inQuery)throws Exception ; 
	
	public List findAll()throws Exception ;
	
}
