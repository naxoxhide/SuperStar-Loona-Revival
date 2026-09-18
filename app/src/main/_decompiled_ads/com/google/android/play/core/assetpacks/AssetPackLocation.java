package com.google.android.play.core.assetpacks;

/* JADX INFO: compiled from: com.google.android.play:core@@1.10.3 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AssetPackLocation {
    private static final AssetPackLocation zza = new zzbm(1, null, null);

    static AssetPackLocation zza() {
        return zza;
    }

    public abstract String assetsPath();

    public abstract int packStorageMethod();

    public abstract String path();
}
