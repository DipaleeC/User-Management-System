package user.bo;

public class UserAddBo {

	private int id;
	private String name,email,city,dob;
	private String phon;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public UserAddBo(int id, String name, String email, String phon,String dob, String city) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phon=phon;
		this.city = city;
		this.dob = dob;
	}
	public UserAddBo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPhon() {
		// TODO Auto-generated method stub
		return phon;
	}
	public void setPhon(String phon) {
		this.phon=phon;
	}
	
}
