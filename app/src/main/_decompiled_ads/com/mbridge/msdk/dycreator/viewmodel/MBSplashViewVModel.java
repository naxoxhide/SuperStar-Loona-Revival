package com.mbridge.msdk.dycreator.viewmodel;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.dycreator.binding.response.SplashResData;
import com.mbridge.msdk.dycreator.bridge.MBSplashData;
import com.mbridge.msdk.dycreator.bus.EventBus;
import com.mbridge.msdk.dycreator.g.c;
import com.mbridge.msdk.dycreator.g.d;
import com.mbridge.msdk.dycreator.g.f;
import com.mbridge.msdk.dycreator.g.h;
import com.mbridge.msdk.dycreator.listener.action.EAction;
import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.dycreator.wrapper.DynamicViewBackListener;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.w;

/* JADX INFO: loaded from: classes4.dex */
public class MBSplashViewVModel implements BaseViewModel {
    private d a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f2011b;
    private f c;
    private h d;
    private DynamicViewBackListener e;
    private DyOption f;

    public MBSplashViewVModel(DyOption dyOption) {
        this.f = dyOption;
        String campaignUnitId = (dyOption == null || dyOption.getCampaignEx() == null) ? "" : dyOption.getCampaignEx().getCampaignUnitId();
        if (!TextUtils.isEmpty(campaignUnitId)) {
            EventBus.getDefault().register(campaignUnitId, this);
        } else {
            EventBus.getDefault().register(this);
        }
    }

    @Override // com.mbridge.msdk.dycreator.viewmodel.BaseViewModel
    public void setModelDataAndBind() {
        MBSplashData mBSplashData = new MBSplashData(this.f);
        Context contextG = b.d().g();
        if (contextG != null) {
            DyOption dyOption = this.f;
            if (dyOption != null) {
                CampaignEx campaignEx = dyOption.getCampaignEx();
                if (campaignEx != null) {
                    mBSplashData.setAdClickText(campaignEx.getAdCall());
                }
                mBSplashData.setCountDownText(contextG.getResources().getString(t.a(contextG, this.f.isCanSkip() ? "mbridge_splash_count_time_can_skip" : "mbridge_splash_count_time_can_skip_not", "string")));
            }
            mBSplashData.setNoticeImage(t.a(contextG, "mbridge_splash_notice", "drawable"));
            String strG = w.g(contextG);
            mBSplashData.setLogoText((TextUtils.isEmpty(strG) || !strG.contains("zh")) ? "AD" : "广告");
        }
        d dVar = this.a;
        if (dVar != null) {
            dVar.a(mBSplashData);
        }
        c cVar = this.f2011b;
        if (cVar != null) {
            cVar.a(mBSplashData);
        }
        f fVar = this.c;
        if (fVar != null) {
            fVar.a(mBSplashData);
        }
    }

    @Override // com.mbridge.msdk.dycreator.viewmodel.BaseViewModel
    public void setDynamicViewBackListener(DynamicViewBackListener dynamicViewBackListener) {
        if (dynamicViewBackListener != null) {
            this.e = dynamicViewBackListener;
        }
    }

    @Override // com.mbridge.msdk.dycreator.viewmodel.BaseViewModel
    public void setClickSubject(c cVar) {
        if (cVar != null) {
            this.f2011b = cVar;
        }
    }

    @Override // com.mbridge.msdk.dycreator.viewmodel.BaseViewModel
    public void setConcreteSubject(d dVar) {
        if (dVar != null) {
            this.a = dVar;
        }
    }

    @Override // com.mbridge.msdk.dycreator.viewmodel.BaseViewModel
    public void setEffectSubject(f fVar) {
        if (fVar != null) {
            this.c = fVar;
        }
    }

    @Override // com.mbridge.msdk.dycreator.viewmodel.BaseViewModel
    public void setReportSubject(h hVar) {
        if (hVar != null) {
            this.d = hVar;
        }
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.dycreator.viewmodel.MBSplashViewVModel$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EAction.values().length];
            a = iArr;
            try {
                iArr[EAction.DOWNLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EAction.CLOSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public void onEventMainThread(SplashResData splashResData) {
        if (this.e == null || splashResData == null) {
            return;
        }
        int i = AnonymousClass1.a[splashResData.geteAction().ordinal()];
        if (i == 1 || i == 2) {
            try {
                String campaignUnitId = "";
                if (splashResData.getBaseViewData() != null && splashResData.getBaseViewData().getBindData() != null) {
                    campaignUnitId = splashResData.getBaseViewData().getBindData().getCampaignUnitId();
                }
                if (!TextUtils.isEmpty(campaignUnitId)) {
                    EventBus.getDefault().unregister(campaignUnitId);
                    com.mbridge.msdk.dycreator.binding.b.a().b();
                } else {
                    EventBus.getDefault().unregister(this);
                    com.mbridge.msdk.dycreator.binding.b.a().b();
                }
            } catch (Exception e) {
                e.printStackTrace();
                EventBus.getDefault().unregister(this);
                EventBus.getDefault().release();
                com.mbridge.msdk.dycreator.binding.b.a().b();
            }
        }
        this.e.viewClicked(splashResData);
    }
}
