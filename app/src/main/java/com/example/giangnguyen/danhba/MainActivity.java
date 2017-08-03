package com.example.giangnguyen.danhba;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list_ct;
    EditText input_name;
    EditText input_number;
    RadioButton male;
    RadioButton female;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();

        final ArrayList<Contact> danhsach = new ArrayList<>();
        final ContactAdapter adapter = new ContactAdapter(this, R.layout.contact_layout, danhsach);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = input_name.getText().toString().trim();
                String number = input_number.getText().toString().trim();
                boolean ismale;
                if (male.isChecked()) ismale = true;
                else ismale = false;

                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(number)) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    danhsach.add(new Contact(name, number, ismale));
                    list_ct.setAdapter(adapter);

                    input_name.getText().clear();
                    input_number.getText().clear();
                }
            }
        });

        list_ct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int a = i;
                alertdialog(a);
            }

            void alertdialog(int i) {

                final int a = i;
                final AlertDialog.Builder alertdialog = new AlertDialog.Builder(MainActivity.this);
                alertdialog.setCancelable(false);
                alertdialog.setTitle("Ahihi");
                alertdialog.setMessage("Chọn hành động muốn thực hiện");
                alertdialog.setPositiveButton("GỌI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,danhsach.get(a).getnName(),Toast.LENGTH_SHORT).show();
                    }
                });

                alertdialog.setNegativeButton("GỬI SMS", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog aa = alertdialog.create();
                aa.show();
            }

            void dialog(int i) {
                final int a = i;
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_layout);
                dialog.setCancelable(false);

                Button call = (Button) dialog.findViewById(R.id.call);
                Button sms = (Button) dialog.findViewById(R.id.sms);

                call.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, danhsach.get(a).getnNumber(), Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }

    void anhxa() {
        list_ct = (ListView) findViewById(R.id.list_ct);
        input_name = (EditText) findViewById(R.id.input_name);
        input_number = (EditText) findViewById(R.id.input_number);
        male = (RadioButton) findViewById(R.id.male);
        female = (RadioButton) findViewById(R.id.female);
        add = (Button) findViewById(R.id.addd);
    }

}
