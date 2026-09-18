package com.mbridge.msdk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.mbridge.msdk.c.c;
import com.mbridge.msdk.c.d;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.out.Campaign;

/* JADX INFO: loaded from: classes4.dex */
public class MBAdChoice extends MBImageView {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2676b;
    private String c;
    private final Context d;
    private CampaignEx e;
    private com.mbridge.msdk.foundation.c.a f;

    public MBAdChoice(Context context) {
        super(context);
        this.a = "";
        this.f2676b = "";
        this.c = "";
        this.d = context;
        a();
    }

    public MBAdChoice(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = "";
        this.f2676b = "";
        this.c = "";
        this.d = context;
        a();
    }

    public MBAdChoice(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = "";
        this.f2676b = "";
        this.c = "";
        this.d = context;
        a();
    }

    private void a() {
        setScaleType(ImageView.ScaleType.FIT_CENTER);
        setClickable(true);
    }

    public void setCampaign(Campaign campaign) {
        if (campaign instanceof CampaignEx) {
            CampaignEx campaignEx = (CampaignEx) campaign;
            this.e = campaignEx;
            this.e = campaignEx;
            c cVarB = d.a().b(b.d().h());
            this.e = campaignEx;
            if (campaignEx != null) {
                String privacyUrl = campaignEx.getPrivacyUrl();
                this.c = privacyUrl;
                if (TextUtils.isEmpty(privacyUrl)) {
                    CampaignEx.a adchoice = campaignEx.getAdchoice();
                    if (adchoice != null) {
                        this.c = adchoice.d();
                    }
                    if (TextUtils.isEmpty(this.c) && cVarB != null) {
                        this.c = cVarB.al();
                    }
                    if (TextUtils.isEmpty(this.c)) {
                        this.c = com.mbridge.msdk.foundation.same.net.f.d.a().j;
                    }
                }
            } else if (cVarB != null) {
                this.c = cVarB.al();
            }
            this.e = campaignEx;
            if (campaignEx != null) {
                CampaignEx.a adchoice2 = campaignEx.getAdchoice();
                if (adchoice2 != null) {
                    this.a = adchoice2.e();
                }
                if (TextUtils.isEmpty(this.a) && cVarB != null) {
                    this.a = cVarB.aj();
                }
            } else if (cVarB != null) {
                this.a = cVarB.aj();
            }
            this.e = campaignEx;
            if (campaignEx != null) {
                CampaignEx.a adchoice3 = campaignEx.getAdchoice();
                if (adchoice3 != null) {
                    this.f2676b = adchoice3.f();
                }
                if (TextUtils.isEmpty(this.f2676b) && cVarB != null) {
                    this.f2676b = cVarB.ak();
                }
            } else if (cVarB != null) {
                this.f2676b = cVarB.ak();
            }
            boolean z = (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.f2676b)) ? false : true;
            setImageUrl(this.a);
            if (!z || this.d == null) {
                return;
            }
            com.mbridge.msdk.foundation.same.c.b.a(b.d().g()).a(this.a, new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.widget.MBAdChoice.1
                @Override // com.mbridge.msdk.foundation.same.c.c
                public final void onFailedLoad(String str, String str2) {
                }

                @Override // com.mbridge.msdk.foundation.same.c.c
                public final void onSuccessLoad(Bitmap bitmap, String str) {
                    MBAdChoice.this.setImageBitmap(bitmap);
                }
            });
            return;
        }
        this.e = null;
    }

    public void setFeedbackDialogEventListener(com.mbridge.msdk.foundation.c.a aVar) {
        this.f = aVar;
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.f == null) {
            this.f = new com.mbridge.msdk.foundation.c.a() { // from class: com.mbridge.msdk.widget.MBAdChoice.2
                @Override // com.mbridge.msdk.foundation.c.a
                public final void a() {
                }

                @Override // com.mbridge.msdk.foundation.c.a
                public final void a(String str) {
                }

                @Override // com.mbridge.msdk.foundation.c.a
                public final void b() {
                }
            };
        }
        af.a(this.e, this.f, 4, "");
        return true;
    }
}
