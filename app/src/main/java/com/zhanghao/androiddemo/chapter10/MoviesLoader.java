package com.zhanghao.androiddemo.chapter10;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by wonderworld on 2017/4/21.
 */

public class MoviesLoader {

    private MovieService service;
    private Call<Result> topMovie;

    public MoviesLoader() {
        this.service = RequestManager.createService(MovieService.class);
    }

    public void getTopMovie(int start, int count, HttpCallback<Result> httpCallback) {
        if (topMovie != null && topMovie.isExecuted()) {
            topMovie.cancel();
        }
        topMovie = service.getTopMovie(start, count);
        topMovie.enqueue(httpCallback);
    }
}
