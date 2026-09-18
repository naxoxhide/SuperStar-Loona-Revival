package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdld {
    private final zzdpt zza;
    private final zzdoi zzb;
    private ViewTreeObserver.OnScrollChangedListener zzc = null;

    public zzdld(zzdpt zzdptVar, zzdoi zzdoiVar) {
        this.zza = zzdptVar;
        this.zzb = zzdoiVar;
    }

    private static final int zzf(Context context, String str, int i) {
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
        }
        com.google.android.gms.ads.internal.client.zzay.zzb();
        return zzcam.zzx(context, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View zza(final View view, final WindowManager windowManager) throws zzcgm {
        zzcgb zzcgbVarZza = this.zza.zza(com.google.android.gms.ads.internal.client.zzq.zzc(), null, null);
        View view2 = (View) zzcgbVarZza;
        view2.setVisibility(4);
        view2.setContentDescription("policy_validator");
        zzcgbVarZza.zzad("/sendMessageToSdk", new zzbjj() { // from class: com.google.android.gms.internal.ads.zzdkx
            @Override // com.google.android.gms.internal.ads.zzbjj
            public final void zza(Object obj, Map map) {
                this.zza.zzb((zzcgb) obj, map);
            }
        });
        zzcgbVarZza.zzad("/hideValidatorOverlay", new zzbjj() { // from class: com.google.android.gms.internal.ads.zzdky
            @Override // com.google.android.gms.internal.ads.zzbjj
            public final void zza(Object obj, Map map) {
                this.zza.zzc(windowManager, view, (zzcgb) obj, map);
            }
        });
        zzcgbVarZza.zzad("/open", new zzbju(null, null, null, null, null, null));
        this.zzb.zzj(new WeakReference(zzcgbVarZza), "/loadNativeAdPolicyViolations", new zzbjj() { // from class: com.google.android.gms.internal.ads.zzdkz
            @Override // com.google.android.gms.internal.ads.zzbjj
            public final void zza(Object obj, Map map) {
                this.zza.zze(view, windowManager, (zzcgb) obj, map);
            }
        });
        this.zzb.zzj(new WeakReference(zzcgbVarZza), "/showValidatorOverlay", new zzbjj() { // from class: com.google.android.gms.internal.ads.zzdla
            @Override // com.google.android.gms.internal.ads.zzbjj
            public final void zza(Object obj, Map map) {
                zzcat.zze("Show native ad policy validator overlay.");
                ((zzcgb) obj).zzF().setVisibility(0);
            }
        });
        return view2;
    }

    final /* synthetic */ void zzb(zzcgb zzcgbVar, Map map) {
        this.zzb.zzg("sendMessageToNativeJs", map);
    }

    final /* synthetic */ void zzc(WindowManager windowManager, View view, zzcgb zzcgbVar, Map map) {
        zzcat.zze("Hide native ad policy validator overlay.");
        zzcgbVar.zzF().setVisibility(8);
        if (zzcgbVar.zzF().getWindowToken() != null) {
            windowManager.removeView(zzcgbVar.zzF());
        }
        zzcgbVar.destroy();
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (this.zzc == null || viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.removeOnScrollChangedListener(this.zzc);
    }

    final /* synthetic */ void zzd(Map map, boolean z, int i, String str, String str2) {
        HashMap map2 = new HashMap();
        map2.put("messageType", "validatorHtmlLoaded");
        map2.put("id", (String) map.get("id"));
        this.zzb.zzg("sendMessageToNativeJs", map2);
    }

    final /* synthetic */ void zze(final View view, final WindowManager windowManager, final zzcgb zzcgbVar, final Map map) {
        zzcgbVar.zzN().zzA(new zzchm() { // from class: com.google.android.gms.internal.ads.zzdlc
            @Override // com.google.android.gms.internal.ads.zzchm
            public final void zza(boolean z, int i, String str, String str2) {
                this.zza.zzd(map, z, i, str, str2);
            }
        });
        if (map == null) {
            return;
        }
        Context context = view.getContext();
        int iZzf = zzf(context, (String) map.get("validator_width"), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzhQ)).intValue());
        int iZzf2 = zzf(context, (String) map.get("validator_height"), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzhR)).intValue());
        int iZzf3 = zzf(context, (String) map.get("validator_x"), 0);
        int iZzf4 = zzf(context, (String) map.get("validator_y"), 0);
        zzcgbVar.zzag(zzchq.zzb(iZzf, iZzf2));
        try {
            zzcgbVar.zzG().getSettings().setUseWideViewPort(((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzhS)).booleanValue());
            zzcgbVar.zzG().getSettings().setLoadWithOverviewMode(((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzhT)).booleanValue());
        } catch (NullPointerException unused) {
        }
        final WindowManager.LayoutParams layoutParamsZzb = com.google.android.gms.ads.internal.util.zzbz.zzb();
        layoutParamsZzb.x = iZzf3;
        layoutParamsZzb.y = iZzf4;
        windowManager.updateViewLayout(zzcgbVar.zzF(), layoutParamsZzb);
        final String str = (String) map.get("orientation");
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect)) {
            final int i = (("1".equals(str) || "2".equals(str)) ? rect.bottom : rect.top) - iZzf4;
            this.zzc = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.google.android.gms.internal.ads.zzdlb
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    Rect rect2 = new Rect();
                    if (view.getGlobalVisibleRect(rect2)) {
                        zzcgb zzcgbVar2 = zzcgbVar;
                        if (zzcgbVar2.zzF().getWindowToken() == null) {
                            return;
                        }
                        int i2 = i;
                        WindowManager.LayoutParams layoutParams = layoutParamsZzb;
                        String str2 = str;
                        if ("1".equals(str2) || "2".equals(str2)) {
                            layoutParams.y = rect2.bottom - i2;
                        } else {
                            layoutParams.y = rect2.top - i2;
                        }
                        windowManager.updateViewLayout(zzcgbVar2.zzF(), layoutParams);
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnScrollChangedListener(this.zzc);
            }
        }
        String str2 = (String) map.get("overlay_url");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        zzcgbVar.loadUrl(str2);
    }
}
