package com.zhanghao.androiddemo.chapter7;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.zhanghao.androiddemo.R;
import com.zhanghao.androiddemo.base.BaseActivity;

import butterknife.OnClick;

public class ProviderTest extends BaseActivity {

    private static final String TAG = "ProviderTest";

    private String newId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_test);
    }

    @OnClick(R.id.add_data) void onClickedAddButton() {
        Uri uri = Uri.parse("content://com.zhanghao.androiddemo.provider/book");
        ContentValues values = new ContentValues();
        values.put("name", "A Clash of Kings");
        values.put("author", "George Martin");
        values.put("pages", "1040");
        values.put("price", 22.85);
        Uri newUri = getContentResolver().insert(uri, values);
        newId = newUri.getPathSegments().get(1);
        Toast.makeText(this, "插入book成功，id = " + newId, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.query_data) void onClickedQueryButton() {
        Uri uri = Uri.parse("content://com.zhanghao.androiddemo.provider/book");
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                newId = cursor.getString(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String author = cursor.getString(cursor.getColumnIndex("author"));
                int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                double price = cursor.getDouble(cursor.getColumnIndex("price"));
                Toast.makeText(this, String.format("name: %s, author: %s, pages: %d, price: %f", name, author, pages, price), Toast.LENGTH_SHORT).show();
            }
            cursor.close();
        }
    }

    @OnClick(R.id.update_data) void onClickedUpdateButton() {
        Uri uri = Uri.parse("content://com.zhanghao.androiddemo.provider/book/" + newId);
        ContentValues values = new ContentValues();
        values.put("name", "A Storm of Swords");
        values.put("pages", "1216");
        values.put("price", 24.05);
        getContentResolver().update(uri, values, null, null);
        Toast.makeText(this, "update success", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.delete_data) void onClickedDeleteButton() {
        Uri uri = Uri.parse("content://com.zhanghao.androiddemo.provider/book/" + newId);
        getContentResolver().delete(uri, null, null);
        Toast.makeText(this, "delete success", Toast.LENGTH_SHORT).show();
    }

}
