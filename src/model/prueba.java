package model;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.AsyncTask;
import android.util.Log;

public class prueba extends AsyncTask<String, Void, String> {
	
	@Override
	protected String doInBackground(String... urls) {
		String contentAsString = "";
		try {
			URL url = new URL(urls[0]);
			
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//	        conn.setReadTimeout(10000 /* milliseconds */);
//	        conn.setConnectTimeout(15000 /* milliseconds */);
	        conn.setRequestMethod("GET");
	        conn.setDoInput(true);
	        // Starts the query
	        Log.i("111", "11");
	        conn.connect();
	        Log.i("111", "22");
	        InputStream is = conn.getInputStream();
	        int len = 10000;

	        // Convert the InputStream into a string
	        contentAsString = readIt(is, len);
	        Log.i("resputes: ", ""+contentAsString);
		} catch (Exception e) {
		}
		return contentAsString;
	}
	
	public String readIt(InputStream stream, int len) throws IOException, UnsupportedEncodingException {
	    Reader reader = null;
	    reader = new InputStreamReader(stream, "UTF-8");        
	    char[] buffer = new char[len];
	    reader.read(buffer);
	    return new String(buffer);
	}
}
