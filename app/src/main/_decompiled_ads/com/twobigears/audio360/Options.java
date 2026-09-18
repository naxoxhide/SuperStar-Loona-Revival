package com.twobigears.audio360;

/* JADX INFO: loaded from: classes4.dex */
public enum Options {
    DEFAULT(0),
    DECODE_IN_AUDIO_CALLBACK(1);

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static Options swigToEnum(int i) {
        Options[] optionsArr = (Options[]) Options.class.getEnumConstants();
        if (i < optionsArr.length && i >= 0 && optionsArr[i].swigValue == i) {
            return optionsArr[i];
        }
        for (Options options : optionsArr) {
            if (options.swigValue == i) {
                return options;
            }
        }
        throw new IllegalArgumentException("No enum " + Options.class + " with value " + i);
    }

    Options() {
        this.swigValue = SwigNext.access$008();
    }

    Options(int i) {
        this.swigValue = i;
        int unused = SwigNext.next = i + 1;
    }

    Options(Options options) {
        int i = options.swigValue;
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
