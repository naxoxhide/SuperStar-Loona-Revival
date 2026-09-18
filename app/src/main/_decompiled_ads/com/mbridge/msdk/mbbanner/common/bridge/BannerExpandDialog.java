package com.mbridge.msdk.mbbanner.common.bridge;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.ads.AdError;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.mbsignalcommon.mraid.b;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.widget.MBAdChoice;
import com.tapjoy.TJAdUnitConstants;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class BannerExpandDialog extends Dialog {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2256b;
    private boolean c;
    private FrameLayout d;
    private WindVaneWebView e;
    private TextView f;
    private String g;
    private List<CampaignEx> h;
    private com.mbridge.msdk.mbbanner.common.b.a i;
    private b j;

    public BannerExpandDialog(Context context, Bundle bundle, com.mbridge.msdk.mbbanner.common.b.a aVar) {
        super(context);
        this.a = "BannerExpandDialog";
        this.j = new b() { // from class: com.mbridge.msdk.mbbanner.common.bridge.BannerExpandDialog.5
            @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
            public final void expand(String str, boolean z) {
            }

            @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
            public final CampaignEx getMraidCampaign() {
                return null;
            }

            @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
            public final void open(String str) {
                try {
                    if (BannerExpandDialog.this.e == null || System.currentTimeMillis() - BannerExpandDialog.this.e.lastTouchTime <= com.mbridge.msdk.click.b.a.c || !com.mbridge.msdk.click.b.a.a((CampaignEx) BannerExpandDialog.this.h.get(0), BannerExpandDialog.this.e.getUrl(), com.mbridge.msdk.click.b.a.a)) {
                        aa.d("BannerExpandDialog", str);
                        if (BannerExpandDialog.this.h.size() > 1) {
                            com.mbridge.msdk.foundation.controller.b.d().g().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                            str = null;
                        }
                        if (BannerExpandDialog.this.i != null) {
                            BannerExpandDialog.this.i.a(true, str);
                        }
                    }
                } catch (Throwable th) {
                    aa.b("BannerExpandDialog", "open", th);
                }
            }

            @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
            public final void close() {
                BannerExpandDialog.this.dismiss();
            }

            @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
            public final void unload() {
                close();
            }

            @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
            public final void useCustomClose(boolean z) {
                try {
                    BannerExpandDialog.this.f.setVisibility(z ? 4 : 0);
                } catch (Throwable th) {
                    aa.b("BannerExpandDialog", "useCustomClose", th);
                }
            }
        };
        if (bundle != null) {
            this.f2256b = bundle.getString("url");
            this.c = bundle.getBoolean("shouldUseCustomClose");
        }
        this.i = aVar;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        CampaignEx campaignEx;
        super.onCreate(bundle);
        requestWindowFeature(1);
        setCanceledOnTouchOutside(false);
        setCancelable(true);
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.d = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        WindVaneWebView windVaneWebView = new WindVaneWebView(getContext().getApplicationContext());
        this.e = windVaneWebView;
        windVaneWebView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.d.addView(this.e);
        TextView textView = new TextView(getContext());
        this.f = textView;
        textView.setBackgroundColor(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(96, 96);
        layoutParams.gravity = 8388661;
        layoutParams.setMargins(30, 30, 30, 30);
        this.f.setLayoutParams(layoutParams);
        this.f.setVisibility(this.c ? 4 : 0);
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.mbbanner.common.bridge.BannerExpandDialog.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BannerExpandDialog.this.dismiss();
            }
        });
        BitmapDrawable bitmapDrawableA = com.mbridge.msdk.foundation.controller.b.d().a(this.g, 296);
        if (bitmapDrawableA != null) {
            ImageView imageView = new ImageView(com.mbridge.msdk.foundation.controller.b.d().g());
            af.a(imageView, bitmapDrawableA, this.d.getResources().getDisplayMetrics());
            this.d.addView(imageView, new ViewGroup.LayoutParams(-1, -1));
        }
        this.d.addView(this.f);
        setContentView(this.d);
        a();
        this.e.setWebViewListener(new com.mbridge.msdk.mbsignalcommon.b.b() { // from class: com.mbridge.msdk.mbbanner.common.bridge.BannerExpandDialog.2
            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
            public final void a(WebView webView, String str) {
                super.a(webView, str);
                StringBuilder sb = new StringBuilder("javascript:");
                sb.append(com.mbridge.msdk.c.b.a.a().b());
                if (Build.VERSION.SDK_INT <= 19) {
                    webView.loadUrl(sb.toString());
                } else {
                    webView.evaluateJavascript(sb.toString(), new ValueCallback<String>() { // from class: com.mbridge.msdk.mbbanner.common.bridge.BannerExpandDialog.2.1
                        @Override // android.webkit.ValueCallback
                        public final /* bridge */ /* synthetic */ void onReceiveValue(String str2) {
                        }
                    });
                }
                BannerExpandDialog.a(BannerExpandDialog.this);
            }
        });
        this.e.setObject(this.j);
        this.e.loadUrl(this.f2256b);
        List<CampaignEx> list = this.h;
        if (list != null && list.size() > 0 && (campaignEx = this.h.get(0)) != null && campaignEx.getPrivacyButtonTemplateVisibility() != 0) {
            MBAdChoice mBAdChoice = new MBAdChoice(com.mbridge.msdk.foundation.controller.b.d().g());
            mBAdChoice.setCampaign(campaignEx);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(af.b(com.mbridge.msdk.foundation.controller.b.d().g(), 12.0f), af.b(com.mbridge.msdk.foundation.controller.b.d().g(), 12.0f));
            layoutParams2.gravity = 85;
            layoutParams2.bottomMargin = layoutParams.topMargin;
            layoutParams2.rightMargin = layoutParams.rightMargin;
            mBAdChoice.setFeedbackDialogEventListener(new com.mbridge.msdk.foundation.c.a() { // from class: com.mbridge.msdk.mbbanner.common.bridge.BannerExpandDialog.3
                @Override // com.mbridge.msdk.foundation.c.a
                public final void a() {
                }

                @Override // com.mbridge.msdk.foundation.c.a
                public final void b() {
                    BannerExpandDialog.this.a();
                }

                @Override // com.mbridge.msdk.foundation.c.a
                public final void a(String str) {
                    BannerExpandDialog.this.a();
                }
            });
            this.d.addView(mBAdChoice, layoutParams2);
        }
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.mbridge.msdk.mbbanner.common.bridge.BannerExpandDialog.4
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                if (BannerExpandDialog.this.i != null) {
                    BannerExpandDialog.this.i.a(false);
                }
                BannerExpandDialog.this.e.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
                BannerExpandDialog.this.d.removeView(BannerExpandDialog.this.e);
                BannerExpandDialog.this.e.release();
                BannerExpandDialog.this.e = null;
                BannerExpandDialog.this.i = null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (getWindow() != null) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            getWindow().setAttributes(attributes);
            if (Build.VERSION.SDK_INT >= 16) {
                getWindow().getDecorView().setSystemUiVisibility(Build.VERSION.SDK_INT >= 19 ? 4615 : 519);
            }
        }
    }

    public void setCampaignList(String str, List<CampaignEx> list) {
        this.g = str;
        this.h = list;
    }

    static /* synthetic */ void a(BannerExpandDialog bannerExpandDialog) {
        String str;
        try {
            int i = com.mbridge.msdk.foundation.controller.b.d().g().getResources().getConfiguration().orientation;
            JSONObject jSONObject = new JSONObject();
            if (i == 2) {
                str = TJAdUnitConstants.String.LANDSCAPE;
            } else {
                str = i == 1 ? TJAdUnitConstants.String.PORTRAIT : AdError.UNDEFINED_DOMAIN;
            }
            jSONObject.put("orientation", str);
            jSONObject.put("locked", "true");
            float fL = w.l(com.mbridge.msdk.foundation.controller.b.d().g());
            float fM = w.m(com.mbridge.msdk.foundation.controller.b.d().g());
            HashMap mapN = w.n(com.mbridge.msdk.foundation.controller.b.d().g());
            int iIntValue = ((Integer) mapN.get("width")).intValue();
            int iIntValue2 = ((Integer) mapN.get("height")).intValue();
            HashMap map = new HashMap();
            map.put("placementType", "Interstitial");
            map.put("state", "expanded");
            map.put("viewable", "true");
            map.put("currentAppOrientation", jSONObject);
            int[] iArr = new int[2];
            bannerExpandDialog.e.getLocationInWindow(iArr);
            com.mbridge.msdk.mbsignalcommon.mraid.a aVarA = com.mbridge.msdk.mbsignalcommon.mraid.a.a();
            WindVaneWebView windVaneWebView = bannerExpandDialog.e;
            aVarA.a(windVaneWebView, iArr[0], iArr[1], windVaneWebView.getWidth(), bannerExpandDialog.e.getHeight());
            com.mbridge.msdk.mbsignalcommon.mraid.a aVarA2 = com.mbridge.msdk.mbsignalcommon.mraid.a.a();
            WindVaneWebView windVaneWebView2 = bannerExpandDialog.e;
            aVarA2.b(windVaneWebView2, iArr[0], iArr[1], windVaneWebView2.getWidth(), bannerExpandDialog.e.getHeight());
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(bannerExpandDialog.e, fL, fM);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().c(bannerExpandDialog.e, iIntValue, iIntValue2);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(bannerExpandDialog.e, map);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(bannerExpandDialog.e);
        } catch (Throwable th) {
            aa.b("BannerExpandDialog", "notifyMraid", th);
        }
    }
}
