package com.twobigears.audio360;

/* JADX INFO: loaded from: classes4.dex */
public class AudioObject extends SpatDecoderInterface {
    private EventListener eventListener_;
    private transient long swigCPtr;

    protected AudioObject(long j, boolean z) {
        super(Audio360JNI.AudioObject_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(AudioObject audioObject) {
        if (audioObject == null) {
            return 0L;
        }
        return audioObject.swigCPtr;
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

    @Override // com.twobigears.audio360.TransportControl
    public EngineError stop() {
        return EngineError.swigToEnum(Audio360JNI.AudioObject_stop(this.swigCPtr, this));
    }

    @Override // com.twobigears.audio360.TransportControl
    public EngineError stopScheduled(float f) {
        return EngineError.swigToEnum(Audio360JNI.AudioObject_stopScheduled(this.swigCPtr, this, f));
    }

    @Override // com.twobigears.audio360.TransportControl
    public EngineError stopWithFade(float f) {
        return EngineError.swigToEnum(Audio360JNI.AudioObject_stopWithFade(this.swigCPtr, this, f));
    }

    public EngineError open(String str) {
        return EngineError.swigToEnum(Audio360JNI.AudioObject_open__SWIG_0(this.swigCPtr, this, str));
    }

    public EngineError open(String str, AssetDescriptor assetDescriptor) {
        return EngineError.swigToEnum(Audio360JNI.AudioObject_open__SWIG_1(this.swigCPtr, this, str, AssetDescriptor.getCPtr(assetDescriptor), assetDescriptor));
    }

    public void close() {
        Audio360JNI.AudioObject_close(this.swigCPtr, this);
    }

    public boolean isOpen() {
        return Audio360JNI.AudioObject_isOpen(this.swigCPtr, this);
    }

    public EngineError seekToSample(long j) {
        return EngineError.swigToEnum(Audio360JNI.AudioObject_seekToSample(this.swigCPtr, this, j));
    }

    public EngineError seekToMs(float f) {
        return EngineError.swigToEnum(Audio360JNI.AudioObject_seekToMs(this.swigCPtr, this, f));
    }

    public long getElapsedTimeInSamples() {
        return Audio360JNI.AudioObject_getElapsedTimeInSamples(this.swigCPtr, this);
    }

    public double getElapsedTimeInMs() {
        return Audio360JNI.AudioObject_getElapsedTimeInMs(this.swigCPtr, this);
    }

    public long getAssetDurationInSamples() {
        return Audio360JNI.AudioObject_getAssetDurationInSamples(this.swigCPtr, this);
    }

    public float getAssetDurationInMs() {
        return Audio360JNI.AudioObject_getAssetDurationInMs(this.swigCPtr, this);
    }

    public void shouldSpatialise(boolean z) {
        Audio360JNI.AudioObject_shouldSpatialise(this.swigCPtr, this, z);
    }

    public boolean isSpatialised() {
        return Audio360JNI.AudioObject_isSpatialised(this.swigCPtr, this);
    }

    public EngineError setSpatializationType(SpatializationType spatializationType) {
        return EngineError.swigToEnum(Audio360JNI.AudioObject_setSpatializationType(this.swigCPtr, this, spatializationType.swigValue()));
    }

    public SpatializationType getSpatializationType() {
        return SpatializationType.swigToEnum(Audio360JNI.AudioObject_getSpatializationType(this.swigCPtr, this));
    }

    public boolean enableLooping(boolean z) {
        return Audio360JNI.AudioObject_enableLooping(this.swigCPtr, this, z);
    }

    public boolean loopingEnabled() {
        return Audio360JNI.AudioObject_loopingEnabled(this.swigCPtr, this);
    }

    public void setAttenuationMode(AttenuationMode attenuationMode) {
        Audio360JNI.AudioObject_setAttenuationMode(this.swigCPtr, this, attenuationMode.swigValue());
    }

    public AttenuationMode getAttenuationMode() {
        return AttenuationMode.swigToEnum(Audio360JNI.AudioObject_getAttenuationMode(this.swigCPtr, this));
    }

    public void setAttenuationProperties(AttenuationProps attenuationProps) {
        Audio360JNI.AudioObject_setAttenuationProperties(this.swigCPtr, this, AttenuationProps.getCPtr(attenuationProps), attenuationProps);
    }

    public AttenuationProps getAttenuationProperties() {
        return new AttenuationProps(Audio360JNI.AudioObject_getAttenuationProperties(this.swigCPtr, this), true);
    }

    public void setDirectionalityEnabled(boolean z) {
        Audio360JNI.AudioObject_setDirectionalityEnabled(this.swigCPtr, this, z);
    }

    public boolean isDirectionalityEnabled() {
        return Audio360JNI.AudioObject_isDirectionalityEnabled(this.swigCPtr, this);
    }

    public void setDirectionalProperties(DirectionalProps directionalProps) {
        Audio360JNI.AudioObject_setDirectionalProperties(this.swigCPtr, this, DirectionalProps.getCPtr(directionalProps), directionalProps);
    }

    public DirectionalProps getDirectionalProperties() {
        return new DirectionalProps(Audio360JNI.AudioObject_getDirectionalProperties(this.swigCPtr, this), true);
    }

    public void setPitch(float f) {
        Audio360JNI.AudioObject_setPitch(this.swigCPtr, this, f);
    }

    public float getPitch() {
        return Audio360JNI.AudioObject_getPitch(this.swigCPtr, this);
    }

    private void setEventListenerInternal(EventListener eventListener) {
        Audio360JNI.AudioObject_setEventListenerInternal(this.swigCPtr, this, EventListener.getCPtr(eventListener), eventListener);
    }
}
