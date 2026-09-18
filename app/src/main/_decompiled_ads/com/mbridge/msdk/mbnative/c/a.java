package com.mbridge.msdk.mbnative.c;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.out.NativeListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: AdListenerProxy.java */
/* JADX INFO: loaded from: classes4.dex */
public class a implements NativeListener.NativeAdListener {
    private static final String a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private NativeListener.NativeAdListener f2288b;
    private boolean c = false;
    private String d;
    private Context e;
    private boolean f;

    public final void a(boolean z) {
        this.f = z;
    }

    public final boolean a() {
        return this.f;
    }

    public final void a(String str) {
        this.d = str;
    }

    public a() {
    }

    public a(NativeListener.NativeAdListener nativeAdListener) {
        this.f2288b = nativeAdListener;
    }

    public final boolean b() {
        return this.c;
    }

    public final void c() {
        this.c = true;
    }

    @Override // com.mbridge.msdk.out.NativeListener.NativeAdListener
    public void onAdLoaded(List<Campaign> list, int i) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        try {
            this.c = false;
            synchronized (list) {
                copyOnWriteArrayList = new CopyOnWriteArrayList(list);
            }
            if (this.f2288b != null) {
                if (copyOnWriteArrayList.size() > 0) {
                    this.f2288b.onAdLoaded(copyOnWriteArrayList, i);
                } else {
                    this.f2288b.onAdLoaded(list, i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(CampaignEx campaignEx, String str) {
        this.c = false;
        NativeListener.NativeAdListener nativeAdListener = this.f2288b;
        if (nativeAdListener != null) {
            nativeAdListener.onAdLoadError(str);
            if (this.e == null) {
                this.e = b.d().g();
            }
            if (TextUtils.isEmpty(this.d)) {
                return;
            }
            com.mbridge.msdk.mbnative.d.a.a(this.e, str, this.d, this.f, campaignEx);
        }
    }

    @Override // com.mbridge.msdk.out.NativeListener.NativeAdListener
    public void onAdLoadError(String str) {
        this.c = false;
        NativeListener.NativeAdListener nativeAdListener = this.f2288b;
        if (nativeAdListener != null) {
            nativeAdListener.onAdLoadError(str);
            if (this.e == null) {
                this.e = b.d().g();
            }
            if (TextUtils.isEmpty(this.d)) {
                return;
            }
            com.mbridge.msdk.mbnative.d.a.a(this.e, str, this.d, this.f, null);
        }
    }

    @Override // com.mbridge.msdk.out.NativeListener.NativeAdListener
    public void onAdClick(Campaign campaign) {
        NativeListener.NativeAdListener nativeAdListener = this.f2288b;
        if (nativeAdListener != null) {
            nativeAdListener.onAdClick(campaign);
        }
    }

    @Override // com.mbridge.msdk.out.NativeListener.NativeAdListener
    public void onAdFramesLoaded(List<Frame> list) {
        NativeListener.NativeAdListener nativeAdListener = this.f2288b;
        if (nativeAdListener != null) {
            nativeAdListener.onAdFramesLoaded(list);
        }
    }

    @Override // com.mbridge.msdk.out.NativeListener.NativeAdListener
    public void onLoggingImpression(int i) {
        NativeListener.NativeAdListener nativeAdListener = this.f2288b;
        if (nativeAdListener != null) {
            nativeAdListener.onLoggingImpression(i);
        }
    }
}
