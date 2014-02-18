package model;

public class ChampionVS {
	
	private Champion ganador = null;
	private Champion perdedor = null;
	
	public ChampionVS(Champion g, Champion p) {
		ganador = g;
		perdedor = p;
	}
	public Champion getGanador() {
		return ganador;
	}

	public Champion getPerdedor() {
		return perdedor;
	}
}
