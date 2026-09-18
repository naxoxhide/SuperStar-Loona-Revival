package com.RenderHeads.AVProVideo;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLES30;
import androidx.work.Data;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

/* JADX INFO: loaded from: classes.dex */
public class AVProMobileVideo_GlRender {
    private int m_FragmentShaderHandle;
    private String m_FragmentShaderSource;
    private int m_FrameBufferHandle;
    private int m_FrameBufferTextureHandle;
    private int m_FramebufferHeight;
    private int m_FramebufferWidth;
    private boolean m_HasImageData;
    private int m_Height;
    private ByteBuffer m_ImageData;
    private FloatBuffer m_MatrixFloatBuffer;
    private int m_MatrixHandle;
    private int m_ProgramHandle;
    private FloatBuffer m_QuadPositions;
    private FloatBuffer m_QuadUVs;
    private int m_TextureHandle;
    private boolean m_UseFastOesPath;
    private int m_VertexAttribHandle;
    private int m_VertexShaderHandle;
    private String m_VertexShaderSource;
    private int m_Width;
    private int[] m_aiVertexBufferObjects = new int[2];
    private boolean m_bBlendEnabled;
    private boolean m_bCanUseGLBindVertexArray;
    private boolean m_bCullFace;
    private boolean m_bDepthTest;
    private boolean m_bStencilEnabled;
    private boolean m_bTextureFormat_EOS;
    private int m_iCurrentProgram;
    private int m_iFrameBufferBinding;
    private int m_iRenderBufferBinding;
    private int m_iVertexArrayObject;
    private int m_uvAttribHandle;

    public void Setup(int i, int i2, byte[] bArr, boolean z, boolean z2, boolean z3) {
        this.m_Width = i;
        this.m_Height = i2;
        this.m_bTextureFormat_EOS = z;
        this.m_bCanUseGLBindVertexArray = z2;
        this.m_UseFastOesPath = z3;
        if (bArr != null) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i * i2 * 4);
            this.m_ImageData = byteBufferAllocate;
            byteBufferAllocate.put(bArr);
            new StringBuilder("CreateGlTexture image size: ").append(this.m_ImageData.position());
            this.m_ImageData.position(0);
            this.m_HasImageData = true;
        }
        if (!z3) {
            if (this.m_bTextureFormat_EOS) {
                LoadGlShaders_TextureOES();
            } else {
                LoadGlShaders_Texture2D();
            }
        }
        CreateGlTexture();
        if (z3) {
            return;
        }
        CreateGlShaderProgram();
        SetupGlShaderProgram();
        CreateGlQuadGeometry();
    }

    public void Destroy() {
        DestroyGlTexture();
        DestroyRenderTarget();
        int i = this.m_ProgramHandle;
        if (i > 0) {
            GLES20.glDeleteProgram(i);
            this.m_ProgramHandle = 0;
        }
        if (this.m_bCanUseGLBindVertexArray) {
            int i2 = this.m_iVertexArrayObject;
            if (i2 > 0) {
                GLES30.glDeleteVertexArrays(1, new int[]{i2}, 0);
                GLES30.glGetError();
                this.m_iVertexArrayObject = 0;
            }
            int[] iArr = this.m_aiVertexBufferObjects;
            if (iArr[0] > 0) {
                GLES30.glDeleteBuffers(2, new int[]{iArr[0], iArr[1]}, 0);
                GLES30.glGetError();
                int[] iArr2 = this.m_aiVertexBufferObjects;
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
        }
        this.m_QuadPositions = null;
        this.m_QuadUVs = null;
        this.m_aiVertexBufferObjects = null;
        this.m_MatrixFloatBuffer = null;
    }

    public int GetGlTextureHandle(boolean z) {
        if (!this.m_UseFastOesPath && !z) {
            return this.m_FrameBufferTextureHandle;
        }
        return this.m_TextureHandle;
    }

    public void CreateRenderTarget(int i, int i2) {
        new StringBuilder("CreateRenderTarget() called (").append(i).append(" x ").append(i2).append(")");
        GLES20.glGetError();
        this.m_FramebufferWidth = i;
        this.m_FramebufferHeight = i2;
        IntBuffer intBufferAllocate = IntBuffer.allocate(1);
        GLES20.glGenFramebuffers(1, intBufferAllocate);
        this.m_FrameBufferHandle = intBufferAllocate.get(0);
        new StringBuilder("CreateRenderTarget m_FrameBufferHandle: ").append(this.m_FrameBufferHandle);
        GLES20.glGenTextures(1, intBufferAllocate);
        this.m_FrameBufferTextureHandle = intBufferAllocate.get(0);
        new StringBuilder("CreateRenderTarget m_FrameBufferTextureHandle: ").append(this.m_FrameBufferTextureHandle);
        GLES20.glBindFramebuffer(36160, this.m_FrameBufferHandle);
        GLES20.glBindTexture(3553, this.m_FrameBufferTextureHandle);
        GLES20.glTexImage2D(3553, 0, 6408, this.m_FramebufferWidth, this.m_FramebufferHeight, 0, 6408, 5121, null);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, Data.MAX_DATA_BYTES, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.m_FrameBufferTextureHandle, 0);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(17664);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glGetError();
    }

    public void DestroyRenderTarget() {
        new StringBuilder("DestroyRenderTarget m_FrameBufferHandle: ").append(this.m_FrameBufferHandle);
        int i = this.m_FrameBufferHandle;
        if (i != 0) {
            GLES20.glBindFramebuffer(36160, i);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, 0, 0);
            GLES20.glDeleteFramebuffers(1, new int[]{this.m_FrameBufferHandle}, 0);
            GLES20.glGetError();
            this.m_FrameBufferHandle = 0;
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glGetError();
        }
        new StringBuilder("DestroyRenderTarget m_FrameBufferTextureHandle: ").append(this.m_FrameBufferTextureHandle);
        int i2 = this.m_FrameBufferTextureHandle;
        if (i2 != 0) {
            GLES20.glDeleteTextures(1, new int[]{i2}, 0);
            GLES20.glGetError();
            this.m_FrameBufferTextureHandle = 0;
        }
    }

    public void StartRender() {
        if (this.m_FrameBufferHandle != 0) {
            IntBuffer intBufferAllocate = IntBuffer.allocate(8);
            GLES20.glGetBooleanv(3042, intBufferAllocate);
            this.m_bBlendEnabled = intBufferAllocate.get(0) == 1;
            GLES20.glGetBooleanv(2929, intBufferAllocate);
            this.m_bDepthTest = intBufferAllocate.get(0) == 1;
            GLES20.glGetBooleanv(2884, intBufferAllocate);
            this.m_bCullFace = intBufferAllocate.get(0) == 1;
            GLES20.glGetIntegerv(35725, intBufferAllocate);
            this.m_iCurrentProgram = intBufferAllocate.get(0);
            GLES20.glGetIntegerv(36006, intBufferAllocate);
            this.m_iFrameBufferBinding = intBufferAllocate.get(0);
            GLES20.glGetIntegerv(36007, intBufferAllocate);
            this.m_iRenderBufferBinding = intBufferAllocate.get(0);
            GLES20.glGetBooleanv(2960, intBufferAllocate);
            this.m_bStencilEnabled = intBufferAllocate.get(0) == 1;
            GLES20.glBindFramebuffer(36160, this.m_FrameBufferHandle);
            GLES20.glBindRenderbuffer(36161, 0);
            GLES20.glDisable(3089);
            GLES20.glViewport(0, 0, this.m_FramebufferWidth, this.m_FramebufferHeight);
            GLES20.glClear(16384);
        }
    }

    public void EndRender() {
        if (this.m_FrameBufferHandle != 0) {
            if (this.m_bBlendEnabled) {
                GLES20.glEnable(3042);
            } else {
                GLES20.glDisable(3042);
            }
            if (this.m_bDepthTest) {
                GLES20.glEnable(2929);
            } else {
                GLES20.glDisable(2929);
            }
            if (this.m_bCullFace) {
                GLES20.glEnable(2884);
            } else {
                GLES20.glDisable(2884);
            }
            if (this.m_bStencilEnabled) {
                GLES20.glEnable(2960);
            } else {
                GLES20.glDisable(2960);
            }
            GLES20.glBindFramebuffer(36160, this.m_iFrameBufferBinding);
            GLES20.glBindRenderbuffer(36161, this.m_iRenderBufferBinding);
            GLES20.glUseProgram(this.m_iCurrentProgram);
        }
    }

    public long Blit(SurfaceTexture surfaceTexture, float[] fArr) {
        GLES20.glBindBuffer(34963, 0);
        GLES20.glBindBuffer(34962, 0);
        GLES20.glDisable(2960);
        GLES20.glDisable(2929);
        GLES20.glDisable(2884);
        GLES20.glDisable(3042);
        GLES20.glColorMask(true, true, true, true);
        GLES20.glDepthMask(false);
        if (!this.m_bTextureFormat_EOS && surfaceTexture == null) {
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(770, 771);
        }
        GLES20.glUseProgram(this.m_ProgramHandle);
        if (!this.m_bCanUseGLBindVertexArray) {
            GLES20.glVertexAttribPointer(this.m_VertexAttribHandle, 3, 5126, false, 12, (Buffer) this.m_QuadPositions);
            GLES20.glEnableVertexAttribArray(this.m_VertexAttribHandle);
            GLES20.glVertexAttribPointer(this.m_uvAttribHandle, 2, 5126, false, 8, (Buffer) this.m_QuadUVs);
            GLES20.glEnableVertexAttribArray(this.m_uvAttribHandle);
        }
        boolean z = this.m_bTextureFormat_EOS;
        int i = z ? 36197 : 3553;
        long timestamp = 0;
        if (!z) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(i, this.m_TextureHandle);
        } else if (surfaceTexture != null) {
            IntBuffer intBufferAllocate = IntBuffer.allocate(1);
            GLES20.glGetTexParameteriv(36197, 36200, intBufferAllocate);
            int i2 = intBufferAllocate.get(0);
            if (i2 == 2) {
                GLES20.glActiveTexture(33985);
            } else if (i2 == 3) {
                GLES20.glActiveTexture(33986);
                GLES20.glActiveTexture(33985);
            }
            GLES20.glActiveTexture(33984);
            try {
                surfaceTexture.updateTexImage();
                timestamp = surfaceTexture.getTimestamp();
            } catch (IllegalStateException e) {
                new StringBuilder("Failed to updateTexImage in Blit: ").append(e);
            }
            if (fArr == null) {
                fArr = new float[16];
                surfaceTexture.getTransformMatrix(fArr);
            }
        }
        if (fArr != null) {
            FloatBuffer floatBufferCreateFloatBuffer = CreateFloatBuffer(fArr);
            this.m_MatrixFloatBuffer = floatBufferCreateFloatBuffer;
            GLES20.glUniformMatrix4fv(this.m_MatrixHandle, 1, false, floatBufferCreateFloatBuffer);
        }
        if (this.m_bCanUseGLBindVertexArray) {
            GLES30.glBindVertexArray(this.m_iVertexArrayObject);
            GLES20.glDrawArrays(5, 0, 4);
            GLES30.glBindVertexArray(0);
        } else {
            GLES20.glDrawArrays(5, 0, 4);
        }
        GLES20.glBindTexture(i, 0);
        GLES20.glDisableVertexAttribArray(this.m_uvAttribHandle);
        GLES20.glDisableVertexAttribArray(this.m_VertexAttribHandle);
        GLES20.glUseProgram(0);
        return timestamp;
    }

    private void LoadGlShaders_TextureOES() {
        this.m_VertexShaderSource = "#version 100\n";
        this.m_VertexShaderSource += "precision mediump float;\n";
        this.m_VertexShaderSource += "attribute vec4 vertexPosition;\n";
        this.m_VertexShaderSource += "attribute vec4 vertexUV;\n";
        this.m_VertexShaderSource += "uniform mat4 textureMat;\n";
        this.m_VertexShaderSource += "varying highp vec2 out_uv;\n";
        this.m_VertexShaderSource += "\n";
        this.m_VertexShaderSource += "void main()\n";
        this.m_VertexShaderSource += "{\n";
        this.m_VertexShaderSource += "\tgl_Position = vec4(vertexPosition.xy, 0.0, 1.0);\n";
        this.m_VertexShaderSource += "\tout_uv = (textureMat * vertexUV).xy;\n";
        this.m_VertexShaderSource += "}\n";
        this.m_FragmentShaderSource = "#version 100\n";
        this.m_FragmentShaderSource += "#extension GL_OES_EGL_image_external : require\n";
        this.m_FragmentShaderSource += "uniform samplerExternalOES texture;\n";
        this.m_FragmentShaderSource += "varying highp vec2 out_uv;\n";
        this.m_FragmentShaderSource += "\n";
        this.m_FragmentShaderSource += "void main()\n";
        this.m_FragmentShaderSource += "{\n";
        this.m_FragmentShaderSource += "\tgl_FragColor = texture2D(texture, out_uv);\n";
        this.m_FragmentShaderSource += "}\n";
    }

    private void LoadGlShaders_Texture2D() {
        this.m_VertexShaderSource = "#version 100\n";
        this.m_VertexShaderSource += "precision mediump float;\n";
        this.m_VertexShaderSource += "attribute vec4 vertexPosition;\n";
        this.m_VertexShaderSource += "attribute vec4 vertexUV;\n";
        this.m_VertexShaderSource += "uniform mat4 textureMat;\n";
        this.m_VertexShaderSource += "varying highp vec2 out_uv;\n";
        this.m_VertexShaderSource += "\n";
        this.m_VertexShaderSource += "void main()\n";
        this.m_VertexShaderSource += "{\n";
        this.m_VertexShaderSource += "\tgl_Position = vec4(vertexPosition.xy, 0.0, 1.0);\n";
        this.m_VertexShaderSource += "\tout_uv = (textureMat * vertexUV).xy;\n";
        this.m_VertexShaderSource += "}\n";
        this.m_FragmentShaderSource = "#version 100\n";
        this.m_FragmentShaderSource += "uniform sampler2D texture;\n";
        this.m_FragmentShaderSource += "varying highp vec2 out_uv;\n";
        this.m_FragmentShaderSource += "\n";
        this.m_FragmentShaderSource += "void main()\n";
        this.m_FragmentShaderSource += "{\n";
        this.m_FragmentShaderSource += "\tgl_FragColor = texture2D(texture, out_uv);\n";
        this.m_FragmentShaderSource += "}\n";
    }

    private void CreateGlTexture() {
        IntBuffer intBufferAllocate = IntBuffer.allocate(1);
        GLES20.glGenTextures(1, intBufferAllocate);
        int i = intBufferAllocate.get(0);
        this.m_TextureHandle = i;
        if (i > 0) {
            new StringBuilder("CreateGlTexture m_TextureHandle: ").append(this.m_TextureHandle);
            int i2 = this.m_bTextureFormat_EOS ? 36197 : 3553;
            GLES20.glBindTexture(i2, this.m_TextureHandle);
            if (this.m_HasImageData) {
                GLES20.glTexImage2D(i2, 0, 6408, this.m_Width, this.m_Height, 0, 6408, 5121, this.m_ImageData);
            }
            GLES20.glTexParameteri(i2, 10241, 9729);
            GLES20.glTexParameteri(i2, Data.MAX_DATA_BYTES, 9729);
            GLES20.glTexParameteri(i2, 10242, 33071);
            GLES20.glTexParameteri(i2, 10243, 33071);
            GLES20.glBindTexture(i2, 0);
            return;
        }
        new StringBuilder("Error allocating texture handle ").append(this.m_TextureHandle);
    }

    private void DestroyGlTexture() {
        int i = this.m_TextureHandle;
        if (i > 0) {
            GLES20.glDeleteTextures(1, new int[]{i}, 0);
            GLES20.glGetError();
            this.m_TextureHandle = 0;
        }
    }

    private void CreateGlShaderProgram() {
        this.m_VertexShaderHandle = LoadGlShader(35633, this.m_VertexShaderSource);
        this.m_FragmentShaderHandle = LoadGlShader(35632, this.m_FragmentShaderSource);
        int iGlCreateProgram = GLES20.glCreateProgram();
        if (iGlCreateProgram > 0) {
            GLES20.glAttachShader(iGlCreateProgram, this.m_VertexShaderHandle);
            GLES20.glAttachShader(iGlCreateProgram, this.m_FragmentShaderHandle);
            GLES20.glLinkProgram(iGlCreateProgram);
            this.m_ProgramHandle = iGlCreateProgram;
            GLES20.glDetachShader(iGlCreateProgram, this.m_VertexShaderHandle);
            GLES20.glDetachShader(this.m_ProgramHandle, this.m_FragmentShaderHandle);
            GLES20.glDeleteShader(this.m_VertexShaderHandle);
            GLES20.glDeleteShader(this.m_FragmentShaderHandle);
        }
    }

    private void SetupGlShaderProgram() {
        this.m_VertexAttribHandle = GLES20.glGetAttribLocation(this.m_ProgramHandle, "vertexPosition");
        this.m_uvAttribHandle = GLES20.glGetAttribLocation(this.m_ProgramHandle, "vertexUV");
        this.m_MatrixHandle = GLES20.glGetUniformLocation(this.m_ProgramHandle, "textureMat");
    }

    private void CreateGlQuadGeometry() {
        this.m_QuadPositions = CreateFloatBuffer(new float[]{-1.0f, -1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 1.0f, 0.0f});
        this.m_QuadUVs = CreateFloatBuffer(new float[]{0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f});
        if (this.m_bCanUseGLBindVertexArray) {
            IntBuffer intBufferAllocate = IntBuffer.allocate(1);
            GLES30.glGenVertexArrays(1, intBufferAllocate);
            int i = intBufferAllocate.get(0);
            this.m_iVertexArrayObject = i;
            GLES30.glBindVertexArray(i);
            IntBuffer intBufferAllocate2 = IntBuffer.allocate(2);
            GLES30.glGenBuffers(2, intBufferAllocate2);
            this.m_aiVertexBufferObjects[0] = intBufferAllocate2.get(0);
            this.m_aiVertexBufferObjects[1] = intBufferAllocate2.get(1);
            GLES30.glBindBuffer(34962, this.m_aiVertexBufferObjects[0]);
            GLES30.glBufferData(34962, 48, this.m_QuadPositions, 35044);
            GLES30.glVertexAttribPointer(this.m_VertexAttribHandle, 3, 5126, false, 0, 0);
            GLES30.glEnableVertexAttribArray(this.m_VertexAttribHandle);
            GLES30.glBindBuffer(34962, this.m_aiVertexBufferObjects[1]);
            GLES30.glBufferData(34962, 32, this.m_QuadUVs, 35044);
            GLES30.glVertexAttribPointer(this.m_uvAttribHandle, 2, 5126, false, 0, 0);
            GLES30.glEnableVertexAttribArray(this.m_uvAttribHandle);
            GLES30.glBindVertexArray(0);
        }
    }

    private int LoadGlShader(int i, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i);
        if (iGlCreateShader > 0) {
            GLES20.glShaderSource(iGlCreateShader, str);
            GLES20.glCompileShader(iGlCreateShader);
        }
        return iGlCreateShader;
    }

    private static FloatBuffer CreateFloatBuffer(float[] fArr) {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr);
        floatBufferAsFloatBuffer.position(0);
        return floatBufferAsFloatBuffer;
    }
}
