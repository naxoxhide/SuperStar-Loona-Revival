package com.bytedance.sdk.openadsdk.n.d;

import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import b.b.a.a.h.h;
import b.b.a.a.h.k;
import b.b.a.a.h.o;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.h.d;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Map;

/* JADX INFO: compiled from: GifLoader.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.n.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: GifLoader.java */
    class C0248a implements o {
        final /* synthetic */ c a;

        C0248a(c cVar) {
            this.a = cVar;
        }

        @Override // b.b.a.a.h.o
        public void a(k kVar) {
            a.this.a(kVar, this.a);
        }

        @Override // b.b.a.a.h.o
        public void a(int i, String str, Throwable th) {
            a.this.a(i, str, th, this.a);
        }
    }

    /* JADX INFO: compiled from: GifLoader.java */
    class b implements h {
        final /* synthetic */ int a;

        b(a aVar, int i) {
            this.a = i;
        }

        @Override // b.b.a.a.h.h
        public Bitmap a(Bitmap bitmap) {
            if (this.a <= 0) {
                return bitmap;
            }
            if (Build.VERSION.SDK_INT >= 17) {
                return b.b.a.a.d.g.a.a(com.bytedance.sdk.openadsdk.core.o.a(), bitmap, this.a);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: GifLoader.java */
    public interface c {
        void a();

        void a(int i, String str, Throwable th);

        void a(String str, com.bytedance.sdk.openadsdk.n.d.b bVar);
    }

    protected void a() {
        throw null;
    }

    public void a(com.bytedance.sdk.openadsdk.n.a aVar, c cVar, int i, int i2, ImageView.ScaleType scaleType, String str, int i3, q qVar) {
        d.a(aVar.a).a(aVar.f806b).b(i).a(i2).d(b0.g(com.bytedance.sdk.openadsdk.core.o.a())).c(b0.i(com.bytedance.sdk.openadsdk.core.o.a())).b(str).a(Bitmap.Config.RGB_565).a(scaleType).a(!TextUtils.isEmpty(str)).a(new b(this, i3)).a(new com.bytedance.sdk.openadsdk.h.b(qVar, aVar.a, new C0248a(cVar)));
        a();
    }

    protected void a(k kVar, c cVar) {
        if (cVar != null) {
            Object objC = kVar.c();
            int iA = a(kVar);
            if (objC instanceof byte[]) {
                cVar.a(kVar.a(), new com.bytedance.sdk.openadsdk.n.d.b((byte[]) objC, iA));
            } else {
                if (objC instanceof Bitmap) {
                    cVar.a(kVar.a(), new com.bytedance.sdk.openadsdk.n.d.b((Bitmap) objC, kVar.e() instanceof Bitmap ? (Bitmap) kVar.e() : null, iA));
                } else {
                    cVar.a(0, "not bitmap or gif result!", null);
                }
            }
        }
        if (cVar != null) {
            cVar.a();
        }
    }

    private int a(k kVar) {
        Object obj;
        Map<String, String> mapB = kVar.b();
        if (mapB == null || (obj = mapB.get(CampaignEx.JSON_KEY_IMAGE_SIZE)) == null || !(obj instanceof Integer)) {
            return 0;
        }
        return ((Integer) obj).intValue();
    }

    protected void a(int i, String str, Throwable th, c cVar) {
        if (cVar != null) {
            cVar.a(i, str, th);
        }
    }
}
