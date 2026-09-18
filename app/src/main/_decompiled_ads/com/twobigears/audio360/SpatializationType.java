package com.twobigears.audio360;

/* JADX INFO: loaded from: classes4.dex */
public enum SpatializationType {
    AMBISONICS,
    BINAURAL;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static SpatializationType swigToEnum(int i) {
        SpatializationType[] spatializationTypeArr = (SpatializationType[]) SpatializationType.class.getEnumConstants();
        if (i < spatializationTypeArr.length && i >= 0 && spatializationTypeArr[i].swigValue == i) {
            return spatializationTypeArr[i];
        }
        for (SpatializationType spatializationType : spatializationTypeArr) {
            if (spatializationType.swigValue == i) {
                return spatializationType;
            }
        }
        throw new IllegalArgumentException("No enum " + SpatializationType.class + " with value " + i);
    }

    SpatializationType() {
        this.swigValue = SwigNext.access$008();
    }

    SpatializationType(int i) {
        this.swigValue = i;
        int unused = SwigNext.next = i + 1;
    }

    SpatializationType(SpatializationType spatializationType) {
        int i = spatializationType.swigValue;
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
