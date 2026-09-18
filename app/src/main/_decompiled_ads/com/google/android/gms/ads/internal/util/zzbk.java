package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzalo;
import com.google.android.gms.internal.ads.zzamk;
import com.google.android.gms.internal.ads.zzaml;
import com.google.android.gms.internal.ads.zzank;
import com.google.android.gms.internal.ads.zzcas;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbk extends zzank {
    final /* synthetic */ byte[] zza;
    final /* synthetic */ Map zzb;
    final /* synthetic */ zzcas zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbk(zzbq zzbqVar, int i, String str, zzaml zzamlVar, zzamk zzamkVar, byte[] bArr, Map map, zzcas zzcasVar) {
        super(i, str, zzamlVar, zzamkVar);
        this.zza = bArr;
        this.zzb = map;
        this.zzc = zzcasVar;
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final Map zzl() throws zzalo {
        Map map = this.zzb;
        return map == null ? Collections.emptyMap() : map;
    }

    @Override // com.google.android.gms.internal.ads.zzank, com.google.android.gms.internal.ads.zzamg
    protected final /* bridge */ /* synthetic */ void zzo(Object obj) {
        zzo((String) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final byte[] zzx() throws zzalo {
        byte[] bArr = this.zza;
        if (bArr == null) {
            return null;
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzank
    /* JADX INFO: renamed from: zzz */
    public final void zzo(String str) {
        this.zzc.zzg(str);
        super.zzo(str);
    }
}
