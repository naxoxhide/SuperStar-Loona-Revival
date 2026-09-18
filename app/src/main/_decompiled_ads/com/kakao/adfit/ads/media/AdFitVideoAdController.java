package com.kakao.adfit.ads.media;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tapjoy.TapjoyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AdFitVideoAdController.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000f\bg\u0018\u00002\u00020\u0001:\u0001&J\b\u0010\"\u001a\u00020\rH\u0016J\b\u0010#\u001a\u00020\rH&J\b\u0010$\u001a\u00020\rH&J\b\u0010%\u001a\u00020\rH\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R5\u0010\b\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\tX¦\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R5\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\r\u0018\u00010\tX¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0011R5\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\r\u0018\u00010\tX¦\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R\u0012\u0010\u0014\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0019\u001a\u00020\u0018X¦\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006'"}, d2 = {"Lcom/kakao/adfit/ads/media/AdFitVideoAdController;", "", "currentPosition", "", "getCurrentPosition", "()I", "duration", "getDuration", "onProgressChangedListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "position", "", "getOnProgressChangedListener", "()Lkotlin/jvm/functions/Function1;", "setOnProgressChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "onStateChangedListener", "Lcom/kakao/adfit/ads/media/AdFitVideoAdController$State;", "state", "getOnStateChangedListener", "setOnStateChangedListener", "onVolumeChangedListener", "", TapjoyConstants.TJC_VOLUME, "getOnVolumeChangedListener", "setOnVolumeChangedListener", "getState", "()Lcom/kakao/adfit/ads/media/AdFitVideoAdController$State;", "getVolume", "()F", "setVolume", "(F)V", CampaignEx.JSON_NATIVE_VIDEO_MUTE, CampaignEx.JSON_NATIVE_VIDEO_PAUSE, "play", CampaignEx.JSON_NATIVE_VIDEO_UNMUTE, "State", "library_networkRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface AdFitVideoAdController {

    /* JADX INFO: compiled from: AdFitVideoAdController.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/kakao/adfit/ads/media/AdFitVideoAdController$State;", "", "(Ljava/lang/String;I)V", "IDLE", "INITIALIZED", "LOADING", "PLAYING", "PAUSED", "COMPLETED", "ERROR", "library_networkRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum State {
        IDLE,
        INITIALIZED,
        LOADING,
        PLAYING,
        PAUSED,
        COMPLETED,
        ERROR
    }

    /* JADX INFO: compiled from: AdFitVideoAdController.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public static void a(AdFitVideoAdController adFitVideoAdController) {
            adFitVideoAdController.setVolume(0.0f);
        }

        public static void b(AdFitVideoAdController adFitVideoAdController) {
            adFitVideoAdController.setVolume(1.0f);
        }
    }

    int getCurrentPosition();

    int getDuration();

    Function1<Integer, Unit> getOnProgressChangedListener();

    Function1<State, Unit> getOnStateChangedListener();

    Function1<Float, Unit> getOnVolumeChangedListener();

    State getState();

    float getVolume();

    void mute();

    void pause();

    void play();

    void setOnProgressChangedListener(Function1<? super Integer, Unit> function1);

    void setOnStateChangedListener(Function1<? super State, Unit> function1);

    void setOnVolumeChangedListener(Function1<? super Float, Unit> function1);

    void setVolume(float f);

    void unmute();
}
