package com.example.lotus.mycontacts;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lotus.mycontacts.adapter.ContactAdapter;
import com.example.lotus.mycontacts.model.Contact;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private List<Contact> arrayContact;
    private ContactAdapter adapter;
    private EditText edtName;
    private EditText edtPhone;
    private Button btnAdd,btUpdate,btDel;
    private ListView lvContact;
    int vitri=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setWidget();
        arrayContact = new ArrayList<>();
        adapter = new ContactAdapter(this, R.layout.item_contact_listview,arrayContact);
        lvContact.setAdapter(adapter);

        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                edtName.setText(arrayContact.get(position).getName());
                edtPhone.setText(arrayContact.get(position).getPhone());
                vitri=position;
                showDialogConfirm(position);
            }
        });
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  arrayContact.set();
             //   adapter.notifyDataSetChanged();
            }
        });
         btDel.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 arrayContact.remove(vitri);
                 adapter.notifyDataSetChanged();
                 edtName.setText("");
                 edtPhone.setText("");
             }
         });
    }

    public void setWidget()
    {
        edtName = (EditText)  findViewById(R.id.iv_Name);
        edtPhone = (EditText)  findViewById(R.id.iv_Phone);
        btnAdd= (Button) findViewById(R.id.btn_add);
        lvContact= (ListView) findViewById(R.id.lv_contact);
        btUpdate= (Button) findViewById(R.id.bt_update);
        btDel= (Button) findViewById(R.id.bt_del);
    }
    public  void addContact(View view)
    {

        if(view.getId()==R.id.btn_add){
            String name= edtName.getText().toString().trim();
            String number = edtPhone.getText().toString().trim();

            if(TextUtils.isEmpty(name)|| TextUtils.isEmpty(number)){
                Toast.makeText(this,"Vui lòng nhập tên và số điện thoại", Toast.LENGTH_SHORT).show();
            }else {
                Contact contact= new Contact(name,number);
                arrayContact.add(contact);
            }
            adapter.notifyDataSetChanged();
        }
        edtName.setText(" ");
        edtPhone.setText(" ");
    }
    //xin quyen goi va nhan tin
    private void checkAndRequestPermissions() {
        String[] permissions = new String[]{
                Manifest.permission.CALL_PHONE,
                Manifest.permission.SEND_SMS
        };
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(permission);
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), 1);
        }
    }
    public void showDialogConfirm(final int position) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog_layout);
        Button btnCall = (Button) dialog.findViewById(R.id.btn_call);
        Button btnSendMessage = (Button) dialog.findViewById(R.id.btn_send_message);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentCall(position);
            }
        });
        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentSendMesseage(position);
            }
        });
        dialog.show();

    }
    private void intentSendMesseage(int position) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + arrayContact.get(position).getPhone()));
        startActivity(intent);
    }

    private void intentCall(int position) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + arrayContact.get(position).getPhone()));
        startActivity(intent);
    }
}
