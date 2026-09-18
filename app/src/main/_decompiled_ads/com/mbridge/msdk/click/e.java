package com.mbridge.msdk.click;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.scheme.applet.AppletSchemeCallBack;
import com.mbridge.msdk.scheme.applet.AppletsModel;

/* JADX INFO: compiled from: DefaultAppletSchemeCallBack.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e extends AppletSchemeCallBack {
    private final NativeListener.NativeTrackingListener a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CampaignEx f1932b;
    private final AppletsModel c;
    private final a d;

    @Override // com.mbridge.msdk.scheme.applet.AppletSchemeCallBack
    protected final void onRequestStart() {
    }

    public e(NativeListener.NativeTrackingListener nativeTrackingListener, CampaignEx campaignEx, AppletsModel appletsModel, a aVar) {
        this.a = nativeTrackingListener;
        this.f1932b = campaignEx;
        this.c = appletsModel;
        this.d = aVar;
    }

    @Override // com.mbridge.msdk.scheme.applet.AppletSchemeCallBack
    protected final void onRequestSuccess(String str) {
        CampaignEx campaignEx = this.f1932b;
        if (campaignEx == null || this.c == null) {
            return;
        }
        try {
            NativeListener.NativeTrackingListener nativeTrackingListener = this.a;
            if (nativeTrackingListener != null) {
                try {
                    nativeTrackingListener.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        aa.d("DefaultAppletSchemeCallBack", e.getMessage());
                    }
                }
            }
            this.c.setUserClick(false);
            this.c.setRequestingFinish();
            this.f1932b.setDeepLinkUrl(str);
            a aVar = this.d;
            if (aVar != null) {
                try {
                    aVar.a(this.f1932b);
                } catch (Exception e2) {
                    if (MBridgeConstans.DEBUG) {
                        aa.d("DefaultAppletSchemeCallBack", e2.getMessage());
                    }
                }
            }
        } catch (Exception e3) {
            if (MBridgeConstans.DEBUG) {
                aa.d("DefaultAppletSchemeCallBack", e3.getMessage());
            }
        }
    }

    @Override // com.mbridge.msdk.scheme.applet.AppletSchemeCallBack
    protected final void onRequestFailed(int i, String str, String str2) {
        CampaignEx campaignEx = this.f1932b;
        if (campaignEx == null || this.c == null) {
            return;
        }
        try {
            NativeListener.NativeTrackingListener nativeTrackingListener = this.a;
            if (nativeTrackingListener != null) {
                try {
                    nativeTrackingListener.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        aa.d("DefaultAppletSchemeCallBack", e.getMessage());
                    }
                }
            }
            this.c.setUserClick(false);
            this.c.setRequestingFinish();
            this.f1932b.setClickURL(str2);
            a aVar = this.d;
            if (aVar != null) {
                try {
                    aVar.a(this.f1932b);
                } catch (Exception e2) {
                    if (MBridgeConstans.DEBUG) {
                        aa.d("DefaultAppletSchemeCallBack", e2.getMessage());
                    }
                }
            }
        } catch (Exception e3) {
            if (MBridgeConstans.DEBUG) {
                aa.d("DefaultAppletSchemeCallBack", e3.getMessage());
            }
        }
    }
}
