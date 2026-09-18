package com.twobigears.audio360;

/* JADX INFO: loaded from: classes4.dex */
public enum AttenuationMode {
    LOGARITHMIC,
    LINEAR,
    DISABLE;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static AttenuationMode swigToEnum(int i) {
        AttenuationMode[] attenuationModeArr = (AttenuationMode[]) AttenuationMode.class.getEnumConstants();
        if (i < attenuationModeArr.length && i >= 0 && attenuationModeArr[i].swigValue == i) {
            return attenuationModeArr[i];
        }
        for (AttenuationMode attenuationMode : attenuationModeArr) {
            if (attenuationMode.swigValue == i) {
                return attenuationMode;
            }
        }
        throw new IllegalArgumentException("No enum " + AttenuationMode.class + " with value " + i);
    }

    AttenuationMode() {
        this.swigValue = SwigNext.access$008();
    }

    AttenuationMode(int i) {
        this.swigValue = i;
        int unused = SwigNext.next = i + 1;
    }

    AttenuationMode(AttenuationMode attenuationMode) {
        int i = attenuationMode.swigValue;
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
