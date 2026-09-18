package com.google.android.gms.internal.ads;

import androidx.core.view.PointerIconCompat;
import com.facebook.ads.AdError;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzhb extends zzgj {
    public final zzgn zzb;
    public final int zzc;

    public zzhb(zzgn zzgnVar, int i, int i2) {
        super(zzb(AdError.REMOTE_ADS_SERVICE_ERROR, 1));
        this.zzb = zzgnVar;
        this.zzc = 1;
    }

    public static zzhb zza(IOException iOException, zzgn zzgnVar, int i) {
        String message = iOException.getMessage();
        boolean z = iOException instanceof SocketTimeoutException;
        int i2 = AdError.INTERNAL_ERROR_CODE;
        if (z) {
            i2 = AdError.CACHE_ERROR_CODE;
        } else if (iOException instanceof InterruptedIOException) {
            i2 = PointerIconCompat.TYPE_WAIT;
        } else if (message != null && zzfsc.zza(message).matches("cleartext.*not permitted.*")) {
            i2 = 2007;
        }
        return i2 == 2007 ? new zzha(iOException, zzgnVar) : new zzhb(iOException, zzgnVar, i2, i);
    }

    private static int zzb(int i, int i2) {
        if (i != 2000) {
            return i;
        }
        if (i2 != 1) {
            return 2000;
        }
        return AdError.INTERNAL_ERROR_CODE;
    }

    public zzhb(IOException iOException, zzgn zzgnVar, int i, int i2) {
        super(iOException, zzb(i, i2));
        this.zzb = zzgnVar;
        this.zzc = i2;
    }

    public zzhb(String str, zzgn zzgnVar, int i, int i2) {
        super(str, zzb(i, i2));
        this.zzb = zzgnVar;
        this.zzc = i2;
    }

    public zzhb(String str, IOException iOException, zzgn zzgnVar, int i, int i2) {
        super(str, iOException, zzb(i, i2));
        this.zzb = zzgnVar;
        this.zzc = i2;
    }
}
