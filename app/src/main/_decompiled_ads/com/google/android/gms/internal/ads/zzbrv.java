package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.ads.impl.R;
import com.google.common.net.HttpHeaders;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbrv extends zzbry {
    private final Map zza;
    private final Context zzb;

    public zzbrv(zzcgb zzcgbVar, Map map) {
        super(zzcgbVar, "storePicture");
        this.zza = map;
        this.zzb = zzcgbVar.zzi();
    }

    public final void zzb() {
        if (this.zzb == null) {
            zzg("Activity context is not available");
            return;
        }
        com.google.android.gms.ads.internal.zzt.zzp();
        if (!new zzbbs(this.zzb).zzc()) {
            zzg("Feature is not supported by the device.");
            return;
        }
        String str = (String) this.zza.get("iurl");
        if (TextUtils.isEmpty(str)) {
            zzg("Image url cannot be empty.");
            return;
        }
        if (!URLUtil.isValidUrl(str)) {
            zzg("Invalid image url: ".concat(String.valueOf(str)));
            return;
        }
        String lastPathSegment = Uri.parse(str).getLastPathSegment();
        com.google.android.gms.ads.internal.zzt.zzp();
        if (TextUtils.isEmpty(lastPathSegment) || !lastPathSegment.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)")) {
            zzg("Image type not recognized: ".concat(String.valueOf(lastPathSegment)));
            return;
        }
        Resources resourcesZzd = com.google.android.gms.ads.internal.zzt.zzo().zzd();
        com.google.android.gms.ads.internal.zzt.zzp();
        AlertDialog.Builder builderZzJ = com.google.android.gms.ads.internal.util.zzt.zzJ(this.zzb);
        builderZzJ.setTitle(resourcesZzd != null ? resourcesZzd.getString(R.string.s1) : "Save image");
        builderZzJ.setMessage(resourcesZzd != null ? resourcesZzd.getString(R.string.s2) : "Allow Ad to store image in Picture gallery?");
        builderZzJ.setPositiveButton(resourcesZzd != null ? resourcesZzd.getString(R.string.s3) : HttpHeaders.ACCEPT, new zzbrt(this, str, lastPathSegment));
        builderZzJ.setNegativeButton(resourcesZzd != null ? resourcesZzd.getString(R.string.s4) : "Decline", new zzbru(this));
        builderZzJ.create().show();
    }
}
