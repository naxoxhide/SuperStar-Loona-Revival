package com.kbeanie.imagechooser.threads;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.webkit.ProxyConfig;
import com.kbeanie.imagechooser.api.ChosenVideo;
import com.kbeanie.imagechooser.api.ChosenVideos;
import com.kbeanie.imagechooser.api.FileUtils;
import com.kbeanie.imagechooser.exceptions.ChooserException;
import com.kbeanie.imagechooser.helpers.StreamHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

/* JADX INFO: loaded from: classes2.dex */
public class VideoProcessorThread extends MediaProcessorThread {
    private static final String TAG = "VideoProcessorThread";
    private boolean isMultiple;
    private VideoProcessorListener listener;
    private String previewImage;

    public VideoProcessorThread(String str, String str2, boolean z) {
        super(str, str2, z);
        setMediaExtension("mp4");
    }

    public VideoProcessorThread(String[] strArr, String str, boolean z) {
        super(strArr, str, z);
        this.isMultiple = true;
    }

    public void setListener(VideoProcessorListener videoProcessorListener) {
        this.listener = videoProcessorListener;
    }

    @Override // com.kbeanie.imagechooser.threads.MediaProcessorThread
    public void setContext(Context context) {
        this.context = context;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws Throwable {
        try {
            manageDirectoryCache("mp4");
            if (!this.isMultiple) {
                processVideo();
            } else {
                ChosenVideos chosenVideosProcessVideos = processVideos();
                VideoProcessorListener videoProcessorListener = this.listener;
                if (videoProcessorListener != null) {
                    videoProcessorListener.onProcessedVideos(chosenVideosProcessVideos);
                }
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            VideoProcessorListener videoProcessorListener2 = this.listener;
            if (videoProcessorListener2 != null) {
                videoProcessorListener2.onError(e.getMessage());
            }
        }
    }

    private ChosenVideos processVideos() throws Throwable {
        ChosenVideos chosenVideos = new ChosenVideos();
        for (String absoluteImagePathFromUri : this.filePaths) {
            ChosenVideo chosenVideoProcessPicasaMediaNewVideo = null;
            if (absoluteImagePathFromUri != null && absoluteImagePathFromUri.startsWith("content:")) {
                absoluteImagePathFromUri = getAbsoluteImagePathFromUri(Uri.parse(absoluteImagePathFromUri));
            }
            if (absoluteImagePathFromUri != null && !TextUtils.isEmpty(absoluteImagePathFromUri)) {
                if (absoluteImagePathFromUri.startsWith(ProxyConfig.MATCH_HTTP)) {
                    chosenVideoProcessPicasaMediaNewVideo = downloadAndProcessVideo(absoluteImagePathFromUri);
                } else if (absoluteImagePathFromUri.startsWith("content://com.google.android.gallery3d") || absoluteImagePathFromUri.startsWith("content://com.microsoft.skydrive.content.external")) {
                    chosenVideoProcessPicasaMediaNewVideo = processPicasaMediaNewVideo(absoluteImagePathFromUri, ".mp4");
                } else if (absoluteImagePathFromUri.startsWith("content://com.google.android.apps.photos.content") || absoluteImagePathFromUri.startsWith("content://com.android.providers.media.documents") || absoluteImagePathFromUri.startsWith("content://com.google.android.apps.docs.storage") || absoluteImagePathFromUri.startsWith("content://")) {
                    chosenVideoProcessPicasaMediaNewVideo = processGooglePhotosMediaNewVideo(absoluteImagePathFromUri, ".mp4");
                } else if (absoluteImagePathFromUri.startsWith("content://media/external/video")) {
                    chosenVideoProcessPicasaMediaNewVideo = processContentProviderMediaNewVideo(absoluteImagePathFromUri, ".mp4");
                } else {
                    chosenVideoProcessPicasaMediaNewVideo = process(absoluteImagePathFromUri);
                }
            }
            String strCreatePreviewImage = createPreviewImage(chosenVideoProcessPicasaMediaNewVideo.getVideoFilePath());
            chosenVideoProcessPicasaMediaNewVideo.setVideoPreviewImage(strCreatePreviewImage);
            if (this.shouldCreateThumnails) {
                String[] strArrCreateThumbnails = createThumbnails(strCreatePreviewImage);
                chosenVideoProcessPicasaMediaNewVideo.setThumbnailPath(strArrCreateThumbnails[0]);
                chosenVideoProcessPicasaMediaNewVideo.setThumbnailSmallPath(strArrCreateThumbnails[1]);
            }
            chosenVideos.addVideo(chosenVideoProcessPicasaMediaNewVideo);
        }
        return chosenVideos;
    }

    private void processVideo() throws Throwable {
        if (this.filePath != null && this.filePath.startsWith("content:")) {
            this.filePath = getAbsoluteImagePathFromUri(Uri.parse(this.filePath));
        }
        if (this.filePath == null || TextUtils.isEmpty(this.filePath)) {
            VideoProcessorListener videoProcessorListener = this.listener;
            if (videoProcessorListener != null) {
                videoProcessorListener.onError("Couldn't process a null file");
                return;
            }
            return;
        }
        if (this.filePath.startsWith(ProxyConfig.MATCH_HTTP)) {
            downloadAndProcess(this.filePath);
            return;
        }
        if (this.filePath.startsWith("content://com.google.android.gallery3d") || this.filePath.startsWith("content://com.microsoft.skydrive.content.external")) {
            processPicasaMedia(this.filePath, ".mp4");
            return;
        }
        if (this.filePath.startsWith("content://com.google.android.apps.photos.content") || this.filePath.startsWith("content://com.android.providers.media.documents") || this.filePath.startsWith("content://com.google.android.apps.docs.storage") || this.filePath.startsWith("content://")) {
            processGooglePhotosMedia(this.filePath, ".mp4");
        } else if (this.filePath.startsWith("content://media/external/video")) {
            processContentProviderMedia(this.filePath, ".mp4");
        } else {
            process();
        }
    }

    protected ChosenVideo process(String str) throws ChooserException {
        ChosenVideo chosenVideoProcessVideo = super.processVideo(str);
        chosenVideoProcessVideo.setVideoPreviewImage(createPreviewImage());
        if (this.shouldCreateThumnails) {
            String[] strArrCreateThumbnails = createThumbnails(createThumbnailOfVideo());
            chosenVideoProcessVideo.setThumbnailPath(strArrCreateThumbnails[0]);
            chosenVideoProcessVideo.setThumbnailSmallPath(strArrCreateThumbnails[1]);
        }
        return chosenVideoProcessVideo;
    }

    @Override // com.kbeanie.imagechooser.threads.MediaProcessorThread
    protected void process() throws Throwable {
        super.process();
        if (this.shouldCreateThumnails) {
            createPreviewImage();
            String[] strArrCreateThumbnails = createThumbnails(createThumbnailOfVideo());
            processingDone(this.filePath, strArrCreateThumbnails[0], strArrCreateThumbnails[1]);
            return;
        }
        processingDone(this.filePath, this.filePath, this.filePath);
    }

    private String createPreviewImage() throws Throwable {
        FileOutputStream fileOutputStream;
        Throwable th;
        IOException e;
        this.previewImage = null;
        Bitmap bitmapCreateVideoThumbnail = ThumbnailUtils.createVideoThumbnail(this.filePath, 2);
        if (bitmapCreateVideoThumbnail != null) {
            this.previewImage = FileUtils.getDirectory(this.foldername) + File.separator + Calendar.getInstance().getTimeInMillis() + ".jpg";
            try {
                fileOutputStream = new FileOutputStream(new File(this.previewImage));
                try {
                    try {
                        bitmapCreateVideoThumbnail.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                        StreamHelper.flush(fileOutputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        StreamHelper.flush(fileOutputStream);
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                    throw new ChooserException(e);
                }
            } catch (IOException e3) {
                fileOutputStream = null;
                e = e3;
            } catch (Throwable th3) {
                fileOutputStream = null;
                th = th3;
                StreamHelper.flush(fileOutputStream);
                throw th;
            }
        }
        return this.previewImage;
    }

    private String createPreviewImage(String str) throws Throwable {
        Bitmap bitmapCreateVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 2);
        FileOutputStream fileOutputStream = null;
        if (bitmapCreateVideoThumbnail == null) {
            return null;
        }
        String str2 = FileUtils.getDirectory(this.foldername) + File.separator + Calendar.getInstance().getTimeInMillis() + ".jpg";
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(str2));
                try {
                    bitmapCreateVideoThumbnail.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream2);
                    StreamHelper.flush(fileOutputStream2);
                    return str2;
                } catch (IOException e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    throw new ChooserException(e);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    StreamHelper.flush(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    private String createThumbnailOfVideo() throws Throwable {
        Bitmap bitmapCreateVideoThumbnail = ThumbnailUtils.createVideoThumbnail(this.filePath, 1);
        FileOutputStream fileOutputStream = null;
        if (bitmapCreateVideoThumbnail == null) {
            return null;
        }
        String str = FileUtils.getDirectory(this.foldername) + File.separator + Calendar.getInstance().getTimeInMillis() + ".jpg";
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(str));
                try {
                    bitmapCreateVideoThumbnail.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream2);
                    StreamHelper.flush(fileOutputStream2);
                    return str;
                } catch (IOException e) {
                    e = e;
                    throw new ChooserException(e);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    StreamHelper.flush(fileOutputStream);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.kbeanie.imagechooser.threads.MediaProcessorThread
    protected void processingDone(String str, String str2, String str3) {
        if (this.listener != null) {
            ChosenVideo chosenVideo = new ChosenVideo();
            chosenVideo.setVideoFilePath(str);
            chosenVideo.setThumbnailPath(str2);
            chosenVideo.setThumbnailSmallPath(str3);
            chosenVideo.setVideoPreviewImage(this.previewImage);
            this.listener.onProcessedVideo(chosenVideo);
        }
    }
}
