import java.util.Scanner;

public class Admin
{
	public static void load()
	{
		Scanner option = new Scanner(System.in);
		int choice = 0;
		while(choice != 5)
		{
			System.out.println("Choose, brand.\n1. Add Student\n2. Remove Student\n3. Accept Tutor\n4. Remove Tutor\n5. Exit");
			choice = option.nextInt();
			if(choice == 1)
				idDatabase.addStudent();
			if(choice == 2)
				idDatabase.removeStudent();
			if(choice == 3)
				idDatabase.acceptTutor();
			if(choice == 4)
				idDatabase.removeTutor();
		}
	}
}
