package com.twobigears.audio360;

/* JADX INFO: loaded from: classes4.dex */
public enum AmbisonicRenderer {
    VIRTUAL_SPEAKER,
    AMBISONIC;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static AmbisonicRenderer swigToEnum(int i) {
        AmbisonicRenderer[] ambisonicRendererArr = (AmbisonicRenderer[]) AmbisonicRenderer.class.getEnumConstants();
        if (i < ambisonicRendererArr.length && i >= 0 && ambisonicRendererArr[i].swigValue == i) {
            return ambisonicRendererArr[i];
        }
        for (AmbisonicRenderer ambisonicRenderer : ambisonicRendererArr) {
            if (ambisonicRenderer.swigValue == i) {
                return ambisonicRenderer;
            }
        }
        throw new IllegalArgumentException("No enum " + AmbisonicRenderer.class + " with value " + i);
    }

    AmbisonicRenderer() {
        this.swigValue = SwigNext.access$008();
    }

    AmbisonicRenderer(int i) {
        this.swigValue = i;
        int unused = SwigNext.next = i + 1;
    }

    AmbisonicRenderer(AmbisonicRenderer ambisonicRenderer) {
        int i = ambisonicRenderer.swigValue;
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
