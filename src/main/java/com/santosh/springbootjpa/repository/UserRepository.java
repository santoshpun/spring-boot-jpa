package com.santosh.springbootjpa.repository;

import com.santosh.springbootjpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    @Query("SELECT t FROM User t WHERE t.username = ?1")
    User findUserByUsername(String username);

    @Query("SELECT t FROM User t WHERE t.name = :name")
    List<User> findUsersByName(@Param("name") String name);

    Optional<User> findById(Integer id);

    @Query("SELECT t FROM User t")
    List<User> findAllUsers();

}
