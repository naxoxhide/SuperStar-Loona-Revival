package com.mbridge.msdk.dycreator.wrapper;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mbridge.msdk.dycreator.a.b;
import com.mbridge.msdk.dycreator.b.a;
import com.mbridge.msdk.dycreator.e.f;
import com.mbridge.msdk.dycreator.viewmodel.BaseViewModel;
import com.mbridge.msdk.dycreator.viewmodel.MBCommonViewVModel;
import com.mbridge.msdk.dycreator.viewmodel.MBRewardViewVModel;
import com.mbridge.msdk.dycreator.viewmodel.MBSplashViewVModel;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.aa;
import java.io.File;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class DynamicViewCreator {
    private static volatile DynamicViewCreator a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f2014b = -201;

    private DynamicViewCreator() {
        b.a().a(com.mbridge.msdk.foundation.controller.b.d().g());
    }

    public static DynamicViewCreator getInstance() {
        if (a == null) {
            synchronized (DynamicViewCreator.class) {
                if (a == null) {
                    a = new DynamicViewCreator();
                }
            }
        }
        return a;
    }

    public void createDynamicView(DyOption dyOption, DynamicViewBackListener dynamicViewBackListener) {
        BaseViewModel mBSplashViewVModel;
        boolean z;
        if (dyOption == null) {
            dynamicViewBackListener.viewCreateFail(new a(com.mbridge.msdk.dycreator.b.b.NOT_FOUND_DYNAMIC_OPTION));
            return;
        }
        if (dynamicViewBackListener == null) {
            return;
        }
        Context contextG = com.mbridge.msdk.foundation.controller.b.d().g();
        if (contextG == null) {
            dynamicViewBackListener.viewCreateFail(new a(com.mbridge.msdk.dycreator.b.b.NOT_FOUND_CONTEXT));
            return;
        }
        boolean z2 = false;
        String[] strArr = new String[0];
        if (dyOption != null) {
            if (dyOption.getCampaignEx() == null) {
                dynamicViewBackListener.viewCreateFail(new a(com.mbridge.msdk.dycreator.b.b.NOT_FOUND_CAMPAIGN));
                z = false;
            } else {
                z = true;
            }
            if (dyOption.getFile() != null || dyOption.getFileDirs() == null) {
                z2 = z;
            } else {
                dynamicViewBackListener.viewCreateFail(new a(com.mbridge.msdk.dycreator.b.b.BIND_DATA_FILE_OR_DIR));
            }
        } else {
            z2 = true;
        }
        if (z2) {
            try {
                a(dyOption, "create dynamic view", "start");
                View viewA = a(contextG, dyOption);
                if (viewA == null) {
                    dynamicViewBackListener.viewCreateFail(new a(com.mbridge.msdk.dycreator.b.b.FILE_CREATE_VIEW_FILE));
                    a(dyOption, "create dynamic view", "fail");
                    return;
                }
                a(dyOption, "create dynamic view", "success");
                int i = AnonymousClass1.a[dyOption.getDyAdType().ordinal()];
                if (i == 1) {
                    mBSplashViewVModel = new MBSplashViewVModel(dyOption);
                } else if (i == 2) {
                    mBSplashViewVModel = new MBRewardViewVModel(dyOption);
                } else {
                    mBSplashViewVModel = new MBCommonViewVModel();
                }
                mBSplashViewVModel.setDynamicViewBackListener(dynamicViewBackListener);
                com.mbridge.msdk.dycreator.binding.b.a().a(mBSplashViewVModel);
                mBSplashViewVModel.setModelDataAndBind();
                a(dyOption, "create dynamic view", "bind_data_done");
                dynamicViewBackListener.viewCreatedSuccess(viewA);
            } catch (Exception e) {
                aa.d("DynamicViewCreator", e.getMessage());
                dynamicViewBackListener.viewCreateFail(new a(f2014b, e.getMessage()));
            }
        }
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.dycreator.wrapper.DynamicViewCreator$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[DyAdType.values().length];
            a = iArr;
            try {
                iArr[DyAdType.SPLASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[DyAdType.REWARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public View createDynamicView(DyOption dyOption) {
        Context contextG;
        if (dyOption == null || (contextG = com.mbridge.msdk.foundation.controller.b.d().g()) == null) {
            return null;
        }
        return a(contextG, dyOption);
    }

    private View a(Context context, DyOption dyOption) {
        List<String> fileDirs;
        if (dyOption == null || (fileDirs = dyOption.getFileDirs()) == null) {
            return null;
        }
        int i = 0;
        ViewGroup viewGroup = null;
        int i2 = 0;
        while (i2 < fileDirs.size()) {
            try {
                if (!TextUtils.isEmpty(fileDirs.get(i2))) {
                    if (i2 == 0) {
                        viewGroup = (ViewGroup) f.a(context).a(fileDirs.get(i2));
                    } else {
                        String str = fileDirs.get(i2);
                        if (context != null && viewGroup != null && !TextUtils.isEmpty(str)) {
                            try {
                                JSONObject jSONObject = new JSONObject(str);
                                String string = jSONObject.getString("folder_dir");
                                if (!TextUtils.isEmpty(string)) {
                                    JSONArray jSONArray = new JSONArray(jSONObject.optString("ext_template"));
                                    if (jSONArray.length() != 0) {
                                        int i3 = i;
                                        while (i3 < jSONArray.length()) {
                                            JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                                            if (jSONObject2 != null) {
                                                View viewA = f.a(context).a(string + File.separator + jSONObject2.optString("name"));
                                                if (viewGroup != null && viewA != null) {
                                                    JSONObject jSONObject3 = jSONObject2.getJSONObject("layout");
                                                    if (jSONObject3 == null) {
                                                        viewGroup.addView(viewA, 3);
                                                    } else if (context != null && viewGroup != null && viewA != null && jSONObject3 != null) {
                                                        try {
                                                            String strOptString = jSONObject3.optString("parent_id");
                                                            ViewGroup viewGroup2 = !TextUtils.isEmpty(strOptString) ? (ViewGroup) f.a(context).a(viewGroup, strOptString) : viewGroup;
                                                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewGroup2.getLayoutParams();
                                                            if (layoutParams != null) {
                                                                String strOptString2 = jSONObject3.optString("below", "");
                                                                if (!TextUtils.isEmpty(strOptString2)) {
                                                                    layoutParams.addRule(3, strOptString2.hashCode());
                                                                }
                                                                String strOptString3 = jSONObject3.optString("left_of", "");
                                                                if (!TextUtils.isEmpty(strOptString3)) {
                                                                    layoutParams.addRule(i, strOptString3.hashCode());
                                                                }
                                                                String strOptString4 = jSONObject3.optString("right_of", "");
                                                                if (!TextUtils.isEmpty(strOptString4)) {
                                                                    layoutParams.addRule(1, strOptString4.hashCode());
                                                                }
                                                                int iOptInt = jSONObject3.optInt(FirebaseAnalytics.Param.INDEX, -2);
                                                                int iOptInt2 = jSONObject3.optInt(ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, -1);
                                                                if (iOptInt2 != -1) {
                                                                    viewA.setVisibility(iOptInt2);
                                                                }
                                                                if (iOptInt != -2) {
                                                                    viewGroup2.addView(viewA, iOptInt, layoutParams);
                                                                } else {
                                                                    viewGroup2.addView(viewA, layoutParams);
                                                                }
                                                            }
                                                        } catch (Exception e) {
                                                            aa.d("DynamicViewCreator", e.getMessage());
                                                        }
                                                    }
                                                }
                                            }
                                            i3++;
                                            i = 0;
                                        }
                                    }
                                }
                            } catch (Exception e2) {
                                aa.d("DynamicViewCreator", e2.getMessage());
                            }
                        }
                    }
                }
                i2++;
                i = 0;
            } catch (Exception e3) {
                aa.d("DynamicViewCreator", e3.getMessage());
            }
        }
        return viewGroup;
    }

    private void a(DyOption dyOption, String str, String str2) {
        if (dyOption != null) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    q.a(com.mbridge.msdk.foundation.controller.b.d().g(), dyOption.getDyAdType() + "", dyOption.getTemplateType(), str, str2, dyOption.getCampaignEx());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
