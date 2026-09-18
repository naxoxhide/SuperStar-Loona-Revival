package com.mbridge.msdk.splash.c;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.mbridge.msdk.dycreator.binding.response.SplashResData;
import com.mbridge.msdk.dycreator.binding.response.base.BaseRespData;
import com.mbridge.msdk.dycreator.bridge.MBSplashData;
import com.mbridge.msdk.dycreator.listener.DyCountDownListener;
import com.mbridge.msdk.dycreator.listener.action.EAction;
import com.mbridge.msdk.dycreator.wrapper.DyAdType;
import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.dycreator.wrapper.DynamicViewBackListener;
import com.mbridge.msdk.dycreator.wrapper.DynamicViewCreator;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.k;
import com.mbridge.msdk.splash.view.MBSplashNativeView;
import com.mbridge.msdk.splash.view.MBSplashView;
import java.util.ArrayList;

/* JADX INFO: compiled from: NativeViewRenderManager.java */
/* JADX INFO: loaded from: classes4.dex */
final class a {
    private a() {
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.splash.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: NativeViewRenderManager.java */
    static class C0511a {
        private static final a a = new a();
    }

    public final void a(final MBSplashView mBSplashView, final com.mbridge.msdk.splash.a.c cVar, final com.mbridge.msdk.splash.b.a aVar) {
        Context context = mBSplashView.getContext();
        if (context == null) {
            context = com.mbridge.msdk.foundation.controller.b.d().g();
        }
        if (cVar == null && aVar != null) {
            aVar.a("The render parameters is unavailable.");
            return;
        }
        String strA = (cVar == null || cVar.c() == null) ? "" : k.a(cVar.c().getAdZip());
        if (!TextUtils.isEmpty(strA)) {
            if (cVar == null || cVar.c() == null) {
                return;
            }
            if (!TextUtils.isEmpty(cVar.c().getAdZip())) {
                try {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(strA);
                    com.mbridge.msdk.c.d.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
                    final DyOption dyOptionBuild = new DyOption.Builder().campaignEx(cVar.c()).fileDirs(arrayList).dyAdType(DyAdType.SPLASH).canSkip(cVar.d()).isScreenClick(cVar.g() == 1).isClickButtonVisible(cVar.f() == 0).isShakeVisible(cVar.i() == 1).isApkInfoVisible(cVar.h() == 0).isLogoVisible(cVar.m() == 1).shakeStrenght(cVar.j()).shakeTime(cVar.k()).orientation(cVar.l()).countDownTime(cVar.e()).adChoiceLink(af.c(cVar.c())).build();
                    mBSplashView.setDyCountDownListener(new DyCountDownListener() { // from class: com.mbridge.msdk.splash.c.a.1
                        @Override // com.mbridge.msdk.dycreator.listener.DyCountDownListener
                        public final void getCountDownValue(int i) {
                            dyOptionBuild.setDyCountDownListener(i);
                        }
                    });
                    DynamicViewCreator.getInstance().createDynamicView(dyOptionBuild, new DynamicViewBackListener() { // from class: com.mbridge.msdk.splash.c.a.2
                        @Override // com.mbridge.msdk.dycreator.wrapper.DynamicViewBackListener
                        public final void viewCreatedSuccess(View view) {
                            com.mbridge.msdk.splash.b.a aVar2 = aVar;
                            if (aVar2 != null) {
                                if (view != null) {
                                    aVar2.a(view);
                                } else {
                                    aVar2.a("View render error.");
                                }
                            }
                        }

                        @Override // com.mbridge.msdk.dycreator.wrapper.DynamicViewBackListener
                        public final void viewCreateFail(com.mbridge.msdk.dycreator.b.a aVar2) {
                            try {
                                if (dyOptionBuild != null) {
                                    q.a(com.mbridge.msdk.foundation.controller.b.d().g(), dyOptionBuild.getDyAdType() + "", dyOptionBuild.getTemplateType(), "create dynamic view fail " + aVar2.toString(), "fail", dyOptionBuild.getCampaignEx());
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            MBSplashView mBSplashView2 = mBSplashView;
                            if (mBSplashView2 != null) {
                                Context context2 = mBSplashView2.getContext();
                                if (context2 == null) {
                                    context2 = com.mbridge.msdk.foundation.controller.b.d().g();
                                }
                                a.this.a(context2, mBSplashView, cVar, aVar);
                            }
                        }

                        @Override // com.mbridge.msdk.dycreator.wrapper.DynamicViewBackListener
                        public final void viewClicked(BaseRespData baseRespData) {
                            float f;
                            com.mbridge.msdk.splash.signal.b splashSignalCommunicationImpl;
                            MBSplashView mBSplashView2 = mBSplashView;
                            final com.mbridge.msdk.splash.d.a aVarA = (mBSplashView2 == null || (splashSignalCommunicationImpl = mBSplashView2.getSplashSignalCommunicationImpl()) == null) ? null : splashSignalCommunicationImpl.a();
                            DyOption dyOption = dyOptionBuild;
                            CampaignEx campaignEx = dyOption != null ? dyOption.getCampaignEx() : null;
                            boolean z = baseRespData instanceof SplashResData;
                            EAction eAction = z ? ((SplashResData) baseRespData).geteAction() : null;
                            if (eAction != null) {
                                int i = AnonymousClass4.a[eAction.ordinal()];
                                final int clickType = 0;
                                if (i == 1) {
                                    if (aVarA != null) {
                                        if (baseRespData == null) {
                                            aVarA.a(campaignEx);
                                            return;
                                        }
                                        if (z) {
                                            SplashResData splashResData = (SplashResData) baseRespData;
                                            if (splashResData.getBaseViewData() != null) {
                                                com.mbridge.msdk.dycreator.f.a.a baseViewData = splashResData.getBaseViewData();
                                                float f2 = 0.0f;
                                                if (baseViewData == null || !(baseViewData instanceof MBSplashData)) {
                                                    f = 0.0f;
                                                } else {
                                                    MBSplashData mBSplashData = (MBSplashData) baseViewData;
                                                    f2 = mBSplashData.getxInScreen();
                                                    f = mBSplashData.getyInScreen();
                                                    clickType = mBSplashData.getClickType();
                                                }
                                                if (aVarA != null) {
                                                    try {
                                                        aVarA.a(com.mbridge.msdk.splash.a.a.a.a(com.mbridge.msdk.splash.a.a.a.a(clickType, f2, f), campaignEx));
                                                        return;
                                                    } catch (Throwable th) {
                                                        th.printStackTrace();
                                                        aVarA.a(campaignEx);
                                                        return;
                                                    }
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                if (i == 2) {
                                    if (aVarA != null) {
                                        aVarA.a();
                                        return;
                                    }
                                    return;
                                }
                                if (i == 3) {
                                    if (dyOptionBuild != null) {
                                        com.mbridge.msdk.click.b.b(com.mbridge.msdk.foundation.controller.b.d().g(), dyOptionBuild.getAdChoiceLink());
                                        return;
                                    }
                                    return;
                                }
                                if (i == 4 && baseRespData != null && z) {
                                    SplashResData splashResData2 = (SplashResData) baseRespData;
                                    if (splashResData2.getBaseViewData() != null) {
                                        com.mbridge.msdk.dycreator.f.a.a baseViewData2 = splashResData2.getBaseViewData();
                                        final a aVar2 = a.this;
                                        if (campaignEx != null) {
                                            String campaignUnitId = campaignEx.getCampaignUnitId();
                                            String requestId = campaignEx.getRequestId();
                                            clickType = baseViewData2 != null ? baseViewData2.getEffectData().getCurrentCountDown() : 0;
                                            aVarA.a(1, clickType);
                                            com.mbridge.msdk.foundation.c.a.a aVarA2 = com.mbridge.msdk.foundation.c.b.a().a(campaignUnitId + "_" + requestId);
                                            aVarA2.a(campaignEx);
                                            if (aVarA2 != null) {
                                                com.mbridge.msdk.foundation.c.b.a().a(campaignUnitId + "_" + requestId, new com.mbridge.msdk.foundation.c.a() { // from class: com.mbridge.msdk.splash.c.a.3
                                                    @Override // com.mbridge.msdk.foundation.c.a
                                                    public final void a() {
                                                    }

                                                    @Override // com.mbridge.msdk.foundation.c.a
                                                    public final void b() {
                                                        aVarA.a(2, clickType);
                                                    }

                                                    @Override // com.mbridge.msdk.foundation.c.a
                                                    public final void a(String str) {
                                                        aVarA.a(2, clickType);
                                                    }
                                                });
                                                aVarA2.a();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    });
                    return;
                } catch (Exception unused) {
                }
            }
            a(context, mBSplashView, cVar, aVar);
            return;
        }
        a(context, mBSplashView, cVar, aVar);
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.splash.c.a$4, reason: invalid class name */
    /* JADX INFO: compiled from: NativeViewRenderManager.java */
    static /* synthetic */ class AnonymousClass4 {
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
            try {
                a[EAction.NOTICE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[EAction.FEEDBACK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, MBSplashView mBSplashView, com.mbridge.msdk.splash.a.c cVar, com.mbridge.msdk.splash.b.a aVar) {
        try {
            MBSplashNativeView mBSplashNativeView = new MBSplashNativeView(context, mBSplashView, cVar);
            if (aVar != null) {
                aVar.a(mBSplashNativeView);
            }
        } catch (Throwable unused) {
            if (aVar != null) {
                aVar.a("View render error.");
            }
        }
    }
}
