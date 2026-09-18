package com.twobigears.audio360;

/* JADX INFO: loaded from: classes4.dex */
public enum ChannelMap {
    TBE_8_2,
    TBE_8,
    TBE_6_2,
    TBE_6,
    TBE_4_2,
    TBE_4,
    TBE_8_PAIR0,
    TBE_8_PAIR1,
    TBE_8_PAIR2,
    TBE_8_PAIR3,
    TBE_CHANNEL0,
    TBE_CHANNEL1,
    TBE_CHANNEL2,
    TBE_CHANNEL3,
    TBE_CHANNEL4,
    TBE_CHANNEL5,
    TBE_CHANNEL6,
    TBE_CHANNEL7,
    HEADLOCKED_STEREO,
    HEADLOCKED_CHANNEL0,
    HEADLOCKED_CHANNEL1,
    AMBIX_4,
    AMBIX_9,
    AMBIX_9_2,
    AMBIX_16,
    AMBIX_16_2,
    STEREO,
    INVALID;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static ChannelMap swigToEnum(int i) {
        ChannelMap[] channelMapArr = (ChannelMap[]) ChannelMap.class.getEnumConstants();
        if (i < channelMapArr.length && i >= 0 && channelMapArr[i].swigValue == i) {
            return channelMapArr[i];
        }
        for (ChannelMap channelMap : channelMapArr) {
            if (channelMap.swigValue == i) {
                return channelMap;
            }
        }
        throw new IllegalArgumentException("No enum " + ChannelMap.class + " with value " + i);
    }

    ChannelMap() {
        this.swigValue = SwigNext.access$008();
    }

    ChannelMap(int i) {
        this.swigValue = i;
        int unused = SwigNext.next = i + 1;
    }

    ChannelMap(ChannelMap channelMap) {
        int i = channelMap.swigValue;
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
