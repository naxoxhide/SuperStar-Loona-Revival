package com.bytedance.sdk.openadsdk.c;

import com.bytedance.sdk.component.utils.m;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: TotalCountLruDiskFile.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f522b;
    private int c;
    private volatile boolean d;

    public b(int i, int i2) {
        this.f522b = 15;
        this.c = 3;
        if (i <= 0) {
            throw new IllegalArgumentException("Max count must be positive number!");
        }
        this.f522b = i;
        this.c = i2;
    }

    private void c(List<File> list) {
        long jA = a(list);
        int size = list.size();
        if (a(jA, size)) {
            return;
        }
        for (File file : list) {
            long length = file.length();
            if (file.delete()) {
                size--;
                jA -= length;
            }
            if (a(file, jA, size)) {
                return;
            }
        }
    }

    private void d(List<File> list) {
        if (list != null) {
            try {
                if (list.size() == 0) {
                    return;
                }
                long jA = a(list);
                int size = list.size();
                boolean zA = a(jA, size);
                if (zA) {
                    m.d("splashLoadAd", "Do not meet the delete condition, do not perform a delete operation(true)" + zA);
                    return;
                }
                TreeMap treeMap = new TreeMap();
                for (File file : list) {
                    treeMap.put(Long.valueOf(file.lastModified()), file);
                }
                for (Map.Entry entry : treeMap.entrySet()) {
                    if (entry != null && !zA) {
                        ((Long) entry.getKey()).longValue();
                        File file2 = (File) entry.getValue();
                        long length = file2.length();
                        if (file2.delete()) {
                            size--;
                            jA -= length;
                        }
                        if (a(file2, jA, size)) {
                            return;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    protected boolean a(long j, int i) {
        return i <= this.f522b;
    }

    @Override // com.bytedance.sdk.openadsdk.c.a
    protected void b(List<File> list) {
        if (!this.d) {
            c(list);
        } else {
            d(list);
            this.d = false;
        }
    }

    protected boolean a(File file, long j, int i) {
        return i <= this.c;
    }

    public b(int i, int i2, boolean z) {
        this.f522b = 15;
        this.c = 3;
        if (i > 0) {
            this.f522b = i;
            this.c = i2;
            this.d = z;
            return;
        }
        throw new IllegalArgumentException("Max count must be positive number!");
    }
}
