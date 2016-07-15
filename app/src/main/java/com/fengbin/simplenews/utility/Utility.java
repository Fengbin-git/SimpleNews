package com.fengbin.simplenews.utility;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/7/12.
 */
public class Utility {
    public static boolean isConnect(Context context){
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
    public static void noNetworkAlert(Context context) {
        Toast.makeText(context, "No Network", Toast.LENGTH_SHORT).show();
    }
}
