package Class.bean;

public class Student {
    private int  ClassNumber;
    private String Name;
    private int Number;
    private String Sex;
    private int Age;
    private String ClassName;
    public Student() {
    	
    }
    public Student(int ClassNumber,String Name,int Number,String Sex,int Age) {
    	this.Name=Name;
    	this.Number=Number;
    	this.ClassNumber=ClassNumber;
    	this.Sex=Sex;
    	this.Age=Age;
    }
    
    public Student(String Name,int Number) {
    	this.Name=Name;
    	this.Number=Number;
    }
    public Student(int Number,int ClassNumber) {
    	this.Number=Number;
    	this.ClassNumber=ClassNumber;
    }
    public int getClassNumber() {
    	return ClassNumber;
    }
    public void setClassNumber(int ClassNumber) {
    	this.ClassNumber=ClassNumber;
    }
    public String getClassName() {
    	return ClassName;
    }
    public void setClassName(String ClassName) {
    	this.ClassName=ClassName;
    }
    public String getName() {
    	return Name;
    }
    public void setName(String Name) {
    	this.Name=Name;
    }
    public int getNumber() {
    	return Number;
    }
    public void setNumber(int Number) {
    	this.Number=Number;
    }
    public String getSex() {
    	return Sex;
    }
    public void setSex(String Sex) {
    	this.Sex=Sex;
    }
    public int getAge() {
    	return Age;
    }
    public void setAge(int Age) {
    	this.Age=Age;
    }
}
