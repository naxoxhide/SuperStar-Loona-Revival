package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbom implements zzfza {
    private final zzbns zza;
    private final zzbnt zzb;
    private final String zzc = "google.afma.activeView.handleUpdate";
    private final ListenableFuture zzd;

    zzbom(ListenableFuture listenableFuture, String str, zzbnt zzbntVar, zzbns zzbnsVar) {
        this.zzd = listenableFuture;
        this.zzb = zzbntVar;
        this.zza = zzbnsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfza
    public final ListenableFuture zza(Object obj) throws Exception {
        return zzb(obj);
    }

    public final ListenableFuture zzb(final Object obj) {
        return zzfzt.zzn(this.zzd, new zzfza() { // from class: com.google.android.gms.internal.ads.zzbok
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj2) {
                return this.zza.zzc(obj, (zzbnn) obj2);
            }
        }, zzcbg.zzf);
    }

    final /* synthetic */ ListenableFuture zzc(Object obj, zzbnn zzbnnVar) throws Exception {
        zzcbl zzcblVar = new zzcbl();
        com.google.android.gms.ads.internal.zzt.zzp();
        String string = UUID.randomUUID().toString();
        zzbji.zzo.zzc(string, new zzbol(this, zzcblVar));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", string);
        jSONObject.put("args", (JSONObject) obj);
        zzbnnVar.zzl(this.zzc, jSONObject);
        return zzcblVar;
    }
}
