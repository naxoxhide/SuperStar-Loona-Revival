package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbir implements zzbjj {
    zzbir() {
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcgb zzcgbVar = (zzcgb) obj;
        if (TextUtils.isEmpty((CharSequence) map.get("appId"))) {
            com.google.android.gms.ads.internal.util.zze.zza("Missing App Id, cannot show LMD Overlay without it");
            return;
        }
        zzfqz zzfqzVarZzl = zzfra.zzl();
        zzfqzVarZzl.zzb((String) map.get("appId"));
        zzfqzVarZzl.zzh(zzcgbVar.getWidth());
        zzfqzVarZzl.zzg(zzcgbVar.zzF().getWindowToken());
        if (map.containsKey("gravityX") && map.containsKey("gravityY")) {
            zzfqzVarZzl.zzd(Integer.parseInt((String) map.get("gravityX")) | Integer.parseInt((String) map.get("gravityY")));
        } else {
            zzfqzVarZzl.zzd(81);
        }
        if (map.containsKey("verticalMargin")) {
            zzfqzVarZzl.zze(Float.parseFloat((String) map.get("verticalMargin")));
        } else {
            zzfqzVarZzl.zze(0.02f);
        }
        if (map.containsKey("enifd")) {
            zzfqzVarZzl.zza((String) map.get("enifd"));
        }
        try {
            com.google.android.gms.ads.internal.zzt.zzj().zzj(zzcgbVar, zzfqzVarZzl.zzi());
        } catch (NullPointerException e) {
            com.google.android.gms.ads.internal.zzt.zzo().zzu(e, "DefaultGmsgHandlers.ShowLMDOverlay");
            com.google.android.gms.ads.internal.util.zze.zza("Missing parameters for LMD Overlay show request");
        }
    }
}
