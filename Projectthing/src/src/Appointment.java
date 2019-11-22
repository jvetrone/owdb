import java.io.Serializable;
public class Appointment implements Serializable
{
	//private double timeDate;
	private int month;
	private int day;
	private int time;
	private boolean approval;
	private int rqID; //the SID of the requester
	private int tutorID; //the SID of the tutor
	Appointment()
	{
		month = 1;
		day = 1;
		time = 9;
		approval = false;
		rqID = 700700000;
		tutorID = 700700001;
	}
	Appointment(int uMonth, int uDay, int uTime, int uRQID, int uTutorID)
	{
		month = uMonth;
		day = uDay;
		time = uTime;
		rqID = uRQID;
		tutorID = uTutorID;
	}
	public int getMonth()
	{
		return month;
	}
	public int getDay()
	{
		return day;
	}
	public int getTime()
	{
		return time;
	}
	public boolean getApproval()
	{
		return approval;
	}
	public void setApproval(boolean answer)
	{
		approval = answer;
	}
	public int getRQID()
	{
		return rqID;
	}
	public int getTutorID()
	{
		return tutorID;
	}
	public String toString()
	{
		String str = "Date: "+getMonth()+"/"+getDay()+"\n"+"Time: "+getTime()+":00 - "+getTime()+1+":00\n"+"Tutor ID: "+getTutorID()+"\nStudent ID: "+getRQID();
		if(getApproval() == true)
			str = str + " APPROVED";
		return str;
	}
}
