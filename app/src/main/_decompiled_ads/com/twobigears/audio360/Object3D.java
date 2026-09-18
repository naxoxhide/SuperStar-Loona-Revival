package com.twobigears.audio360;

/* JADX INFO: loaded from: classes4.dex */
public class Object3D extends TransportControl {
    private transient long swigCPtr;

    protected Object3D(long j, boolean z) {
        super(Audio360JNI.Object3D_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(Object3D object3D) {
        if (object3D == null) {
            return 0L;
        }
        return object3D.swigCPtr;
    }

    @Override // com.twobigears.audio360.TransportControl
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

    public EngineError setPosition(TBVector tBVector) {
        return EngineError.swigToEnum(Audio360JNI.Object3D_setPosition(this.swigCPtr, this, TBVector.getCPtr(tBVector), tBVector));
    }

    public TBVector getPosition() {
        return new TBVector(Audio360JNI.Object3D_getPosition(this.swigCPtr, this), true);
    }

    public EngineError setRotation(TBQuat tBQuat) {
        return EngineError.swigToEnum(Audio360JNI.Object3D_setRotation__SWIG_0(this.swigCPtr, this, TBQuat.getCPtr(tBQuat), tBQuat));
    }

    public EngineError setRotation(TBVector tBVector, TBVector tBVector2) {
        return EngineError.swigToEnum(Audio360JNI.Object3D_setRotation__SWIG_1(this.swigCPtr, this, TBVector.getCPtr(tBVector), tBVector, TBVector.getCPtr(tBVector2), tBVector2));
    }

    public TBQuat getRotation() {
        return new TBQuat(Audio360JNI.Object3D_getRotation(this.swigCPtr, this), true);
    }
}
