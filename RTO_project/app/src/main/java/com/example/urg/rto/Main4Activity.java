package com.example.urg.rto;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
    DatabaseHelper2 db2;
    Button b1,b2;
    EditText e1,e2,e3,e4,e5,e6,e7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        getSupportActionBar().setTitle("ADMIN");
        db2= new DatabaseHelper2(this);

        b1= (Button)findViewById(R.id.b4_1);
        b2= (Button)findViewById(R.id.b4_2);
        e1=(EditText)findViewById(R.id.et4_1);
        e2=(EditText)findViewById(R.id.et4_2);
        e3=(EditText)findViewById(R.id.et4_3);
        e4=(EditText)findViewById(R.id.et4_4);
        e5=(EditText)findViewById(R.id.et4_5);
        e6=(EditText) findViewById(R.id.et4_6);
        e7=(EditText)findViewById(R.id.et8);
        b1.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        boolean isInserted=db2.insertData(e1.getText().toString(), e2.getText().toString(), e3.getText().toString(), e4.getText().toString(), e5.getText().toString(), e6.getText().toString());

                        if(isInserted == true)
                            Toast.makeText(Main4Activity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Main4Activity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                });




        showdata();
}
public void showdata()
{
    b2.setOnClickListener(
            new View.OnClickListener()
            {
                public void onClick(View v)
                {
                    Cursor res = db2.getAllData2();
                    if (res.getCount() == 0)
                    {
                        // show message
                        showMessage("Error", "Nothing found");
                        return;
                    }
                    int flag=0;


                    StringBuffer buffer1 = new StringBuffer();

                    while (res.moveToNext()) {
                        if(e7.getText().toString().equals(res.getString(1))) {

                            buffer1.append("Id :" + res.getString(0) + "\n");
                            buffer1.append("Vehicle number :" + res.getString(1) + "\n");
                            buffer1.append("Vehicle name:" + res.getString(2) + "\n");
                            buffer1.append("NAME :" + res.getString(3) + "\n");
                            buffer1.append("Mobile number :" + res.getString(4) + "\n");
                            buffer1.append("City :" + res.getString(5) + "\n");
                            buffer1.append("License number :" + res.getString(6) + "\n\n");
                            flag=1;
                        }


                    }
                    if(flag==1)
                    {

                        // Show all data
                        showMessage("Data", buffer1.toString());
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


