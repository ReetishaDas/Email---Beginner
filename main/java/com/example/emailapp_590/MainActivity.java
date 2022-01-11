package com.example.emailapp_590;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button send;
EditText sub,email,body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send=findViewById(R.id.button);
        sub=findViewById(R.id.editTextTextPersonName2);
        email=findViewById(R.id.editTextTextEmailAddress2);
        body=findViewById(R.id.editTextTextMultiLine);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailsend=send.getText().toString();
                String subject=sub.getText().toString();
                String b=body.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailsend});
                intent.putExtra(Intent.EXTRA_SUBJECT,subject);
                intent.putExtra(Intent.EXTRA_TEXT,b);

                intent.setType("messafe/rfc822");
                startActivity(Intent.createChooser(intent, "Choose and Email Client"));

                Toast.makeText(getApplicationContext(),"Email Sent Successfully",Toast.LENGTH_LONG);
            }
        });
    }
}