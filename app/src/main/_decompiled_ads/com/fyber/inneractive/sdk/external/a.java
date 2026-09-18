package com.fyber.inneractive.sdk.external;

import android.content.SharedPreferences;
import com.fyber.inneractive.sdk.util.q;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Thread.UncaughtExceptionHandler {
    public final /* synthetic */ SharedPreferences a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Thread.UncaughtExceptionHandler f915b;

    public a(SharedPreferences sharedPreferences, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.a = sharedPreferences;
        this.f915b = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        SharedPreferences sharedPreferences = this.a;
        String strA = q.a(th);
        if (strA.contains("com.fyber.inneractive")) {
            sharedPreferences.edit().putString("FyberExceptionKey", strA).putString("FyberVersionKey", InneractiveAdManager.getVersion()).putString("FyberNameKey", th.getClass().getName()).putString("FyberDescriptionKey", th.getLocalizedMessage()).commit();
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f915b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
