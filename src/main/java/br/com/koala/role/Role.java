package br.com.koala.role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "title")
	private String title;
	
	//Hibernate eyes only
	@Deprecated
	Role() {}
	
	public Role(Long id, String title) {
		this.id = id;
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}
	
}
