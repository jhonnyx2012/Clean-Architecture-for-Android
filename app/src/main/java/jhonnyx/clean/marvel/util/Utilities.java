package jhonnyx.clean.marvel.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import jhonnyx.clean.marvel.data.remote.ApiConstants;

/**
 * Created by jhonnybarrios on 08-09-17.
 */

public class Utilities {
    public static int getNewRandom() {
        Random rand = new Random();
        return rand.nextInt(500);
    }

    public static String getHash(long timestamp) {
        return md5(timestamp+ ApiConstants.PRIVATE_KEY+ApiConstants.PUBLIC_KEY);
    }

    private static String md5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            StringBuilder hexString = new StringBuilder();
            for (byte digestByte : md.digest(input.getBytes()))
                hexString.append(String.format("%02x", digestByte));
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void openURL(String webUrl,Context context) {
        if(webUrl==null||context==null)return;
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(webUrl));
        context.startActivity(i);
    }
}
