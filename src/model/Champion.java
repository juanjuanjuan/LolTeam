package model;

import java.io.Serializable;

public class Champion implements Serializable {
	private static final long serialVersionUID = 4654549790175804404L;
	
	private String name = "NONE";
	private int img = 0;
	private int poke = 0;
	private int aoe = 0;
	private int peel = 0;
	private int dive = 0;
	private int splitpush = 0;
	private int ad = 0;
	private int ap = 0;
	private int hp = 0;
	private int diff = 0;
	
	//BORRAR ESTE CUANDO ESTEN TODOS CON IMG
	public Champion(String name, int poke, int aoe, int peel, int dive, int split, 
			int ad, int ap, int hp, int diff) {
		this.name = name;
		this.poke = poke;
		this.aoe = aoe;
		this.peel = peel;
		this.dive = dive;
		splitpush = split;
		this.ad = ad;
		this.ap = ap;
		this.hp = hp;
		this.diff = diff;
	}
	
	public Champion() {
		
	}
	
	public Champion(String name, int poke, int aoe, int peel, int dive, int split, 
			int ad, int ap, int hp, int diff, int img) {
		this.name = name;
		this.poke = poke;
		this.aoe = aoe;
		this.peel = peel;
		this.dive = dive;
		splitpush = split;
		this.ad = ad;
		this.ap = ap;
		this.hp = hp;
		this.diff = diff;
		this.img = img;
	}
	
	public String getName() {
		return name;
	}
	
	public void setImg(int img) {
		this.img = img;
	}
	
	public int getImg() {
		return img;
	}

	public int getPoke() {
		return poke;
	}

	public int getAoe() {
		return aoe;
	}

	public int getPeel() {
		return peel;
	}

	public int getDive() {
		return dive;
	}

	public int getSplitpush() {
		return splitpush;
	}

	public int getAd() {
		return ad;
	}

	public int getAp() {
		return ap;
	}

	public int getHp() {
		return hp;
	}

	public int getDiff() {
		return diff;
	}
}
