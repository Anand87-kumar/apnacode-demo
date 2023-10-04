package com.anand.springboot.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

/**
 * Tag domain model
 * @author javaguides.net
 *
 */
@Entity
@Table( name = "tags")
public class Tag {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "tags")
	private Set<Post> posts = new HashSet<>();
	
	public Tag() {
		
	}
	
	public Tag(String name) {
		super();
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Post> getPosts() {
		return posts;
	}
	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}
}
