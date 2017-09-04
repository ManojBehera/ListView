package com.naitiks.listview.kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

import com.naitiks.listview.R

import java.util.ArrayList

/**
 * Created by Naitik on 9/4/2017.
 */

class ListAdapterKt(context: Context, dataList: ArrayList<UserModelKt>) : BaseAdapter() {
    private var dataList: ArrayList<UserModelKt>? = null
    private var context: Context? = null

    init {
        this.context = context
        this.dataList = dataList
    }

    override fun getCount(): Int {
        return dataList?.size ?: 0
    }

    override fun getItem(i: Int): Any {
        return dataList!![i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup): View {
        var view = view
        var holder: UserHolder? = null
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.row, viewGroup, false)
            holder = UserHolder()
            holder.firstName = view!!.findViewById(R.id.first_letter) as TextView
            holder.name = view.findViewById(R.id.name) as TextView
            view.tag = holder
        } else {
            holder = view.tag as UserHolder
        }
        val name = dataList!![i].name
        holder.firstName!!.setText(name!!.subSequence(0, 1))
        holder.name!!.text = name
        return view
    }

    internal inner class UserHolder {
        var firstName: TextView? = null
        var name: TextView? = null
    }
}
