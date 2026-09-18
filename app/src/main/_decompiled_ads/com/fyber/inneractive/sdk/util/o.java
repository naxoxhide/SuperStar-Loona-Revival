package com.fyber.inneractive.sdk.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class o extends AsyncTask<Void, Void, Bitmap> {
    public Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f1344b;
    public String c;
    public String d = null;
    public int e;

    public interface a {
    }

    public o(Context context, a aVar, String str, String str2, int i) {
        this.a = context;
        this.f1344b = aVar;
        this.c = str;
        this.e = i;
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00d3 A[Catch: all -> 0x00ea, TRY_LEAVE, TryCatch #1 {all -> 0x00ea, blocks: (B:52:0x00c4, B:54:0x00d3), top: B:78:0x00c4 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00db A[DONT_GENERATE, DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:58:0x00dd A[Catch: all -> 0x00e6, DONT_GENERATE, TryCatch #0 {all -> 0x00e6, blocks: (B:56:0x00d8, B:58:0x00dd, B:60:0x00e2), top: B:76:0x00d8 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x00e2 A[Catch: all -> 0x00e6, DONT_GENERATE, TRY_LEAVE, TryCatch #0 {all -> 0x00e6, blocks: (B:56:0x00d8, B:58:0x00dd, B:60:0x00e2), top: B:76:0x00d8 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x00f2 A[Catch: all -> 0x00fb, FINALLY_INSNS, TryCatch #11 {all -> 0x00fb, blocks: (B:66:0x00ed, B:68:0x00f2, B:70:0x00f7), top: B:97:0x00ed }] */
    /* JADX WARN: Code duplicated, block: B:70:0x00f7 A[Catch: all -> 0x00fb, FINALLY_INSNS, TRY_LEAVE, TryCatch #11 {all -> 0x00fb, blocks: (B:66:0x00ed, B:68:0x00f2, B:70:0x00f7), top: B:97:0x00ed }] */
    /* JADX WARN: Code duplicated, block: B:76:0x00d8 A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.InputStream] */
    @Override // android.os.AsyncTask
    public Bitmap doInBackground(Void[] voidArr) {
        File file;
        FileOutputStream fileOutputStream;
        ?? r6;
        ?? inputStream;
        byte[] bArr = new byte[8192];
        Bitmap frameAtTime = null;
        try {
            file = new File(this.a.getFilesDir(), TextUtils.isEmpty(this.d) ? UUID.randomUUID().toString() + ".mp4" : this.d);
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    r6 = (HttpURLConnection) new URL(this.c).openConnection();
                    try {
                        r6.setConnectTimeout(5000);
                        r6.setReadTimeout(5000);
                        inputStream = r6.getInputStream();
                        int i = 0;
                        while (i < this.e - 8192) {
                            try {
                                int i2 = inputStream.read(bArr, 0, 8192);
                                if (i2 > -1) {
                                    fileOutputStream.write(bArr, 0, i2);
                                    i += i2;
                                }
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    IAlog.a("Failed getting frame from video file%s", q.b(th));
                                    if (file != null) {
                                        file.delete();
                                    }
                                } finally {
                                    if (r6 != 0) {
                                        try {
                                            r6.disconnect();
                                            if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                            if (inputStream != 0) {
                                                inputStream.close();
                                            }
                                        } catch (Throwable unused) {
                                            file.delete();
                                        }
                                    } else {
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        if (inputStream != 0) {
                                            inputStream.close();
                                        }
                                    }
                                }
                            }
                        }
                        try {
                            r6.disconnect();
                            fileOutputStream.close();
                            if (inputStream != 0) {
                                inputStream.close();
                            }
                        } catch (Throwable unused2) {
                            file.delete();
                        }
                        Object obj = new Object();
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        try {
                            try {
                                synchronized (obj) {
                                    mediaMetadataRetriever.setDataSource(file.getPath());
                                    mediaMetadataRetriever.extractMetadata(8192);
                                    frameAtTime = mediaMetadataRetriever.getFrameAtTime(1L);
                                }
                            } catch (Throwable th2) {
                                try {
                                    mediaMetadataRetriever.release();
                                } catch (Throwable unused3) {
                                }
                                throw th2;
                            }
                        } catch (Exception e) {
                            IAlog.a("Failed getting frame from video file%s", q.b(e));
                        }
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Throwable unused4) {
                        }
                        file.delete();
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = 0;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    r6 = 0;
                    inputStream = r6;
                    IAlog.a("Failed getting frame from video file%s", q.b(th));
                    if (file != null) {
                        file.delete();
                    }
                    return frameAtTime;
                }
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
                r6 = fileOutputStream;
                inputStream = r6;
                IAlog.a("Failed getting frame from video file%s", q.b(th));
                if (file != null) {
                    file.delete();
                }
                return frameAtTime;
            }
        } catch (Throwable th6) {
            th = th6;
            file = null;
            fileOutputStream = null;
        }
        return frameAtTime;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Bitmap bitmap) {
        Bitmap bitmap2 = bitmap;
        a aVar = this.f1344b;
        if (aVar == null) {
            return;
        }
        if (bitmap2 != null) {
            com.fyber.inneractive.sdk.player.b bVar = (com.fyber.inneractive.sdk.player.b) aVar;
            com.fyber.inneractive.sdk.player.c cVar = bVar.a;
            if (cVar.m != null) {
                cVar.a(bitmap2);
                com.fyber.inneractive.sdk.player.c cVar2 = bVar.a;
                cVar2.l = null;
                cVar2.m = null;
            }
            IAlog.a("MediaPlayerController: fetching video frame success!", new Object[0]);
        } else {
            com.fyber.inneractive.sdk.player.b bVar2 = (com.fyber.inneractive.sdk.player.b) aVar;
            com.fyber.inneractive.sdk.player.c cVar3 = bVar2.a;
            if (cVar3.m != null) {
                cVar3.a((Bitmap) null);
                com.fyber.inneractive.sdk.player.c cVar4 = bVar2.a;
                cVar4.l = null;
                cVar4.m = null;
            }
            IAlog.a("MediaPlayerController: fetching video frame failed!", new Object[0]);
        }
        this.f1344b = null;
    }
}
