package com.fengbin.simplenews.http;

import com.fengbin.simplenews.bean.NewsEntity;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Administrator on 2016/7/12.
 */
public interface NewsService {
    @GET("/api/4/news/latest")
    Observable<NewsEntity> getNewsMessage();
//    @GET("")
//    Observable<>
}
