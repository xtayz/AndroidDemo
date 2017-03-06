package com.zhanghao.androiddemo.chapter3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

import com.zhanghao.androiddemo.R;
import com.zhanghao.androiddemo.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class UIBestPractice extends BaseActivity {

    private List<Msg> msgList = new ArrayList<>();

    @BindView(R.id.input_text)
    EditText inputText;

    @BindView(R.id.send)
    Button send;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private MsgAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uibest_practice);
        initMsgs();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MsgAdapter(msgList);
        recyclerView.setAdapter(adapter);
    }

    private void  initMsgs() {
        Msg msg1 = new Msg("Hello guy.", Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("Hello. Who is that?", Msg.TYPE_SENT);
        msgList.add(msg2);
        Msg msg13 = new Msg("This is Tom. Nice talking to you.", Msg.TYPE_RECEIVED);
        msgList.add(msg13);
    }

    @OnClick(R.id.send) void sendMsg() {
        String content = inputText.getText().toString();
        if (content.length() > 0) {
            Msg msg = new Msg(content, Msg.TYPE_SENT);
            msgList.add(msg);
            adapter.notifyItemInserted(msgList.size() - 1);
            recyclerView.scrollToPosition(msgList.size() - 1);
            inputText.setText("");
        }
    }
}
