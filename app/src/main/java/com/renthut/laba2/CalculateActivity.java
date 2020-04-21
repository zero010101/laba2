package com.renthut.laba2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CalculateActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        findViewById(R.id.get_result).setOnClickListener(v -> {
            String mFirstNumber =((EditText) findViewById(R.id.first_number)).getText().toString();
            String mSecondNumber =((EditText) findViewById(R.id.second_number)).getText().toString();
            if (!mFirstNumber.isEmpty() && !mSecondNumber.isEmpty()) {
                double firstNumber = Double.parseDouble(mFirstNumber);
                double secondNumber = Double.parseDouble(mSecondNumber);

                System.out.println(firstNumber);

                Intent intent = new Intent();

                switch (getIntent().getExtras().getString("action")) {
                    case "add":
                        intent.putExtra("result", firstNumber + secondNumber);
                        break;
                    case "sub":
                        intent.putExtra("result", firstNumber - secondNumber);
                        break;
                    case "div":
                        if (secondNumber != 0) {
                            intent.putExtra("result", firstNumber / secondNumber);
                            break;
                        }
                    case "mul":
                        intent.putExtra("result", firstNumber * secondNumber);
                        break;
                }
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        setResult(RESULT_CANCELED);
    }
}
