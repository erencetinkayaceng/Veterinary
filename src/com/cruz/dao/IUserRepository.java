package com.cruz.dao;

import java.util.List;

import com.cruz.model.User;

public interface IUserRepository {
	User saveUser(User user);

	void deleteUser(int id);

	User updateUser(User user);

	User findUserById(int id);

	User findUserByUserName(String userName);

	List<User> findAllUserByName(String name);
}
