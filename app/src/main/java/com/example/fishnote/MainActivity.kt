package com.example.fishnote

import android.content.res.TypedArray
import android.os.Bundle
import android.view.MenuItem
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
        nav_view.setNavigationItemSelectedListener(this)

        var list = ArrayList<ListItem>()


      /*  list.addAll(fillArrays(
                resources.getStringArray(R.array.fish),
                resources.getStringArray(R.array.fishContent),
                getImageId(R.array.fishPngArr)
            ))*/
      /* manual add
        list.add(ListItem(R.drawable.som,"som", "sdasadasd"))
        list.add(ListItem(R.drawable.shuca,"shuca", "sdasadasd"))
        list.add(ListItem(R.drawable.caras,"caras", "sdasadasd"))
        list.add(ListItem(R.drawable.nalim,"nalim", "sdasadasd"))*/

        rc_view.hasFixedSize()
        rc_view.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(list,this)
        rc_view.adapter = adapter

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

       when(item.itemId){

           R.id.id_fish ->
           {
               Toast.makeText(this, "ID fish", Toast.LENGTH_SHORT).show()
               adapter?.updateAdapter(fillArrays(
                       resources.getStringArray(R.array.fish),
                       resources.getStringArray(R.array.fishContent),
                       getImageId(R.array.fishPngArr)
               ))
           }
           R.id.id_sna ->
           {
               Toast.makeText(this, "ID sna", Toast.LENGTH_SHORT).show()

           }
           R.id.id_na -> {
               Toast.makeText(this, "ID na", Toast.LENGTH_SHORT).show()
               adapter?.updateAdapter(fillArrays(
                       resources.getStringArray(R.array.na),
                       resources.getStringArray(R.array.naContent),
                       getImageId(R.array.naPngArr)
               ))
           }
           R.id.id_history -> Toast.makeText(this, "ID history", Toast.LENGTH_SHORT).show()
       }
        drawerLayout.closeDrawer(GravityCompat.START)
       return true
    }

    fun fillArrays(titleArray:Array<String>,contentArray:Array<String>, imageArray:IntArray):List<ListItem>
    {
        var listItemArray = ArrayList<ListItem>()

        for (n in titleArray.indices)
        {
            var listItem = ListItem(imageArray[n], titleArray[n], contentArray[n])
            listItemArray.add(listItem)
        }
        return listItemArray
    }

    fun getImageId(ImageArrayId:Int):IntArray
    {
        var tArray:TypedArray = resources.obtainTypedArray(ImageArrayId)
        var count = tArray.length()
        val ids = IntArray(count)
        for (i in ids.indices)
        {
            ids[i] = tArray.getResourceId(i,0)
        }
        tArray.recycle()
        return ids
    }
}