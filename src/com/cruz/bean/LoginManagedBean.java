package com.cruz.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.cruz.dao.IUserRepository;
import com.cruz.dao.impl.UserRepository;
import com.cruz.model.User;
import com.cruz.util.SessionUtils;

@ManagedBean
@SessionScoped
public class LoginManagedBean {

	private User user;
	private String username;
	private String password;
	private IUserRepository userRepository;

	public LoginManagedBean() {
		user = new User();
		userRepository = new UserRepository();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String validateUserLogin() {

		try {
			user = userRepository.findUserByUserName(username);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Incorrect Username and Passowrd", "Please enter correct username and Password"));
			return "index?faces-redirect=true";
		}

		if (username.equalsIgnoreCase(user.getUsername()) && password.equals(user.getPassword())) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", user.getUsername());
			session.setAttribute("userid", user.getId());
			session.setAttribute("userrole", user.getRole());
			return "secured/home?faces-redirect=true";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Incorrect Username and Passowrd", "Please enter correct username and Password"));
			return "index?faces-redirect=true";
		}
	}

	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "/index?faces-redirect=true";
	}
}
