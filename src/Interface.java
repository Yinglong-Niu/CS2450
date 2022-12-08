import java.util.HashSet;
import java.util.Scanner;

public class Interface {
	static admin ad = new admin();
	static student stu;
	public static courseLibrary cl = new courseLibrary();
public static void entrance() {
	
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the number of interface you want to enter in: ");
	System.out.println("1. You are a student: ");
	System.out.println("2. You are the administrator: ");
	System.out.println("3. I am new, sign up.");
	System.out.println("4. Exit the system.");
	int choice = sc.nextInt();
	if(choice == 1) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter your name: ");
		String name = input.next();
		stu = admin.findBystudentName(name);
		if(stu!=null) {
		System.out.println("The default password is 1234, you can change it later.");
		String password = input.next();
		while(true) {
			if(stu.isPassword(password)) {
				studentEntrance(stu);
				return;
			}
			else {
				System.out.println("Password error!");
			}
		}
		}
		else {
			System.out.println("Name not found.");	
			entrance();
			return;
		}
	}
	else if(choice == 2) {
		while(true) {
		System.out.println("The default password is 1234, you can change password later");
		Scanner in = new Scanner(System.in);
		String p = sc.next();
		if(ad.isPassword(p)) {
			adminEntrance();
			break;
		}
		else {
			System.out.println("Password error!");
			continue;
		}
		}	
	}
	else if(choice == 3) {
		Scanner sip = new Scanner(System.in);
		System.out.println("Welcome to register for your account");
		System.out.println("Enter the name: ");
		String name = sip.next();
		System.out.println("The default password is 1234, you can change it later.");
		System.out.println("Enter your studentID: ");
		int id = sip.nextInt();
		student s = new student(name,id);
		stu = s;
		studentEntrance(stu);
		return;
	}
	else if(choice == 4) {
		System.out.println("Have a good day!");
		System.exit(0);
	}
	else {
		System.out.println("Input error!");
		entrance();
		return;
	}
}
public static void studentEntrance(student s) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the number of function: ");
	System.out.println("1. Register for the class ");
	System.out.println("2. look up all classes ");
	System.out.println("3. Drop the class ");
	System.out.println("4. Change the password ");
	System.out.println("5. return to last page");
	System.out.println("6. my info ");
	System.out.println("7. Look the class that already have registerd ");
	System.out.println("8. exit the system ");
	int choice = sc.nextInt();
	if(choice == 1) {
		cl.printAllCourse();
		stu.RegisterforClass();
		studentEntrance(stu);
		return;
	}
	else if(choice == 2) {
		cl.printAllCourse();
		studentEntrance(stu);
		return;
	}
	else if(choice == 3) {
		stu.sl.printAllCourse();
		stu.DropForClass();
		studentEntrance(stu);
		return;
	}
	else if(choice == 4) {
		stu.changePassword();
		studentEntrance(stu);
		return;
	}
	else if(choice == 5) {
		stu = null;
		entrance();
		return;
	}
	else if(choice == 6) {
		stu.printStudentInfo();
		studentEntrance(stu);
		return;
	}
	else if(choice == 7) {
		stu.sl.printAllCourse();
		studentEntrance(stu);
		return;
	}
	else if(choice == 8) {
		System.out.println("Have a good day!");
		System.exit(0);
	}
	else {
		System.out.println("Input error!");
		studentEntrance(s);
		return;
	}
}
public static void adminEntrance() {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the number of function: ");
	System.out.println("1. look up all students ");
	System.out.println("2. Add student ");
	System.out.println("3. Delete student ");
	System.out.println("4. Add class ");
	System.out.println("5. Delete class ");
	System.out.println("6. look up classes ");
	System.out.println("7. change the password ");
	System.out.println("8. return to last entance ");
	System.out.println("9. Exit the system ");
	int choice = sc.nextInt();
	if(choice == 1) {
		ad.printStudentList();
		adminEntrance();
		return;
	}
	else if(choice == 2) {
		ad.addStudent();
		adminEntrance();
		return;
	}
	else if(choice == 3) {
		ad.deleteBystudentID();
		adminEntrance();
		return;
	}
	else if(choice == 4) {
		cl.addCourse();
		adminEntrance();
		return;
	}
	else if(choice == 5) {
		cl.deleteByCourseNumber();
		adminEntrance();
		return;
	}
	else if(choice == 6) {
		cl.printAllCourse();
		adminEntrance();
		return;
	}
	else if(choice == 7) {
		ad.changePassword();
		adminEntrance();
		return;
	}	
	else if(choice == 8) {
		entrance();
		return;
	}
	else if(choice == 9) {
		System.out.println("Have a good day!");
		System.exit(0);
	}
	else {
		System.out.println("Input error!");
		adminEntrance();
		return;
	}
}

}
