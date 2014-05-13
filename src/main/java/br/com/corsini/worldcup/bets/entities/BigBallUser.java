package br.com.corsini.worldcup.bets.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.corsini.user.entities.User;


@Entity
@Table(name="big_ball_user")
public class BigBallUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private BigBall bigball;
	
	private User user;
	
	
	
}
