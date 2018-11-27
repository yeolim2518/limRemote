package egovframework.example.excel.service;

public class ExcelVO {

	private String name;
	private int age;
	private double avg;
	private char school;
	private long classNum;
	private byte family;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public char getSchool() {
		return school;
	}
	public void setSchool(char school) {
		this.school = school;
	}
	public long getClassNum() {
		return classNum;
	}
	public void setClassNum(long classNum) {
		this.classNum = classNum;
	}
	public byte getFamily() {
		return family;
	}
	public void setFamily(byte family) {
		this.family = family;
	}
	@Override
	public String toString() {
		return "ExcelVO [name=" + name + ", age=" + age + ", avg=" + avg + ", school=" + school + ", classNum="
				+ classNum + ", family=" + family + "]";
	}
	
	
}
