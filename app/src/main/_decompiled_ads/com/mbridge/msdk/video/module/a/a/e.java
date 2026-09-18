package com.mbridge.msdk.video.module.a.a;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.q;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.w;

/* JADX INFO: compiled from: DefaultImageLoaderListener.java */
/* JADX INFO: loaded from: classes4.dex */
public class e implements com.mbridge.msdk.foundation.same.c.c {
    private CampaignEx a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected ImageView f2545b;
    private String c;

    public e(ImageView imageView) {
        this.f2545b = imageView;
    }

    public e(ImageView imageView, CampaignEx campaignEx, String str) {
        this.f2545b = imageView;
        this.a = campaignEx;
        this.c = str;
    }

    @Override // com.mbridge.msdk.foundation.same.c.c
    public void onSuccessLoad(Bitmap bitmap, String str) {
        try {
            if (bitmap == null) {
                aa.d("ImageLoaderListener", "bitmap=null");
            } else {
                if (this.f2545b == null || bitmap.isRecycled()) {
                    return;
                }
                this.f2545b.setImageBitmap(bitmap);
                this.f2545b.setVisibility(0);
            }
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.mbridge.msdk.foundation.same.c.c
    public void onFailedLoad(final String str, String str2) {
        Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.video.module.a.a.e.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    q qVarA = q.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
                    if (e.this.a == null) {
                        aa.a("ImageLoaderListener", "campaign is null");
                        return;
                    }
                    com.mbridge.msdk.foundation.entity.n nVar = new com.mbridge.msdk.foundation.entity.n();
                    nVar.r("2000044");
                    nVar.d(w.r(com.mbridge.msdk.foundation.controller.b.d().g()));
                    nVar.q(e.this.a.getId());
                    nVar.d(e.this.a.getImageUrl());
                    nVar.m(e.this.a.getRequestId());
                    nVar.o(e.this.a.getRequestIdNotice());
                    nVar.p(e.this.c);
                    nVar.s(str);
                    qVarA.a(nVar);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        com.mbridge.msdk.foundation.controller.c.a();
        com.mbridge.msdk.foundation.same.f.b.a().execute(runnable);
        aa.d("ImageLoaderListener", "desc:" + str);
    }
}
