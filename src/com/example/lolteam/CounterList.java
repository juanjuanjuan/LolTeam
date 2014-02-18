package com.example.lolteam;

import java.util.ArrayList;

import model.Champion;
import model.ChampionDAO;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

public class CounterList extends Activity {
	
	ChampionDAO cDAO = new ChampionDAO();
	private ArrayList<String> champListNames = new ArrayList<String>();
	private ArrayList<String> counterChampListNames = new ArrayList<String>();
	Champion cSelected = new Champion();
	ImageButton cSelectedImg = null;
	ListView counterList = null;
	Button btnBack = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_counter_list);
		
		if (champListNames.size() == 0) 
			champListNames = cDAO.getAllChampNames();
		
		cSelectedImg = (ImageButton) findViewById(R.id.imageView_CL_SelChamp);
		counterList = (ListView) findViewById(R.id.listView_CL_Results);
		btnBack = (Button) findViewById(R.id.btn_CL_Back);
		
		irSelectChamp();
		
		cSelectedImg.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				irSelectChamp();
			}
		});
		btnBack.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
	}
	
	private void irSelectChamp() {
		Intent irSelectChamp = new Intent(this, SelectChampActivity.class);
		irSelectChamp.putExtra("allChamps", champListNames);
		startActivityForResult(irSelectChamp, 0);
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if (requestCode == 0 && data != null) {
	    	cSelected = cDAO.getChamp(data.getStringExtra("champ"));
	    	cSelectedImg.setImageResource(cSelected.getImg());
	    	counterChampListNames = cDAO.getCounterChampNames(cSelected.getName());
	    	
	    	final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, 
					android.R.layout.simple_list_item_1, android.R.id.text1, counterChampListNames);
			
			counterList.setAdapter(arrayAdapter);
	    }
	}

}
