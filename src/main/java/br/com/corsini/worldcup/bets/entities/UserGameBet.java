package br.com.corsini.worldcup.bets.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.corsini.worldcup.entities.Game;

@Entity
@Table(name="user_game_bet")
public class UserGameBet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private BigBallUser bigBallUser;
	
	private Game game;
	
	private int scoreTeamA;
	
	private int scoreTeamB;
	
	public UserGameBet() {
		// TODO Auto-generated constructor stub
	}
	
}