package br.com.corsini.user.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.corsini.user.model.User;
import br.com.corsini.utils.service.AbstractPersistence;

@Stateless
public class UserServiceEJB extends AbstractPersistence<User, Long> 
	implements UserService {

	@PersistenceContext
    private EntityManager em;
	
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public UserServiceEJB() {
		super(User.class);
	}
	
}
