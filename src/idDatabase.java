import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
public class idDatabase
{
	public static void search()
	{
		Student[] stuList = new Student[200];
		readFile(stuList);
		int ctf = 0; //used as a check for while loop
		Scanner query = new Scanner(System.in);
		String choice = "A";
		while(ctf != 1) //in case the user wants to perform the function again
		{
		boolean found = false;
		int wantID = 0;
		while(wantID < 700700000 || wantID >700799999) //to make sure that it stays a 7007 number
		{
		System.out.println("Enter Student ID: ");
		wantID = query.nextInt();
		}
		int i = 0;
		while(stuList[i] != null)
		{
			int currentID = stuList[i].getID();
			if(wantID == currentID)
			{
				System.out.println(stuList[i].toString()); //gives you your result
				found = true;
			}
			i++;
		}
		if(found == false)
			System.out.println("No results.");
		else System.out.println("Student found!");
		System.out.println("Would you like to continue? Type N to stop");
		choice = query.nextLine();
		choice = query.nextLine();
		if(choice.equals("N") || choice.equals("n"))
			ctf = 1;
		else ctf = 0;
		}
	}

	public static void addStudent() //for admin to add students to database with
	{
		Student[] stuList = new Student[200];
		readFile(stuList);
		Scanner info = new Scanner(System.in);
		String choice = "A";
		int ctf = 0;
		while(ctf != 1)
		{
			String name = "";
			int sid = 0;
			double gpa = 5;
			double math = 101;
			String dean = "";
			boolean isDean = false;
			int deancheck = 0;
			System.out.println("Enter name: ");
			name = info.nextLine();
			while(sid < 700700000 || sid > 700799999)
			{
			System.out.println("Enter Student ID: ");
			sid = info.nextInt();
			}
			while(gpa < 0 || gpa > 4.0) //to make sure GPA is not too high or low
			{
			System.out.println("Enter GPA: ");
			gpa = info.nextDouble();
			}
			while(math < 0 || math > 100) //to make sure math grade is not too high or low
			{
				System.out.println("Enter Math Grade: ");
				math = info.nextDouble();
			}
			while(deancheck != 1) //to make sure only Y or N can be typed
			{
				System.out.println("Were you on the dean's list? Y for yes N for no: ");
				dean = info.nextLine();
				dean = info.nextLine();
				if(dean.equals("Y") || dean.equals("y"))
				{
					isDean = true;
					deancheck = 1;
				}
				else if(dean.equals("N") || dean.equals("n"))
				{
					isDean = false;
					deancheck = 1;
				}
			}
			int i = 0;
			while(stuList[i] != null) //goes to the end of the list so a student can be added
			{
				i++;
			}

			stuList[i] = new Student(sid, name, gpa, math, isDean);
			writeFile(stuList);
			System.out.println("Student added. Would you like to continue? Type N to stop");
			choice = info.nextLine();
			if(choice.equals("N") || choice.equals("n"))
				ctf = 1;
			else ctf = 0;
		}
	}
	public static void removeStudent() //similar to search except it removes the student
	{
		Student[] stuList = new Student[200];
		readFile(stuList);
		Scanner query = new Scanner(System.in);
		String choice = "A";
		int ctf = 0;
	while(ctf != 1)
	{
		int wantID = 0;
		while(wantID < 700700000 || wantID >700799999)
		{
		System.out.println("Enter Student ID: ");
		wantID = query.nextInt();
		}
		int i = 0;
		while(stuList[i] != null)
		{
			int currentID = stuList[i].getID();
			if(wantID == currentID)
			{
				stuList[i] = null;
			}
			i++;
		}
		writeFile(stuList);
		System.out.println("Student removed. Would you like to continue? Type N to stop");
		choice = query.nextLine();
		choice = query.nextLine();
		if(choice.equals("N") || choice.equals("n"))
			ctf = 1;
		else ctf = 0;
	}
	}
	public static void applyTutor(int ID) //used as a backend of sorts for student's applyTutor function
	//so student does not have to enter their own ID when applying for tutor
	{
		int i = 0;
		Student[] stuList = new Student[200];
		readFile(stuList);
		while(stuList[i] != null)
		{
		int currentID = stuList[i].getID();
		if(ID == currentID)
		{
		stuList[i].setTutorRQ(true);
		}
		i++;
		}
		writeFile(stuList);
	}
	public static void acceptTutor() //makes a student into a tutor
	{
		int i = 0;
		int l = 0;
		int count = 0;
		int choice = 0;
		Scanner option = new Scanner(System.in);
		Student[] stuList = new Student[200];
		Student[] wbTutors = new Student[200]; //an array that only students with tutorRQ as true will be put into
		readFile(stuList);
		while(stuList[i] != null)
		{
			if(stuList[i].isTutorRQ() == true)
			{
				count++;
				wbTutors[l] = stuList[i];
				System.out.println(count+". "+ wbTutors[l]);
				l++;
			}
			i++;
		}
		while(!(choice < 0)  && wbTutors != null)
		{
		System.out.println("Which do you want to make a tutor? type 0 to exit.");
		choice = option.nextInt();
		if(choice - 1 < 0) //subtracting from 1 is because the index in an array starts at 0 but the printed list starts at 1
			return;
		else
		{
		wbTutors[choice - 1].setTutor(true); //makes the student a tutor
		writeFile(stuList);
		}
		}
	}
	public static void removeTutor() //makes a tutor into a student
	{
		int i = 0;
		int l = 0;
		int count = 0;
		int choice = 0;
		Scanner option = new Scanner(System.in);
		Student[] stuList = new Student[200];
		Student[] firedTutors = new Student[200]; //an array that only students who are tutors will be put into
		readFile(stuList);
		while(stuList[i] != null)
		{
			if(stuList[i].isTutor() == true)
			{
				count++;
				firedTutors[l] = stuList[i];
				System.out.println(count+". "+ firedTutors[l]);
				l++;
			}
			i++;
		}
		while(!(choice < 0)  && firedTutors != null)
		{
		System.out.println("Which do you want to fire? type 0 to exit.");
		choice = option.nextInt();
		if(choice - 1 < 0) //subtracting from 1 is because the index in an array starts at 0 but the printed list starts at 1
			return;
		else
		{
		firedTutors[choice - 1].setTutor(false); //makes the tutor a student
		firedTutors[choice - 1].setTutorRQ(false);
		writeFile(stuList);
		}
		}
	}
	public static void writeFile(Student[] stuList) //saves the array of Students to a text file in the form of bytes
	{
	    try
	    {
	       FileOutputStream fos = new FileOutputStream("owdb.txt"); //writes to owdb no matter where writeFile is called
	       ObjectOutputStream oos = new ObjectOutputStream(fos);
	       oos.writeObject(stuList);
	       oos.close();
	       System.out.println("File Saved");
	    }
	    catch(Exception e) {
	        System.out.println("Error in output:" + e.toString());
	    }
	}
	public static void readFile(Student[] stuList) //loads the bytes from the file into an array
	{
	    try
	    {
	    	Student[] s;
	        FileInputStream fis = new FileInputStream("owdb.txt"); //reads from owdb no matter where readFile is called
	        ObjectInputStream ois = new ObjectInputStream(fis);
	        s = (Student[]) ois.readObject();
	        ois.close();
	        System.arraycopy(s, 0, stuList, 0, 200);
	    }
	    catch(Exception e)
	    {
	        System.out.println("Error in output:" + e.toString());
	    }
	}	
}
