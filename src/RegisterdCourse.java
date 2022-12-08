import java.util.Date;
import java.text.SimpleDateFormat;
public class RegisterdCourse {
	public course c;
	private String date;
public RegisterdCourse(course c) {
	this.c=c;
	date = this.setDate();
}
public String setDate() {
	Date d1 = new Date();
    SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
    return ft.format(d1);
}
public String getDate() {
	return date;
}
public String toString() {
	return this.c.toString() +"\n" + date;
}
}
