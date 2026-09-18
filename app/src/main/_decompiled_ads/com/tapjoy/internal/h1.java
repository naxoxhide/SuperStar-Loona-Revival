package com.tapjoy.internal;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/* JADX INFO: loaded from: classes4.dex */
public final class h1 implements Runnable {
    public final /* synthetic */ URL a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InputStream f2762b;
    public final /* synthetic */ long c;
    public final /* synthetic */ j1 d;

    public h1(j1 j1Var, URL url, ByteArrayInputStream byteArrayInputStream, long j) {
        this.d = j1Var;
        this.a = url;
        this.f2762b = byteArrayInputStream;
        this.c = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            j1 j1Var = this.d;
            File file = j1Var.d;
            if (file == null) {
                file = new File(j1Var.a.getCacheDir(), "tapjoy_mm_cache");
                j1Var.d = file;
            }
            if (!file.isDirectory()) {
                file.delete();
            }
            if (!file.exists()) {
                file.mkdirs();
            }
            File fileCreateTempFile = File.createTempFile("tj_", null, file);
            if (fileCreateTempFile == null) {
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            InputStream inputStream = this.f2762b;
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    break;
                } else {
                    fileOutputStream.write(bArr, 0, i);
                }
            }
            fileOutputStream.close();
            long j = this.c;
            if (j > 604800) {
                j = 604800;
            }
            long jA = (j * 1000) + na.a();
            synchronized (this.d) {
                String strA = this.d.a(this.a);
                j1 j1Var2 = this.d;
                j1Var2.getClass();
                File file2 = j1Var2.d;
                if (file2 == null) {
                    file2 = new File(j1Var2.a.getCacheDir(), "tapjoy_mm_cache");
                    j1Var2.d = file2;
                }
                if (!file2.isDirectory()) {
                    file2.delete();
                }
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (fileCreateTempFile.renameTo(new File(file2, strA))) {
                    this.d.f2772b.edit().putLong(strA, jA).commit();
                }
            }
        } catch (FileNotFoundException | IOException unused) {
        }
    }
}
