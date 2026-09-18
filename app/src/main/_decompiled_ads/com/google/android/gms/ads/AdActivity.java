package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbsv;
import com.google.android.gms.internal.ads.zzcat;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class AdActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    private zzbsv zza;

    private final void zza() {
        zzbsv zzbsvVar = this.zza;
        if (zzbsvVar != null) {
            try {
                zzbsvVar.zzx();
            } catch (RemoteException e) {
                zzcat.zzl("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // android.app.Activity
    protected final void onActivityResult(int i, int i2, Intent intent) {
        try {
            zzbsv zzbsvVar = this.zza;
            if (zzbsvVar != null) {
                zzbsvVar.zzh(i, i2, intent);
            }
        } catch (Exception e) {
            zzcat.zzl("#007 Could not call remote method.", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        try {
            zzbsv zzbsvVar = this.zza;
            if (zzbsvVar != null && !zzbsvVar.zzH()) {
                return;
            }
        } catch (RemoteException e) {
            zzcat.zzl("#007 Could not call remote method.", e);
        }
        super.onBackPressed();
        try {
            zzbsv zzbsvVar2 = this.zza;
            if (zzbsvVar2 != null) {
                zzbsvVar2.zzi();
            }
        } catch (RemoteException e2) {
            zzcat.zzl("#007 Could not call remote method.", e2);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            zzbsv zzbsvVar = this.zza;
            if (zzbsvVar != null) {
                zzbsvVar.zzk(ObjectWrapper.wrap(configuration));
            }
        } catch (RemoteException e) {
            zzcat.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zzbsv zzbsvVarZzo = zzay.zza().zzo(this);
        this.zza = zzbsvVarZzo;
        if (zzbsvVarZzo == null) {
            zzcat.zzl("#007 Could not call remote method.", null);
            finish();
            return;
        }
        try {
            zzbsvVarZzo.zzl(bundle);
        } catch (RemoteException e) {
            zzcat.zzl("#007 Could not call remote method.", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onDestroy() {
        try {
            zzbsv zzbsvVar = this.zza;
            if (zzbsvVar != null) {
                zzbsvVar.zzm();
            }
        } catch (RemoteException e) {
            zzcat.zzl("#007 Could not call remote method.", e);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected final void onPause() {
        try {
            zzbsv zzbsvVar = this.zza;
            if (zzbsvVar != null) {
                zzbsvVar.zzo();
            }
        } catch (RemoteException e) {
            zzcat.zzl("#007 Could not call remote method.", e);
            finish();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        try {
            zzbsv zzbsvVar = this.zza;
            if (zzbsvVar != null) {
                zzbsvVar.zzp(i, strArr, iArr);
            }
        } catch (RemoteException e) {
            zzcat.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // android.app.Activity
    protected final void onRestart() {
        super.onRestart();
        try {
            zzbsv zzbsvVar = this.zza;
            if (zzbsvVar != null) {
                zzbsvVar.zzq();
            }
        } catch (RemoteException e) {
            zzcat.zzl("#007 Could not call remote method.", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onResume() {
        super.onResume();
        try {
            zzbsv zzbsvVar = this.zza;
            if (zzbsvVar != null) {
                zzbsvVar.zzr();
            }
        } catch (RemoteException e) {
            zzcat.zzl("#007 Could not call remote method.", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onSaveInstanceState(Bundle bundle) {
        try {
            zzbsv zzbsvVar = this.zza;
            if (zzbsvVar != null) {
                zzbsvVar.zzs(bundle);
            }
        } catch (RemoteException e) {
            zzcat.zzl("#007 Could not call remote method.", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected final void onStart() {
        super.onStart();
        try {
            zzbsv zzbsvVar = this.zza;
            if (zzbsvVar != null) {
                zzbsvVar.zzt();
            }
        } catch (RemoteException e) {
            zzcat.zzl("#007 Could not call remote method.", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onStop() {
        try {
            zzbsv zzbsvVar = this.zza;
            if (zzbsvVar != null) {
                zzbsvVar.zzu();
            }
        } catch (RemoteException e) {
            zzcat.zzl("#007 Could not call remote method.", e);
            finish();
        }
        super.onStop();
    }

    @Override // android.app.Activity
    protected final void onUserLeaveHint() {
        super.onUserLeaveHint();
        try {
            zzbsv zzbsvVar = this.zza;
            if (zzbsvVar != null) {
                zzbsvVar.zzv();
            }
        } catch (RemoteException e) {
            zzcat.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // android.app.Activity
    public final void setContentView(int i) {
        super.setContentView(i);
        zza();
    }

    @Override // android.app.Activity
    public final void setContentView(View view) {
        super.setContentView(view);
        zza();
    }

    @Override // android.app.Activity
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        zza();
    }
}
