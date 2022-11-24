package kr.hs.emirim.xodusguckhan.dreamoon;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Post_activity extends AppCompatActivity {
    int[] poster = {R.drawable.dream1, R.drawable.dream2, R.drawable.dream3, R.drawable.dream4, R.drawable.dream5, R.drawable.dream6, R.drawable.dream7, R.drawable.dream8, R.drawable.dream9};
    String[] items = {"현몽", "역몽", "길몽", "흉몽", "태몽", "계시몽", "자각몽(루시드드림)", "영몽", "실몽"};

    ImageView imgv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
       /* imgv = findViewById(R.id.imgv);
        Spinner spinner = findViewById(R.id.dreamcategory);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                imgv.setImageResource(poster[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });*/
    }
}