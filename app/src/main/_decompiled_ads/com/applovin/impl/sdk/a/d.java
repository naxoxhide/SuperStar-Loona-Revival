package com.applovin.impl.sdk.a;

import android.view.View;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private final View VG;
    private final FriendlyObstructionPurpose aIy;
    private final String aIz;

    public d(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        this.VG = view;
        this.aIy = friendlyObstructionPurpose;
        this.aIz = str;
    }

    public View IO() {
        return this.VG;
    }

    public FriendlyObstructionPurpose IP() {
        return this.aIy;
    }

    public String IQ() {
        return this.aIz;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        View view = this.VG;
        if (view == null ? dVar.VG != null : !view.equals(dVar.VG)) {
            return false;
        }
        if (this.aIy != dVar.aIy) {
            return false;
        }
        String str = this.aIz;
        String str2 = dVar.aIz;
        if (str != null) {
            return str.equals(str2);
        }
        return str2 == null;
    }

    public int hashCode() {
        View view = this.VG;
        int iHashCode = (view != null ? view.hashCode() : 0) * 31;
        FriendlyObstructionPurpose friendlyObstructionPurpose = this.aIy;
        int iHashCode2 = (iHashCode + (friendlyObstructionPurpose != null ? friendlyObstructionPurpose.hashCode() : 0)) * 31;
        String str = this.aIz;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }
}
