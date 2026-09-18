package com.twobigears.audio360;

/* JADX INFO: loaded from: classes4.dex */
public enum Event {
    ERROR_BUFFER_UNDERRUN,
    ERROR_QUEUE_STARVATION,
    DECODER_INIT,
    END_OF_STREAM,
    LOOPED,
    PLAY_STATE_CHANGED,
    INVALID;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static Event swigToEnum(int i) {
        Event[] eventArr = (Event[]) Event.class.getEnumConstants();
        if (i < eventArr.length && i >= 0 && eventArr[i].swigValue == i) {
            return eventArr[i];
        }
        for (Event event : eventArr) {
            if (event.swigValue == i) {
                return event;
            }
        }
        throw new IllegalArgumentException("No enum " + Event.class + " with value " + i);
    }

    Event() {
        this.swigValue = SwigNext.access$008();
    }

    Event(int i) {
        this.swigValue = i;
        int unused = SwigNext.next = i + 1;
    }

    Event(Event event) {
        int i = event.swigValue;
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
