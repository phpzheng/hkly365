package com.example.administrator.renyuan;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Handler;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;




/**
 * A login screen that offers login via email/password.
 */
public class RegisterActivity extends Activity {

    JSONArray jArray;
    String result = null;
    InputStream is = null;
    StringBuilder sb=null;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    public void to_submit(View view){
        EditText user_name = (EditText) findViewById(R.id.user_name);
        String user_name_str = user_name.getText().toString();
        EditText pwd = (EditText) findViewById(R.id.pwd);
        String pwd_str = pwd.getText().toString();
        EditText repwd = (EditText) findViewById(R.id.repwd);
        String repwd_str = repwd.getText().toString();


        if(!pwd_str.equals(repwd_str)){
            Toast. makeText ( this, pwd_str+repwd_str, Toast. LENGTH_LONG ). show () ;
            //pwd.setError("两次密码不一致");
            return;
        }

        ArrayList nameValuePairs = new ArrayList();
        //nameValuePairs.add(new BasicNameValuePair("id","4"));
        nameValuePairs.add(new BasicNameValuePair("name",user_name_str));
        try{
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://www.haokeok.com/app/insert.php");
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = httpclient.execute(httppost);
            Toast. makeText ( this, "insert successfully", Toast. LENGTH_LONG ). show () ;
        }catch(Exception e){
            Log.e("log_tag", "Error in http connection"+e.toString());
        }

    }

    public void to_reset(View view){
        EditText user_name = (EditText) findViewById(R.id.user_name);
        user_name.setText(null);
        EditText pwd = (EditText) findViewById(R.id.pwd);
        pwd.setText(null);
        EditText repwd = (EditText) findViewById(R.id.repwd);
        repwd.setText(null);
    }








}

