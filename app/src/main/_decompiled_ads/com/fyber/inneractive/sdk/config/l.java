package com.fyber.inneractive.sdk.config;

import android.content.Context;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class l implements v {
    public Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f887b = new c();

    public static class b {
        public static l a = new l();
    }

    public static class c implements Serializable {
        public static final long serialVersionUID = 2;
        public String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f888b;
        public boolean c;

        public c() {
        }
    }

    public static String a() {
        c cVar = b.a.f887b;
        if (cVar != null) {
            return cVar.a;
        }
        return null;
    }

    public static boolean b() {
        c cVar = b.a.f887b;
        if (cVar != null) {
            return cVar.c;
        }
        return false;
    }

    public static boolean c() {
        c cVar = b.a.f887b;
        if (cVar != null) {
            return cVar.f888b;
        }
        return false;
    }
}
