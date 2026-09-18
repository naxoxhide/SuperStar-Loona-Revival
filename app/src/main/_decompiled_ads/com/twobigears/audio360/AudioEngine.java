package com.twobigears.audio360;

import android.content.Context;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public class AudioEngine {
    private EventListener eventListener_;
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected AudioEngine(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(AudioEngine audioEngine) {
        if (audioEngine == null) {
            return 0L;
        }
        return audioEngine.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                Audio360JNI.delete_AudioEngine(j);
            }
            this.swigCPtr = 0L;
        }
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

    public EngineError start() {
        return EngineError.swigToEnum(Audio360JNI.AudioEngine_start(this.swigCPtr, this));
    }

    public EngineError suspend() {
        return EngineError.swigToEnum(Audio360JNI.AudioEngine_suspend(this.swigCPtr, this));
    }

    public void setListenerRotation(TBVector tBVector, TBVector tBVector2) {
        Audio360JNI.AudioEngine_setListenerRotation__SWIG_0(this.swigCPtr, this, TBVector.getCPtr(tBVector), tBVector, TBVector.getCPtr(tBVector2), tBVector2);
    }

    public void setListenerRotation(TBQuat tBQuat) {
        Audio360JNI.AudioEngine_setListenerRotation__SWIG_1(this.swigCPtr, this, TBQuat.getCPtr(tBQuat), tBQuat);
    }

    public void setListenerRotation(float f, float f2, float f3) {
        Audio360JNI.AudioEngine_setListenerRotation__SWIG_2(this.swigCPtr, this, f, f2, f3);
    }

    public void setListenerPosition(TBVector tBVector) {
        Audio360JNI.AudioEngine_setListenerPosition(this.swigCPtr, this, TBVector.getCPtr(tBVector), tBVector);
    }

    public TBVector getListenerPosition() {
        return new TBVector(Audio360JNI.AudioEngine_getListenerPosition(this.swigCPtr, this), true);
    }

    public TBQuat getListenerRotation() {
        return new TBQuat(Audio360JNI.AudioEngine_getListenerRotation(this.swigCPtr, this), true);
    }

    public TBVector getListenerForward() {
        return new TBVector(Audio360JNI.AudioEngine_getListenerForward(this.swigCPtr, this), true);
    }

    public TBVector getListenerUp() {
        return new TBVector(Audio360JNI.AudioEngine_getListenerUp(this.swigCPtr, this), true);
    }

    public EngineError enablePositionalTracking(boolean z, TBVector tBVector) {
        return EngineError.swigToEnum(Audio360JNI.AudioEngine_enablePositionalTracking(this.swigCPtr, this, z, TBVector.getCPtr(tBVector), tBVector));
    }

    public boolean positionalTrackingEnabled() {
        return Audio360JNI.AudioEngine_positionalTrackingEnabled(this.swigCPtr, this);
    }

    public int getBufferSize() {
        return Audio360JNI.AudioEngine_getBufferSize(this.swigCPtr, this);
    }

    public float getSampleRate() {
        return Audio360JNI.AudioEngine_getSampleRate(this.swigCPtr, this);
    }

    public EngineError getAudioMix(ByteBuffer byteBuffer, int i, int i2) {
        return EngineError.swigToEnum(Audio360JNI.AudioEngine_getAudioMix(this.swigCPtr, this, byteBuffer, i, i2));
    }

    public void destroySpatDecoderQueue(SpatDecoderQueue spatDecoderQueue) {
        Audio360JNI.AudioEngine_destroySpatDecoderQueue(this.swigCPtr, this, SpatDecoderQueue.getCPtr(spatDecoderQueue), spatDecoderQueue);
    }

    public EngineError createSpatDecoderFile(SpatDecoderFile spatDecoderFile, Options options) {
        return EngineError.swigToEnum(Audio360JNI.AudioEngine_createSpatDecoderFile__SWIG_0(this.swigCPtr, this, SpatDecoderFile.getCPtr(spatDecoderFile), spatDecoderFile, options.swigValue()));
    }

    public void destroySpatDecoderFile(SpatDecoderFile spatDecoderFile) {
        Audio360JNI.AudioEngine_destroySpatDecoderFile(this.swigCPtr, this, SpatDecoderFile.getCPtr(spatDecoderFile), spatDecoderFile);
    }

    public EngineError createAudioObject(AudioObject audioObject, Options options) {
        return EngineError.swigToEnum(Audio360JNI.AudioEngine_createAudioObject__SWIG_0(this.swigCPtr, this, AudioObject.getCPtr(audioObject), audioObject, options.swigValue()));
    }

    public void destroyAudioObject(AudioObject audioObject) {
        Audio360JNI.AudioEngine_destroyAudioObject(this.swigCPtr, this, AudioObject.getCPtr(audioObject), audioObject);
    }

    public void enableTestTone(boolean z, float f, float f2) {
        Audio360JNI.AudioEngine_enableTestTone__SWIG_0(this.swigCPtr, this, z, f, f2);
    }

    public void enableTestTone(boolean z, float f) {
        Audio360JNI.AudioEngine_enableTestTone__SWIG_1(this.swigCPtr, this, z, f);
    }

    public void enableTestTone(boolean z) {
        Audio360JNI.AudioEngine_enableTestTone__SWIG_2(this.swigCPtr, this, z);
    }

    public int getVersionMajor() {
        return Audio360JNI.AudioEngine_getVersionMajor(this.swigCPtr, this);
    }

    public int getVersionMinor() {
        return Audio360JNI.AudioEngine_getVersionMinor(this.swigCPtr, this);
    }

    public int getVersionPatch() {
        return Audio360JNI.AudioEngine_getVersionPatch(this.swigCPtr, this);
    }

    public String getVersionHash() {
        return Audio360JNI.AudioEngine_getVersionHash(this.swigCPtr, this);
    }

    public LoudnessStatistics getRenderedLoudness() {
        return new LoudnessStatistics(Audio360JNI.AudioEngine_getRenderedLoudness(this.swigCPtr, this), true);
    }

    public void resetLoudness() {
        Audio360JNI.AudioEngine_resetLoudness(this.swigCPtr, this);
    }

    public void enableLoudness(boolean z) {
        Audio360JNI.AudioEngine_enableLoudness__SWIG_0(this.swigCPtr, this, z);
    }

    public void enableLoudness() {
        Audio360JNI.AudioEngine_enableLoudness__SWIG_1(this.swigCPtr, this);
    }

    public long getDSPTime() {
        return Audio360JNI.AudioEngine_getDSPTime(this.swigCPtr, this);
    }

    public EngineError setNumOutputBuffers(long j) {
        return EngineError.swigToEnum(Audio360JNI.AudioEngine_setNumOutputBuffers(this.swigCPtr, this, j));
    }

    public long getNumOutputBuffers() {
        return Audio360JNI.AudioEngine_getNumOutputBuffers(this.swigCPtr, this);
    }

    public int getOutputLatencySamples() {
        return Audio360JNI.AudioEngine_getOutputLatencySamples(this.swigCPtr, this);
    }

    public double getOutputLatencyMs() {
        return Audio360JNI.AudioEngine_getOutputLatencyMs(this.swigCPtr, this);
    }

    public String getOutputAudioDeviceName() {
        return Audio360JNI.AudioEngine_getOutputAudioDeviceName(this.swigCPtr, this);
    }

    public static int getNumAudioDevices() {
        return Audio360JNI.AudioEngine_getNumAudioDevices();
    }

    public static String getAudioDeviceName(int i) {
        return Audio360JNI.AudioEngine_getAudioDeviceName(i);
    }

    public static AudioEngine create(EngineInitSettings engineInitSettings, Context context) {
        long jAudioEngine_create__SWIG_0 = Audio360JNI.AudioEngine_create__SWIG_0(EngineInitSettings.getCPtr(engineInitSettings), engineInitSettings, context != null ? context.getAssets() : null);
        if (jAudioEngine_create__SWIG_0 == 0) {
            return null;
        }
        return new AudioEngine(jAudioEngine_create__SWIG_0, true);
    }

    public static AudioEngine create(float f, Context context) {
        long jAudioEngine_create__SWIG_1 = Audio360JNI.AudioEngine_create__SWIG_1(f, context != null ? context.getAssets() : null);
        if (jAudioEngine_create__SWIG_1 == 0) {
            return null;
        }
        return new AudioEngine(jAudioEngine_create__SWIG_1, true);
    }

    public static AudioEngine create(float f, int i, Context context) {
        long jAudioEngine_create__SWIG_2 = Audio360JNI.AudioEngine_create__SWIG_2(f, i, context != null ? context.getAssets() : null);
        if (jAudioEngine_create__SWIG_2 == 0) {
            return null;
        }
        return new AudioEngine(jAudioEngine_create__SWIG_2, false);
    }

    public static AudioEngine create(float f, int i, int i2, Context context) {
        long jAudioEngine_create__SWIG_3 = Audio360JNI.AudioEngine_create__SWIG_3(f, i, i2, context != null ? context.getAssets() : null);
        if (jAudioEngine_create__SWIG_3 == 0) {
            return null;
        }
        return new AudioEngine(jAudioEngine_create__SWIG_3, false);
    }

    public SpatDecoderQueue createSpatDecoderQueue() {
        long jAudioEngine_createSpatDecoderQueue = Audio360JNI.AudioEngine_createSpatDecoderQueue(this.swigCPtr, this);
        if (jAudioEngine_createSpatDecoderQueue == 0) {
            return null;
        }
        return new SpatDecoderQueue(jAudioEngine_createSpatDecoderQueue, false);
    }

    public SpatDecoderFile createSpatDecoderFile() {
        long jAudioEngine_createSpatDecoderFile__SWIG_1 = Audio360JNI.AudioEngine_createSpatDecoderFile__SWIG_1(this.swigCPtr, this);
        if (jAudioEngine_createSpatDecoderFile__SWIG_1 == 0) {
            return null;
        }
        return new SpatDecoderFile(jAudioEngine_createSpatDecoderFile__SWIG_1, false);
    }

    public AudioObject createAudioObject() {
        long jAudioEngine_createAudioObject__SWIG_1 = Audio360JNI.AudioEngine_createAudioObject__SWIG_1(this.swigCPtr, this);
        if (jAudioEngine_createAudioObject__SWIG_1 == 0) {
            return null;
        }
        return new AudioObject(jAudioEngine_createAudioObject__SWIG_1, false);
    }

    private void setEventListenerInternal(EventListener eventListener) {
        Audio360JNI.AudioEngine_setEventListenerInternal(this.swigCPtr, this, EventListener.getCPtr(eventListener), eventListener);
    }
}
