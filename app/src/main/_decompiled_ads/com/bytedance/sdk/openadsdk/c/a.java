package com.bytedance.sdk.openadsdk.c;

import com.bytedance.sdk.component.utils.g;
import com.bytedance.sdk.component.utils.m;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: LruDiskFile.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    private final ExecutorService a = Executors.newSingleThreadExecutor();

    /* JADX INFO: compiled from: LruDiskFile.java */
    private class b implements Callable<Void> {
        private final File a;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            a.this.b(this.a);
            return null;
        }

        private b(File file) {
            this.a = file;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(File file) throws IOException {
        try {
            g.f(file);
        } catch (Throwable th) {
            m.a("LruDiskFile", "setLastModifiedNowError", th);
        }
        b(g.b(file.getParentFile()));
    }

    protected abstract void b(List<File> list);

    public void a(File file) throws IOException {
        this.a.submit(new b(file));
    }

    long a(List<File> list) {
        Iterator<File> it = list.iterator();
        long length = 0;
        while (it.hasNext()) {
            length += it.next().length();
        }
        return length;
    }
}
