package kr.hs.emirim.xodusguckhan.dreamoon;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    private CalendarView calendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavi);
        calendarView = (CalendarView) findViewById(R.id.calendar);

        //처음화면
        getSupportFragmentManager().beginTransaction().add(R.id.main_frame, new Fragment1()).commit(); //FrameLayout에 fragment.xml 띄우기

        //바텀 네비게이션뷰 안의 아이템 설정
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    //item을 클릭시 id값을 가져와 FrameLayout에 fragment.xml띄우기
                    case R.id.i1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new Fragment1()).commit();
                        break;
                    case R.id.i2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new Fragment2()).commit();
                        break;
                    case R.id.i3://
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new Fragment3()).commit();
                        break;
                    case R.id.i4:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new Fragment4()).commit();
                        break;
                    case R.id.i5:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new Fragment5()).commit();
                        break;
                }
                return true;
            }
        });

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                Log.i("디버깅", "현재 선택한 날짜는" + i + "년" + (i1 + 1) + "월" + i2 + "일");
            }
        });
    }
}
