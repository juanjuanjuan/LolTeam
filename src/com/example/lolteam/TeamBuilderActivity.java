package com.example.lolteam;

import java.util.ArrayList;

import model.Champion;
import model.ChampionDAO;
import model.Partida;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class TeamBuilderActivity extends Activity {
	
	Champion top1 = null;
	Champion jg1 = null;
	Champion mid1 = null;
	Champion supp1 = null;
	Champion adc1 = null;
	Champion top2 = null;
	Champion jg2 = null;
	Champion mid2 = null;
	Champion supp2 = null;
	Champion adc2 = null;
	String aux = "";
	Button btn_Calcular = null;
	ChampionDAO cDAO = new ChampionDAO();
	
	ImageButton iTop1 = null;
	ImageButton iJg1 = null;
	ImageButton iMid1 = null;
	ImageButton iSupp1 = null;
	ImageButton iAdc1 = null;
	ImageButton iTop2 = null;
	ImageButton iJg2 = null;
	ImageButton iMid2 = null;
	ImageButton iSupp2 = null;
	ImageButton iAdc2 = null;
	ImageButton img_temp = null;
		
	private ArrayList<String> champListNames = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_team_builder);
		
		if (champListNames.size() == 0) 
			champListNames = cDAO.getAllChampNames();
		
		btn_Calcular = (Button) findViewById(R.id.btnCalc);
		
		iTop1 = (ImageButton) findViewById(R.id.imageButton_TB_Top1);
		iJg1 = (ImageButton) findViewById(R.id.imageButton_TB_JG1);
		iMid1 = (ImageButton) findViewById(R.id.imageButton_TB_Mid1);
		iSupp1 = (ImageButton) findViewById(R.id.imageButton_TB_Supp1);
		iAdc1 = (ImageButton) findViewById(R.id.imageButton_TB_ADC1);
		iTop2 = (ImageButton) findViewById(R.id.imageButton_TB_Top2);
		iJg2 = (ImageButton) findViewById(R.id.imageButton_TB_JG2);
		iMid2 = (ImageButton) findViewById(R.id.imageButton_TB_Mid2);
		iSupp2 = (ImageButton) findViewById(R.id.imageButton_TB_Supp2);
		iAdc2 = (ImageButton) findViewById(R.id.imageButton_TB_ADC2);
		
		iTop1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				irSelectChamp(iTop1, "top1");
			}
		});
		iJg1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				irSelectChamp(iJg1, "jg1");
			}
		});
		iMid1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				irSelectChamp(iMid1, "mid1");
			}
		});
		iSupp1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				irSelectChamp(iSupp1, "supp1");
			}
		});
		iAdc1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				irSelectChamp(iAdc1, "adc1");
			}
		});
		iTop2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				irSelectChamp(iTop2, "top2");
			}
		});
		iJg2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				irSelectChamp(iJg2, "jg2");
			}
		});
		iMid2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				irSelectChamp(iMid2, "mid2");
			}
		});
		iSupp2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				irSelectChamp(iSupp2, "supp2");
			}
		});
		iAdc2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				irSelectChamp(iAdc2, "adc2");
			}
		});
		btn_Calcular.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				irResultado();
			}
		});
	}
	
	private void irSelectChamp(ImageButton img, String btn) {
		img_temp = img;
		aux = btn;
		Intent irSelectChamp = new Intent(this, SelectChampActivity.class);
		
		irSelectChamp.putExtra("allChamps", champListNames);
		
		startActivityForResult(irSelectChamp, 0);
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if (requestCode == 0 && data != null) {
//	    	txt_temp.setTypeface(null, Typeface.BOLD);
	    	Champion c = cDAO.getChamp(data.getStringExtra("champ"));
	    	assignChamp(aux, c);
	    	img_temp.setImageResource(c.getImg());
	    }
	}
	
	private void irResultado() {
		Partida p = new Partida();
		fillChamps();
		p.setTeam(1, top1, jg1, mid1, supp1, adc1);
		p.setTeam(2, top2, jg2, mid2, supp2, adc2); 
		
		p.setwTop(cDAO.calcularVS(top1.getName(), top2.getName()));
		p.setwJG(cDAO.calcularVS(jg1.getName(), jg2.getName()));
		p.setwMid(cDAO.calcularVS(mid1.getName(), mid2.getName()));
		p.setwSupp(cDAO.calcularVS(supp1.getName(), supp2.getName()));
		p.setwADC(cDAO.calcularVS(adc1.getName(), adc2.getName()));
		
		Intent irResultado = new Intent(this, ResultActivity.class);
		irResultado.putExtra("partida", p);
		
		startActivity(irResultado);
	}
	
	private void fillChamps() {
		if (top1 == null) top1 = new Champion();
		if (jg1 == null) jg1 = new Champion();
		if (mid1 == null) mid1 = new Champion();
		if (supp1 == null) supp1 = new Champion();
		if (adc1 == null) adc1 = new Champion();
		if (top2 == null) top2 = new Champion();
		if (jg2 == null) jg2 = new Champion();
		if (mid2 == null) mid2 = new Champion();
		if (supp2 == null) supp2 = new Champion();
		if (adc2 == null) adc2 =new Champion();
	}
	
	private void assignChamp(String s, Champion c) {
		if (s.equalsIgnoreCase("top1")) top1 = c;
		if (s.equalsIgnoreCase("jg1")) jg1 = c;
		if (s.equalsIgnoreCase("mid1")) mid1 = c;
		if (s.equalsIgnoreCase("supp1")) supp1 = c;
		if (s.equalsIgnoreCase("adc1")) adc1 = c;
		if (s.equalsIgnoreCase("top2")) top2 = c;
		if (s.equalsIgnoreCase("jg2")) jg2 = c;
		if (s.equalsIgnoreCase("mid2")) mid2 = c;
		if (s.equalsIgnoreCase("supp2")) supp2 = c;
		if (s.equalsIgnoreCase("adc2")) adc2 = c;
	}
}
