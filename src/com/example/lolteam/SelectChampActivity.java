package com.example.lolteam;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class SelectChampActivity extends Activity {
	
	ListView listChamp = null;
	private EditText filterBox = null;
	private ArrayList<String> allChamps = new ArrayList<String>();
	ArrayAdapter<String> arrayAdapter = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_champ);
		
		listChamp = (ListView) findViewById(R.id.listViewChampions);
		filterBox = (EditText) findViewById(R.id.editText_SC_search_box);
		
		Intent desdeTeamBuilder = this.getIntent();
		allChamps = desdeTeamBuilder.getStringArrayListExtra("allChamps");
		
		final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, 
				android.R.layout.simple_list_item_1, android.R.id.text1, allChamps);
		
		filterBox.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				arrayAdapter.getFilter().filter(s);
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}
			
			@Override
			public void afterTextChanged(Editable s) {
			}
		});
		
		listChamp.setAdapter(arrayAdapter);
		
		listChamp.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> a, View v, int pos, long l) {
				String selection = a.getAdapter().getItem(pos).toString();
				
				Intent volverTB = new Intent();
				volverTB.putExtra("champ", selection);
				setResult(0, volverTB);
				
				finish();
			}
		});
	}
}
