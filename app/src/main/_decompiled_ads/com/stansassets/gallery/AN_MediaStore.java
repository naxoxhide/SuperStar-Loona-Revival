package com.stansassets.gallery;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Environment;
import androidx.core.content.FileProvider;
import com.stansassets.core.interfaces.AN_ActivityResultCallback;
import com.stansassets.core.interfaces.AN_CallbackJsonHandler;
import com.stansassets.core.utility.AN_BitmapFactory;
import com.stansassets.core.utility.AN_Logger;
import com.stansassets.core.utility.AN_ProxyActivity;
import com.stansassets.core.utility.AN_UnityBridge;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class AN_MediaStore {
    static final int REQUEST_TAKE_PHOTO = 1;
    private static String currentPhotoPath;

    private static File createImageFileTest() throws IOException {
        File fileCreateTempFile = File.createTempFile("JPEG_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + "_", ".jpg", AN_UnityBridge.currentActivity.getExternalFilesDir(Environment.DIRECTORY_PICTURES));
        currentPhotoPath = fileCreateTempFile.getAbsolutePath();
        return fileCreateTempFile;
    }

    public static void TakePicture(final AN_CallbackJsonHandler aN_CallbackJsonHandler) {
        Activity activity = AN_UnityBridge.currentActivity;
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(activity.getPackageManager()) != null) {
            File fileCreateImageFileTest = null;
            try {
                fileCreateImageFileTest = createImageFileTest();
            } catch (IOException e) {
                AN_Logger.Log("Failed to create Image File");
                e.printStackTrace();
            }
            if (fileCreateImageFileTest != null) {
                final String path = fileCreateImageFileTest.getPath();
                AN_Logger.Log("Photo file path: " + path);
                AN_Logger.Log(" BuildConfig.APPLICATION_ID: com.example.camera_and_gallery");
                intent.putExtra("output", FileProvider.getUriForFile(activity, "com.stansassets.androidnative.pro.fileprovider", fileCreateImageFileTest));
                AN_ProxyActivity.startForResult(intent, new AN_ActivityResultCallback() { // from class: com.stansassets.gallery.AN_MediaStore.1
                    @Override // com.stansassets.core.interfaces.AN_ActivityResultCallback
                    public void onActivityResult(int i, int i2, Intent intent2) {
                        AN_GalleryPickResult aN_GalleryPickResult;
                        if (i2 == -1) {
                            aN_GalleryPickResult = new AN_GalleryPickResult();
                            Bitmap bitmapDecodeFile = AN_BitmapFactory.DecodeFile(path, 1024);
                            AN_Meida aN_Meida = new AN_Meida();
                            aN_Meida.m_type = 0;
                            aN_Meida.m_base64String = AN_BitmapFactory.EncodeToBase64(bitmapDecodeFile);
                            aN_Meida.m_path = path;
                            aN_GalleryPickResult.AddImage(aN_Meida);
                        } else {
                            aN_GalleryPickResult = new AN_GalleryPickResult(i2, "Failed To Take a Picture");
                        }
                        AN_UnityBridge.sendCallback(aN_CallbackJsonHandler, aN_GalleryPickResult, true);
                    }
                });
            }
        }
    }
}
