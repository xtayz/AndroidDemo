package com.zhanghao.androiddemo.chapter5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.zhanghao.androiddemo.R;

import butterknife.OnClick;

public class BroadcastBestPractice extends BaseActivity1 {

    LocalBroadcastManager localBroadcastManager;
    ForceOfflineReceiver forceOfflineReceiver;

    private static String FORCE_OFFLINE_BROADCAST_ACTION = "com.zhanghao.androiddemo.FORCE_OFFLINE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_best_practice);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        forceOfflineReceiver = new ForceOfflineReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(FORCE_OFFLINE_BROADCAST_ACTION);
        localBroadcastManager.registerReceiver(forceOfflineReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(forceOfflineReceiver);
    }

    @OnClick(R.id.logout)
    void onClickedLogoutButton() {
        Intent intent = new Intent(FORCE_OFFLINE_BROADCAST_ACTION);
        localBroadcastManager.sendBroadcast(intent);
    }

    class ForceOfflineReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(final Context context, Intent intent) {
            AlertDialog.Builder builder = new AlertDialog.Builder(BroadcastBestPractice.this);
            builder.setTitle("Warning");
            builder.setMessage("You are forced to be offline. Please try to login again.");
            builder.setCancelable(false);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent1 = new Intent(context, LoginActivity.class);
                    intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent1);
                    ActivityController.finishAll();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
            alertDialog.show();
        }
    }

}
