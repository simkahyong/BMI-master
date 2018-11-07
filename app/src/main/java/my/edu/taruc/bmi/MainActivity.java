package my.edu.taruc.bmi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String BMI_MESSAGE = "my.edu.taruc.bmi.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateBMI (View view) {

        // link to UI
        EditText editTextWeight;
        editTextWeight = findViewById(R.id.editTextWeight);

        EditText editTextHeight;
        editTextHeight = findViewById(R.id.editTextHeight);

        // Input Validation
        try{
            if (TextUtils.isEmpty(editTextWeight.getText())) {
                editTextWeight.setError(getString(R.string.error_message));
                return;
            } else if (TextUtils.isEmpty(editTextHeight.getText())) {
                editTextHeight.setError(getString(R.string.error_message));
                return;
            } else {
                Double weight;
                Double height;
                Double BMI;
                weight = Double.parseDouble(editTextWeight.getText().toString());
                height = Double.parseDouble(editTextHeight.getText().toString());
                BMI = weight / (height * height);

                if (BMI >= 0 && BMI < 18) {
                    Intent intent = new Intent(this, Main4Activity.class);
                    String stringBMI;
                    intent.putExtra(BMI_MESSAGE, BMI);
                    startActivity(intent);

                } else if (BMI >= 18 && BMI <= 25) {
                    Intent intent = new Intent(this, Main2Activity.class);
                    String stringBMI;
                    stringBMI = String.valueOf(BMI);
                    intent.putExtra(BMI_MESSAGE, String.format(stringBMI,2));
                    startActivity(intent);

                } else { // BMI > 25
                    Intent intent = new Intent(this, Main3Activity.class);
                    String stringBMI;
                    stringBMI = String.valueOf(BMI);
                    String.format(stringBMI,2);
                    intent.putExtra(BMI_MESSAGE, String.format(stringBMI,2));
                    startActivity(intent);
                }
            }
        } catch(Exception e){
            Toast.makeText(this,"Invalid Input !!",Toast.LENGTH_SHORT).show();
        }
    }
}
