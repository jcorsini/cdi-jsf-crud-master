package br.com.corsini.worldcup.bets.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.corsini.worldcup.rules.entities.RulesType;

@Entity
@Table(name="user_position_bet")
public class UserPositionBet {
	
	public enum PositionBet {
		CHAMPION("Campeão", RulesType.CHAMPION_ASSERT),
		SECOND_PLACE("Vice-campeão", RulesType.SECOND_PLACE_ASSERT),
		THIRD_PLACE("Terceiro Lugar", RulesType.THIRD_PLACE_ASSERT),
		FOURTH_PLACE("Quarto Lugar", RulesType.FOURTH_PLACE_ASSERT);
		
		private final String label;
		
		private final RulesType ruleType;
		
		private PositionBet(String label, RulesType ruleType) {
			this.label = label;
			this.ruleType = ruleType;
		}

		public String getLabel() {
			return label;
		}

		public RulesType getRuleType() {
			return ruleType;
		}
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private BigBallUser bigBallUser;
	
	private PositionBet positionBet;
	
	public UserPositionBet() {
		// TODO Auto-generated constructor stub
	}
	
}