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
public class Class {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "class_id")
	private int classId;
	
	
	@Column(name = "class_name")
	private String className;
	
	@ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	@JoinTable(name="CLASS_SUBJECT", 
				joinColumns={@JoinColumn(name="class_id")}, 
				inverseJoinColumns={@JoinColumn(name="subject_id")})
	private Set<Subject> subjects = new HashSet<Subject>();
	
	
	@ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinTable(name="CLASS_TEACHER", 
				joinColumns={@JoinColumn(name="class_id")}, 
				inverseJoinColumns={@JoinColumn(name="teacher_id")})
	private Set<Teacher> teachers = new HashSet<Teacher>();

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}
	
	
	

}
