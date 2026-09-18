package com.kakao.adfit.d;

import android.view.Surface;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tapjoy.TapjoyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: IVideoAdPlayer.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0002\u000f\u0003J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&R\u0014\u0010\n\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00118&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0006\u0010\u0014R\u001c\u0010\u001b\u001a\u00020\u00168&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aRN\u0010#\u001a4\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001c8&@&X¦\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\u000f\u0010\"RN\u0010'\u001a4\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110$¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001c8&@&X¦\u000e¢\u0006\f\u001a\u0004\b&\u0010!\"\u0004\b\u0006\u0010\"¨\u0006("}, d2 = {"Lcom/kakao/adfit/d/j;", "", "", "c", "play", CampaignEx.JSON_NATIVE_VIDEO_PAUSE, "a", "Lcom/kakao/adfit/d/j$c;", "getState", "()Lcom/kakao/adfit/d/j$c;", "state", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "()Z", "isPrepared", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "isPlaying", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "(Landroid/view/Surface;)V", "surface", "", "getVolume", "()F", "setVolume", "(F)V", TapjoyConstants.TJC_VOLUME, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "player", "getOnStateChanged", "()Lkotlin/jvm/functions/Function2;", "(Lkotlin/jvm/functions/Function2;)V", "onStateChanged", "", "position", "getOnProgressChanged", "onProgressChanged", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public interface j {

    /* JADX INFO: compiled from: IVideoAdPlayer.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public static boolean a(j jVar) {
            return jVar.getState() == c.STARTED;
        }

        public static boolean b(j jVar) {
            int i = d.a[jVar.getState().ordinal()];
            return i == 1 || i == 2 || i == 3 || i == 4;
        }
    }

    /* JADX INFO: compiled from: IVideoAdPlayer.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/kakao/adfit/d/j$b;", "", "<init>", "(Ljava/lang/String;I)V", "CONNECTION_ERROR", "TIMEOUT_ERROR", "UNKNOWN_INPUT_FORMAT_ERROR", "UNKNOWN_ERROR", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public enum b {
        CONNECTION_ERROR,
        TIMEOUT_ERROR,
        UNKNOWN_INPUT_FORMAT_ERROR,
        UNKNOWN_ERROR
    }

    /* JADX INFO: compiled from: IVideoAdPlayer.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/kakao/adfit/d/j$c;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "INITIALIZED", "PREPARING", "PREPARED", "STARTED", "PAUSED", "COMPLETED", "STOPPED", "RELEASED", "ERROR", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public enum c {
        IDLE,
        INITIALIZED,
        PREPARING,
        PREPARED,
        STARTED,
        PAUSED,
        COMPLETED,
        STOPPED,
        RELEASED,
        ERROR
    }

    /* JADX INFO: compiled from: IVideoAdPlayer.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.values().length];
            iArr[c.PREPARED.ordinal()] = 1;
            iArr[c.STARTED.ordinal()] = 2;
            iArr[c.PAUSED.ordinal()] = 3;
            iArr[c.COMPLETED.ordinal()] = 4;
            a = iArr;
        }
    }

    void a();

    void a(Surface surface);

    void a(Function2<? super j, ? super Integer, Unit> function2);

    void b(Function2<? super j, ? super c, Unit> function2);

    boolean b();

    void c();

    boolean d();

    c getState();

    Surface getSurface();

    void pause();

    void play();

    void setVolume(float f);
}
