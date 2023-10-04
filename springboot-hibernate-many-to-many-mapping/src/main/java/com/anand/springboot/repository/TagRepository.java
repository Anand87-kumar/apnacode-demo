package com.anand.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anand.springboot.entity.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long>{

}
