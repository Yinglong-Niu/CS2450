
public class course {
private int courseNumber;
private String courseName;
public String coursenameAndCoursenumber;
public course(String courseName,int courseNumber) {
	this.setCourseName(courseName);
	this.setCourseNumber(courseNumber);
	coursenameAndCoursenumber = courseName+""+courseNumber;
}
public int getCourseNumber() {
	return courseNumber;
}
public void setCourseNumber(int courseNumber) {
	this.courseNumber = courseNumber;
}
public String getCourseName() {
	return courseName;
}
public void setCourseName(String courseName) {
	this.courseName = courseName;
}
@Override
public int hashCode()
{
	return coursenameAndCoursenumber.hashCode();
}

@Override
public boolean equals(final Object o)
{
	if (o instanceof course)
	{
		return coursenameAndCoursenumber.equals(((course)o).coursenameAndCoursenumber);
	}
	return false;
}
public String toString() {
	return courseNumber+" "+courseName;
}
}
