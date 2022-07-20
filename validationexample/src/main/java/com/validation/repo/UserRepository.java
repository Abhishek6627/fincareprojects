package com.validation.repo;

import com.validation.dto.UserRequset;
import com.validation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
    User findByUserId(int id);
}
