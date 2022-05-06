package userdata;

public class Logindata {
	
	private String email;
	private String password;
	
	
	public String getEmail() {
		System.out.println("Email is :" + email);
		return email;
	}
	public String getPassword() {
		System.out.println("Pass is :" + password);
		return password;
	}
	public void setPassword(String password) {
		System.out.println("password for Set:" + password);
		this.password = password;
	}
	public void setEmail(String email) {
		System.out.println("Email for Set:" + email);
		this.email = email;
	}

}
