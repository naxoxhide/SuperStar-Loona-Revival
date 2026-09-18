package com.bytedance.sdk.openadsdk.b.m;

import com.bytedance.sdk.component.utils.p;
import com.bytedance.sdk.openadsdk.utils.y;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ContinueDownloadTask.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends b.b.a.a.k.g {
    private final List<? extends b.b.a.a.k.g> c;

    public b(String str, List<? extends b.b.a.a.k.g> list) {
        super(str);
        this.c = list;
    }

    @Override // java.lang.Runnable
    public void run() {
        List<? extends b.b.a.a.k.g> list;
        if (p.b(com.bytedance.sdk.openadsdk.core.o.a()) != 0 && (list = this.c) != null) {
            Iterator<? extends b.b.a.a.k.g> it = list.iterator();
            while (it.hasNext()) {
                y.b(it.next(), 1);
                it.remove();
            }
        }
        try {
            com.bytedance.sdk.component.utils.i.a().removeCallbacks(this);
        } catch (Exception unused) {
        }
    }
}
