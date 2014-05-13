package br.com.corsini.worldcup.entities;


public enum NationalTeams {

	BRAZIL("Brasil", FirstRoundGroup.A, ""),
	CROATIA("Croacia", FirstRoundGroup.A, ""),
	MEXICO("M�xico", FirstRoundGroup.A, ""),
	CAMEROON("Camar�es", FirstRoundGroup.A, ""),
	SPAIN("Espanha", FirstRoundGroup.B, ""),
	NETHERLANDS("Holanda", FirstRoundGroup.B, ""),
	CHILE("Chile", FirstRoundGroup.B, ""),
	AUSTRALIA("Austr�lia", FirstRoundGroup.B, ""),
	COLOMBIA("Colombia", FirstRoundGroup.C, ""),
	GREECE("Gr�cia", FirstRoundGroup.C, ""),
	IVORY_COAST("Costa do Marfim", FirstRoundGroup.C, ""),
	JAPAN("Jap�o", FirstRoundGroup.C, "");
	

	private final String name;
	
	private final FirstRoundGroup group;
	
	private final String flagImageSrc;
	
	private NationalTeams(String name, FirstRoundGroup group, String flagImageSrc)
	{
		this.name = name;
		this.group = group;
		this.flagImageSrc = flagImageSrc;
	}

	public String getName() {
		return name;
	}

	public FirstRoundGroup getGroup() {
		return group;
	}

	public String getFlagImageSrc() {
		return flagImageSrc;
	}
	
	
	
	
}
