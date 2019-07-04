/**
 * 
 */
package com.piggy.security;

/**
 * @author ACER
 *
 */
public interface SecurityService {
	String findLoggedInUsername();
    void autoLogin(String username, String password);
}
