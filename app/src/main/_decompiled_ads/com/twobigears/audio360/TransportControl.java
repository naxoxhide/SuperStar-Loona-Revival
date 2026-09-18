package com.twobigears.audio360;

/* JADX INFO: loaded from: classes4.dex */
public class TransportControl {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected TransportControl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(TransportControl transportControl) {
        if (transportControl == null) {
            return 0L;
        }
        return transportControl.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                throw new UnsupportedOperationException("C++ destructor does not have public access");
            }
            this.swigCPtr = 0L;
        }
    }

    public EngineError play() {
        return EngineError.swigToEnum(Audio360JNI.TransportControl_play(this.swigCPtr, this));
    }

    public EngineError playScheduled(float f) {
        return EngineError.swigToEnum(Audio360JNI.TransportControl_playScheduled(this.swigCPtr, this, f));
    }

    public EngineError playWithFade(float f) {
        return EngineError.swigToEnum(Audio360JNI.TransportControl_playWithFade(this.swigCPtr, this, f));
    }

    public EngineError pause() {
        return EngineError.swigToEnum(Audio360JNI.TransportControl_pause(this.swigCPtr, this));
    }

    public EngineError pauseScheduled(float f) {
        return EngineError.swigToEnum(Audio360JNI.TransportControl_pauseScheduled(this.swigCPtr, this, f));
    }

    public EngineError pauseWithFade(float f) {
        return EngineError.swigToEnum(Audio360JNI.TransportControl_pauseWithFade(this.swigCPtr, this, f));
    }

    public EngineError stop() {
        return EngineError.swigToEnum(Audio360JNI.TransportControl_stop(this.swigCPtr, this));
    }

    public EngineError stopScheduled(float f) {
        return EngineError.swigToEnum(Audio360JNI.TransportControl_stopScheduled(this.swigCPtr, this, f));
    }

    public EngineError stopWithFade(float f) {
        return EngineError.swigToEnum(Audio360JNI.TransportControl_stopWithFade(this.swigCPtr, this, f));
    }

    public PlayState getPlayState() {
        return PlayState.swigToEnum(Audio360JNI.TransportControl_getPlayState(this.swigCPtr, this));
    }
}
