package com.java.persistence;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Teacher {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "teacher_id")
	private int teacherId;
	
	@Column(name = "teacher_name")
	private String teacherName;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="TEACHER_SUBJECT", 
				joinColumns={@JoinColumn(name="teacher_id")}, 
				inverseJoinColumns={@JoinColumn(name="subject_id")})
	private Set<Subject> subjects = new HashSet<Subject>();
	
	
	@ManyToMany(fetch = FetchType.EAGER,			
		    mappedBy="teachers")
	private Set<Class> Classes = new HashSet<Class>();


	public int getTeacherId() {
		return teacherId;
	}


	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}


	public String getTeacherName() {
		return teacherName;
	}


	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}


	public Set<Subject> getSubjects() {
		return subjects;
	}


	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}


	public Set<Class> getClasses() {
		return Classes;
	}


	public void setClasses(Set<Class> classes) {
		Classes = classes;
	}

	

}
