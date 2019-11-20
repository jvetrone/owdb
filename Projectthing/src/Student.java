import java.io.Serializable;
public class Student implements Serializable
{
	private int studentID;
	private String studentName;
	private double studentGPA;
	private double mathGrade;
	private boolean isDeansList;
	private boolean isTutor;
	Student()
	{
		studentID = 700000000;
		studentName = " ";
		studentGPA = 0.0;
		mathGrade = 0.0;
		isDeansList = false;
		isTutor = false;
	}
	Student(int sid, String name, double gpa, double math, boolean dean, boolean tutor)
	{
		studentID = sid;
		studentName = name;
		studentGPA = gpa;
		mathGrade = math;
		isDeansList = dean;
		isTutor = tutor;
		
	}
	public int getID()
	{
		return studentID;
	}
	public String getName()
	{
		return studentName;
	}
	public double getGPA()
	{
		return studentGPA;
	}
	public double getMath()
	{
		return mathGrade;
	}
	public boolean isDeansList()
	{
		return isDeansList;
	}
	public boolean isTutor()
	{
		return isTutor;
	}
	public void setTutor(boolean answer)
	{
		isTutor = answer;
	}
	@Override
	public String toString()
	{
		String str = "";
		if(isTutor() == true)
			str = "Name: "+getName()+" Student ID: "+getID()+" GPA: "+getGPA()+" TUTOR\n";
		else str = "Name: "+getName()+" Student ID: "+getID()+" GPA: "+getGPA()+"\n";
		return str;
	}
}
