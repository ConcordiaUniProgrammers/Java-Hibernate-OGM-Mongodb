package model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import repositories.Interceptor;


@Entity
@EntityListeners(value = {Interceptor.class})
public class Project implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String github_link;
	@ManyToOne(cascade = CascadeType.ALL)
	private Student owner;
	public Project() {
		// TODO Auto-generated constructor stub
	}
	public Project(String name, String github_link) {
		super();
		this.name = name;
		this.github_link = github_link;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGithub_link() {
		return github_link;
	}
	public void setGithub_link(String github_link) {
		this.github_link = github_link;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return this.getClass().getName() + " --> " + this.getId() + " : " +this.getName();
	}
	
	public Student getOwner() {
		return owner;
	}
	public void setOwner(Student owner) {
		this.owner = owner;
	}
}
