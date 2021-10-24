package com.example.guess_the_phrase_sql

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class Dbhelper(cont: Context): SQLiteOpenHelper(cont, "notes",null, 1) {

    private val sqldbw:SQLiteDatabase =writableDatabase
    private val sqldbr:SQLiteDatabase =readableDatabase

    override fun onCreate(db: SQLiteDatabase?) {
        if(db != null){
            db.execSQL("create table note(Content text)")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {}

    fun addnote(n:String): Long {
        val cv= ContentValues()
        cv.put("Content",n)
        var st= sqldbw.insert("note",null,cv)
        return st
    }

    @SuppressLint("Range")
    fun getall():ArrayList<String>{
        var list=arrayListOf<String>()
        val query="SELECT * from note"
        var cursor : Cursor? = null
        try {
            cursor=sqldbr.rawQuery(query,null)
        }catch (e:Exception){
            sqldbr.execSQL(query)
            return ArrayList()
        }
        var content=""
        if(cursor.moveToFirst()){
            do {
                content=cursor.getString(cursor.getColumnIndex("Content"))
                list.add(content)
            }while(cursor.moveToNext())
        }
        return list
    }
}