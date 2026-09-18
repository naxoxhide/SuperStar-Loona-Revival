package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgby {
    private final Class zza;
    private zzgbz zzd;
    private ConcurrentMap zzb = new ConcurrentHashMap();
    private final List zzc = new ArrayList();
    private zzgmc zze = zzgmc.zza;

    /* synthetic */ zzgby(Class cls, zzgbx zzgbxVar) {
        this.zza = cls;
    }

    private final zzgby zze(@Nullable Object obj, @Nullable Object obj2, zzgpl zzgplVar, boolean z) throws GeneralSecurityException {
        byte[] bArrArray;
        if (this.zzb == null) {
            throw new IllegalStateException("addPrimitive cannot be called after build");
        }
        if (obj == null && obj2 == null) {
            throw new GeneralSecurityException("at least one of the `fullPrimitive` or `primitive` must be set");
        }
        if (zzgplVar.zzk() != 3) {
            throw new GeneralSecurityException("only ENABLED key is allowed");
        }
        Integer numValueOf = Integer.valueOf(zzgplVar.zza());
        if (zzgplVar.zzf() == zzgqf.RAW) {
            numValueOf = null;
        }
        zzgbe zzgbeVarZza = zzgii.zzb().zza(zzgjc.zza(zzgplVar.zzc().zzg(), zzgplVar.zzc().zzf(), zzgplVar.zzc().zzc(), zzgplVar.zzf(), numValueOf), zzgch.zza());
        int iOrdinal = zzgplVar.zzf().ordinal();
        if (iOrdinal == 1) {
            bArrArray = ByteBuffer.allocate(5).put((byte) 1).putInt(zzgplVar.zza()).array();
        } else if (iOrdinal == 2) {
            bArrArray = ByteBuffer.allocate(5).put((byte) 0).putInt(zzgplVar.zza()).array();
        } else if (iOrdinal != 3) {
            if (iOrdinal != 4) {
                throw new GeneralSecurityException("unknown output prefix type");
            }
            bArrArray = ByteBuffer.allocate(5).put((byte) 0).putInt(zzgplVar.zza()).array();
        } else {
            bArrArray = zzgbc.zza;
        }
        zzgbz zzgbzVar = new zzgbz(obj, obj2, bArrArray, zzgplVar.zzk(), zzgplVar.zzf(), zzgplVar.zza(), zzgplVar.zzc().zzg(), zzgbeVarZza);
        ConcurrentMap concurrentMap = this.zzb;
        List list = this.zzc;
        ArrayList arrayList = new ArrayList();
        arrayList.add(zzgbzVar);
        zzgcb zzgcbVar = new zzgcb(zzgbzVar.zzg(), null);
        List list2 = (List) concurrentMap.put(zzgcbVar, Collections.unmodifiableList(arrayList));
        if (list2 != null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(list2);
            arrayList2.add(zzgbzVar);
            concurrentMap.put(zzgcbVar, Collections.unmodifiableList(arrayList2));
        }
        list.add(zzgbzVar);
        if (z) {
            if (this.zzd != null) {
                throw new IllegalStateException("you cannot set two primary primitives");
            }
            this.zzd = zzgbzVar;
        }
        return this;
    }

    public final zzgby zza(@Nullable Object obj, @Nullable Object obj2, zzgpl zzgplVar) throws GeneralSecurityException {
        zze(obj, obj2, zzgplVar, false);
        return this;
    }

    public final zzgby zzb(@Nullable Object obj, @Nullable Object obj2, zzgpl zzgplVar) throws GeneralSecurityException {
        zze(obj, obj2, zzgplVar, true);
        return this;
    }

    public final zzgby zzc(zzgmc zzgmcVar) {
        if (this.zzb == null) {
            throw new IllegalStateException("setAnnotations cannot be called after build");
        }
        this.zze = zzgmcVar;
        return this;
    }

    public final zzgcd zzd() throws GeneralSecurityException {
        ConcurrentMap concurrentMap = this.zzb;
        if (concurrentMap == null) {
            throw new IllegalStateException("build cannot be called twice");
        }
        zzgcd zzgcdVar = new zzgcd(concurrentMap, this.zzc, this.zzd, this.zze, this.zza, null);
        this.zzb = null;
        return zzgcdVar;
    }
}
