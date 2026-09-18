package com.bytedance.sdk.openadsdk.b.m.p;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.f0.r;
import com.bytedance.sdk.openadsdk.core.s;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: RewardFullDataManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    private static final SparseArray<WeakReference<q>> a = new SparseArray<>();

    public static void a(a aVar, Intent intent, Bundle bundle) {
        a(intent, aVar);
        a(bundle, aVar);
    }

    public static q a(Intent intent, Bundle bundle, com.bytedance.sdk.openadsdk.core.j0.c.b bVar) {
        q rVar = null;
        if (!com.bytedance.sdk.openadsdk.m.b.b()) {
            q qVarE = s.g().e();
            com.bytedance.sdk.openadsdk.core.f0.a aVarB = s.g().b();
            if (qVarE == null && aVarB != null) {
                qVarE = new r(aVarB);
            }
            rVar = qVarE;
            if (bVar != null) {
                bVar.a(bundle);
            }
            s.g().a();
        } else if (intent != null) {
            try {
                String stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_AD_INFO);
                if (stringExtra != null) {
                    rVar = new r(com.bytedance.sdk.openadsdk.core.f0.a.a(new JSONObject(stringExtra)));
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.m.b("TTAD.RFDM", "", e);
            }
        }
        if (bundle != null) {
            try {
                WeakReference<q> weakReference = a.get(bundle.getInt("meta_tmp"));
                if (weakReference != null) {
                    rVar = weakReference.get();
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.m.b("TTAD.RFDM", "", th);
            }
        }
        if (rVar != null) {
            rVar.a(rVar.k0(), 7);
        }
        return rVar;
    }

    private static void a(Intent intent, a aVar) {
        if (intent == null) {
            return;
        }
        aVar.G.b(intent.getStringExtra("video_cache_url"));
        aVar.c = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_META_MD5);
        aVar.n = intent.getIntExtra("orientation_angle", 0) == 3;
    }

    public static void a(Bundle bundle, a aVar) {
        if (bundle == null) {
            return;
        }
        aVar.c = bundle.getString(TTAdConstant.MULTI_PROCESS_META_MD5);
        aVar.G.b(bundle.getString("video_cache_url"));
        aVar.d = bundle.getBoolean("is_mute");
        if (bundle.getLong("video_current") > 0) {
            aVar.G.a(bundle.getLong("video_current", 0L));
        }
        aVar.a(bundle.getBoolean("has_show_skip_btn"));
    }

    public static void a(a aVar, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        try {
            q qVar = aVar.a;
            a.append(qVar.hashCode(), new WeakReference<>(qVar));
            bundle.putInt("meta_tmp", qVar.hashCode());
            bundle.putString(TTAdConstant.MULTI_PROCESS_META_MD5, aVar.c);
            bundle.putString("video_cache_url", aVar.G.m());
            bundle.putLong("video_current", aVar.G.e());
            bundle.putBoolean("is_mute", aVar.d);
            bundle.putBoolean("has_show_skip_btn", aVar.p);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.m.b("TTAD.RFDM", "onSaveInstanceState: ", th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0025  */
    /* JADX WARN: Code duplicated, block: B:14:0x0030  */
    /* JADX WARN: Code duplicated, block: B:16:0x0036  */
    /* JADX WARN: Code duplicated, block: B:18:0x003c  */
    /* JADX WARN: Code duplicated, block: B:19:0x004b  */
    public static void a(Intent intent, Activity activity, boolean z, String str, com.bytedance.sdk.openadsdk.core.f0.a aVar, String str2) {
        int rotation;
        JSONObject jSONObjectK;
        if (activity == null) {
            intent.addFlags(268435456);
        } else {
            try {
                rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.m.b("TTAD.RFDM", "", e);
                rotation = 0;
            }
            intent.putExtra("orientation_angle", rotation);
            if (z) {
                intent.putExtra("video_cache_url", str);
            }
            if (com.bytedance.sdk.openadsdk.m.b.b()) {
                jSONObjectK = aVar.k();
                if (jSONObjectK == null) {
                    com.bytedance.sdk.component.utils.m.b("toJsonObj return null");
                    return;
                } else {
                    intent.putExtra(TTAdConstant.MULTI_PROCESS_AD_INFO, jSONObjectK.toString());
                    intent.putExtra(TTAdConstant.MULTI_PROCESS_META_MD5, str2);
                    return;
                }
            }
            s.g().a();
            s.g().a(aVar);
        }
        rotation = 0;
        intent.putExtra("orientation_angle", rotation);
        if (z) {
            intent.putExtra("video_cache_url", str);
        }
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            jSONObjectK = aVar.k();
            if (jSONObjectK == null) {
                com.bytedance.sdk.component.utils.m.b("toJsonObj return null");
                return;
            } else {
                intent.putExtra(TTAdConstant.MULTI_PROCESS_AD_INFO, jSONObjectK.toString());
                intent.putExtra(TTAdConstant.MULTI_PROCESS_META_MD5, str2);
                return;
            }
        }
        s.g().a();
        s.g().a(aVar);
    }
}
