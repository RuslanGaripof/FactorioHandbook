package com.example.factoriohandbook

import android.content.res.TypedArray
import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_content.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{
        var adapter: MyAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav_view.setNavigationItemSelectedListener (this)

        var list = ArrayList<ListItem>()

        list.addAll(fillArrays(resources.getStringArray(R.array.item),
            resources.getStringArray(R.array.item_content),getImageId(R.array.item_image),0))
        rcView.hasFixedSize()
        rcView.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(list, this)
        rcView.adapter = adapter

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {

            R.id.id_era1 ->
            {
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.item),
                    resources.getStringArray(R.array.item_content),getImageId(R.array.item_image)
                    ,0))
            }

            R.id.id_pattern ->
            {
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.item_1),
                    resources.getStringArray(R.array.item_1_content),getImageId(R.array
                        .item_1_image),1))
            }

            R.id.id_recom ->
            {
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.item_2),
                    resources.getStringArray(R.array.item_2_content),getImageId(R.array
                        .item_2_image),2))
            }




        }
        drawerLayout.closeDrawer(GravityCompat.START)

        return true
    }
    fun fillArrays(titleArray:Array<String>,contentArray:Array<String>,imageArray:IntArray, cat:Int)
    :List<ListItem>
    {
        var listItemArray = ArrayList<ListItem>()
            for(n in 0..titleArray.size - 1)
            {
                var listItem = ListItem(imageArray[n],titleArray[n],contentArray[n], cat)
                listItemArray.add(listItem)
            }
            return listItemArray
    }

    fun  getImageId(imageArrayId:Int):IntArray
    {
        var tArray: TypedArray = resources.obtainTypedArray(imageArrayId)
        val count = tArray.length()
        val ids = IntArray(count)
        for(i in ids.indices)
        {
            ids[i] = tArray.getResourceId(i, 0)
        }
        tArray.recycle()
        return ids
    }

}