package com.example.firstmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.service.autofill.RegexValidator;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class MainActivity extends AppCompatActivity {

    EditText name, mobile, email, website, password, confirmationPassword;
    Button submit;

    AwesomeValidation awesomeValidation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign variable
        name = findViewById(R.id.et_name);
        mobile = findViewById(R.id.et_mobile);
        email = findViewById(R.id.et_email);
        website = findViewById(R.id.et_website);
        password = findViewById(R.id.et_password);
        confirmationPassword = findViewById(R.id.et_confirm_password);
        submit = findViewById(R.id.bt_submit);
        //Initialize validation style
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        //add validation name
        awesomeValidation.addValidation(this,R.id.et_name,
                RegexTemplate.NOT_EMPTY, R.string.invalid_name);
        //add validation mobile
        awesomeValidation.addValidation(this,R.id.et_mobile,
                "[5-9]{1}[0-9]{9}$",R.string.invalid_mobile);

        //add validation email
        awesomeValidation.addValidation(this,R.id.et_email,
                Patterns.EMAIL_ADDRESS, R.string.invalid_email);
        // for website
        awesomeValidation.addValidation(this,R.id.et_email,
                Patterns.WEB_URL, R.string.invalid_website);
        // for password
        awesomeValidation.addValidation(this,R.id.et_mobile,
                ".{6,}",R.string.invalid_password);
        // for confirm password
        awesomeValidation.addValidation(this, R.id.et_confirm_password,
                R.id.et_password, R.string.invalid_confirm_password);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check validation
                if(awesomeValidation.validate()){
                    //On success
                    Toast.makeText(getApplicationContext(),
                            "Form validate Successfully", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),
                            "Validation Failed", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}