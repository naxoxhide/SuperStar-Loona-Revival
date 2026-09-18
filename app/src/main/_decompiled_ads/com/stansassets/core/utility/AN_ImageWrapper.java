package com.stansassets.core.utility;

import android.content.ContentValues;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.core.content.FileProvider;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class AN_ImageWrapper {
    private static boolean PreferInternalStorage = false;

    public static void SetStorageOptions(boolean z) {
        PreferInternalStorage = z;
        if (z) {
            AN_Logger.Log("Preferred storage set to Internal");
        } else {
            AN_Logger.Log("Preferred storage set to External");
        }
    }

    public static Uri GetImageUri(String str) {
        try {
            if (PreferInternalStorage) {
                try {
                    return GetImageUriInternal(str);
                } catch (Exception unused) {
                    return GetImageUriExternal(str);
                }
            }
            try {
                return GetImageUriExternal(str);
            } catch (Exception unused2) {
                return GetImageUriInternal(str);
            }
        } catch (Exception e) {
            AN_Logger.LogError("Failed to generate image URI: " + e.getMessage());
            return Uri.parse("");
        }
        AN_Logger.LogError("Failed to generate image URI: " + e.getMessage());
        return Uri.parse("");
    }

    private static Uri GetImageUriExternal(String str) throws Exception {
        byte[] bArrDecode = AN_Base64.decode(str);
        AN_Logger.Log("Creating Share URI with external storage");
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
        bitmapDecodeByteArray.compress(Bitmap.CompressFormat.PNG, 100, new ByteArrayOutputStream());
        String str2 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "");
        file.mkdirs();
        String str3 = "Screenshot_" + str2 + ".png";
        File file2 = new File(file, str3);
        int i = 1;
        while (file2.exists()) {
            str3 = "Screenshot_" + str2 + Integer.toString(i) + ".png";
            file2 = new File(file, str3);
            i++;
        }
        AN_Logger.Log("FileName: " + str3);
        AN_Logger.Log("is exists: " + file2.exists());
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        bitmapDecodeByteArray.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", str3);
        contentValues.put("description", "");
        contentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("bucket_id", Integer.valueOf(file2.toString().toLowerCase(Locale.US).hashCode()));
        contentValues.put("bucket_display_name", file2.getName().toLowerCase(Locale.US));
        contentValues.put("_data", file2.getAbsolutePath());
        Uri uriInsert = AN_UnityBridge.currentActivity.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        AN_Logger.Log("Saved: " + uriInsert);
        return uriInsert;
    }

    private static Uri GetImageUriInternal(String str) throws Exception {
        byte[] bArrDecode = AN_Base64.decode(str);
        AN_Logger.Log("Creating Share URI with local storage");
        AN_Logger.Log("rootCreated: " + new File(AN_UnityBridge.currentActivity.getCacheDir(), "image").mkdirs());
        File file = new File(AN_UnityBridge.currentActivity.getCacheDir(), "image/screen.png");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(bArrDecode);
        fileOutputStream.close();
        AN_Logger.Log("File exists: " + file.exists());
        Uri uriForFile = FileProvider.getUriForFile(AN_UnityBridge.currentActivity, AN_UnityBridge.currentActivity.getPackageName() + ".fileprovider", file);
        AN_Logger.Log("Local Path with file provider: " + uriForFile.toString());
        return uriForFile;
    }
}
