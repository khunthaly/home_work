package com.example.tock13app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Database database;
    EditText txtid,txtname,txtsurname,txtphone,txtemail;
    Button btnsubmit,btncancel,btndelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = new Database(this);

        txtid = findViewById(R.id.txtid);
        txtname = findViewById(R.id.txtName);
        txtsurname = findViewById(R.id.txtSur);
        txtphone = findViewById(R.id.txtPhone);
        txtemail = findViewById(R.id.txtEmail);
        btnsubmit = findViewById(R.id.btnSubmit);
        btncancel = findViewById(R.id.btnlCancel);
        btndelete = findViewById(R.id.btnEdelets);
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name, surname, phone, email;
                name = txtname.getText().toString();
                surname = txtsurname.getText().toString();
                phone = txtphone.getText().toString();
                email = txtemail.getText().toString();
                boolean delete = database.deleteData(name);
                if (delete == true) {
                    Toast.makeText(MainActivity.this, "Data delate", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(MainActivity.this, "Data cannot delate", Toast.LENGTH_SHORT).show();
            }
        });
      btnsubmit.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             String id = txtid.getText().toString();
             String name,surname,phone,email;
             name = txtname.getText().toString();
             surname = txtsurname.getText().toString();
             phone = txtphone.getText().toString();
             email = txtemail.getText().toString();
             boolean update = Database.updateData(name,surname,phone,email);
             if (update ==true){
                 Toast.makeText(getApplication(),"Data has been updated",Toast.LENGTH_LONG).show();
             }else {
                 Toast.makeText(getApplication(),"Data has not been updated!!",Toast.LENGTH_LONG).show();
             }
             
             cleardata();
            }
        });
    }
    public void cleardata(){
        txtname.setText("");
        txtsurname.setText("");
        txtphone.setText("");
        txtemail.setText("");
    }
}