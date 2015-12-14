package store.model;

public class Customer extends Users {

	private int id; 
	private String fullname; 
	private String emailid;
	
	private int phonenumber;
	private String city;

	
	public Customer() {
	}
//parameterized constructor
	public Customer(int id, String name, String emailid, String pswd, int number, String city) {
		this.id = id;
		this.fullname = name;
		this.emailid = emailid;
		this.phonenumber = number;
		this.city = city;
	}

	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public int getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}




}