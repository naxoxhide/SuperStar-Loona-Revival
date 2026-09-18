package com.twobigears.audio360;

/* JADX INFO: loaded from: classes4.dex */
public enum SyncMode {
    INTERNAL,
    EXTERNAL;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static SyncMode swigToEnum(int i) {
        SyncMode[] syncModeArr = (SyncMode[]) SyncMode.class.getEnumConstants();
        if (i < syncModeArr.length && i >= 0 && syncModeArr[i].swigValue == i) {
            return syncModeArr[i];
        }
        for (SyncMode syncMode : syncModeArr) {
            if (syncMode.swigValue == i) {
                return syncMode;
            }
        }
        throw new IllegalArgumentException("No enum " + SyncMode.class + " with value " + i);
    }

    SyncMode() {
        this.swigValue = SwigNext.access$008();
    }

    SyncMode(int i) {
        this.swigValue = i;
        int unused = SwigNext.next = i + 1;
    }

    SyncMode(SyncMode syncMode) {
        int i = syncMode.swigValue;
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
