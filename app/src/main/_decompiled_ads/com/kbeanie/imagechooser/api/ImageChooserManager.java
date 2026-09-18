package com.kbeanie.imagechooser.api;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.Fragment;
import com.kbeanie.imagechooser.exceptions.ChooserException;
import com.kbeanie.imagechooser.threads.ImageProcessorListener;
import com.kbeanie.imagechooser.threads.ImageProcessorThread;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class ImageChooserManager extends BChooser implements ImageProcessorListener {
    private static final String TAG = "ImageChooserManager";
    private ImageChooserListener listener;

    public ImageChooserManager(Activity activity, int i) {
        super(activity, i, true);
    }

    public ImageChooserManager(Fragment fragment, int i) {
        super(fragment, i, true);
    }

    public ImageChooserManager(android.app.Fragment fragment, int i) {
        super(fragment, i, true);
    }

    @Deprecated
    public ImageChooserManager(Activity activity, int i, String str) {
        super(activity, i, str, true);
    }

    @Deprecated
    public ImageChooserManager(Fragment fragment, int i, String str) {
        super(fragment, i, str, true);
    }

    @Deprecated
    public ImageChooserManager(android.app.Fragment fragment, int i, String str) {
        super(fragment, i, str, true);
    }

    public ImageChooserManager(Activity activity, int i, boolean z) {
        super(activity, i, z);
    }

    public ImageChooserManager(Fragment fragment, int i, boolean z) {
        super(fragment, i, z);
    }

    public ImageChooserManager(android.app.Fragment fragment, int i, boolean z) {
        super(fragment, i, z);
    }

    @Deprecated
    public ImageChooserManager(Activity activity, int i, String str, boolean z) {
        super(activity, i, str, z);
    }

    @Deprecated
    public ImageChooserManager(Fragment fragment, int i, String str, boolean z) {
        super(fragment, i, str, z);
    }

    @Deprecated
    public ImageChooserManager(android.app.Fragment fragment, int i, String str, boolean z) {
        super(fragment, i, str, z);
    }

    public void setImageChooserListener(ImageChooserListener imageChooserListener) {
        this.listener = imageChooserListener;
    }

    @Override // com.kbeanie.imagechooser.api.BChooser
    public String choose() throws ChooserException {
        if (this.listener == null) {
            throw new ChooserException("ImageChooserListener cannot be null. Forgot to set ImageChooserListener???");
        }
        int i = this.type;
        if (i == 291) {
            choosePicture();
            return null;
        }
        if (i == 294) {
            return takePicture();
        }
        throw new ChooserException("Cannot choose a video in ImageChooserManager");
    }

    private void choosePicture() throws ChooserException {
        checkDirectory();
        try {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType("image/*");
            if (this.extras != null) {
                intent.putExtras(this.extras);
            }
            intent.addFlags(1);
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            throw new ChooserException(e);
        }
    }

    private String takePicture() throws ChooserException {
        checkDirectory();
        try {
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            this.filePathOriginal = buildFilePathOriginal(this.foldername, "jpg");
            intent.putExtra("output", buildCaptureUri(this.filePathOriginal));
            if (this.extras != null) {
                intent.putExtras(this.extras);
            }
            startActivity(intent);
            return this.filePathOriginal;
        } catch (ActivityNotFoundException e) {
            throw new ChooserException(e);
        }
    }

    @Override // com.kbeanie.imagechooser.api.BChooser
    public void submit(int i, Intent intent) {
        try {
            if (i != this.type) {
                onError("onActivityResult requestCode is different from the type the chooser was initialized with.");
            } else if (i == 291) {
                processImageFromGallery(intent);
            } else if (i == 294) {
                processCameraImage();
            }
        } catch (Exception e) {
            onError(e.getMessage());
        }
    }

    private void processImageFromGallery(Intent intent) {
        String[] strArr;
        if (intent != null && intent.getDataString() != null) {
            sanitizeURI(intent.getData().toString());
            if (this.filePathOriginal == null || TextUtils.isEmpty(this.filePathOriginal)) {
                onError("File path was null");
                return;
            }
            ImageProcessorThread imageProcessorThread = new ImageProcessorThread(this.filePathOriginal, this.foldername, this.shouldCreateThumbnails);
            imageProcessorThread.clearOldFiles(this.clearOldFiles);
            imageProcessorThread.setListener(this);
            imageProcessorThread.setContext(getContext());
            imageProcessorThread.start();
            return;
        }
        if (intent.getClipData() != null || intent.hasExtra("uris")) {
            int i = 0;
            if (intent.hasExtra("uris")) {
                ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("uris");
                strArr = new String[parcelableArrayListExtra.size()];
                while (i < parcelableArrayListExtra.size()) {
                    strArr[i] = ((Uri) parcelableArrayListExtra.get(i)).toString();
                    i++;
                }
            } else {
                ClipData clipData = intent.getClipData();
                int itemCount = clipData.getItemCount();
                String[] strArr2 = new String[itemCount];
                while (i < itemCount) {
                    ClipData.Item itemAt = clipData.getItemAt(i);
                    Log.i(TAG, "processImageFromGallery: Item: " + itemAt.getUri());
                    strArr2[i] = itemAt.getUri().toString();
                    i++;
                }
                strArr = strArr2;
            }
            ImageProcessorThread imageProcessorThread2 = new ImageProcessorThread(strArr, this.foldername, this.shouldCreateThumbnails);
            imageProcessorThread2.clearOldFiles(this.clearOldFiles);
            imageProcessorThread2.setListener(this);
            imageProcessorThread2.setContext(getContext());
            imageProcessorThread2.start();
            return;
        }
        onError("Image Uri was null!");
    }

    private void processCameraImage() {
        ImageProcessorThread imageProcessorThread = new ImageProcessorThread(this.filePathOriginal, this.foldername, this.shouldCreateThumbnails);
        imageProcessorThread.setListener(this);
        imageProcessorThread.start();
    }

    @Override // com.kbeanie.imagechooser.threads.ImageProcessorListener
    public void onProcessedImage(ChosenImage chosenImage) {
        ImageChooserListener imageChooserListener = this.listener;
        if (imageChooserListener != null) {
            imageChooserListener.onImageChosen(chosenImage);
        }
    }

    @Override // com.kbeanie.imagechooser.threads.ImageProcessorListener, com.kbeanie.imagechooser.threads.VideoProcessorListener, com.kbeanie.imagechooser.threads.FileProcessorListener
    public void onError(String str) {
        ImageChooserListener imageChooserListener = this.listener;
        if (imageChooserListener != null) {
            imageChooserListener.onError(str);
        }
    }

    @Override // com.kbeanie.imagechooser.threads.ImageProcessorListener
    public void onProcessedImages(ChosenImages chosenImages) {
        ImageChooserListener imageChooserListener = this.listener;
        if (imageChooserListener != null) {
            imageChooserListener.onImagesChosen(chosenImages);
        }
    }
}
