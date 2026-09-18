package com.twobigears.audio360;

import android.content.res.AssetManager;
import java.math.BigInteger;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public class Audio360JNI {
    public static final native long AssetDescriptor_lengthInBytes_get(long j, AssetDescriptor assetDescriptor);

    public static final native void AssetDescriptor_lengthInBytes_set(long j, AssetDescriptor assetDescriptor, long j2);

    public static final native long AssetDescriptor_offsetInBytes_get(long j, AssetDescriptor assetDescriptor);

    public static final native void AssetDescriptor_offsetInBytes_set(long j, AssetDescriptor assetDescriptor, long j2);

    public static final native float AttenuationProps_factor_get(long j, AttenuationProps attenuationProps);

    public static final native void AttenuationProps_factor_set(long j, AttenuationProps attenuationProps, float f);

    public static final native boolean AttenuationProps_maxDistanceMute_get(long j, AttenuationProps attenuationProps);

    public static final native void AttenuationProps_maxDistanceMute_set(long j, AttenuationProps attenuationProps, boolean z);

    public static final native float AttenuationProps_maximumDistance_get(long j, AttenuationProps attenuationProps);

    public static final native void AttenuationProps_maximumDistance_set(long j, AttenuationProps attenuationProps, float f);

    public static final native float AttenuationProps_minimumDistance_get(long j, AttenuationProps attenuationProps);

    public static final native void AttenuationProps_minimumDistance_set(long j, AttenuationProps attenuationProps, float f);

    public static final native int AudioEngine_createAudioObject__SWIG_0(long j, AudioEngine audioEngine, long j2, AudioObject audioObject, int i);

    public static final native long AudioEngine_createAudioObject__SWIG_1(long j, AudioEngine audioEngine);

    public static final native int AudioEngine_createSpatDecoderFile__SWIG_0(long j, AudioEngine audioEngine, long j2, SpatDecoderFile spatDecoderFile, int i);

    public static final native long AudioEngine_createSpatDecoderFile__SWIG_1(long j, AudioEngine audioEngine);

    public static final native long AudioEngine_createSpatDecoderQueue(long j, AudioEngine audioEngine);

    public static final native long AudioEngine_create__SWIG_0(long j, EngineInitSettings engineInitSettings, AssetManager assetManager);

    public static final native long AudioEngine_create__SWIG_1(float f, AssetManager assetManager);

    public static final native long AudioEngine_create__SWIG_2(float f, int i, AssetManager assetManager);

    public static final native long AudioEngine_create__SWIG_3(float f, int i, int i2, AssetManager assetManager);

    public static final native void AudioEngine_destroyAudioObject(long j, AudioEngine audioEngine, long j2, AudioObject audioObject);

    public static final native void AudioEngine_destroySpatDecoderFile(long j, AudioEngine audioEngine, long j2, SpatDecoderFile spatDecoderFile);

    public static final native void AudioEngine_destroySpatDecoderQueue(long j, AudioEngine audioEngine, long j2, SpatDecoderQueue spatDecoderQueue);

    public static final native void AudioEngine_enableLoudness__SWIG_0(long j, AudioEngine audioEngine, boolean z);

    public static final native void AudioEngine_enableLoudness__SWIG_1(long j, AudioEngine audioEngine);

    public static final native int AudioEngine_enablePositionalTracking(long j, AudioEngine audioEngine, boolean z, long j2, TBVector tBVector);

    public static final native void AudioEngine_enableTestTone__SWIG_0(long j, AudioEngine audioEngine, boolean z, float f, float f2);

    public static final native void AudioEngine_enableTestTone__SWIG_1(long j, AudioEngine audioEngine, boolean z, float f);

    public static final native void AudioEngine_enableTestTone__SWIG_2(long j, AudioEngine audioEngine, boolean z);

    public static final native String AudioEngine_getAudioDeviceName(int i);

    public static final native int AudioEngine_getAudioMix(long j, AudioEngine audioEngine, ByteBuffer byteBuffer, int i, int i2);

    public static final native int AudioEngine_getBufferSize(long j, AudioEngine audioEngine);

    public static final native long AudioEngine_getDSPTime(long j, AudioEngine audioEngine);

    public static final native long AudioEngine_getListenerForward(long j, AudioEngine audioEngine);

    public static final native long AudioEngine_getListenerPosition(long j, AudioEngine audioEngine);

    public static final native long AudioEngine_getListenerRotation(long j, AudioEngine audioEngine);

    public static final native long AudioEngine_getListenerUp(long j, AudioEngine audioEngine);

    public static final native int AudioEngine_getNumAudioDevices();

    public static final native long AudioEngine_getNumOutputBuffers(long j, AudioEngine audioEngine);

    public static final native String AudioEngine_getOutputAudioDeviceName(long j, AudioEngine audioEngine);

    public static final native double AudioEngine_getOutputLatencyMs(long j, AudioEngine audioEngine);

    public static final native int AudioEngine_getOutputLatencySamples(long j, AudioEngine audioEngine);

    public static final native long AudioEngine_getRenderedLoudness(long j, AudioEngine audioEngine);

    public static final native float AudioEngine_getSampleRate(long j, AudioEngine audioEngine);

    public static final native String AudioEngine_getVersionHash(long j, AudioEngine audioEngine);

    public static final native int AudioEngine_getVersionMajor(long j, AudioEngine audioEngine);

    public static final native int AudioEngine_getVersionMinor(long j, AudioEngine audioEngine);

    public static final native int AudioEngine_getVersionPatch(long j, AudioEngine audioEngine);

    public static final native boolean AudioEngine_positionalTrackingEnabled(long j, AudioEngine audioEngine);

    public static final native void AudioEngine_resetLoudness(long j, AudioEngine audioEngine);

    public static final native void AudioEngine_setEventListenerInternal(long j, AudioEngine audioEngine, long j2, EventListener eventListener);

    public static final native void AudioEngine_setListenerPosition(long j, AudioEngine audioEngine, long j2, TBVector tBVector);

    public static final native void AudioEngine_setListenerRotation__SWIG_0(long j, AudioEngine audioEngine, long j2, TBVector tBVector, long j3, TBVector tBVector2);

    public static final native void AudioEngine_setListenerRotation__SWIG_1(long j, AudioEngine audioEngine, long j2, TBQuat tBQuat);

    public static final native void AudioEngine_setListenerRotation__SWIG_2(long j, AudioEngine audioEngine, float f, float f2, float f3);

    public static final native int AudioEngine_setNumOutputBuffers(long j, AudioEngine audioEngine, long j2);

    public static final native int AudioEngine_start(long j, AudioEngine audioEngine);

    public static final native int AudioEngine_suspend(long j, AudioEngine audioEngine);

    public static final native long AudioObject_SWIGUpcast(long j);

    public static final native void AudioObject_close(long j, AudioObject audioObject);

    public static final native boolean AudioObject_enableLooping(long j, AudioObject audioObject, boolean z);

    public static final native float AudioObject_getAssetDurationInMs(long j, AudioObject audioObject);

    public static final native long AudioObject_getAssetDurationInSamples(long j, AudioObject audioObject);

    public static final native int AudioObject_getAttenuationMode(long j, AudioObject audioObject);

    public static final native long AudioObject_getAttenuationProperties(long j, AudioObject audioObject);

    public static final native long AudioObject_getDirectionalProperties(long j, AudioObject audioObject);

    public static final native double AudioObject_getElapsedTimeInMs(long j, AudioObject audioObject);

    public static final native long AudioObject_getElapsedTimeInSamples(long j, AudioObject audioObject);

    public static final native float AudioObject_getPitch(long j, AudioObject audioObject);

    public static final native int AudioObject_getSpatializationType(long j, AudioObject audioObject);

    public static final native boolean AudioObject_isDirectionalityEnabled(long j, AudioObject audioObject);

    public static final native boolean AudioObject_isOpen(long j, AudioObject audioObject);

    public static final native boolean AudioObject_isSpatialised(long j, AudioObject audioObject);

    public static final native boolean AudioObject_loopingEnabled(long j, AudioObject audioObject);

    public static final native int AudioObject_open__SWIG_0(long j, AudioObject audioObject, String str);

    public static final native int AudioObject_open__SWIG_1(long j, AudioObject audioObject, String str, long j2, AssetDescriptor assetDescriptor);

    public static final native int AudioObject_seekToMs(long j, AudioObject audioObject, float f);

    public static final native int AudioObject_seekToSample(long j, AudioObject audioObject, long j2);

    public static final native void AudioObject_setAttenuationMode(long j, AudioObject audioObject, int i);

    public static final native void AudioObject_setAttenuationProperties(long j, AudioObject audioObject, long j2, AttenuationProps attenuationProps);

    public static final native void AudioObject_setDirectionalProperties(long j, AudioObject audioObject, long j2, DirectionalProps directionalProps);

    public static final native void AudioObject_setDirectionalityEnabled(long j, AudioObject audioObject, boolean z);

    public static final native void AudioObject_setEventListenerInternal(long j, AudioObject audioObject, long j2, EventListener eventListener);

    public static final native void AudioObject_setPitch(long j, AudioObject audioObject, float f);

    public static final native int AudioObject_setSpatializationType(long j, AudioObject audioObject, int i);

    public static final native void AudioObject_shouldSpatialise(long j, AudioObject audioObject, boolean z);

    public static final native int AudioObject_stop(long j, AudioObject audioObject);

    public static final native int AudioObject_stopScheduled(long j, AudioObject audioObject, float f);

    public static final native int AudioObject_stopWithFade(long j, AudioObject audioObject, float f);

    public static final native long AudioResampler_create(long j, float f, float f2, int i);

    public static final native float AudioResampler_getInputSampleRate(long j, AudioResampler audioResampler);

    public static final native int AudioResampler_getNumChannels(long j, AudioResampler audioResampler);

    public static final native float AudioResampler_getOutputSampleRate(long j, AudioResampler audioResampler);

    public static final native int AudioResampler_getQuality(long j, AudioResampler audioResampler);

    public static final native long AudioResampler_process(long j, AudioResampler audioResampler, ByteBuffer byteBuffer, long j2, ByteBuffer byteBuffer2, long j3, boolean z);

    public static final native void AudioResampler_reset(long j, AudioResampler audioResampler);

    public static final native int AudioSettings_bufferSize_get(long j, AudioSettings audioSettings);

    public static final native void AudioSettings_bufferSize_set(long j, AudioSettings audioSettings, int i);

    public static final native String AudioSettings_customAudioDeviceName_get(long j, AudioSettings audioSettings);

    public static final native void AudioSettings_customAudioDeviceName_set(long j, AudioSettings audioSettings, String str);

    public static final native long AudioSettings_default_get();

    public static final native int AudioSettings_deviceType_get(long j, AudioSettings audioSettings);

    public static final native void AudioSettings_deviceType_set(long j, AudioSettings audioSettings, int i);

    public static final native float AudioSettings_sampleRate_get(long j, AudioSettings audioSettings);

    public static final native void AudioSettings_sampleRate_set(long j, AudioSettings audioSettings, float f);

    public static final native float DirectionalProps_coneArea_get(long j, DirectionalProps directionalProps);

    public static final native void DirectionalProps_coneArea_set(long j, DirectionalProps directionalProps, float f);

    public static final native float DirectionalProps_effectLevel_get(long j, DirectionalProps directionalProps);

    public static final native void DirectionalProps_effectLevel_set(long j, DirectionalProps directionalProps, float f);

    public static final native void DirectionalProps_set(long j, DirectionalProps directionalProps, float f, float f2);

    public static final native long EngineInitSettings_audioSettings_get(long j, EngineInitSettings engineInitSettings);

    public static final native void EngineInitSettings_audioSettings_set(long j, EngineInitSettings engineInitSettings, long j2, AudioSettings audioSettings);

    public static final native long EngineInitSettings_default_get();

    public static final native long EngineInitSettings_experimental_get(long j, EngineInitSettings engineInitSettings);

    public static final native void EngineInitSettings_experimental_set(long j, EngineInitSettings engineInitSettings, long j2, Experimental experimental);

    public static final native long EngineInitSettings_memorySettings_get(long j, EngineInitSettings engineInitSettings);

    public static final native void EngineInitSettings_memorySettings_set(long j, EngineInitSettings engineInitSettings, long j2, MemorySettings memorySettings);

    public static final native long EngineInitSettings_platformSettings_get(long j, EngineInitSettings engineInitSettings);

    public static final native void EngineInitSettings_platformSettings_set(long j, EngineInitSettings engineInitSettings, long j2, PlatformSettings platformSettings);

    public static final native long EngineInitSettings_threads_get(long j, EngineInitSettings engineInitSettings);

    public static final native void EngineInitSettings_threads_set(long j, EngineInitSettings engineInitSettings, long j2, ThreadSettings threadSettings);

    public static final native void EventListener_change_ownership(EventListener eventListener, long j, boolean z);

    public static final native void EventListener_director_connect(EventListener eventListener, long j, boolean z, boolean z2);

    public static final native void EventListener_onNewEvent(long j, EventListener eventListener, int i);

    public static final native int Experimental_ambisonicRenderer_get(long j, Experimental experimental);

    public static final native void Experimental_ambisonicRenderer_set(long j, Experimental experimental, int i);

    public static final native float LoudnessStatistics_integrated_get(long j, LoudnessStatistics loudnessStatistics);

    public static final native void LoudnessStatistics_integrated_set(long j, LoudnessStatistics loudnessStatistics, float f);

    public static final native float LoudnessStatistics_momentary_get(long j, LoudnessStatistics loudnessStatistics);

    public static final native void LoudnessStatistics_momentary_set(long j, LoudnessStatistics loudnessStatistics, float f);

    public static final native float LoudnessStatistics_shortTerm_get(long j, LoudnessStatistics loudnessStatistics);

    public static final native void LoudnessStatistics_shortTerm_set(long j, LoudnessStatistics loudnessStatistics, float f);

    public static final native float LoudnessStatistics_truePeak_get(long j, LoudnessStatistics loudnessStatistics);

    public static final native void LoudnessStatistics_truePeak_set(long j, LoudnessStatistics loudnessStatistics, float f);

    public static final native int MemorySettings_audioObjectPoolSize_get(long j, MemorySettings memorySettings);

    public static final native void MemorySettings_audioObjectPoolSize_set(long j, MemorySettings memorySettings, int i);

    public static final native long MemorySettings_default_get();

    public static final native int MemorySettings_spatDecoderFilePoolSize_get(long j, MemorySettings memorySettings);

    public static final native void MemorySettings_spatDecoderFilePoolSize_set(long j, MemorySettings memorySettings, int i);

    public static final native int MemorySettings_spatDecoderQueuePoolSize_get(long j, MemorySettings memorySettings);

    public static final native void MemorySettings_spatDecoderQueuePoolSize_set(long j, MemorySettings memorySettings, int i);

    public static final native int MemorySettings_spatQueueSizePerChannel_get(long j, MemorySettings memorySettings);

    public static final native void MemorySettings_spatQueueSizePerChannel_set(long j, MemorySettings memorySettings, int i);

    public static final native long MemorySettings_speakersVirtualizersPoolSize_get(long j, MemorySettings memorySettings);

    public static final native void MemorySettings_speakersVirtualizersPoolSize_set(long j, MemorySettings memorySettings, long j2);

    public static final native long NetworkSettings_default_get();

    public static final native long NetworkSettings_maxDownloadSpeedBytes_get(long j, NetworkSettings networkSettings);

    public static final native void NetworkSettings_maxDownloadSpeedBytes_set(long j, NetworkSettings networkSettings, long j2);

    public static final native boolean NetworkSettings_printDebugInfo_get(long j, NetworkSettings networkSettings);

    public static final native void NetworkSettings_printDebugInfo_set(long j, NetworkSettings networkSettings, boolean z);

    public static final native long NetworkSettings_streamingBufferSizeBytes_get(long j, NetworkSettings networkSettings);

    public static final native void NetworkSettings_streamingBufferSizeBytes_set(long j, NetworkSettings networkSettings, long j2);

    public static final native long Object3D_SWIGUpcast(long j);

    public static final native long Object3D_getPosition(long j, Object3D object3D);

    public static final native long Object3D_getRotation(long j, Object3D object3D);

    public static final native int Object3D_setPosition(long j, Object3D object3D, long j2, TBVector tBVector);

    public static final native int Object3D_setRotation__SWIG_0(long j, Object3D object3D, long j2, TBQuat tBQuat);

    public static final native int Object3D_setRotation__SWIG_1(long j, Object3D object3D, long j2, TBVector tBVector, long j3, TBVector tBVector2);

    public static final native boolean PlatformSettings_useAndroidFastPath_get(long j, PlatformSettings platformSettings);

    public static final native void PlatformSettings_useAndroidFastPath_set(long j, PlatformSettings platformSettings, boolean z);

    public static final native long SpatDecoderFile_SWIGUpcast(long j);

    public static final native void SpatDecoderFile_applyVolumeFade(long j, SpatDecoderFile spatDecoderFile, float f, float f2, float f3);

    public static final native void SpatDecoderFile_close(long j, SpatDecoderFile spatDecoderFile);

    public static final native void SpatDecoderFile_enableLooping(long j, SpatDecoderFile spatDecoderFile, boolean z);

    public static final native float SpatDecoderFile_getAssetDurationInMs(long j, SpatDecoderFile spatDecoderFile);

    public static final native long SpatDecoderFile_getAssetDurationInSamples(long j, SpatDecoderFile spatDecoderFile);

    public static final native double SpatDecoderFile_getElapsedTimeInMs(long j, SpatDecoderFile spatDecoderFile);

    public static final native long SpatDecoderFile_getElapsedTimeInSamples(long j, SpatDecoderFile spatDecoderFile);

    public static final native double SpatDecoderFile_getFreewheelTimeInMs(long j, SpatDecoderFile spatDecoderFile);

    public static final native double SpatDecoderFile_getResyncThresholdMs(long j, SpatDecoderFile spatDecoderFile);

    public static final native int SpatDecoderFile_getSyncMode(long j, SpatDecoderFile spatDecoderFile);

    public static final native boolean SpatDecoderFile_isOpen(long j, SpatDecoderFile spatDecoderFile);

    public static final native boolean SpatDecoderFile_loopingEnabled(long j, SpatDecoderFile spatDecoderFile);

    public static final native int SpatDecoderFile_open__SWIG_0(long j, SpatDecoderFile spatDecoderFile, String str, int i);

    public static final native int SpatDecoderFile_open__SWIG_1(long j, SpatDecoderFile spatDecoderFile, String str);

    public static final native int SpatDecoderFile_open__SWIG_2(long j, SpatDecoderFile spatDecoderFile, String str, long j2, AssetDescriptor assetDescriptor, int i);

    public static final native int SpatDecoderFile_open__SWIG_3(long j, SpatDecoderFile spatDecoderFile, String str, long j2, AssetDescriptor assetDescriptor);

    public static final native int SpatDecoderFile_seekToMs(long j, SpatDecoderFile spatDecoderFile, float f);

    public static final native int SpatDecoderFile_seekToSample(long j, SpatDecoderFile spatDecoderFile, long j2);

    public static final native void SpatDecoderFile_setEventListenerInternal(long j, SpatDecoderFile spatDecoderFile, long j2, EventListener eventListener);

    public static final native void SpatDecoderFile_setExternalClockInMs(long j, SpatDecoderFile spatDecoderFile, double d);

    public static final native void SpatDecoderFile_setFreewheelTimeInMs(long j, SpatDecoderFile spatDecoderFile, double d);

    public static final native void SpatDecoderFile_setResyncThresholdMs(long j, SpatDecoderFile spatDecoderFile, double d);

    public static final native void SpatDecoderFile_setSyncMode(long j, SpatDecoderFile spatDecoderFile, int i);

    public static final native long SpatDecoderInterface_SWIGUpcast(long j);

    public static final native void SpatDecoderInterface_enableFocus(long j, SpatDecoderInterface spatDecoderInterface, boolean z, boolean z2);

    public static final native int SpatDecoderInterface_getPlayState(long j, SpatDecoderInterface spatDecoderInterface);

    public static final native float SpatDecoderInterface_getVolume(long j, SpatDecoderInterface spatDecoderInterface);

    public static final native float SpatDecoderInterface_getVolumeDecibels(long j, SpatDecoderInterface spatDecoderInterface);

    public static final native int SpatDecoderInterface_pause(long j, SpatDecoderInterface spatDecoderInterface);

    public static final native int SpatDecoderInterface_pauseScheduled(long j, SpatDecoderInterface spatDecoderInterface, float f);

    public static final native int SpatDecoderInterface_pauseWithFade(long j, SpatDecoderInterface spatDecoderInterface, float f);

    public static final native int SpatDecoderInterface_play(long j, SpatDecoderInterface spatDecoderInterface);

    public static final native int SpatDecoderInterface_playScheduled(long j, SpatDecoderInterface spatDecoderInterface, float f);

    public static final native int SpatDecoderInterface_playWithFade(long j, SpatDecoderInterface spatDecoderInterface, float f);

    public static final native void SpatDecoderInterface_setFocusOrientationQuat(long j, SpatDecoderInterface spatDecoderInterface, long j2, TBQuat tBQuat);

    public static final native void SpatDecoderInterface_setFocusProperties(long j, SpatDecoderInterface spatDecoderInterface, float f, float f2);

    public static final native void SpatDecoderInterface_setFocusWidthDegrees(long j, SpatDecoderInterface spatDecoderInterface, float f);

    public static final native void SpatDecoderInterface_setOffFocusLeveldB(long j, SpatDecoderInterface spatDecoderInterface, float f);

    public static final native void SpatDecoderInterface_setVolumeDecibels__SWIG_0(long j, SpatDecoderInterface spatDecoderInterface, float f, float f2, boolean z);

    public static final native void SpatDecoderInterface_setVolumeDecibels__SWIG_1(long j, SpatDecoderInterface spatDecoderInterface, float f, float f2);

    public static final native void SpatDecoderInterface_setVolume__SWIG_0(long j, SpatDecoderInterface spatDecoderInterface, float f, float f2, boolean z);

    public static final native void SpatDecoderInterface_setVolume__SWIG_1(long j, SpatDecoderInterface spatDecoderInterface, float f, float f2);

    public static final native long SpatDecoderQueue_SWIGUpcast(long j);

    public static final native int SpatDecoderQueue_enqueueDataFloat(long j, SpatDecoderQueue spatDecoderQueue, ByteBuffer byteBuffer, int i, int i2);

    public static final native int SpatDecoderQueue_enqueueDataInt16(long j, SpatDecoderQueue spatDecoderQueue, ByteBuffer byteBuffer, int i, int i2);

    public static final native int SpatDecoderQueue_enqueueSilence(long j, SpatDecoderQueue spatDecoderQueue, int i, int i2);

    public static final native void SpatDecoderQueue_flushQueue(long j, SpatDecoderQueue spatDecoderQueue);

    public static final native boolean SpatDecoderQueue_getEndOfStreamStatus(long j, SpatDecoderQueue spatDecoderQueue);

    public static final native int SpatDecoderQueue_getFreeSpaceInQueue(long j, SpatDecoderQueue spatDecoderQueue, int i);

    public static final native BigInteger SpatDecoderQueue_getNumSamplesDequeuedPerChannel(long j, SpatDecoderQueue spatDecoderQueue);

    public static final native int SpatDecoderQueue_getQueueSize(long j, SpatDecoderQueue spatDecoderQueue, int i);

    public static final native void SpatDecoderQueue_setEndOfStream(long j, SpatDecoderQueue spatDecoderQueue, boolean z);

    public static final native void SpatDecoderQueue_setEventListenerInternal(long j, SpatDecoderQueue spatDecoderQueue, long j2, EventListener eventListener);

    public static final native long TBQuat_antiRotateVectorByQuat(long j, TBQuat tBQuat, long j2, TBVector tBVector);

    public static final native long TBQuat_convertFromOpenGLQuaternion(float f, float f2, float f3, float f4);

    public static final native long TBQuat_generateRandomQuat();

    public static final native long TBQuat_getEulerAnglesFromQuat(long j, TBQuat tBQuat);

    public static final native long TBQuat_getForwardFromQuat(long j, TBQuat tBQuat);

    public static final native long TBQuat_getFromToQuatRotation(long j, TBVector tBVector, long j2, TBVector tBVector2);

    public static final native long TBQuat_getQuatFromEulerAngles(float f, float f2, float f3);

    public static final native long TBQuat_getQuatFromForwardAndUpVectors(long j, TBVector tBVector, long j2, TBVector tBVector2);

    public static final native long TBQuat_getQuatFromMatrix(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9);

    public static final native long TBQuat_getRightFromQuat(long j, TBQuat tBQuat);

    public static final native long TBQuat_getUpFromQuat(long j, TBQuat tBQuat);

    public static final native long TBQuat_identity();

    public static final native long TBQuat_invert(long j, TBQuat tBQuat);

    public static final native void TBQuat_normalise(long j, TBQuat tBQuat);

    public static final native long TBQuat_quatProductUnNormalised(long j, TBQuat tBQuat, long j2, TBQuat tBQuat2);

    public static final native long TBQuat_rotateVectorByQuat(long j, TBQuat tBQuat, long j2, TBVector tBVector);

    public static final native String TBQuat_toString__SWIG_0(long j, TBQuat tBQuat, int i);

    public static final native String TBQuat_toString__SWIG_1(long j, TBQuat tBQuat);

    public static final native float TBQuat_w_get(long j, TBQuat tBQuat);

    public static final native void TBQuat_w_set(long j, TBQuat tBQuat, float f);

    public static final native float TBQuat_x_get(long j, TBQuat tBQuat);

    public static final native void TBQuat_x_set(long j, TBQuat tBQuat, float f);

    public static final native float TBQuat_y_get(long j, TBQuat tBQuat);

    public static final native void TBQuat_y_set(long j, TBQuat tBQuat, float f);

    public static final native float TBQuat_z_get(long j, TBQuat tBQuat);

    public static final native void TBQuat_z_set(long j, TBQuat tBQuat, float f);

    public static final native float TBVector_Angle(long j, TBVector tBVector, long j2, TBVector tBVector2);

    public static final native long TBVector_CrossProduct(long j, TBVector tBVector, long j2, TBVector tBVector2);

    public static final native float TBVector_DotProduct(long j, TBVector tBVector, long j2, TBVector tBVector2);

    public static final native void TBVector_abs__SWIG_0(long j, TBVector tBVector);

    public static final native void TBVector_clampMagnitude(long j, TBVector tBVector, float f);

    public static final native long TBVector_forward();

    public static final native long TBVector_getVectorFromAziEle(float f, float f2);

    public static final native long TBVector_getVectorFromAziEleDist(float f, float f2, float f3);

    public static final native long TBVector_getVectorFromEuler(long j, TBVector tBVector);

    public static final native float TBVector_magSquared(long j, TBVector tBVector);

    public static final native float TBVector_magnitude(long j, TBVector tBVector);

    public static final native float TBVector_max_val(long j, TBVector tBVector);

    public static final native float TBVector_min_val(long j, TBVector tBVector);

    public static final native void TBVector_normalise(long j, TBVector tBVector);

    public static final native void TBVector_rotateByVectors(long j, TBVector tBVector, long j2, TBVector tBVector2, long j3, TBVector tBVector3);

    public static final native void TBVector_set(long j, TBVector tBVector, float f, float f2, float f3);

    public static final native String TBVector_toString__SWIG_0(long j, TBVector tBVector, int i);

    public static final native String TBVector_toString__SWIG_1(long j, TBVector tBVector);

    public static final native long TBVector_up();

    public static final native float TBVector_x_get(long j, TBVector tBVector);

    public static final native void TBVector_x_set(long j, TBVector tBVector, float f);

    public static final native float TBVector_y_get(long j, TBVector tBVector);

    public static final native void TBVector_y_set(long j, TBVector tBVector, float f);

    public static final native float TBVector_z_get(long j, TBVector tBVector);

    public static final native void TBVector_z_set(long j, TBVector tBVector, float f);

    public static final native long TBVector_zero();

    public static final native boolean ThreadSettings_useDecoderThread_get(long j, ThreadSettings threadSettings);

    public static final native void ThreadSettings_useDecoderThread_set(long j, ThreadSettings threadSettings, boolean z);

    public static final native int TransportControl_getPlayState(long j, TransportControl transportControl);

    public static final native int TransportControl_pause(long j, TransportControl transportControl);

    public static final native int TransportControl_pauseScheduled(long j, TransportControl transportControl, float f);

    public static final native int TransportControl_pauseWithFade(long j, TransportControl transportControl, float f);

    public static final native int TransportControl_play(long j, TransportControl transportControl);

    public static final native int TransportControl_playScheduled(long j, TransportControl transportControl, float f);

    public static final native int TransportControl_playWithFade(long j, TransportControl transportControl, float f);

    public static final native int TransportControl_stop(long j, TransportControl transportControl);

    public static final native int TransportControl_stopScheduled(long j, TransportControl transportControl, float f);

    public static final native int TransportControl_stopWithFade(long j, TransportControl transportControl, float f);

    public static final native void delete_AssetDescriptor(long j);

    public static final native void delete_AttenuationProps(long j);

    public static final native void delete_AudioEngine(long j);

    public static final native void delete_AudioResampler(long j);

    public static final native void delete_AudioSettings(long j);

    public static final native void delete_DirectionalProps(long j);

    public static final native void delete_EngineInitSettings(long j);

    public static final native void delete_EventListener(long j);

    public static final native void delete_Experimental(long j);

    public static final native void delete_LoudnessStatistics(long j);

    public static final native void delete_MemorySettings(long j);

    public static final native void delete_NetworkSettings(long j);

    public static final native void delete_PlatformSettings(long j);

    public static final native void delete_TBQuat(long j);

    public static final native void delete_TBVector(long j);

    public static final native void delete_ThreadSettings(long j);

    public static final native int getNumChannelsForMap(int i);

    public static final native long kMaxStrSize_get();

    public static final native long new_AssetDescriptor__SWIG_0();

    public static final native long new_AssetDescriptor__SWIG_1(long j, long j2);

    public static final native long new_AttenuationProps__SWIG_0();

    public static final native long new_AttenuationProps__SWIG_1(float f, float f2, float f3, boolean z);

    public static final native long new_AttenuationProps__SWIG_2(float f, float f2, float f3);

    public static final native long new_AudioSettings();

    public static final native long new_DirectionalProps__SWIG_0();

    public static final native long new_DirectionalProps__SWIG_1(float f, float f2);

    public static final native long new_EngineInitSettings();

    public static final native long new_EventListener();

    public static final native long new_Experimental();

    public static final native long new_LoudnessStatistics();

    public static final native long new_MemorySettings();

    public static final native long new_NetworkSettings();

    public static final native long new_PlatformSettings();

    public static final native long new_TBQuat__SWIG_0();

    public static final native long new_TBQuat__SWIG_1(float f, float f2, float f3, float f4);

    public static final native long new_TBQuat__SWIG_2(long j, TBQuat tBQuat);

    public static final native long new_TBVector__SWIG_0();

    public static final native long new_TBVector__SWIG_1(float f, float f2, float f3);

    public static final native long new_TBVector__SWIG_2(float f);

    public static final native long new_ThreadSettings();

    private static final native void swig_module_init();

    static {
        System.loadLibrary("Audio360");
        System.loadLibrary("Audio360-JNI");
        swig_module_init();
    }

    public static void SwigDirector_EventListener_onNewEvent(EventListener eventListener, int i) {
        eventListener.onNewEvent(Event.swigToEnum(i));
    }
}
