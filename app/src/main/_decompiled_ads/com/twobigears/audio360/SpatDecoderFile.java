package com.twobigears.audio360;

/* JADX INFO: loaded from: classes4.dex */
public class SpatDecoderFile extends SpatDecoderInterface {
    private EventListener eventListener_;
    private transient long swigCPtr;

    protected SpatDecoderFile(long j, boolean z) {
        super(Audio360JNI.SpatDecoderFile_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(SpatDecoderFile spatDecoderFile) {
        if (spatDecoderFile == null) {
            return 0L;
        }
        return spatDecoderFile.swigCPtr;
    }

    @Override // com.twobigears.audio360.SpatDecoderInterface, com.twobigears.audio360.Object3D, com.twobigears.audio360.TransportControl
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                throw new UnsupportedOperationException("C++ destructor does not have public access");
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public void setEventListener(EventListener eventListener) {
        EventListener eventListener2 = this.eventListener_;
        if (eventListener2 != null) {
            eventListener2.delete();
            this.eventListener_ = null;
        }
        this.eventListener_ = eventListener;
        setEventListenerInternal(eventListener);
    }

    public EngineError open(String str, ChannelMap channelMap) {
        return EngineError.swigToEnum(Audio360JNI.SpatDecoderFile_open__SWIG_0(this.swigCPtr, this, str, channelMap.swigValue()));
    }

    public EngineError open(String str) {
        return EngineError.swigToEnum(Audio360JNI.SpatDecoderFile_open__SWIG_1(this.swigCPtr, this, str));
    }

    public EngineError open(String str, AssetDescriptor assetDescriptor, ChannelMap channelMap) {
        return EngineError.swigToEnum(Audio360JNI.SpatDecoderFile_open__SWIG_2(this.swigCPtr, this, str, AssetDescriptor.getCPtr(assetDescriptor), assetDescriptor, channelMap.swigValue()));
    }

    public EngineError open(String str, AssetDescriptor assetDescriptor) {
        return EngineError.swigToEnum(Audio360JNI.SpatDecoderFile_open__SWIG_3(this.swigCPtr, this, str, AssetDescriptor.getCPtr(assetDescriptor), assetDescriptor));
    }

    public void close() {
        Audio360JNI.SpatDecoderFile_close(this.swigCPtr, this);
    }

    public boolean isOpen() {
        return Audio360JNI.SpatDecoderFile_isOpen(this.swigCPtr, this);
    }

    public EngineError seekToSample(long j) {
        return EngineError.swigToEnum(Audio360JNI.SpatDecoderFile_seekToSample(this.swigCPtr, this, j));
    }

    public EngineError seekToMs(float f) {
        return EngineError.swigToEnum(Audio360JNI.SpatDecoderFile_seekToMs(this.swigCPtr, this, f));
    }

    public long getElapsedTimeInSamples() {
        return Audio360JNI.SpatDecoderFile_getElapsedTimeInSamples(this.swigCPtr, this);
    }

    public double getElapsedTimeInMs() {
        return Audio360JNI.SpatDecoderFile_getElapsedTimeInMs(this.swigCPtr, this);
    }

    public long getAssetDurationInSamples() {
        return Audio360JNI.SpatDecoderFile_getAssetDurationInSamples(this.swigCPtr, this);
    }

    public float getAssetDurationInMs() {
        return Audio360JNI.SpatDecoderFile_getAssetDurationInMs(this.swigCPtr, this);
    }

    public void setSyncMode(SyncMode syncMode) {
        Audio360JNI.SpatDecoderFile_setSyncMode(this.swigCPtr, this, syncMode.swigValue());
    }

    public SyncMode getSyncMode() {
        return SyncMode.swigToEnum(Audio360JNI.SpatDecoderFile_getSyncMode(this.swigCPtr, this));
    }

    public void setExternalClockInMs(double d) {
        Audio360JNI.SpatDecoderFile_setExternalClockInMs(this.swigCPtr, this, d);
    }

    public void setFreewheelTimeInMs(double d) {
        Audio360JNI.SpatDecoderFile_setFreewheelTimeInMs(this.swigCPtr, this, d);
    }

    public double getFreewheelTimeInMs() {
        return Audio360JNI.SpatDecoderFile_getFreewheelTimeInMs(this.swigCPtr, this);
    }

    public void setResyncThresholdMs(double d) {
        Audio360JNI.SpatDecoderFile_setResyncThresholdMs(this.swigCPtr, this, d);
    }

    public double getResyncThresholdMs() {
        return Audio360JNI.SpatDecoderFile_getResyncThresholdMs(this.swigCPtr, this);
    }

    public void applyVolumeFade(float f, float f2, float f3) {
        Audio360JNI.SpatDecoderFile_applyVolumeFade(this.swigCPtr, this, f, f2, f3);
    }

    public void enableLooping(boolean z) {
        Audio360JNI.SpatDecoderFile_enableLooping(this.swigCPtr, this, z);
    }

    public boolean loopingEnabled() {
        return Audio360JNI.SpatDecoderFile_loopingEnabled(this.swigCPtr, this);
    }

    private void setEventListenerInternal(EventListener eventListener) {
        Audio360JNI.SpatDecoderFile_setEventListenerInternal(this.swigCPtr, this, EventListener.getCPtr(eventListener), eventListener);
    }
}
