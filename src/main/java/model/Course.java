package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import repositories.Interceptor;

@Entity
@EntityListeners(value = {Interceptor.class})
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private Date start_date;
	@ManyToMany(mappedBy ="courses")
	private List<Student> students =  new ArrayList<>();
	
	public Course() {
		// TODO Auto-generated constructor stub
	}
	public Course(String name, Date start_date) {
		super();
		this.name = name;
		this.start_date = start_date;
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
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	@Override
	public String toString() {
		return this.getClass().getName() + " --> " + this.getId() + " : " +this.getName();
	}
}
