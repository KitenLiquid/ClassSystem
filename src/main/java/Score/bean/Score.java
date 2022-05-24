package Score.bean;

public class Score {
	private String Score;//分数
	private String Number;//学号
	private String ClassNumber;//课程号
	private String ClassName;//课程名
	
	public Score() {}
	public Score(String score, String number, String classNumber,String ClassName) {
		super();
		this.Score = score;
		this.Number = number;
		this.ClassNumber = classNumber;
		this.ClassName=ClassName;
	}
	public String getScore() {
		return Score;
	}

	public void setScore(String score) {
		this.Score = score;
	}

	public String getNumber() {
		return Number;
	}

	public void setNumber(String number) {
		this.Number = number;
	}
	
	public String getClassNumber() {
		return ClassNumber;
	}

	public void setClassNumber(String classNumber) {
		this.ClassNumber = classNumber;
	}

	public String getClassName() {
		return ClassName;
	}

	public void setClassName(String className) {
		this.ClassName = className;
	}
}
