package br.com.corsini.worldcup.entities;

public enum Venue {

	RIO_DE_JANEIRO("Rio de Janeiro", "RJ", "Maracan�"),
	BRASILIA("Brasilia", "DF", "Man� Garrincha"),
	SAO_PAULO("S�o Paulo", "SP", "Lix�o"),
	FORTALEZA("Fortaleza", "CE", "Castel�o"),
	BELO_HORIZONTE("Belo Horizonte", "BH", "Mineir�o"),
	PORTO_ALEGRE("Porto Alegre", "RS", "Beira-Rio"),
	SALVADOR("Salvador", "BA", "Fonte Nova"),
	RECIFE("Recife", "PE", "Arena Pernambuco"),
	CUIBA("Cuib�", "MT", "Arena Pantanal"),
	MANAUS("Manaus", "AM", "Arena da Amaz�nia"),
	NATAL("Natal", "RN", "Arena das Dunas"),
	CURITIBA("Curitiba", "PR", "Arena da Baixada");
	
	private final String city;
	
	private final String state;
	
	private final String stadium;

	private Venue(String city, String state, String stadium) {
		this.city = city;
		this.state = state;
		this.stadium = stadium;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getStadium() {
		return stadium;
	}
	
	
	
	
}
