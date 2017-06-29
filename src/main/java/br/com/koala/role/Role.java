package br.com.koala.role;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
	
	@Column(name = "date")
	private LocalDateTime date;
	
	@Deprecated //Hibernate eyes only
	Role() {}
	
	public Role(Long id, String title, LocalDateTime date) {
		this.id = id;
		this.title = title;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}
	
	public String getFormattedDate() {
		return date.format(DateTimeFormatter.ofPattern("dd/MM HH:mm EEEE"));
	}
}
