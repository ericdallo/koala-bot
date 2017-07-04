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
	
	@Column(name = "organizer_id")
	private Long organizerId;
	
	@Deprecated //Hibernate eyes only
	Role() {}
	
	public Role(String title, LocalDateTime date, Long organizerId) {
		this.title = title;
		this.date = date;
		this.organizerId = organizerId;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}
	
	public void changeTitle(String title) {
		this.title = title;
	}
	
	public Long getOrganizerId() {
		return organizerId;
	}
	
	public String getFormattedDate() {
		return date.format(DateTimeFormatter.ofPattern("dd/MM HH:mm EEEE"));
	}

	public static Role preRole(Long organizerId, LocalDateTime dateTime) {
		return new Role(null, dateTime, organizerId);
	}

}
