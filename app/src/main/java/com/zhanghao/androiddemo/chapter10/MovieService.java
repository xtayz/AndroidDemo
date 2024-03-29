package com.zhanghao.androiddemo.chapter10;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by wonderworld on 2017/3/30.
 */

public interface MovieService {
    @GET("/v2/movie/top250")
    Call<Result> getTopMovie(@Query("start") int start, @Query("count") int count);
}
