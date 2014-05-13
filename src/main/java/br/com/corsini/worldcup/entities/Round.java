package br.com.corsini.worldcup.entities;

public enum Round {

	GROUP_STAGE("Fase de Grupos"),
	ROUND_OF_16("Oitavas de Final"),
	QUARTER_FINALS("Quartas de Final"),
	SEMI_FINALS("Semi-Final"),
	THIRD_PLACE("Terceiro Lugar"),
	FINAL("Final");
	
	private final String label;
	
	private Round(String label)
	{
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
}
