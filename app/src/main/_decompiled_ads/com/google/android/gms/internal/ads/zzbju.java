package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.webkit.ProxyConfig;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.tapjoy.TJAdUnitConstants;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbju implements zzbjj {
    private final com.google.android.gms.ads.internal.zzb zza;
    private final zzdso zzb;
    private final zzfib zzc;
    private final zzbrs zze;
    private final zzedo zzf;
    private final zzcou zzg;
    private com.google.android.gms.ads.internal.overlay.zzx zzh = null;
    private final zzgad zzi = zzcbg.zzf;
    private final zzcay zzd = new zzcay(null);

    public zzbju(com.google.android.gms.ads.internal.zzb zzbVar, zzbrs zzbrsVar, zzedo zzedoVar, zzdso zzdsoVar, zzfib zzfibVar, zzcou zzcouVar) {
        this.zza = zzbVar;
        this.zze = zzbrsVar;
        this.zzf = zzedoVar;
        this.zzb = zzdsoVar;
        this.zzc = zzfibVar;
        this.zzg = zzcouVar;
    }

    public static int zzb(Map map) {
        String str = (String) map.get("o");
        if (str == null) {
            return -1;
        }
        if ("p".equalsIgnoreCase(str)) {
            return 7;
        }
        if ("l".equalsIgnoreCase(str)) {
            return 6;
        }
        return "c".equalsIgnoreCase(str) ? 14 : -1;
    }

    static Uri zzc(Context context, zzaro zzaroVar, Uri uri, View view, Activity activity) {
        if (zzaroVar == null) {
            return uri;
        }
        try {
            return zzaroVar.zze(uri) ? zzaroVar.zza(uri, context, view, activity) : uri;
        } catch (zzarp unused) {
            return uri;
        } catch (Exception e) {
            com.google.android.gms.ads.internal.zzt.zzo().zzu(e, "OpenGmsgHandler.maybeAddClickSignalsToUri");
            return uri;
        }
    }

    static Uri zzd(Uri uri) {
        try {
            if (uri.getQueryParameter("aclk_ms") != null) {
                return uri.buildUpon().appendQueryParameter("aclk_upms", String.valueOf(SystemClock.uptimeMillis())).build();
            }
        } catch (UnsupportedOperationException e) {
            zzcat.zzh("Error adding click uptime parameter to url: ".concat(String.valueOf(uri.toString())), e);
        }
        return uri;
    }

    public static boolean zzf(Map map) {
        return "1".equals(map.get("custom_close"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:126:0x02fc  */
    public final void zzh(String str, com.google.android.gms.ads.internal.client.zza zzaVar, Map map, String str2) {
        String str3;
        boolean z;
        Object obj;
        zzcgb zzcgbVar = (zzcgb) zzaVar;
        zzfcr zzfcrVarZzD = zzcgbVar.zzD();
        zzfcv zzfcvVarZzP = zzcgbVar.zzP();
        boolean z2 = false;
        if (zzfcrVarZzD == null || zzfcvVarZzP == null) {
            str3 = "";
            z = false;
        } else {
            String str4 = zzfcvVarZzP.zzb;
            z = zzfcrVarZzD.zzak;
            str3 = str4;
        }
        boolean z3 = (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzjS)).booleanValue() && map.containsKey("sc") && ((String) map.get("sc")).equals("0")) ? false : true;
        if ("expand".equalsIgnoreCase(str2)) {
            if (zzcgbVar.zzaA()) {
                zzcat.zzj("Cannot expand WebView that is already expanded.");
                return;
            } else {
                zzk(false);
                ((zzchg) zzaVar).zzaF(zzf(map), zzb(map), z3);
                return;
            }
        }
        if ("webapp".equalsIgnoreCase(str2)) {
            zzk(false);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzkQ)).booleanValue() && ((obj = map.get("is_allowed_for_lock_screen")) == "1" || (obj != null && obj.equals("1")))) {
                z2 = true;
            }
            if (str != null) {
                ((zzchg) zzaVar).zzaH(zzf(map), zzb(map), str, z3, z2);
                return;
            } else {
                ((zzchg) zzaVar).zzaG(zzf(map), zzb(map), (String) map.get(TJAdUnitConstants.String.HTML), (String) map.get("baseurl"), z3);
                return;
            }
        }
        if ("chrome_custom_tab".equalsIgnoreCase(str2)) {
            Context context = zzcgbVar.getContext();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzes)).booleanValue()) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzey)).booleanValue()) {
                    com.google.android.gms.ads.internal.util.zze.zza("User opt out chrome custom tab.");
                } else {
                    if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzew)).booleanValue()) {
                        z2 = true;
                        break;
                    }
                    String str5 = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzex);
                    if (!str5.isEmpty() && context != null) {
                        String packageName = context.getPackageName();
                        Iterator it = zzftj.zzc(zzfsh.zzc(';')).zzd(str5).iterator();
                        while (it.hasNext()) {
                            if (((String) it.next()).equals(packageName)) {
                                z2 = true;
                                break;
                            }
                        }
                    }
                }
            }
            boolean zZzg = zzbdj.zzg(zzcgbVar.getContext());
            if (z2) {
                if (zZzg) {
                    zzk(true);
                    if (TextUtils.isEmpty(str)) {
                        zzcat.zzj("Cannot open browser with null or empty url");
                        zzm(7);
                        return;
                    }
                    Uri uriZzd = zzd(zzc(zzcgbVar.getContext(), zzcgbVar.zzI(), Uri.parse(str), zzcgbVar.zzF(), zzcgbVar.zzi()));
                    if (z && this.zzf != null && zzl(zzaVar, zzcgbVar.getContext(), uriZzd.toString(), str3)) {
                        return;
                    }
                    this.zzh = new zzbjr(this);
                    ((zzchg) zzaVar).zzaD(new com.google.android.gms.ads.internal.overlay.zzc(null, uriZzd.toString(), null, null, null, null, null, null, ObjectWrapper.wrap(this.zzh).asBinder(), true), z3);
                    return;
                }
                zzm(4);
            }
            map.put("use_first_package", "true");
            map.put("use_running_process", "true");
            zzj(zzaVar, map, z, str3, z3);
            return;
        }
        if ("app".equalsIgnoreCase(str2) && "true".equalsIgnoreCase((String) map.get("system_browser"))) {
            zzj(zzaVar, map, z, str3, z3);
            return;
        }
        if ("open_app".equalsIgnoreCase(str2)) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzhY)).booleanValue()) {
                zzk(true);
                String str6 = (String) map.get("p");
                if (str6 == null) {
                    zzcat.zzj("Package name missing from open app action.");
                    return;
                }
                if (z && this.zzf != null && zzl(zzaVar, zzcgbVar.getContext(), str6, str3)) {
                    return;
                }
                PackageManager packageManager = zzcgbVar.getContext().getPackageManager();
                if (packageManager == null) {
                    zzcat.zzj("Cannot get package manager from open app action.");
                    return;
                }
                Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str6);
                if (launchIntentForPackage != null) {
                    ((zzchg) zzaVar).zzaD(new com.google.android.gms.ads.internal.overlay.zzc(launchIntentForPackage, this.zzh), z3);
                    return;
                }
                return;
            }
            return;
        }
        zzk(true);
        String str7 = (String) map.get("intent_url");
        Intent uri = null;
        if (!TextUtils.isEmpty(str7)) {
            try {
                uri = Intent.parseUri(str7, 0);
            } catch (URISyntaxException e) {
                zzcat.zzh("Error parsing the url: ".concat(String.valueOf(str7)), e);
            }
        }
        Intent intent = uri;
        if (intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            if (!Uri.EMPTY.equals(data)) {
                Uri uriZzd2 = zzd(zzc(zzcgbVar.getContext(), zzcgbVar.zzI(), data, zzcgbVar.zzF(), zzcgbVar.zzi()));
                if (TextUtils.isEmpty(intent.getType())) {
                    intent.setData(uriZzd2);
                } else if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzhZ)).booleanValue()) {
                    intent.setDataAndType(uriZzd2, intent.getType());
                } else {
                    intent.setData(uriZzd2);
                }
            }
        }
        boolean z4 = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzin)).booleanValue() && "intent_async".equalsIgnoreCase(str2) && map.containsKey("event_id");
        HashMap map2 = new HashMap();
        if (z4) {
            this.zzh = new zzbjs(this, z3, zzaVar, map2, map);
            z3 = false;
        }
        if (intent != null) {
            if (!z || this.zzf == null || !zzl(zzaVar, zzcgbVar.getContext(), intent.getData().toString(), str3)) {
                ((zzchg) zzaVar).zzaD(new com.google.android.gms.ads.internal.overlay.zzc(intent, this.zzh), z3);
                return;
            } else {
                if (z4) {
                    map2.put((String) map.get("event_id"), true);
                    ((zzbmd) zzaVar).zzd("openIntentAsync", map2);
                    return;
                }
                return;
            }
        }
        String string = !TextUtils.isEmpty(str) ? zzd(zzc(zzcgbVar.getContext(), zzcgbVar.zzI(), Uri.parse(str), zzcgbVar.zzF(), zzcgbVar.zzi())).toString() : str;
        if (!z || this.zzf == null || !zzl(zzaVar, zzcgbVar.getContext(), string, str3)) {
            ((zzchg) zzaVar).zzaD(new com.google.android.gms.ads.internal.overlay.zzc((String) map.get("i"), string, (String) map.get(InneractiveMediationDefs.GENDER_MALE), (String) map.get("p"), (String) map.get("c"), (String) map.get(InneractiveMediationDefs.GENDER_FEMALE), (String) map.get("e"), this.zzh), z3);
        } else if (z4) {
            map2.put((String) map.get("event_id"), true);
            ((zzbmd) zzaVar).zzd("openIntentAsync", map2);
        }
    }

    private final void zzi(Context context, String str, String str2) {
        this.zzf.zzc(str);
        zzdso zzdsoVar = this.zzb;
        if (zzdsoVar != null) {
            zzedz.zzc(context, zzdsoVar, this.zzc, this.zzf, str, "dialog_not_shown", zzfvv.zze("dialog_not_shown_reason", str2));
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:31:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:44:0x0125 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:45:0x0127  */
    /* JADX WARN: Code duplicated, block: B:46:0x0133  */
    private final void zzj(com.google.android.gms.ads.internal.client.zza zzaVar, Map map, boolean z, String str, boolean z2) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ResolveInfo resolveInfoZzc;
        boolean z3 = true;
        zzk(true);
        zzcgb zzcgbVar = (zzcgb) zzaVar;
        Context context = zzcgbVar.getContext();
        zzaro zzaroVarZzI = zzcgbVar.zzI();
        View viewZzF = zzcgbVar.zzF();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        String str2 = (String) map.get("u");
        Intent intentZzb = null;
        Uri uriBuild = null;
        if (!TextUtils.isEmpty(str2)) {
            Uri uriZzd = zzd(zzc(context, zzaroVarZzI, Uri.parse(str2), viewZzF, null));
            boolean z4 = Boolean.parseBoolean((String) map.get("use_first_package"));
            boolean z5 = Boolean.parseBoolean((String) map.get("use_running_process"));
            if (!Boolean.parseBoolean((String) map.get("use_custom_tabs"))) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzeq)).booleanValue()) {
                    z3 = false;
                }
            }
            if (ProxyConfig.MATCH_HTTP.equalsIgnoreCase(uriZzd.getScheme())) {
                uriBuild = uriZzd.buildUpon().scheme("https").build();
            } else if ("https".equalsIgnoreCase(uriZzd.getScheme())) {
                uriBuild = uriZzd.buildUpon().scheme(ProxyConfig.MATCH_HTTP).build();
            }
            ArrayList arrayList = new ArrayList();
            Intent intentZza = zzbjt.zza(uriZzd, context, zzaroVarZzI, viewZzF);
            Intent intentZza2 = zzbjt.zza(uriBuild, context, zzaroVarZzI, viewZzF);
            if (z3) {
                com.google.android.gms.ads.internal.zzt.zzp();
                com.google.android.gms.ads.internal.util.zzt.zzo(context, intentZza);
                com.google.android.gms.ads.internal.zzt.zzp();
                com.google.android.gms.ads.internal.util.zzt.zzo(context, intentZza2);
            }
            ResolveInfo resolveInfoZzd = zzbjt.zzd(intentZza, arrayList, context, zzaroVarZzI, viewZzF);
            if (resolveInfoZzd != null) {
                intentZzb = zzbjt.zzb(intentZza, resolveInfoZzd, context, zzaroVarZzI, viewZzF);
            } else if (intentZza2 != null && (resolveInfoZzc = zzbjt.zzc(intentZza2, context, zzaroVarZzI, viewZzF)) != null) {
                intentZzb = zzbjt.zzb(intentZza, resolveInfoZzc, context, zzaroVarZzI, viewZzF);
                if (zzbjt.zzc(intentZzb, context, zzaroVarZzI, viewZzF) == null) {
                    if (!arrayList.isEmpty()) {
                        intentZzb = intentZza;
                    } else if (!z5) {
                        if (z4) {
                            intentZzb = zzbjt.zzb(intentZza, (ResolveInfo) arrayList.get(0), context, zzaroVarZzI, viewZzF);
                        } else {
                            intentZzb = intentZza;
                        }
                    } else if (z4) {
                        intentZzb = zzbjt.zzb(intentZza, (ResolveInfo) arrayList.get(0), context, zzaroVarZzI, viewZzF);
                    } else {
                        intentZzb = intentZza;
                    }
                }
            } else if (!arrayList.isEmpty()) {
                intentZzb = intentZza;
            } else if (!z5 && activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    if (i < size) {
                        ResolveInfo resolveInfo = (ResolveInfo) arrayList.get(i);
                        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                        while (true) {
                            int i2 = i + 1;
                            if (!it.hasNext()) {
                                i = i2;
                            } else if (it.next().processName.equals(resolveInfo.activityInfo.packageName)) {
                                intentZzb = zzbjt.zzb(intentZza, resolveInfo, context, zzaroVarZzI, viewZzF);
                            }
                        }
                    } else if (z4) {
                        intentZzb = zzbjt.zzb(intentZza, (ResolveInfo) arrayList.get(0), context, zzaroVarZzI, viewZzF);
                    } else {
                        intentZzb = intentZza;
                    }
                }
            } else if (z4) {
                intentZzb = zzbjt.zzb(intentZza, (ResolveInfo) arrayList.get(0), context, zzaroVarZzI, viewZzF);
            } else {
                intentZzb = intentZza;
            }
        }
        if (!z || this.zzf == null || intentZzb == null || !zzl(zzaVar, zzcgbVar.getContext(), intentZzb.getData().toString(), str)) {
            try {
                ((zzchg) zzaVar).zzaD(new com.google.android.gms.ads.internal.overlay.zzc(intentZzb, this.zzh), z2);
            } catch (ActivityNotFoundException e) {
                zzcat.zzj(e.getMessage());
            }
        }
    }

    private final void zzk(boolean z) {
        zzbrs zzbrsVar = this.zze;
        if (zzbrsVar != null) {
            zzbrsVar.zza(z);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x008d, code lost:
    
        if (r2 != false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean zzl(com.google.android.gms.ads.internal.client.zza r9, android.content.Context r10, java.lang.String r11, java.lang.String r12) {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbju.zzl(com.google.android.gms.ads.internal.client.zza, android.content.Context, java.lang.String, java.lang.String):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzm(int i) {
        if (this.zzb == null) {
            return;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzir)).booleanValue()) {
            zzdsn zzdsnVarZza = this.zzb.zza();
            zzdsnVarZza.zzb("action", "cct_action");
            zzdsnVarZza.zzb("cct_open_status", zzbdi.zza(i));
            zzdsnVarZza.zzg();
            return;
        }
        zzfib zzfibVar = this.zzc;
        String strZza = zzbdi.zza(i);
        zzfia zzfiaVarZzb = zzfia.zzb("cct_action");
        zzfiaVarZzb.zza("cct_open_status", strZza);
        zzfibVar.zzb(zzfiaVarZzb);
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcou zzcouVar;
        com.google.android.gms.ads.internal.client.zza zzaVar = (com.google.android.gms.ads.internal.client.zza) obj;
        String strZzc = zzbza.zzc((String) map.get("u"), ((zzcgb) zzaVar).getContext(), true);
        String str = (String) map.get("a");
        if (str == null) {
            zzcat.zzj("Action missing from an open GMSG.");
            return;
        }
        com.google.android.gms.ads.internal.zzb zzbVar = this.zza;
        if (zzbVar == null || zzbVar.zzc()) {
            zzfzt.zzr((!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzju)).booleanValue() || (zzcouVar = this.zzg) == null) ? zzfzt.zzh(strZzc) : zzcouVar.zzc(strZzc, com.google.android.gms.ads.internal.client.zzay.zze()), new zzbjq(this, zzaVar, map, str), this.zzi);
        } else {
            zzbVar.zzb(strZzc);
        }
    }
}
