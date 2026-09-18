package com.applovin.impl.sdk;

import android.location.Location;
import android.location.LocationManager;
import android.provider.Settings;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class w {
    private final LocationManager aFe = (LocationManager) n.getApplicationContext().getSystemService(FirebaseAnalytics.Param.LOCATION);
    private double aFf;
    private double aFg;
    private long aFh;
    private final n sdk;

    public double Fi() {
        return this.aFf;
    }

    public double Fj() {
        return this.aFg;
    }

    w(n nVar) {
        this.sdk = nVar;
    }

    public boolean Fe() {
        return com.applovin.impl.sdk.utils.h.d("android.permission.ACCESS_COARSE_LOCATION", n.getApplicationContext());
    }

    public boolean Ff() {
        if (com.applovin.impl.sdk.utils.h.KZ()) {
            return this.aFe.isLocationEnabled();
        }
        return (com.applovin.impl.sdk.utils.h.KU() && Settings.Secure.getInt(n.getApplicationContext().getContentResolver(), "location_mode", 0) == 0) ? false : true;
    }

    public boolean Fg() {
        if (this.sdk.getSettings().isLocationCollectionEnabled() && ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPf)).booleanValue() && Fe()) {
            return Fh() || this.aFh != 0;
        }
        return false;
    }

    private boolean Fh() {
        long millis = TimeUnit.MINUTES.toMillis(((Long) this.sdk.a(com.applovin.impl.sdk.c.b.aPg)).longValue());
        if (this.aFh != 0 && System.currentTimeMillis() - this.aFh < millis) {
            return false;
        }
        Location locationB = B("gps", "android.permission.ACCESS_FINE_LOCATION");
        if (locationB == null) {
            locationB = B("network", "android.permission.ACCESS_COARSE_LOCATION");
        }
        if (locationB == null) {
            return false;
        }
        this.aFf = locationB.getLatitude();
        this.aFg = locationB.getLongitude();
        this.aFh = System.currentTimeMillis();
        return true;
    }

    private Location B(String str, String str2) {
        if (!com.applovin.impl.sdk.utils.h.d(str2, n.getApplicationContext())) {
            return null;
        }
        try {
            return this.aFe.getLastKnownLocation(str);
        } catch (IllegalArgumentException e) {
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().c("LocationManager", "Failed to retrieve location from " + str + ": device does not support this location provider.", e);
            }
            return null;
        } catch (NullPointerException e2) {
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().c("LocationManager", "Failed to retrieve location from " + str + ": location provider is not available.", e2);
            }
            return null;
        } catch (SecurityException e3) {
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().c("LocationManager", "Failed to retrieve location from " + str + ": access denied.", e3);
            }
            return null;
        } catch (Throwable th) {
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().c("LocationManager", "Failed to retrieve location from " + str + ".", th);
            }
            return null;
        }
    }
}
