package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeem implements zzeen {
    static /* synthetic */ zzfkc zzc(String str, String str2, String str3, zzeeo zzeeoVar, String str4, WebView webView, String str5, String str6, zzeep zzeepVar) {
        zzfkm zzfkmVarZza = zzfkm.zza("Google", str2);
        zzfkl zzfklVarZzm = zzm("javascript");
        zzfkh zzfkhVarZzk = zzk(zzeeoVar.toString());
        if (zzfklVarZzm == zzfkl.NONE) {
            zzcat.zzj("Omid html session error; Unable to parse impression owner: javascript");
            return null;
        }
        if (zzfkhVarZzk == null) {
            zzcat.zzj("Omid html session error; Unable to parse creative type: ".concat(String.valueOf(String.valueOf(zzeeoVar))));
            return null;
        }
        zzfkl zzfklVarZzm2 = zzm(str4);
        if (zzfkhVarZzk == zzfkh.VIDEO && zzfklVarZzm2 == zzfkl.NONE) {
            zzcat.zzj("Omid html session error; Video events owner unknown for video creative: ".concat(String.valueOf(str4)));
            return null;
        }
        return zzfkc.zza(zzfkd.zza(zzfkhVarZzk, zzl(zzeepVar.toString()), zzfklVarZzm, zzfklVarZzm2, true), zzfke.zzb(zzfkmVarZza, webView, str5, ""));
    }

    static /* synthetic */ zzfkc zzd(String str, String str2, String str3, String str4, zzeeo zzeeoVar, WebView webView, String str5, String str6, zzeep zzeepVar) {
        zzfkm zzfkmVarZza = zzfkm.zza(str, str2);
        zzfkl zzfklVarZzm = zzm("javascript");
        zzfkl zzfklVarZzm2 = zzm(str4);
        zzfkh zzfkhVarZzk = zzk(zzeeoVar.toString());
        if (zzfklVarZzm == zzfkl.NONE) {
            zzcat.zzj("Omid js session error; Unable to parse impression owner: javascript");
            return null;
        }
        if (zzfkhVarZzk == null) {
            zzcat.zzj("Omid js session error; Unable to parse creative type: ".concat(String.valueOf(String.valueOf(zzeeoVar))));
            return null;
        }
        if (zzfkhVarZzk == zzfkh.VIDEO && zzfklVarZzm2 == zzfkl.NONE) {
            zzcat.zzj("Omid js session error; Video events owner unknown for video creative: ".concat(String.valueOf(str4)));
            return null;
        }
        return zzfkc.zza(zzfkd.zza(zzfkhVarZzk, zzl(zzeepVar.toString()), zzfklVarZzm, zzfklVarZzm2, true), zzfke.zzc(zzfkmVarZza, webView, str5, ""));
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0034  */
    private static zzfkh zzk(String str) {
        byte b2;
        int iHashCode = str.hashCode();
        if (iHashCode != -382745961) {
            if (iHashCode != 112202875) {
                if (iHashCode == 714893483 && str.equals("nativeDisplay")) {
                    b2 = 1;
                } else {
                    b2 = -1;
                }
            } else if (str.equals("video")) {
                b2 = 2;
            } else {
                b2 = -1;
            }
        } else if (str.equals("htmlDisplay")) {
            b2 = 0;
        } else {
            b2 = -1;
        }
        if (b2 == 0) {
            return zzfkh.HTML_DISPLAY;
        }
        if (b2 == 1) {
            return zzfkh.NATIVE_DISPLAY;
        }
        if (b2 != 2) {
            return null;
        }
        return zzfkh.VIDEO;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0034  */
    private static zzfkk zzl(String str) {
        byte b2;
        int iHashCode = str.hashCode();
        if (iHashCode != -1104128070) {
            if (iHashCode != 1318088141) {
                if (iHashCode == 1988248512 && str.equals("onePixel")) {
                    b2 = 2;
                } else {
                    b2 = -1;
                }
            } else if (str.equals("definedByJavascript")) {
                b2 = 1;
            } else {
                b2 = -1;
            }
        } else if (str.equals("beginToRender")) {
            b2 = 0;
        } else {
            b2 = -1;
        }
        if (b2 == 0) {
            return zzfkk.BEGIN_TO_RENDER;
        }
        if (b2 != 1) {
            return b2 != 2 ? zzfkk.UNSPECIFIED : zzfkk.ONE_PIXEL;
        }
        return zzfkk.DEFINED_BY_JAVASCRIPT;
    }

    private static zzfkl zzm(String str) {
        if ("native".equals(str)) {
            return zzfkl.NATIVE;
        }
        return "javascript".equals(str) ? zzfkl.JAVASCRIPT : zzfkl.NONE;
    }

    private static final Object zzn(zzeel zzeelVar) {
        try {
            return zzeelVar.zza();
        } catch (RuntimeException e) {
            com.google.android.gms.ads.internal.zzt.zzo().zzt(e, "omid exception");
            return null;
        }
    }

    private static final void zzo(Runnable runnable) {
        try {
            runnable.run();
        } catch (RuntimeException e) {
            com.google.android.gms.ads.internal.zzt.zzo().zzt(e, "omid exception");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeen
    public final zzfkc zza(final String str, final WebView webView, String str2, String str3, final String str4, final zzeep zzeepVar, final zzeeo zzeeoVar, final String str5) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzeS)).booleanValue() || !zzfka.zzb()) {
            return null;
        }
        final String str6 = "Google";
        final String str7 = "javascript";
        final String str8 = "";
        return (zzfkc) zzn(new zzeel(str6, str, str7, zzeeoVar, str4, webView, str5, str8, zzeepVar) { // from class: com.google.android.gms.internal.ads.zzeei
            public final /* synthetic */ String zzb;
            public final /* synthetic */ zzeeo zzd;
            public final /* synthetic */ String zze;
            public final /* synthetic */ WebView zzf;
            public final /* synthetic */ String zzg;
            public final /* synthetic */ zzeep zzi;
            public final /* synthetic */ String zza = "Google";
            public final /* synthetic */ String zzc = "javascript";
            public final /* synthetic */ String zzh = "";

            {
                this.zzb = str;
                this.zzd = zzeeoVar;
                this.zze = str4;
                this.zzf = webView;
                this.zzg = str5;
                this.zzi = zzeepVar;
            }

            @Override // com.google.android.gms.internal.ads.zzeel
            public final Object zza() {
                return zzeem.zzc(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeen
    public final zzfkc zzb(final String str, final WebView webView, String str2, String str3, final String str4, final String str5, final zzeep zzeepVar, final zzeeo zzeeoVar, final String str6) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzeS)).booleanValue() || !zzfka.zzb()) {
            return null;
        }
        final String str7 = "javascript";
        final String str8 = "";
        return (zzfkc) zzn(new zzeel(str5, str, str7, str4, zzeeoVar, webView, str6, str8, zzeepVar) { // from class: com.google.android.gms.internal.ads.zzeef
            public final /* synthetic */ String zza;
            public final /* synthetic */ String zzb;
            public final /* synthetic */ String zzd;
            public final /* synthetic */ zzeeo zze;
            public final /* synthetic */ WebView zzf;
            public final /* synthetic */ String zzg;
            public final /* synthetic */ zzeep zzi;
            public final /* synthetic */ String zzc = "javascript";
            public final /* synthetic */ String zzh = "";

            {
                this.zzd = str4;
                this.zze = zzeeoVar;
                this.zzf = webView;
                this.zzg = str6;
                this.zzi = zzeepVar;
            }

            @Override // com.google.android.gms.internal.ads.zzeel
            public final Object zza() {
                return zzeem.zzd(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeen
    public final String zze(Context context) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzeS)).booleanValue()) {
            return (String) zzn(new zzeel() { // from class: com.google.android.gms.internal.ads.zzeej
                @Override // com.google.android.gms.internal.ads.zzeel
                public final Object zza() {
                    return "a.1.4.8-google_20230803";
                }
            });
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzeen
    public final void zzf(final zzfkc zzfkcVar, final View view) {
        zzo(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeed
            @Override // java.lang.Runnable
            public final void run() {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzeS)).booleanValue() && zzfka.zzb()) {
                    zzfkcVar.zzb(view, zzfkj.NOT_VISIBLE, "Ad overlay");
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeen
    public final void zzg(final zzfkc zzfkcVar) {
        zzo(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeek
            @Override // java.lang.Runnable
            public final void run() {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzeS)).booleanValue() && zzfka.zzb()) {
                    zzfkcVar.zzc();
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeen
    public final void zzh(final zzfkc zzfkcVar, final View view) {
        zzo(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeee
            @Override // java.lang.Runnable
            public final void run() {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzeS)).booleanValue() && zzfka.zzb()) {
                    zzfkcVar.zzd(view);
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeen
    public final void zzi(final zzfkc zzfkcVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzeS)).booleanValue() && zzfka.zzb()) {
            zzfkcVar.getClass();
            zzo(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeeg
                @Override // java.lang.Runnable
                public final void run() {
                    zzfkcVar.zze();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeen
    public final boolean zzj(final Context context) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzeS)).booleanValue()) {
            Boolean bool = (Boolean) zzn(new zzeel() { // from class: com.google.android.gms.internal.ads.zzeeh
                @Override // com.google.android.gms.internal.ads.zzeel
                public final Object zza() {
                    if (zzfka.zzb()) {
                        return true;
                    }
                    zzfka.zza(context);
                    return Boolean.valueOf(zzfka.zzb());
                }
            });
            return bool != null && bool.booleanValue();
        }
        zzcat.zzj("Omid flag is disabled");
        return false;
    }
}
