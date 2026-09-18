package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdyz {
    private final zzgad zza;
    private final zzdyf zzb;
    private final zzhaw zzc;
    private final zzfjh zzd;
    private final Context zze;
    private final zzcaz zzf;

    public zzdyz(zzgad zzgadVar, zzdyf zzdyfVar, zzhaw zzhawVar, zzfjh zzfjhVar, Context context, zzcaz zzcazVar) {
        this.zza = zzgadVar;
        this.zzb = zzdyfVar;
        this.zzc = zzhawVar;
        this.zzd = zzfjhVar;
        this.zze = context;
        this.zzf = zzcazVar;
    }

    private final ListenableFuture zzh(final zzbvg zzbvgVar, zzdyy zzdyyVar, final zzdyy zzdyyVar2, final zzfza zzfzaVar) {
        ListenableFuture listenableFutureZzf;
        String str = zzbvgVar.zzd;
        com.google.android.gms.ads.internal.zzt.zzp();
        if (com.google.android.gms.ads.internal.util.zzt.zzB(str)) {
            listenableFutureZzf = zzfzt.zzg(new zzdyo(1));
        } else {
            listenableFutureZzf = zzfzt.zzf(zzdyyVar.zza(zzbvgVar), ExecutionException.class, new zzfza() { // from class: com.google.android.gms.internal.ads.zzdyx
                @Override // com.google.android.gms.internal.ads.zzfza
                public final ListenableFuture zza(Object obj) {
                    ExecutionException executionException = (ExecutionException) obj;
                    Throwable cause = executionException.getCause();
                    ExecutionException cause2 = executionException;
                    if (cause != null) {
                        cause2 = executionException.getCause();
                    }
                    return zzfzt.zzg(cause2);
                }
            }, this.zza);
        }
        return zzfzt.zzf(zzfzt.zzn(zzfzk.zzu(listenableFutureZzf), zzfzaVar, this.zza), zzdyo.class, new zzfza() { // from class: com.google.android.gms.internal.ads.zzdyw
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return this.zza.zzc(zzdyyVar2, zzbvgVar, zzfzaVar, (zzdyo) obj);
            }
        }, this.zza);
    }

    public final ListenableFuture zza(final zzbvg zzbvgVar) {
        zzfza zzfzaVar = new zzfza() { // from class: com.google.android.gms.internal.ads.zzdyt
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                String str = new String(zzfxv.zza((InputStream) obj), zzfsi.zzc);
                zzbvg zzbvgVar2 = zzbvgVar;
                zzbvgVar2.zzj = str;
                return zzfzt.zzh(zzbvgVar2);
            }
        };
        final zzdyf zzdyfVar = this.zzb;
        return zzh(zzbvgVar, new zzdyy() { // from class: com.google.android.gms.internal.ads.zzdyu
            @Override // com.google.android.gms.internal.ads.zzdyy
            public final ListenableFuture zza(zzbvg zzbvgVar2) {
                return zzdyfVar.zzb(zzbvgVar2);
            }
        }, new zzdyy() { // from class: com.google.android.gms.internal.ads.zzdyv
            @Override // com.google.android.gms.internal.ads.zzdyy
            public final ListenableFuture zza(zzbvg zzbvgVar2) {
                return this.zza.zzd(zzbvgVar2);
            }
        }, zzfzaVar);
    }

    public final ListenableFuture zzb(JSONObject jSONObject) {
        return zzfzt.zzn(zzfzk.zzu(zzfzt.zzh(jSONObject)), com.google.android.gms.ads.internal.zzt.zzf().zza(this.zze, this.zzf, this.zzd).zza("AFMA_getAdDictionary", zzbnx.zza, new zzbns() { // from class: com.google.android.gms.internal.ads.zzdyp
            @Override // com.google.android.gms.internal.ads.zzbns
            public final Object zza(JSONObject jSONObject2) {
                return new zzbvj(jSONObject2);
            }
        }), this.zza);
    }

    final /* synthetic */ ListenableFuture zzc(zzdyy zzdyyVar, zzbvg zzbvgVar, zzfza zzfzaVar, zzdyo zzdyoVar) throws Exception {
        return zzfzt.zzn(zzdyyVar.zza(zzbvgVar), zzfzaVar, this.zza);
    }

    final /* synthetic */ ListenableFuture zzd(zzbvg zzbvgVar) {
        return ((zzeav) this.zzc.zzb()).zzb(zzbvgVar, Binder.getCallingUid());
    }

    final /* synthetic */ ListenableFuture zze(zzbvg zzbvgVar) {
        return this.zzb.zzc(zzbvgVar.zzh);
    }

    final /* synthetic */ ListenableFuture zzf(zzbvg zzbvgVar) {
        return ((zzeav) this.zzc.zzb()).zzi(zzbvgVar.zzh);
    }

    public final ListenableFuture zzg(zzbvg zzbvgVar) {
        return zzh(zzbvgVar, new zzdyy() { // from class: com.google.android.gms.internal.ads.zzdyr
            @Override // com.google.android.gms.internal.ads.zzdyy
            public final ListenableFuture zza(zzbvg zzbvgVar2) {
                return this.zza.zze(zzbvgVar2);
            }
        }, new zzdyy() { // from class: com.google.android.gms.internal.ads.zzdys
            @Override // com.google.android.gms.internal.ads.zzdyy
            public final ListenableFuture zza(zzbvg zzbvgVar2) {
                return this.zza.zzf(zzbvgVar2);
            }
        }, new zzfza() { // from class: com.google.android.gms.internal.ads.zzdyq
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return zzfzt.zzh(null);
            }
        });
    }
}
