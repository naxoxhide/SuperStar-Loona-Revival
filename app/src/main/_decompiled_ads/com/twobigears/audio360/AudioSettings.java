package com.twobigears.audio360;

/* JADX INFO: loaded from: classes4.dex */
public class AudioSettings {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected AudioSettings(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(AudioSettings audioSettings) {
        if (audioSettings == null) {
            return 0L;
        }
        return audioSettings.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                Audio360JNI.delete_AudioSettings(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setSampleRate(float f) {
        Audio360JNI.AudioSettings_sampleRate_set(this.swigCPtr, this, f);
    }

    public float getSampleRate() {
        return Audio360JNI.AudioSettings_sampleRate_get(this.swigCPtr, this);
    }

    public void setBufferSize(int i) {
        Audio360JNI.AudioSettings_bufferSize_set(this.swigCPtr, this, i);
    }

    public int getBufferSize() {
        return Audio360JNI.AudioSettings_bufferSize_get(this.swigCPtr, this);
    }

    public void setDeviceType(AudioDeviceType audioDeviceType) {
        Audio360JNI.AudioSettings_deviceType_set(this.swigCPtr, this, audioDeviceType.swigValue());
    }

    public AudioDeviceType getDeviceType() {
        return AudioDeviceType.swigToEnum(Audio360JNI.AudioSettings_deviceType_get(this.swigCPtr, this));
    }

    public void setCustomAudioDeviceName(String str) {
        Audio360JNI.AudioSettings_customAudioDeviceName_set(this.swigCPtr, this, str);
    }

    public String getCustomAudioDeviceName() {
        return Audio360JNI.AudioSettings_customAudioDeviceName_get(this.swigCPtr, this);
    }

    public AudioSettings() {
        this(Audio360JNI.new_AudioSettings(), true);
    }
}
