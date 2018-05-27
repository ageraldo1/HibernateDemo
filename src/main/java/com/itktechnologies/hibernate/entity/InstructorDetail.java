package com.itktechnologies.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="youtube_channel")
	private String youTubeChannel;
	
	@Column(name="hobby")
	private String hobby;
	
	@OneToOne(mappedBy="instructorDetail", cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}) // except for delete cascade 
	private Instructor instructor;
	
	public InstructorDetail() {
		this.youTubeChannel = null;
		this.hobby = null;
	}
	
	public InstructorDetail(String channel, String hobby) {
		this.youTubeChannel = channel;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYouTubeChannel() {
		return youTubeChannel;
	}

	public void setYouTubeChannel(String youTubeChannel) {
		this.youTubeChannel = youTubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	@Override
	public String toString() {
		return "[id : " + this.id + " - youtube channel: " + this.youTubeChannel + " - hobby: " + this.hobby + "]";
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	
	
}
