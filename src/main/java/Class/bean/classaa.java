package Class.bean;

public class classaa {
	private String ClassName;
	private int ClassNumber;
	private int APnumber;
	private String TName;
	private int PhoneNumber;
	 public classaa() {
		
	}
	public classaa(String ClassName,int ClassNumber,int APnumber) {
		this.ClassName=ClassName;
		this.ClassNumber=ClassNumber;
		this.APnumber=APnumber;
	}
	public classaa(int PhoneNumber,String TName) {
		this.PhoneNumber=PhoneNumber;
		this.TName=TName;
	}
	public String getClassName() {
		return ClassName;
	}
	public void setClassName(String ClassName) {
		this.ClassName=ClassName;
	}
	public int getClassNumber() {
		return ClassNumber;
	}
	public void setClassNumber(int ClassNumber) {
		this.ClassNumber=ClassNumber;
	}
	public int getAPnumber() {
		return APnumber;
	}
	public void setAPnumber(int APnumber) {
		this.APnumber=APnumber;
	}
	public String getTName() {
		return TName;
	}
	public void setTName(String TName) {
		this.TName=TName;
	}
	public int getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(int PhoneNumber) {
		this.PhoneNumber=PhoneNumber;
	}
	
}
