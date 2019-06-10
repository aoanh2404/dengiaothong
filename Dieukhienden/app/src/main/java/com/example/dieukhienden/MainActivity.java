package com.example.dieukhienden;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText edtden1,edtden2;
    Button btnnhap;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addcontrol();
        new readJson().execute("http://controlbms.com/api/points/get_all_point?device_key=DEVICE_6E94117044");

    }
//    private  class wJson extends AsyncTask<String,Void,String>
//    {
//        @Override
//        protected String doInBackground(String... strings) {
//            StringBuilder content = new StringBuilder();
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//            try {
//                JSONObject jsonObject=new JSONObject(s);
//                JSONArray jsonArray=jsonObject.getJSONArray("data");
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//
//        }
//    }
    private  class readJson extends AsyncTask<String,Void,String>
    {
        @Override
        protected String doInBackground(String... strings) {
            StringBuilder content=new StringBuilder();
            try {
                URL url=new URL(strings[0]);
                InputStreamReader stream=new InputStreamReader(url.openConnection().getInputStream());
                BufferedReader buff=new BufferedReader(stream);
                String line="";
                while ((line=buff.readLine())!=null)
                {
                    content.append(line);
                }
                buff.close();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return content.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject jsonObject=new JSONObject(s);
                JSONArray jsonArray=jsonObject.getJSONArray("data");
                for(int i=0;i<jsonArray.length();i++)
                {
                    JSONObject objectid=jsonArray.getJSONObject(i);
                    if(Integer.parseInt(objectid.getString("id"))==370)
                    {
                        edtden1.setText(objectid.getString("point_value"));
                    }
                    if(Integer.parseInt(objectid.getString("id"))==371)
                    {
                        edtden2.setText(objectid.getString("point_value"));

                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }
    private void addcontrol() {
        edtden1=findViewById(R.id.edtden1);
        edtden2=findViewById(R.id.edtden2);
        btnnhap=findViewById(R.id.btnnhap);
    }
}
