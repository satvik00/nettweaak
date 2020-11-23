package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class first extends AppCompatActivity {

    LinearLayout l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences p=getSharedPreferences("PREFERENCES", MODE_PRIVATE);
        String s=p.getString("Dark","");
        if (s.equals("yes")) {
            setTheme(R.style.DarkTheme);
        } else {
            setTheme(R.style.LightTheme);
        }
        setContentView(R.layout.activity_first);
        getSupportActionBar().setTitle("NeTTweaak");
        System.out.println("Testinggggggggggggggggggggg");
        l=(LinearLayout)findViewById(R.id.linear);
        Animation pushupin = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.push_up_in);
        l.startAnimation(pushupin);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.action_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.home:
                Intent intent=new Intent(this,first.class);
                startActivity(intent);
                break;
            case R.id.ctheme:
                Intent i=new Intent(this,theme.class);
                startActivity(i);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        EditText portField = (EditText) findViewById(R.id.portField);
        EditText usernameField = (EditText) findViewById(R.id.usernameField);
        EditText passwordField = (EditText) findViewById(R.id.passwordField);

        String host = editText.getText().toString();
        String port = portField.getText().toString();
        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();

        intent.putExtra("host", host);
        intent.putExtra("port", port);
        intent.putExtra("username", username);
        intent.putExtra("password", password);
        startActivity(intent);
        finish();
        /*
        Intent intent2 = new Intent(this, SSHservice.class);
        startService(intent2);*/
    }
    public void stopMessage(View view) {
        // Do something in response to button
        Intent intent3 = new Intent(this, SSHservice.class);
        stopService(intent3);
        finish();
    }

}