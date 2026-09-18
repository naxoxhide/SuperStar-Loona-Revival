package com.kakao.adfit.ads.media;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AdFitVideoAutoPlayPolicy.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lcom/kakao/adfit/ads/media/AdFitVideoAutoPlayPolicy;", "", "(Ljava/lang/String;I)V", "NONE", "WIFI_ONLY", "ALWAYS", "Companion", "library_networkRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum AdFitVideoAutoPlayPolicy {
    NONE,
    WIFI_ONLY,
    ALWAYS;


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: AdFitVideoAutoPlayPolicy.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/kakao/adfit/ads/media/AdFitVideoAutoPlayPolicy$Companion;", "", "()V", "default", "Lcom/kakao/adfit/ads/media/AdFitVideoAutoPlayPolicy;", "library_networkRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: default, reason: not valid java name */
        public final AdFitVideoAutoPlayPolicy m444default() {
            return AdFitVideoAutoPlayPolicy.WIFI_ONLY;
        }
    }
}
