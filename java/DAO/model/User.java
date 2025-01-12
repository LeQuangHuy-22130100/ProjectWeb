package DAO.model;

public class User {
	private int id;
	private String name;
	private String password;
	private String email;
	private String phone;
	private String address;
	private int isAdmin;
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "id: " + id + " name: " + name + ", password: " + password + ", email: " + email + ", phone: "
				+ phone + ", address: " + address + ", isAdmin: " + isAdmin;
	}
	
}
