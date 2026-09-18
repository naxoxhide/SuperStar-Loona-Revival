package com.tapjoy.internal;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public final class y4 {
    public final Context a;
    public CharSequence c;
    public CharSequence d;
    public PendingIntent e;
    public Bitmap f;
    public int g;
    public z4 i;
    public final String j;
    public final Notification k;
    public final ArrayList l;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f2833b = new ArrayList();
    public final boolean h = true;

    public y4(Context context, String str) {
        Notification notification = new Notification();
        this.k = notification;
        this.a = context;
        this.j = str;
        notification.when = System.currentTimeMillis();
        notification.audioStreamType = -1;
        this.g = 0;
        this.l = new ArrayList();
    }

    public final y4 a(x4 x4Var) {
        if (this.i != x4Var) {
            this.i = x4Var;
            if (x4Var.a != this) {
                x4Var.a = this;
                a(x4Var);
            }
        }
        return this;
    }
}
