package user.bo;

public class UserBo {

	private String name,email,phon,dob,city;

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhon() {
		return phon;
	}

	public void setPhon(String phon) {
		this.phon = phon;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	@Override
	public String toString() {
		return "UserBo [email=" + email + ", phon=" + phon + ", dob=" + dob + ", city="
				+ city + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserBo(String name, String email, String phon, String dob, String city) {
		super();
		this.name = name;
		this.email = email;
		this.phon = phon;
		this.dob = dob;
		this.city = city;
	}

	public UserBo() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

}
