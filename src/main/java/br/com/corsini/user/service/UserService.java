package br.com.corsini.user.service;

import java.util.List;

import javax.ejb.Local;

import br.com.corsini.user.model.User;

@Local
public interface UserService {

	public User save(User user);
	
	public void remove(User user);
	
	public User find(Long id);
	
	public List<User> findAll();

}
