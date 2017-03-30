package com.zhanghao.androiddemo.chapter10;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Callback;
import retrofit2.Retrofit;

/**
 * Created by wonderworld on 2017/3/30.
 */

public class RequestManager {

    public static final String BASE_URL = "https://api.douban.com/";
    public static final int DEFAULT_TIMEOUT = 5;
    private Retrofit retrofit;

    private RequestManager() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder()
                .client(builder.build())
//                .addConverterFactory(ResponseConvertFactory.create())
                .baseUrl(BASE_URL)
                .build();

    }

    private static class SingletonHolder {
        private static final RequestManager INSTANCE = new RequestManager();
    }

    public static RequestManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
