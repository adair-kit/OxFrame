package cn.adair.xframe;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import android.util.DisplayMetrics;

import cn.adair.xframe.utils.XDensityUtils;
import cn.adair.frame.utils.OxOutdatedUtil;
import cn.adair.xframe.utils.http.IHttpEngine;
import cn.adair.xframe.utils.http.XHttp;
import cn.adair.xframe.utils.imageload.ImageLoader;
import cn.adair.xframe.utils.imageload.XImage;
import cn.adair.xframe.widget.loadingview.XLoadingView;
import cn.adair.xframe.widget.loadingview.XLoadingViewConfig;

public class XFrame {

    private static Context context;
    public static int screenHeight;
    public static int screenWidth;

    // #log
    public static String tag = "XFrame";
    public static boolean isDebug = true;


    public static void init(Context context) {
        XFrame.context = context;
        screenHeight = XDensityUtils.getScreenHeight();
        screenWidth = XDensityUtils.getScreenWidth();
    }

    public static XLoadingViewConfig initXLoadingView() {
        return XLoadingView.init();
    }

    public static void initXHttp(IHttpEngine httpEngine) {
        XHttp.init(httpEngine);
    }

    public static void initXImageLoader(ImageLoader loader) {
        XImage.init(loader);
    }

    public static Context getContext() {
        synchronized (XFrame.class) {
            if (XFrame.context == null) {
                throw new NullPointerException("Call XFrame.init(context) within your Application onCreate() method. Or extends XApplication");
            }
            return XFrame.context.getApplicationContext();
        }
    }

    public static Resources getResources() {
        return XFrame.getContext().getResources();
    }

    public static String getString(@StringRes int id) {
        return getResources().getString(id);
    }

    public static Resources.Theme getTheme() {
        return XFrame.getContext().getTheme();
    }

    public static AssetManager getAssets() {
        return XFrame.getContext().getAssets();
    }

    public static Drawable getDrawable(@DrawableRes int id) {
        return OxOutdatedUtil.getDrawable(id);
    }

    public static int getColor(@ColorRes int id) {
        return OxOutdatedUtil.getColor(id);
    }

    public static Object getSystemService(String name) {
        return XFrame.getContext().getSystemService(name);
    }

    public static Configuration getConfiguration() {
        return XFrame.getResources().getConfiguration();
    }

    public static DisplayMetrics getDisplayMetrics() {
        return XFrame.getResources().getDisplayMetrics();
    }

}
