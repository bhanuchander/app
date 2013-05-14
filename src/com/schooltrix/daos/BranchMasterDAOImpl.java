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

import com.schooltrix.hibernate.BranchMaster;
import com.schooltrix.hibernate.SchoolMaster;

public class BranchMasterDAOImpl extends STHibernateDAOSupport implements BranchMasterDAO{
	
	@Override
	public boolean save(BranchMaster transientInstance) throws Exception {
		
			getHibernateTemplate().saveOrUpdate(transientInstance);
			System.out.println("in saveee");
			return true;
		
	}
	@Override
	public boolean update(BranchMaster transientInstance) {
		try {
			getHibernateTemplate().update(transientInstance);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean delete(BranchMaster persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
			return true;
		} catch (Exception re) {
			re.printStackTrace();
			return false;
		}
	}
	@Override
	public BranchMaster findByProperty(final String filed,final String value) {
		try {
			return (BranchMaster) getHibernateTemplate().execute(
					new HibernateCallback() {
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException{							
							Criteria isExpiredCrit = session.createCriteria(BranchMaster.class);
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
	public List findByPropertyList(final String filed,final String value) {
		List BranchMasterList=null;
		try {
			BranchMasterList = (List) getHibernateTemplate().execute(
					new HibernateCallback() {
						public Object doInHibernate(Session session)throws HibernateException, SQLException {
							Criteria crit = session.createCriteria(BranchMaster.class);
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
		return BranchMasterList;
	}
	
	@Override
	public List getBranchList(final String filed,final String value,final String filed1,final Long value1) {
		List branchMasterList=null;
		try {
			branchMasterList = (List) getHibernateTemplate().execute(
					new HibernateCallback() {
						public Object doInHibernate(Session session)throws HibernateException, SQLException {
							Criteria crit = session.createCriteria(BranchMaster.class);
							crit.add(Restrictions.eq(filed, value));
							crit.add(Restrictions.eq(filed1, value1));
							crit.add(Restrictions.eq("active", "Y"));
							//crit.addOrder(Order.desc("sno"));
							return crit.list();
						}
					});
		} catch (Exception ex_) {
			ex_.printStackTrace();
			return null;
		}
		return branchMasterList;
	}
	
	@Override
	public List getMultiBranchList(final String im_id,final String inQuery){
		
		List branchMasterList=null;
		try {
			//System.out.println("in branchMasterList DAOIMPL");
			branchMasterList = (List) getHibernateTemplate().execute(
					new HibernateCallback() {
						public Object doInHibernate(Session session)throws HibernateException, SQLException {
						
							String qu= "select BM_ID,Branch_Name from branch_master where IM_ID='"+im_id+"' and SM_ID in("+inQuery+") and Active='Y'";
							System.out.println("##"+qu);
							SQLQuery sqlqu = session.createSQLQuery(qu);							
							sqlqu.addScalar("BM_ID", new StringType());
							sqlqu.addScalar("Branch_Name", new StringType());
							System.out.println("in SIZE"+sqlqu.list().size());
							return sqlqu.list();
						}
					});
		} catch (Exception ex_) {
			ex_.printStackTrace();
			return null;
		}
		return branchMasterList;
	}
	
	
	@Override
	public BranchMaster findById(java.lang.Long id) {
		try {
			BranchMaster instance = (BranchMaster) getHibernateTemplate().get("com.schooltrix.hibernate.BranchMaster", id);
			return instance;
		} catch (Exception re) {
			throw re;
		}
	}

	@Override
	public List findAll() {
		try {
			String queryString = "from BranchMaster";
			return getHibernateTemplate().find(queryString);
		} catch (Exception re) {
			re.printStackTrace();
			return null;
		}
	}
}