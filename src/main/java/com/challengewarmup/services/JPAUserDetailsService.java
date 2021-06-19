package com.challengewarmup.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.challengewarmup.models.dao.IUserDao;
import com.challengewarmup.models.entity.Role;
import com.challengewarmup.models.entity.User;


@Service("jpaUserDetailsService")
public class JPAUserDetailsService implements UserDetailsService {
	
	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private Logger logger = LoggerFactory.getLogger(JPAUserDetailsService.class);

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByEmail(username);
		
		if(user == null) {
			logger.error("Error login: no existe el usuario '" + username + "'");
            throw new UsernameNotFoundException("Username " + username + "no existe en el sistema!");
		} else {
			logger.info(user.getEmail());
		}
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for(Role role : user.getRoles()) {
			logger.info("Role: ".concat(role.getAuthority()));
			authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
		}
		
		if(authorities.isEmpty()) {
			logger.error(username.concat("no tiene roles asignados"));
			throw new UsernameNotFoundException(username.concat("no tiene roles asignados"));
		}
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), true, true, true, true, authorities);
	}

}
