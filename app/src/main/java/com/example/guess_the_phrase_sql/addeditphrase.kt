package com.example.guess_the_phrase_sql

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class addeditphrase : AppCompatActivity() {
    lateinit var rv: RecyclerView
    lateinit var ed: EditText
    lateinit var add:Button
    lateinit var dbh:Dbhelper
    var lis=arrayListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addeditphrase)
        init()
        add.setOnClickListener {
            if(ed.text.isNotEmpty()){
                dbh.addnote(ed.text.toString())
            }
            lis=dbh.getall()
            rv.adapter=RVAdapter(lis)
        }
    }
    fun init() {
        dbh=Dbhelper(this)
        ed = findViewById(R.id.edadd)
        add=findViewById(R.id.add)
        lis=dbh.getall()
        rv = findViewById(R.id.rv)
        rv.adapter=RVAdapter(lis)
        rv.layoutManager= LinearLayoutManager(this)
    }
    /////////////////////menu////////////////////////////


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {

        val item1 = menu!!.getItem(0)
        item1.setTitle("switch to game")


        return super.onPrepareOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.m1 -> {
                intent= Intent(this,MainActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}