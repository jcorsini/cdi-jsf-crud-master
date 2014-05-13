package br.com.corsini.worldcup.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="official_result")
public class OfficialResult {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private Game game;
	
	private int scoreTeamA;
	
	private int scoreTeamB;
	
	public OfficialResult() {
		// TODO Auto-generated constructor stub
	}
	
}
