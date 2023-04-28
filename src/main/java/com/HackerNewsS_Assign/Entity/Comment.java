package com.HackerNewsS_Assign.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table
@Data
@ToString


public class Comment {
	
	@Id
	private Integer id;
	private String text;
	private String wriitenBy;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getWriitenBy() {
		return wriitenBy;
	}
	public void setWriitenBy(String wriitenBy) {
		this.wriitenBy = wriitenBy;
	}
	public Comment(Integer id, String text, String wriitenBy) {
		super();
		this.id = id;
		this.text = text;
		this.wriitenBy = wriitenBy;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", text=" + text + ", wriitenBy=" + wriitenBy + "]";
	}

	public Comment()
	{

	}

}
