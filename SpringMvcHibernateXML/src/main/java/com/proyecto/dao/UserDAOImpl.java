package com.proyecto.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.model.User;

public class UserDAOImpl implements UserDAO {
	private SessionFactory sessionFactory;
	

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<User> list() {
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) sessionFactory.getCurrentSession()
				.createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listUser;
	}

	@Override
	@Transactional
	public void saveorUpdateUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		
	}

	@Override
	@Transactional
	public void deleteUser(int idUser) {
		
		User user=(User) sessionFactory.getCurrentSession().load(User.class, idUser);
		if(user!=null) {
			this.sessionFactory.getCurrentSession().delete(user);
		}
	}

	@Override
	@Transactional
	public User getIdUser(int idUser) {
//		User user=(User) sessionFactory.getCurrentSession().load(User.class, idUser);
		  String hql = "from User where id=" + idUser;
	        Query query = sessionFactory.getCurrentSession().createQuery(hql);
	         
	        @SuppressWarnings("unchecked")
	        List<User> listUser = (List<User>) query.list();
	         
	        if (listUser != null && !listUser.isEmpty()) {
	            return listUser.get(0);
	        }
	         
	        return null;
		
	}

}
