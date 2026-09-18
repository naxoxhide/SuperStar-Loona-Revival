package com.kakao.adfit.d;

import android.graphics.drawable.Drawable;
import android.view.Surface;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tapjoy.TJAdUnitConstants;
import kotlin.Metadata;

/* JADX INFO: compiled from: IVideoAdViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0002H&J\b\u0010\t\u001a\u00020\u0002H&J\b\u0010\n\u001a\u00020\u0002H&J\b\u0010\u000b\u001a\u00020\u0002H&J\b\u0010\f\u001a\u00020\u0002H&J\b\u0010\r\u001a\u00020\u0002H&R\u0014\u0010\u0011\u001a\u00020\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00128&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00168&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00168&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0018R\u0014\u0010\u001e\u001a\u00020\u00168&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0018R\u001c\u0010#\u001a\u00020\u001f8&@&X¦\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\u0007\u0010\"R\u0014\u0010'\u001a\u00020$8&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006("}, d2 = {"Lcom/kakao/adfit/d/l;", "", "", "play", CampaignEx.JSON_NATIVE_VIDEO_PAUSE, "Landroid/view/Surface;", "surface", "a", "h", "i", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "c", "l", CampaignEx.JSON_KEY_AD_K, "Lcom/kakao/adfit/d/l$a;", InneractiveMediationDefs.GENDER_FEMALE, "()Lcom/kakao/adfit/d/l$a;", "viewState", "Landroid/graphics/drawable/Drawable;", "o", "()Landroid/graphics/drawable/Drawable;", "videoImage", "", "e", "()I", TJAdUnitConstants.String.VIDEO_WIDTH, InneractiveMediationDefs.GENDER_MALE, TJAdUnitConstants.String.VIDEO_HEIGHT, TJAdUnitConstants.String.VIDEO_DURATION, "g", "videoPosition", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "()F", "(F)V", "videoVolume", "", "n", "()Z", "isAudioTrackPrepared", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public interface l {

    /* JADX INFO: compiled from: IVideoAdViewModel.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/kakao/adfit/d/l$a;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "INITIALIZED", "LOADING", "PLAYING", "PAUSED", "COMPLETED", "ERROR", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public enum a {
        IDLE,
        INITIALIZED,
        LOADING,
        PLAYING,
        PAUSED,
        COMPLETED,
        ERROR
    }

    int a();

    void a(float f);

    void a(Surface surface);

    void b();

    void c();

    float d();

    int e();

    a f();

    int g();

    void h();

    void i();

    void k();

    void l();

    int m();

    boolean n();

    Drawable o();

    void pause();

    void play();
}
