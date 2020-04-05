package relationships.association;



public class Person {
	private Phone homePhone, officePhone;

	public Phone getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(Phone homePhone) {
		this.homePhone = homePhone;
	}

	public Phone getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(Phone officePhone) {
		this.officePhone = officePhone;
	}
	
}
