package kr.hs.emirim.xodusguckhan.dreamoon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Post_activity extends AppCompatActivity {
    String[] items = {"현몽", "역몽", "길몽", "흉몽", "태몽", "계시몽", "자각몽(루시드드림)", "영몽", "실몽"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

    }
}