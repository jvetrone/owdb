import java.util.Arrays;
import java.util.Scanner;
public class main
{
	public static void main(String[] args) //Using this for tests for now
	{
		int choice = 0;
		while(choice != 4)
		{
			Student[]stuList = new Student[200];
			initializeStuArray(stuList);
			Scanner option = new Scanner(System.in);
			//System.out.println("What are you?\n1. Admin\n2. Professor\n3. Tutor\n4. Student");
			System.out.println("What would you like to do?\n1. Add a Student\n2. Search for a Student\n3. Remove a Student\n4. Exit\n5. Apply for tutor\n6. Accept Tutor\n7. Fire Tutor");
			choice = option.nextInt();
			if(choice == 1)
				idDatabase.addStudent();
			if(choice == 2)
				idDatabase.search();
			if(choice == 3)
				idDatabase.removeStudent();
			if(choice == 5)
				stuList[2].applyTutor();
			if(choice == 6)
				idDatabase.acceptTutor();
			if(choice == 7)
				idDatabase.removeTutor();
		}
	}
	public static void initializeStuArray(Student[]stuList) //loads the student array
	{
		int count = 0;
		int i = 0;
		//stuList[0] = new Student(700700000, "Joe", 3.5, 70, false); stuList[1] = new Student(700700001, "Lenny", 3.6, 75, false); stuList[2] = new Student(700700002, "Obi", 3.7, 80, true); stuList[3] = new Student(700700003, "Steven", 3.8, 85, false); idDatabase.writeFile(stuList);
		idDatabase.readFile(stuList);
		while(stuList[i] != null)
		{
				count++;
				System.out.println(count+". "+ stuList[i]);
				i++;
		}
	}
	public static void login() //decides whether the admin or a student/tutor is logging in
	{
		Student[] stuList = new Student[200];
		idDatabase.readFile(stuList);
		Scanner option = new Scanner(System.in);
		int choice = 0;
		while(choice != 1 || choice != 2)
		{
			System.out.println("What are you?\n1. Student\n2. Admin");
			choice = option.nextInt();
			if(choice == 1);
			{
				int sid = 0;
				int i = 0;
				Student s;
				while(sid < 700700000 || sid > 700799999)
				{
					System.out.println("Enter student ID");
					sid = option.nextInt();
					while(stuList[i] != null)
					{
						int currentID = stuList[i].getID();
						if(sid == currentID)
						{
							s = stuList[i];
							//s.load();
						}
						i++;
					}
				}
			}
			if(choice == 2)
			{
				//going to have admin enter some kind of password
			}
		}
		
	}
}