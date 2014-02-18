package model;

import java.io.Serializable;
import java.util.ArrayList;


public class Partida implements Serializable {
	private static final long serialVersionUID = 7197967662959187780L;
	
	private ArrayList<Champion> team1 = new ArrayList<Champion>();
	private ArrayList<Champion> team2 = new ArrayList<Champion>();
	private int[] skills1 = new int[5];
	private int[] skills2 = new int[5];
	private int[] stats1 = new int[4];
	private int[] stats2 = new int[4];
	
	private int wTop = 0;
	private int wJG = 0;
	private int wMid = 0;
	private int wSupp = 0;
	private int wADC = 0;
	
	public void setTeam(int t, Champion top, Champion jg, Champion mid, Champion supp, Champion adc) {
		if (t == 1) {
			team1.add(top);
			team1.add(jg);
			team1.add(mid);
			team1.add(supp);
			team1.add(adc);
		} else {
			team2.add(top);
			team2.add(jg);
			team2.add(mid);
			team2.add(supp);
			team2.add(adc);
		}
	}
	
	public Champion getChamp(int pos, int t) {
		return (t==1)?team1.get(pos):team2.get(pos);
	}
	
	public int getStat(int stat, int t) {
		return (t==1)?stats1[stat]:stats2[stat];
	}
	
	public int getwTop() {
		return wTop;
	}
	public void setwTop(int wTop) {
		this.wTop = wTop;
	}
	public int getwJG() {
		return wJG;
	}
	public void setwJG(int wJG) {
		this.wJG = wJG;
	}
	public int getwMid() {
		return wMid;
	}
	public void setwMid(int wMid) {
		this.wMid = wMid;
	}
	public int getwSupp() {
		return wSupp;
	}
	public void setwSupp(int wSupp) {
		this.wSupp = wSupp;
	}
	public int getwADC() {
		return wADC;
	}
	public void setwADC(int wADC) {
		this.wADC = wADC;
	}
	public void setTeamScores() {
		
		for (Champion c : team1) {
			skills1[0] += c.getPoke();
			skills1[1] += c.getSplitpush();
			skills1[2] += c.getAoe();
			skills1[3] += c.getPeel();
			skills1[4] += c.getDive();
		}
		for (Champion c : team2) {
			skills2[0] += c.getPoke();
			skills2[1] += c.getSplitpush();
			skills2[2] += c.getAoe();
			skills2[3] += c.getPeel();
			skills2[4] += c.getDive();
		}
	}
	
	public void setTeamStats() {
		int coef = 10/5;
		for (Champion c : team1) {
			stats1[0] += c.getAd()*coef;
			stats1[1] += c.getAp()*coef;
			stats1[2] += c.getHp()*coef;
			stats1[3] += c.getDiff()*coef;
		}
		for (Champion c : team2) {
			stats2[0] += c.getAd()*coef;
			stats2[1] += c.getAp()*coef;
			stats2[2] += c.getHp()*coef;
			stats2[3] += c.getDiff()*coef;
		}
	}
	
	public String getSkills(String value, int t) {
		int[] team = null;
		team = (t==1)?skills1:skills2;
		
		int maxVal= 0;
		int minVal = 0;
		if (value.equalsIgnoreCase("Excelent")) {
			maxVal = 15;
			minVal = 12;
		}
		if (value.equalsIgnoreCase("Good")){ 
			maxVal = 11;
			minVal = 7;
		}
		if (value.equalsIgnoreCase("Bad")) {
			maxVal = 6;
			minVal = 0;
		}
		String desc = "";
		for (int i = 0; i < team.length; i++) {
			if (team[i] >= minVal && team[i] <= maxVal) {
				if (desc.length() > 0)
					desc += ",";
				switch (i) {
					case 0: desc += " Poke";	break;
					case 1: desc += " Splitpush";	break;
					case 2: desc += " AOE";	break;
					case 3: desc += " Peel";	break;
					case 4: desc += " Dive";	break;
				}
				desc += " ("+(team[i]*100/15)+"%)";
			}
		}
		return desc;
	}
	
}
