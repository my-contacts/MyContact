package com.example.lotus.mycontacts;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
    private Button btnAdd;
    private ListView lvContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setWidget();
        arrayContact = new ArrayList<>();
        adapter = new ContactAdapter(this, R.layout.item_contact_listview,arrayContact);
        lvContact.setAdapter(adapter);
    }

    public void setWidget()
    {
        edtName = (EditText)  findViewById(R.id.iv_Name);
        edtPhone = (EditText)  findViewById(R.id.iv_Phone);
        btnAdd= (Button) findViewById(R.id.btn_add);
        lvContact= (ListView) findViewById(R.id.lv_contact);

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
    }
}
