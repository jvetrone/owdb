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
	public static void search(Student[] stuList)
	{
		Scanner query = new Scanner(System.in);
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
				System.out.println(stuList[i].toString());
			i++;
		}
	}

	public static void addStudent(Student[] stuList)
	{
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
			while(gpa < 0 || gpa > 4.0)
			{
			System.out.println("Enter GPA: ");
			gpa = info.nextDouble();
			}
			while(math < 0 || math > 100)
			{
				System.out.println("Enter Math Grade: ");
				math = info.nextDouble();
			}
			/*while(deancheck != 1)
			{
				System.out.println("Were you on the dean's list? Y for yes N for no: ");
				dean = info.nextLine();
				if(dean == "Y" || dean == "y")
				{
					isDean = true;
					deancheck = 1;
				}
				else if(dean == "N" || dean == "n")
				{
					isDean = false;
					deancheck = 1;
				}
			}*/
			int i = 0;
			while(stuList[i] != null)
			{
				i++;
			}

			stuList[i] = new Student(sid, name, gpa, math, isDean, false);
			System.out.println("Student added. Would you like to continue? Type N to stop");
			choice = info.nextLine();
			choice = info.nextLine();
			if(choice.equals("N") || choice.equals("n"))
				ctf = 1;
			else ctf = 0;
			writeFile(stuList);
		}
	}
	public static void removeStudent(Student[] stuList)
	{
		Scanner query = new Scanner(System.in);
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
	}
	public static void writeFile(Student[] stuList)
	{
	    try
	    {
	       FileOutputStream fos = new FileOutputStream("owdb.txt");
	       ObjectOutputStream oos = new ObjectOutputStream(fos);
	       oos.writeObject(stuList);
	       oos.close();
	       System.out.println("File Saved");
	    }
	    catch(Exception e) {
	        System.out.println("Error in output:" + e.toString());
	    }
	}
	public static void readFile(Student[] stuList)
	{
	    try
	    {
	    	Student[] s;
	        FileInputStream fis = new FileInputStream("owdb.txt");
	        ObjectInputStream ois = new ObjectInputStream(fis);
	        s = (Student[]) ois.readObject();
	        ois.close();
	        System.arraycopy(s, 0, stuList, 0, 200);
	        System.out.println("File Imported");
	    }
	    catch(Exception e)
	    {
	        System.out.println("Error in output:" + e.toString());
	    }
	}	
}
