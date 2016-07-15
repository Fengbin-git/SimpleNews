package com.fengbin.simplenews;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.fengbin.simplenews.activity.FavourateActivity;
import com.fengbin.simplenews.activity.NewsDetailActivity;
import com.fengbin.simplenews.adapter.NewsAdapter;
import com.fengbin.simplenews.bean.NewsEntity;
import com.fengbin.simplenews.http.NewsService;
import com.fengbin.simplenews.ui.DividerItemDecoration;
import com.fengbin.simplenews.utility.Utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.toolBar)
    Toolbar toolBar;
    @Bind(R.id.recycler)
    RecyclerView recycler;
    @Bind(R.id.refresh)
    SwipeRefreshLayout refresh;
    private NewsAdapter adapter;
    private boolean isConnection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolBar);
        isConnection = Utility.isConnect(MainActivity.this);
        refresh.setColorSchemeColors(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        refresh.setOnRefreshListener(this);
        setTitle(getTime());
        adapter = new NewsAdapter();
        recycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recycler.addItemDecoration(new DividerItemDecoration(MainActivity.this,DividerItemDecoration.VERTICAL_LIST));
        recycler.setAdapter(adapter);
        if(isConnection){
            getData();
        }else {
           Utility.noNetworkAlert(MainActivity.this);
        }
        adapter.setClickListener(new NewsAdapter.OnRecyclerItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
//                Toast.makeText(MainActivity.this, ""+position, Toast.LENGTH_SHORT).show();
                NewsEntity.StoriesBean stories = adapter.getStories().get(position);
//                NewsDetailActivity.startNewsDetaiActivity(MainActivity.this,storiesBean);
                Log.e("TAG","aaa");
                if(Utility.isConnect(MainActivity.this)) {
                    Intent intent = new Intent(MainActivity.this,NewsDetailActivity.class);
                    intent.putExtra("stories",stories);
                    startActivity(intent);
                }else {
                    Utility.noNetworkAlert(MainActivity.this);
                }
            }
        });
    }
    public void getData(){
        String baseUrl = "http://news-at.zhihu.com";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        NewsService newsService = retrofit.create(NewsService.class);
        newsService.getNewsMessage()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<NewsEntity>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(NewsEntity newsEntity) {
                        List<NewsEntity.StoriesBean> stories = newsEntity.getStories();
                        adapter.refreshNewsList(stories);
                    }
                });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.save) {
            startActivity(new Intent(MainActivity.this,FavourateActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRefresh() {
        getData();
        refresh.setRefreshing(false);
    }
    public String getTime() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy年M月d日 EEEE");
        return format.format(c.getTime());
    }
}
