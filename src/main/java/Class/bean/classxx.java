package Class.bean;

public class classxx {
    private String ClassName;
    private String TName;
    private int APnumber;
    private int PhoneNumber;
    private int ClassNumber;
    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String ClassName) {
        this.ClassName = ClassName;
    }
    public String getTName() {
        return TName;
    }

    public void setTName(String TName) {
        this.TName = TName;
    }

    public int getAPnumber() {
        return APnumber;
    }
    public int getPhoneNumber() {
        return PhoneNumber;
    }
    public int getClassNumber() {
        return ClassNumber;
    }
    public void setPhoneNumber(int PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }
    public void setAPnumber(int APnumber) {
        this.APnumber = APnumber;
    }
    public void setClassNumber(int ClassNumber) {
        this.ClassNumber = ClassNumber;
    }
    
    public classxx(String ClassName, int APnumber,int ClassNumber) {
        this.ClassName = ClassName;
        this.APnumber = APnumber;
        this.ClassNumber = ClassNumber;
    }

    public classxx() {
    }

    public classxx(String ClassName, int ClassNumber) {
    	this.ClassName = ClassName;
    	this.ClassNumber = ClassNumber;
    }
}
