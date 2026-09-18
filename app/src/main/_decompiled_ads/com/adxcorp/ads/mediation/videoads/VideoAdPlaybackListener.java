package com.adxcorp.ads.mediation.videoads;

/* JADX INFO: loaded from: classes.dex */
public interface VideoAdPlaybackListener {
    void onVideoAdStarted();

    void onVideoFinished(FinishState finishState);
}
