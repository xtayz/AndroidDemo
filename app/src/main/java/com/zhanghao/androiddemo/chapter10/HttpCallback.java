package com.zhanghao.androiddemo.chapter10;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by wonderworld on 2017/4/21.
 */

public abstract class HttpCallback<T extends HttpBean> implements Callback<T> {

    abstract void onSuccess(Call<T> call, Response<T> response);

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        onSuccess(call, response);
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {

    }
}
