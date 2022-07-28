package com.example.whatsappdirect;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.hbb20.CountryCodePicker;

public class MainActivity extends AppCompatActivity {

    CountryCodePicker countryCodePicker;
    TextInputEditText mobileNumber;
    Button chatBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // finding id's of all components
        countryCodePicker = findViewById(R.id.countryCodePicker);
        mobileNumber = findViewById(R.id.editMobileNumber);
        chatBtn = findViewById(R.id.chatBtn);

        chatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = countryCodePicker.getSelectedCountryCode();
                String s = mobileNumber.getEditableText().toString();
                String done = code+s;

                Toast.makeText(MainActivity.this, "processing", Toast.LENGTH_SHORT).show();
                gotoUrl("https://wa.me/+"+done);
            }
        });
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}