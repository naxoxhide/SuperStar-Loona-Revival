package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
@ParametersAreNonnullByDefault
public final class zzboe implements zzbnq {
    private final zzbns zza;
    private final zzbnt zzb;
    private final zzbnm zzc;
    private final String zzd;

    zzboe(zzbnm zzbnmVar, String str, zzbnt zzbntVar, zzbns zzbnsVar) {
        this.zzc = zzbnmVar;
        this.zzd = str;
        this.zzb = zzbntVar;
        this.zza = zzbnsVar;
    }

    static /* bridge */ /* synthetic */ void zzd(zzboe zzboeVar, zzbng zzbngVar, zzbnn zzbnnVar, Object obj, zzcbl zzcblVar) {
        try {
            com.google.android.gms.ads.internal.zzt.zzp();
            String string = UUID.randomUUID().toString();
            zzbji.zzo.zzc(string, new zzbod(zzboeVar, zzbngVar, zzcblVar));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", string);
            jSONObject.put("args", zzboeVar.zzb.zzb(obj));
            zzbnnVar.zzl(zzboeVar.zzd, jSONObject);
        } catch (Exception e) {
            try {
                zzcblVar.zzd(e);
                zzcat.zzh("Unable to invokeJavascript", e);
            } finally {
                zzbngVar.zzb();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfza
    public final ListenableFuture zza(Object obj) throws Exception {
        return zzb(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzbnq
    public final ListenableFuture zzb(Object obj) {
        zzcbl zzcblVar = new zzcbl();
        zzbng zzbngVarZzb = this.zzc.zzb(null);
        zzbngVarZzb.zzi(new zzbob(this, zzbngVarZzb, obj, zzcblVar), new zzboc(this, zzcblVar, zzbngVarZzb));
        return zzcblVar;
    }
}
