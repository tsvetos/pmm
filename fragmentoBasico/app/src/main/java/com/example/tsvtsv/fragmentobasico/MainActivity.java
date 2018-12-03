package com.example.tsvtsv.fragmentobasico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final View miFramento;
        final CheckBox apareceFrag;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miFramento = (View)findViewById(R.id.ejemplo);
        apareceFrag = (CheckBox)findViewById(R.id.checkFrag);

        apareceFrag.setChecked(true);

        apareceFrag.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(apareceFrag.isChecked()) miFramento.setVisibility(View.VISIBLE);
                else miFramento.setVisibility(View.INVISIBLE);
            }
        });
    }
}
