package com.naitiks.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListViewCompat listView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListViewCompat)findViewById(R.id.list_view);
        setAdapter();
    }

    private void setAdapter(){
        final ArrayList<UserModel> dataList = getDummyData(10);
        ListAdapter adapter = new ListAdapter(MainActivity.this, dataList);
        listView.setAdapter(adapter);
        //set click listner
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, dataList.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private ArrayList<UserModel> getDummyData(int limit){
        ArrayList<UserModel> dummyList = new ArrayList<>();
        for(int i=0; i<limit; i++){
            dummyList.add(new UserModel("Dummy Item "+i));
        }
        return dummyList;
    }
}
