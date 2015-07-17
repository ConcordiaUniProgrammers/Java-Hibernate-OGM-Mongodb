import java.util.Date;

import model.Course;
import model.Project;
import model.Student;
import repositories.BaseRepository;


public class Demo {

	public static void main(String[] args) {
		
		Student student = new Student("Mojtaba", new Date());
		student.addCourse(new Course("Math", new Date()));
		student.addCourse(new Course("Sport", new Date()));
		Project project = new Project("java", "http://www.example.com");
		student.addProject(project);
		
		
		Student student2 = new Student("Mojtaba", new Date());
		student2.addCourse(new Course("Math", new Date()));
		student2.addCourse(new Course("Sport", new Date()));
		Project project2 = new Project("java", "http://www.example.com");
		student2.addProject(project2);
		
		BaseRepository.save(student, student2);
	}

}
