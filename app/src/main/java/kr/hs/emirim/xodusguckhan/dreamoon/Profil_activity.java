package kr.hs.emirim.xodusguckhan.dreamoon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Profil_activity extends AppCompatActivity {
    EditText textName = findViewById(R.id.edit_name);
    EditText textIntro = findViewById(R.id.edit_intro);
    String strTextName = textName.getText().toString();
    String strTextIntro = textIntro.getText().toString();
    Button btnUpd = findViewById(R.id.btn_upd);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        btnUpd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textName.setText(strTextName);
                textIntro.setText(strTextIntro);
            }
        });
    }

}