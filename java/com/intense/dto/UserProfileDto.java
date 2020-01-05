package com.intense.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

public class UserProfileDto {
	@SerializedName("userName")
	@Expose
	@NotNull(message = "Please provide user name")
	private String name;

	@SerializedName("gender")
	@Expose
	@NotNull(message = "Please provide your gender")
	private String gender;

	@SerializedName("dateofBirth")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateofBirth;

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
		return "UserProfile [name=" + name + ", gender=" + gender + ", dateofBirth=" + dateofBirth + "]";
	}

}
