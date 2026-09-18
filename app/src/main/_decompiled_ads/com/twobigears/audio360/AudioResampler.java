package com.twobigears.audio360;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public class AudioResampler {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected AudioResampler(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(AudioResampler audioResampler) {
        if (audioResampler == null) {
            return 0L;
        }
        return audioResampler.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                Audio360JNI.delete_AudioResampler(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public long process(ByteBuffer byteBuffer, long j, ByteBuffer byteBuffer2, long j2, boolean z) {
        return Audio360JNI.AudioResampler_process(this.swigCPtr, this, byteBuffer, j, byteBuffer2, j2, z);
    }

    public int getNumChannels() {
        return Audio360JNI.AudioResampler_getNumChannels(this.swigCPtr, this);
    }

    public float getInputSampleRate() {
        return Audio360JNI.AudioResampler_getInputSampleRate(this.swigCPtr, this);
    }

    public float getOutputSampleRate() {
        return Audio360JNI.AudioResampler_getOutputSampleRate(this.swigCPtr, this);
    }

    public Quality getQuality() {
        return Quality.swigToEnum(Audio360JNI.AudioResampler_getQuality(this.swigCPtr, this));
    }

    public void reset() {
        Audio360JNI.AudioResampler_reset(this.swigCPtr, this);
    }

    public static AudioResampler create(long j, float f, float f2, Quality quality) {
        long jAudioResampler_create = Audio360JNI.AudioResampler_create(j, f, f2, quality.swigValue());
        if (jAudioResampler_create == 0) {
            return null;
        }
        return new AudioResampler(jAudioResampler_create, true);
    }

    public enum Quality {
        OPTIMAL,
        FAST;

        private final int swigValue;

        public final int swigValue() {
            return this.swigValue;
        }

        public static Quality swigToEnum(int i) {
            Quality[] qualityArr = (Quality[]) Quality.class.getEnumConstants();
            if (i < qualityArr.length && i >= 0 && qualityArr[i].swigValue == i) {
                return qualityArr[i];
            }
            for (Quality quality : qualityArr) {
                if (quality.swigValue == i) {
                    return quality;
                }
            }
            throw new IllegalArgumentException("No enum " + Quality.class + " with value " + i);
        }

        Quality() {
            this.swigValue = SwigNext.access$008();
        }

        Quality(int i) {
            this.swigValue = i;
            int unused = SwigNext.next = i + 1;
        }

        Quality(Quality quality) {
            int i = quality.swigValue;
            this.swigValue = i;
            int unused = SwigNext.next = i + 1;
        }

        private static class SwigNext {
            private static int next;

            private SwigNext() {
            }

            static /* synthetic */ int access$008() {
                int i = next;
                next = i + 1;
                return i;
            }
        }
    }
}
