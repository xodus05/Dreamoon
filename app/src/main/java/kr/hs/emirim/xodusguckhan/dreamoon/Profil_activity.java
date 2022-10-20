package kr.hs.emirim.xodusguckhan.dreamoon;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Profil_activity extends AppCompatActivity {

    Button btnUpd;
    TextView textName, textIntro;
    EditText editName, editIntro;
    View dialogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        btnUpd = findViewById(R.id.btn_upd);
        textName = findViewById(R.id.text_name);
        textIntro = findViewById(R.id.text_intro);

        btnUpd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialogView = View.inflate(Profil_activity.this, R.layout.dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(Profil_activity.this);
                dlg.setTitle("정보 입력");
                dlg.setView(dialogView);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        editName=(EditText)dialogView.findViewById(R.id.edit_name);
                        editIntro=(EditText)dialogView.findViewById(R.id.edit_intro);

                        textName.setText(editName.getText().toString());
                        textIntro.setText(editIntro.getText().toString());

                    }
                });
                dlg.setNegativeButton("취소", null);
                dlg.show();
            }
        });
    }

}