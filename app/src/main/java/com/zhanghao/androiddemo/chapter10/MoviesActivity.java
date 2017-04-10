package com.zhanghao.androiddemo.chapter10;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.zhanghao.androiddemo.R;
import com.zhanghao.androiddemo.base.BaseActivity;
import com.zhanghao.androiddemo.base.CommonAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesActivity extends BaseActivity {

    @BindView(R.id.lv_movie)
    ListView lvMovie;

    private CommonAdapter<Result> mAdapter;
    private ArrayList<Result> categories = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        mAdapter = new CommonAdapter<Result>(this, categories) {
            @Override
            public int getLayoutId(int i) {
                return R.layout.item_movie_list;
            }

            @Override
            public void convert(ViewHolder holder, final Result data, int position) {
                holder.setText(R.id.tv_title, data.getTitle());
                holder.getView(R.id.btn_more).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

                RecyclerView recyclerView = holder.getView(R.id.rv_movies);
                LinearLayoutManager layoutManager = new LinearLayoutManager(MoviesActivity.this);
                layoutManager.setOrientation(OrientationHelper.HORIZONTAL);
                recyclerView.setLayoutManager(layoutManager);

                recyclerView.setAdapter(new CommonRecycleAdapter<Result.SubjectsBean>(MoviesActivity.this, data.getSubjects()) {

                    @Override
                    public int getLayoutId(int viewType) {
                        return R.layout.item_movie;
                    }

                    @Override
                    public void convert(MyViewHolder holder, Result.SubjectsBean data, int position) {
                        holder.setText(R.id.tv_title, data.getTitle())
                                .setImage(R.id.iv_cover, data.getImages().getMedium());
                    }

                });
            }
        };

        lvMovie.setAdapter(mAdapter);

        MovieService movieService = RequestManager.getInstance().getRetrofit().create(MovieService.class);
        Call<Result> topMovieCall = movieService.getTopMovie(0, 20);

        topMovieCall.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                categories.add(response.body());
                categories.add(response.body());
                categories.add(response.body());
                categories.add(response.body());
                categories.add(response.body());
                categories.add(response.body());
                categories.add(response.body());
                categories.add(response.body());
                categories.add(response.body());
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Toast.makeText(MoviesActivity.this, "获取数据失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
