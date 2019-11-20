import java.util.Arrays;
import java.util.Scanner;
public class main
{
	public static void main(String[] args)
	{
		int choice = 0;
		//Student[]stuList = new Student[200];
		//initializeStuArray(stuList);
		while(choice != 4)
		{
			Student[]stuList = new Student[200];
			initializeStuArray(stuList);
			System.out.println(Arrays.toString(stuList));
			Scanner option = new Scanner(System.in);
			//System.out.println("What are you?\n1. Admin\n2. Professor\n3. Tutor\n4. Student");
			System.out.println("What would you like to do?\n1. Add a Student\n2. Search for a Student\n3. Remove a Student\n4. Exit");
			choice = option.nextInt();
			if(choice == 1)
				idDatabase.addStudent(stuList);
			if(choice == 2)
				idDatabase.search(stuList);
			if(choice == 3)
				idDatabase.removeStudent(stuList);
		}
	}
	public static void initializeStuArray(Student[]stuList)
	{
		/*stuList[0] = new Student(700700000, "Joe", 3.5, 70, false, false);
		stuList[1] = new Student(700700001, "Lenny", 3.6, 75, false, false);
		stuList[2] = new Student(700700002, "Obi", 3.7, 80, true, false);
		stuList[3] = new Student(700700003, "Steven", 3.8, 85, false, false);
		idDatabase.writeFile(stuList);*/
		idDatabase.readFile(stuList);
	}
}