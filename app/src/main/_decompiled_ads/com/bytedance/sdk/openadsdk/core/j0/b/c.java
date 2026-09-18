package com.bytedance.sdk.openadsdk.core.j0.b;

import com.bytedance.sdk.component.utils.g;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: TotalCountLruDiskDir.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends com.bytedance.sdk.openadsdk.c.b {
    public c(int i, int i2) {
        super(i, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.c.b, com.bytedance.sdk.openadsdk.c.a
    protected void b(List<File> list) {
        int size = list.size();
        if (a(0L, size)) {
            return;
        }
        for (File file : list) {
            g.a(file);
            size--;
            if (a(file, 0L, size)) {
                return;
            }
        }
    }
}
