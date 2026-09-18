package com.twobigears.audio360;

/* JADX INFO: loaded from: classes4.dex */
public enum AudioDeviceType {
    DEFAULT,
    CUSTOM,
    DISABLED;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static AudioDeviceType swigToEnum(int i) {
        AudioDeviceType[] audioDeviceTypeArr = (AudioDeviceType[]) AudioDeviceType.class.getEnumConstants();
        if (i < audioDeviceTypeArr.length && i >= 0 && audioDeviceTypeArr[i].swigValue == i) {
            return audioDeviceTypeArr[i];
        }
        for (AudioDeviceType audioDeviceType : audioDeviceTypeArr) {
            if (audioDeviceType.swigValue == i) {
                return audioDeviceType;
            }
        }
        throw new IllegalArgumentException("No enum " + AudioDeviceType.class + " with value " + i);
    }

    AudioDeviceType() {
        this.swigValue = SwigNext.access$008();
    }

    AudioDeviceType(int i) {
        this.swigValue = i;
        int unused = SwigNext.next = i + 1;
    }

    AudioDeviceType(AudioDeviceType audioDeviceType) {
        int i = audioDeviceType.swigValue;
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
