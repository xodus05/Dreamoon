package kr.hs.emirim.xodusguckhan.dreamoon;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Diary_activity extends AppCompatActivity {
    myDBHelper myDBHelper;
    SQLiteDatabase sqlDB;
    ImageButton btnred, btnorange, btnyellow, btngreen, btnblue, btnpurple;
    Button btnpost, btnDiarySave;
    BottomNavigationView diarytab;
    EditText edtDiary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);
/*
        btnred = findViewById(R.id.btn_red);
        btnorange = findViewById(R.id.btn_orange);
        btnyellow = findViewById(R.id.btn_yellow);
        btngreen = findViewById(R.id.btn_green);
        btnblue = findViewById(R.id.btn_blue);
        btnpurple = findViewById(R.id.btn_purple);
*/
        btnpost = findViewById(R.id.btn_post);
        btnDiarySave = findViewById(R.id.btn_diary_save);
        edtDiary = findViewById(R.id.edt_diary);

        diarytab = findViewById(R.id.diary_tab);
        diarytab.setOnClickListener(diarytabListener);

        myDBHelper = new myDBHelper(this);
        btnDiarySave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = myDBHelper.getWritableDatabase();
                sqlDB.execSQL("INSERT INTO groupTBL VALUES('"+ edtDiary.getText().toString() + ");");
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "저장되었습니다.", 0).show();
            }
        });
    }
    View.OnClickListener diarytabListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            finish();
        }
    };

    public class myDBHelper extends SQLiteOpenHelper {
        public myDBHelper(Context context){
            super(context, "groupDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE groupTBL ( gName CHAR(20) PRIMARY KEY, gNumber INTEGER);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            db.execSQL("DROP TABLE IF EXISTS groupTBL");
            onCreate(db);
        }
    }



}