package com.twobigears.audio360;

/* JADX INFO: loaded from: classes4.dex */
public enum EngineError {
    INVALID_PARAM(-23),
    INVALID_QUALITY(-22),
    QUEUE_FULL(-21),
    BAD_THREAD(-20),
    NOT_SUPPORTED(-19),
    NO_AUDIO_DEVICE(-18),
    COULD_NOT_CONNECT(-17),
    MEMORY_MAP_FAIL(-16),
    INVALID_URL_FORMAT(-15),
    ERROR_OPENING_TEMP_FILE(-14),
    INVALID_HEADER(-13),
    CURL_FAIL(-12),
    INVALID_CHANNEL_COUNT(-11),
    CANNOT_INIT_DECODER(-10),
    ERROR_OPENING_FILE(-9),
    NO_ASSET(-8),
    CANNOT_ALLOCATE_MEMORY(-7),
    CANNOT_CREATE_AUDIO_DEVICE(-6),
    CANNOT_INITIALISE_CORE(-5),
    INVALID_BUFFER_SIZE(-4),
    INVALID_SAMPLE_RATE(-3),
    NO_OBJECTS_IN_POOL(-2),
    FAIL(-1),
    OK(0);

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static EngineError swigToEnum(int i) {
        EngineError[] engineErrorArr = (EngineError[]) EngineError.class.getEnumConstants();
        if (i < engineErrorArr.length && i >= 0 && engineErrorArr[i].swigValue == i) {
            return engineErrorArr[i];
        }
        for (EngineError engineError : engineErrorArr) {
            if (engineError.swigValue == i) {
                return engineError;
            }
        }
        throw new IllegalArgumentException("No enum " + EngineError.class + " with value " + i);
    }

    EngineError() {
        this.swigValue = SwigNext.access$008();
    }

    EngineError(int i) {
        this.swigValue = i;
        int unused = SwigNext.next = i + 1;
    }

    EngineError(EngineError engineError) {
        int i = engineError.swigValue;
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
