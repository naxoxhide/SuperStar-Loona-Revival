package com.twobigears.audio360;

/* JADX INFO: loaded from: classes4.dex */
public class MemorySettings {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MemorySettings(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MemorySettings memorySettings) {
        if (memorySettings == null) {
            return 0L;
        }
        return memorySettings.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                Audio360JNI.delete_MemorySettings(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setSpatDecoderQueuePoolSize(int i) {
        Audio360JNI.MemorySettings_spatDecoderQueuePoolSize_set(this.swigCPtr, this, i);
    }

    public int getSpatDecoderQueuePoolSize() {
        return Audio360JNI.MemorySettings_spatDecoderQueuePoolSize_get(this.swigCPtr, this);
    }

    public void setSpatDecoderFilePoolSize(int i) {
        Audio360JNI.MemorySettings_spatDecoderFilePoolSize_set(this.swigCPtr, this, i);
    }

    public int getSpatDecoderFilePoolSize() {
        return Audio360JNI.MemorySettings_spatDecoderFilePoolSize_get(this.swigCPtr, this);
    }

    public void setSpatQueueSizePerChannel(int i) {
        Audio360JNI.MemorySettings_spatQueueSizePerChannel_set(this.swigCPtr, this, i);
    }

    public int getSpatQueueSizePerChannel() {
        return Audio360JNI.MemorySettings_spatQueueSizePerChannel_get(this.swigCPtr, this);
    }

    public void setAudioObjectPoolSize(int i) {
        Audio360JNI.MemorySettings_audioObjectPoolSize_set(this.swigCPtr, this, i);
    }

    public int getAudioObjectPoolSize() {
        return Audio360JNI.MemorySettings_audioObjectPoolSize_get(this.swigCPtr, this);
    }

    public void setSpeakersVirtualizersPoolSize(long j) {
        Audio360JNI.MemorySettings_speakersVirtualizersPoolSize_set(this.swigCPtr, this, j);
    }

    public long getSpeakersVirtualizersPoolSize() {
        return Audio360JNI.MemorySettings_speakersVirtualizersPoolSize_get(this.swigCPtr, this);
    }

    public MemorySettings() {
        this(Audio360JNI.new_MemorySettings(), true);
    }
}
