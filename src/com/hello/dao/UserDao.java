package com.hello.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.hello.domain.User;

@Repository
@SuppressWarnings({"unchecked", "serial", "rawtypes"})
public class UserDao extends BaseDao {

	public User getUserById(Integer id) {
		return getSession().get(User.class, id);
	}

	public Map<String, Object> getUsers(int pageNO, int pageSize, Map<String, Object> params) {		
		String hql = "FROM User ";
		Query query = getSession().createQuery(hql);
		int count = query.getResultList().size();
		
		List<User> users = query.setFirstResult((pageNO - 1)*pageSize).setMaxResults(pageSize).getResultList();
		return new HashMap<String, Object>(){
			{
				put("rows", users);
				put("total", count);
			}
		};
	}

	public void save(User user) {
		getSession().save(user);
	}

	public void update(User user) {
		getSession().update(user);
	}

	public void saveOrUpdate(User user) {
		getSession().saveOrUpdate(user);
	}

	public void delete(User user) {
		getSession().delete(user);
	}

}
