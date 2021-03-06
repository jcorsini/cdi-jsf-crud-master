package br.com.corsini.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.corsini.utils.AbstractEntity;
import br.com.corsini.utils.Query;


@Entity
@Table(name="user")
@NamedQueries(value = { @NamedQuery(name = "User.findByLogin", query = "SELECT u FROM User u WHERE u.login LIKE :login") })
public class User implements AbstractEntity  {
	
		private static final long serialVersionUID = 1583248914760632185L;
		
		public static final Query<User> FIND_BY_LOGIN = Query.valueOf(User.class, "User.findByLogin", "login");

		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Integer id;
	    
	    @Column(length = 40, unique = true, nullable = false)
	    private String login;
	    
	    @Column(length = 40, nullable = false)
	    private String password;
	    

		@Column(length = 40, nullable = false)
	    private String name;   
	    
	    @Column(length = 50, nullable = false)
	    private String surname;

	    public User(){
	    	
	    }
	    
	    public User(String login, String password, String name, String surname) {
			this.login = login;
			this.password = password;
			this.name = name;
			this.surname = surname;
		}
	    
		public Integer getId() {
			return id;
		}

		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSurname() {
			return surname;
		}

		public void setSurname(String surname) {
			this.surname = surname;
		}        
	
}