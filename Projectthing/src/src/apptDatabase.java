import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class apptDatabase
{
	public static void writeFile(Appointment[] schedule) //saves the array of Appointments to a text file in the form of bytes
	{
	    try
	    {
	       FileOutputStream fos = new FileOutputStream("appt.txt"); //writes to appt no matter where writeFile is called
	       ObjectOutputStream oos = new ObjectOutputStream(fos);
	       oos.writeObject(schedule);
	       oos.close();
	       System.out.println("File Saved");
	    }
	    catch(Exception e) {
	        System.out.println("Error in output:" + e.toString());
	    }
	}
	public static void readFile(Appointment[] schedule) //loads the bytes from the file into an array
	{
	    try
	    {
	    	Appointment[] a; //a temporary array
	        FileInputStream fis = new FileInputStream("appt.txt"); //reads from appt no matter where readFile is called
	        ObjectInputStream ois = new ObjectInputStream(fis);
	        a = (Appointment[]) ois.readObject();
	        ois.close();
	        System.arraycopy(a, 0, schedule, 0, 200); //This line copies the database from the temp array to the array that is being used
	    }
	    catch(Exception e)
	    {
	        System.out.println("Error in output:" + e.toString());
	    }
	}
	public static void makeAppt(int ID) //for Student to add appointments to database with
	{
		Appointment[] schedule = new Appointment[200];
		readFile(schedule);
		Student s = new Student();
		Student[] stuList = new Student[200];
		Student[] tutors = new Student[200]; //an array that only students who are tutors will be put into
		idDatabase.readFile(stuList);
		int j = 0;
		int l = 0;
		int count = 0;
		int choose = 0;
		Scanner option = new Scanner(System.in);
		while(stuList[j] != null)
		{
			if(stuList[j].isTutor() == true)
			{
				count++;
				tutors[l] = stuList[j];
				System.out.println(count+". "+ tutors[l]);
				l++;
			}
			j++;
		}
		while(!(choose < 0)  && tutors != null)
		{
		System.out.println("Which do you want to make an appointment with? type 0 to exit or move on.");
		choose = option.nextInt();
		if(choose - 1 < 0) //subtracting from 1 is because the index in an array starts at 0 but the printed list starts at 1
			return;
		else
		{
			s = tutors[choose - 1];
			choose = -1;
		}
		}
		Scanner info = new Scanner(System.in);
		String choice = "A";
		int ctf = 0;
		while(ctf != 1)
		{
			int month = 0;
			int day = 0;
			int time = 0;
			while(month < 1 || month > 12)
			{
			System.out.println("Enter the month of your appointment: ");
			month = info.nextInt();
			}
			while(day < 1 || day > 31) //to make sure GPA is not too high or low
			{
			System.out.println("Enter the day of your appointment: ");
			day = info.nextInt();
			}
			while(time < 1 || time > 9) //to make sure math grade is not too high or low
			{
				System.out.println("Enter the time of your appointment: ");
				time = info.nextInt();
			}
			int i = 0;
			while(schedule[i] != null) //goes to the end of the list so an appointment can be added
			{
				i++;
			}
			schedule[i] = new Appointment(month, day, time, ID, s.getID());
			writeFile(schedule);
			System.out.println("Appointment made. Would you like to continue? Type N to stop");
			choice = info.nextLine();
			choice = info.nextLine();
			if(choice.equals("N") || choice.equals("n"))
				ctf = 1;
			else ctf = 0;
		}
	}
	public static void checkAppt(int ID)
	{
		int i = 0;
		int l = 0;
		int count = 0;
		int choice = 0;
		Appointment a = new Appointment();
		Scanner option = new Scanner(System.in);
		Appointment[] apptList = new Appointment[200];
		Appointment[] onlyTutor = new Appointment[200]; //an array that only students with tutorRQ as true will be put into
		readFile(apptList);
		while(apptList[i] != null)
		{
			if(apptList[i].getTutorID() == ID)
			{
				count++;
				onlyTutor[l] = apptList[i];
				System.out.println(count+". "+ onlyTutor[l]);
				l++;
			}
			i++;
		}
		while(!(choice < 0)  && onlyTutor != null)
		{
			System.out.println("Which do you want to check? type 0 to exit.");
			choice = option.nextInt();
			if(choice - 1 < 0) //subtracting from 1 is because the index in an array starts at 0 but the printed list starts at 1
				return;
			else
			{
				a = onlyTutor[choice - 1]; //gives appointment for approval/rejection
				choice = -1; //update value to exit while loop
			}
		}
		
		while(choice != 3)
		{
		System.out.println("What would you like to do with this appointment?\n1. Approve\n2. Reject\n3. Exit");
		choice = option.nextInt();
			if(choice == 1)
			{
				approveAppt(a);
				choice = 3;
			}
			if(choice == 2)
			{
				rejectAppt(a);
				choice = 3;
			}
		}
	}
	public static void approveAppt(Appointment a)
	{
		Appointment[] apptList = new Appointment[200];
		readFile(apptList);
		int i = 0;
		while(apptList[i] != null)
		{
			
			if(a == apptList[i])
			{
				apptList[i].setApproval(true);
			}
			i++;
		}
		writeFile(apptList);
	}
	public static void rejectAppt (Appointment a)
	{
		Appointment[] apptList = new Appointment[200];
		readFile(apptList);
		int i = 0;
		while(apptList[i] != null)
		{
			
			if(a.equals(apptList[i]))
			{
				apptList[i] = null;
			}
			i++;
		}
		writeFile(apptList);
	}
	public static void cancelAppt (int ID)
	{
		int i = 0;
		int l = 0;
		int count = 0;
		int choice = 0;
		Appointment a = new Appointment();
		Scanner option = new Scanner(System.in);
		Appointment[] apptList = new Appointment[200];
		Appointment[] onlyStudent = new Appointment[200]; //an array that only students with tutorRQ as true will be put into
		readFile(apptList);
		while(apptList[i] != null)
		{
			if(apptList[i].getRQID() == ID)
			{
				count++;
				onlyStudent[l] = apptList[i];
				System.out.println(count+". "+ onlyStudent[l]);
				l++;
			}
			i++;
		}
		while(!(choice < 0)  && onlyStudent != null)
		{
			System.out.println("Which do you want to cancel? type 0 to exit.");
			choice = option.nextInt();
			if(choice - 1 < 0) //subtracting from 1 is because the index in an array starts at 0 but the printed list starts at 1
				return;
			else
			{
				onlyStudent[choice - 1] = null; //cancels appointment
			}
		}
		writeFile(apptList);
	}
}
