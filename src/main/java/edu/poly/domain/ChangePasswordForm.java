package edu.poly.domain;

public class ChangePasswordForm {
	private String username;
	private String password;
	private String currentPassword;
	private String confirmPassword;
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
	public String getCurrentPassword() {
		return currentPassword;
	}
	public void setCurrentpPassword(String currentpPassword) {
		this.currentPassword = currentpPassword;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public ChangePasswordForm(String username, String password, String currentpPassword, String confirmPassword) {
		
		this.username = username;
		this.password = password;
		this.currentPassword = currentpPassword;
		this.confirmPassword = confirmPassword;
	}
	public ChangePasswordForm() {
		
	}
	
}
