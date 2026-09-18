package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzanq extends zzhan implements Closeable {
    private static final zzhau zza = zzhau.zzb(zzanq.class);

    public zzanq(zzhao zzhaoVar, zzanp zzanpVar) throws IOException {
        zzf(zzhaoVar, zzhaoVar.zzc(), zzanpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhan, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }

    @Override // com.google.android.gms.internal.ads.zzhan
    public final String toString() {
        String string = this.zzd.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 7);
        sb.append("model(");
        sb.append(string);
        sb.append(")");
        return sb.toString();
    }
}
