package kr.hs.emirim.xodusguckhan.dreamoon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Mbtn = findViewById(R.id.main_tab);
        Mbtn.setOnClickListener(mbtnListener);
        Button calendar_tab = findViewById(R.id.calendar_tab);

    }
    View.OnClickListener mbtnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), Diary_activity.class);
            startActivityForResult(intent, 0);
        }
    };


}