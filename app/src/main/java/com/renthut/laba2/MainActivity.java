package com.renthut.laba2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final int REQUEST_CODE = 111;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            double resultValue = data.getExtras().getDouble("result");
            TextView result = findViewById(R.id.result);
            result.setText(String.valueOf(resultValue));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView divide = findViewById(R.id.div);
        CardView multiply = findViewById(R.id.mul);
        CardView subtract = findViewById(R.id.sub);
        CardView add = findViewById(R.id.add);

        Intent intent = new Intent(this, CalculateActivity.class);

        add.setOnClickListener(v -> {
            intent.putExtra("action", "add");
            startActivityForResult(intent, REQUEST_CODE);
        });

        subtract.setOnClickListener(v -> {
            intent.putExtra("action", "sub");
            startActivityForResult(intent, REQUEST_CODE);
        });

        multiply.setOnClickListener(v -> {
            intent.putExtra("action", "mul");
            startActivityForResult(intent, REQUEST_CODE);
        });

        divide.setOnClickListener(v -> {
            intent.putExtra("action", "div");
            startActivityForResult(intent, REQUEST_CODE);
        });

        findViewById(R.id.see_statistics).setOnClickListener(v -> {
            Uri address = Uri.parse("https://ncov2019.live/");
            Intent openLinkIntent = new Intent(Intent.ACTION_VIEW, address);

            if (openLinkIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(openLinkIntent);
            }
        });
    }
}
