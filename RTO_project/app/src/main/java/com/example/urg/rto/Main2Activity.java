package com.example.urg.rto;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    DatabaseHelper myDb;
    Button b1,b2;
    EditText et1,et2,et3,et4,et5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setTitle("REGISTER");
        myDb = new DatabaseHelper(this);
        et1= (EditText)findViewById(R.id.et2_1);
        et2= (EditText)findViewById(R.id.et2_2);
        et3= (EditText)findViewById(R.id.et2_3);
        et4= (EditText)findViewById(R.id.et2_4);
        et5= (EditText)findViewById(R.id.et2_5);
        b1= (Button)findViewById(R.id.b2_1);
        /*b2= (Button)findViewById(R.id.s);*/
        AddData();
        /*showData();*/

    }
    public void AddData() {
        b1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(et1.getText().toString(),
                                et2.getText().toString(), et3.getText().toString(), et4.getText().toString(),
                                et5.getText().toString() );
                        if(isInserted == true)
                            Toast.makeText(Main2Activity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Main2Activity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    /*public void showData(){
        b2.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Cursor res = myDb.getAllData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id :"+ res.getString(0)+"\n");
                            buffer.append("Name :"+ res.getString(1)+"\n");
                            buffer.append("Email :"+ res.getString(2)+"\n");
                            buffer.append("Phone number :"+ res.getString(3)+"\n");
                            buffer.append("Password :"+ res.getString(4)+"\n\n");
                        }

                        // Show all data
                        showMessage("Data",buffer.toString());
                    }
                });
                    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();*/
    }







