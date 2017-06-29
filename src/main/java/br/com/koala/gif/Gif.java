package br.com.koala.gif;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gif")
public class Gif {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "url")
	private String url;
	
	//Hibernate eyes only
	@Deprecated
	Gif() {}
	
	public Gif(Long id, String url) {
		this.id = id;
		this.url = url;
	}

	public Long getId() {
		return id;
	}

	public String getUrl() {
		return url;
	}
}
