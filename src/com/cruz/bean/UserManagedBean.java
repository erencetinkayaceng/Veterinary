package com.cruz.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.cruz.dao.IUserRepository;
import com.cruz.dao.impl.UserRepository;
import com.cruz.model.User;
import com.cruz.model.UserRole;
import com.cruz.util.EncryptPasswordUtil;
import com.cruz.util.SessionUtils;

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
		User u = umb.getUser();
		u.setRole(UserRole.standartRole);
		String encryptpwd = EncryptPasswordUtil.encrypt(u.getPassword());
		if (!encryptpwd.equals("error")) {
			u.setPassword(encryptpwd);
		} else {
			return "newUser?faces-redirect=true";
		}
		userRepository.saveUser(u);
		return "/secured/home?faces-redirect=true";
	}

	public String update(int id) {
		user = userRepository.findUserById(id);
		return "/secured/editUser?faces-redirect=true";
	}

	public String update(UserManagedBean umb) {
		userRepository.updateUser(umb.getUser());
		return "/secured/home?faces-redirect=true";
	}

	public String delete(int id) {
		if (SessionUtils.getRole().equals("adminRole")) {
			userRepository.deleteUser(id);
		}
		return "/secured/home?faces-redirect=true";
	}

}
