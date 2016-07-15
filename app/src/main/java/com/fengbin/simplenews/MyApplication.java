package com.fengbin.simplenews;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

/**
 * Created by Administrator on 2016/7/13.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initImageLoader(getApplicationContext());
    }

    public static void initImageLoader(Context context) {
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(context)
                                                    .denyCacheImageMultipleSizesInMemory()
                                                    .threadPriority(Thread.NORM_PRIORITY - 2)
                                                    .tasksProcessingOrder(QueueProcessingType.FIFO)
                                                    .build();
        ImageLoader.getInstance().init(configuration);
    }
}
