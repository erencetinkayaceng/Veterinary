package com.cruz.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.cruz.dao.IUserRepository;
import com.cruz.dao.impl.UserRepository;
import com.cruz.model.User;

@ManagedBean
@SessionScoped
public class UserManagedBean {

	private User user;
	private IUserRepository userRepository;

	public UserManagedBean() {
		user = new User();
		userRepository = new UserRepository();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String save(UserManagedBean umb) {
		userRepository.saveUser(umb.getUser());
		return "index?faces-redirect=true";
	}

	public String update(int id) {
		user = userRepository.findUserById(id);
		return "editUser?faces-redirect=true";
	}

	public String update(UserManagedBean umb) {
		userRepository.updateUser(umb.getUser());
		return "index?faces-redirect=true";
	}

	public String delete(int id) {
		userRepository.deleteUser(id);
		return "index?faces-redirect=true";
	}

}
