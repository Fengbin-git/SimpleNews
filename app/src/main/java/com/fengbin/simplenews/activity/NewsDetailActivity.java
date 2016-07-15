package com.fengbin.simplenews.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import com.fengbin.simplenews.R;
import com.fengbin.simplenews.bean.NewsEntity;
import com.fengbin.simplenews.task.LoadNewsDetailTask;

/**
 * Created by Administrator on 2016/7/13.
 */
public class NewsDetailActivity extends Activity {
    private WebView web_view;
    private NewsEntity.StoriesBean stories;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_detail);
        Log.e("TAG","bbb");
        web_view = (WebView)findViewById(R.id.web_view);
        setWebView(web_view);

        stories = (NewsEntity.StoriesBean) getIntent().getSerializableExtra("stories");
        Log.e("TAG",""+stories.getId());
        new LoadNewsDetailTask(web_view).execute(stories.getId());
    }

    private void setWebView(WebView web_view) {
        web_view.getSettings().setJavaScriptEnabled(true);
        web_view.setVerticalScrollBarEnabled(false);
        web_view.setHorizontalScrollBarEnabled(false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
//    public static void startNewsDetaiActivity(Context context, NewsEntity.StoriesBean stories){
//        if(Utility.isConnect(context)) {
//            Intent intent = new Intent(context,NewsDetailActivity.class);
//            intent.putExtra("stories",stories);
//            context.startActivity(intent);
//        }else {
//            Utility.noNetworkAlert(context);
//        }
//    }
}
