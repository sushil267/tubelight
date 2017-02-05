package com.example.dell.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewClass extends AppCompatActivity {
    ListView listView;
    String[] list,link;
    String trimester,first="first",second="second",third="third";
    ArrayAdapter adapter;
    Intent intent1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week_list);
        final Intent intent=getIntent();
        if(intent!=null) {
            list = intent.getStringArrayExtra("name");
            trimester=intent.getStringExtra("tri");
//            title=intent.getIntExtra("name",R.string.list );
          //  this.setTitle(title);
            adapter = new ArrayAdapter<>(ListViewClass.this,R.layout.list_name, list);
            listView= (ListView) findViewById(R.id.my_list_view);
            assert listView != null;
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(ListViewClass.this,String.valueOf(position),Toast.LENGTH_SHORT).show();
                    intent1=new Intent(ListViewClass.this,DetailWeek.class);
                    intent1.putExtra("link_name",list[position]);
                    startActivity(intent1);
                }
            });
        }

    }
}
