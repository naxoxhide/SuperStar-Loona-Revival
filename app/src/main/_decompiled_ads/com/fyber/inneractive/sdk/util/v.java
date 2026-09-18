package com.fyber.inneractive.sdk.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class v {
    public List<b> a = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1349b;
    public Context c;
    public BroadcastReceiver d;

    public static class a {
        public static v a = new v();
    }

    public interface b {
        void c(boolean z);
    }
}
