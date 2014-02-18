package com.example.lolteam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class PlayerInfo extends Activity {
	
	Button btnSearch = null;
	Button btnBack = null;
	Spinner spRealm = null;
	EditText summName = null;
	ListView results = null;
	ArrayList<String> resultArray = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player_info);
		
		btnSearch = (Button) findViewById(R.id.btn_PI_SearchSumm);
		btnBack = (Button) findViewById(R.id.btn_PI_Back);
		spRealm = (Spinner) findViewById(R.id.spinner_PI_Realm);
		summName = (EditText) findViewById(R.id.editText_PI_SummonerName);
		results = (ListView) findViewById(R.id.listView_PI_Results);
		
		final String[] realms =
		        new String[]{"BR","EUNE","EUW","KR","LAN","LAS","NA","OCE","RU","TR"};
		ArrayAdapter<String> adaptadorRealms = new ArrayAdapter<String>(this,
		            android.R.layout.simple_spinner_item, realms);
		spRealm.setAdapter(adaptadorRealms);
		
		btnSearch.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//TODO: HACER LLAMADA A RIOT API!!!
				try {
					cargarSummonerInfo("caperucitem", "las");
//					cargarSummonerInfo(summName.getText().toString(), spRealm.getSelectedItem().toString());
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		});
		btnBack.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
	
	private void cargarSummonerInfo(String name, String sv) throws JSONException {
		JSONObject json = new JSONObject(querySummStats(querySummID(name, sv), sv));
		JSONArray jsonChampions = json.getJSONArray("champions");
		JSONObject jsonChamp = null;
		JSONObject jsonChampStats = null;
		
		int totGames = 0;
		String stats = "";
		
		for (int i = 0; i < jsonChampions.length(); i++) {
			jsonChamp = jsonChampions.getJSONObject(i);
			jsonChampStats = jsonChamp.getJSONObject("stats");
			totGames = Integer.parseInt(jsonChampStats.getString("totalSessionsPlayed"));
			
			if (jsonChamp.getString("name").equalsIgnoreCase("Combined"))
				stats = "TOTAL:\n";
			else
				stats = jsonChamp.getString("name")+":\n";
			
			stats += "	Total Games: "+totGames+"\n"+
					"		Winrate: "+(100*(Integer.parseInt(jsonChampStats.getString("totalSessionsWon")))/totGames)+"%\n"+
					"		KDA: "+(Integer.parseInt(jsonChampStats.getString("totalChampionKills"))/totGames)+"/"+
							(Integer.parseInt(jsonChampStats.getString("totalDeathsPerSession"))/totGames)+"/"+
							(Integer.parseInt(jsonChampStats.getString("totalAssists"))/totGames)+"\n"+
					"		CS/game: "+(Integer.parseInt(jsonChampStats.getString("totalMinionKills"))/totGames)+"\n"+
					"		Gold/game: "+(Integer.parseInt(jsonChampStats.getString("totalGoldEarned"))/totGames)+"\n"+
					"		AD dealt/game: "+(Integer.parseInt(jsonChampStats.getString("totalPhysicalDamageDealt"))/totGames)+"\n"+
					"		AP dealt/game: "+(Integer.parseInt(jsonChampStats.getString("totalMagicDamageDealt"))/totGames)+"\n"+
					"		Total Doublekills: "+jsonChampStats.getString("totalDoubleKills")+"\n"+
					"		Total Triplekills: "+jsonChampStats.getString("totalTripleKills")+"\n"+
					"		Total Quadrakills: "+jsonChampStats.getString("totalQuadraKills")+"\n"+
					"		Total Pentakills: "+jsonChampStats.getString("totalPentaKills")+"\n"+
					"		Max Kills: "+jsonChampStats.getString("maxChampionsKilled");
			
			if (jsonChamp.getString("name").equalsIgnoreCase("Combined")) {
				int hsPlayed = Integer.parseInt(jsonChampStats.getString("maxTimePlayed"))/60;
				int hsAlive = Integer.parseInt(jsonChampStats.getString("maxTimeSpentLiving"))/60;
				stats += "\n"+ 
						"		Max Deaths: "+jsonChampStats.getString("maxNumDeaths")+"\n"+
						"		Best Killing Spree: "+jsonChampStats.getString("maxLargestKillingSpree")+"\n"+
						"		Best Critic: "+jsonChampStats.getString("maxLargestCriticalStrike")+"\n"+
						"		Hours played: "+hsPlayed+"\n"+
						"		Hours alive: "+hsAlive+"\n"+
						"		Hours death: "+(hsPlayed-hsAlive);
			}
			
			resultArray.add(stats);
		}
		
		ArrayAdapter<String> adaptadorResults = new ArrayAdapter<String>(this,
	            android.R.layout.simple_list_item_1, resultArray);
	 
		results.setAdapter(adaptadorResults);
	}
	
	ConsultaAsyncTask queryAsync = new ConsultaAsyncTask();
	String query = "";
	private int querySummID(String name, String sv) throws JSONException {
//		query = "{\"caperucitem\": {" +
//						   "\"id\": 250110," +
//						   "\"name\": \"CaperuciteM\"," +
//						   "\"profileIconId\": 604," +
//						   "\"revisionDate\": 1392232664000," +
//						   "\"summonerLevel\": 30" +
//						"}}";
		
//		prueba("https://prod.api.pvp.net/api/lol/las/v1.3/summoner/by-name/Caperucitem?api_key=1ac6dee9-fac0-44d4-8b4c-e29f6db07aab");
		
		queryAsync.execute("https://prod.api.pvp.net/api/lol/"+sv+"/v1.3/summoner/by-name/"+name+"?api_key=1ac6dee9-fac0-44d4-8b4c-e29f6db07aab");
		return (new JSONObject(query).getJSONObject(name).getInt("id"));
	}
	
	private String querySummStats(int id, String sv) {
		
		query = "";
		queryAsync.execute("https://prod.api.pvp.net/api/lol/"+sv+"/v1.2/stats/by-summoner/"+id+"/ranked?season=SEASON4&api_key=1ac6dee9-fac0-44d4-8b4c-e29f6db07aab");
		
		//https://prod.api.pvp.net/api/lol/las/v1.2/stats/by-summoner/250110/ranked?season=SEASON4&api_key=1ac6dee9-fac0-44d4-8b4c-e29f6db07aab
//		 String query = "{\"modifyDate\": 1392223756000," +
//				   "\"champions\": [" +
//				      "{" +
//				         "\"id\": 89," +
//				         "\"stats\": {" +
//				            "\"totalDeathsPerSession\": 31," +
//				            "\"totalSessionsPlayed\": 4," +
//				            "\"totalDamageTaken\": 94175," +
//				            "\"totalQuadraKills\": 0," +
//				            "\"totalTripleKills\": 0," +
//				            "\"totalMinionKills\": 103," +
//				            "\"maxChampionsKilled\": 5," +
//				            "\"totalDoubleKills\": 0," +
//				            "\"totalPhysicalDamageDealt\": 32315," +
//				            "\"totalChampionKills\": 14," +
//				            "\"totalAssists\": 56," +
//				            "\"mostChampionKillsPerSession\": 5," +
//				            "\"totalDamageDealt\": 150813," +
//				            "\"totalFirstBlood\": 0," +
//				            "\"totalSessionsLost\": 3," +
//				            "\"totalSessionsWon\": 1," +
//				            "\"totalMagicDamageDealt\": 113049," +
//				            "\"totalGoldEarned\": 41260," +
//				            "\"totalPentaKills\": 0," +
//				            "\"totalTurretsKilled\": 0," +
//				            "\"mostSpellsCast\": 0," +
//				            "\"maxNumDeaths\": 11," +
//				            "\"totalUnrealKills\": 0" +
//				         "}," +
//				         "\"name\": \"Leona\"" +
//				      "}," +
//				      "{" +
//				         "\"id\": 222," +
//				         "\"stats\": {" +
//				            "\"totalDeathsPerSession\": 72," +
//				            "\"totalSessionsPlayed\": 13," +
//				            "\"totalDamageTaken\": 268016," +
//				            "\"totalQuadraKills\": 1," +
//				            "\"totalTripleKills\": 2," +
//				            "\"totalMinionKills\": 2314," +
//				            "\"maxChampionsKilled\": 17," +
//				            "\"totalDoubleKills\": 7," +
//				            "\"totalPhysicalDamageDealt\": 1906168," +
//				            "\"totalChampionKills\": 112," +
//				            "\"totalAssists\": 119," +
//				            "\"mostChampionKillsPerSession\": 17," +
//				            "\"totalDamageDealt\": 1997951," +
//				            "\"totalFirstBlood\": 0," +
//				            "\"totalSessionsLost\": 6," +
//				            "\"totalSessionsWon\": 7," +
//				            "\"totalMagicDamageDealt\": 76264," +
//				            "\"totalGoldEarned\": 172197," +
//				            "\"totalPentaKills\": 0," +
//				            "\"totalTurretsKilled\": 33," +
//				            "\"mostSpellsCast\": 0," +
//				            "\"maxNumDeaths\": 11," +
//				            "\"totalUnrealKills\": 0" +
//				         "}," +
//				         "\"name\": \"Jinx\"" +
//				      "}," +
//				      "{" +
//				         "\"id\": 0," +
//				         "\"stats\": {" +
//				            "\"totalDamageTaken\": 2344063," +
//				            "\"totalTripleKills\": 13," +
//				            "\"totalMinionKills\": 18978," +
//				            "\"maxChampionsKilled\": 25," +
//				            "\"maxLargestCriticalStrike\": 1002," +
//				            "\"totalChampionKills\": 889," +
//				            "\"totalPhysicalDamageDealt\": 8990017," +
//				            "\"rankedPremadeGamesPlayed\": 0," +
//				            "\"totalSessionsLost\": 56," +
//				            "\"totalNeutralMinionsKilled\": 2040," +
//				            "\"totalSessionsWon\": 51," +
//				            "\"totalMagicDamageDealt\": 6522121," +
//				            "\"maxLargestKillingSpree\": 12," +
//				            "\"totalPentaKills\": 1," +
//				            "\"maxTimeSpentLiving\": 2137," +
//				            "\"totalDeathsPerSession\": 589," +
//				            "\"totalQuadraKills\": 5," +
//				            "\"totalSessionsPlayed\": 107," +
//				            "\"totalDoubleKills\": 79," +
//				            "\"totalAssists\": 986," +
//				            "\"maxTimePlayed\": 3187," +
//				            "\"mostChampionKillsPerSession\": 25," +
//				            "\"totalDamageDealt\": 15927186," +
//				            "\"botGamesPlayed\": 0," +
//				            "\"killingSpree\": 432," +
//				            "\"totalFirstBlood\": 0," +
//				            "\"rankedSoloGamesPlayed\": 0," +
//				            "\"totalHeal\": 267652," +
//				            "\"totalGoldEarned\": 1408527," +
//				            "\"mostSpellsCast\": 0," +
//				            "\"totalTurretsKilled\": 139," +
//				            "\"maxNumDeaths\": 13," +
//				            "\"totalUnrealKills\": 0," +
//				            "\"normalGamesPlayed\": 0" +
//				         "}," +
//				         "\"name\": \"Combined\"" +
//				      "}" +
//				   "]," +
//				   "\"summonerId\": 250110 " +
//				"}";
		
		return query;
	}
	
	private String prueba(String URL) {
		String responseString = "";
		try {
			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet();
			request.setURI(new URI(URL));
		    HttpResponse response = client.execute(request);
		    if (response != null)
		    	responseString = convertStreamToString(response.getEntity().getContent());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		return responseString;
	}
	
	private static String convertStreamToString(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            Writer writer = new StringWriter();

            char[] buffer = new char[1024];
            try {
                Reader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"),1024);
                int n;
                while ((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
            } finally {
                inputStream.close();
            }
            return writer.toString();
        } else {
            return "";
        }
    }
	
	private class ConsultaAsyncTask extends AsyncTask<String, Integer, String> {
		 
	    @Override
	    protected String doInBackground(String... params) {
	        return prueba(params[0]);
	    }
	 
	    @Override
	    protected void onProgressUpdate(Integer... values) {
	        int progreso = values[0].intValue();
	 
//	        pbarProgreso.setProgress(progreso);
	    }
	 
	    @Override
	    protected void onPreExecute() {
	    	System.out.println("antes de correr!");
	    }
	 
	    @Override
	    protected void onPostExecute(String result) {
	    	System.out.println("termino ok!: "+result.length());
	    	Toast.makeText(PlayerInfo.this, ""+result, Toast.LENGTH_LONG).show();
	    	query = result;
	    }
	 
	    @Override
	    protected void onCancelled() {
	    	System.out.println("termino mal!!!!");
	    }
	}

}