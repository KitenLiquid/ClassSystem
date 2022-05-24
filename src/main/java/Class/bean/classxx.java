package Class.bean;
import java.util.Arrays;

public class classxx {
    private String ClassName;
    private int APnumber;
    private int ClassNumber;
    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String ClassName) {
        this.ClassName = ClassName;
    }

    public int getAPnumber() {
        return APnumber;
    }
    public int getClassNumber() {
        return ClassNumber;
    }
    public void setAPnumber(int APnumber) {
        this.APnumber = APnumber;
    }
    public void setClassNumber(int ClassNumber) {
        this.ClassNumber = ClassNumber;
    }

    @Override
    public String toString() {
        return "Class{" +
                "ClassName='" + ClassName + '\'' +
                 ", APnumber='" + APnumber + '\'' +
                ", ClassNumber='" + ClassNumber + '\'' +
                '}';
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
