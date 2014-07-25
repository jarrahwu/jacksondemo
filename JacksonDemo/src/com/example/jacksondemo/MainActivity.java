package com.example.jacksondemo;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.jw.json.JacksonWrapper;
import com.jw.util.JSONUtil;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		

		
		try {
			InputStream json = getAssets().open("test1.json");
			String jsonStr = inputStream2String(json);
			JSONObject obj = JSONUtil.createJSONObject(jsonStr);
			Test1Entry u = JacksonWrapper.json2Bean(obj, Test1Entry.class);
			TextView tv = (TextView) findViewById(R.id.test1);
			tv.setText(u.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		try {
			InputStream json = getAssets().open("test.json");
			saveToFile(getFilesDir()+"/test", json);
			File f = new File(getFilesDir()+"/test");
			TestEntry u = JacksonWrapper.file2Bean(f, TestEntry.class);
			TextView tv = (TextView) findViewById(R.id.test);
			tv.setText(u.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public String inputStream2String(InputStream is)
            throws UnsupportedEncodingException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is,"utf-8"));
        StringBuffer sb = new StringBuffer();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
	
	public void saveToFile(String fileName, InputStream in) throws IOException { 
	      FileOutputStream fos = null;    
	      BufferedInputStream bis = null;    
	      int BUFFER_SIZE = 1024; 
	      byte[] buf = new byte[BUFFER_SIZE];    
	      int size = 0;    
	      bis = new BufferedInputStream(in);    
//			    //建立文件    
	      fos = new FileOutputStream(fileName);    
//			    //保存文件    
	      while ( (size = bis.read(buf)) != -1)     
	        fos.write(buf, 0, size);    
	      fos.close();    
	      bis.close();    
	    }
}
