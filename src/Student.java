import java.io.Serializable;
public class Student implements Serializable //allows the object to be written in the form of bytes and read from a text file kind of like save data
{
	private int studentID; //unique identifier that the search function uses
	private String studentName;
	private double studentGPA; //must be at least 3.25 to be a tutor
	private double mathGrade; //must be at least 80 to be a tutor
	private boolean isDeansList; //must be true to be a tutor
	private boolean tutorRQ; //classifies student as applied or not
	private boolean isTutor; //classifies student as tutor or not
	Student()
	{
		studentID = 700000000;
		studentName = " ";
		studentGPA = 0.0;
		mathGrade = 0.0;
		isDeansList = false;
		tutorRQ = false;
		isTutor = false;
	}
	Student(int sid, String name, double gpa, double math, boolean dean)
	{
		//tutorRQ and isTutor are not here because every tutor is a student that applied to become a tutor
		studentID = sid;
		studentName = name;
		studentGPA = gpa;
		mathGrade = math;
		isDeansList = dean;
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
	public boolean isTutorRQ()
	{
		return tutorRQ;
	}
	public void setTutorRQ(boolean answer) //marks student as applied
	{
		tutorRQ = answer;
	}
	public void applyTutor() //used as a check to see if the student meets the requirements to become a tutor
	{
		if(isDeansList() == true && getGPA() >= 3.25 && getMath() >= 80)
		idDatabase.applyTutor(getID());
		else System.out.println("You do not meet the requirements to be a tutor.");
	}
	public boolean isTutor()
	{
		return isTutor;
	}
	public void setTutor(boolean answer) //used to accept tutor
	{
		isTutor = answer;
	}
	@Override
	public String toString()
	{
		String str = "";
		if(isTutor() == true) //used to differentiate tutors from students
			str = "Name: "+getName()+" Student ID: "+getID()+" GPA: "+getGPA()+" TUTOR\n";
		else str = "Name: "+getName()+" Student ID: "+getID()+" GPA: "+getGPA()+"\n";
		return str;
	}
}
