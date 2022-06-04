package Class;
public class Teacher {
	private String TName;
	private String ClassNumber;
	private String PhoneNumber;
	public Teacher() {
		
	}
	public Teacher(String TName,String ClassNumber,String PhoneNumber) {
		this.TName=TName;
		this.ClassNumber=ClassNumber;
		this.PhoneNumber=PhoneNumber;
	}
	public String getClassNumber() {
		return ClassNumber;
	}
	public void setClassNumber(String ClassNumber) {
		this.ClassNumber=ClassNumber;
	}
	public String getTName() {
		return TName;
	}
	public void setTName(String TName) {
		this.TName=TName;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String PhoneNumber) {
		this.PhoneNumber=PhoneNumber;
	}
}
