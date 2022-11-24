package kr.hs.emirim.xodusguckhan.dreamoon;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Calendar;

public class Diary_activity extends AppCompatActivity {
    myDBHelper myDBHelper;
    SQLiteDatabase sqlDB;
    ImageButton btnred, btnorange, btnyellow, btngreen, btnblue, btnpurple;
    Button btnpost, btnDiarySave;
    BottomNavigationView diarytab;
    EditText edtDiary;
    String fileName;

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

        Calendar cal = Calendar.getInstance();
        int cYear = cal.get(Calendar.YEAR);
        int cMonth = cal.get(Calendar.MONTH);
        int cDay = cal.get(Calendar.DAY_OF_MONTH);

        myDBHelper = new myDBHelper(this);

        fileName = Integer.toString(cYear)+"_"+Integer.toString(cMonth+1)+"_"+Integer.toString(cDay);
        btnDiarySave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = myDBHelper.getWritableDatabase();
                sqlDB.execSQL("INSERT INTO myDiary VALUES('"+ edtDiary.getText().toString() + ");");
                Toast.makeText(getApplicationContext(), "저장되었습니다.", Toast.LENGTH_LONG).show();
                Log.d("저장되었습니다.","완료");
                sqlDB.close();
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
            super(context, "myDiaryDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE myDiary ( gName CHAR(500));");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            db.execSQL("DROP TABLE IF EXISTS myDiary");
            onCreate(db);
        }

    }

}