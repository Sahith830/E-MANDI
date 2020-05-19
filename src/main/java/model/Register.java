package model;

public class Register {

		public String userName;
		public String email;
		public String password;
		public String confirmPassword;
		public String mobile;
		Register(){}
		public Register(String userName, String email, String password, String confirmPassword, String mobile) 
		{
			this.userName = userName;
			this.email = email;
			this.password = password;
			this.confirmPassword = confirmPassword;
			this.mobile = mobile;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getConfirmPassword() {
			return confirmPassword;
		}

		public void setConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
		}

		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
	}

