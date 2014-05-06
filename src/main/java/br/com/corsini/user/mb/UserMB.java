package br.com.corsini.user.mb;

import static javax.faces.context.FacesContext.getCurrentInstance;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.corsini.user.model.User;
import br.com.corsini.user.service.UserService;

@Named
@RequestScoped
public class UserMB implements Serializable {
	
	private static final long serialVersionUID = -5414388741973607828L;

	@Inject
	private UserService service;
	
	@Inject
	private User user;
	
	private Long idSelecionado;
	
	private List<User> users;
	
	public UserMB() {
	}
	
	public void setIdSelecionado(Long idSelecionado) {
		this.idSelecionado = idSelecionado;
	}
	
	public Long getIdSelecionado() {
		return idSelecionado;
	}
	
	public User getUser() {
		return user;
	}
	
	
	public void editar() {
		if (idSelecionado == null) {
			return;
		}
		user = service.find(idSelecionado);
	}
	
	public List<User> getUsers() {
		if (users == null) {
			users = service.findAll();
		}
		return users;
	}

	
	public String salvar() {
		try {
			service.save(user);
		} catch(Exception ex) {
			//log.error("Erro ao salvar usuario.", ex);
			addMessage(getMessageFromI18N("msg.erro.salvar"), ex.getMessage());
			return "";
		}
		//log.debug("Salvou "+mercadoria.getId());
		return "usersList";
	}
	
	public String remover() {
		try {
			service.remove(user);
		} catch(Exception ex) {
			//log.error("Erro ao remover mercadoria.", ex);
			addMessage(getMessageFromI18N("msg.erro.remover"), ex.getMessage());
			return "";
		}
		//log.debug("Removeu mercadoria "+mercadoria.getId());
		return "usersList";
	}
	
	/**
	 * @param key
	 * @return Recupera a mensagem do arquivo properties <code>ResourceBundle</code>.
	 */
	private String getMessageFromI18N(String key) {
		ResourceBundle bundle = ResourceBundle.getBundle("messages_labels", getCurrentInstance().getViewRoot().getLocale());
		return bundle.getString(key);
	}
	
	/**
	 * Adiciona um mensagem no contexto do Faces (<code>FacesContext</code>).
	 * @param summary
	 * @param detail
	 */
	private void addMessage(String summary, String detail) {
		getCurrentInstance().addMessage(null, new FacesMessage(summary, summary.concat("<br/>").concat(detail)));
	}
	
}