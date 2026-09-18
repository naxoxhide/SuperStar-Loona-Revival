package com.bytedance.sdk.openadsdk.dislike;

import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import java.util.List;

/* JADX INFO: compiled from: DislikeDispatcher.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f765b;
    private final p<com.bytedance.sdk.openadsdk.d.a> a = o.c();

    private a() {
    }

    public static a a() {
        if (f765b == null) {
            synchronized (a.class) {
                if (f765b == null) {
                    f765b = new a();
                }
            }
        }
        return f765b;
    }

    public void a(String str, List<FilterWord> list) {
        this.a.a(str, list);
    }
}
