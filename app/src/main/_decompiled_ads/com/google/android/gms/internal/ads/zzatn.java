package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzatn extends zzaud {
    private final zzash zzi;

    public zzatn(zzasp zzaspVar, String str, String str2, zzaom zzaomVar, int i, int i2, zzash zzashVar) {
        super(zzaspVar, "tfuuP59pzWN+H8zv1geT3jADiBKBGMQRjmCPoIvL5f45Lvl5qgJ0PgBqZF4WPnQj", "MIrDuKB7N0O22daoYjLtFOJg5TtVRHK1+0ktwmGNtdU=", zzaomVar, i, 94);
        this.zzi = zzashVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaud
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        int iIntValue = ((Integer) this.zzf.invoke(null, this.zzi.zza())).intValue();
        synchronized (this.zze) {
            this.zze.zzae(zzapa.zza(iIntValue));
        }
    }
}
