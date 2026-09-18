package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.common.util.concurrent.ListenableFuture;
import com.tapjoy.TJAdUnitConstants;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzert implements zzetw {
    private final zzgad zza;
    private final zzfdn zzb;
    private final PackageInfo zzc;
    private final com.google.android.gms.ads.internal.util.zzg zzd;

    public zzert(zzgad zzgadVar, zzfdn zzfdnVar, PackageInfo packageInfo, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zza = zzgadVar;
        this.zzb = zzfdnVar;
        this.zzc = packageInfo;
        this.zzd = zzgVar;
    }

    public static /* synthetic */ zzeru zzc(final zzert zzertVar) {
        final ArrayList arrayList = zzertVar.zzb.zzg;
        if (arrayList == null) {
            return new zzeru() { // from class: com.google.android.gms.internal.ads.zzerq
                @Override // com.google.android.gms.internal.ads.zzetv
                public final void zzj(Object obj) {
                }
            };
        }
        return arrayList.isEmpty() ? new zzeru() { // from class: com.google.android.gms.internal.ads.zzerr
            @Override // com.google.android.gms.internal.ads.zzetv
            public final void zzj(Object obj) {
                ((Bundle) obj).putInt("native_version", 0);
            }
        } : new zzeru() { // from class: com.google.android.gms.internal.ads.zzers
            @Override // com.google.android.gms.internal.ads.zzetv
            public final void zzj(Object obj) {
                this.zza.zzd(arrayList, (Bundle) obj);
            }
        };
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final int zza() {
        return 26;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzerp
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzert.zzc(this.zza);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:63:0x011e  */
    final /* synthetic */ void zzd(ArrayList arrayList, Bundle bundle) {
        JSONArray jSONArrayOptJSONArray;
        String str;
        bundle.putInt("native_version", 3);
        bundle.putStringArrayList("native_templates", arrayList);
        bundle.putStringArrayList("native_custom_templates", this.zzb.zzh);
        int i = this.zzb.zzi.zza;
        String str2 = TJAdUnitConstants.String.LANDSCAPE;
        if (i > 3) {
            bundle.putBoolean("enable_native_media_orientation", true);
            int i2 = this.zzb.zzi.zzh;
            if (i2 == 1) {
                str = "any";
            } else if (i2 == 2) {
                str = TJAdUnitConstants.String.LANDSCAPE;
            } else if (i2 != 3) {
                str = i2 != 4 ? "unknown" : "square";
            } else {
                str = TJAdUnitConstants.String.PORTRAIT;
            }
            if (!"unknown".equals(str)) {
                bundle.putString("native_media_orientation", str);
            }
        }
        int i3 = this.zzb.zzi.zzc;
        if (i3 == 0) {
            str2 = "any";
        } else if (i3 == 1) {
            str2 = TJAdUnitConstants.String.PORTRAIT;
        } else if (i3 != 2) {
            str2 = "unknown";
        }
        if (!"unknown".equals(str2)) {
            bundle.putString("native_image_orientation", str2);
        }
        bundle.putBoolean("native_multiple_images", this.zzb.zzi.zzd);
        bundle.putBoolean("use_custom_mute", this.zzb.zzi.zzg);
        zzbfc zzbfcVar = this.zzb.zzi;
        if (zzbfcVar.zzi != 0) {
            bundle.putBoolean("sccg_tap", zzbfcVar.zzj);
            bundle.putInt("sccg_dir", this.zzb.zzi.zzi);
        }
        PackageInfo packageInfo = this.zzc;
        int i4 = packageInfo == null ? 0 : packageInfo.versionCode;
        if (i4 > this.zzd.zza()) {
            this.zzd.zzs();
            this.zzd.zzv(i4);
        }
        JSONObject jSONObjectZzp = this.zzd.zzp();
        String string = null;
        if (jSONObjectZzp != null && (jSONArrayOptJSONArray = jSONObjectZzp.optJSONArray(this.zzb.zzf)) != null) {
            string = jSONArrayOptJSONArray.toString();
        }
        if (!TextUtils.isEmpty(string)) {
            bundle.putString("native_advanced_settings", string);
        }
        int i5 = this.zzb.zzk;
        if (i5 > 1) {
            bundle.putInt("max_num_ads", i5);
        }
        zzbls zzblsVar = this.zzb.zzb;
        if (zzblsVar != null) {
            if (TextUtils.isEmpty(zzblsVar.zzc)) {
                String str3 = "p";
                if (zzblsVar.zza >= 2) {
                    int i6 = zzblsVar.zzd;
                    if (i6 == 2 || i6 != 3) {
                        str3 = "l";
                    }
                } else {
                    int i7 = zzblsVar.zzb;
                    if (i7 == 1) {
                        str3 = "l";
                    } else if (i7 != 2) {
                        zzcat.zzg("Instream ad video aspect ratio " + i7 + " is wrong.");
                        str3 = "l";
                    }
                }
                bundle.putString("ia_var", str3);
            } else {
                bundle.putString("ad_tag", zzblsVar.zzc);
            }
            bundle.putBoolean("instr", true);
        }
        if (this.zzb.zza() != null) {
            bundle.putBoolean("has_delayed_banner_listener", true);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzkN)).booleanValue()) {
            if (this.zzb.zzi.zzf != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("startMuted", this.zzb.zzi.zzf.zza);
                bundle2.putBoolean("clickToExpandRequested", this.zzb.zzi.zzf.zzc);
                bundle2.putBoolean("customControlsRequested", this.zzb.zzi.zzf.zzb);
                bundle.putBundle("video", bundle2);
            }
            bundle.putBoolean("disable_image_loading", this.zzb.zzi.zzb);
            bundle.putInt("preferred_ad_choices_position", this.zzb.zzi.zze);
        }
    }
}
