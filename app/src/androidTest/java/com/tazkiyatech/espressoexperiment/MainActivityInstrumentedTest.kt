package com.tazkiyatech.espressoexperiment

import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.After
import org.junit.Before
import org.junit.Test

class MainActivityInstrumentedTest {

    private lateinit var activityScenario: ActivityScenario<MainActivity>

    @Before
    fun setUp() {
        activityScenario = launch(MainActivity::class.java)
    }

    @After
    fun tearDown() {
        activityScenario.close()
    }

    @Test
    fun hello_world_text_view_is_laid_out_correctly() {
        onView(withId(R.id.helloWorldTextView)).check(matches(isCompletelyDisplayed()))
        onView(withId(R.id.helloWorldTextView)).check(matches(withText("Hello World!")))
    }
}