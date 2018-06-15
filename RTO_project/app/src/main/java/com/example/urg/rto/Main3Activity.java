package com.example.urg.rto;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity {
    DatabaseHelper2 db3;
    Button b1;
    EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getSupportActionBar().setTitle("Vehicle Information");
        db3= new DatabaseHelper2(this);
        b1=(Button)findViewById(R.id.b3_3);
        et1=(EditText)findViewById(R.id.rn);
        showdata2();

    }
    public void showdata2(){
        b1.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Cursor res = db3.getAllData2();
                        if (res.getCount() == 0) {
                            // show message
                            showMessage("Error", "Nothing found");
                            return;
                        }
                        int flag=0;


                        StringBuffer buffer2 = new StringBuffer();

                        while (res.moveToNext()) {
                            if(et1.getText().toString().equals(res.getString(1))) {

                                buffer2.append("Id :" + res.getString(0) + "\n");
                                buffer2.append("Vehicle number :" + res.getString(1) + "\n");
                                buffer2.append("Vehicle name:" + res.getString(2) + "\n");
                                buffer2.append("NAME :" + res.getString(3) + "\n");
                                buffer2.append("Mobile number :" + res.getString(4) + "\n");
                                buffer2.append("City :" + res.getString(5) + "\n");
                                buffer2.append("License number :" + res.getString(6) + "\n\n");
                                flag=1;
                            }


                        }
                        if(flag==1) {

                            // Show all data
                            showMessage("Data", buffer2.toString());
                        }
                    }




                });
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
    }

