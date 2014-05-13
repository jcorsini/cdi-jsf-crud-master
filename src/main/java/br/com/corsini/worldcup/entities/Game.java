package br.com.corsini.worldcup.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="game")
public class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int fifaId;
	
	@Enumerated
	private Round round;
	
	//Deverá guardar hora
	private Date date;
	
	private Venue venue;
	
	private NationalTeams teamA;
	
	private NationalTeams teamB;
	
	public Game() {
		// TODO Auto-generated constructor stub
	}
	

	public Game(int fifaId, Round round, Date date, Venue venue,
			NationalTeams teamA, NationalTeams teamB) {
		this.fifaId = fifaId;
		this.round = round;
		this.date = date;
		this.venue = venue;
		this.teamA = teamA;
		this.teamB = teamB;
	}

	public int getFifaId() {
		return fifaId;
	}

	public Round getRound() {
		return round;
	}

	public Date getDate() {
		return date;
	}

	public Venue getVenue() {
		return venue;
	}

	public NationalTeams getTeamA() {
		return teamA;
	}

	public NationalTeams getTeamB() {
		return teamB;
	}
	
}
