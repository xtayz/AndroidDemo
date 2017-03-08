package com.zhanghao.androiddemo.chapter3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.zhanghao.androiddemo.R;
import com.zhanghao.androiddemo.chapter1.HelloWorldActivity;
import com.zhanghao.androiddemo.chapter2.FirstActivity;
import com.zhanghao.androiddemo.chapter4.FragmentBestPractice;
import com.zhanghao.androiddemo.chapter4.FragmentTest;
import com.zhanghao.androiddemo.chapter5.BroadcastTest;
import com.zhanghao.androiddemo.chapter5.LoginActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListViewTestActivity extends AppCompatActivity {

    @BindView(R.id.listView)
    ListView listView;

    List<Chapter> chapters = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_test);

        ButterKnife.bind(this);

        initChapters();
        ChapterAdapter adapter = new ChapterAdapter(this, R.layout.chapter_item, chapters);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Chapter item = ListViewTestActivity.this.chapters.get(position);
                Toast.makeText(ListViewTestActivity.this, item.getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ListViewTestActivity.this, item.getaClass());
                startActivity(intent);
            }
        });
    }

    private void initChapters() {
        chapters.add(new Chapter("Hello World", R.mipmap.ic_launcher, HelloWorldActivity.class));
        chapters.add(new Chapter("Activity", R.mipmap.ic_launcher, FirstActivity.class));
        chapters.add(new Chapter("Custom Top Bar", R.mipmap.ic_launcher, CustomTopBarActivity.class));
        chapters.add(new Chapter("RecyclerView", R.mipmap.ic_launcher, RecyclerViewTest.class));
        chapters.add(new Chapter("UIBestPractice", R.mipmap.ic_launcher, UIBestPractice.class));
        chapters.add(new Chapter("FragmentTest", R.mipmap.ic_launcher, FragmentTest.class));
        chapters.add(new Chapter("FragmentBestractice", R.mipmap.ic_launcher, FragmentBestPractice.class));
        chapters.add(new Chapter("Broadcast Test", R.mipmap.ic_launcher, BroadcastTest.class));
        chapters.add(new Chapter("BroadcastBestPractice", R.mipmap.ic_launcher, LoginActivity.class));
    }

}
