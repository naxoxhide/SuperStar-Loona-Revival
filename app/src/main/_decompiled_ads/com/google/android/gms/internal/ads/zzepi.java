package com.google.android.gms.internal.ads;

import android.os.Build;
import android.os.Bundle;
import android.os.ext.SdkExtensions;
import javax.annotation.Nullable;
import kotlin.time.DurationKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzepi implements zzetv {

    @Nullable
    private final Integer zza;

    private zzepi(@Nullable Integer num) {
        this.zza = num;
    }

    static /* bridge */ /* synthetic */ zzepi zzb() {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzju)).booleanValue()) {
            return new zzepi(null);
        }
        com.google.android.gms.ads.internal.zzt.zzp();
        int extensionVersion = 0;
        if (Build.VERSION.SDK_INT >= 30 && SdkExtensions.getExtensionVersion(30) > 3) {
            extensionVersion = SdkExtensions.getExtensionVersion(DurationKt.NANOS_IN_MILLIS);
        }
        return new zzepi(Integer.valueOf(extensionVersion));
    }

    @Override // com.google.android.gms.internal.ads.zzetv
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Integer num = this.zza;
        Bundle bundle = (Bundle) obj;
        if (num != null) {
            bundle.putInt("aos", num.intValue());
        }
    }
}
