package com.backend.myTicket.repository;

import com.backend.myTicket.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

}
