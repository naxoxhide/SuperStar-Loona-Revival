package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdfw extends zzcsx {
    private final Context zzc;
    private final WeakReference zzd;
    private final zzdel zze;
    private final zzdhf zzf;
    private final zzctr zzg;
    private final zzfnb zzh;
    private final zzcxy zzi;
    private final zzcag zzj;
    private boolean zzk;

    zzdfw(zzcsw zzcswVar, Context context, @Nullable zzcgb zzcgbVar, zzdel zzdelVar, zzdhf zzdhfVar, zzctr zzctrVar, zzfnb zzfnbVar, zzcxy zzcxyVar, zzcag zzcagVar) {
        super(zzcswVar);
        this.zzk = false;
        this.zzc = context;
        this.zzd = new WeakReference(zzcgbVar);
        this.zze = zzdelVar;
        this.zzf = zzdhfVar;
        this.zzg = zzctrVar;
        this.zzh = zzfnbVar;
        this.zzi = zzcxyVar;
        this.zzj = zzcagVar;
    }

    public final void finalize() throws Throwable {
        try {
            final zzcgb zzcgbVar = (zzcgb) this.zzd.get();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgH)).booleanValue()) {
                if (!this.zzk && zzcgbVar != null) {
                    zzcbg.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdfv
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

    public final boolean zza() {
        return this.zzg.zzg();
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0092  */
    /* JADX WARN: Code duplicated, block: B:21:0x0096  */
    /* JADX WARN: Code duplicated, block: B:24:0x00aa A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:9:0x004e  */
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
    public final boolean zzc(boolean z, @Nullable Activity activity) {
        Context context;
        zzfcr zzfcrVarZzD;
        this.zze.zzb();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzaA)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzp();
            if (com.google.android.gms.ads.internal.util.zzt.zzF(this.zzc)) {
                zzcat.zzj("Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://googlemobileadssdk.page.link/admob-interstitial-policies");
                this.zzi.zzb();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzaB)).booleanValue()) {
                    this.zzh.zza(this.zza.zzb.zzb.zzb);
                }
            } else {
                zzcgb zzcgbVar = (zzcgb) this.zzd.get();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzkP)).booleanValue() || zzcgbVar == null || (zzfcrVarZzD = zzcgbVar.zzD()) == null || !zzfcrVarZzD.zzas || zzfcrVarZzD.zzat == this.zzj.zzb()) {
                    if (this.zzk) {
                        zzcat.zzj("The interstitial ad has been shown.");
                        this.zzi.zza(zzfeo.zzd(10, null, null));
                    }
                    context = activity;
                    if (!this.zzk) {
                        if (activity == null) {
                            context = this.zzc;
                        }
                        try {
                            this.zzf.zza(z, context, this.zzi);
                            this.zze.zza();
                            this.zzk = true;
                            return true;
                        } catch (zzdhe e) {
                            this.zzi.zzc(e);
                        }
                    }
                } else {
                    zzcat.zzj("The interstitial consent form has been shown.");
                    this.zzi.zza(zzfeo.zzd(12, "The consent form has already been shown.", null));
                }
            }
        } else {
            zzcgb zzcgbVar2 = (zzcgb) this.zzd.get();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzkP)).booleanValue()) {
                if (this.zzk) {
                    zzcat.zzj("The interstitial ad has been shown.");
                    this.zzi.zza(zzfeo.zzd(10, null, null));
                }
                context = activity;
                if (!this.zzk) {
                    if (activity == null) {
                        context = this.zzc;
                    }
                    this.zzf.zza(z, context, this.zzi);
                    this.zze.zza();
                    this.zzk = true;
                    return true;
                }
            } else {
                if (this.zzk) {
                    zzcat.zzj("The interstitial ad has been shown.");
                    this.zzi.zza(zzfeo.zzd(10, null, null));
                }
                context = activity;
                if (!this.zzk) {
                    if (activity == null) {
                        context = this.zzc;
                    }
                    this.zzf.zza(z, context, this.zzi);
                    this.zze.zza();
                    this.zzk = true;
                    return true;
                }
            }
        }
        return false;
    }
}
