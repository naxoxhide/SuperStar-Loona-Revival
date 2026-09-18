package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.tapjoy.TJAdUnitConstants;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface zzhf extends zzgi {
    public static final zzfsx zza = new zzfsx() { // from class: com.google.android.gms.internal.ads.zzgz
        @Override // com.google.android.gms.internal.ads.zzfsx
        public final boolean zza(Object obj) {
            String str = (String) obj;
            if (str == null) {
                return false;
            }
            String strZza = zzfsc.zza(str);
            if (TextUtils.isEmpty(strZza)) {
                return false;
            }
            return ((strZza.contains("text") && !strZza.contains("text/vtt")) || strZza.contains(TJAdUnitConstants.String.HTML) || strZza.contains("xml")) ? false : true;
        }
    };

    @Override // com.google.android.gms.internal.ads.zzgi
    Map zze();
}
