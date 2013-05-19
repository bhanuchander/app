package com.schooltrix.daos;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StringType;

import org.springframework.orm.hibernate3.HibernateCallback;

import com.schooltrix.hibernate.ClassBranchMap;
import com.schooltrix.hibernate.ClassMaster;
import com.schooltrix.hibernate.SubjectMaster;
import com.sun.istack.internal.FinalArrayList;


public class ClassMasterDAOImpl extends STHibernateDAOSupport implements ClassMasterDAO{
	
	
	
	
	
	@Override
	public boolean save(ClassMaster transientInstance) throws Exception {
		System.out.println("in ClassMasterDAOImpl");
			getHibernateTemplate().saveOrUpdate(transientInstance);
			System.out.println("in saveee");
			return true;
		
	}
	@Override
	public boolean update(ClassMaster transientInstance) throws Exception {
		try {
			getHibernateTemplate().update(transientInstance);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean delete(ClassMaster persistentInstance) throws Exception {
		try {
			getHibernateTemplate().delete(persistentInstance);
			return true;
		} catch (Exception re) {
			re.printStackTrace();
			return false;
		}
	}
	@Override
	public ClassMaster findByProperty(final String filed,final String value) throws Exception {
		try {
			return (ClassMaster) getHibernateTemplate().execute(
					new HibernateCallback() {
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException{							
							Criteria isExpiredCrit = session.createCriteria(ClassMaster.class);
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
		List ClassMasterList=null;
		try {
			ClassMasterList = (List) getHibernateTemplate().execute(
					new HibernateCallback() {
						public Object doInHibernate(Session session)throws HibernateException, SQLException {
							Criteria crit = session.createCriteria(ClassMaster.class);
							crit.add(Restrictions.eq(filed, value));
							crit.add(Restrictions.eq("active", "Y"));
							//crit.addOrder(Order.desc("sno"));
							return crit.list();
						}
					});
		} catch (Exception ex_) {
			ex_.printStackTrace();
			return null;
		}
		return ClassMasterList;
	}
	

		@Override
		public List getClassMasterList(final String IM_ID,final String SM_ID,final String BM_ID,final int flag) throws Exception {
			List ClassMasterList=null;
			try {
				System.out.println("in daoimpl--"+flag+"--"+IM_ID+"--"+SM_ID+"--"+BM_ID+"--");
				ClassMasterList = (List) getHibernateTemplate().execute(
						new HibernateCallback() {
							public Object doInHibernate(Session session)throws HibernateException, SQLException {//need more where condtion im_id sm_id
							//	String qu= "select cm_id,class_name from class_master where cm_id in(select cm_id  from class_branch_map where Active='Y' and bm_id='"+BM_ID+"')";
								String  qu=null;
								if (flag == 1) {
									//all classes under institution
									qu= "select cm_id,class_name from class_master where cm_id in(select cm_id  from class_branch_map where Active='Y'" +
											" and bm_id in (select bm_id  from branch_master where Active='Y' and im_id='"+IM_ID+"'))";
									
								}else if (flag == 2) {
									//here based on branch id only we get classes list....
									qu= "select cm_id,class_name from class_master where cm_id in(select cm_id  from class_branch_map where Active='Y'" +
											" and bm_id ='"+BM_ID+"')";
									
								}else if (flag == 3) {
									//under one school...
									//all classes under school
									qu= "select cm_id,class_name from class_master where cm_id in(select cm_id  from class_branch_map where Active='Y'" +
											" and bm_id in (select bm_id  from branch_master where Active='Y' and sm_id='"+SM_ID+"'))";
									
								}
								
								
								SQLQuery sqlqu = session.createSQLQuery(qu);							
								sqlqu.addScalar("cm_id", new StringType());
								sqlqu.addScalar("class_name", new StringType());
								System.out.println(qu);
								System.out.println("in SIZE"+sqlqu.list().size());
								return sqlqu.list();
							}
						});
			} catch (Exception ex_) {
				ex_.printStackTrace();
				return null;
			}
			return ClassMasterList;
		}
		
		@Override
		public List getClassMasterList(final String BM_ID) throws Exception {
			List ClassMasterList=null;
			try {
				System.out.println("in getClassMasterList DAOIMPL");
				ClassMasterList = (List) getHibernateTemplate().execute(
						new HibernateCallback() {
							public Object doInHibernate(Session session)throws HibernateException, SQLException {//need more where condtion im_id sm_id
							//	String qu= "select cm_id,class_name from class_master where cm_id in(select cm_id  from class_branch_map where Active='Y' and bm_id='"+BM_ID+"')";
								String qu= "select cm_id,class_name from class_master where cm_id in(select cm_id  from class_branch_map where Active='Y' and bm_id='"+BM_ID+"')";
								SQLQuery sqlqu = session.createSQLQuery(qu);							
								sqlqu.addScalar("cm_id", new StringType());
								sqlqu.addScalar("class_name", new StringType());
								System.out.println("in SIZE"+sqlqu.list().size());
								return sqlqu.list();
							}
						});
			} catch (Exception ex_) {
				ex_.printStackTrace();
				return null;
			}
			return ClassMasterList;
		}	
		
		@Override
		public List getMultiClassMasterList(final String BM_IDs) throws Exception {
			List ClassMasterList=null;
			try {
				ClassMasterList = (List) getHibernateTemplate().execute(
						new HibernateCallback() {
							public Object doInHibernate(Session session)throws HibernateException, SQLException {
								String qu= "select cm_id,class_name from class_master where cm_id in(select cm_id  from class_branch_map where Active='Y' and bm_id in ("+BM_IDs+"))";
							//	System.out.println("in getMultiClassMasterList DAOIMPL*&"+qu);
								SQLQuery sqlqu = session.createSQLQuery(qu);							
								sqlqu.addScalar("cm_id", new StringType());
								sqlqu.addScalar("class_name", new StringType());
								System.out.println("in SIZE"+sqlqu.list().size());
								return sqlqu.list();
							}
						});
			} catch (Exception ex_) {
				ex_.printStackTrace();
				return null;
			}
			return ClassMasterList;
		}	
		
		
	@Override
	public ClassMaster findById(java.lang.Long id) throws Exception {
		try {
			System.out.println("in classmaster impl findbyid");
			ClassMaster instance = (ClassMaster) getHibernateTemplate().get("com.schooltrix.hibernate.ClassMaster", id);
			return instance;
		} catch (Exception re) {
			throw re;
		}
	}

	@Override
	public List findAll() throws Exception {
		try {
			String queryString = "from ClassMaster";
			return getHibernateTemplate().find(queryString);
		} catch (Exception re) {
			re.printStackTrace();
			return null;
		}
	}
	//-------------------------------------------------------------------
	@Override
	public boolean save(SubjectMaster transientInstance) throws Exception {
		System.out.println("in SubjectMasterDAOImpl");
			getHibernateTemplate().saveOrUpdate(transientInstance);
			System.out.println("in saveee");
			return true;
		
	}
	@Override
	public boolean update(SubjectMaster transientInstance) throws Exception {
		try {
			getHibernateTemplate().update(transientInstance);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean delete(SubjectMaster persistentInstance) throws Exception {
		try {
			getHibernateTemplate().delete(persistentInstance);
			return true;
		} catch (Exception re) {
			re.printStackTrace();
			return false;
		}
	}
	@Override
	public SubjectMaster findBySubjectMasterProperty(final String filed,final String value) throws Exception {
		try {
			return (SubjectMaster) getHibernateTemplate().execute(
					new HibernateCallback() {
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException{							
							Criteria isExpiredCrit = session.createCriteria(SubjectMaster.class);
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
	public List findBySubjectMasterPropertyList(final String filed,final String value) throws Exception {
		List SubjectMasterList=null;
		try {
			SubjectMasterList = (List) getHibernateTemplate().execute(
					new HibernateCallback() {
						public Object doInHibernate(Session session)throws HibernateException, SQLException {
							Criteria crit = session.createCriteria(SubjectMaster.class);
							crit.add(Restrictions.eq(filed, value));
							//crit.addOrder(Order.desc("sno"));
							return crit.list();
						}
					});
		} catch (Exception ex_) {
			ex_.printStackTrace();
			return null;
		}
		return SubjectMasterList;
	}
	
	@Override
	public SubjectMaster findBySubjectMasterId(java.lang.Long id) throws Exception {
		try {
			System.out.println("in SubjectMaster impl findbyid");
			SubjectMaster instance = (SubjectMaster) getHibernateTemplate().get("com.schooltrix.hibernate.SubjectMaster", id);
			return instance;
		} catch (Exception re) {
			throw re;
		}
	}

	@Override
	public List findAllSubjectMaster() throws Exception {
		try {
			String queryString = "from SubjectMaster";
			return getHibernateTemplate().find(queryString);
		} catch (Exception re) {
			re.printStackTrace();
			return null;
		}
	}
	
//requirement based methodsssssssssssssssssssssss
		@Override
		public List getSubjectMasterList(String IM_ID,final String BM_ID, String SM_ID,final String CM_ID) throws Exception {
			List SubjectMasterList=null;
			try {
				System.out.println("in getSubjectMasterList DAOIMPL---"+BM_ID+"---"+CM_ID);
				SubjectMasterList = (List) getHibernateTemplate().execute(
						new HibernateCallback() {
							public Object doInHibernate(Session session)throws HibernateException, SQLException {//need more where condtion im_id sm_id
								//String qu= "select class_name from subject_master where cm_id in(select cm_id  from class_branch_map where Active='Y' and bm_id='"+BM_ID+"')";
								String qu = "";
								if(CM_ID.equalsIgnoreCase("0")){
									qu="SELECT subm_id,sub_name FROM subject_MASTER where subm_id in " +
											"(SELECT subm_id FROM subject_class_map where cm_id in " +
											"(select cm_id  from class_branch_map where Active='Y' and bm_id='"+BM_ID+"'))";									
								}else{								
								 qu="SELECT subm_id,sub_name FROM subject_MASTER where subm_id in (SELECT subm_id FROM subject_class_map where cm_id='"+CM_ID+"')";
								}
								
								SQLQuery sqlqu = session.createSQLQuery(qu);							
								sqlqu.addScalar("subm_id", new StringType());
								sqlqu.addScalar("sub_name", new StringType());
								System.out.println("in SIZE"+sqlqu.list().size());
								return sqlqu.list();
							}
						});
			} catch (Exception ex_) {
				ex_.printStackTrace();
				return null;
			}
			return SubjectMasterList;
		}
	
		@Override
		public List getMultiSubjectMasterList(String IM_ID,String SM_ID,final String BM_IDs, final String CM_IDs) throws Exception {
			List SubjectMasterList=null;
			try {
				//System.out.println("in getSubjectMasterList DAOIMPL---"+BM_IDs+"---"+CM_IDs);
				SubjectMasterList = (List) getHibernateTemplate().execute(
						new HibernateCallback() {
							public Object doInHibernate(Session session)throws HibernateException, SQLException {//need more where condtion im_id sm_id
								//String qu= "select class_name from subject_master where cm_id in(select cm_id  from class_branch_map where Active='Y' and bm_id='"+BM_ID+"')";
								String qu = "";
								 qu="SELECT sub_name, subm_id FROM subject_MASTER where subm_id in (SELECT subm_id FROM subject_class_map where cm_id in ("+CM_IDs+"))" +
								 		"and bm_id in("+BM_IDs+") group by sub_name ";
								
								SQLQuery sqlqu = session.createSQLQuery(qu);							
								sqlqu.addScalar("sub_name", new StringType());
								sqlqu.addScalar("subm_id", new StringType());
								System.out.println("in SIZE"+sqlqu.list().size());
								return sqlqu.list();
							}
						});
			} catch (Exception ex_) {
				ex_.printStackTrace();
				return null;
			}
			return SubjectMasterList;
		}
	
		
		
		@Override
		public boolean saveClassBranchMap(ClassBranchMap transientInstance) throws Exception {
			System.out.println("in ClassMasterDAOImpl---ClassBranchMap");
				getHibernateTemplate().saveOrUpdate(transientInstance);
				System.out.println("in saveee");
				return true;
			
		}
		
	
}