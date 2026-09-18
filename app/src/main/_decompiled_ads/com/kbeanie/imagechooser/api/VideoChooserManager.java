package com.kbeanie.imagechooser.api;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.Fragment;
import com.kbeanie.imagechooser.exceptions.ChooserException;
import com.kbeanie.imagechooser.threads.VideoProcessorListener;
import com.kbeanie.imagechooser.threads.VideoProcessorThread;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class VideoChooserManager extends BChooser implements VideoProcessorListener {
    private static final String TAG = "VideoChooserManager";
    private VideoChooserListener listener;

    public VideoChooserManager(Activity activity, int i) {
        super(activity, i, true);
    }

    public VideoChooserManager(Fragment fragment, int i) {
        super(fragment, i, true);
    }

    public VideoChooserManager(android.app.Fragment fragment, int i) {
        super(fragment, i, true);
    }

    @Deprecated
    public VideoChooserManager(Activity activity, int i, String str) {
        super(activity, i, str, true);
    }

    @Deprecated
    public VideoChooserManager(Fragment fragment, int i, String str) {
        super(fragment, i, str, true);
    }

    @Deprecated
    public VideoChooserManager(android.app.Fragment fragment, int i, String str) {
        super(fragment, i, str, true);
    }

    public VideoChooserManager(Activity activity, int i, boolean z) {
        super(activity, i, z);
    }

    public VideoChooserManager(Fragment fragment, int i, boolean z) {
        super(fragment, i, z);
    }

    public VideoChooserManager(android.app.Fragment fragment, int i, boolean z) {
        super(fragment, i, z);
    }

    @Deprecated
    public VideoChooserManager(Activity activity, int i, String str, boolean z) {
        super(activity, i, str, z);
    }

    @Deprecated
    public VideoChooserManager(Fragment fragment, int i, String str, boolean z) {
        super(fragment, i, str, z);
    }

    @Deprecated
    public VideoChooserManager(android.app.Fragment fragment, int i, String str, boolean z) {
        super(fragment, i, str, z);
    }

    public void setVideoChooserListener(VideoChooserListener videoChooserListener) {
        this.listener = videoChooserListener;
    }

    @Override // com.kbeanie.imagechooser.api.BChooser
    public String choose() throws ChooserException {
        if (this.listener == null) {
            throw new ChooserException("ImageChooserListener cannot be null. Forgot to set ImageChooserListener???");
        }
        int i = this.type;
        if (i == 292) {
            return captureVideo();
        }
        if (i == 295) {
            pickVideo();
            return null;
        }
        throw new ChooserException("Cannot choose an image in VideoChooserManager");
    }

    private String captureVideo() throws ChooserException {
        int i = Build.VERSION.SDK_INT;
        if (i >= 9 && i <= 10) {
            return captureVideoPatchedMethodForGingerbread();
        }
        return captureVideoCurrent();
    }

    private String captureVideoCurrent() throws ChooserException {
        checkDirectory();
        try {
            Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
            this.filePathOriginal = buildFilePathOriginal(this.foldername, "mp4");
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

    private String captureVideoPatchedMethodForGingerbread() throws ChooserException {
        try {
            Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
            if (this.extras != null) {
                intent.putExtras(this.extras);
            }
            startActivity(intent);
            return null;
        } catch (ActivityNotFoundException e) {
            throw new ChooserException(e);
        }
    }

    private void pickVideo() throws ChooserException {
        checkDirectory();
        try {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            if (this.extras != null) {
                intent.putExtras(this.extras);
            }
            intent.addFlags(1);
            intent.setType("video/*");
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            throw new ChooserException(e);
        }
    }

    @Override // com.kbeanie.imagechooser.api.BChooser
    public void submit(int i, Intent intent) {
        try {
            int i2 = this.type;
            if (i2 == 292) {
                processCameraVideo(intent);
            } else if (i2 == 295) {
                processVideoFromGallery(intent);
            }
        } catch (Exception e) {
            onError(e.getMessage());
        }
    }

    private void processVideoFromGallery(Intent intent) {
        String[] strArr;
        if (intent != null && intent.getDataString() != null && intent.getClipData() == null) {
            sanitizeURI(intent.getData().toString());
            if (this.filePathOriginal == null || TextUtils.isEmpty(this.filePathOriginal)) {
                onError("File path was null");
                return;
            }
            VideoProcessorThread videoProcessorThread = new VideoProcessorThread(this.filePathOriginal, this.foldername, this.shouldCreateThumbnails);
            videoProcessorThread.setListener(this);
            videoProcessorThread.setContext(getContext());
            videoProcessorThread.start();
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
            VideoProcessorThread videoProcessorThread2 = new VideoProcessorThread(strArr, this.foldername, this.shouldCreateThumbnails);
            videoProcessorThread2.clearOldFiles(this.clearOldFiles);
            videoProcessorThread2.setListener(this);
            videoProcessorThread2.setContext(getContext());
            videoProcessorThread2.start();
            return;
        }
        onError("Image Uri was null!");
    }

    private void processCameraVideo(Intent intent) {
        String dataString;
        int i = Build.VERSION.SDK_INT;
        if (i >= 9 && i <= 10) {
            dataString = intent.getDataString();
        } else {
            dataString = this.filePathOriginal;
        }
        VideoProcessorThread videoProcessorThread = new VideoProcessorThread(dataString, this.foldername, this.shouldCreateThumbnails);
        videoProcessorThread.clearOldFiles(this.clearOldFiles);
        videoProcessorThread.setListener(this);
        videoProcessorThread.setContext(getContext());
        videoProcessorThread.start();
    }

    @Override // com.kbeanie.imagechooser.threads.VideoProcessorListener
    public void onProcessedVideo(ChosenVideo chosenVideo) {
        VideoChooserListener videoChooserListener = this.listener;
        if (videoChooserListener != null) {
            videoChooserListener.onVideoChosen(chosenVideo);
        }
    }

    @Override // com.kbeanie.imagechooser.threads.VideoProcessorListener, com.kbeanie.imagechooser.threads.FileProcessorListener
    public void onError(String str) {
        VideoChooserListener videoChooserListener = this.listener;
        if (videoChooserListener != null) {
            videoChooserListener.onError(str);
        }
    }

    @Override // com.kbeanie.imagechooser.threads.VideoProcessorListener
    public void onProcessedVideos(ChosenVideos chosenVideos) {
        VideoChooserListener videoChooserListener = this.listener;
        if (videoChooserListener != null) {
            videoChooserListener.onVideosChosen(chosenVideos);
        }
    }
}
