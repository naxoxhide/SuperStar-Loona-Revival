package com.kbeanie.imagechooser.threads;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.security.CertificateUtil;
import com.facebook.share.internal.ShareInternalUtility;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.kbeanie.imagechooser.api.ChosenImage;
import com.kbeanie.imagechooser.api.ChosenVideo;
import com.kbeanie.imagechooser.api.FileUtils;
import com.kbeanie.imagechooser.exceptions.ChooserException;
import com.kbeanie.imagechooser.helpers.StreamHelper;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MediaProcessorThread extends Thread {
    protected static final int MAX_DIRECTORY_SIZE = 524288000;
    protected static final int MAX_THRESHOLD_DAYS = 864000000;
    private static final String TAG = "MediaProcessorThread";
    private static final int THUMBNAIL_BIG = 1;
    private static final int THUMBNAIL_SMALL = 2;
    protected boolean clearOldFiles;
    protected Context context;
    protected String filePath;
    protected String[] filePaths;
    protected String foldername;
    protected String mediaExtension;
    protected boolean shouldCreateThumnails;

    protected abstract void processingDone(String str, String str2, String str3);

    public MediaProcessorThread(String str, String str2, boolean z) {
        this.filePaths = new String[0];
        this.clearOldFiles = false;
        this.filePath = str;
        this.foldername = str2;
        this.shouldCreateThumnails = z;
    }

    public MediaProcessorThread(String[] strArr, String str, boolean z) {
        this.filePaths = new String[0];
        this.clearOldFiles = false;
        this.filePaths = strArr;
        this.foldername = str;
        this.shouldCreateThumnails = z;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setMediaExtension(String str) {
        this.mediaExtension = str;
    }

    public void clearOldFiles(boolean z) {
        this.clearOldFiles = z;
    }

    protected void downloadAndProcess(String str) throws Throwable {
        this.filePath = downloadFile(str);
        process();
    }

    protected ChosenVideo downloadAndProcessVideo(String str) throws ChooserException {
        return processVideo(downloadFile(str));
    }

    protected ChosenImage downloadAndProcessNew(String str) throws ChooserException {
        return processImage(downloadFile(str));
    }

    protected void process() throws Throwable {
        if (this.filePath.contains(this.foldername)) {
            return;
        }
        copyFileToDir();
    }

    protected ChosenVideo processVideo(String str) throws ChooserException {
        ChosenVideo chosenVideo = new ChosenVideo();
        if (!str.contains(this.foldername)) {
            chosenVideo.setVideoFilePath(copyFileToDir(str));
        } else {
            chosenVideo.setVideoFilePath(str);
        }
        return chosenVideo;
    }

    protected ChosenImage processImage(String str) throws ChooserException {
        ChosenImage chosenImage = new ChosenImage();
        if (!str.contains(this.foldername)) {
            chosenImage.setFilePathOriginal(copyFileToDir(str));
        } else {
            chosenImage.setFilePathOriginal(str);
        }
        return chosenImage;
    }

    protected String[] createThumbnails(String str) throws ChooserException {
        return new String[]{getThumbnailPath(str), getThumbnailSmallPath(str)};
    }

    private String getThumbnailPath(String str) throws ChooserException {
        return compressAndSaveImage(str, 1);
    }

    private String getThumbnailSmallPath(String str) throws ChooserException {
        return compressAndSaveImage(str, 2);
    }

    private String compressAndSaveImage(String str, int i) throws Throwable {
        FileOutputStream fileOutputStream;
        int i2;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(bufferedInputStream, null, options);
            if (bitmapDecodeStream != null) {
                bitmapDecodeStream.recycle();
            }
            bufferedInputStream.close();
            int i3 = options.outWidth;
            int i4 = options.outHeight;
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                i2 = 180;
            } else if (attributeInt != 6) {
                i2 = attributeInt != 8 ? 0 : -90;
            } else {
                i2 = 90;
            }
            if (i3 <= i4) {
                i3 = i4;
            }
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            if (i3 > 3000) {
                options2.inSampleSize = i * 6;
            } else if (i3 > 2000 && i3 <= 3000) {
                options2.inSampleSize = i * 5;
            } else if (i3 > 1500 && i3 <= 2000) {
                options2.inSampleSize = i * 4;
            } else if (i3 > 1000 && i3 <= 1500) {
                options2.inSampleSize = i * 3;
            } else if (i3 <= 400 || i3 > 1000) {
                options2.inSampleSize = i;
            } else {
                options2.inSampleSize = i * 2;
            }
            options2.inJustDecodeBounds = false;
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(str));
            Bitmap bitmapDecodeStream2 = BitmapFactory.decodeStream(bufferedInputStream2, null, options2);
            bufferedInputStream2.close();
            if (bitmapDecodeStream2 == null) {
                StreamHelper.close((Closeable) null);
                StreamHelper.flush(null);
                StreamHelper.close((Closeable) null);
                return str;
            }
            File file = new File(str);
            File file2 = new File(file.getParent() + File.separator + file.getName().replace(".", "_fact_" + i + "."));
            fileOutputStream = new FileOutputStream(file2);
            if (i2 != 0) {
                try {
                    Matrix matrix = new Matrix();
                    matrix.setRotate(i2);
                    bitmapDecodeStream2 = Bitmap.createBitmap(bitmapDecodeStream2, 0, 0, bitmapDecodeStream2.getWidth(), bitmapDecodeStream2.getHeight(), matrix, false);
                } catch (IOException unused) {
                } catch (Exception unused2) {
                    StreamHelper.close((Closeable) null);
                    StreamHelper.flush(fileOutputStream);
                    StreamHelper.close(fileOutputStream);
                    return str;
                } catch (Throwable th) {
                    th = th;
                    StreamHelper.close((Closeable) null);
                    StreamHelper.flush(fileOutputStream);
                    StreamHelper.close(fileOutputStream);
                    throw th;
                }
            }
            bitmapDecodeStream2.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            String absolutePath = file2.getAbsolutePath();
            StreamHelper.close((Closeable) null);
            StreamHelper.flush(fileOutputStream);
            StreamHelper.close(fileOutputStream);
            return absolutePath;
        } catch (IOException unused3) {
            fileOutputStream = null;
        } catch (Exception unused4) {
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
        StreamHelper.close((Closeable) null);
        StreamHelper.flush(fileOutputStream);
        StreamHelper.close(fileOutputStream);
        return str;
    }

    private String copyFileToDir(String str) throws Throwable {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                File file = new File(Uri.parse(str).getPath());
                File file2 = new File(FileUtils.getDirectory(this.foldername) + File.separator + file.getName());
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file2));
                    try {
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int i = bufferedInputStream.read(bArr);
                            if (i > 0) {
                                bufferedOutputStream2.write(bArr, 0, i);
                            } else {
                                String absolutePath = file2.getAbsolutePath();
                                StreamHelper.flush(bufferedOutputStream2);
                                StreamHelper.close(bufferedInputStream);
                                StreamHelper.close(bufferedOutputStream2);
                                return absolutePath;
                            }
                        }
                    } catch (IOException e) {
                        e = e;
                        throw new ChooserException(e);
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream = bufferedOutputStream2;
                        StreamHelper.flush(bufferedOutputStream);
                        StreamHelper.close(bufferedInputStream);
                        StreamHelper.close(bufferedOutputStream);
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (IOException e3) {
                e = e3;
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private void copyFileToDir() throws Throwable {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        IOException e;
        try {
            File file = new File(Uri.parse(this.filePath).getPath());
            File file2 = new File(FileUtils.getDirectory(this.foldername) + File.separator + file.getName());
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                try {
                    try {
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int i = bufferedInputStream.read(bArr);
                            if (i > 0) {
                                bufferedOutputStream.write(bArr, 0, i);
                            } else {
                                this.filePath = file2.getAbsolutePath();
                                StreamHelper.flush(bufferedOutputStream);
                                StreamHelper.close(bufferedInputStream);
                                StreamHelper.close(bufferedOutputStream);
                                return;
                            }
                            th = th;
                            StreamHelper.flush(bufferedOutputStream);
                            StreamHelper.close(bufferedInputStream);
                            StreamHelper.close(bufferedOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (IOException e2) {
                    e = e2;
                    throw new ChooserException(e);
                }
            } catch (IOException e3) {
                bufferedOutputStream = null;
                e = e3;
            } catch (Throwable th3) {
                bufferedOutputStream = null;
                th = th3;
            }
        } catch (IOException e4) {
            bufferedInputStream = null;
            e = e4;
            bufferedOutputStream = null;
        } catch (Throwable th4) {
            bufferedInputStream = null;
            th = th4;
            bufferedOutputStream = null;
        }
    }

    protected String downloadFile(String str) {
        String str2 = "";
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new BufferedInputStream(((HttpURLConnection) new URL(str).openConnection()).getInputStream()));
            str2 = FileUtils.getDirectory(this.foldername) + File.separator + Calendar.getInstance().getTimeInMillis() + "." + this.mediaExtension;
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str2));
            byte[] bArr = new byte[1024];
            while (true) {
                int i = bufferedInputStream.read(bArr);
                if (i <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, i);
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            bufferedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return str2;
    }

    protected void manageDirectoryCache(final String str) {
        if (this.clearOldFiles) {
            File file = new File(FileUtils.getDirectory(this.foldername));
            File[] fileArrListFiles = file.listFiles();
            long length = 0;
            if (fileArrListFiles == null) {
                return;
            }
            for (File file2 : fileArrListFiles) {
                length += file2.length();
            }
            if (length > 524288000) {
                final long timeInMillis = Calendar.getInstance().getTimeInMillis();
                File[] fileArrListFiles2 = file.listFiles(new FileFilter() { // from class: com.kbeanie.imagechooser.threads.MediaProcessorThread.1
                    @Override // java.io.FileFilter
                    public boolean accept(File file3) {
                        return timeInMillis - file3.lastModified() > 864000000 && file3.getAbsolutePath().toUpperCase(Locale.ENGLISH).endsWith(str.toUpperCase(Locale.ENGLISH));
                    }
                });
                int i = 0;
                for (File file3 : fileArrListFiles2) {
                    i++;
                    file3.delete();
                }
                Log.i(TAG, "Deleted " + i + " files");
            }
        }
    }

    protected void processPicasaMedia(String str, String str2) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        bufferedOutputStream = null;
        bufferedOutputStream = null;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(this.context.getContentResolver().openInputStream(Uri.parse(str)));
            try {
                try {
                    StreamHelper.verifyStream(str, bufferedInputStream);
                    this.filePath = FileUtils.getDirectory(this.foldername) + File.separator + Calendar.getInstance().getTimeInMillis() + str2;
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this.filePath));
                    try {
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int i = bufferedInputStream.read(bArr);
                            if (i > 0) {
                                bufferedOutputStream.write(bArr, 0, i);
                            } else {
                                StreamHelper.flush(bufferedOutputStream);
                                process();
                                StreamHelper.close(bufferedInputStream);
                                StreamHelper.close(bufferedOutputStream);
                                return;
                            }
                        }
                    } catch (IOException e) {
                        e = e;
                        bufferedOutputStream2 = bufferedOutputStream;
                        throw new ChooserException(e);
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream2 = bufferedInputStream;
                        StreamHelper.close(bufferedInputStream2);
                        StreamHelper.close(bufferedOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = bufferedOutputStream2;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (IOException e3) {
            e = e3;
            bufferedInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
            StreamHelper.close(bufferedInputStream2);
            StreamHelper.close(bufferedOutputStream);
            throw th;
        }
    }

    protected ChosenVideo processPicasaMediaNewVideo(String str, String str2) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(this.context.getContentResolver().openInputStream(Uri.parse(str)));
                try {
                    StreamHelper.verifyStream(str, bufferedInputStream2);
                    String str3 = FileUtils.getDirectory(this.foldername) + File.separator + Calendar.getInstance().getTimeInMillis() + str2;
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str3));
                    try {
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int i = bufferedInputStream2.read(bArr);
                            if (i > 0) {
                                bufferedOutputStream.write(bArr, 0, i);
                            } else {
                                StreamHelper.flush(bufferedOutputStream);
                                ChosenVideo chosenVideoProcessVideo = processVideo(str3);
                                StreamHelper.close(bufferedInputStream2);
                                StreamHelper.close(bufferedOutputStream);
                                return chosenVideoProcessVideo;
                            }
                        }
                    } catch (IOException e) {
                        e = e;
                        throw new ChooserException(e);
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = bufferedInputStream2;
                        StreamHelper.close(bufferedInputStream);
                        StreamHelper.close(bufferedOutputStream);
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (IOException e3) {
                e = e3;
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = null;
                StreamHelper.close(bufferedInputStream);
                StreamHelper.close(bufferedOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
        }
    }

    protected ChosenImage processPicasaMediaNew(String str, String str2) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(this.context.getContentResolver().openInputStream(Uri.parse(str)));
                try {
                    StreamHelper.verifyStream(str, bufferedInputStream2);
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(FileUtils.getDirectory(this.foldername) + File.separator + Calendar.getInstance().getTimeInMillis() + str2));
                    try {
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int i = bufferedInputStream2.read(bArr);
                            if (i > 0) {
                                bufferedOutputStream.write(bArr, 0, i);
                            } else {
                                StreamHelper.flush(bufferedOutputStream);
                                ChosenImage chosenImageProcessImage = processImage(str);
                                StreamHelper.close(bufferedInputStream2);
                                StreamHelper.close(bufferedOutputStream);
                                return chosenImageProcessImage;
                            }
                        }
                    } catch (IOException e) {
                        e = e;
                        throw new ChooserException(e);
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = bufferedInputStream2;
                        StreamHelper.close(bufferedInputStream);
                        StreamHelper.close(bufferedOutputStream);
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (IOException e3) {
                e = e3;
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = null;
                StreamHelper.close(bufferedInputStream);
                StreamHelper.close(bufferedOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
        }
    }

    protected void processGooglePhotosMedia(String str, String str2) throws Throwable {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        String strCheckExtension = checkExtension(Uri.parse(str));
        if (strCheckExtension != null && !TextUtils.isEmpty(strCheckExtension)) {
            str2 = "." + strCheckExtension;
        }
        BufferedOutputStream bufferedOutputStream2 = null;
        bufferedOutputStream2 = null;
        bufferedInputStream = null;
        bufferedOutputStream2 = null;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            this.filePath = FileUtils.getDirectory(this.foldername) + File.separator + Calendar.getInstance().getTimeInMillis() + str2;
            parcelFileDescriptorOpenFileDescriptor = this.context.getContentResolver().openFileDescriptor(Uri.parse(str), CampaignEx.JSON_KEY_AD_R);
            try {
                StreamHelper.verifyStream(str, parcelFileDescriptorOpenFileDescriptor);
                bufferedInputStream = new BufferedInputStream(new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()));
                try {
                    BufferedInputStream bufferedInputStream3 = new BufferedInputStream(bufferedInputStream);
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this.filePath));
                    try {
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int i = bufferedInputStream3.read(bArr);
                            if (i > 0) {
                                bufferedOutputStream.write(bArr, 0, i);
                            } else {
                                StreamHelper.flush(bufferedOutputStream);
                                process();
                                StreamHelper.flush(bufferedOutputStream);
                                StreamHelper.close(bufferedOutputStream);
                                StreamHelper.close(bufferedInputStream);
                                StreamHelper.close(parcelFileDescriptorOpenFileDescriptor);
                                return;
                            }
                        }
                    } catch (IOException e) {
                        e = e;
                        bufferedInputStream2 = bufferedInputStream;
                        try {
                            throw new ChooserException(e);
                        } catch (Throwable th) {
                            th = th;
                            bufferedInputStream = bufferedInputStream2;
                            bufferedOutputStream2 = bufferedOutputStream;
                            StreamHelper.flush(bufferedOutputStream2);
                            StreamHelper.close(bufferedOutputStream2);
                            StreamHelper.close(bufferedInputStream);
                            StreamHelper.close(parcelFileDescriptorOpenFileDescriptor);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedOutputStream2 = bufferedOutputStream;
                        StreamHelper.flush(bufferedOutputStream2);
                        StreamHelper.close(bufferedOutputStream2);
                        StreamHelper.close(bufferedInputStream);
                        StreamHelper.close(parcelFileDescriptorOpenFileDescriptor);
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                    bufferedOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    StreamHelper.flush(bufferedOutputStream2);
                    StreamHelper.close(bufferedOutputStream2);
                    StreamHelper.close(bufferedInputStream);
                    StreamHelper.close(parcelFileDescriptorOpenFileDescriptor);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                bufferedOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream = null;
            }
        } catch (IOException e4) {
            e = e4;
            parcelFileDescriptorOpenFileDescriptor = null;
            bufferedOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            parcelFileDescriptorOpenFileDescriptor = null;
            bufferedInputStream = null;
        }
    }

    protected ChosenVideo processGooglePhotosMediaNewVideo(String str, String str2) throws Throwable {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        String strCheckExtension = checkExtension(Uri.parse(str));
        if (strCheckExtension != null && !TextUtils.isEmpty(strCheckExtension)) {
            str2 = "." + strCheckExtension;
        }
        BufferedOutputStream bufferedOutputStream2 = null;
        bufferedOutputStream2 = null;
        bufferedInputStream = null;
        bufferedOutputStream2 = null;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            String str3 = FileUtils.getDirectory(this.foldername) + File.separator + Calendar.getInstance().getTimeInMillis() + str2;
            parcelFileDescriptorOpenFileDescriptor = this.context.getContentResolver().openFileDescriptor(Uri.parse(str), CampaignEx.JSON_KEY_AD_R);
            try {
                StreamHelper.verifyStream(str, parcelFileDescriptorOpenFileDescriptor);
                bufferedInputStream = new BufferedInputStream(new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()));
                try {
                    BufferedInputStream bufferedInputStream3 = new BufferedInputStream(bufferedInputStream);
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str3));
                    try {
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int i = bufferedInputStream3.read(bArr);
                            if (i > 0) {
                                bufferedOutputStream.write(bArr, 0, i);
                            } else {
                                StreamHelper.flush(bufferedOutputStream);
                                ChosenVideo chosenVideoProcessVideo = processVideo(str3);
                                StreamHelper.flush(bufferedOutputStream);
                                StreamHelper.close(bufferedOutputStream);
                                StreamHelper.close(bufferedInputStream);
                                StreamHelper.close(parcelFileDescriptorOpenFileDescriptor);
                                return chosenVideoProcessVideo;
                            }
                        }
                    } catch (IOException e) {
                        e = e;
                        bufferedInputStream2 = bufferedInputStream;
                        try {
                            throw new ChooserException(e);
                        } catch (Throwable th) {
                            th = th;
                            bufferedInputStream = bufferedInputStream2;
                            bufferedOutputStream2 = bufferedOutputStream;
                            StreamHelper.flush(bufferedOutputStream2);
                            StreamHelper.close(bufferedOutputStream2);
                            StreamHelper.close(bufferedInputStream);
                            StreamHelper.close(parcelFileDescriptorOpenFileDescriptor);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedOutputStream2 = bufferedOutputStream;
                        StreamHelper.flush(bufferedOutputStream2);
                        StreamHelper.close(bufferedOutputStream2);
                        StreamHelper.close(bufferedInputStream);
                        StreamHelper.close(parcelFileDescriptorOpenFileDescriptor);
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                    bufferedOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    StreamHelper.flush(bufferedOutputStream2);
                    StreamHelper.close(bufferedOutputStream2);
                    StreamHelper.close(bufferedInputStream);
                    StreamHelper.close(parcelFileDescriptorOpenFileDescriptor);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                bufferedOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream = null;
            }
        } catch (IOException e4) {
            e = e4;
            parcelFileDescriptorOpenFileDescriptor = null;
            bufferedOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            parcelFileDescriptorOpenFileDescriptor = null;
            bufferedInputStream = null;
        }
    }

    protected ChosenImage processGooglePhotosMediaNew(String str, String str2) throws Throwable {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        String strCheckExtension = checkExtension(Uri.parse(str));
        if (strCheckExtension != null && !TextUtils.isEmpty(strCheckExtension)) {
            str2 = "." + strCheckExtension;
        }
        BufferedOutputStream bufferedOutputStream2 = null;
        bufferedOutputStream2 = null;
        bufferedInputStream = null;
        bufferedOutputStream2 = null;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            String str3 = FileUtils.getDirectory(this.foldername) + File.separator + Calendar.getInstance().getTimeInMillis() + str2;
            parcelFileDescriptorOpenFileDescriptor = this.context.getContentResolver().openFileDescriptor(Uri.parse(str), CampaignEx.JSON_KEY_AD_R);
            try {
                StreamHelper.verifyStream(str, parcelFileDescriptorOpenFileDescriptor);
                bufferedInputStream = new BufferedInputStream(new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()));
                try {
                    BufferedInputStream bufferedInputStream3 = new BufferedInputStream(bufferedInputStream);
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str3));
                    try {
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int i = bufferedInputStream3.read(bArr);
                            if (i > 0) {
                                bufferedOutputStream.write(bArr, 0, i);
                            } else {
                                StreamHelper.flush(bufferedOutputStream);
                                ChosenImage chosenImageProcessImage = processImage(str3);
                                StreamHelper.flush(bufferedOutputStream);
                                StreamHelper.close(bufferedOutputStream);
                                StreamHelper.close(bufferedInputStream);
                                StreamHelper.close(parcelFileDescriptorOpenFileDescriptor);
                                return chosenImageProcessImage;
                            }
                        }
                    } catch (IOException e) {
                        e = e;
                        bufferedInputStream2 = bufferedInputStream;
                        try {
                            throw new ChooserException(e);
                        } catch (Throwable th) {
                            th = th;
                            bufferedInputStream = bufferedInputStream2;
                            bufferedOutputStream2 = bufferedOutputStream;
                            StreamHelper.flush(bufferedOutputStream2);
                            StreamHelper.close(bufferedOutputStream2);
                            StreamHelper.close(bufferedInputStream);
                            StreamHelper.close(parcelFileDescriptorOpenFileDescriptor);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedOutputStream2 = bufferedOutputStream;
                        StreamHelper.flush(bufferedOutputStream2);
                        StreamHelper.close(bufferedOutputStream2);
                        StreamHelper.close(bufferedInputStream);
                        StreamHelper.close(parcelFileDescriptorOpenFileDescriptor);
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                    bufferedOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    StreamHelper.flush(bufferedOutputStream2);
                    StreamHelper.close(bufferedOutputStream2);
                    StreamHelper.close(bufferedInputStream);
                    StreamHelper.close(parcelFileDescriptorOpenFileDescriptor);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                bufferedOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream = null;
            }
        } catch (IOException e4) {
            e = e4;
            parcelFileDescriptorOpenFileDescriptor = null;
            bufferedOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            parcelFileDescriptorOpenFileDescriptor = null;
            bufferedInputStream = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0074  */
    public String checkExtension(Uri uri) {
        String strSubstring;
        Cursor cursorQuery = this.context.getContentResolver().query(uri, null, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("_display_name"));
                    strSubstring = string.substring(string.indexOf(".") + 1);
                    String str = TAG;
                    Log.i(str, "Display Name: " + string);
                    int columnIndex = cursorQuery.getColumnIndex("_size");
                    Log.i(str, "Size: " + (!cursorQuery.isNull(columnIndex) ? cursorQuery.getString(columnIndex) : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN));
                } else {
                    strSubstring = "";
                }
            } finally {
                cursorQuery.close();
            }
        } else {
            strSubstring = "";
        }
        return strSubstring;
    }

    protected void processContentProviderMedia(String str, String str2) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        checkExtension(Uri.parse(str));
        BufferedInputStream bufferedInputStream2 = null;
        bufferedOutputStream = null;
        bufferedOutputStream = null;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(this.context.getContentResolver().openInputStream(Uri.parse(str)));
            try {
                try {
                    StreamHelper.verifyStream(str, bufferedInputStream);
                    this.filePath = FileUtils.getDirectory(this.foldername) + File.separator + Calendar.getInstance().getTimeInMillis() + str2;
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this.filePath));
                    try {
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int i = bufferedInputStream.read(bArr);
                            if (i > 0) {
                                bufferedOutputStream.write(bArr, 0, i);
                            } else {
                                process();
                                StreamHelper.close(bufferedInputStream);
                                StreamHelper.close(bufferedOutputStream);
                                return;
                            }
                        }
                    } catch (IOException e) {
                        e = e;
                        bufferedOutputStream2 = bufferedOutputStream;
                        Log.e(TAG, e.getMessage(), e);
                        throw new ChooserException(e);
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream2 = bufferedInputStream;
                        StreamHelper.close(bufferedInputStream2);
                        StreamHelper.close(bufferedOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = bufferedOutputStream2;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (IOException e3) {
            e = e3;
            bufferedInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
            StreamHelper.close(bufferedInputStream2);
            StreamHelper.close(bufferedOutputStream);
            throw th;
        }
    }

    protected ChosenVideo processContentProviderMediaNewVideo(String str, String str2) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        checkExtension(Uri.parse(str));
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(this.context.getContentResolver().openInputStream(Uri.parse(str)));
                try {
                    StreamHelper.verifyStream(str, bufferedInputStream2);
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(FileUtils.getDirectory(this.foldername) + File.separator + Calendar.getInstance().getTimeInMillis() + str2));
                    try {
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int i = bufferedInputStream2.read(bArr);
                            if (i > 0) {
                                bufferedOutputStream.write(bArr, 0, i);
                            } else {
                                ChosenVideo chosenVideoProcessVideo = processVideo(str);
                                StreamHelper.close(bufferedInputStream2);
                                StreamHelper.close(bufferedOutputStream);
                                return chosenVideoProcessVideo;
                            }
                        }
                    } catch (IOException e) {
                        e = e;
                        Log.e(TAG, e.getMessage(), e);
                        throw new ChooserException(e);
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = bufferedInputStream2;
                        StreamHelper.close(bufferedInputStream);
                        StreamHelper.close(bufferedOutputStream);
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (IOException e3) {
                e = e3;
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = null;
                StreamHelper.close(bufferedInputStream);
                StreamHelper.close(bufferedOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
        }
    }

    protected String getAbsoluteImagePathFromUri(Uri uri) {
        String string;
        String[] strArr = {"_data", "_display_name"};
        if (uri.toString().startsWith("content://com.android.gallery3d.provider")) {
            uri = Uri.parse(uri.toString().replace("com.android.gallery3d", "com.google.android.gallery3d"));
        }
        String string2 = uri.toString();
        if (string2.startsWith("content://com.google.android.gallery3d") || string2.startsWith("content://com.google.android.apps.photos.content") || string2.startsWith("content://com.android.providers.media.documents") || string2.startsWith("content://com.google.android.apps.docs.storage") || string2.startsWith("content://com.microsoft.skydrive.content.external") || string2.startsWith("content://com.android.externalstorage.documents") || string2.startsWith("content://com.android.internalstorage.documents") || string2.startsWith("content://")) {
            string = uri.toString();
        } else {
            Cursor cursorQuery = this.context.getContentResolver().query(uri, strArr, null, null, null);
            cursorQuery.moveToFirst();
            string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
            cursorQuery.close();
        }
        return (string == null && isDownloadsDocument(uri) && Build.VERSION.SDK_INT >= 19) ? getPath(this.context, uri) : string;
    }

    public static String getPath(Context context, Uri uri) {
        Uri uri2 = null;
        if ((Build.VERSION.SDK_INT >= 19) && DocumentsContract.isDocumentUri(context, uri)) {
            if (isExternalStorageDocument(uri)) {
                String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(CertificateUtil.DELIMITER);
                if ("primary".equalsIgnoreCase(strArrSplit[0])) {
                    return Environment.getExternalStorageDirectory() + RemoteSettings.FORWARD_SLASH_STRING + strArrSplit[1];
                }
            } else {
                if (isDownloadsDocument(uri)) {
                    return getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
                }
                if (isMediaDocument(uri)) {
                    String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(CertificateUtil.DELIMITER);
                    String str = strArrSplit2[0];
                    if ("image".equals(str)) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(str)) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if ("audio".equals(str)) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return getDataColumn(context, uri2, "_id=?", new String[]{strArrSplit2[1]});
                }
            }
        } else {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                return getDataColumn(context, uri, null, null);
            }
            if (ShareInternalUtility.STAGING_PARAM.equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return null;
    }

    public static String getDataColumn(Context context, Uri uri, String str, String[] strArr) throws Throwable {
        Cursor cursor = null;
        try {
            Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return string;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }
}
