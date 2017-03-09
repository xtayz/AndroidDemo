package com.zhanghao.androiddemo.chapter6;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.zhanghao.androiddemo.R;
import com.zhanghao.androiddemo.base.BaseActivity;

import butterknife.OnClick;

public class DatabaseTest extends BaseActivity {

    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_test);
        createDatabase();
    }

    private void createDatabase() {
        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 3);
    }

    @OnClick(R.id.create_database) void onClickedCreateDatabaseButton() {
        dbHelper.getWritableDatabase();
    }

    @OnClick(R.id.add_data) void onClickedAddDataButton() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", "The Da Vinci Code");
        values.put("author", "Dan Brown");
        values.put("pages", 454);
        values.put("price", 16.96);
        db.insert("Book", null, values);
        values.clear();
        values.put("name", "The Lost Symbol");
        values.put("author", "Dan Brown");
        values.put("pages", 510);
        values.put("price", 19.95);
        db.insert("Book", null, values);
    }

    @OnClick(R.id.update_data) void onClickedUpdateDataButton() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("price", 10.99);
        db.update("Book", values, "name = ?", new String[] { "The Da Vinci Code" });
    }

    @OnClick(R.id.delete_data) void onClickedDeleteButton() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("Book", "pages > ?", new String[] { "500" });
    }

    @OnClick(R.id.query_data) void onClickedQueryDataButton() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("Book", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String author = cursor.getString(cursor.getColumnIndex("author"));
                int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                double price = cursor.getDouble(cursor.getColumnIndex("price"));
                Log.d("DatabaseTest", "book name is " + name);
                Log.d("DatabaseTest", "book author is " + author);
                Log.d("DatabaseTest", "book pages is " + pages);
                Log.d("DatabaseTest", "book price is " + price);
            } while (cursor.moveToNext());
        }
    }
}
