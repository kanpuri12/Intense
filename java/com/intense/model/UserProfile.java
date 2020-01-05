package com.intense.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name="user_Profile")
public class UserProfile implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique=true, nullable=false, precision=10)
    private int id;
	
    @Column(nullable=false, length=45)
	private String name;
    
    @Column(nullable=false, length=45)
	private String gender;
    
    @Column
    @JsonSerialize(as = Date.class)
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd",lenient=OptBoolean.FALSE)
    private Date dateofBirth;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(Date dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	@Override
	public String toString() {
		return "UserProfile [id=" + id + ", name=" + name + ", gender=" + gender + ", dateofBirth=" + dateofBirth + "]";
	}
    

}
