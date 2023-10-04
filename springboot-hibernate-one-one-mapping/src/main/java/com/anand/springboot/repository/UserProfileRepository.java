package com.anand.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anand.springboot.entity.UserProfile;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long>{

}
