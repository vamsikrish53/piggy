/**
 * 
 */
package com.piggy.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.piggy.entity.Role;
import com.piggy.entity.User;
import com.piggy.repository.UserRepository;

/**
 * @author ACER
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	UserRepository mUserRepository;
	
	//TODO do we want user name or can we go with gmail?
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String aUserName) throws UsernameNotFoundException {
		User user = mUserRepository.findByUsername(aUserName);
		if (user == null) throw new UsernameNotFoundException(aUserName);

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (Role role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
	}

}
