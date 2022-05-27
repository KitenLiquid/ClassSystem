package Score.bean;

public class ScoreBean {
	private int Score;//分数
	private int Number;//学号
	private int ClassNumber;//课程号
	private String ClassName;//课程名
	private int APnumber;//人数
	
	public ScoreBean() {}
	public ScoreBean(int score, int number, int classNumber) {
		super();
		this.Score = score;
		this.Number = number;
		this.ClassNumber = classNumber;
	}
	public ScoreBean(String className,int classNumber)
	{
		this.ClassName=className;
		this.ClassNumber=classNumber;
	}
	public ScoreBean(int score, int number, int classNumber,String className,int APnumber) {
		super();
		this.Score = score;
		this.Number = number;
		this.ClassNumber = classNumber;
		this.ClassName=className;
		this.APnumber=APnumber;
	}
	public ScoreBean(String ClassName,int ClassNumber,int APnumber)
	{
		this.ClassName=ClassName;
		this.ClassNumber=ClassNumber;
		this.APnumber=APnumber;
	}
	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		this.Score = score;
	}

	public int getNumber() {
		return Number;
	}

	public void setNumber(int number) {
		this.Number = number;
	}
	
	public int getClassNumber() {
		return ClassNumber;
	}

	public void setClassNumber(int classNumber) {
		this.ClassNumber = classNumber;
	}

	public String getClassName() {
		return ClassName;
	}

	public void setClassName(String className) {
		this.ClassName = className;
	}
	public int getAPnumber() {
		return APnumber;
	}
	public void setAPnumber(int APnumber) {
		this.APnumber = APnumber;
	}
}
