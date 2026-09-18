package com.stansassets.gallery;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import com.facebook.internal.security.CertificateUtil;
import com.kbeanie.imagechooser.api.BChooser;
import com.kbeanie.imagechooser.api.ChosenImage;
import com.kbeanie.imagechooser.api.ChosenImages;
import com.kbeanie.imagechooser.api.ChosenVideo;
import com.kbeanie.imagechooser.api.ChosenVideos;
import com.kbeanie.imagechooser.api.ImageChooserListener;
import com.kbeanie.imagechooser.api.ImageChooserManager;
import com.kbeanie.imagechooser.api.MediaChooserListener;
import com.kbeanie.imagechooser.api.MediaChooserManager;
import com.kbeanie.imagechooser.api.VideoChooserListener;
import com.kbeanie.imagechooser.api.VideoChooserManager;
import com.stansassets.core.interfaces.AN_ActivityCreateCallback;
import com.stansassets.core.interfaces.AN_ActivityResultCallback;
import com.stansassets.core.interfaces.AN_CallbackJsonHandler;
import com.stansassets.core.utility.AN_Base64;
import com.stansassets.core.utility.AN_BitmapFactory;
import com.stansassets.core.utility.AN_Logger;
import com.stansassets.core.utility.AN_ProxyActivity;
import com.stansassets.core.utility.AN_UnityBridge;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class AN_Gallery {
    private static final int CAPTURE_PICTURE = 294;
    private static final int CAPTURE_VIDEO = 292;
    public static final int IMAGE_TYPE = 0;
    private static int MAX_IMAGE_SIZE = 1024;
    private static final int PICK_PICTURE = 291;
    private static final int PICK_PICTURE_OR_VIDEO = 300;
    private static final int PICK_VIDEO = 295;
    public static final int VIDEO_TYPE = 1;

    public static void SaveImageToGallery(String str, String str2, String str3, int i, AN_CallbackJsonHandler aN_CallbackJsonHandler) {
        AN_GallerySaveResult aN_GallerySaveResult;
        Bitmap.CompressFormat compressFormat;
        try {
            byte[] bArrDecode = AN_Base64.decode(str);
            if (i == 0) {
                AN_Logger.Log("SaveImageToGallery: JPEG format");
                compressFormat = Bitmap.CompressFormat.JPEG;
            } else {
                AN_Logger.Log("SaveImageToGallery: PNG format");
                compressFormat = Bitmap.CompressFormat.PNG;
            }
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), str2);
            AN_Logger.Log("imageRootDirectory.exists(): " + file.exists());
            if (!file.exists()) {
                AN_Logger.Log("appDirectory does not exists. let's create one");
                if (!file.mkdirs()) {
                    AN_UnityBridge.sendCallback(aN_CallbackJsonHandler, new AN_GallerySaveResult(100, "Not able to create directory with path: " + file.getPath()), true);
                    return;
                }
            }
            File file2 = new File(file, str3 + (compressFormat == Bitmap.CompressFormat.JPEG ? ".jpg" : ".png"));
            if (file2.exists()) {
                AN_Logger.Log("The file with the same name already exists. Let's remove it");
                if (!file2.delete()) {
                    AN_UnityBridge.sendCallback(aN_CallbackJsonHandler, new AN_GallerySaveResult(101, "Unable to delete file: " + file2.getAbsolutePath()), true);
                }
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmapDecodeByteArray.compress(compressFormat, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            addImageToGallery(file2, AN_UnityBridge.currentActivity);
            aN_GallerySaveResult = new AN_GallerySaveResult(file2.getAbsolutePath());
        } catch (Exception e) {
            aN_GallerySaveResult = new AN_GallerySaveResult(-1, e.getMessage());
        }
        AN_UnityBridge.sendCallback(aN_CallbackJsonHandler, aN_GallerySaveResult, true);
    }

    public static void addImageToGallery(File file, Context context) {
        file.getPath();
        MediaScannerConnection.scanFile(context, new String[]{file.toString()}, null, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.stansassets.gallery.AN_Gallery.1
            @Override // android.media.MediaScannerConnection.OnScanCompletedListener
            public void onScanCompleted(String str, Uri uri) {
                AN_Logger.Log("Scanned " + str + CertificateUtil.DELIMITER);
                AN_Logger.Log("-> uri=" + uri);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void BChooser_onError(String str, AN_CallbackJsonHandler aN_CallbackJsonHandler) {
        AN_UnityBridge.sendCallback(aN_CallbackJsonHandler, new AN_GalleryPickResult(1, str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void BChooser_onImageChosen(ChosenImage chosenImage, AN_CallbackJsonHandler aN_CallbackJsonHandler) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(chosenImage);
        BChooser_OnImagesPicked(arrayList, aN_CallbackJsonHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void BChooser_onImagesChosen(ChosenImages chosenImages, AN_CallbackJsonHandler aN_CallbackJsonHandler) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < chosenImages.size(); i++) {
            arrayList.add(chosenImages.getImage(i));
        }
        BChooser_OnImagesPicked(arrayList, aN_CallbackJsonHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void BChooser_OnImagesPicked(ArrayList<ChosenImage> arrayList, AN_CallbackJsonHandler aN_CallbackJsonHandler) {
        AN_GalleryPickResult aN_GalleryPickResult = new AN_GalleryPickResult();
        for (ChosenImage chosenImage : arrayList) {
            AN_Meida aN_Meida = new AN_Meida();
            aN_Meida.m_type = 0;
            Bitmap bitmapDecodeFile = AN_BitmapFactory.DecodeFile(chosenImage.getFilePathOriginal(), MAX_IMAGE_SIZE);
            if (bitmapDecodeFile == null) {
                AN_UnityBridge.sendCallback(aN_CallbackJsonHandler, new AN_GalleryPickResult(2, "Failed to read an image from file."), true);
                return;
            } else {
                aN_Meida.m_path = chosenImage.getFilePathOriginal();
                aN_Meida.m_base64String = AN_BitmapFactory.EncodeToBase64(bitmapDecodeFile);
                aN_GalleryPickResult.AddImage(aN_Meida);
            }
        }
        AN_UnityBridge.sendCallback(aN_CallbackJsonHandler, aN_GalleryPickResult, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void BChooser_onVideoChosen(ChosenVideo chosenVideo, AN_CallbackJsonHandler aN_CallbackJsonHandler) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(chosenVideo);
        BChooser_OnVideosPicked(arrayList, aN_CallbackJsonHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void BChooser_onVideosChosen(ChosenVideos chosenVideos, AN_CallbackJsonHandler aN_CallbackJsonHandler) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < chosenVideos.size(); i++) {
            arrayList.add(chosenVideos.getImage(i));
        }
        BChooser_OnVideosPicked(arrayList, aN_CallbackJsonHandler);
    }

    private static void BChooser_OnVideosPicked(ArrayList<ChosenVideo> arrayList, AN_CallbackJsonHandler aN_CallbackJsonHandler) {
        AN_GalleryPickResult aN_GalleryPickResult = new AN_GalleryPickResult();
        for (ChosenVideo chosenVideo : arrayList) {
            AN_Meida aN_Meida = new AN_Meida();
            aN_Meida.m_type = 1;
            aN_Meida.m_path = chosenVideo.getVideoFilePath();
            aN_Meida.m_base64String = AN_BitmapFactory.EncodeToBase64(AN_BitmapFactory.DecodeFile(chosenVideo.getThumbnailPath(), MAX_IMAGE_SIZE));
            aN_GalleryPickResult.AddImage(aN_Meida);
        }
        AN_UnityBridge.sendCallback(aN_CallbackJsonHandler, aN_GalleryPickResult, true);
    }

    private static BChooser pickPicure(AN_ProxyActivity aN_ProxyActivity, int i, final AN_CallbackJsonHandler aN_CallbackJsonHandler) {
        ImageChooserManager imageChooserManager = new ImageChooserManager(aN_ProxyActivity, i);
        imageChooserManager.setImageChooserListener(new ImageChooserListener() { // from class: com.stansassets.gallery.AN_Gallery.2
            @Override // com.kbeanie.imagechooser.api.ImageChooserListener
            public void onImageChosen(ChosenImage chosenImage) {
                AN_Gallery.BChooser_onImageChosen(chosenImage, aN_CallbackJsonHandler);
            }

            @Override // com.kbeanie.imagechooser.api.ImageChooserListener
            public void onImagesChosen(ChosenImages chosenImages) {
                AN_Gallery.BChooser_onImagesChosen(chosenImages, aN_CallbackJsonHandler);
            }

            @Override // com.kbeanie.imagechooser.api.ImageChooserListener
            public void onError(String str) {
                AN_Gallery.BChooser_onError(str, aN_CallbackJsonHandler);
            }

            public void OnImagesPicked(ArrayList<ChosenImage> arrayList) {
                AN_Gallery.BChooser_OnImagesPicked(arrayList, aN_CallbackJsonHandler);
            }
        });
        return imageChooserManager;
    }

    private static BChooser pickVideos(AN_ProxyActivity aN_ProxyActivity, int i, final AN_CallbackJsonHandler aN_CallbackJsonHandler) {
        VideoChooserManager videoChooserManager = new VideoChooserManager(aN_ProxyActivity, i);
        videoChooserManager.setVideoChooserListener(new VideoChooserListener() { // from class: com.stansassets.gallery.AN_Gallery.3
            @Override // com.kbeanie.imagechooser.api.VideoChooserListener
            public void onVideoChosen(ChosenVideo chosenVideo) {
                AN_Gallery.BChooser_onVideoChosen(chosenVideo, aN_CallbackJsonHandler);
            }

            @Override // com.kbeanie.imagechooser.api.VideoChooserListener
            public void onVideosChosen(ChosenVideos chosenVideos) {
                AN_Gallery.BChooser_onVideosChosen(chosenVideos, aN_CallbackJsonHandler);
            }

            @Override // com.kbeanie.imagechooser.api.VideoChooserListener
            public void onError(String str) {
                AN_Gallery.BChooser_onError(str, aN_CallbackJsonHandler);
            }
        });
        return videoChooserManager;
    }

    private static BChooser pickImageOrVideo(AN_ProxyActivity aN_ProxyActivity, int i, final AN_CallbackJsonHandler aN_CallbackJsonHandler) {
        MediaChooserManager mediaChooserManager = new MediaChooserManager(aN_ProxyActivity, i);
        mediaChooserManager.setMediaChooserListener(new MediaChooserListener() { // from class: com.stansassets.gallery.AN_Gallery.4
            @Override // com.kbeanie.imagechooser.api.ImageChooserListener
            public void onImageChosen(ChosenImage chosenImage) {
                AN_Gallery.BChooser_onImageChosen(chosenImage, aN_CallbackJsonHandler);
            }

            @Override // com.kbeanie.imagechooser.api.ImageChooserListener
            public void onImagesChosen(ChosenImages chosenImages) {
                AN_Gallery.BChooser_onImagesChosen(chosenImages, aN_CallbackJsonHandler);
            }

            @Override // com.kbeanie.imagechooser.api.VideoChooserListener
            public void onVideoChosen(ChosenVideo chosenVideo) {
                AN_Gallery.BChooser_onVideoChosen(chosenVideo, aN_CallbackJsonHandler);
            }

            @Override // com.kbeanie.imagechooser.api.VideoChooserListener
            public void onVideosChosen(ChosenVideos chosenVideos) {
                AN_Gallery.BChooser_onVideosChosen(chosenVideos, aN_CallbackJsonHandler);
            }

            @Override // com.kbeanie.imagechooser.api.ImageChooserListener
            public void onError(String str) {
                AN_Gallery.BChooser_onError(str, aN_CallbackJsonHandler);
            }
        });
        return mediaChooserManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static BChooser generateChooser(AN_ProxyActivity aN_ProxyActivity, int i, AN_CallbackJsonHandler aN_CallbackJsonHandler) {
        AN_Logger.Log("chooserType: " + i);
        if (i != 291) {
            if (i != 292) {
                if (i != 294) {
                    if (i != 295) {
                        if (i != 300) {
                            return null;
                        }
                        return pickImageOrVideo(aN_ProxyActivity, i, aN_CallbackJsonHandler);
                    }
                }
            }
            return pickVideos(aN_ProxyActivity, i, aN_CallbackJsonHandler);
        }
        return pickPicure(aN_ProxyActivity, i, aN_CallbackJsonHandler);
    }

    public static void PickImageFromGallery(int i, final int i2, final boolean z, final AN_CallbackJsonHandler aN_CallbackJsonHandler) {
        MAX_IMAGE_SIZE = i;
        AN_ProxyActivity.Create(new AN_ActivityCreateCallback<AN_ProxyActivity>() { // from class: com.stansassets.gallery.AN_Gallery.5
            @Override // com.stansassets.core.interfaces.AN_ActivityCreateCallback
            public void OnCreate(final AN_ProxyActivity aN_ProxyActivity) {
                try {
                    final BChooser bChooserGenerateChooser = AN_Gallery.generateChooser(aN_ProxyActivity, i2, aN_CallbackJsonHandler);
                    if (z) {
                        AN_Logger.Log("Multiselect allowed!");
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("android.intent.extra.ALLOW_MULTIPLE", true);
                        bChooserGenerateChooser.setExtras(bundle);
                    }
                    aN_ProxyActivity.AddActivityResultListener(new AN_ActivityResultCallback() { // from class: com.stansassets.gallery.AN_Gallery.5.1
                        @Override // com.stansassets.core.interfaces.AN_ActivityResultCallback
                        public void onActivityResult(int i3, int i4, Intent intent) {
                            try {
                                aN_ProxyActivity.finish();
                                bChooserGenerateChooser.submit(i3, intent);
                            } catch (Exception e) {
                                AN_UnityBridge.sendCallback(aN_CallbackJsonHandler, new AN_GalleryPickResult(100, e.getMessage()), true);
                            }
                        }
                    });
                    bChooserGenerateChooser.choose();
                } catch (Exception e) {
                    AN_UnityBridge.sendCallback(aN_CallbackJsonHandler, new AN_GalleryPickResult(100, e.getMessage()), true);
                }
            }
        });
    }

    public static void DeleteChooserTmpDirectory() {
        File file = new File(Environment.getExternalStorageDirectory() + "/bichooser");
        if (file.isDirectory()) {
            String[] list = file.list();
            for (int i = 0; i < list.length; i++) {
                AN_Logger.Log("chooser file deleted " + list[i]);
                new File(file, list[i]).delete();
            }
        }
        file.delete();
    }
}
