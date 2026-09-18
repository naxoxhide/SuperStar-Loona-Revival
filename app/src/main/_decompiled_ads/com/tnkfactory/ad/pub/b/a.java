package com.tnkfactory.ad.pub.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tnkfactory.ad.pub.a.u;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f2901b;

    /* JADX INFO: renamed from: com.tnkfactory.ad.pub.b.a$a, reason: collision with other inner class name */
    public static class HandlerC0532a extends Handler {
        public r a;

        public HandlerC0532a(r rVar) {
            super(Looper.getMainLooper());
            this.a = rVar;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                Object obj = message.obj;
                if (message.what == 1) {
                    if (obj instanceof Throwable) {
                        this.a.a((Throwable) obj);
                    } else {
                        this.a.a(obj);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        this(context, u.a("ce6c1586fa0bde24e06f2a5730f234b4c4d4060d6b44cc915f19b67a"));
        Map<String, String> map = u.a;
    }

    public a(Context context, String str) {
        this.f2901b = context;
        this.a = str;
    }
}
