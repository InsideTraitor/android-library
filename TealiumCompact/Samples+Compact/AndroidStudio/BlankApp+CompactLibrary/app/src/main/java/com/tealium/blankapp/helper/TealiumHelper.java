package com.tealium.blankapp.helper;

import java.util.Map;

import com.tealium.blankapp.BuildConfig;
import com.tealium.library.Tealium;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.view.View;
import android.webkit.WebView;

public final class TealiumHelper {

	@SuppressLint("NewApi")
	public static void initialize(Application application) {
		
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && BuildConfig.DEBUG) {
			WebView.setWebContentsDebuggingEnabled(true);
		}
		
		Tealium.initialize(Tealium.Config.create(application, "tealiummobile", "demo", "dev")
				.setLibraryLogLevel(Tealium.LogLevel.DEBUG));
	}
	
	public static void onResume(Activity activity, Map<String, String> data) {
		Tealium.onResume(activity);
		Tealium.track(activity, data, Tealium.VIEW);
	}
	
	public static void onPause(Activity activity) {
		Tealium.onPause(activity);
	}
	
	public static void trackEvent(View widget, Map<String, String> data) {
		Tealium.track(widget, data, Tealium.EVENT);
	}
	
	public static void trackEvent(Throwable throwable, Map<String, String> data) {
		Tealium.track(throwable, data, Tealium.EVENT);
	}
}
