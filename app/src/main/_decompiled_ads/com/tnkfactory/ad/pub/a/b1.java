package com.tnkfactory.ad.pub.a;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tnkfactory.ad.pub.model.Vdo_iconsVO;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/* JADX INFO: loaded from: classes4.dex */
public final class b1 implements Runnable {
    public final /* synthetic */ Vdo_iconsVO a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageView f2863b;

    public class a implements Runnable {
        public final /* synthetic */ Drawable a;

        public a(Drawable drawable) {
            this.a = drawable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b1.this.f2863b.setImageDrawable(this.a);
        }
    }

    public b1(Vdo_iconsVO vdo_iconsVO, ImageView imageView) {
        this.a = vdo_iconsVO;
        this.f2863b = imageView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (TextUtils.isEmpty(this.a.icon_url)) {
                return;
            }
            this.f2863b.post(new a(Drawable.createFromStream((InputStream) new URL(this.a.icon_url).getContent(), "src")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
