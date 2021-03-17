package com.hello.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hello.dao.UserDao;
import com.hello.domain.User;

@Transactional
@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public User getUserById(Integer id) {
		return userDao.getUserById(id);
	}

//	public List<User> getAllUser() {
//		return userDao.findAll();
//	}

	public void save(User user) {
//		userDao.save(user);
		userDao.saveOrUpdate(user);
	}

	public void update(User user) {
//		userDao.update(user);
		userDao.saveOrUpdate(user);
	}

	public void delete(Integer id) {
		Optional.ofNullable(userDao.getUserById(id)).ifPresent(userDao::delete);
	}

	public Map<String, Object> getUsers(int pageNO, int pageSize, Map<String, Object> params) {
		return userDao.getUsers(pageNO, pageSize, params);
	}

}
