package br.com.corsini.security;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.picketlink.annotations.PicketLink;
import org.picketlink.authentication.BaseAuthenticator;
import org.picketlink.credential.DefaultLoginCredentials;
import org.picketlink.idm.model.basic.User;

/**
 * A simple PicketLink authenticator that will accept a hard coded username/password value. The
 * @PicketLink annotation is required to indicate to PicketLink that this is the default Authenticator
 * to be used.
 * 
 * @author Shane Bryzak
 *
 */
@PicketLink
public class SimpleAuthenticator extends BaseAuthenticator {

	@Inject 
	private DefaultLoginCredentials credentials;

	@Inject
	private FacesContext facesContext;

	@Override
	public void authenticate() {

        if ("jsmith".equals(credentials.getUserId()) &&
                "abc123".equals(credentials.getPassword())) {
            setStatus(AuthenticationStatus.SUCCESS);
            setAccount(new User("jsmith"));
        } else {
            setStatus(AuthenticationStatus.FAILURE);
            facesContext.addMessage(null, new FacesMessage(
                    "Authentication Failure - The username or password you provided were invalid."));
        }

	}


	
//	
//	@Override
//	public void authenticate() {
//
//		User u = User.FIND_BY_LOGIN.single(em, credentials.getUserId());
//		if(u == null)
//		{
//			failAuthenticate();
//			return;
//		}
//
//		if(!validatePassword(u))
//		{
//			failAuthenticate();
//			return;
//		}
//		
//		
//		setStatus(AuthenticationStatus.SUCCESS);
//		//            setAccount(new User("J")); -- deles
//		//Aplicar regras
//		
//
//	}
//
//
//
//	private void failAuthenticate()
//	{
//		setStatus(AuthenticationStatus.FAILURE);
//		facesContext.addMessage(null, new FacesMessage(
//				"Falha de autenticação - Usuário ou senha inválidos."));
//	}
//
//	private boolean validatePassword(User u)
//	{
//		return u.getPassword().equals(credentials.getPassword());
//	}


}