package com.example.tock13app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Editdata extends AppCompatActivity {
    Database database;
    EditText txtid,txtname,txtsurname,txtphone,txtemail;
    Button submit,cancel,delete;

    /**
     * {@inheritDoc}
     * <p>
     * Perform initialization of all fragments.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_edit_data);
        txtid = findViewById(R.id.txtEid);
        txtname = findViewById(R.id.txtEname);
        txtsurname = findViewById(R.id.txtEsurname);
        txtphone = findViewById(R.id.txtEphone);
        txtemail = findViewById(R.id.txtEemail);
        submit = findViewById(R.id.btnEsubmit);
        cancel = findViewById(R.id.btnEcancel);
        delete = findViewById(R.id.btnEdelets);
        database=new Database(this);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name;
                name = txtname.getText().toString();
                boolean deleteData = database.deleteData(name);
                if (deleteData == true){
                    Toast.makeText(getApplication(),"Data has been deleted"+ name,Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplication(),"Data cannot delete!!" + name,Toast.LENGTH_LONG).show();
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleardata();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = txtid.getText().toString();
                String name,surname,phone,email;
                name = txtname.getText().toString();
                surname = txtsurname.getText().toString();
                phone = txtphone.getText().toString();
                email = txtemail.getText().toString();
                boolean update = database.updateData(name,surname,phone,email);
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

