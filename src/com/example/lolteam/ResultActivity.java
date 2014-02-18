package com.example.lolteam;

import model.Champion;
import model.Partida;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends Activity {
	
	Partida p = null;
	
	TextView vsTop = null;
	TextView vsJG = null;
	TextView vsMid = null;
	TextView vsSupp = null;
	TextView vsADC = null;
	
	TextView winTop = null;
	TextView winJG = null;
	TextView winMid = null;
	TextView winSupp = null;
	TextView winADC = null;
	
	TextView tc_Skill_Excelent = null;
	TextView tc_Skill_Good = null;
	TextView tc_Skill_Bad = null;
	TextView tc_Stats_AD = null;
	TextView tc_Stats_AP = null;
	TextView tc_Stats_HP = null;
	TextView tc_Stats_Diff = null;
	
	TextView tc_Skill2_Excelent = null;
	TextView tc_Skill2_Good = null;
	TextView tc_Skill2_Bad = null;
	TextView tc_Stats2_AD = null;
	TextView tc_Stats2_AP = null;
	TextView tc_Stats2_HP = null;
	TextView tc_Stats2_Diff = null;
	
	Button btn_Back = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		
		vsTop = (TextView) findViewById(R.id.textView_Result_VSTop);
		vsJG = (TextView) findViewById(R.id.textView_Result_VSJG);
		vsMid = (TextView) findViewById(R.id.textView_Result_VSMid);
		vsSupp = (TextView) findViewById(R.id.textView_Result_VSSupp);
		vsADC = (TextView) findViewById(R.id.textView_Result_VSADC);
		winTop = (TextView) findViewById(R.id.textView_Result_wTop);
		winJG = (TextView) findViewById(R.id.textView_Result_wJG);
		winMid = (TextView) findViewById(R.id.textView_Result_wMid);
		winSupp = (TextView) findViewById(R.id.textView_Result_wSupp);
		winADC = (TextView) findViewById(R.id.textView_Result_wADC);
		
		tc_Skill_Excelent = (TextView) findViewById(R.id.textView_Result_TC_SkEx);
		tc_Skill_Good = (TextView) findViewById(R.id.textView_Result_TC_SkGo);
		tc_Skill_Bad = (TextView) findViewById(R.id.textView_Result_TC_SkBa);
		tc_Stats_AD = (TextView) findViewById(R.id.textView_Result_TC_StAD);
		tc_Stats_AP = (TextView) findViewById(R.id.textView_Result_TC_StAP);
		tc_Stats_HP = (TextView) findViewById(R.id.textView_Result_TC_StHP);
		tc_Stats_Diff = (TextView) findViewById(R.id.textView_Result_TC_StDiff);
		
		tc_Skill2_Excelent = (TextView) findViewById(R.id.textView_Result_TC_SkEx2);
		tc_Skill2_Good = (TextView) findViewById(R.id.textView_Result_TC_SkGo2);
		tc_Skill2_Bad = (TextView) findViewById(R.id.textView_Result_TC_SkBa2);
		tc_Stats2_AD = (TextView) findViewById(R.id.textView_Result_TC_StAD2);
		tc_Stats2_AP = (TextView) findViewById(R.id.textView_Result_TC_StAP2);
		tc_Stats2_HP = (TextView) findViewById(R.id.textView_Result_TC_StHP2);
		tc_Stats2_Diff = (TextView) findViewById(R.id.textView_Result_TC_StDiff2);
		
		btn_Back = (Button) findViewById(R.id.button_Result_Back);
		
		Intent deTB = this.getIntent();
		p = (Partida) deTB.getSerializableExtra("partida");
		
		setTexts(vsTop, winTop, p.getwTop(), p.getChamp(0, 1), p.getChamp(0, 2));
		setTexts(vsJG, winJG, p.getwJG(), p.getChamp(1, 1), p.getChamp(1, 2));
		setTexts(vsMid, winMid, p.getwMid(), p.getChamp(2, 1), p.getChamp(2, 2));
		setTexts(vsSupp, winSupp, p.getwSupp(), p.getChamp(3, 1), p.getChamp(3, 2));
		setTexts(vsADC, winADC, p.getwADC(), p.getChamp(4, 1), p.getChamp(4, 2));
		
		p.setTeamScores();
		setTeamCompositionScores();
		
		p.setTeamStats();
		setTeamStats();
		
		btn_Back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
	}
	
	private void setTexts(TextView text1, TextView textW, int winner, Champion p1, Champion p2) {
		text1.setText(p1.getName()+" - "+p2.getName());
		if (winner == 1) {
			textW.setText(p1.getName());
			textW.setBackgroundColor(Color.CYAN);
		} else {
			if (winner == 2) {
				textW.setText(p2.getName());
				textW.setBackgroundColor(Color.RED);
			} else {
				textW.setText("TIE");
				textW.setBackgroundColor(Color.YELLOW);
			}
		}
	}
	
	private void setTeamCompositionScores() {
		tc_Skill_Excelent.setText(tc_Skill_Excelent.getText()+p.getSkills("Excelent", 1));
		tc_Skill_Good.setText(tc_Skill_Good.getText()+p.getSkills("Good", 1));
		tc_Skill_Bad.setText(tc_Skill_Bad.getText()+p.getSkills("Bad", 1));
		
		tc_Skill2_Excelent.setText(tc_Skill2_Excelent.getText()+p.getSkills("Excelent", 2));
		tc_Skill2_Good.setText(tc_Skill2_Good.getText()+p.getSkills("Good", 2));
		tc_Skill2_Bad.setText(tc_Skill2_Bad.getText()+p.getSkills("Bad", 2));
	}
	
	private void setTeamStats() {
		tc_Stats_AD.setText(tc_Stats_AD.getText()+" "+p.getStat(0, 1)+"%");
		tc_Stats_AP.setText(tc_Stats_AP.getText()+" "+p.getStat(1, 1)+"%");
		tc_Stats_HP.setText(tc_Stats_HP.getText()+" "+p.getStat(2, 1)+"%");
		tc_Stats_Diff.setText(tc_Stats_Diff.getText()+" "+p.getStat(3, 1)+"%");
		
		tc_Stats2_AD.setText(tc_Stats2_AD.getText()+" "+p.getStat(0, 2)+"%");
		tc_Stats2_AP.setText(tc_Stats2_AP.getText()+" "+p.getStat(1, 2)+"%");
		tc_Stats2_HP.setText(tc_Stats2_HP.getText()+" "+p.getStat(2, 2)+"%");
		tc_Stats2_Diff.setText(tc_Stats2_Diff.getText()+" "+p.getStat(3, 2)+"%");
	}
}
