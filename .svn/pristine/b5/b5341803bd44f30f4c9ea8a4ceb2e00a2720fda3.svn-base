package com.schooltrix.daos;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StringType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.schooltrix.hibernate.ParentStudentMap;
import com.schooltrix.hibernate.StudentDetails;
import com.schooltrix.hibernate.StudentDetails;
import com.schooltrix.hibernate.StudentDetails;
import com.schooltrix.hibernate.StudentSectionMap;
import com.schooltrix.hibernate.StudentxlErrorTemp;
import com.sun.istack.internal.FinalArrayList;

public class StudentDetailsDAOImpl extends STHibernateDAOSupport implements StudentDetailsDAO{
	
	@Override
	public boolean save(StudentDetails transientInstance) throws Exception {
		
			getHibernateTemplate().saveOrUpdate(transientInstance);
			System.out.println("in saveee");
			return true;
		
	}
	@Override
	public boolean update(StudentDetails transientInstance) throws Exception {
		try {
			getHibernateTemplate().update(transientInstance);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean delete(StudentDetails persistentInstance) throws Exception {
		try {
			getHibernateTemplate().delete(persistentInstance);
			return true;
		} catch (Exception re) {
			re.printStackTrace();
			return false;
		}
	}
	@Override
	public StudentDetails findByProperty(final String filed,final String value) throws Exception {
		try {
			return (StudentDetails) getHibernateTemplate().execute(
					new HibernateCallback() {
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException{							
							Criteria isExpiredCrit = session.createCriteria(StudentDetails.class);
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
	public StudentDetails findByProperty(final String filed,final Long value) throws Exception {
		try {
			return (StudentDetails) getHibernateTemplate().execute(
					new HibernateCallback() {
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException{							
							Criteria isExpiredCrit = session.createCriteria(StudentDetails.class);
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
		List StudentDetailsList=null;
		try {
			StudentDetailsList = (List) getHibernateTemplate().execute(
					new HibernateCallback() {
						public Object doInHibernate(Session session)throws HibernateException, SQLException {
							Criteria crit = session.createCriteria(StudentDetails.class);
							crit.add(Restrictions.eq(filed, value));
							//crit.addOrder(Order.desc("sno"));
							return crit.list();
						}
					});
		} catch (Exception ex_) {
			ex_.printStackTrace();
			return null;
		}
		return StudentDetailsList;
	}
	
	
	
	@Override
	public StudentDetails findById(java.lang.Long id) throws Exception {
		try {
			StudentDetails instance = (StudentDetails) getHibernateTemplate().get("com.schooltrix.hibernate.StudentDetails", id);
			return instance;
		} catch (Exception re) {
			throw re;
		}
	}

	@Override
	public List findAll() throws Exception {
		try {
			String queryString = "from StudentDetails";
			return getHibernateTemplate().find(queryString);
		} catch (Exception re) {
			re.printStackTrace();
			return null;
		}
	}
	@Override
	public boolean saveStudentParentMap(ParentStudentMap transientInstance)
			throws Exception {
		// TODO Auto-generated method stub

		getHibernateTemplate().save(transientInstance);
		System.out.println("in saveee");
		return false;
	}
	@Override
	public boolean insertStudentSectionMap(StudentSectionMap ssm) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(ssm);
		System.out.println("in saveee");
		return true;
	}
	@Override
	public boolean insertStudentErrorLog(StudentxlErrorTemp setemp) throws Exception{
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(setemp);
		return true;
	}

	@Override
	public int deleteStudentErrorLog(final String um_id) throws Exception {

		
		Integer deletedData = (Integer)getHibernateTemplate().execute(new HibernateCallback () {
		    public Object doInHibernate(Session session) throws HibernateException, SQLException {
		        // delete the data
		    	Query hqlQuery = session.createQuery("DELETE FROM StudentxlErrorTemp WHERE umId=?");
		    	hqlQuery.setString(0, um_id);
		        int updated = hqlQuery.executeUpdate();
		        return updated;
		    }
		});
		
				return 0;
	}
	
	@Override
	public List getStudentErrorLog(final String um_id) throws Exception{
		// TODO Auto-generated method stub
	
		List StudentDetailsList=null;
		try {
			System.out.println("in getStudentErrorLog-----"+um_id);
			StudentDetailsList = (List) getHibernateTemplate().execute(
					new HibernateCallback() {
						public Object doInHibernate(Session session)throws HibernateException, SQLException {
							Criteria crit = session.createCriteria(StudentxlErrorTemp.class);
							crit.add(Restrictions.eq("umId", um_id));
							//crit.addOrder(Order.desc("sno"));
							System.out.println(crit.list().size()+"^^^^^^^^");
							return crit.list();
						}
					});
		} catch (Exception ex_) {
			ex_.printStackTrace();
			return null;
		}
		return StudentDetailsList;
	
	}
	
}