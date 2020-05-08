package com.example.fragmenttoactivitycommunication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements PersonDetailFragment.FragmentInterface {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);

    }

    @Override
    public void sendData(Person person) {
        textView.setText(person.getName()+"\n"+person.getLastname()+"\n"+person.getEmail());
    }
}
