# About

This super simple Android application project demonstrates that version 3.3.0 of the `espresso-core` library does not work together with version 1.2.5 of the `fragment-testing` library.

If you inspect the [app/build.gradle](app/build.gradle) file, you'll see that the only two testing libraries declared in the Android tests configuration are the `espresso-core` and `fragment-testing` libraries.

If you run the [MainActivityInstrumentedTest](app/src/androidTest/java/com/tazkiyatech/espressoexperiment/MainActivityInstrumentedTest.kt) test class, you'll see that the test run fails with an `Instrumentation run failed due to 'Process crashed.'` message. On inspection of Logcat, you'll see a message as follows:

```
E/AndroidRuntime: FATAL EXCEPTION: Instr: androidx.test.runner.AndroidJUnitRunner
Process: com.tazkiyatech.espressoexperiment, PID: 12272
java.lang.NoSuchMethodError: No virtual method shouldWaitForActivitiesToComplete()Z in class Landroidx/test/runner/AndroidJUnitRunner; or its super classes (declaration of 'androidx.test.runner.AndroidJUnitRunner' appears in /data/app/com.tazkiyatech.espressoexperiment.test-GV-nmmuMmkY9wm_jRwOoGg==/base.apk)
    at androidx.test.runner.AndroidJUnitRunner.addListenersLegacyOrder(AndroidJUnitRunner.java:442)
    at androidx.test.runner.AndroidJUnitRunner.addListeners(AndroidJUnitRunner.java:423)
    at androidx.test.runner.AndroidJUnitRunner.onStart(AndroidJUnitRunner.java:391)
    at android.app.Instrumentation$InstrumentationThread.run(Instrumentation.java:2189)
```

An issue has been raised about this in the [android-test](https://github.com/android/android-test) repository [here](https://github.com/android/android-test/issues/731).
