package com.zhanghao.androiddemo.chapter5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.zhanghao.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BroadcastTest extends AppCompatActivity {

    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;

    private IntentFilter localIntentFilter;
    private LocalReceiver localReceiver;
    private LocalBroadcastManager localBroadcastManager;
    private static String LOCAL_BROADCAST_ACTION = "com.zhanghao.androiddemo.LOCAL_BROADCAST";

    @BindView(R.id.text_view)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_test);
        ButterKnife.bind(this);
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver, intentFilter);

        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        localIntentFilter = new IntentFilter();
        localIntentFilter.addAction(LOCAL_BROADCAST_ACTION);
        localReceiver = new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver, localIntentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
        unregisterReceiver(localReceiver);
    }

    @OnClick(R.id.send)
    void onClickedSendButton() {
        Intent intent = new Intent("com.zhanghao.androiddemo.MY_BROADCAST");
//        sendBroadcast(intent);
        sendOrderedBroadcast(intent, null);
    }

    @OnClick(R.id.send_local_broadcast)
    void onClickedSendButton1() {
        Intent intent = new Intent(LOCAL_BROADCAST_ACTION);
        localBroadcastManager.sendBroadcast(intent);
    }

    class NetworkChangeReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = cm.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                Toast.makeText(context, "network is available", Toast.LENGTH_SHORT).show();
                textView.setText("network is available");
            } else {
                Toast.makeText(context, "network is unavailable", Toast.LENGTH_SHORT).show();
                textView.setText("network is unavailable");
            }
        }
    }

    class LocalReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "received local broadcast", Toast.LENGTH_SHORT).show();
        }
    }
}
