package com.example.hckd;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;


public class MainActivity extends Activity {


   private EditText Email;
    //private EditText Password;
    private Button checkmail;
    //private Button signup;
    //private static final String TAG = "kinvey ping";
    //String Currentuser;


    private void setupVariables() {

        Email = (EditText) findViewById(R.id.email);

        //Password = (EditText) findViewById(R.id.password);

        checkmail = (Button) findViewById(R.id.check);

        // signup = (Button) findViewById(R.id.signup);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setupVariables();
        checkmail.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View view) {

                String email = Email.getText().toString();
                Log.e("Hello", email);

                Intent intent =new Intent(getApplicationContext(), com.example.hckd.Message.class);
                intent.putExtra("Email", email);

                startActivity(intent);


            }
        });
    }
}


/*
class RetrieveFeedTask extends AsyncTask {
    String email;

    public RetrieveFeedTask(String email) {
        this.email = email;
    }

    protected Object doInBackground(Object[] params) {

        if (email != null) {
            try {

                String str1 = "https://www.haveibeenpwned.com/api/v2/breachedaccount/" + email;
                */
/*HttpUriRequest request = new HttpGet(str1);
                HttpClient httpclient = new DefaultHttpClient();
                HttpResponse response = httpclient.execute(request);
                String resp = EntityUtils.toString(response.getEntity());*//*

                URL url = new URL(str1);
                SSLContext context = SSLContext.getInstance("Default");

                HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
                urlConnection.setSSLSocketFactory(context.getSocketFactory());
                InputStream in = urlConnection.getInputStream();
              */
/*  BufferedReader br;
                br = new BufferedReader(new InputStreamReader(in));*//*

                readJsonStream(in);

                */
/*MainActivity.this.startActivity(new Intent(MainActivity.this,
                        Message.class));
                MainActivity.this.finish();


                Intent intent = new Intent(context, Message.class);

                intent.putExtra("InputStream", in);
                startActivity(intent);*//*

              //  String inputLine;

              */
/*  while ((inputLine = br.readLine()) != null) {
                    Log.d("Response", inputLine);
                    in.close();
                }*//*




             */
/*  JSONArray marray = new JSONArray(inputLine);

               if(inputLine!=null) {
                    for (int i = 0; i < marray.length(); i++) {
                        try {


                            JSONObject jObj = marray.getJSONObject(i);
                            String nm=jObj.getString("Name");

                            Log.d("Reason",nm);

                        }
                        catch(JSONException e)
                        {
                            //e.printStackTrace();
                        }


                    }

                }*//*

               */
/* PushbackInputStream pushbackInputStream = new PushbackInputStream(in);
                int b;
                b = pushbackInputStream.read();
                if ( b == -1 ) {
                    Log.d("Your are safe", "No Breach");
                }
                pushbackInputStream.unread(b);
                return pushbackInputStream; *//*



                // Log.d("Response", resp);
            } catch (FileNotFoundException e) {
                Log.d("Your are safe", "No Breach");
            } catch (Exception e) {
                e.printStackTrace();
            }


        }



        return null;
    }

    public List readJsonStream(InputStream in) throws IOException {

        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            return readMessagesArray(reader);

        } finally {
            reader.close();
        }

    }

    public List readMessagesArray(JsonReader reader) throws IOException {
        List messages = new ArrayList();

        reader.beginArray();
        while (reader.hasNext()) {
            messages.add(readMessage(reader));
        }
        reader.endArray();
        return messages;
    }

    public Message readMessage(JsonReader reader) throws IOException {
        String text = null;
        String desp = null;

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("Name")) {
                text = reader.nextString();
                Log.d("Name", text);
            }
            else if(name.equals("Description")){
                desp=reader.nextString();
                Log.d("Description",desp);
            }

            else {
                reader.skipValue();
            }

        }

        reader.endObject();
        return new Message();


    }
}*/
