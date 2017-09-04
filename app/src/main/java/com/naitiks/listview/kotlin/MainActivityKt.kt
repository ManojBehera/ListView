package com.naitiks.listview.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.ListViewCompat
import android.view.View
import android.widget.AdapterView
import android.widget.Toast

import com.naitiks.listview.R

import java.util.ArrayList

class MainActivityKt : AppCompatActivity() {
    private var listView: ListViewCompat? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.list_view) as ListViewCompat
        setAdapter()
    }

    private fun setAdapter() {
        val dataList = getDummyData(10)
        val adapter = ListAdapterKt(this@MainActivityKt, dataList)
        listView!!.adapter = adapter
        //set click listner
        listView!!.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l -> Toast.makeText(this@MainActivityKt, dataList[i].name, Toast.LENGTH_SHORT).show() }
    }

    private fun getDummyData(limit: Int): ArrayList<UserModelKt> {
        val dummyList = ArrayList<UserModelKt>()
        for (i in 0..limit - 1) {
            dummyList.add(UserModelKt("Dummy Item " + i))
        }
        return dummyList
    }
}
