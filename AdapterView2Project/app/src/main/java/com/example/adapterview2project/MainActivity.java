package com.example.adapterview2project;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Contact> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView) findViewById(R.id.list);

        //Data
        arrayList = new ArrayList<Contact>();
        arrayList.add(new Contact(R.drawable.apeach,"010-1111-1111"));
        arrayList.add(new Contact(R.drawable.cons,"010-2222-2222"));
        arrayList.add(new Contact(R.drawable.frodo,"010-3333-3333"));
        arrayList.add(new Contact(R.drawable.jayg,"010-4444-4444"));
        arrayList.add(new Contact(R.drawable.muzi,"010-5555-5555"));
        arrayList.add(new Contact(R.drawable.neo,"010-6666-6666"));
        arrayList.add(new Contact(R.drawable.ryan,"010-7777-7777"));
        arrayList.add(new Contact(R.drawable.tube,"010-8888-8888"));

        //Adapter
        MyAdapter adapter = new MyAdapter(this, R.layout.item ,arrayList);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+ arrayList.get(position).getPhone_num()));
                startActivity(intent);
            }
        });
    }
}
