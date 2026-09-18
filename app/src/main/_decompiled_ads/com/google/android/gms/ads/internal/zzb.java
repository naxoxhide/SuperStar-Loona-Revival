package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzbum;
import com.google.android.gms.internal.ads.zzbxu;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes2.dex */
@ParametersAreNonnullByDefault
public final class zzb {
    private final Context zza;
    private boolean zzb;
    private final zzbxu zzc;
    private final zzbum zzd = new zzbum(false, Collections.emptyList());

    public zzb(Context context, zzbxu zzbxuVar, zzbum zzbumVar) {
        this.zza = context;
        this.zzc = zzbxuVar;
    }

    private final boolean zzd() {
        zzbxu zzbxuVar = this.zzc;
        return (zzbxuVar != null && zzbxuVar.zza().zzf) || this.zzd.zza;
    }

    public final void zza() {
        this.zzb = true;
    }

    public final void zzb(String str) {
        List<String> list;
        if (zzd()) {
            if (str == null) {
                str = "";
            }
            zzbxu zzbxuVar = this.zzc;
            if (zzbxuVar != null) {
                zzbxuVar.zzd(str, null, 3);
                return;
            }
            zzbum zzbumVar = this.zzd;
            if (!zzbumVar.zza || (list = zzbumVar.zzb) == null) {
                return;
            }
            for (String str2 : list) {
                if (!TextUtils.isEmpty(str2)) {
                    String strReplace = str2.replace("{NAVIGATION_URL}", Uri.encode(str));
                    Context context = this.zza;
                    zzt.zzp();
                    com.google.android.gms.ads.internal.util.zzt.zzK(context, "", strReplace);
                }
            }
        }
    }

    public final boolean zzc() {
        return !zzd() || this.zzb;
    }
}
