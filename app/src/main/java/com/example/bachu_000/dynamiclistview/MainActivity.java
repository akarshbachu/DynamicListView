package com.example.bachu_000.dynamiclistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button bt;
    ListView lv;
    ArrayList<String> strArr;
    ArrayAdapter<String> adapter;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=(Button)findViewById(R.id.button);
        et=(EditText)findViewById(R.id.et);
        lv=(ListView)findViewById(R.id.listView);
        strArr=new ArrayList<String>();
        /*for(int i=0;i<2;i++){
            strArr.add("Row: " + i);
        }*/
        adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,strArr);
        lv.setAdapter(adapter);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strArr.add(et.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"selected"+position,Toast.LENGTH_LONG).show();

            }
        });
    }
}
