import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class admin {
private String name ;
private String password;
public static ArrayList<student> studentlist;
public admin() {
	this.name = "admin";
	this.password = "1234";
	studentlist = new ArrayList<student>();
}
public void printStudentList() {
	for(student s: studentlist)
		s.printStudentInfo();
}
public void importSudent() throws FileNotFoundException {
	File f = new File("student.txt");
	@SuppressWarnings("resource")
	Scanner sc = new Scanner(f);
	while(sc.hasNext()) {
		int ID = sc.nextInt();
		String name = sc.next();
		student c = new student(name,ID);
		studentlist.add(c);
	}
}
public String getName() {
	return name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public boolean isPassword(String p) {
	return p.equals(this.password);
}
public void changePassword() {
	System.out.println("Enter your old password here.");
	@SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
	String p = sc.next();
	if(this.isPassword(p)) {
		System.out.println("Enter your new password here.");
		String n = sc.next();
		this.setPassword(n);
		
	}
	else {
		System.out.println("Password error! Please enter again!");
		changePassword();
		return;
	}
}
public void addStudent() {
	@SuppressWarnings("resource")
	Scanner sip = new Scanner(System.in);
	System.out.println("Enter the student name: ");
	String name = sip.next();
	System.out.println("Enter the studentID: ");
	int id = sip.nextInt();
	student s = new student(name,id);
	studentlist.add(s);
}
public void deleteBystudentID() {
	@SuppressWarnings("resource")
	Scanner sip = new Scanner(System.in);
	System.out.println("Enter the studentID: ");
	int id = sip.nextInt();
	student s = findBystudentID(id);
	studentlist.remove(s);
	
}
public student findBystudentID(int id) {
	student s = null;
	for(student st:studentlist) {
		if(st.getStudentID()==id)
			s = st;
	}
	return s;
	
}
public static student findBystudentName(String name) {
	student s = null;
	for(student st:studentlist) {
		if(st.getStudentName().equals(name))
			s = st;
	}
	return s;
	
}
}
