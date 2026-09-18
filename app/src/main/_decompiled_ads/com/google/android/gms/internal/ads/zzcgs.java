package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcgs implements zzbjj {
    final /* synthetic */ zzcgu zza;

    zzcgs(zzcgu zzcguVar) {
        this.zza = zzcguVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        if (map != null) {
            String str = (String) map.get("height");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                int i = Integer.parseInt(str);
                synchronized (this.zza) {
                    zzcgu zzcguVar = this.zza;
                    if (zzcguVar.zzG != i) {
                        zzcguVar.zzG = i;
                        this.zza.requestLayout();
                    }
                }
            } catch (Exception e) {
                zzcat.zzk("Exception occurred while getting webview content height", e);
            }
        }
    }
}
