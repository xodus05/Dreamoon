package kr.hs.emirim.xodusguckhan.dreamoon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Diary_activity extends AppCompatActivity {

    ImageButton btnred, btnorange, btnyellow, btngreen, btnblue, btnpurple;
    Button btnpost, btnDiarySave;
    BottomNavigationView diarytab;
    EditText edtDiary;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);
        btnred = findViewById(R.id.btn_red);
        btnorange = findViewById(R.id.btn_orange);
        btnyellow = findViewById(R.id.btn_yellow);
        btngreen = findViewById(R.id.btn_green);
        btnblue = findViewById(R.id.btn_blue);
        btnpurple = findViewById(R.id.btn_purple);
        btnpost = findViewById(R.id.btn_post);
        btnDiarySave = findViewById(R.id.btn_diary_save);
        edtDiary = findViewById(R.id.edt_diary);

        diarytab = findViewById(R.id.diary_tab);
        diarytab.setOnClickListener(diarytabListener);
    }
    View.OnClickListener diarytabListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            finish();
        }
    };


}