package com.kakao.adfit.a;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.ads.RequestConfiguration;
import com.kakao.adfit.a.a;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AdRequest.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B/\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\r\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0005\u0010\u0010R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\n\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/kakao/adfit/a/j;", "Lcom/kakao/adfit/a/a;", RequestConfiguration.MAX_AD_CONTENT_RATING_T, "", "", "a", "Ljava/lang/String;", "getString", "()Ljava/lang/String;", "string", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "getId", "id", "", "c", "Ljava/util/List;", "()Ljava/util/List;", CampaignUnit.JSON_KEY_ADS, "Lcom/kakao/adfit/a/n;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "Lcom/kakao/adfit/a/n;", "()Lcom/kakao/adfit/a/n;", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/kakao/adfit/a/n;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class j<T extends a> {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final String string;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String id;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final List<T> ads;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final n options;

    /* JADX WARN: Multi-variable type inference failed */
    public j(String string, String id, List<? extends T> ads, n nVar) {
        Intrinsics.checkNotNullParameter(string, "string");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(ads, "ads");
        this.string = string;
        this.id = id;
        this.ads = ads;
        this.options = nVar;
    }

    public final List<T> a() {
        return this.ads;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final n getOptions() {
        return this.options;
    }
}
