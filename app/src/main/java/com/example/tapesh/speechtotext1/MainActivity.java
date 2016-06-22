package com.example.tapesh.speechtotext1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener {
    protected static final int result_speech=1;
    private ImageButton btnSpeak;
    private TextView textSpeak;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnSpeak=(ImageButton)findViewById(R.id.imageButton);
        textSpeak=(TextView)findViewById(R.id.textView);


        btnSpeak.setOnClickListener(this);





    }

    public void onClick(View view)
    {
        Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-us");
      //  intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-us");

        try
        {
            startActivityForResult(intent,result_speech);
            textSpeak.setText("");
        }catch(Exception e)
        {
            Log.i("error", e.toString());
        }
    }



    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode)
        {
            case result_speech :
                if(resultCode==RESULT_OK && data!=null)
                {
                    ArrayList<String> text = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                    textSpeak.setText(text.get(0));
                }
                break;


        }

    }



}
