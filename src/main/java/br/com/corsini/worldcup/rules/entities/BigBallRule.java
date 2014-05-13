package br.com.corsini.worldcup.rules.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.corsini.worldcup.bets.entities.BigBall;

@Entity
@Table(name="big_ball_rule")
public class BigBallRule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private BigBall bigball;
	
	private RulesType ruleType;
	
	private int pointValue;

}
