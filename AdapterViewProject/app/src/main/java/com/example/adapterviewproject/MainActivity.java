package com.example.adapterviewproject;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Contact> list;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // AdapterView
        ListView listView = (ListView) findViewById(R.id.ListView);

        // Data
        list = new ArrayList<Contact>();
        list.add(new Contact(R.drawable.apeach, "홍일동", "27", "010-1111-1111"));
        list.add(new Contact(R.drawable.cons, "홍이동", "26", "010-2222-2222"));
        list.add(new Contact(R.drawable.frodo, "홍삼동", "25", "010-3333-3333"));
        list.add(new Contact(R.drawable.muzi, "홍사동", "24", "010-4444-4444"));
        list.add(new Contact(R.drawable.neo, "홍오동", "23", "010-5555-5555"));
        list.add(new Contact(R.drawable.muzi, "홍사동", "24", "010-4444-4444"));
        list.add(new Contact(R.drawable.frodo, "홍삼동", "25", "010-3333-3333"));
        list.add(new Contact(R.drawable.cons, "홍이동", "26", "010-2222-2222"));
        list.add(new Contact(R.drawable.apeach, "홍일동", "27", "010-1111-1111"));

        // Adapter
        adapter = new MyAdapter(this, R.layout.item, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), list.get(position).getName(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:" + list.get(position).getPhone()));
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            // Long 클릭 했을 때 나오는 view --> View
            // adapterView --> ListView
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {

                adapter.remove(list.get(position));

                // true로 반환해야, 다음 클릭 이벤트를 실행 안하게 함.
                return true;
            }
        });

        Button btnSortAsc = (Button) findViewById(R.id.btnSortAsc);

        btnSortAsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 정렬을 위해서는 Comparator의 인터페이스가 필요하다.
                // 여기서는 한번만 사용하므로, 익명 클래스로 작성하였다.
                adapter.sort(new Comparator<Contact>() {
                    @Override
                    public int compare(Contact left, Contact right) {

                        return left.getName().compareTo(right.getName());
                    }
                });
            }
        });

        Button btnSortDesc = (Button) findViewById(R.id.btnSortDesc);

        btnSortDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 정렬을 위해서는 Comparator의 인터페이스가 필요하다.
                // 여기서는 한번만 사용하므로, 익명 클래스로 작성하였다.
                adapter.sort(new Comparator<Contact>() {
                    @Override
                    public int compare(Contact left, Contact right) {

                        return right.getName().compareTo(left.getName());
                    }
                });
            }
        });

    }

    public void clearAll(View view) {
        adapter.clear();
    }

    public void AddInfo(View view)
    {
        TextView txtName = (TextView)findViewById(R.id.txtName);
        TextView txtAge =  (TextView)findViewById(R.id.txtAge);
        TextView txtTel  = (TextView)findViewById(R.id.txtTel);
        RadioGroup radioGroup = (RadioGroup) findViewById( R.id.imageGroup );
        int image_id = 0;
        int id = radioGroup.getCheckedRadioButtonId();

        switch(id)
        {
            case R.id.muzi:
                image_id = R.drawable.muzi;
                break;
            case R.id.nemo:
                image_id = R.drawable.neo;
                break;
        }

        adapter.add(new Contact(image_id,txtName.getText().toString(),
                txtAge.getText().toString(), txtTel.getText().toString()));

        txtName.setText("");
        txtTel.setText("");
        txtAge.setText("");
    }
}
