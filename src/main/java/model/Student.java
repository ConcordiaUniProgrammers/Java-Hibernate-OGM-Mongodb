package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import repositories.Interceptor;

@Entity
@EntityListeners(value = {Interceptor.class})
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private Date register_date;
	@OneToMany(mappedBy = "owner", cascade= CascadeType.ALL)
	private List<Project> projects = new ArrayList<Project>();
	@ManyToMany(cascade =CascadeType.ALL)
	private List<Course> courses = new ArrayList<>();
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, Date register_date) {
		super();
		this.name = name;
		this.register_date = register_date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegister_date() {
		return register_date;
	}

	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	public void addCourse(Course course){
		this.courses.add(course);
	}

	
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	@Override
	public String toString() {
		return this.getClass().getName() + " --> " + this.getId() + " : " +this.getName();
	}

	public void addProject(Project project) {
		project.setOwner(this);
		this.projects.add(project);
		
	}
}
