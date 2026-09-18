package com.kbeanie.imagechooser.threads;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import com.facebook.share.internal.ShareInternalUtility;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.kbeanie.imagechooser.api.ChosenFile;
import com.kbeanie.imagechooser.api.FileUtils;
import com.kbeanie.imagechooser.exceptions.ChooserException;
import com.kbeanie.imagechooser.helpers.StreamHelper;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.Calendar;

/* JADX INFO: loaded from: classes2.dex */
public class FileProcessorThread extends MediaProcessorThread {
    private static final String TAG = "FileProcessorThread";
    private ContentResolver cr;
    private String fileDisplayName;
    private long fileSize;
    private FileProcessorListener listener;
    private String mimeType;

    @Override // com.kbeanie.imagechooser.threads.MediaProcessorThread
    protected void processingDone(String str, String str2, String str3) {
    }

    public FileProcessorThread(String str, String str2, boolean z) {
        super(str, str2, z);
    }

    public void setListener(FileProcessorListener fileProcessorListener) {
        this.listener = fileProcessorListener;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0049  */
    /* JADX WARN: Code duplicated, block: B:24:0x0069 A[Catch: all -> 0x00f6, TryCatch #5 {all -> 0x00f6, blocks: (B:22:0x0057, B:24:0x0069, B:26:0x006f), top: B:84:0x0057 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:31:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:32:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:33:0x00e0  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v14, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r12v28, types: [android.content.ContentResolver] */
    /* JADX WARN: Type inference failed for: r12v30 */
    /* JADX WARN: Type inference failed for: r12v33, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v14, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v9 */
    @Override // com.kbeanie.imagechooser.threads.MediaProcessorThread
    public void setContext(Context context) throws Throwable {
        String str;
        InputStream inputStreamOpenInputStream;
        String extensionFromMimeType;
        this.context = context;
        ?? Substring = 0;
        Cursor cursorQuery = null;
        ?? r4 = 0;
        String str2 = null;
        String extensionFromMimeType2 = null;
        FileInputStream fileInputStream = null;
        if (this.filePath.startsWith("content")) {
            ?? contentResolver = context.getContentResolver();
            this.cr = contentResolver;
            this.mimeType = null;
            try {
                try {
                    inputStreamOpenInputStream = contentResolver.openInputStream(Uri.parse(this.filePath));
                    try {
                        StreamHelper.verifyStream(this.filePath, inputStreamOpenInputStream);
                        this.mimeType = URLConnection.guessContentTypeFromStream(inputStreamOpenInputStream);
                    } catch (ChooserException e) {
                        e = e;
                        Log.e(TAG, e.getMessage(), e);
                    } catch (IOException e2) {
                        e = e2;
                        Log.e(TAG, e.getMessage(), e);
                    }
                } catch (ChooserException e3) {
                    e = e3;
                    inputStreamOpenInputStream = null;
                    Log.e(TAG, e.getMessage(), e);
                    StreamHelper.closeSilent(inputStreamOpenInputStream);
                    contentResolver = this.mimeType;
                    if (contentResolver == 0) {
                        this.mimeType = this.cr.getType(Uri.parse(this.filePath));
                    }
                    cursorQuery = this.cr.query(Uri.parse(this.filePath), null, null, null, null);
                    if (cursorQuery != null) {
                        this.fileDisplayName = cursorQuery.getString(cursorQuery.getColumnIndex("_display_name"));
                    }
                    StreamHelper.closeSilent(cursorQuery);
                    extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(this.mimeType);
                    Log.i(TAG, "Extension: " + extensionFromMimeType);
                    if (extensionFromMimeType == null) {
                        if (this.mimeType.contains(RemoteSettings.FORWARD_SLASH_STRING)) {
                            setMediaExtension("." + this.mimeType.split(RemoteSettings.FORWARD_SLASH_STRING)[1]);
                            return;
                        } else {
                            setMediaExtension("." + this.mimeType);
                            return;
                        }
                    }
                    setMediaExtension("." + extensionFromMimeType);
                    return;
                } catch (IOException e4) {
                    e = e4;
                    inputStreamOpenInputStream = null;
                    Log.e(TAG, e.getMessage(), e);
                    StreamHelper.closeSilent(inputStreamOpenInputStream);
                    contentResolver = this.mimeType;
                    if (contentResolver == 0) {
                        this.mimeType = this.cr.getType(Uri.parse(this.filePath));
                    }
                    cursorQuery = this.cr.query(Uri.parse(this.filePath), null, null, null, null);
                    if (cursorQuery != null) {
                        this.fileDisplayName = cursorQuery.getString(cursorQuery.getColumnIndex("_display_name"));
                    }
                    StreamHelper.closeSilent(cursorQuery);
                    extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(this.mimeType);
                    Log.i(TAG, "Extension: " + extensionFromMimeType);
                    if (extensionFromMimeType == null) {
                        if (this.mimeType.contains(RemoteSettings.FORWARD_SLASH_STRING)) {
                            setMediaExtension("." + this.mimeType.split(RemoteSettings.FORWARD_SLASH_STRING)[1]);
                            return;
                        } else {
                            setMediaExtension("." + this.mimeType);
                            return;
                        }
                    }
                    setMediaExtension("." + extensionFromMimeType);
                    return;
                } catch (Throwable th) {
                    th = th;
                    StreamHelper.closeSilent(r4);
                    throw th;
                }
                StreamHelper.closeSilent(inputStreamOpenInputStream);
                contentResolver = this.mimeType;
                if (contentResolver == 0) {
                    this.mimeType = this.cr.getType(Uri.parse(this.filePath));
                }
                try {
                    cursorQuery = this.cr.query(Uri.parse(this.filePath), null, null, null, null);
                    if (cursorQuery != null && cursorQuery.moveToFirst()) {
                        this.fileDisplayName = cursorQuery.getString(cursorQuery.getColumnIndex("_display_name"));
                    }
                    StreamHelper.closeSilent(cursorQuery);
                    extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(this.mimeType);
                    Log.i(TAG, "Extension: " + extensionFromMimeType);
                    if (extensionFromMimeType == null) {
                        if (this.mimeType.contains(RemoteSettings.FORWARD_SLASH_STRING)) {
                            setMediaExtension("." + this.mimeType.split(RemoteSettings.FORWARD_SLASH_STRING)[1]);
                            return;
                        } else {
                            setMediaExtension("." + this.mimeType);
                            return;
                        }
                    }
                    setMediaExtension("." + extensionFromMimeType);
                    return;
                } catch (Throwable th2) {
                    StreamHelper.closeSilent(cursorQuery);
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
                r4 = contentResolver;
                StreamHelper.closeSilent(r4);
                throw th;
            }
        }
        try {
            if (this.filePath.startsWith(ShareInternalUtility.STAGING_PARAM)) {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(new File(Uri.parse(this.filePath).getPath()));
                    try {
                        this.mimeType = URLConnection.guessContentTypeFromStream(fileInputStream2);
                        ContentResolver contentResolver2 = context.getContentResolver();
                        this.cr = contentResolver2;
                        String type = contentResolver2.getType(Uri.parse(this.filePath));
                        this.mimeType = type;
                        if (type != null && (extensionFromMimeType2 = MimeTypeMap.getSingleton().getExtensionFromMimeType(this.mimeType)) != null) {
                            str2 = extensionFromMimeType2;
                            setMediaExtension("." + extensionFromMimeType2);
                            str2 = extensionFromMimeType2;
                        }
                        str2 = extensionFromMimeType2;
                        StreamHelper.closeSilent(fileInputStream2);
                        Substring = str2;
                    } catch (IOException e5) {
                        e = e5;
                        str = extensionFromMimeType2;
                        fileInputStream = fileInputStream2;
                        Log.e(TAG, e.getMessage(), e);
                        StreamHelper.closeSilent(fileInputStream);
                        Substring = str;
                    } catch (Throwable th4) {
                        th = th4;
                        Substring = fileInputStream2;
                    }
                } catch (IOException e6) {
                    e = e6;
                    str = null;
                }
                if (this.mimeType == null) {
                    this.mimeType = "application/octet-steam";
                }
                if (Substring == 0) {
                    int iLastIndexOf = this.filePath.lastIndexOf(46);
                    if (iLastIndexOf > 0) {
                        Substring = Substring;
                        Substring = this.filePath.substring(iLastIndexOf + 1);
                    }
                    if (Substring != 0 && !TextUtils.isEmpty(Substring)) {
                        setMediaExtension("." + Substring);
                    }
                }
                String str3 = this.fileDisplayName;
                if (str3 == null || !TextUtils.isEmpty(str3)) {
                    this.fileDisplayName = new File(this.filePath).getName();
                }
                return;
            }
            return;
        } catch (Throwable th5) {
            th = th5;
        }
        StreamHelper.closeSilent(Substring);
        throw th;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws Throwable {
        try {
            manageDirectoryCache(this.mediaExtension);
            processFile();
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            FileProcessorListener fileProcessorListener = this.listener;
            if (fileProcessorListener != null) {
                fileProcessorListener.onError(e.getMessage());
            }
        }
    }

    private void processFile() throws Throwable {
        processFileDetails(this.filePath);
        process();
    }

    protected void processFileDetails(String str) throws Throwable {
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        IOException iOException;
        if (this.filePath.startsWith("content:")) {
            InputStream inputStream = null;
            try {
                InputStream inputStreamOpenInputStream = this.context.getContentResolver().openInputStream(Uri.parse(this.filePath));
                try {
                    StreamHelper.verifyStream(this.filePath, inputStreamOpenInputStream);
                    if (this.fileDisplayName == null) {
                        this.fileDisplayName = "" + Calendar.getInstance().getTimeInMillis() + this.mediaExtension;
                    }
                    if (!this.fileDisplayName.contains(".") && this.mediaExtension != null && this.mediaExtension.length() > 0) {
                        this.fileDisplayName += this.mediaExtension;
                    }
                    this.filePath = FileUtils.getDirectory(this.foldername) + File.separator + this.fileDisplayName;
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this.filePath));
                    try {
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int i = inputStreamOpenInputStream.read(bArr);
                            if (i > 0) {
                                bufferedOutputStream.write(bArr, 0, i);
                            } else {
                                this.fileSize = new File(this.filePath).length();
                                StreamHelper.close(inputStreamOpenInputStream);
                                StreamHelper.close(bufferedOutputStream);
                                return;
                            }
                        }
                    } catch (IOException e) {
                        iOException = e;
                        inputStream = inputStreamOpenInputStream;
                        try {
                            throw new ChooserException(iOException);
                        } catch (Throwable th2) {
                            th = th2;
                            StreamHelper.close(inputStream);
                            StreamHelper.close(bufferedOutputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = inputStreamOpenInputStream;
                        StreamHelper.close(inputStream);
                        StreamHelper.close(bufferedOutputStream);
                        throw th;
                    }
                } catch (IOException e2) {
                    bufferedOutputStream = null;
                    inputStream = inputStreamOpenInputStream;
                    iOException = e2;
                } catch (Throwable th4) {
                    bufferedOutputStream = null;
                    inputStream = inputStreamOpenInputStream;
                    th = th4;
                }
            } catch (IOException e3) {
                iOException = e3;
                bufferedOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                bufferedOutputStream = null;
            }
        } else if (this.filePath.startsWith("file:")) {
            this.filePath = this.filePath.substring(7);
        }
    }

    @Override // com.kbeanie.imagechooser.threads.MediaProcessorThread
    protected void process() throws Throwable {
        super.process();
        if (this.listener != null) {
            ChosenFile chosenFile = new ChosenFile();
            chosenFile.setFilePath(this.filePath);
            chosenFile.setExtension(this.mediaExtension);
            chosenFile.setFileName(this.fileDisplayName);
            chosenFile.setFileSize(this.fileSize);
            chosenFile.setMimeType(this.mimeType);
            this.listener.onProcessedFile(chosenFile);
        }
    }
}
