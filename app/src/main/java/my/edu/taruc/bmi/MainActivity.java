package my.edu.taruc.bmi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String BMI_MESSAGE = "my.edu.taruc.BMI.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateBMI (View view){

        // link to UI
        EditText editTextWeight;
        editTextWeight = findViewById(R.id.editTextWeight);

        EditText editTextHeight;
        editTextHeight = findViewById(R.id.editTextHeight);

        // Input Validation
        if(TextUtils.isEmpty(editTextWeight.getText()) || TextUtils.isEmpty(editTextHeight.getText())){
            editTextWeight.setError(getString(R.string.error_message));
            editTextHeight.setError(getString(R.string.error_message));
            // where is my error_message ??
            return;
        }

        int weight;
        int height;
        int BMI;
        weight = Integer.parseInt(editTextWeight.getText().toString());
        height = Integer.parseInt(editTextHeight.getText().toString());
        BMI = weight / (height*height);

        if(BMI < 18){
            Intent intent = new Intent (this,Main4Activity.class);
            String stringBMI;
            stringBMI = String.valueOf(BMI);
            intent.putExtra(BMI_MESSAGE,stringBMI);

        } if(BMI >= 18 && BMI <= 25){
            Intent intent = new Intent(this,Main2Activity.class);
            String stringBMI;
            stringBMI = String.valueOf(BMI);
            intent.putExtra(BMI_MESSAGE,stringBMI);

        } if(BMI > 25){
          Intent intent = new Intent(this,Main3Activity.class);
            String stringBMI;
            stringBMI = String.valueOf(BMI);
            intent.putExtra(BMI_MESSAGE,stringBMI);

        } else {
            editTextWeight.setError(getString(R.string.error_message));
            editTextHeight.setError(getString(R.string.error_message));
            //Log.d(getString(R.string.invalid_Input));
        }


    }

}
