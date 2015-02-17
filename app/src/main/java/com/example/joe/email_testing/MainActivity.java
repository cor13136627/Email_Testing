package com.example.joe.email_testing;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    Button send;
    EditText address,subject,message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send = (Button) findViewById(R.id.SendButton);
        address = (EditText) findViewById(R.id.Address) ;
        subject = (EditText) findViewById(R.id.Subject);
        message = (EditText) findViewById(R.id.Message);



        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("message/rfc822");

                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[] {address.getText().toString()});
                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject.getText().toString());
                emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message.getText().toString());

                try {
                    startActivity(Intent.createChooser(emailIntent, "Send Mail...."));

                } catch (ActivityNotFoundException ex) {
                    Toast.makeText(MainActivity.this, "No Email Client installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


}
