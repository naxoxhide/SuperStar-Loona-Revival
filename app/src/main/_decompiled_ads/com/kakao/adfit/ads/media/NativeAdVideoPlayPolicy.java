package com.kakao.adfit.ads.media;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;

/* JADX INFO: compiled from: NativeAdVideoPlayPolicy.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/kakao/adfit/ads/media/NativeAdVideoPlayPolicy;", "", "", "a", "Z", "getAutoPlayEnabled", "()Z", "setAutoPlayEnabled", "(Z)V", "autoPlayEnabled", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "getWifiAutoPlayEnabled", "setWifiAutoPlayEnabled", "wifiAutoPlayEnabled", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class NativeAdVideoPlayPolicy {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private boolean autoPlayEnabled;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean wifiAutoPlayEnabled;

    public final boolean getAutoPlayEnabled() {
        return this.autoPlayEnabled;
    }

    public final boolean getWifiAutoPlayEnabled() {
        return this.wifiAutoPlayEnabled;
    }

    public final void setAutoPlayEnabled(boolean z) {
        this.autoPlayEnabled = z;
    }

    public final void setWifiAutoPlayEnabled(boolean z) {
        this.wifiAutoPlayEnabled = z;
    }
}
