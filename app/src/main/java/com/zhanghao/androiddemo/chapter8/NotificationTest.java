package com.zhanghao.androiddemo.chapter8;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zhanghao.androiddemo.R;
import com.zhanghao.androiddemo.base.BaseActivity;

import java.io.File;

import butterknife.OnClick;

public class NotificationTest extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_test);
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // 取消requestCode为1的通知
        manager.cancel(1);
    }

    @OnClick(R.id.send_notice) void onClickedSendNoticeButton() {
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Intent intent = new Intent(this, NotificationActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("This is content title")
                .setContentText("This is content text This is content text This is content text This is content text This is content text This is content text This is content text This is content text This is content text This is content text This is content text This is content text ")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setContentIntent(pi)
                .setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Luna.ogg")))
                .setVibrate(new long[]{ 0, 1000, 1000, 1000 })
                .setLights(Color.GREEN, 1000, 1000)
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher)))
                .setStyle(new NotificationCompat.BigTextStyle().bigText("This is content text This is content text This is content text This is content text This is content text This is content text This is content text This is content text This is content text This is content text This is content text This is content text "))
//                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .build();
        manager.notify(1, notification);
    }
}
