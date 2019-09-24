package com.alex.study.jnitest;

public class TestJni {

    static {
        System.loadLibrary("test-jni");
    }
    public static native String getStringFromNativeMethod();
}
