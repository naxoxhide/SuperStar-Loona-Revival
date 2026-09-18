package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzblf implements zzalz {
    private volatile zzbks zza;
    private final Context zzb;

    public zzblf(Context context) {
        this.zzb = context;
    }

    static /* bridge */ /* synthetic */ void zzc(zzblf zzblfVar) {
        if (zzblfVar.zza == null) {
            return;
        }
        zzblfVar.zza.disconnect();
        Binder.flushPendingCommands();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzalz
    public final zzamc zza(zzamg zzamgVar) throws zzamp {
        Parcelable.Creator<zzbkt> creator = zzbkt.CREATOR;
        Map mapZzl = zzamgVar.zzl();
        int size = mapZzl.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i = 0;
        int i2 = 0;
        for (Map.Entry entry : mapZzl.entrySet()) {
            strArr[i2] = (String) entry.getKey();
            strArr2[i2] = (String) entry.getValue();
            i2++;
        }
        zzbkt zzbktVar = new zzbkt(zzamgVar.zzk(), strArr, strArr2);
        long jElapsedRealtime = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
        try {
            zzcbl zzcblVar = new zzcbl();
            this.zza = new zzbks(this.zzb, com.google.android.gms.ads.internal.zzt.zzt().zzb(), new zzbld(this, zzcblVar), new zzble(this, zzcblVar));
            this.zza.checkAvailabilityAndConnect();
            ListenableFuture listenableFutureZzo = zzfzt.zzo(zzfzt.zzn(zzcblVar, new zzblb(this, zzbktVar), zzcbg.zza), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzep)).intValue(), TimeUnit.MILLISECONDS, zzcbg.zzd);
            listenableFutureZzo.addListener(new zzblc(this), zzcbg.zza);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) listenableFutureZzo.get();
            com.google.android.gms.ads.internal.util.zze.zza("Http assets remote cache took " + (com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - jElapsedRealtime) + "ms");
            zzbkv zzbkvVar = (zzbkv) new zzbve(parcelFileDescriptor).zza(zzbkv.CREATOR);
            if (zzbkvVar == null) {
                return null;
            }
            if (zzbkvVar.zza) {
                throw new zzamp(zzbkvVar.zzb);
            }
            if (zzbkvVar.zze.length != zzbkvVar.zzf.length) {
                return null;
            }
            HashMap map = new HashMap();
            while (true) {
                String[] strArr3 = zzbkvVar.zze;
                if (i >= strArr3.length) {
                    return new zzamc(zzbkvVar.zzc, zzbkvVar.zzd, map, zzbkvVar.zzg, zzbkvVar.zzh);
                }
                map.put(strArr3[i], zzbkvVar.zzf[i]);
                i++;
            }
        } catch (InterruptedException | ExecutionException unused) {
            com.google.android.gms.ads.internal.util.zze.zza("Http assets remote cache took " + (com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - jElapsedRealtime) + "ms");
            return null;
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.zze.zza("Http assets remote cache took " + (com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - jElapsedRealtime) + "ms");
            throw th;
        }
    }
}
