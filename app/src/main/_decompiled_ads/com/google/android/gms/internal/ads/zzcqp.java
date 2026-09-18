package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcqp extends zzcsx {
    private final zzcgb zzc;
    private final int zzd;
    private final Context zze;
    private final zzcqe zzf;
    private final zzdhf zzg;
    private final zzdel zzh;
    private final zzcxy zzi;
    private final boolean zzj;
    private final zzcag zzk;
    private boolean zzl;

    zzcqp(zzcsw zzcswVar, Context context, zzcgb zzcgbVar, int i, zzcqe zzcqeVar, zzdhf zzdhfVar, zzdel zzdelVar, zzcxy zzcxyVar, zzcag zzcagVar) {
        super(zzcswVar);
        this.zzl = false;
        this.zzc = zzcgbVar;
        this.zze = context;
        this.zzd = i;
        this.zzf = zzcqeVar;
        this.zzg = zzdhfVar;
        this.zzh = zzdelVar;
        this.zzi = zzcxyVar;
        this.zzj = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzfh)).booleanValue();
        this.zzk = zzcagVar;
    }

    public final int zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzcsx
    public final void zzb() {
        super.zzb();
        zzcgb zzcgbVar = this.zzc;
        if (zzcgbVar != null) {
            zzcgbVar.destroy();
        }
    }

    public final void zzc(zzawj zzawjVar) {
        zzcgb zzcgbVar = this.zzc;
        if (zzcgbVar != null) {
            zzcgbVar.zzah(zzawjVar);
        }
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
    public final void zzd(Activity activity, zzaww zzawwVar, boolean z) throws RemoteException {
        zzcgb zzcgbVar;
        zzfcr zzfcrVarZzD;
        Context context = activity;
        if (activity == null) {
            context = this.zze;
        }
        if (this.zzj) {
            this.zzh.zzb();
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzaA)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzp();
            if (com.google.android.gms.ads.internal.util.zzt.zzF(context)) {
                zzcat.zzj("Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://googlemobileadssdk.page.link/admob-interstitial-policies");
                this.zzi.zzb();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzaB)).booleanValue()) {
                    new zzfnb(context.getApplicationContext(), com.google.android.gms.ads.internal.zzt.zzt().zzb()).zza(this.zza.zzb.zzb.zzb);
                    return;
                }
                return;
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzkP)).booleanValue() && (zzcgbVar = this.zzc) != null && (zzfcrVarZzD = zzcgbVar.zzD()) != null && zzfcrVarZzD.zzas && zzfcrVarZzD.zzat != this.zzk.zzb()) {
            zzcat.zzj("The app open consent form has been shown.");
            this.zzi.zza(zzfeo.zzd(12, "The consent form has already been shown.", null));
            return;
        }
        if (this.zzl) {
            zzcat.zzj("App open interstitial ad is already visible.");
            this.zzi.zza(zzfeo.zzd(10, null, null));
        }
        if (this.zzl) {
            return;
        }
        try {
            this.zzg.zza(z, context, this.zzi);
            if (this.zzj) {
                this.zzh.zza();
            }
            this.zzl = true;
        } catch (zzdhe e) {
            this.zzi.zzc(e);
        }
    }

    public final void zze(long j, int i) {
        this.zzf.zza(j, i);
    }
}
