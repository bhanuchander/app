package com.schooltrix.daos;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StringType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.schooltrix.hibernate.UploadDocumentClassBranchMap;
import com.schooltrix.hibernate.UploadDocuments;
import com.schooltrix.hibernate.UploadDocument;

public class UploadDocDAOImpl extends STHibernateDAOSupport implements UploadDocDAO{
	
	@Override
	public boolean save(UploadDocument transientInstance) throws Exception {
		
			getHibernateTemplate().saveOrUpdate(transientInstance);
			System.out.println("in saveee");
			return true;
		
	}
	@Override
	public boolean update(UploadDocument transientInstance) throws Exception {
		try {
			getHibernateTemplate().update(transientInstance);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean delete(UploadDocument persistentInstance) throws Exception {
		try {
			getHibernateTemplate().delete(persistentInstance);
			return true;
		} catch (Exception re) {
			re.printStackTrace();
			return false;
		}
	}
	@Override
	public UploadDocument findByProperty(final String filed,final String value) throws Exception {
		try {
			return (UploadDocument) getHibernateTemplate().execute(
					new HibernateCallback() {
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException{							
							Criteria isExpiredCrit = session.createCriteria(UploadDocument.class);
							isExpiredCrit.add(Restrictions.eq(filed, value));
							List list = isExpiredCrit.list();
							if(list.size()>0)
								return list.get(0);
							else
								return null;
						}
					});
		} catch (Exception ex_) {
			ex_.printStackTrace();
			return null;
		}
		
	}
		
	
	@Override
	public List findByPropertyList(final String filed,final String value) throws Exception {
		List UploadDocumentList=null;
		try {
			UploadDocumentList = (List) getHibernateTemplate().execute(
					new HibernateCallback() {
						public Object doInHibernate(Session session)throws HibernateException, SQLException {
							Criteria crit = session.createCriteria(UploadDocument.class);
							crit.add(Restrictions.eq(filed, value));
							//crit.addOrder(Order.desc("sno"));
							return crit.list();
						}
					});
		} catch (Exception ex_) {
			ex_.printStackTrace();
			return null;
		}
		return UploadDocumentList;
	}
	
	
	
	@Override
	public UploadDocument findById(java.lang.Long id) throws Exception {
		try {
			UploadDocument instance = (UploadDocument) getHibernateTemplate().get("com.schooltrix.hibernate.UploadDocument", id);
			return instance;
		} catch (Exception re) {
			throw re;
		}
	}
	
/*	public List getAssignemets(final String bm_id,final String cm_id)throws Exception {

		
		List assignList=null;
		try {
			//System.out.println("in branchMasterList DAOIMPL");
			assignList = (List) getHibernateTemplate().execute(
					new HibernateCallback() {
						public Object doInHibernate(Session session)throws HibernateException, SQLException {
						
							select * from upload_documents where ((to_which like '%,4,%') or
									(to_which like '4,%') or (to_which like '%,4') or (to_which like '4') );
							
							String qu = "select upload_date,assign_type ,subject,assg_desc,file_name  from upload_documents where ((to_which like '%,"+cm_id+",%') or	(to_which like '"+cm_id+",%') " +
									"or (to_which like '%,"+cm_id+"') or (to_which like '"+cm_id+"'))  and ((bm_id like '%,"+bm_id+",%') or	(bm_id like '"+bm_id+",%') " +
									"or (bm_id like '%,"+bm_id+"') or (bm_id like '"+bm_id+"'))  and    to_whome in ('Parents','0') and upload_type='Assignment'  order by upload_date desc";
							
							System.out.println("##"+qu);
							StringType st = new StringType();
							SQLQuery sqlqu = session.createSQLQuery(qu);	
							sqlqu.addScalar("upload_date", st);
							sqlqu.addScalar("assign_type",st );
							sqlqu.addScalar("subject", st);
							sqlqu.addScalar("assg_desc",st);
							sqlqu.addScalar("file_name", st);
							
							System.out.println("in SIZE"+sqlqu.list().size());
							return sqlqu.list();
						}
					});
		} catch (Exception ex_) {
			ex_.printStackTrace();
			return assignList;
		}
		return assignList;
	}
	*/

	public List getAssignemets(final String bm_id,final String cm_id)throws Exception {		
		
		List assignList=null;
		try {
			//System.out.println("in branchMasterList DAOIMPL");
			assignList = (List) getHibernateTemplate().execute(
					new HibernateCallback() {
						public Object doInHibernate(Session session)throws HibernateException, SQLException {
							
/*							String qu = "select upload_date,assign_type ,subject,assg_desc,file_name  from upload_documents where ((to_which like '%,"+cm_id+",%') or	(to_which like '"+cm_id+",%') " +
									"or (to_which like '%,"+cm_id+"') or (to_which like '"+cm_id+"'))  and ((bm_id like '%,"+bm_id+",%') or	(bm_id like '"+bm_id+",%') " +
									"or (bm_id like '%,"+bm_id+"') or (bm_id like '"+bm_id+"'))  and    to_whome in ('Parents','0') and upload_type='Assignment'  order by upload_date desc";
*/							
							String qu ="select ud.upload_date as upload_date,ud.assign_type as assign_type ,ud.subject as subject,ud.assg_desc as assg_desc,ud.file_name as file_name " +
									"from upload_document ud inner join upload_document_class_branch_map udbc on ud.ud_id=udbc.ud_id  " +
									"where  ud.subject in (select subm_id from subject_class_map where cm_id = '"+cm_id+"') " +
									"and udbc.bm_id='"+bm_id+"' and udbc.cm_id='"+cm_id+"' and    ud.to_whome in ('Parents','0') and ud.upload_type='Assignment'  order by ud.upload_date desc";
							
							System.out.println("##"+qu);
							StringType st = new StringType();
							SQLQuery sqlqu = session.createSQLQuery(qu);	
							sqlqu.addScalar("upload_date", st);
							sqlqu.addScalar("assign_type",st );
							sqlqu.addScalar("subject", st);
							sqlqu.addScalar("assg_desc",st);
							sqlqu.addScalar("file_name", st);
							
							System.out.println("in SIZE"+sqlqu.list().size());
							return sqlqu.list();
						}
					});
		} catch (Exception ex_) {
			ex_.printStackTrace();
			return assignList;
		}
		return assignList;
	}
	
	public List getAcademics(final String bm_id,final String cm_id)throws Exception {		
		
		List assignList=null;
		try {
			//System.out.println("in branchMasterList DAOIMPL");
			assignList = (List) getHibernateTemplate().execute(
					new HibernateCallback() {
						public Object doInHibernate(Session session)throws HibernateException, SQLException {
							
/*							String qu = "select upload_date,assign_type ,subject,assg_desc,file_name  from upload_documents where ((to_which like '%,"+cm_id+",%') or	(to_which like '"+cm_id+",%') " +
									"or (to_which like '%,"+cm_id+"') or (to_which like '"+cm_id+"'))  and ((bm_id like '%,"+bm_id+",%') or	(bm_id like '"+bm_id+",%') " +
									"or (bm_id like '%,"+bm_id+"') or (bm_id like '"+bm_id+"'))  and    to_whome in ('Parents','0') and upload_type='Assignment'  order by upload_date desc";
*/							
							String qu ="select ud.upload_date as upload_date,ud.subject as subject,ud.assg_desc as assg_desc,ud.file_name as file_name " +
									"from upload_document ud inner join upload_document_class_branch_map udbc on ud.ud_id=udbc.ud_id  " +
									"where  ud.subject in (select subm_id from subject_class_map where cm_id = '"+cm_id+"') " +
									"and udbc.bm_id='"+bm_id+"' and udbc.cm_id='"+cm_id+"' and    ud.to_whome in ('Parents','0') and ud.upload_type='AcademicMaterial'  order by ud.upload_date desc";
							
							System.out.println("##"+qu);
							StringType st = new StringType();
							SQLQuery sqlqu = session.createSQLQuery(qu);	
							sqlqu.addScalar("upload_date", st);
							sqlqu.addScalar("subject", st);
							sqlqu.addScalar("assg_desc",st);
							sqlqu.addScalar("file_name", st);
							
							System.out.println("in SIZE"+sqlqu.list().size());
							return sqlqu.list();
						}
					});
		} catch (Exception ex_) {
			ex_.printStackTrace();
			return assignList;
		}
		return assignList;
	}
	
	
	//this is same like getAssignemets....
	public List getUtilities(final String bm_id,final String cm_id,final String uptype)throws Exception {

		
		List assignList=null;
		try {
			//System.out.println("in branchMasterList DAOIMPL");
			assignList = (List) getHibernateTemplate().execute(
					new HibernateCallback() {
						public Object doInHibernate(Session session)throws HibernateException, SQLException {
						
							
						/*	String qu = "select upload_date,upload_type ,file_name  from upload_documents where ((to_which like '%,"+cm_id+",%') or	(to_which like '"+cm_id+",%') " +
									"or (to_which like '%,"+cm_id+"') or (to_which like '"+cm_id+"'))  and ((bm_id like '%,"+bm_id+",%') or	(bm_id like '"+bm_id+",%') " +
									"or (bm_id like '%,"+bm_id+"') or (bm_id like '"+bm_id+"'))  and    to_whome in ('Parents','0') and upload_type='"+uptype+"'  order by upload_date desc limit 1";
						*/	
							String qu ="select ud.upload_date as upload_date,ud.upload_type as upload_type ,ud.file_name as file_name " +
									"from upload_document ud inner join upload_document_class_branch_map udbc on ud.ud_id=udbc.ud_id  " +
									"where  udbc.bm_id='"+bm_id+"' and udbc.cm_id='"+cm_id+"' and    ud.to_whome in ('Parents','0') and ud.upload_type='"+uptype+"' order by ud.upload_date desc limit 1";
							
							System.out.println(uptype+"getUtilities#"+qu);
							StringType st = new StringType();
							SQLQuery sqlqu = session.createSQLQuery(qu);	
							sqlqu.addScalar("upload_date", st);
							sqlqu.addScalar("upload_type",st );
							sqlqu.addScalar("file_name", st);
							
							System.out.println("getUtilities SIZE"+sqlqu.list().size());
							return sqlqu.list();
						}
					});
		} catch (Exception ex_) {
			ex_.printStackTrace();
			return assignList;
		}
		return assignList;
	}
	
	public boolean saveUploadClassBranchMap(UploadDocumentClassBranchMap transientInstance) throws Exception {
		
		getHibernateTemplate().save(transientInstance);
		//System.out.println("in saveee");
		return true;
	}
	
	
	
	
	
	
	
	
	@Override
	public List findAll() throws Exception {
		try {
			String queryString = "from UploadDocument";
			return getHibernateTemplate().find(queryString);
		} catch (Exception re) {
			re.printStackTrace();
			return null;
		}
	}
}