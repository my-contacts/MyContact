package com.example.lotus.mycontacts;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.EventLogTags;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import static android.provider.ContactsContract.CommonDataKinds.Organization.TITLE;
import static android.provider.MediaStore.Images.ImageColumns.DESCRIPTION;


public class AddContact extends AppCompatActivity {
    //khai báo thuoc tính
 private EditText edFirstName;
    private EditText edLastName;
    private EditText edTelephone;
    private Button btThem;
    private ImageView imgBack;

    public static final String TITLE="TITLE";
    public static final String TITLE1="TITLE1";
    public static final String NUMBER="NUMBER";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcontact);
        //gán thuộc tính
        edFirstName=(EditText)findViewById(R.id.iv_FirstName);
        edLastName=(EditText)findViewById(R.id.iv_LastName);
        edTelephone=(EditText)findViewById(R.id.iv_Phone);
        btThem=(Button) findViewById(R.id.btThem);
        imgBack=(ImageView) findViewById(R.id.imgback);

        btThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title=edFirstName.getText().toString();
                String title1=edLastName.getText().toString();
                String number=edTelephone.getText().toString();
                byExtra(title,title1,number);
finish();
            }
        });
    }
    public  void byExtra(String title,String title1,String number)
    {
       // Intent intent=new Intent(AddContact.this,MainActivity.class);
      //  intent.putExtra(TITLE,title);
       // intent.putExtra(TITLE1,title1);
      //  intent.putExtra(NUMBER,number);
      //  startActivity(intent);

    }


}
