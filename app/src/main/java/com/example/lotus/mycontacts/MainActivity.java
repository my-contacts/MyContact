package com.example.lotus.mycontacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
//hiển thị menu_toolbar trên activity_main
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar,menu);
        return super.onCreateOptionsMenu(menu);
    }
//bấm vào các nút trên toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.setting:
                Toast.makeText(this,"Setting",Toast.LENGTH_SHORT ).show();
                return true;
            case R.id.contacts_us:

                return true;
            case R.id.delete:
                // Làm bất cứ cái gì đó
                return true;
            case R.id.search:

                return true;
            case R.id.person:

                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
