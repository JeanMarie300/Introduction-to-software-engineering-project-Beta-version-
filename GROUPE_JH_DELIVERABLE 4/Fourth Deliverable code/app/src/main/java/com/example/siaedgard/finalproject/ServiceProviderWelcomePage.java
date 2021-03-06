package com.example.siaedgard.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ServiceProviderWelcomePage extends AppCompatActivity {

    private static  final String[] ActionBar = {"Enter Availabilities", "Add Services", "Delete services", "See availabilities", "Edit availabilities"};
    private String Name, lastName, userType;
    String userId;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_provider_welcome_page);
        TextView FirsttxtView = findViewById(R.id.sessionText);
        TextView SecondtxtView = findViewById(R.id.welcomeText);
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        if(bd != null)
        {
            userId = (String) bd.get("USER_ID");
            MyDBHandler dbHandler = new MyDBHandler(this);
            user =  dbHandler.findUserById(userId);
            String sessionType = user.getUserType() + " Session";
            Button ButtonAction1 = findViewById(R.id.Action1);
            ButtonAction1.setText(ActionBar[0]);
            Button ButtonAction2 = findViewById(R.id.Action2);
            ButtonAction2.setText(ActionBar[1]);
            Button ButtonAction3 = findViewById(R.id.Action3);
            ButtonAction3.setText(ActionBar[2]);
            Button ButtonAction4 = findViewById(R.id.Action4);
            ButtonAction4.setText(ActionBar[3]);
            String getName = "Welcome "+(String) user.getFirstName();
            FirsttxtView.setText(sessionType);
            SecondtxtView.setText(getName);
        }
    }

    public void OnFinish(View view) {
        Intent intent = new Intent(this, ServiceProviderAvailabilities.class);
        intent.putExtra("USER_ID", userId);
        startActivity(intent);
    }

    public void OnFinish2(View view) {
        Intent intent = new Intent(this, ServiceProviderAddServices.class);
        intent.putExtra("USER_ID", userId);
        startActivity(intent);
    }

    public void OnFinish3(View view) {
        Intent intent = new Intent(this, ServiceProviderDeleteServices.class);
        intent.putExtra("USER_ID", userId);
        startActivity(intent);
    }

    public void OnFinish4(View view) {
        Intent intent = new Intent(this, ServiceProviderAvailabilitiesList.class);
        intent.putExtra("USER_ID", userId);
        startActivity(intent);
    }
}
