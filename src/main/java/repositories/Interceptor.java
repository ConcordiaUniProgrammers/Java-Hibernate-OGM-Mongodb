package repositories;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

import model.Student;

public class Interceptor {
	
	@PrePersist
	public void prePersist(Object obj){
		System.out.println(obj.toString());
	}
	@PostPersist
	public void postPersist(Object obj){
		System.out.println(obj.toString());
	}

}
