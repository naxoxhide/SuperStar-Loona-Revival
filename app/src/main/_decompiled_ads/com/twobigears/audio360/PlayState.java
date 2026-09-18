package com.twobigears.audio360;

/* JADX INFO: loaded from: classes4.dex */
public enum PlayState {
    PLAYING,
    PAUSED,
    STOPPED,
    INVALID;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static PlayState swigToEnum(int i) {
        PlayState[] playStateArr = (PlayState[]) PlayState.class.getEnumConstants();
        if (i < playStateArr.length && i >= 0 && playStateArr[i].swigValue == i) {
            return playStateArr[i];
        }
        for (PlayState playState : playStateArr) {
            if (playState.swigValue == i) {
                return playState;
            }
        }
        throw new IllegalArgumentException("No enum " + PlayState.class + " with value " + i);
    }

    PlayState() {
        this.swigValue = SwigNext.access$008();
    }

    PlayState(int i) {
        this.swigValue = i;
        int unused = SwigNext.next = i + 1;
    }

    PlayState(PlayState playState) {
        int i = playState.swigValue;
        this.swigValue = i;
        int unused = SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }

        static /* synthetic */ int access$008() {
            int i = next;
            next = i + 1;
            return i;
        }
    }
}
