package com.example.user.userservice.repository;

import com.example.user.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>
{

    User findByUserId(Long userId);
}
