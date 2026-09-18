package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
@ParametersAreNonnullByDefault
public final class zzdlk implements zzdjr {
    private final zzbpm zza;
    private final zzcyd zzb;
    private final zzcxj zzc;
    private final zzdfb zzd;
    private final Context zze;
    private final zzfcr zzf;
    private final zzcaz zzg;
    private final zzfdn zzh;
    private boolean zzi = false;
    private boolean zzj = false;
    private boolean zzk = true;
    private final zzbpi zzl;
    private final zzbpj zzm;

    public zzdlk(zzbpi zzbpiVar, zzbpj zzbpjVar, zzbpm zzbpmVar, zzcyd zzcydVar, zzcxj zzcxjVar, zzdfb zzdfbVar, Context context, zzfcr zzfcrVar, zzcaz zzcazVar, zzfdn zzfdnVar) {
        this.zzl = zzbpiVar;
        this.zzm = zzbpjVar;
        this.zza = zzbpmVar;
        this.zzb = zzcydVar;
        this.zzc = zzcxjVar;
        this.zzd = zzdfbVar;
        this.zze = context;
        this.zzf = zzfcrVar;
        this.zzg = zzcazVar;
        this.zzh = zzfdnVar;
    }

    private final void zzb(View view) {
        try {
            zzbpm zzbpmVar = this.zza;
            if (zzbpmVar != null && !zzbpmVar.zzA()) {
                this.zza.zzw(ObjectWrapper.wrap(view));
                this.zzc.onAdClicked();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzjU)).booleanValue()) {
                    this.zzd.zzbK();
                    return;
                }
                return;
            }
            zzbpi zzbpiVar = this.zzl;
            if (zzbpiVar != null && !zzbpiVar.zzx()) {
                this.zzl.zzs(ObjectWrapper.wrap(view));
                this.zzc.onAdClicked();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzjU)).booleanValue()) {
                    this.zzd.zzbK();
                    return;
                }
                return;
            }
            zzbpj zzbpjVar = this.zzm;
            if (zzbpjVar == null || zzbpjVar.zzv()) {
                return;
            }
            this.zzm.zzq(ObjectWrapper.wrap(view));
            this.zzc.onAdClicked();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzjU)).booleanValue()) {
                this.zzd.zzbK();
            }
        } catch (RemoteException e) {
            zzcat.zzk("Failed to call handleClick", e);
        }
    }

    private static final HashMap zzc(Map map) {
        HashMap map2 = new HashMap();
        if (map == null) {
            return map2;
        }
        synchronized (map) {
            for (Map.Entry entry : map.entrySet()) {
                View view = (View) ((WeakReference) entry.getValue()).get();
                if (view != null) {
                    map2.put((String) entry.getKey(), view);
                }
            }
        }
        return map2;
    }

    @Override // com.google.android.gms.internal.ads.zzdjr
    public final boolean zzA() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdjr
    public final boolean zzB() {
        return this.zzf.zzN;
    }

    @Override // com.google.android.gms.internal.ads.zzdjr
    public final boolean zzC(Bundle bundle) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdjr
    public final int zza() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdjr
    public final JSONObject zze(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdjr
    public final JSONObject zzf(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdjr
    public final void zzg() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzdjr
    public final void zzh() {
    }

    @Override // com.google.android.gms.internal.ads.zzdjr
    public final void zzi() {
    }

    @Override // com.google.android.gms.internal.ads.zzdjr
    public final void zzj(com.google.android.gms.ads.internal.client.zzcw zzcwVar) {
        zzcat.zzj("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzdjr
    public final void zzk(View view, View view2, Map map, Map map2, boolean z, ImageView.ScaleType scaleType) {
        if (this.zzj && this.zzf.zzN) {
            return;
        }
        zzb(view);
    }

    @Override // com.google.android.gms.internal.ads.zzdjr
    public final void zzl(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzdjr
    public final void zzm(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzdjr
    public final void zzo(View view, View view2, Map map, Map map2, boolean z, ImageView.ScaleType scaleType, int i) {
        if (!this.zzj) {
            zzcat.zzj("Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.");
        } else if (this.zzf.zzN) {
            zzb(view2);
        } else {
            zzcat.zzj("Custom click reporting for 3p ads failed. Ad unit id not in allow list.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjr
    public final void zzp() {
    }

    @Override // com.google.android.gms.internal.ads.zzdjr
    public final void zzq(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        try {
            if (!this.zzi) {
                this.zzi = com.google.android.gms.ads.internal.zzt.zzs().zzn(this.zze, this.zzg.zza, this.zzf.zzE.toString(), this.zzh.zzf);
            }
            if (this.zzk) {
                zzbpm zzbpmVar = this.zza;
                if (zzbpmVar != null && !zzbpmVar.zzB()) {
                    this.zza.zzx();
                    this.zzb.zza();
                    return;
                }
                zzbpi zzbpiVar = this.zzl;
                if (zzbpiVar != null && !zzbpiVar.zzy()) {
                    this.zzl.zzt();
                    this.zzb.zza();
                    return;
                }
                zzbpj zzbpjVar = this.zzm;
                if (zzbpjVar == null || zzbpjVar.zzw()) {
                    return;
                }
                this.zzm.zzr();
                this.zzb.zza();
            }
        } catch (RemoteException e) {
            zzcat.zzk("Failed to call recordImpression", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjr
    public final void zzr() {
    }

    @Override // com.google.android.gms.internal.ads.zzdjr
    public final void zzs(View view, MotionEvent motionEvent, View view2) {
    }

    @Override // com.google.android.gms.internal.ads.zzdjr
    public final void zzt(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzdjr
    public final void zzu(View view) {
    }

    @Override // com.google.android.gms.internal.ads.zzdjr
    public final void zzv() {
        this.zzj = true;
    }

    @Override // com.google.android.gms.internal.ads.zzdjr
    public final void zzw(com.google.android.gms.ads.internal.client.zzcs zzcsVar) {
        zzcat.zzj("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzdjr
    public final void zzx(zzbhi zzbhiVar) {
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00cc A[Catch: JSONException -> 0x0045, RemoteException -> 0x0122, TRY_LEAVE, TryCatch #0 {RemoteException -> 0x0122, blocks: (B:2:0x0000, B:4:0x001c, B:8:0x0026, B:11:0x002f, B:13:0x0036, B:14:0x0045, B:16:0x004b, B:18:0x0057, B:21:0x0062, B:24:0x0069, B:26:0x007f, B:28:0x0087, B:43:0x00a6, B:33:0x0091, B:37:0x009a, B:46:0x00ad, B:47:0x00b1, B:48:0x00c6, B:50:0x00cc, B:54:0x00de, B:56:0x00ec, B:58:0x00f8, B:60:0x00fc, B:62:0x010d, B:64:0x0111), top: B:72:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x005f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x0045 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x00c6 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzdjr
    public final void zzy(View view, Map map, Map map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        Object obj;
        ClassLoader classLoader;
        Iterator it;
        IObjectWrapper iObjectWrapperZzn;
        try {
            IObjectWrapper iObjectWrapperWrap = ObjectWrapper.wrap(view);
            JSONObject jSONObject = this.zzf.zzal;
            boolean z = true;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzbv)).booleanValue() && jSONObject.length() != 0) {
                Map map3 = map == null ? new HashMap() : map;
                Map map4 = map2 == null ? new HashMap() : map2;
                HashMap map5 = new HashMap();
                map5.putAll(map3);
                map5.putAll(map4);
                Iterator<String> itKeys = jSONObject.keys();
                loop0: while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(next);
                    if (jSONArrayOptJSONArray != null) {
                        WeakReference weakReference = (WeakReference) map5.get(next);
                        if (weakReference != null && (obj = weakReference.get()) != null) {
                            Class<?> cls = obj.getClass();
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzbw)).booleanValue() && next.equals("3010")) {
                                zzbpm zzbpmVar = this.zza;
                                Object objUnwrap = null;
                                if (zzbpmVar != null) {
                                    try {
                                        iObjectWrapperZzn = zzbpmVar.zzn();
                                    } catch (RemoteException | IllegalArgumentException unused) {
                                    }
                                } else {
                                    zzbpi zzbpiVar = this.zzl;
                                    if (zzbpiVar != null) {
                                        iObjectWrapperZzn = zzbpiVar.zzk();
                                    } else {
                                        zzbpj zzbpjVar = this.zzm;
                                        iObjectWrapperZzn = zzbpjVar != null ? zzbpjVar.zzj() : null;
                                    }
                                }
                                if (iObjectWrapperZzn != null) {
                                    objUnwrap = ObjectWrapper.unwrap(iObjectWrapperZzn);
                                }
                                if (objUnwrap != null) {
                                    cls = objUnwrap.getClass();
                                    ArrayList arrayList = new ArrayList();
                                    com.google.android.gms.ads.internal.util.zzbw.zzc(jSONArrayOptJSONArray, arrayList);
                                    com.google.android.gms.ads.internal.zzt.zzp();
                                    classLoader = this.zze.getClassLoader();
                                    it = arrayList.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            if (Class.forName((String) it.next(), false, classLoader).isAssignableFrom(cls)) {
                                            }
                                        }
                                    }
                                }
                            } else {
                                try {
                                    ArrayList arrayList2 = new ArrayList();
                                    com.google.android.gms.ads.internal.util.zzbw.zzc(jSONArrayOptJSONArray, arrayList2);
                                    com.google.android.gms.ads.internal.zzt.zzp();
                                    classLoader = this.zze.getClassLoader();
                                    it = arrayList2.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            if (Class.forName((String) it.next(), false, classLoader).isAssignableFrom(cls)) {
                                            }
                                        }
                                    }
                                } catch (JSONException unused2) {
                                    continue;
                                }
                            }
                        }
                        z = false;
                        break;
                    }
                }
            }
            this.zzk = z;
            HashMap mapZzc = zzc(map);
            HashMap mapZzc2 = zzc(map2);
            zzbpm zzbpmVar2 = this.zza;
            if (zzbpmVar2 != null) {
                zzbpmVar2.zzy(iObjectWrapperWrap, ObjectWrapper.wrap(mapZzc), ObjectWrapper.wrap(mapZzc2));
                return;
            }
            zzbpi zzbpiVar2 = this.zzl;
            if (zzbpiVar2 != null) {
                zzbpiVar2.zzv(iObjectWrapperWrap, ObjectWrapper.wrap(mapZzc), ObjectWrapper.wrap(mapZzc2));
                this.zzl.zzu(iObjectWrapperWrap);
                return;
            }
            zzbpj zzbpjVar2 = this.zzm;
            if (zzbpjVar2 != null) {
                zzbpjVar2.zzt(iObjectWrapperWrap, ObjectWrapper.wrap(mapZzc), ObjectWrapper.wrap(mapZzc2));
                this.zzm.zzs(iObjectWrapperWrap);
            }
        } catch (RemoteException e) {
            zzcat.zzk("Failed to call trackView", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjr
    public final void zzz(View view, Map map) {
        try {
            IObjectWrapper iObjectWrapperWrap = ObjectWrapper.wrap(view);
            zzbpm zzbpmVar = this.zza;
            if (zzbpmVar != null) {
                zzbpmVar.zzz(iObjectWrapperWrap);
                return;
            }
            zzbpi zzbpiVar = this.zzl;
            if (zzbpiVar != null) {
                zzbpiVar.zzw(iObjectWrapperWrap);
                return;
            }
            zzbpj zzbpjVar = this.zzm;
            if (zzbpjVar != null) {
                zzbpjVar.zzu(iObjectWrapperWrap);
            }
        } catch (RemoteException e) {
            zzcat.zzk("Failed to call untrackView", e);
        }
    }
}
