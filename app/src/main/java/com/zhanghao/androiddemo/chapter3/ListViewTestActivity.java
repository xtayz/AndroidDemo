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
import com.zhanghao.androiddemo.chapter6.DatabaseTest;
import com.zhanghao.androiddemo.chapter6.FilePersistenceTest;
import com.zhanghao.androiddemo.chapter6.MyDatabaseHelper;
import com.zhanghao.androiddemo.chapter6.SharedPreferencesTest;
import com.zhanghao.androiddemo.chapter7.ContactsTest;
import com.zhanghao.androiddemo.chapter7.ProviderTest;
import com.zhanghao.androiddemo.chapter7.RuntimePermissionTest;
import com.zhanghao.androiddemo.chapter8.CameraAlbumTest;
import com.zhanghao.androiddemo.chapter8.NotificationTest;
import com.zhanghao.androiddemo.chapter8.PlayAudioTest;
import com.zhanghao.androiddemo.chapter8.PlayVideoTest;
import com.zhanghao.androiddemo.chapter9.WebViewTest;

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
        listView.setStackFromBottom(true);
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
        chapters.add(new Chapter("FilePersistenceTest", R.mipmap.ic_launcher, FilePersistenceTest.class));
        chapters.add(new Chapter("SharedPreferencesTest", R.mipmap.ic_launcher, SharedPreferencesTest.class));
        chapters.add(new Chapter("DatabaseTest", R.mipmap.ic_launcher, DatabaseTest.class));
        chapters.add(new Chapter("RuntimePermissionTest", R.mipmap.ic_launcher, RuntimePermissionTest.class));
        chapters.add(new Chapter("ContactsTest", R.mipmap.ic_launcher, ContactsTest.class));
        chapters.add(new Chapter("ProviderTest", R.mipmap.ic_launcher, ProviderTest.class));
        chapters.add(new Chapter("NotificationTest", R.mipmap.ic_launcher, NotificationTest.class));
        chapters.add(new Chapter("CameraAlbumTest", R.mipmap.ic_launcher, CameraAlbumTest.class));
        chapters.add(new Chapter("PlayAudioTest", R.mipmap.ic_launcher, PlayAudioTest.class));
        chapters.add(new Chapter("PlayVideoTest", R.mipmap.ic_launcher, PlayVideoTest.class));
        chapters.add(new Chapter("WebViewTest", R.mipmap.ic_launcher, WebViewTest.class));
    }

}
