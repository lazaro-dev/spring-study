package com.apispring.demo.repository;

import com.apispring.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //@Query("SELECT u FROM User u WHERE u.name LIKE :name")
    //public List<User> findByName(@Param("name") String name);
    public List<User> findByNameIgnoreCase(String name);

}
