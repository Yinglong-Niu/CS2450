import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class courseLibrary {
public static HashSet<course> Library;
public courseLibrary() {
	Library = new HashSet<>();
}
	
public void importCourse() throws FileNotFoundException {
	File f = new File("course.txt");
	@SuppressWarnings("resource")
	Scanner sc = new Scanner(f);
	while(sc.hasNext()) {
		int number = sc.nextInt();
		String name = sc.next();
		course c = new course(name,number);
		Library.add(c);
	}
}
public void printAllCourse() {
	Iterator<course> set = Library.iterator();
	while(set.hasNext()) {
		System.out.println(set.next());
	}
}
public void addCourse() {
	@SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
	System.out.println("Add course here.");
	System.out.println("Enter the name of course: ");
	String name = sc.next();
	System.out.println("Enter the number of course: ");
	int number = sc.nextInt();
	course c = new course(name,number);
	Library.add(c);
}
public void deleteByCourseNumber() {
	@SuppressWarnings("resource")
	Scanner sip = new Scanner(System.in);
	System.out.println("Enter the course number: ");
	int id = sip.nextInt();
	course s = findByCourseNumber(id);
	Library.remove(s);
	
}
public  static course findByCourseNumber(int number) {
	course s = null;
	for(course st:Library) {
		if(st.getCourseNumber()==number)
			s = st;
	}
	return s;
	
}
}
