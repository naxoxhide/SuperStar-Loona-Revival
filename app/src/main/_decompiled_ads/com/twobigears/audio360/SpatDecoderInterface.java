package com.twobigears.audio360;

/* JADX INFO: loaded from: classes4.dex */
public class SpatDecoderInterface extends Object3D {
    private transient long swigCPtr;

    protected SpatDecoderInterface(long j, boolean z) {
        super(Audio360JNI.SpatDecoderInterface_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(SpatDecoderInterface spatDecoderInterface) {
        if (spatDecoderInterface == null) {
            return 0L;
        }
        return spatDecoderInterface.swigCPtr;
    }

    @Override // com.twobigears.audio360.Object3D, com.twobigears.audio360.TransportControl
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

    public void enableFocus(boolean z, boolean z2) {
        Audio360JNI.SpatDecoderInterface_enableFocus(this.swigCPtr, this, z, z2);
    }

    public void setFocusProperties(float f, float f2) {
        Audio360JNI.SpatDecoderInterface_setFocusProperties(this.swigCPtr, this, f, f2);
    }

    public void setOffFocusLeveldB(float f) {
        Audio360JNI.SpatDecoderInterface_setOffFocusLeveldB(this.swigCPtr, this, f);
    }

    public void setFocusWidthDegrees(float f) {
        Audio360JNI.SpatDecoderInterface_setFocusWidthDegrees(this.swigCPtr, this, f);
    }

    public void setFocusOrientationQuat(TBQuat tBQuat) {
        Audio360JNI.SpatDecoderInterface_setFocusOrientationQuat(this.swigCPtr, this, TBQuat.getCPtr(tBQuat), tBQuat);
    }

    public void setVolume(float f, float f2, boolean z) {
        Audio360JNI.SpatDecoderInterface_setVolume__SWIG_0(this.swigCPtr, this, f, f2, z);
    }

    public void setVolume(float f, float f2) {
        Audio360JNI.SpatDecoderInterface_setVolume__SWIG_1(this.swigCPtr, this, f, f2);
    }

    public void setVolumeDecibels(float f, float f2, boolean z) {
        Audio360JNI.SpatDecoderInterface_setVolumeDecibels__SWIG_0(this.swigCPtr, this, f, f2, z);
    }

    public void setVolumeDecibels(float f, float f2) {
        Audio360JNI.SpatDecoderInterface_setVolumeDecibels__SWIG_1(this.swigCPtr, this, f, f2);
    }

    public float getVolume() {
        return Audio360JNI.SpatDecoderInterface_getVolume(this.swigCPtr, this);
    }

    public float getVolumeDecibels() {
        return Audio360JNI.SpatDecoderInterface_getVolumeDecibels(this.swigCPtr, this);
    }

    @Override // com.twobigears.audio360.TransportControl
    public EngineError play() {
        return EngineError.swigToEnum(Audio360JNI.SpatDecoderInterface_play(this.swigCPtr, this));
    }

    @Override // com.twobigears.audio360.TransportControl
    public EngineError playScheduled(float f) {
        return EngineError.swigToEnum(Audio360JNI.SpatDecoderInterface_playScheduled(this.swigCPtr, this, f));
    }

    @Override // com.twobigears.audio360.TransportControl
    public EngineError playWithFade(float f) {
        return EngineError.swigToEnum(Audio360JNI.SpatDecoderInterface_playWithFade(this.swigCPtr, this, f));
    }

    @Override // com.twobigears.audio360.TransportControl
    public EngineError pause() {
        return EngineError.swigToEnum(Audio360JNI.SpatDecoderInterface_pause(this.swigCPtr, this));
    }

    @Override // com.twobigears.audio360.TransportControl
    public EngineError pauseScheduled(float f) {
        return EngineError.swigToEnum(Audio360JNI.SpatDecoderInterface_pauseScheduled(this.swigCPtr, this, f));
    }

    @Override // com.twobigears.audio360.TransportControl
    public EngineError pauseWithFade(float f) {
        return EngineError.swigToEnum(Audio360JNI.SpatDecoderInterface_pauseWithFade(this.swigCPtr, this, f));
    }

    @Override // com.twobigears.audio360.TransportControl
    public PlayState getPlayState() {
        return PlayState.swigToEnum(Audio360JNI.SpatDecoderInterface_getPlayState(this.swigCPtr, this));
    }
}
