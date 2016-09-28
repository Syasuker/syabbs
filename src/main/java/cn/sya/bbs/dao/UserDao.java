package cn.sya.bbs.dao;

import cn.sya.bbs.entity.User;

public interface UserDao {
	void saveUser(User user);
	void updataUser(User user);
	void deleteUser(String id);
	User findUserById(String id);
	User findUserByName(String name);
}
