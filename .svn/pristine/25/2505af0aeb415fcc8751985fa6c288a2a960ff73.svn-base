/**
 * 
 */
package com.schooltrix.daos;

import java.io.Serializable;
import java.util.List;

import com.schooltrix.hibernate.UploadDocuments;

/**
 * @author bhanu
 *
 */
public interface UploadDocDAO extends Serializable {
	
	public boolean save(UploadDocuments transientInstance) throws Exception ;
	
	public boolean update(UploadDocuments transientInstance)throws Exception ;
	
	public boolean delete(UploadDocuments persistentInstance)throws Exception ;
	
	public UploadDocuments findById(java.lang.Long id)throws Exception ;
	
	public UploadDocuments findByProperty(final String filed,final String value)throws Exception ;
	
	public List findByPropertyList(final String filed,final String value)throws Exception ;
	
	public List findAll()throws Exception ;
}
