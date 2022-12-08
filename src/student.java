import java.util.Scanner;

public class student {
private int studentID;
private String studentName;
private String studentPassword;
public studentLibrary sl;
public int studentCredits;
public student(String name, int ID) {
	studentName = name;
	studentID = ID;
	studentPassword = "1234";
	studentCredits = 0;
	sl = new studentLibrary();
}
public int getStudentID() {
	return studentID;
}
public void setStudentID(int studentID) {
	this.studentID = studentID;
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public String getStudentPassword() {
	return studentPassword;
}
public void setStudentPassword(String studentPassword) {
	this.studentPassword = studentPassword;
}

public boolean isPassword(String p) {
	
	return p.equals(this.studentPassword);
}
public boolean isName(String name) {
	return name.equals(this.studentName);
}
public void printStudentInfo() {
	System.out.println("This is your name: " + this.studentName);
	System.out.println("This is your Student ID: " + this.studentID);
}
public void changePassword() {
	System.out.println("Enter your old password here.");
	Scanner sc = new Scanner(System.in);
	String p = sc.next();
	if(this.isPassword(p)) {
		System.out.println("Enter your new password here.");
		String n = sc.next();
		this.setStudentPassword(n);
		
	}
	else {
		System.out.println("Password error! Please enter again!");
		changePassword();
		return;
	}
}
public void RegisterforClass() {
	if(this.studentCredits<studentLibrary.MAX_CREDIT) {
		sl.rgesiterForClass();
		this.studentCredits += 3;
	}
	else {
		System.out.println("You cannot over the limit!");
	}
	
}
public void DropForClass() {
	if(this.studentCredits>0) {
		sl.dropForClass();
		this.studentCredits -= 3;
	}
	else {
		System.out.println("No class can be droped!!");
	}
}
}
