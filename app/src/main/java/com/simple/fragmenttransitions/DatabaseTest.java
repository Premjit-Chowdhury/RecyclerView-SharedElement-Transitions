package com.simple.fragmenttransitions;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
import android.content.Context;
import java.util.List;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import java.util.ArrayList;
import android.database.sqlite.SQLiteException;

public class DatabaseTest extends SQLiteAssetHelper{
    
    private static final String DATABASE_NAME = "Test.db";
    private static final int DATABASE_VERSION = 3;
    
    public static final String TABLE_NAME = "words";
    public static final String ID = "id";
    public static final String ADHYAY = "words";
    public static final String PADA = "meaning";
    
    
    public DatabaseTest(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        setForcedUpgrade();
    }
    
    
    public List<AnimalList> getWordsAll() {
        SQLiteDatabase db = getReadableDatabase();

       String sql = "SELECT * FROM " + TABLE_NAME  ;

        Cursor cursor = db.rawQuery(sql,null);
        try { 

            List<AnimalList> wordList = new ArrayList<AnimalList>();
            while (cursor.moveToNext()) {
                int id = cursor.getInt(0);
                String words = cursor.getString(1);
                String meaning = cursor.getString(2);
                

                wordList.add(new AnimalList(id, words, meaning));
            }

            return wordList;
        } catch (SQLiteException exception) {
            exception.printStackTrace();
            return null;
        } finally {

            if (cursor != null)
                cursor.close();

            db.close();
        }
    }
}


