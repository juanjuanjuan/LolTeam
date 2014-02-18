package com.example.lolteam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Button btn_Main_Team = null;
	Button btn_Main_CL = null;
	Button btn_Main_Exit = null;
	Button btn_Main_PI = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btn_Main_Team = (Button) findViewById(R.id.btnMainTeam);
		btn_Main_CL = (Button) findViewById(R.id.btnMainCounterList);
		btn_Main_Exit = (Button) findViewById(R.id.btnMainExit);
		btn_Main_PI = (Button) findViewById(R.id.btnMainPlayerInfo);
		
		btn_Main_Team.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				irTeamBuilder();
			}
		});
		btn_Main_CL.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				irCounterList();
			}
		});
		btn_Main_PI.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				irPlayerInfo();
			}
		});
		btn_Main_Exit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
	}
	
	private void irTeamBuilder() {
		Intent irTeamBuilder = new Intent(this, TeamBuilderActivity.class);
		
		startActivity(irTeamBuilder);
	}
	
	private void irCounterList() {
		Intent irCounterList = new Intent(this, CounterList.class);
		
		startActivity(irCounterList);
	}
	
	private void irPlayerInfo() {
		Intent irPlayerInfo = new Intent(this, PlayerInfo.class);
		
		startActivity(irPlayerInfo);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case R.id.menu_exit:
	            finish();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
