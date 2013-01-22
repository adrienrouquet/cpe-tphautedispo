package objects;

public class User {
	private String firstName = "";
	private String lastName = "";
	private Integer yearOfBirth = 0;
	private String email = "";
	private String login = "";
	private String password = "";
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setYearOfBirth(Integer yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Integer getYearOfBirth() {
		return yearOfBirth;
	}
	public String getEmail() {
		return email;
	}
	public String getLogin() {
		return login;
	}
	public String getPassword() {
		return password;
	}
	
}
