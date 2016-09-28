package cn.sya.bbs.service;

import java.io.Serializable;

import cn.sya.bbs.entity.User;

public interface UserService extends Serializable {
	User register(String name,String password,String mobile)throws ServiceException;
	User login(String name ,String password)throws NameOrPasswordException;
}
