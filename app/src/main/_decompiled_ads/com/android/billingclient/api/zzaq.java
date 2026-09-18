package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.android.billingclient:billing@@5.1.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzaq implements ServiceConnection {
    final /* synthetic */ BillingClientImpl zza;
    private final Object zzb = new Object();
    private boolean zzc = false;
    private BillingClientStateListener zzd;

    /* synthetic */ zzaq(BillingClientImpl billingClientImpl, BillingClientStateListener billingClientStateListener, zzap zzapVar) {
        this.zza = billingClientImpl;
        this.zzd = billingClientStateListener;
    }

    private final void zzd(BillingResult billingResult) {
        synchronized (this.zzb) {
            BillingClientStateListener billingClientStateListener = this.zzd;
            if (billingClientStateListener != null) {
                billingClientStateListener.onBillingSetupFinished(billingResult);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.google.android.gms.internal.play_billing.zzb.zzn("BillingClient", "Billing service connected.");
        this.zza.zzf = com.google.android.gms.internal.play_billing.zzd.zzo(iBinder);
        BillingClientImpl billingClientImpl = this.zza;
        if (billingClientImpl.zzJ(new Callable() { // from class: com.android.billingclient.api.zzan
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                this.zza.zza();
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzao
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzb();
            }
        }, billingClientImpl.zzF()) == null) {
            zzd(this.zza.zzH());
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "Billing service disconnected.");
        this.zza.zzf = null;
        this.zza.zza = 0;
        synchronized (this.zzb) {
            BillingClientStateListener billingClientStateListener = this.zzd;
            if (billingClientStateListener != null) {
                billingClientStateListener.onBillingServiceDisconnected();
            }
        }
    }

    final /* synthetic */ Object zza() throws Exception {
        Bundle bundle;
        int iZzr;
        synchronized (this.zzb) {
            if (this.zzc) {
                return null;
            }
            if (TextUtils.isEmpty(null)) {
                bundle = null;
            } else {
                bundle = new Bundle();
                bundle.putString("accountName", null);
            }
            int i = 3;
            try {
                String packageName = this.zza.zze.getPackageName();
                iZzr = 3;
                int i2 = 17;
                while (true) {
                    if (i2 < 3) {
                        i2 = 0;
                        break;
                    }
                    if (bundle == null) {
                        try {
                            iZzr = this.zza.zzf.zzr(i2, packageName, "subs");
                        } catch (Exception e) {
                            e = e;
                            i = iZzr;
                            com.google.android.gms.internal.play_billing.zzb.zzp("BillingClient", "Exception while checking if billing is supported; try to reconnect", e);
                            this.zza.zza = 0;
                            this.zza.zzf = null;
                            iZzr = i;
                        }
                    } else {
                        iZzr = this.zza.zzf.zzc(i2, packageName, "subs", bundle);
                    }
                    if (iZzr == 0) {
                        break;
                    }
                    i2--;
                }
                boolean z = true;
                this.zza.zzi = i2 >= 5;
                this.zza.zzh = i2 >= 3;
                if (i2 < 3) {
                    com.google.android.gms.internal.play_billing.zzb.zzn("BillingClient", "In-app billing API does not support subscription on this device.");
                }
                for (int i3 = 17; i3 >= 3; i3--) {
                    iZzr = bundle == null ? this.zza.zzf.zzr(i3, packageName, "inapp") : this.zza.zzf.zzc(i3, packageName, "inapp", bundle);
                    if (iZzr == 0) {
                        this.zza.zzj = i3;
                        break;
                    }
                }
                BillingClientImpl billingClientImpl = this.zza;
                billingClientImpl.zzs = billingClientImpl.zzj >= 17;
                BillingClientImpl billingClientImpl2 = this.zza;
                billingClientImpl2.zzr = billingClientImpl2.zzj >= 16;
                BillingClientImpl billingClientImpl3 = this.zza;
                billingClientImpl3.zzq = billingClientImpl3.zzj >= 15;
                BillingClientImpl billingClientImpl4 = this.zza;
                billingClientImpl4.zzp = billingClientImpl4.zzj >= 14;
                BillingClientImpl billingClientImpl5 = this.zza;
                billingClientImpl5.zzo = billingClientImpl5.zzj >= 12;
                BillingClientImpl billingClientImpl6 = this.zza;
                billingClientImpl6.zzn = billingClientImpl6.zzj >= 10;
                BillingClientImpl billingClientImpl7 = this.zza;
                billingClientImpl7.zzm = billingClientImpl7.zzj >= 9;
                BillingClientImpl billingClientImpl8 = this.zza;
                billingClientImpl8.zzl = billingClientImpl8.zzj >= 8;
                BillingClientImpl billingClientImpl9 = this.zza;
                if (billingClientImpl9.zzj < 6) {
                    z = false;
                }
                billingClientImpl9.zzk = z;
                if (this.zza.zzj < 3) {
                    com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "In-app billing API version 3 is not supported on this device.");
                }
                if (iZzr == 0) {
                    this.zza.zza = 2;
                } else {
                    this.zza.zza = 0;
                    this.zza.zzf = null;
                }
            } catch (Exception e2) {
                e = e2;
            }
            if (iZzr == 0) {
                zzd(zzbc.zzl);
            } else {
                zzd(zzbc.zza);
            }
            return null;
        }
    }

    final /* synthetic */ void zzb() {
        this.zza.zza = 0;
        this.zza.zzf = null;
        zzd(zzbc.zzn);
    }

    final void zzc() {
        synchronized (this.zzb) {
            this.zzd = null;
            this.zzc = true;
        }
    }
}
