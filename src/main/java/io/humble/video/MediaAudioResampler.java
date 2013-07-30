/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.0
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.humble.video;
import io.humble.ferry.*;
/**
 * A MediaAudioResampler object resamples {@link MediaAudio} objects 
 * from  
 * one format/sample-rate/channel-layout to another.  
 */
public class MediaAudioResampler extends Configurable {
  // JNIHelper.swg: Start generated code
  // >>>>>>>>>>>>>>>>>>>>>>>>>>>
  /**
   * This method is only here to use some references and remove
   * a Eclipse compiler warning.
   */
  @SuppressWarnings("unused")
  private void noop()
  {
    Buffer.make(null, 1);
  }
   
  private volatile long swigCPtr;

  /**
   * Internal Only.
   */
  protected MediaAudioResampler(long cPtr, boolean cMemoryOwn) {
    super(VideoJNI.SWIGMediaAudioResamplerUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }
  
  /**
   * Internal Only.
   */
  protected MediaAudioResampler(long cPtr, boolean cMemoryOwn,
      java.util.concurrent.atomic.AtomicLong ref)
  {
    super(VideoJNI.SWIGMediaAudioResamplerUpcast(cPtr),
     cMemoryOwn, ref);
    swigCPtr = cPtr;
  }
    
  /**
   * Internal Only.  Not part of public API.
   *
   * Get the raw value of the native object that obj is proxying for.
   *   
   * @param obj The java proxy object for a native object.
   * @return The raw pointer obj is proxying for.
   */
  protected static long getCPtr(MediaAudioResampler obj) {
    if (obj == null) return 0;
    return obj.getMyCPtr();
  }

  /**
   * Internal Only.  Not part of public API.
   *
   * Get the raw value of the native object that we're proxying for.
   *   
   * @return The raw pointer we're proxying for.
   */  
  protected long getMyCPtr() {
    if (swigCPtr == 0) throw new IllegalStateException("underlying native object already deleted");
    return swigCPtr;
  }
  
  /**
   * Create a new MediaAudioResampler object that is actually referring to the
   * exact same underlying native object.
   *
   * @return the new Java object.
   */
  @Override
  public MediaAudioResampler copyReference() {
    if (swigCPtr == 0)
      return null;
    else
      return new MediaAudioResampler(swigCPtr, swigCMemOwn, getJavaRefCount());
  }

  /**
   * Compares two values, returning true if the underlying objects in native code are the same object.
   *
   * That means you can have two different Java objects, but when you do a comparison, you'll find out
   * they are the EXACT same object.
   *
   * @return True if the underlying native object is the same.  False otherwise.
   */
  public boolean equals(Object obj) {
    boolean equal = false;
    if (obj instanceof MediaAudioResampler)
      equal = (((MediaAudioResampler)obj).swigCPtr == this.swigCPtr);
    return equal;
  }
  
  /**
   * Get a hashable value for this object.
   *
   * @return the hashable value.
   */
  public int hashCode() {
     return (int)swigCPtr;
  }
  
  // <<<<<<<<<<<<<<<<<<<<<<<<<<<
  // JNIHelper.swg: End generated code
  
  public static MediaAudioResampler make(AudioChannel.Layout outLayout, int outSampleRate, AudioFormat.Type outFormat, AudioChannel.Layout inLayout, int inSampleRate, AudioFormat.Type inFormat) {
    long cPtr = VideoJNI.MediaAudioResampler_make(outLayout.swigValue(), outSampleRate, outFormat.swigValue(), inLayout.swigValue(), inSampleRate, inFormat.swigValue());
    return (cPtr == 0) ? null : new MediaAudioResampler(cPtr, false);
  }

  public AudioChannel.Layout getOutputLayout() {
    return AudioChannel.Layout.swigToEnum(VideoJNI.MediaAudioResampler_getOutputLayout(swigCPtr, this));
  }

  public AudioChannel.Layout getInputLayout() {
    return AudioChannel.Layout.swigToEnum(VideoJNI.MediaAudioResampler_getInputLayout(swigCPtr, this));
  }

  public int getOutputSampleRate() {
    return VideoJNI.MediaAudioResampler_getOutputSampleRate(swigCPtr, this);
  }

  public int getInputSampleRate() {
    return VideoJNI.MediaAudioResampler_getInputSampleRate(swigCPtr, this);
  }

  public AudioFormat.Type getOutputFormat() {
    return AudioFormat.Type.swigToEnum(VideoJNI.MediaAudioResampler_getOutputFormat(swigCPtr, this));
  }

  public AudioFormat.Type getInputFormat() {
    return AudioFormat.Type.swigToEnum(VideoJNI.MediaAudioResampler_getInputFormat(swigCPtr, this));
  }

  public int getInputChannels() {
    return VideoJNI.MediaAudioResampler_getInputChannels(swigCPtr, this);
  }

  public int getOutputChannels() {
    return VideoJNI.MediaAudioResampler_getOutputChannels(swigCPtr, this);
  }

  public void open() {
    VideoJNI.MediaAudioResampler_open(swigCPtr, this);
  }

/**
 * Convert audio.  
 * in can be set to null to flush the last few samples out at the  
 * end.  
 * If more input is provided than output space then the input will be 
 * buffered.  
 * You can avoid this buffering by providing more output space than 
 * input.  
 *  
 * @param	out output audio object. caller is responsible for making 
 *		 the correct size.  
 * @param	in input audio.  
 * @return	number of samples output per channel.  
 * @throws	RuntimeError if we get an error or InvalidArgument if the 
 *		 attributes of  
 * in or out do not match what this resampler expected.  
 */
  public int resample(MediaAudio out, MediaAudio in) {
    return VideoJNI.MediaAudioResampler_resample(swigCPtr, this, MediaAudio.getCPtr(out), out, MediaAudio.getCPtr(in), in);
  }

/**
 * Convert the next timestamp from input to output  
 * timestamps are in 1/(in_sample_rate out_sample_rate) units.  
 * 
 * First is when automatic timestamp compensation is not used, (min_compensation 
 * >= FLT_MAX)  
 * in this case timestamps will be passed through with delays compensated 
 *  
 * Second is when automatic timestamp compensation is used, (min_compensation 
 * < FLT_MAX)  
 * in this case the output timestamps will match output sample numbers 
 *  
 * @param	pts timestamp for the next input sample, INT64_MIN if unknown 
 *		  
 * @return	the output timestamp for the next output sample  
 */
  public long getNextPts(long pts) {
    return VideoJNI.MediaAudioResampler_getNextPts(swigCPtr, this, pts);
  }

/**
 * Activate resampling compensation.  
 */
  public void setCompensation(int sample_delta, int compensation_distance) {
    VideoJNI.MediaAudioResampler_setCompensation(swigCPtr, this, sample_delta, compensation_distance);
  }

/**
 * Set a customized input channel mapping.  
 * @param	channel_map customized input channel mapping (array of channel 
 *		  
 * indexes, -1 for a muted channel)  
 * @return	AVERROR error code in case of failure.  
 * Set a customized remix matrix.  
 * @param	matrix remix coefficients; matrix[i + stride o] is  
 * the weight of input channel i in output channel o  
 * @param	stride offset between lines of the matrix  
 * @return	AVERROR error code in case of failure.  
 * Drops the specified number of output samples.  
 * @return	# of samples dropped.  
 */
  public int dropOutput(int count) {
    return VideoJNI.MediaAudioResampler_dropOutput(swigCPtr, this, count);
  }

/**
 * Injects the specified number of silence samples.  
 * @return	# of samples injected.  
 */
  public int injectSilence(int count) {
    return VideoJNI.MediaAudioResampler_injectSilence(swigCPtr, this, count);
  }

/**
 * Gets the delay the next input sample will experience relative to 
 * the next output sample.  
 * The resampler can buffer data if more input has been provided than 
 * available  
 * output space, also converting between sample rates needs a delay. 
 *  
 * This function returns the sum of all such delays.  
 * The exact delay is not necessarily an integer value in either input 
 * or  
 * output sample rate. Especially when downsampling by a large value, 
 * the  
 * output sample rate may be a poor choice to represent the delay, similarly 
 *  
 * for upsampling and the input sample rate.  
 * @param	base timebase in which the returned delay will be  
 * if its set to 1 the returned delay is in seconds  
 * if its set to 1000 the returned delay is in milli seconds  
 * if its set to the input sample rate then the returned delay is in 
 * input samples  
 * if its set to the output sample rate then the returned delay is in 
 * output samples  
 * an exact rounding free delay can be found by using LCM(in_sample_rate, 
 * out_sample_rate)  
 * the delay in 1/base units.  
 */
  public long getDelay(long base) {
    return VideoJNI.MediaAudioResampler_getDelay(swigCPtr, this, base);
  }

}
