package com.twobigears.audio360;

/* JADX INFO: loaded from: classes4.dex */
public class Audio360 {
    public static int getNumChannelsForMap(ChannelMap channelMap) {
        return Audio360JNI.getNumChannelsForMap(channelMap.swigValue());
    }

    public static AudioSettings getAudioSettings_default() {
        long jAudioSettings_default_get = Audio360JNI.AudioSettings_default_get();
        if (jAudioSettings_default_get == 0) {
            return null;
        }
        return new AudioSettings(jAudioSettings_default_get, false);
    }

    public static NetworkSettings getNetworkSettings_default() {
        long jNetworkSettings_default_get = Audio360JNI.NetworkSettings_default_get();
        if (jNetworkSettings_default_get == 0) {
            return null;
        }
        return new NetworkSettings(jNetworkSettings_default_get, false);
    }

    public static MemorySettings getMemorySettings_default() {
        long jMemorySettings_default_get = Audio360JNI.MemorySettings_default_get();
        if (jMemorySettings_default_get == 0) {
            return null;
        }
        return new MemorySettings(jMemorySettings_default_get, false);
    }

    public static EngineInitSettings getEngineInitSettings_default() {
        long jEngineInitSettings_default_get = Audio360JNI.EngineInitSettings_default_get();
        if (jEngineInitSettings_default_get == 0) {
            return null;
        }
        return new EngineInitSettings(jEngineInitSettings_default_get, false);
    }

    public static long getKMaxStrSize() {
        return Audio360JNI.kMaxStrSize_get();
    }
}
