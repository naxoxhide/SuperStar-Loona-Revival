package com.google.android.play.core.appupdate;

/* JADX INFO: compiled from: com.google.android.play:core@@1.10.3 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AppUpdateOptions {

    /* JADX INFO: compiled from: com.google.android.play:core@@1.10.3 */
    public static abstract class Builder {
        public abstract AppUpdateOptions build();

        public abstract Builder setAllowAssetPackDeletion(boolean z);

        public abstract Builder setAppUpdateType(int i);
    }

    public static AppUpdateOptions defaultOptions(int i) {
        return newBuilder(i).build();
    }

    public static Builder newBuilder(int i) {
        zzu zzuVar = new zzu();
        zzuVar.setAppUpdateType(i);
        zzuVar.setAllowAssetPackDeletion(false);
        return zzuVar;
    }

    public abstract boolean allowAssetPackDeletion();

    public abstract int appUpdateType();
}
