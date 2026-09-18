package com.kakao.adfit.d;

import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VideoAdMediaPlayer.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 Q2\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u0019\u001a\u00020\r¢\u0006\u0004\bW\u0010XJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u001c\u0010\t\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\n\u0010\u0003\u001a\u00060\u000fj\u0002`\u0010H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016R\u001a\u0010\u0019\u001a\u00020\r8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR*\u0010\"\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00078\u0016@RX\u0096\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b\u001a\u0010!R.\u0010)\u001a\u0004\u0018\u00010#2\b\u0010\u001d\u001a\u0004\u0018\u00010#8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b\t\u0010(R\u0016\u0010+\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010*R*\u00103\u001a\u00020,2\u0006\u0010\u001d\u001a\u00020,8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0016\u00105\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010*R\u008e\u0001\u0010>\u001a4\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0004\u0018\u00010628\u0010\u001d\u001a4\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0004\u0018\u0001068\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b\u001a\u0010=R$\u0010C\u001a\u0012\u0012\u0004\u0012\u00020\u00070?j\b\u0012\u0004\u0012\u00020\u0007`@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u008e\u0001\u0010E\u001a4\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\n¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(D\u0012\u0004\u0012\u00020\u0004\u0018\u00010628\u0010\u001d\u001a4\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\n¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(D\u0012\u0004\u0012\u00020\u0004\u0018\u0001068\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b;\u0010:\u001a\u0004\bA\u0010<\"\u0004\b\t\u0010=RT\u0010I\u001a4\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110F¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(G\u0012\u0004\u0012\u00020\u0004\u0018\u0001068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010:\u001a\u0004\b9\u0010<\"\u0004\bH\u0010=R\u0014\u0010M\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010P\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bN\u0010OR\u0014\u0010R\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010OR\u0014\u0010S\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010OR\u0014\u0010D\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bK\u0010OR\u0014\u0010V\u001a\u00020T8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u0010U¨\u0006Y"}, d2 = {"Lcom/kakao/adfit/d/w;", "Lcom/kakao/adfit/d/j;", "Landroid/media/MediaPlayer;", "e", "", CampaignEx.JSON_KEY_AD_Q, "p", "Lcom/kakao/adfit/d/j$c;", "newState", "a", "", "what", "extra", "", "step", "Ljava/lang/Exception;", "Lkotlin/Exception;", "c", "ms", "play", CampaignEx.JSON_NATIVE_VIDEO_PAUSE, CampaignEx.JSON_KEY_AD_R, "Ljava/lang/String;", CampaignEx.JSON_KEY_AD_K, "()Ljava/lang/String;", MBridgeConstans.DYNAMIC_VIEW_WX_PATH, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Landroid/media/MediaPlayer;", "player", "value", "Lcom/kakao/adfit/d/j$c;", "getState", "()Lcom/kakao/adfit/d/j$c;", "(Lcom/kakao/adfit/d/j$c;)V", "state", "Landroid/view/Surface;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "(Landroid/view/Surface;)V", "surface", "I", "latestPosition", "", InneractiveMediationDefs.GENDER_FEMALE, "F", "o", "()F", "setVolume", "(F)V", TapjoyConstants.TJC_VOLUME, "g", "actionWhenPrepared", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "h", "Lkotlin/jvm/functions/Function2;", "j", "()Lkotlin/jvm/functions/Function2;", "(Lkotlin/jvm/functions/Function2;)V", "onStateChanged", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "i", "Ljava/util/ArrayList;", "changingStates", "position", "onProgressChanged", "Lcom/kakao/adfit/d/j$b;", "type", "setOnErrorOccurred", "onErrorOccurred", "Landroid/os/Handler;", "l", "Landroid/os/Handler;", "handler", "n", "()I", TJAdUnitConstants.String.VIDEO_WIDTH, InneractiveMediationDefs.GENDER_MALE, TJAdUnitConstants.String.VIDEO_HEIGHT, "duration", "", "()Z", "hasAudioTrack", "<init>", "(Ljava/lang/String;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class w implements j {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final String path;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private MediaPlayer player;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private j.c state;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private Surface surface;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private int latestPosition;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private float volume;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private int actionWhenPrepared;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private Function2<? super j, ? super j.c, Unit> onStateChanged;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final ArrayList<j.c> changingStates;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private Function2<? super j, ? super Integer, Unit> onProgressChanged;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private Function2<? super j, ? super j.b, Unit> onErrorOccurred;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private final Handler handler;

    /* JADX INFO: compiled from: VideoAdMediaPlayer.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[j.c.values().length];
            iArr[j.c.PREPARED.ordinal()] = 1;
            iArr[j.c.STARTED.ordinal()] = 2;
            iArr[j.c.PAUSED.ordinal()] = 3;
            iArr[j.c.COMPLETED.ordinal()] = 4;
            iArr[j.c.IDLE.ordinal()] = 5;
            iArr[j.c.INITIALIZED.ordinal()] = 6;
            iArr[j.c.STOPPED.ordinal()] = 7;
            iArr[j.c.PREPARING.ordinal()] = 8;
            iArr[j.c.RELEASED.ordinal()] = 9;
            iArr[j.c.ERROR.ordinal()] = 10;
            a = iArr;
        }
    }

    /* JADX INFO: compiled from: VideoAdMediaPlayer.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/kakao/adfit/d/w$c", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class c extends Handler {

        /* JADX INFO: compiled from: VideoAdMediaPlayer.kt */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[j.c.values().length];
                iArr[j.c.PREPARED.ordinal()] = 1;
                iArr[j.c.STARTED.ordinal()] = 2;
                iArr[j.c.PAUSED.ordinal()] = 3;
                iArr[j.c.COMPLETED.ordinal()] = 4;
                a = iArr;
            }
        }

        c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            w wVar = w.this;
            int i = msg.what;
            if (i == 1) {
                Function2<j, Integer, Unit> function2I = wVar.i();
                if (function2I == null) {
                    return;
                }
                int i2 = a.a[wVar.getState().ordinal()];
                if (i2 != 1 && i2 != 2 && i2 != 3) {
                    if (i2 != 4) {
                        return;
                    }
                    function2I.invoke(wVar, Integer.valueOf(wVar.f()));
                    return;
                } else {
                    function2I.invoke(wVar, Integer.valueOf(wVar.l()));
                    if (!wVar.b() || hasMessages(1)) {
                        return;
                    }
                    sendEmptyMessageDelayed(1, 100L);
                    return;
                }
            }
            if (i == 2) {
                Function2<j, j.b, Unit> function2H = wVar.h();
                if (function2H != null) {
                    Object obj = msg.obj;
                    j.b bVar = obj instanceof j.b ? (j.b) obj : null;
                    if (bVar == null) {
                        return;
                    }
                    function2H.invoke(wVar, bVar);
                    return;
                }
                return;
            }
            if (i == 3 && wVar.getState() == j.c.PREPARING) {
                com.kakao.adfit.k.f.b("MediaPlayer Timeout");
                w.this.b(j.c.ERROR);
                Function2<j, j.b, Unit> function2H2 = wVar.h();
                if (function2H2 != null) {
                    function2H2.invoke(wVar, j.b.TIMEOUT_ERROR);
                }
            }
        }
    }

    public w(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.path = path;
        this.state = j.c.IDLE;
        this.volume = 1.0f;
        this.changingStates = new ArrayList<>();
        this.handler = new c(Looper.getMainLooper());
    }

    private final void a(String step) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(w this$0, MediaPlayer mediaPlayer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.i() == null || !this$0.d()) {
            return;
        }
        this$0.handler.sendEmptyMessage(1);
    }

    private final MediaPlayer e() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        if (Build.VERSION.SDK_INT >= 24) {
            mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(3).build());
        } else {
            mediaPlayer.setAudioStreamType(3);
        }
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.kakao.adfit.d.-$$Lambda$w$ervj-Bbxd9G6TuBYu_Ub77i6rVU
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer2) {
                w.a(this.f$0, mediaPlayer2);
            }
        });
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.kakao.adfit.d.-$$Lambda$w$NRTM_1hb0ZhiqbAlw10AXvqmhqo
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer2) {
                w.b(this.f$0, mediaPlayer2);
            }
        });
        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.kakao.adfit.d.-$$Lambda$w$LeePZ7kA603-W2ziNfBU6Y0iDYE
            @Override // android.media.MediaPlayer.OnErrorListener
            public final boolean onError(MediaPlayer mediaPlayer2, int i, int i2) {
                return w.a(this.f$0, mediaPlayer2, i, i2);
            }
        });
        mediaPlayer.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() { // from class: com.kakao.adfit.d.-$$Lambda$w$VKpGvQDGO-oJFGoROqeNo4riNQM
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public final void onSeekComplete(MediaPlayer mediaPlayer2) {
                w.c(this.f$0, mediaPlayer2);
            }
        });
        return mediaPlayer;
    }

    private final void p() {
        if (getState() != j.c.STARTED) {
            if (getState() == j.c.COMPLETED) {
                return;
            }
            a("onCompleted()");
            return;
        }
        if (this.latestPosition < f()) {
            this.latestPosition = f();
            if (i() != null) {
                this.handler.sendEmptyMessage(1);
            }
        }
        if (this.actionWhenPrepared == 1) {
            this.actionWhenPrepared = 0;
        }
        b(j.c.COMPLETED);
    }

    private final void q() {
        if (getState() != j.c.PREPARING) {
            if (d()) {
                return;
            }
            a("onPrepared()");
            return;
        }
        b(j.c.PREPARED);
        MediaPlayer mediaPlayer = null;
        try {
            MediaPlayer mediaPlayer2 = this.player;
            if (mediaPlayer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("player");
                mediaPlayer2 = null;
            }
            mediaPlayer2.setVolume(getVolume(), getVolume());
        } catch (Exception e) {
            a("setVolume()", e);
        }
        int iF = f();
        int i = this.latestPosition;
        if (500 <= i && i < iF) {
            try {
                MediaPlayer mediaPlayer3 = this.player;
                if (mediaPlayer3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("player");
                } else {
                    mediaPlayer = mediaPlayer3;
                }
                mediaPlayer.seekTo(this.latestPosition);
            } catch (Exception e2) {
                a("seekTo()", e2);
            }
        }
        int i2 = this.actionWhenPrepared;
        if (i2 == 1) {
            play();
        } else if (i2 == 2) {
            r();
        }
        if (i() != null) {
            this.handler.sendEmptyMessage(1);
        }
    }

    @Override // com.kakao.adfit.d.j
    public boolean b() {
        return j.a.a(this);
    }

    @Override // com.kakao.adfit.d.j
    public boolean d() {
        return j.a.b(this);
    }

    public int f() {
        if (!d()) {
            return 0;
        }
        try {
            MediaPlayer mediaPlayer = this.player;
            if (mediaPlayer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("player");
                mediaPlayer = null;
            }
            return mediaPlayer.getDuration();
        } catch (Exception e) {
            a("getDuration()", e);
            return 0;
        }
    }

    public boolean g() {
        if (!d()) {
            return false;
        }
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
            mediaPlayer = null;
        }
        MediaPlayer.TrackInfo[] trackInfo = mediaPlayer.getTrackInfo();
        Intrinsics.checkNotNullExpressionValue(trackInfo, "player.trackInfo");
        for (MediaPlayer.TrackInfo trackInfo2 : trackInfo) {
            if (trackInfo2.getTrackType() == 2) {
                return true;
            }
        }
        return false;
    }

    @Override // com.kakao.adfit.d.j
    public j.c getState() {
        return this.state;
    }

    @Override // com.kakao.adfit.d.j
    public Surface getSurface() {
        return this.surface;
    }

    public Function2<j, j.b, Unit> h() {
        return this.onErrorOccurred;
    }

    public Function2<j, Integer, Unit> i() {
        return this.onProgressChanged;
    }

    public Function2<j, j.c, Unit> j() {
        return this.onStateChanged;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public String getPath() {
        return this.path;
    }

    public int l() {
        int i = b.a[getState().ordinal()];
        if (i != 1 && i != 2 && i != 3) {
            if (i != 4) {
                return 0;
            }
            return f();
        }
        try {
            MediaPlayer mediaPlayer = this.player;
            if (mediaPlayer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("player");
                mediaPlayer = null;
            }
            return mediaPlayer.getCurrentPosition();
        } catch (Exception e) {
            a("getCurrentPosition()", e);
            return 0;
        }
    }

    public int m() {
        if (!d()) {
            return 0;
        }
        try {
            MediaPlayer mediaPlayer = this.player;
            if (mediaPlayer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("player");
                mediaPlayer = null;
            }
            return mediaPlayer.getVideoHeight();
        } catch (Exception e) {
            a("getVideoHeight()", e);
            return 0;
        }
    }

    public int n() {
        if (!d()) {
            return 0;
        }
        try {
            MediaPlayer mediaPlayer = this.player;
            if (mediaPlayer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("player");
                mediaPlayer = null;
            }
            return mediaPlayer.getVideoWidth();
        } catch (Exception e) {
            a("getVideoWidth()", e);
            return 0;
        }
    }

    /* JADX INFO: renamed from: o, reason: from getter */
    public float getVolume() {
        return this.volume;
    }

    @Override // com.kakao.adfit.d.j
    public void pause() {
        this.actionWhenPrepared = 0;
        int i = b.a[getState().ordinal()];
        if (i != 2 && i != 3) {
            if (i == 9 || i == 10) {
                a("pause()");
                return;
            }
            return;
        }
        MediaPlayer mediaPlayer = null;
        try {
            try {
                if (b()) {
                    MediaPlayer mediaPlayer2 = this.player;
                    if (mediaPlayer2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("player");
                        mediaPlayer2 = null;
                    }
                    if (mediaPlayer2.isPlaying()) {
                        this.latestPosition = Math.max(l(), this.latestPosition);
                    }
                }
            } catch (Exception e) {
                a("isPlaying()", e);
            }
            MediaPlayer mediaPlayer3 = this.player;
            if (mediaPlayer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("player");
            } else {
                mediaPlayer = mediaPlayer3;
            }
            mediaPlayer.pause();
            b(j.c.PAUSED);
        } catch (Exception e2) {
            a("pause()", e2);
            b(j.c.ERROR);
        }
    }

    @Override // com.kakao.adfit.d.j
    public void play() {
        this.actionWhenPrepared = 1;
        int i = b.a[getState().ordinal()];
        if (i == 9 || i == 10) {
            a("play()");
            return;
        }
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            try {
                MediaPlayer mediaPlayer = this.player;
                if (mediaPlayer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("player");
                    mediaPlayer = null;
                }
                mediaPlayer.start();
                b(j.c.STARTED);
                if (i() != null) {
                    this.handler.sendEmptyMessage(1);
                }
            } catch (Exception e) {
                a("start()", e);
                b(j.c.ERROR);
            }
        }
    }

    public void r() {
        this.actionWhenPrepared = 2;
        int i = b.a[getState().ordinal()];
        if (i != 1 && i != 2 && i != 3 && i != 4 && i != 7) {
            if (i == 9 || i == 10) {
                a("stop()");
                return;
            }
            return;
        }
        MediaPlayer mediaPlayer = null;
        try {
            try {
                if (b()) {
                    MediaPlayer mediaPlayer2 = this.player;
                    if (mediaPlayer2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("player");
                        mediaPlayer2 = null;
                    }
                    if (mediaPlayer2.isPlaying()) {
                        this.latestPosition = Math.max(l(), this.latestPosition);
                    }
                }
            } catch (Exception e) {
                a("isPlaying()", e);
            }
            try {
                MediaPlayer mediaPlayer3 = this.player;
                if (mediaPlayer3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("player");
                    mediaPlayer3 = null;
                }
                mediaPlayer3.setSurface(null);
            } catch (Exception unused) {
            }
            MediaPlayer mediaPlayer4 = this.player;
            if (mediaPlayer4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("player");
            } else {
                mediaPlayer = mediaPlayer4;
            }
            mediaPlayer.stop();
            b(j.c.STOPPED);
        } catch (Exception e2) {
            a("stop()", e2);
            b(j.c.ERROR);
        }
    }

    @Override // com.kakao.adfit.d.j
    public void setVolume(float f) {
        this.volume = f;
        if (d()) {
            try {
                MediaPlayer mediaPlayer = this.player;
                if (mediaPlayer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("player");
                    mediaPlayer = null;
                }
                mediaPlayer.setVolume(f, f);
            } catch (Exception e) {
                a("setVolume()", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(j.c cVar) {
        j.c cVar2 = this.state;
        if (cVar2 != cVar) {
            if (cVar2 == j.c.PREPARING) {
                this.handler.removeMessages(3);
            }
            this.state = cVar;
            a(cVar);
        }
    }

    @Override // com.kakao.adfit.d.j
    public void a(Surface surface) {
        if (Intrinsics.areEqual(this.surface, surface)) {
            return;
        }
        this.surface = surface;
        boolean z = false;
        MediaPlayer mediaPlayer = null;
        if (!(surface != null && surface.isValid())) {
            j.c state = getState();
            if (state != j.c.IDLE && state != j.c.RELEASED) {
                z = true;
            }
            if (z) {
                try {
                    MediaPlayer mediaPlayer2 = this.player;
                    if (mediaPlayer2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("player");
                        mediaPlayer2 = null;
                    }
                    mediaPlayer2.setSurface(null);
                    return;
                } catch (Exception e) {
                    a("setSurface()", e);
                    return;
                }
            }
            return;
        }
        j.c state2 = getState();
        if (state2 != j.c.IDLE && state2 != j.c.RELEASED && state2 != j.c.ERROR) {
            z = true;
        }
        if (z) {
            try {
                MediaPlayer mediaPlayer3 = this.player;
                if (mediaPlayer3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("player");
                } else {
                    mediaPlayer = mediaPlayer3;
                }
                mediaPlayer.setSurface(surface);
            } catch (Exception e2) {
                a("setSurface()", e2);
                b(j.c.ERROR);
            }
        }
    }

    @Override // com.kakao.adfit.d.j
    public void c() {
        boolean z = false;
        if (this.actionWhenPrepared == 2) {
            this.actionWhenPrepared = 0;
        }
        int i = b.a[getState().ordinal()];
        MediaPlayer mediaPlayer = null;
        if (i == 5) {
            this.player = e();
            try {
                if (getPath().length() == 0) {
                    a("setDataSource()", new RuntimeException("\"path\" is empty."));
                    b(j.c.ERROR);
                    return;
                }
                MediaPlayer mediaPlayer2 = this.player;
                if (mediaPlayer2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("player");
                } else {
                    mediaPlayer = mediaPlayer2;
                }
                mediaPlayer.setDataSource(getPath());
                b(j.c.INITIALIZED);
                c();
                return;
            } catch (Exception e) {
                a("setDataSource()", e);
                b(j.c.ERROR);
                return;
            }
        }
        if (i != 6 && i != 7) {
            if (i == 9 || i == 10) {
                a("prepare()");
                return;
            }
            return;
        }
        Surface surface = getSurface();
        if (surface != null && surface.isValid()) {
            z = true;
        }
        if (z) {
            try {
                MediaPlayer mediaPlayer3 = this.player;
                if (mediaPlayer3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("player");
                    mediaPlayer3 = null;
                }
                mediaPlayer3.setSurface(surface);
            } catch (Exception e2) {
                a("setSurface()", e2);
                b(j.c.ERROR);
                return;
            }
        }
        try {
            MediaPlayer mediaPlayer4 = this.player;
            if (mediaPlayer4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("player");
            } else {
                mediaPlayer = mediaPlayer4;
            }
            mediaPlayer.prepareAsync();
            b(j.c.PREPARING);
            if (this.handler.hasMessages(3)) {
                return;
            }
            this.handler.sendEmptyMessageDelayed(3, 5000L);
        } catch (Exception e3) {
            a("prepareAsync()", e3);
            b(j.c.ERROR);
        }
    }

    @Override // com.kakao.adfit.d.j
    public void b(Function2<? super j, ? super j.c, Unit> function2) {
        if (Intrinsics.areEqual(this.onStateChanged, function2)) {
            return;
        }
        this.onStateChanged = function2;
        this.changingStates.clear();
        if (function2 != null) {
            a(getState());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(w this$0, MediaPlayer mediaPlayer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.p();
    }

    @Override // com.kakao.adfit.d.j
    public void a(Function2<? super j, ? super Integer, Unit> function2) {
        if (Intrinsics.areEqual(this.onProgressChanged, function2)) {
            return;
        }
        this.onProgressChanged = function2;
        this.handler.removeMessages(1);
        if (function2 == null || !d()) {
            return;
        }
        this.handler.sendEmptyMessage(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(w this$0, MediaPlayer mediaPlayer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(w this$0, MediaPlayer mediaPlayer, int i, int i2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a(i, i2);
        j.c state = this$0.getState();
        if ((state == j.c.RELEASED || state == j.c.ERROR) ? false : true) {
            this$0.b(j.c.ERROR);
            this$0.handler.obtainMessage(2, j.b.UNKNOWN_ERROR);
        }
        return true;
    }

    public void a(int ms) {
        j.c state = getState();
        if (state == j.c.PREPARED || state == j.c.STARTED || state == j.c.PAUSED) {
            try {
                MediaPlayer mediaPlayer = this.player;
                if (mediaPlayer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("player");
                    mediaPlayer = null;
                }
                mediaPlayer.seekTo(ms);
                return;
            } catch (Exception e) {
                a("seekTo()", e);
                return;
            }
        }
        a("seekTo()");
    }

    @Override // com.kakao.adfit.d.j
    public void a() {
        MediaPlayer mediaPlayer;
        if (getState() != j.c.IDLE && (mediaPlayer = this.player) != null) {
            MediaPlayer mediaPlayer2 = null;
            if (mediaPlayer == null) {
                try {
                    Intrinsics.throwUninitializedPropertyAccessException("player");
                    mediaPlayer = null;
                } catch (Exception unused) {
                }
            }
            mediaPlayer.setSurface(null);
            try {
                MediaPlayer mediaPlayer3 = this.player;
                if (mediaPlayer3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("player");
                } else {
                    mediaPlayer2 = mediaPlayer3;
                }
                mediaPlayer2.release();
            } catch (Exception e) {
                a("release()", e);
            }
        }
        b(j.c.RELEASED);
    }

    private final void a(j.c newState) {
        Function2<j, j.c, Unit> function2J = j();
        if (function2J == null) {
            return;
        }
        this.changingStates.add(newState);
        if (this.changingStates.size() > 1) {
            return;
        }
        do {
            function2J.invoke(this, newState);
            if (!Intrinsics.areEqual(j(), function2J)) {
                return;
            }
            this.changingStates.remove(0);
            newState = (j.c) CollectionsKt.firstOrNull((List) this.changingStates);
        } while (newState != null);
    }

    private final void a(int what, int extra) {
        com.kakao.adfit.k.f.b("MediaPlayer Runtime Error: state = " + getState() + ", error = " + what + '/' + extra);
    }

    private final void a(String step, Exception e) {
        com.kakao.adfit.k.f.b("Failed to call MediaPlayer#" + step + ": state = " + getState() + ", " + e);
    }
}
