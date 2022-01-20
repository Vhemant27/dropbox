package com.example.dropbox;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
//import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    Spinner sp1,sp2;
    EditText ed1;
    Button b1;
    TextView answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp1 = findViewById(R.id.spfrom);
        sp2 = findViewById(R.id.spto);
        ed1 = findViewById(R.id.txtamt);
        answer = findViewById(R.id.textView5);
        b1 = findViewById(R.id.btn1);

//        edans = findViewById(editTextTextPersonName);


        String[] from = {"Kilometer"};
        ArrayAdapter ad = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(ad);


        String[] to = {"Meter","Centimeter"};
        ArrayAdapter ad1 = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,to);
        sp2.setAdapter(ad1);





        ed1.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int aft )
            {

            }

            @Override
            public void afterTextChanged(Editable s)
            {

                //call your function here of calculation here
          convert();

            }
        });



//
//        b1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Double tot;
//
//                Double amt = Double.parseDouble(ed1.getText().toString());
//
//                if(sp1.getSelectedItem().toString() == "Kilometer" && sp2.getSelectedItem().toString() == "Meter")
//                {
//                    tot = amt * 1000.0;
//                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
//                    answer.setText("" + tot);
//                }
//                else if(sp1.getSelectedItem().toString() == "Kilometer" && sp2.getSelectedItem().toString() == "Centimeter")
//                {
//                    tot = amt * 100000.0;
//                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
//                    answer.setText("" + tot);
//
//                }
//            }
//        });
    }
    
    public void convert(){
        Double tot;

        Double amt = Double.parseDouble(ed1.getText().toString());






        if(amt!=null) {

            if (sp1.getSelectedItem().toString() == "Kilometer" && sp2.getSelectedItem().toString() == "Meter") {
                tot = amt * 1000.0;
                Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);
            } else if (sp1.getSelectedItem().toString() == "Kilometer" && sp2.getSelectedItem().toString() == "Centimeter") {
                tot = amt * 100000.0;
                Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + tot);

            }

        }
        else{
            amt=0.0;
            answer.setText("0");
        }

    }
    
}