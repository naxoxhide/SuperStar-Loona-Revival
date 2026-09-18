package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzafo implements Parcelable.Creator {
    zzafo() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String string = parcel.readString();
        Objects.requireNonNull(string);
        String string2 = parcel.readString();
        String[] strArrCreateStringArray = parcel.createStringArray();
        Objects.requireNonNull(strArrCreateStringArray);
        return new zzafp(string, string2, zzfvs.zzk(strArrCreateStringArray));
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzafp[i];
    }
}
