/**
 * 
 */
package com.piggy.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.piggy.entity.User;
import com.piggy.repository.RoleRepository;
import com.piggy.repository.UserRepository;

/**
 * @author ACER
 *
 */
@Service
public class UserServiceImpl implements UserService{

	@Autowired
    private UserRepository userRepository;
	
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
	@Override
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));//TODO check for special users
        userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}
