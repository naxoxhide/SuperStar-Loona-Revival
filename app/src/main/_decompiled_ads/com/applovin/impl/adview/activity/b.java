package com.applovin.impl.adview.activity;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.view.WindowManager;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.utils.u;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private final Activity ahM;
    private final int aiH;
    private final int aiI;
    private final boolean aiJ;
    private final boolean aiK;

    public b(Activity activity) {
        this.ahM = activity;
        int iAe = u.ae(activity);
        this.aiI = iAe;
        boolean zIsTablet = AppLovinSdkUtils.isTablet(activity);
        this.aiJ = zIsTablet;
        this.aiH = p(iAe, zIsTablet);
        this.aiK = zIsTablet && 2 == v(activity);
    }

    public void c(e eVar) {
        int i;
        if (eVar.Gp() && (i = this.aiH) != -1) {
            gd(i);
        } else {
            a(eVar.FZ());
        }
    }

    private int p(int i, boolean z) {
        if (z && this.aiK) {
            if (i == 0) {
                return 0;
            }
            if (i == 1) {
                return 9;
            }
            if (i == 2) {
                return 8;
            }
            return i == 3 ? 1 : -1;
        }
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 9;
        }
        return i == 3 ? 8 : -1;
    }

    private void a(e.b bVar) {
        if (bVar == e.b.ACTIVITY_PORTRAIT) {
            if (this.aiJ && this.aiK) {
                int i = this.aiI;
                if (i != 1 && i != 3) {
                    gd(1);
                    return;
                } else if (i == 1) {
                    gd(9);
                    return;
                } else {
                    gd(1);
                    return;
                }
            }
            int i2 = this.aiI;
            if (i2 != 0 && i2 != 2) {
                gd(1);
                return;
            } else {
                gd(i2 != 0 ? 9 : 1);
                return;
            }
        }
        if (bVar == e.b.ACTIVITY_LANDSCAPE) {
            if (this.aiJ && this.aiK) {
                int i3 = this.aiI;
                if (i3 != 0 && i3 != 2) {
                    gd(0);
                    return;
                } else {
                    gd(i3 != 2 ? 0 : 8);
                    return;
                }
            }
            int i4 = this.aiI;
            if (i4 != 1 && i4 != 3) {
                gd(0);
            } else {
                gd(i4 == 1 ? 0 : 8);
            }
        }
    }

    private static int v(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        return (((rotation == 0 || rotation == 2) && configuration.orientation == 2) || ((rotation == 1 || rotation == 3) && configuration.orientation == 1)) ? 2 : 1;
    }

    private void gd(int i) {
        try {
            this.ahM.setRequestedOrientation(i);
        } catch (Throwable unused) {
        }
    }
}
