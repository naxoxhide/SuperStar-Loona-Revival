package com.twobigears.audio360;

/* JADX INFO: loaded from: classes4.dex */
public class EngineInitSettings {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected EngineInitSettings(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(EngineInitSettings engineInitSettings) {
        if (engineInitSettings == null) {
            return 0L;
        }
        return engineInitSettings.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                Audio360JNI.delete_EngineInitSettings(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setAudioSettings(AudioSettings audioSettings) {
        Audio360JNI.EngineInitSettings_audioSettings_set(this.swigCPtr, this, AudioSettings.getCPtr(audioSettings), audioSettings);
    }

    public AudioSettings getAudioSettings() {
        long jEngineInitSettings_audioSettings_get = Audio360JNI.EngineInitSettings_audioSettings_get(this.swigCPtr, this);
        if (jEngineInitSettings_audioSettings_get == 0) {
            return null;
        }
        return new AudioSettings(jEngineInitSettings_audioSettings_get, false);
    }

    public void setMemorySettings(MemorySettings memorySettings) {
        Audio360JNI.EngineInitSettings_memorySettings_set(this.swigCPtr, this, MemorySettings.getCPtr(memorySettings), memorySettings);
    }

    public MemorySettings getMemorySettings() {
        long jEngineInitSettings_memorySettings_get = Audio360JNI.EngineInitSettings_memorySettings_get(this.swigCPtr, this);
        if (jEngineInitSettings_memorySettings_get == 0) {
            return null;
        }
        return new MemorySettings(jEngineInitSettings_memorySettings_get, false);
    }

    public void setPlatformSettings(PlatformSettings platformSettings) {
        Audio360JNI.EngineInitSettings_platformSettings_set(this.swigCPtr, this, PlatformSettings.getCPtr(platformSettings), platformSettings);
    }

    public PlatformSettings getPlatformSettings() {
        long jEngineInitSettings_platformSettings_get = Audio360JNI.EngineInitSettings_platformSettings_get(this.swigCPtr, this);
        if (jEngineInitSettings_platformSettings_get == 0) {
            return null;
        }
        return new PlatformSettings(jEngineInitSettings_platformSettings_get, false);
    }

    public void setThreads(ThreadSettings threadSettings) {
        Audio360JNI.EngineInitSettings_threads_set(this.swigCPtr, this, ThreadSettings.getCPtr(threadSettings), threadSettings);
    }

    public ThreadSettings getThreads() {
        long jEngineInitSettings_threads_get = Audio360JNI.EngineInitSettings_threads_get(this.swigCPtr, this);
        if (jEngineInitSettings_threads_get == 0) {
            return null;
        }
        return new ThreadSettings(jEngineInitSettings_threads_get, false);
    }

    public void setExperimental(Experimental experimental) {
        Audio360JNI.EngineInitSettings_experimental_set(this.swigCPtr, this, Experimental.getCPtr(experimental), experimental);
    }

    public Experimental getExperimental() {
        long jEngineInitSettings_experimental_get = Audio360JNI.EngineInitSettings_experimental_get(this.swigCPtr, this);
        if (jEngineInitSettings_experimental_get == 0) {
            return null;
        }
        return new Experimental(jEngineInitSettings_experimental_get, false);
    }

    public EngineInitSettings() {
        this(Audio360JNI.new_EngineInitSettings(), true);
    }
}
