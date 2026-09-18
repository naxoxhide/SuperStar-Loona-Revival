package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.internal.ads.zzalo;
import com.google.android.gms.internal.ads.zzamj;
import com.google.android.gms.internal.ads.zzanm;
import com.google.android.gms.internal.ads.zzbci;
import com.google.android.gms.internal.ads.zzcas;
import com.google.android.gms.internal.ads.zzcat;
import com.google.android.gms.internal.ads.zzcbl;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes2.dex */
@ParametersAreNonnullByDefault
public final class zzbq {
    private static zzamj zzb;
    private static final Object zzc = new Object();

    @Deprecated
    public static final zzbl zza = new zzbi();

    /* JADX WARN: Code duplicated, block: B:14:0x0034 A[Catch: all -> 0x003d, TryCatch #0 {, blocks: (B:7:0x0010, B:9:0x0014, B:11:0x001d, B:13:0x002f, B:15:0x0039, B:14:0x0034, B:16:0x003b), top: B:21:0x0010 }] */
    public zzbq(Context context) {
        zzamj zzamjVarZza;
        context = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        synchronized (zzc) {
            if (zzb == null) {
                zzbci.zza(context);
                if (ClientLibraryUtils.isPackageSide()) {
                    zzamjVarZza = zzanm.zza(context, null);
                } else {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzen)).booleanValue()) {
                        zzamjVarZza = zzaz.zzb(context);
                    } else {
                        zzamjVarZza = zzanm.zza(context, null);
                    }
                }
                zzb = zzamjVarZza;
            }
        }
    }

    public final ListenableFuture zza(String str) {
        zzcbl zzcblVar = new zzcbl();
        zzb.zza(new zzbp(str, null, zzcblVar));
        return zzcblVar;
    }

    public final ListenableFuture zzb(int i, String str, Map map, byte[] bArr) {
        zzbn zzbnVar = new zzbn(null);
        zzbj zzbjVar = new zzbj(this, str, zzbnVar);
        zzcas zzcasVar = new zzcas(null);
        zzbk zzbkVar = new zzbk(this, i, str, zzbnVar, zzbjVar, bArr, map, zzcasVar);
        if (zzcas.zzk()) {
            try {
                zzcasVar.zzd(str, "GET", zzbkVar.zzl(), zzbkVar.zzx());
            } catch (zzalo e) {
                zzcat.zzj(e.getMessage());
            }
        }
        zzb.zza(zzbkVar);
        return zzbnVar;
    }
}
