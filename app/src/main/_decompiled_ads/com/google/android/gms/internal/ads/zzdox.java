package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdox extends zzcsx {
    private final Context zzc;
    private final WeakReference zzd;
    private final zzdhf zze;
    private final zzdel zzf;
    private final zzcxy zzg;
    private final zzczf zzh;
    private final zzctr zzi;
    private final zzbwm zzj;
    private final zzfnb zzk;
    private final zzfdg zzl;
    private boolean zzm;

    zzdox(zzcsw zzcswVar, Context context, zzcgb zzcgbVar, zzdhf zzdhfVar, zzdel zzdelVar, zzcxy zzcxyVar, zzczf zzczfVar, zzctr zzctrVar, zzfcr zzfcrVar, zzfnb zzfnbVar, zzfdg zzfdgVar) {
        super(zzcswVar);
        this.zzm = false;
        this.zzc = context;
        this.zze = zzdhfVar;
        this.zzd = new WeakReference(zzcgbVar);
        this.zzf = zzdelVar;
        this.zzg = zzcxyVar;
        this.zzh = zzczfVar;
        this.zzi = zzctrVar;
        this.zzk = zzfnbVar;
        zzbwi zzbwiVar = zzfcrVar.zzn;
        this.zzj = new zzbxg(zzbwiVar != null ? zzbwiVar.zza : "", zzbwiVar != null ? zzbwiVar.zzb : 1);
        this.zzl = zzfdgVar;
    }

    public final void finalize() throws Throwable {
        try {
            final zzcgb zzcgbVar = (zzcgb) this.zzd.get();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgH)).booleanValue()) {
                if (!this.zzm && zzcgbVar != null) {
                    zzcbg.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdow
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzcgbVar.destroy();
                        }
                    });
                }
            } else if (zzcgbVar != null) {
                zzcgbVar.destroy();
            }
        } finally {
            super.finalize();
        }
    }

    public final Bundle zza() {
        return this.zzh.zzb();
    }

    public final zzbwm zzc() {
        return this.zzj;
    }

    public final zzfdg zzd() {
        return this.zzl;
    }

    public final boolean zze() {
        return this.zzi.zzg();
    }

    public final boolean zzf() {
        return this.zzm;
    }

    public final boolean zzg() {
        zzcgb zzcgbVar = (zzcgb) this.zzd.get();
        return (zzcgbVar == null || zzcgbVar.zzaB()) ? false : true;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final boolean zzh(boolean z, Activity activity) {
        Context context;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzaA)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzp();
            if (com.google.android.gms.ads.internal.util.zzt.zzF(this.zzc)) {
                zzcat.zzj("Rewarded ads that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit https://googlemobileadssdk.page.link/admob-interstitial-policies");
                this.zzg.zzb();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzaB)).booleanValue()) {
                    this.zzk.zza(this.zza.zzb.zzb.zzb);
                }
                return false;
            }
        }
        if (this.zzm) {
            zzcat.zzj("The rewarded ad have been showed.");
            this.zzg.zza(zzfeo.zzd(10, null, null));
            return false;
        }
        this.zzm = true;
        this.zzf.zzb();
        if (activity == null) {
            context = activity;
            context = this.zzc;
        }
        try {
            context = activity;
            this.zze.zza(z, context, this.zzg);
            this.zzf.zza();
            return true;
        } catch (zzdhe e) {
            this.zzg.zzc(e);
            return false;
        }
    }
}
