import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class studentLibrary {
	public HashSet<course> Library;
	public ArrayList<RegisterdCourse> list;
	public final static int MAX_CREDIT = 18;
	public final static String FIRST_DATE = "2022-11-01 08:00:00";
	public studentLibrary() {
		Library = new HashSet<>();
		list = new ArrayList<RegisterdCourse>();
	}
	public void printAllCourse() {
		for(RegisterdCourse r:list)
			System.out.println(r.toString());
	}
	public void rgesiterForClass() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of course: ");
		int n = sc.nextInt();
		Date d1 = new Date();
	    SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
	    String d2 = ft.format(d1);
		if(d2.compareTo(FIRST_DATE)>0) {
		course c = courseLibrary.findByCourseNumber(n);
		if(c!=null) {
		if(!Library.contains(c)) {
			RegisterdCourse rc = new RegisterdCourse(c);
			list.add(rc);
			Library.add(c);
			
		}
		else {
			System.out.println("You have already registerd that class!");
		}
		}
		else {
			System.out.println("Dont have that class!");
		}
		}
		else {
			System.out.println("Please wait after register day!");
		}
	}
	public RegisterdCourse findCoursebyNumber(int number) {
		for(RegisterdCourse rc: list) {
			if(rc.c.equals(courseLibrary.findByCourseNumber(number))) {
				return rc;
			}
		}
				return null;
	}
	public void dropForClass() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of course: ");
		int n = sc.nextInt();
		RegisterdCourse rc = this.findCoursebyNumber(n);
		if(rc!=null) {
		course c = courseLibrary.findByCourseNumber(n);
		list.remove(rc);
		Library.remove(c);
		}
		else {
			System.out.println("Course not found!");
		}
		
	}
}
