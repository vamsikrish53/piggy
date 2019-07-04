/**
 * 
 */
package com.piggy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piggy.entity.User;

/**
 * @author ACER
 *
 */
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String aUserName);

	User findByEmail(String username);

}
