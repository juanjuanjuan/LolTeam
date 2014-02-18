package model;

import java.util.ArrayList;

import com.example.lolteam.R;

public class ChampionDAO {
	
	private ArrayList<Champion> allChamps = new ArrayList<Champion>();
	private ArrayList<ChampionVS> allChampsVS = new ArrayList<ChampionVS>();
	
	public ChampionDAO() {
		loadAll();
		cargaVS();
	}
	
	private void loadAll() {
		//NOMBRE, Poke, AOE, Peel, Dive, Splitpush, AD, AP, HP, Diff, IMG.
		allChamps.add(new Champion("Aatrox", 0, 1, 1, 3, 0, 8, 4, 3, 6, R.drawable.aatrox));
		allChamps.add(new Champion("Ahri", 3, 2, 1, 3, 0, 3, 4, 8, 8, R.drawable.ahri));
		allChamps.add(new Champion("Akali", 0, 1, 0, 3, 0, 5, 3, 8, 6, R.drawable.akali));
		allChamps.add(new Champion("Alistar", 0, 2, 3, 3, 0, 6, 9, 5, 8, R.drawable.alistar));
		allChamps.add(new Champion("Amumu", 0, 3, 2, 3, 0, 2, 6, 8, 4, R.drawable.amumu));
		allChamps.add(new Champion("Anivia", 3, 2, 1, 0, 0, 1, 4, 10, 8, R.drawable.anivia));
		allChamps.add(new Champion("Annie", 2, 3, 2, 2, 0, 2, 3, 10, 4, R.drawable.annie));
		allChamps.add(new Champion("Ashe", 2, 3, 2, 0, 0, 7, 3, 2, 4, R.drawable.ashe));
		allChamps.add(new Champion("Blitzcrank", 2, 2, 2, 0, 2, 4, 8, 5, 6, R.drawable.blitzcrank));
		allChamps.add(new Champion("Brand", 3, 3, 1, 0, 0, 2, 2, 9, 6, R.drawable.brand));
		allChamps.add(new Champion("Caitlyn", 3, 2, 1, 0, 0, 8, 2, 2, 4, R.drawable.caitlyn));
		allChamps.add(new Champion("Cassiopeia", 2, 3, 3, 0, 0, 2, 3, 9, 10, R.drawable.cassiopeia));
		allChamps.add(new Champion("Cho'Gath", 2, 3, 3, 0, 0, 3, 7, 7, 7, R.drawable.chogath));
		allChamps.add(new Champion("Corki", 3, 2, 0, 3, 3, 8, 3, 6, 7, R.drawable.corki));
		allChamps.add(new Champion("Darius", 0, 3, 0, 3, 0, 9, 5, 1, 4, R.drawable.darius));
		allChamps.add(new Champion("Diana", 2, 1, 0, 3, 0, 7, 6, 8, 4, R.drawable.diana));
		allChamps.add(new Champion("Dr. Mundo", 2, 1, 3, 0, 1, 5, 7, 6, 4, R.drawable.drmundo));
		allChamps.add(new Champion("Draven", 3, 1, 1, 0, 2, 9, 3, 1, 10, R.drawable.draven));
		allChamps.add(new Champion("Elise", 2, 0, 1, 3, 1, 6, 5, 7, 8, R.drawable.elise));
		allChamps.add(new Champion("Evelynn", 0, 3, 1, 3, 3, 4, 2, 7, 8, R.drawable.evelynn));
		allChamps.add(new Champion("Ezreal", 3, 2, 1, 1, 2, 7, 2, 6, 8, R.drawable.ezreal));
		allChamps.add(new Champion("Fiddlesticks", 1, 3, 3, 3, 0, 2, 3, 9, 5, R.drawable.fiddlesticks));
		allChamps.add(new Champion("Fiora", 0, 0, 0, 0, 0, 10, 4, 2, 5, R.drawable.fiora)); //VER
		allChamps.add(new Champion("Fizz", 1, 1, 0, 3, 1, 6, 4, 7, 8, R.drawable.fizz));
		allChamps.add(new Champion("Galio", 0, 0, 3, 0, 0, 3, 7, 6, 4, R.drawable.galio)); //VER
		allChamps.add(new Champion("Gangplank", 0, 0, 0, 0, 0, 7, 6, 4, 5, R.drawable.gangplank)); //VER
		allChamps.add(new Champion("Garen", 0, 3, 2, 0, 2, 7, 7, 1, 2, R.drawable.garen));
		allChamps.add(new Champion("Gragas", 3, 3, 2, 3, 0, 5, 6, 7, 6, R.drawable.gragas));
		allChamps.add(new Champion("Graves", 0, 3, 0, 3, 0, 8, 5, 3, 4, R.drawable.graves)); //VER
		allChamps.add(new Champion("Hecarim", 0, 1, 3, 3, 2, 8, 6, 4, 5, R.drawable.hecarim));
		allChamps.add(new Champion("Heimerdinger", 0, 0, 0, 0, 0, 2, 6, 8, 4, R.drawable.heimerdinger)); //VER
		allChamps.add(new Champion("Irelia", 0, 0, 0, 3, 0, 7, 4, 5, 4, R.drawable.irelia)); //VER
		allChamps.add(new Champion("Janna", 2, 3, 3, 0, 0, 3, 5, 7, 9, R.drawable.janna));
		allChamps.add(new Champion("Jarvan IV", 2, 3, 0, 3, 2, 6, 8, 3, 5, R.drawable.jarvaniv));
		allChamps.add(new Champion("Jax", 0, 0, 1, 3, 3, 7, 5, 7, 6, R.drawable.jax));
		allChamps.add(new Champion("Jayce", 3, 2, 2, 1, 0, 8, 4, 3, 8, R.drawable.jayce));
		allChamps.add(new Champion("Jinx", 2, 3, 1, 0, 1, 9, 2, 4, 9, R.drawable.jinx));
		allChamps.add(new Champion("Karma", 0, 0, 0, 0, 2, 1, 7, 8, 8, R.drawable.karma)); //VER
		allChamps.add(new Champion("Karthus", 1, 3, 1, 3, 1, 2, 2, 10, 8, R.drawable.karthus));
		allChamps.add(new Champion("Kassadin", 0, 2, 1, 3, 3, 3, 5, 8, 8, R.drawable.kassadin));
		allChamps.add(new Champion("Katarina", 0, 3, 0, 3, 0, 4, 3, 9, 5, R.drawable.katarina));
		allChamps.add(new Champion("Kayle", 1, 3, 3, 0, 0, 6, 6, 7, 5, R.drawable.kayle));
		allChamps.add(new Champion("Kennen", 1, 3, 0, 3, 3, 6, 4, 7, 5, R.drawable.kennen));
		allChamps.add(new Champion("Kha'Zix", 0, 2, 0, 3, 2, 9, 4, 3, 7, R.drawable.khazix));
		allChamps.add(new Champion("Kog'Maw", 3, 2, 3, 0, 0, 8, 2, 5, 8, R.drawable.kogmaw));
		allChamps.add(new Champion("LeBlanc", 3, 1, 2, 0, 2, 1, 4, 10, 9, R.drawable.leblanc));
		allChamps.add(new Champion("Lee Sin", 1, 2, 2, 3, 3, 8, 5, 3, 9, R.drawable.leesin));
		allChamps.add(new Champion("Leona", 0, 3, 2, 3, 0, 4, 8, 3, 4, R.drawable.leona));
		allChamps.add(new Champion("Lissandra", 1, 3, 1, 3, 1, 2, 5, 8, 8, R.drawable.lissandra));
		allChamps.add(new Champion("Lucian", 3, 3, 0, 1, 0, 8, 5, 3, 8, R.drawable.lucian));
		allChamps.add(new Champion("Lulu", 1, 3, 3, 0, 0, 4, 5, 7, 7, R.drawable.lulu));
		allChamps.add(new Champion("Lux", 3, 3, 1, 0, 0, 2, 4, 9, 6, R.drawable.lux));
		allChamps.add(new Champion("Malphite", 1, 2, 2, 3, 0, 5, 9, 7, 3, R.drawable.malphite));
		allChamps.add(new Champion("Malzahar", 1, 3, 1, 0, 2, 2, 2, 9, 6, R.drawable.malzahar));
		allChamps.add(new Champion("Maokai", 2, 2, 1, 0, 3, 0, 8, 6, 4, R.drawable.maokai)); //VER
		allChamps.add(new Champion("Master Yi", 0, 2, 0, 3, 3, 10, 4, 2, 2, R.drawable.masteryi));
		allChamps.add(new Champion("Miss Fortune", 1, 3, 0, 0, 0, 8, 2, 5, 3, R.drawable.missfortune));
		allChamps.add(new Champion("Mordekaiser", 0, 3, 1, 1, 0, 4, 6, 7, 3, R.drawable.mordekaiser));
		allChamps.add(new Champion("Morgana", 2, 3, 3, 0, 0, 1, 6, 8, 6, R.drawable.morgana));
		allChamps.add(new Champion("Nami", 1, 3, 3, 3, 0, 4, 3, 7, 8, R.drawable.nami));
		allChamps.add(new Champion("Nasus", 0, 1, 3, 2, 1, 7, 5, 6, 2, R.drawable.nasus)); //VER
		allChamps.add(new Champion("Nautilus", 0, 2, 3, 3, 0, 4, 6, 6, 6, R.drawable.nautilus));
		allChamps.add(new Champion("Nidalee", 3, 0, 3, 1, 2, 5, 4, 7, 7, R.drawable.nidalee));
		allChamps.add(new Champion("Nocturne", 0, 0, 1, 3, 2, 9, 5, 2, 6, R.drawable.nocturne));
		allChamps.add(new Champion("Nunu", 1, 3, 3, 0, 0, 4, 6, 7, 1, R.drawable.nunu)); //VER
		allChamps.add(new Champion("Olaf", 3, 0, 2, 0, 0, 9, 5, 3, 4, R.drawable.olaf));
		allChamps.add(new Champion("Orianna", 2, 3, 3, 0, 0, 4, 3, 9, 10, R.drawable.orianna));
		allChamps.add(new Champion("Pantheon", 1, 2, 1, 3, 3, 9, 4, 3, 5, R.drawable.pantheon));
		allChamps.add(new Champion("Poppy", 0, 0, 0, 3, 0, 6, 6, 5, 7, R.drawable.poppy)); //VER
		allChamps.add(new Champion("Quinn", 0, 0, 0, 3, 3, 9, 4, 2, 7, R.drawable.quinn)); //VER
		allChamps.add(new Champion("Rammus", 0, 2, 3, 1, 3, 4, 10, 5, 5, R.drawable.rammus));
		allChamps.add(new Champion("Renekton", 0, 3, 1, 3, 2, 8, 5, 2, 3, R.drawable.renekton));
		allChamps.add(new Champion("Rengar", 0, 0, 0, 3, 3, 7, 4, 2, 5, R.drawable.rengar));
		allChamps.add(new Champion("Riven", 0, 3, 0, 2, 2, 8, 5, 1, 4, R.drawable.riven));
		allChamps.add(new Champion("Rumble", 3, 3, 0, 0, 0, 3, 6, 8, 8, R.drawable.rumble)); //VER
		allChamps.add(new Champion("Ryze", 3, 3, 3, 0, 0, 2, 2, 10, 3, R.drawable.ryze));
		allChamps.add(new Champion("Sejuani", 0, 3, 2, 3, 0, 5, 7, 6, 4, R.drawable.sejuani));
		allChamps.add(new Champion("Shaco", 0, 0, 2, 3, 3, 8, 4, 6, 9, R.drawable.shaco));
		allChamps.add(new Champion("Shen", 0, 0, 3, 2, 3, 3, 9, 3, 3, R.drawable.shen));
		allChamps.add(new Champion("Shyvana", 0, 0, 0, 0, 0, 8, 6, 3, 4, R.drawable.shyvana)); //VER
		allChamps.add(new Champion("Singed", 0, 1, 3, 0, 3, 4, 8, 7, 5, R.drawable.singed));
		allChamps.add(new Champion("Sion", 0, 0, 0, 0, 0, 5, 8, 7, 4, R.drawable.sion)); //VER
		allChamps.add(new Champion("Sivir", 3, 3, 1, 0, 1, 9, 3, 1, 3, R.drawable.sivir));
		allChamps.add(new Champion("Skarner", 0, 0, 0, 0, 0, 7, 6, 5, 5, R.drawable.skarner)); //VER
		allChamps.add(new Champion("Sona", 2, 3, 0, 3, 0, 5, 2, 8, 1, R.drawable.sona)); //VER
		allChamps.add(new Champion("Soraka", 2, 0, 0, 0, 0, 2, 5, 7, 3, R.drawable.soraka)); //VER
		allChamps.add(new Champion("Swain", 0, 3, 3, 0, 0, 2, 6, 9, 5, R.drawable.swain));
		allChamps.add(new Champion("Syndra", 3, 3, 1, 0, 0, 2, 3, 9, 10, R.drawable.syndra));
		allChamps.add(new Champion("Talon", 0, 2, 0, 3, 3, 9, 3, 1, 6, R.drawable.talon));
		allChamps.add(new Champion("Taric", 0, 0, 3, 2, 2, 4, 8, 5, 3, R.drawable.taric));
		allChamps.add(new Champion("Teemo", 2, 1, 2, 0, 3, 5, 3, 7, 4, R.drawable.teemo));
		allChamps.add(new Champion("Thresh", 0, 2, 3, 3, 0, 5, 6, 6, 7, R.drawable.thresh));
		allChamps.add(new Champion("Tristana", 0, 0, 3, 0, 0, 9, 3, 5, 3, R.drawable.tristana)); //VER
		allChamps.add(new Champion("Trundle", 2, 0, 0, 0, 0, 7, 6, 2, 5, R.drawable.trundle)); //VER
		allChamps.add(new Champion("Tryndamere", 0, 0, 1, 3, 3, 10, 5, 2, 6, R.drawable.tryndamere));
		allChamps.add(new Champion("Twisted Fate", 2, 2, 0, 3, 3, 6, 2, 6, 9, R.drawable.twistedfate));
		allChamps.add(new Champion("Twitch", 1, 3, 3, 2, 2, 9, 2, 3, 8, R.drawable.twitch));
		allChamps.add(new Champion("Udyr", 0, 0, 3, 2, 3, 8, 7, 4, 5, R.drawable.udyr));
		allChamps.add(new Champion("Urgot", 0, 0, 0, 3, 0, 8, 5, 3, 8, R.drawable.urgot)); //VER
		allChamps.add(new Champion("Varus", 3, 2, 0, 0, 0, 7, 3, 4, 6, R.drawable.varus));
		allChamps.add(new Champion("Vayne", 0, 0, 3, 2, 2, 10, 1, 1, 7, R.drawable.vayne));
		allChamps.add(new Champion("Veigar", 3, 2, 2, 0, 0, 2, 2, 10, 6, R.drawable.veigar));
		allChamps.add(new Champion("Vi", 0, 3, 0, 3, 1, 8, 5, 3, 5, R.drawable.vi));
		allChamps.add(new Champion("Viktor", 0, 0, 0, 0, 0, 2, 5, 9, 9, R.drawable.viktor)); //VER
		allChamps.add(new Champion("Vladimir", 0, 3, 0, 2, 0, 2, 6, 8, 2, R.drawable.vladimir));
		allChamps.add(new Champion("Volibear", 0, 2, 3, 2, 2, 7, 7, 4, 2, R.drawable.volibear));
		allChamps.add(new Champion("Warwick", 0, 0, 2, 3, 2, 7, 4, 4, 2, R.drawable.warwick));
		allChamps.add(new Champion("Wukong", 0, 3, 0, 3, 2, 8, 5, 2, 3, R.drawable.monkeyking));
		allChamps.add(new Champion("Xerath", 3, 3, 0, 0, 0, 1, 3, 10, 6, R.drawable.xerath)); //VER
		allChamps.add(new Champion("Xin Zhao", 0, 0, 2, 3, 1, 8, 6, 3, 3, R.drawable.xinzhao));
		allChamps.add(new Champion("Yasuo", 0, 2, 1, 3, 0, 8, 4, 4, 8, R.drawable.yasuo));
		allChamps.add(new Champion("Yorick", 0, 0, 3, 0, 0, 6, 6, 6, 3, R.drawable.yorick)); //VER
		allChamps.add(new Champion("Zac", 0, 3, 1, 3, 1, 3, 7, 7, 6, R.drawable.zac));
		allChamps.add(new Champion("Zed", 0, 2, 0, 3, 3, 9, 2, 1, 9, R.drawable.zed));
		allChamps.add(new Champion("Ziggs", 3, 3, 1, 0, 2, 2, 4, 9, 6, R.drawable.ziggs));
		allChamps.add(new Champion("Zilean", 2, 3, 3, 0, 0, 2, 5, 8, 4, R.drawable.zilean));
		allChamps.add(new Champion("Zyra", 2, 3, 3, 0, 0, 4, 3, 8, 7, R.drawable.zyra));
	}
	
	public ArrayList<Champion> getAllChamp() {
		return allChamps;
	}
	
	public ArrayList<String> getAllChampNames() {
		ArrayList<String> allChampsNames = new ArrayList<String>();
		for (Champion c : allChamps) {
			allChampsNames.add(c.getName());
		}
		return allChampsNames;
	}
	
	public Champion getChamp(String name) {
		for (Champion c : allChamps) {
			if (c.getName().equalsIgnoreCase(name))
				return c;
		}
		return (new Champion("NONE", 0, 0, 0, 0, 0, 0, 0, 0, 0));
	}
	
	private void cargaVS() {
		allChampsVS.add(new ChampionVS(getChamp("Annie"), getChamp("Yasuo")));
		allChampsVS.add(new ChampionVS(getChamp("Ryze"), getChamp("Yasuo")));
		allChampsVS.add(new ChampionVS(getChamp("Swain"), getChamp("Yasuo")));
		allChampsVS.add(new ChampionVS(getChamp("Cassiopeia"), getChamp("Yasuo")));
		allChampsVS.add(new ChampionVS(getChamp("Yasuo"), getChamp("Karthus")));
		allChampsVS.add(new ChampionVS(getChamp("Yasuo"), getChamp("Akali")));
		allChampsVS.add(new ChampionVS(getChamp("Yasuo"), getChamp("Anivia")));
		allChampsVS.add(new ChampionVS(getChamp("Yasuo"), getChamp("Cho'Gath")));
		allChampsVS.add(new ChampionVS(getChamp("Yasuo"), getChamp("Diana")));
		allChampsVS.add(new ChampionVS(getChamp("Yasuo"), getChamp("Elise")));
		allChampsVS.add(new ChampionVS(getChamp("Yasuo"), getChamp("Evelynn")));
		allChampsVS.add(new ChampionVS(getChamp("Yasuo"), getChamp("Ezreal")));
		allChampsVS.add(new ChampionVS(getChamp("Yasuo"), getChamp("Fiddlesticks")));
		allChampsVS.add(new ChampionVS(getChamp("Yasuo"), getChamp("Gragas")));
		allChampsVS.add(new ChampionVS(getChamp("Yasuo"), getChamp("Sion")));
		allChampsVS.add(new ChampionVS(getChamp("Yasuo"), getChamp("Teemo")));
		allChampsVS.add(new ChampionVS(getChamp("Yasuo"), getChamp("Zed")));
	}
	
	public int calcularVS(String uno, String dos) {
		if (uno.equalsIgnoreCase("none") && !dos.equalsIgnoreCase("none"))
			return 2;
		if (dos.equalsIgnoreCase("none") && !uno.equalsIgnoreCase("none"))
			return 1;
		for (ChampionVS c : allChampsVS) {
			if (c.getGanador().getName().equalsIgnoreCase(uno) &&
				c.getPerdedor().getName().equalsIgnoreCase(dos))
				return 1;
			if (c.getGanador().getName().equalsIgnoreCase(dos) &&
				c.getPerdedor().getName().equalsIgnoreCase(uno))
				return 2;
		}
		return 0;
	}
	
	public ArrayList<String> getCounterChampNames(String champ) {
		ArrayList<String> counterChampsNames = new ArrayList<String>();
		for (Champion c : allChamps) {
			if (calcularVS(champ, c.getName()) == 2)
				counterChampsNames.add(c.getName());
		}
		return counterChampsNames;
	} 
}
