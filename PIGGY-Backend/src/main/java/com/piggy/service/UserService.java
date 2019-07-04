/**
 * 
 */
package com.piggy.service;

import com.piggy.entity.User;

/**
 * @author ACER
 *
 */
public interface UserService {
	void save(User user);

    User findByUsername(String username);

	User findByEmail(String username);
}
