package com.xadmin.swagger.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table
public class Course implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5857883241528139490L;
	@Id
	@GeneratedValue 
	@ApiModelProperty(value="This is auto generated id")
	private int courseId;
	@ApiModelProperty(value="This is course name")
	private String courseName;
	@ApiModelProperty(value="This is price of Course")
	private double price;
	public Course(int courseId, String courseName, double price) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.price = price;
	}
	public Course() {
		super();
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", price=" + price + "]";
	}
	
	

}
