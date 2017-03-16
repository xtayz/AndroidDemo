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
import com.zhanghao.androiddemo.chapter9.NetworkTest;
import com.zhanghao.androiddemo.chapter9.WebViewTest;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListViewTestActivity extends AppCompatActivity {

    @BindView(R.id.listView)
    ListView listView;

    List<Chapter> chapters = new ArrayList<>();

    ArrayList<Class> mClassList = new ArrayList();

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
//                Toast.makeText(ListViewTestActivity.this, item.getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ListViewTestActivity.this, item.getaClass());
                startActivity(intent);
            }
        });
        listView.setStackFromBottom(true);
    }

    private void initChapters() {

        mClassList.add(HelloWorldActivity.class);
        mClassList.add(FirstActivity.class);
        mClassList.add(CustomTopBarActivity.class);
        mClassList.add(RecyclerViewTest.class);
        mClassList.add(UIBestPractice.class);
        mClassList.add(FragmentTest.class);
        mClassList.add(FragmentBestPractice.class);
        mClassList.add(BroadcastTest.class);
        mClassList.add(LoginActivity.class);
        mClassList.add(FilePersistenceTest.class);
        mClassList.add(SharedPreferencesTest.class);
        mClassList.add(DatabaseTest.class);
        mClassList.add(RuntimePermissionTest.class);
        mClassList.add(ContactsTest.class);
        mClassList.add(ProviderTest.class);
        mClassList.add(NotificationTest.class);
        mClassList.add(CameraAlbumTest.class);
        mClassList.add(PlayAudioTest.class);
        mClassList.add(PlayVideoTest.class);
        mClassList.add(WebViewTest.class);
        mClassList.add(NetworkTest.class);

        for (Class c: mClassList) {
            chapters.add(new Chapter(c.getSimpleName(), R.mipmap.ic_launcher, c));
        }

    }

}
