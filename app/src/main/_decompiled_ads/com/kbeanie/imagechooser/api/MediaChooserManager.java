package com.kbeanie.imagechooser.api;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.kbeanie.imagechooser.exceptions.ChooserException;
import com.kbeanie.imagechooser.threads.ImageProcessorListener;
import com.kbeanie.imagechooser.threads.ImageProcessorThread;
import com.kbeanie.imagechooser.threads.MediaProcessorThread;
import com.kbeanie.imagechooser.threads.VideoProcessorListener;
import com.kbeanie.imagechooser.threads.VideoProcessorThread;

/* JADX INFO: loaded from: classes2.dex */
public class MediaChooserManager extends BChooser implements ImageProcessorListener, VideoProcessorListener {
    private static final String TAG = "MediaChooserManager";
    private MediaChooserListener listener;

    public MediaChooserManager(Activity activity, int i) {
        super(activity, i, true);
    }

    public MediaChooserManager(Fragment fragment, int i) {
        super(fragment, i, true);
    }

    public MediaChooserManager(android.app.Fragment fragment, int i) {
        super(fragment, i, true);
    }

    public MediaChooserManager(Activity activity, int i, String str) {
        super(activity, i, str, true);
    }

    public MediaChooserManager(Fragment fragment, int i, String str) {
        super(fragment, i, str, true);
    }

    public MediaChooserManager(android.app.Fragment fragment, int i, String str) {
        super(fragment, i, str, true);
    }

    public MediaChooserManager(Activity activity, int i, boolean z) {
        super(activity, i, z);
    }

    public MediaChooserManager(Fragment fragment, int i, boolean z) {
        super(fragment, i, z);
    }

    public MediaChooserManager(android.app.Fragment fragment, int i, boolean z) {
        super(fragment, i, z);
    }

    public MediaChooserManager(Activity activity, int i, String str, boolean z) {
        super(activity, i, str, z);
    }

    public MediaChooserManager(Fragment fragment, int i, String str, boolean z) {
        super(fragment, i, str, z);
    }

    public MediaChooserManager(android.app.Fragment fragment, int i, String str, boolean z) {
        super(fragment, i, str, z);
    }

    public void setMediaChooserListener(MediaChooserListener mediaChooserListener) {
        this.listener = mediaChooserListener;
    }

    @Override // com.kbeanie.imagechooser.api.BChooser
    public String choose() throws ChooserException {
        if (this.listener == null) {
            throw new ChooserException("MediaChooserListener cannot be null. Forgot to set MediaChooserListener???");
        }
        if (this.type == 300) {
            chooseMedia();
            return null;
        }
        throw new ChooserException("This chooser type is unappropriate with MediaChooserManager: " + this.type);
    }

    private void chooseMedia() throws ChooserException {
        checkDirectory();
        try {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            if (this.extras != null) {
                intent.putExtras(this.extras);
            }
            intent.setType("video/*, image/*");
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            throw new ChooserException(e);
        }
    }

    @Override // com.kbeanie.imagechooser.api.BChooser
    public void submit(int i, Intent intent) {
        try {
            if (i != this.type) {
                onError("onActivityResult requestCode is different from the type the chooser was initialized with.");
            } else if (i == 300) {
                processImageFromGallery(intent);
            }
        } catch (Exception e) {
            onError(e.getMessage());
        }
    }

    private void processImageFromGallery(Intent intent) {
        MediaProcessorThread videoProcessorThread;
        if (intent != null && intent.getDataString() != null) {
            sanitizeURI(intent.getData().toString());
            if (this.filePathOriginal == null || TextUtils.isEmpty(this.filePathOriginal)) {
                onError("File path was null");
                return;
            }
            String str = this.filePathOriginal;
            if (!wasVideoSelected(intent)) {
                videoProcessorThread = new ImageProcessorThread(str, this.foldername, this.shouldCreateThumbnails);
                ((ImageProcessorThread) videoProcessorThread).setListener(this);
            } else {
                videoProcessorThread = new VideoProcessorThread(str, this.foldername, this.shouldCreateThumbnails);
                ((VideoProcessorThread) videoProcessorThread).setListener(this);
            }
            videoProcessorThread.setContext(getContext());
            videoProcessorThread.start();
            return;
        }
        onError("Image Uri was null!");
    }

    @Override // com.kbeanie.imagechooser.threads.ImageProcessorListener
    public void onProcessedImage(ChosenImage chosenImage) {
        MediaChooserListener mediaChooserListener = this.listener;
        if (mediaChooserListener != null) {
            mediaChooserListener.onImageChosen(chosenImage);
        }
    }

    @Override // com.kbeanie.imagechooser.threads.VideoProcessorListener
    public void onProcessedVideo(ChosenVideo chosenVideo) {
        MediaChooserListener mediaChooserListener = this.listener;
        if (mediaChooserListener != null) {
            mediaChooserListener.onVideoChosen(chosenVideo);
        }
    }

    public void onError(String str) {
        MediaChooserListener mediaChooserListener = this.listener;
        if (mediaChooserListener != null) {
            mediaChooserListener.onError(str);
        }
    }

    @Override // com.kbeanie.imagechooser.threads.VideoProcessorListener
    public void onProcessedVideos(ChosenVideos chosenVideos) {
        MediaChooserListener mediaChooserListener = this.listener;
        if (mediaChooserListener != null) {
            mediaChooserListener.onVideosChosen(chosenVideos);
        }
    }

    @Override // com.kbeanie.imagechooser.threads.ImageProcessorListener
    public void onProcessedImages(ChosenImages chosenImages) {
        MediaChooserListener mediaChooserListener = this.listener;
        if (mediaChooserListener != null) {
            mediaChooserListener.onImagesChosen(chosenImages);
        }
    }
}
