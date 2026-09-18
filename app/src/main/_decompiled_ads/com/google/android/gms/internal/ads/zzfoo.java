package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.facebook.ads.AdError;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.security.GeneralSecurityException;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfoo {
    private static final HashMap zza = new HashMap();
    private final Context zzb;
    private final zzfop zzc;
    private final zzfmq zzd;
    private final zzfml zze;
    private zzfod zzf;
    private final Object zzg = new Object();

    public zzfoo(Context context, zzfop zzfopVar, zzfmq zzfmqVar, zzfml zzfmlVar) {
        this.zzb = context;
        this.zzc = zzfopVar;
        this.zzd = zzfmqVar;
        this.zze = zzfmlVar;
    }

    private final synchronized Class zzd(zzfoe zzfoeVar) throws zzfon {
        String strZzk = zzfoeVar.zza().zzk();
        HashMap map = zza;
        Class cls = (Class) map.get(strZzk);
        if (cls != null) {
            return cls;
        }
        try {
            if (!this.zze.zza(zzfoeVar.zzc())) {
                throw new zzfon(2026, "VM did not pass signature verification");
            }
            try {
                File fileZzb = zzfoeVar.zzb();
                if (!fileZzb.exists()) {
                    fileZzb.mkdirs();
                }
                Class clsLoadClass = new DexClassLoader(zzfoeVar.zzc().getAbsolutePath(), fileZzb.getAbsolutePath(), null, this.zzb.getClassLoader()).loadClass("com.google.ccc.abuse.droidguard.DroidGuard");
                map.put(strZzk, clsLoadClass);
                return clsLoadClass;
            } catch (ClassNotFoundException | IllegalArgumentException | SecurityException e) {
                throw new zzfon(AdError.REMOTE_ADS_SERVICE_ERROR, e);
            }
        } catch (GeneralSecurityException e2) {
            throw new zzfon(2026, e2);
        }
    }

    public final zzfmt zza() {
        zzfod zzfodVar;
        synchronized (this.zzg) {
            zzfodVar = this.zzf;
        }
        return zzfodVar;
    }

    public final zzfoe zzb() {
        synchronized (this.zzg) {
            zzfod zzfodVar = this.zzf;
            if (zzfodVar == null) {
                return null;
            }
            return zzfodVar.zzf();
        }
    }

    public final boolean zzc(zzfoe zzfoeVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                zzfod zzfodVar = new zzfod(zzd(zzfoeVar).getDeclaredConstructor(Context.class, String.class, byte[].class, Object.class, Bundle.class, Integer.TYPE).newInstance(this.zzb, "msa-r", zzfoeVar.zze(), null, new Bundle(), 2), zzfoeVar, this.zzc, this.zzd);
                if (!zzfodVar.zzh()) {
                    throw new zzfon(4000, "init failed");
                }
                int iZze = zzfodVar.zze();
                if (iZze != 0) {
                    throw new zzfon(4001, "ci: " + iZze);
                }
                synchronized (this.zzg) {
                    zzfod zzfodVar2 = this.zzf;
                    if (zzfodVar2 != null) {
                        try {
                            zzfodVar2.zzg();
                        } catch (zzfon e) {
                            this.zzd.zzc(e.zza(), -1L, e);
                        }
                        this.zzf = zzfodVar;
                    } else {
                        this.zzf = zzfodVar;
                    }
                    throw th;
                }
                this.zzd.zzd(3000, System.currentTimeMillis() - jCurrentTimeMillis);
                return true;
            } catch (Exception e2) {
                throw new zzfon(AdError.INTERNAL_ERROR_2004, e2);
            }
        } catch (zzfon e3) {
            this.zzd.zzc(e3.zza(), System.currentTimeMillis() - jCurrentTimeMillis, e3);
            return false;
        } catch (Exception e4) {
            this.zzd.zzc(4010, System.currentTimeMillis() - jCurrentTimeMillis, e4);
            return false;
        }
    }
}
