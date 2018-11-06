package my.edu.taruc.bmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Intent intent = getIntent();
        if(intent.hasExtra(MainActivity.BMI_MESSAGE)){
            TextView textViewBMI4;
            textViewBMI4 = findViewById(R.id.textViewBMI4);
            String stringBMI;
            stringBMI = intent.getStringExtra(MainActivity.BMI_MESSAGE);
            textViewBMI4.setText(stringBMI);
        }
    }
}
