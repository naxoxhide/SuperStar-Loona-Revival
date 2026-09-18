package com.kbeanie.imagechooser.threads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.webkit.ProxyConfig;
import com.kbeanie.imagechooser.api.ChosenImage;
import com.kbeanie.imagechooser.api.ChosenImages;
import com.kbeanie.imagechooser.exceptions.ChooserException;

/* JADX INFO: loaded from: classes2.dex */
public class ImageProcessorThread extends MediaProcessorThread {
    private static final String TAG = "ImageProcessorThread";
    private boolean isMultiple;
    private ImageProcessorListener listener;

    public ImageProcessorThread(String str, String str2, boolean z) {
        super(str, str2, z);
        setMediaExtension("jpg");
    }

    public ImageProcessorThread(String[] strArr, String str, boolean z) {
        super(strArr, str, z);
        this.isMultiple = true;
    }

    public void setListener(ImageProcessorListener imageProcessorListener) {
        this.listener = imageProcessorListener;
    }

    @Override // com.kbeanie.imagechooser.threads.MediaProcessorThread
    public void setContext(Context context) {
        this.context = context;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws Throwable {
        try {
            manageDirectoryCache("jpg");
            if (!this.isMultiple) {
                processImage();
            } else {
                ChosenImages chosenImagesProcessImages = processImages();
                ImageProcessorListener imageProcessorListener = this.listener;
                if (imageProcessorListener != null) {
                    imageProcessorListener.onProcessedImages(chosenImagesProcessImages);
                }
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            ImageProcessorListener imageProcessorListener2 = this.listener;
            if (imageProcessorListener2 != null) {
                imageProcessorListener2.onError(e.getMessage());
            }
        }
    }

    private ChosenImages processImages() throws ChooserException {
        ChosenImages chosenImages = new ChosenImages();
        for (String absoluteImagePathFromUri : this.filePaths) {
            if (absoluteImagePathFromUri != null && absoluteImagePathFromUri.startsWith("content:")) {
                absoluteImagePathFromUri = getAbsoluteImagePathFromUri(Uri.parse(absoluteImagePathFromUri));
            }
            if (absoluteImagePathFromUri == null || TextUtils.isEmpty(absoluteImagePathFromUri)) {
                ImageProcessorListener imageProcessorListener = this.listener;
                if (imageProcessorListener != null) {
                    imageProcessorListener.onError("Couldn't process a null file");
                }
            } else if (absoluteImagePathFromUri.startsWith(ProxyConfig.MATCH_HTTP)) {
                chosenImages.addImage(downloadAndProcessNew(absoluteImagePathFromUri));
            } else if (absoluteImagePathFromUri.startsWith("content://com.google.android.gallery3d") || absoluteImagePathFromUri.startsWith("content://com.microsoft.skydrive.content")) {
                chosenImages.addImage(processPicasaMediaNew(absoluteImagePathFromUri, ".jpg"));
            } else if (absoluteImagePathFromUri.startsWith("content://com.google.android.apps.photos.content") || absoluteImagePathFromUri.startsWith("content://com.android.providers.media.documents") || absoluteImagePathFromUri.startsWith("content://com.google.android.apps.docs.storage") || absoluteImagePathFromUri.startsWith("content://com.android.externalstorage.documents") || absoluteImagePathFromUri.startsWith("content://com.android.internalstorage.documents") || absoluteImagePathFromUri.startsWith("content://")) {
                chosenImages.addImage(processGooglePhotosMediaNew(absoluteImagePathFromUri, ".jpg"));
            } else {
                chosenImages.addImage(process(absoluteImagePathFromUri));
            }
        }
        return chosenImages;
    }

    private void processImage() throws Throwable {
        if (this.filePath != null && this.filePath.startsWith("content:")) {
            this.filePath = getAbsoluteImagePathFromUri(Uri.parse(this.filePath));
        }
        if (this.filePath == null || TextUtils.isEmpty(this.filePath)) {
            ImageProcessorListener imageProcessorListener = this.listener;
            if (imageProcessorListener != null) {
                imageProcessorListener.onError("Couldn't process a null file");
                return;
            }
            return;
        }
        if (this.filePath.startsWith(ProxyConfig.MATCH_HTTP)) {
            downloadAndProcess(this.filePath);
            return;
        }
        if (this.filePath.startsWith("content://com.google.android.gallery3d") || this.filePath.startsWith("content://com.microsoft.skydrive.content")) {
            processPicasaMedia(this.filePath, ".jpg");
            return;
        }
        if (this.filePath.startsWith("content://com.google.android.apps.photos.content") || this.filePath.startsWith("content://com.android.providers.media.documents") || this.filePath.startsWith("content://com.google.android.apps.docs.storage") || this.filePath.startsWith("content://com.android.externalstorage.documents") || this.filePath.startsWith("content://com.android.internalstorage.documents") || this.filePath.startsWith("content://")) {
            processGooglePhotosMedia(this.filePath, ".jpg");
        } else {
            process();
        }
    }

    @Override // com.kbeanie.imagechooser.threads.MediaProcessorThread
    protected void process() throws Throwable {
        super.process();
        if (this.shouldCreateThumnails) {
            String[] strArrCreateThumbnails = createThumbnails(this.filePath);
            processingDone(this.filePath, strArrCreateThumbnails[0], strArrCreateThumbnails[1]);
        } else {
            processingDone(this.filePath, this.filePath, this.filePath);
        }
    }

    protected ChosenImage process(String str) throws ChooserException {
        ChosenImage chosenImageProcessImage = super.processImage(str);
        if (this.shouldCreateThumnails) {
            String[] strArrCreateThumbnails = createThumbnails(str);
            chosenImageProcessImage.setFileThumbnail(strArrCreateThumbnails[0]);
            chosenImageProcessImage.setFileThumbnailSmall(strArrCreateThumbnails[1]);
        }
        return chosenImageProcessImage;
    }

    @Override // com.kbeanie.imagechooser.threads.MediaProcessorThread
    protected void processingDone(String str, String str2, String str3) {
        if (this.listener != null) {
            ChosenImage chosenImage = new ChosenImage();
            chosenImage.setFilePathOriginal(str);
            chosenImage.setFileThumbnail(str2);
            chosenImage.setFileThumbnailSmall(str3);
            this.listener.onProcessedImage(chosenImage);
        }
    }
}
