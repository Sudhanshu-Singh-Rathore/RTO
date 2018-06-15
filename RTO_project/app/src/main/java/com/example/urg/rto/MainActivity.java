package com.example.urg.rto;


import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import static android.accounts.AccountManager.KEY_PASSWORD;
import static android.os.Build.ID;


public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    Button Login;
    EditText email;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("LOGIN");
        db= new DatabaseHelper(this);

         email = (EditText)findViewById(R.id.et1_1);
        password = (EditText) findViewById(R.id.et1_2);
         Login = (Button)findViewById(R.id.b1_1);
        /*Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor res = db.validate(email.getText().toString(), password.getText().toString());
                if(res.getCount()==0)
                {
                    Toast.makeText(getBaseContext(), "Not Registered", Toast.LENGTH_SHORT).show();
                }
                if(res.getCount()>0)
                {
                    Toast.makeText(getBaseContext(), "Registered", Toast.LENGTH_SHORT).show();
                }


            }
        });





    }*/


        Login.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Cursor res = db.getAllData();
                        if(res.getCount() == 0) {
                           Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_LONG).show();
                            return;
                        }
                        int flag=0;
                        if(((email.getText().toString()).equals("admin")&&(password.getText().toString()).equals("admin"))) {

                            Intent intent= new Intent(MainActivity.this,Main4Activity.class);
                            startActivity(intent);
                            flag=1;

                        }
                        while (res.moveToNext()) {
                            if(((email.getText().toString()).equals(res.getString(2)))&&(password.getText().toString()).equals(res.getString(4)))
                            {
                                flag=1;
                                Intent intent= new Intent(MainActivity.this,Main3Activity.class);
                                startActivity(intent);



                            }


                        }
                        if(flag==0)
                            Toast.makeText(MainActivity.this, "Invalid", Toast.LENGTH_SHORT).show();



                    }
                });
    }



    public void ChangeFragment(View view)
    {
        Intent i=new Intent(this, Main2Activity.class);
        startActivity(i);

    }



}
