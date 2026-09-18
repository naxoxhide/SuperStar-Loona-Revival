package com.tnkfactory.ad.pub.a;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/* JADX INFO: loaded from: classes4.dex */
public final class i1 implements Runnable {
    public final /* synthetic */ com.tnkfactory.ad.pub.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f2869b;
    public final /* synthetic */ ImageView c;

    public class a implements Runnable {
        public final /* synthetic */ Drawable a;

        public a(Drawable drawable) {
            this.a = drawable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            i1.this.c.setImageDrawable(this.a);
        }
    }

    public i1(com.tnkfactory.ad.pub.a aVar, int i, ImageView imageView) {
        this.a = aVar;
        this.f2869b = i;
        this.c = imageView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (TextUtils.isEmpty(this.a.h0.get(this.f2869b).icon_url)) {
                return;
            }
            this.c.post(new a(Drawable.createFromStream((InputStream) new URL(this.a.h0.get(this.f2869b).icon_url).getContent(), "src")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
