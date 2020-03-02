package com.suyash.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suyash.flightreservation.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
