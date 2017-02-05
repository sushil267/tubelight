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

/**
 * Created by DELL on 05/02/2017.
 */
public class ListSymptoms extends AppCompatActivity {
    ListView listView;
    String[] list;
    ArrayAdapter adapter;
    Intent intent1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_sysptoms);
        final Intent intent = getIntent();
        if (intent != null) {
            list = intent.getStringArrayExtra("name");
              this.setTitle("Common Symptoms during Pregnancy");
            adapter = new ArrayAdapter<>(ListSymptoms.this, R.layout.list_sys_name, list);
            listView = (ListView) findViewById(R.id.listView_sys);
            assert listView != null;
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(ListSymptoms.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
                    intent1 = new Intent(ListSymptoms.this, DetailSys.class);
                    intent1.putExtra("int", position);
                    startActivity(intent1);
                }
            });
        }

    }
}