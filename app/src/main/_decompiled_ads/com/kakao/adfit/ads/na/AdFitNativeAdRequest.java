package com.kakao.adfit.ads.na;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AdFitNativeAdRequest.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001e\u001dB7\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R%\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/kakao/adfit/ads/na/AdFitNativeAdRequest;", "", "Lcom/kakao/adfit/ads/na/AdFitAdInfoIconPosition;", "a", "Lcom/kakao/adfit/ads/na/AdFitAdInfoIconPosition;", "getAdInfoIconPosition", "()Lcom/kakao/adfit/ads/na/AdFitAdInfoIconPosition;", "adInfoIconPosition", "Lcom/kakao/adfit/ads/na/AdFitVideoAutoPlayPolicy;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/kakao/adfit/ads/na/AdFitVideoAutoPlayPolicy;", "getVideoAutoPlayPolicy", "()Lcom/kakao/adfit/ads/na/AdFitVideoAutoPlayPolicy;", "videoAutoPlayPolicy", "", "c", "Z", "getTestModeEnabled", "()Z", "testModeEnabled", "", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "Ljava/util/Map;", "getTestOptions", "()Ljava/util/Map;", "testOptions", "<init>", "(Lcom/kakao/adfit/ads/na/AdFitAdInfoIconPosition;Lcom/kakao/adfit/ads/na/AdFitVideoAutoPlayPolicy;ZLjava/util/Map;)V", "Companion", "Builder", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class AdFitNativeAdRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final AdFitAdInfoIconPosition adInfoIconPosition;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final AdFitVideoAutoPlayPolicy videoAutoPlayPolicy;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final boolean testModeEnabled;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final Map<String, String> testOptions;

    /* JADX INFO: compiled from: AdFitNativeAdRequest.kt */
    @Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bJ\u001c\u0010\u000e\u001a\u00020\u00002\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bJ\u0006\u0010\u0010\u001a\u00020\u000fR\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R$\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/kakao/adfit/ads/na/AdFitNativeAdRequest$Builder;", "", "Lcom/kakao/adfit/ads/na/AdFitAdInfoIconPosition;", "position", "setAdInfoIconPosition", "Lcom/kakao/adfit/ads/na/AdFitVideoAutoPlayPolicy;", "policy", "setVideoAutoPlayPolicy", "", "enabled", "setTestModeEnabled", "", "", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "setTestOptions", "Lcom/kakao/adfit/ads/na/AdFitNativeAdRequest;", "build", "a", "Lcom/kakao/adfit/ads/na/AdFitAdInfoIconPosition;", "adInfoIconPosition", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/kakao/adfit/ads/na/AdFitVideoAutoPlayPolicy;", "videoAutoPlayPolicy", "c", "Z", "testModeEnabled", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "Ljava/util/Map;", "testOptions", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private AdFitAdInfoIconPosition adInfoIconPosition = AdFitAdInfoIconPosition.INSTANCE.m449default();

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private AdFitVideoAutoPlayPolicy videoAutoPlayPolicy = AdFitVideoAutoPlayPolicy.INSTANCE.m452default();

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private boolean testModeEnabled;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private Map<String, String> testOptions;

        public final AdFitNativeAdRequest build() {
            return new AdFitNativeAdRequest(this.adInfoIconPosition, this.videoAutoPlayPolicy, this.testModeEnabled, this.testOptions, null);
        }

        public final Builder setAdInfoIconPosition(AdFitAdInfoIconPosition position) {
            Intrinsics.checkNotNullParameter(position, "position");
            this.adInfoIconPosition = position;
            return this;
        }

        public final Builder setTestModeEnabled(boolean enabled) {
            this.testModeEnabled = enabled;
            return this;
        }

        public final Builder setTestOptions(Map<String, String> options) {
            this.testModeEnabled = true;
            this.testOptions = options;
            return this;
        }

        public final Builder setVideoAutoPlayPolicy(AdFitVideoAutoPlayPolicy policy) {
            Intrinsics.checkNotNullParameter(policy, "policy");
            this.videoAutoPlayPolicy = policy;
            return this;
        }
    }

    /* JADX INFO: compiled from: AdFitNativeAdRequest.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/kakao/adfit/ads/na/AdFitNativeAdRequest$Companion;", "", "()V", "default", "Lcom/kakao/adfit/ads/na/AdFitNativeAdRequest;", "library_networkRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        /* JADX INFO: renamed from: default, reason: not valid java name */
        public final AdFitNativeAdRequest m451default() {
            return new Builder().build();
        }
    }

    private AdFitNativeAdRequest(AdFitAdInfoIconPosition adFitAdInfoIconPosition, AdFitVideoAutoPlayPolicy adFitVideoAutoPlayPolicy, boolean z, Map<String, String> map) {
        this.adInfoIconPosition = adFitAdInfoIconPosition;
        this.videoAutoPlayPolicy = adFitVideoAutoPlayPolicy;
        this.testModeEnabled = z;
        this.testOptions = map;
    }

    public /* synthetic */ AdFitNativeAdRequest(AdFitAdInfoIconPosition adFitAdInfoIconPosition, AdFitVideoAutoPlayPolicy adFitVideoAutoPlayPolicy, boolean z, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(adFitAdInfoIconPosition, adFitVideoAutoPlayPolicy, z, map);
    }

    @JvmStatic
    /* JADX INFO: renamed from: default, reason: not valid java name */
    public static final AdFitNativeAdRequest m450default() {
        return INSTANCE.m451default();
    }

    public final AdFitAdInfoIconPosition getAdInfoIconPosition() {
        return this.adInfoIconPosition;
    }

    public final boolean getTestModeEnabled() {
        return this.testModeEnabled;
    }

    public final Map<String, String> getTestOptions() {
        return this.testOptions;
    }

    public final AdFitVideoAutoPlayPolicy getVideoAutoPlayPolicy() {
        return this.videoAutoPlayPolicy;
    }
}
