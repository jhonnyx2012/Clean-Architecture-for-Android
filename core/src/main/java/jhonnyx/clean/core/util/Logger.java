package jhonnyx.clean.core.util;

import android.util.Log;

import jhonnyx.clean.core.BuildConfig;

/**
 * Created by jhonnybarrios on 01-09-17.
 */

public class Logger {
    public static String TAG = "PPNLogger";

    public static boolean shouldLog=true;

    public static void log(String text) {
        if (shouldLog&& BuildConfig.DEBUG)
            Log.d(TAG, text);
    }
}