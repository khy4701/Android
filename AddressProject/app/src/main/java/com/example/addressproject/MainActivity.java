package com.example.addressproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // AdapterView 생성
        ListView listView = (ListView) findViewById(R.id.listItem);

        // Item 생성
        final List<Contact> arrayList = new ArrayList<Contact>();

        arrayList.add(new Contact(R.drawable.apeach, "소녀시대", "010-1111-2222","girsGeneration.nate.com"));
        arrayList.add(new Contact(R.drawable.frodo, "시크릿", "010-1555-1678","secret.nate.com"));
        arrayList.add(new Contact(R.drawable.jayg, "아이오아이", "010-1242-4242","ioiJJang.nate.com"));
        arrayList.add(new Contact(R.drawable.muzi, "걸스데이", "010-4341-5345","girlsday.nate.com"));
        arrayList.add(new Contact(R.drawable.thm, "설현", "010-5242-3232","AoA.nate.com"));
        arrayList.add(new Contact(R.drawable.muzi, "걸스데이", "010-4341-5345","girlsday.nate.com"));


        // Adapter 생성
        MyAdapter adapter = new MyAdapter(this, R.layout.item, arrayList);
        listView.setAdapter(adapter);

     listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

             Intent intent = new Intent(MainActivity.this, Main2Activity.class);

             Contact contact = new Contact();

             contact.setEmail(arrayList.get(position).getEmail());
             contact.setName(arrayList.get(position).getName());
             contact.setPhone_num(arrayList.get(position).getPhone_num());

             intent.putExtra("contact_info",contact);

             startActivity(intent);
         }
     });

    }
}
