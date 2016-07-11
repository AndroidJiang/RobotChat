package com.byl.qrobot.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;

import com.byl.qrobot.R;
import com.byl.qrobot.config.Const;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collection;

public class SysUtils {

    /**
     * 移动文件
     * @param oldPath
     * @param newPath
     * @return
     */
    public static boolean copyFile(String oldPath, String newPath) {
        File oldFile = new File(oldPath);
        if (!oldFile.exists()) {
            return false;
        }
        if(oldFile.renameTo(new File(newPath))){
            return true;
        }else{
            return false;
        }
    }


    /**
     * 防止滑动listView到顶部或底部时出现蓝边现象
     *
     * @param listView
     */
    public static void setOverScrollMode(ListView listView) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO)
            listView.setOverScrollMode(View.OVER_SCROLL_NEVER);
    }



}
