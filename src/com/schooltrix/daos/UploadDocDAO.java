/**
 * 
 */
package com.schooltrix.daos;

import java.io.Serializable;
import java.util.List;

import com.schooltrix.hibernate.UploadDocument;
import com.schooltrix.hibernate.UploadDocumentClassBranchMap;
import com.schooltrix.hibernate.UploadDocuments;

/**
 * @author bhanu
 *
 */
public interface UploadDocDAO extends Serializable {
	
	public boolean save(UploadDocument transientInstance) throws Exception ;
	
	public boolean update(UploadDocument transientInstance)throws Exception ;
	
	public boolean delete(UploadDocument persistentInstance)throws Exception ;
	
	public UploadDocument findById(java.lang.Long id)throws Exception ;
	
	public UploadDocument findByProperty(final String filed,final String value)throws Exception ;
	
	public List findByPropertyList(final String filed,final String value)throws Exception ;
	
	public List getAssignemets(final String bm_id,final String cm_id)throws Exception ;

	public List getAcademics(final String bm_id,final String cm_id)throws Exception ;
	
	public List getUtilities(final String bm_id,final String cm_id,final String uptype)throws Exception ;

	public boolean saveUploadClassBranchMap(UploadDocumentClassBranchMap transientInstance) throws Exception;

	
	
	public List findAll()throws Exception ;
}
