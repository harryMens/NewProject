package com.example.NewProject.repository;

import com.example.NewProject.schema.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserInfo, Integer> {

    @Query(value = "SELECT * FROM USERINFO WHERE USERNAME = ?1", nativeQuery = true)
    UserInfo findByUserName(String username);


}
