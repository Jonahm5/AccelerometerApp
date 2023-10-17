package com.example.accelerometer

import android.widget.SeekBar
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class InstrumentedTest {
    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setUp(){
        scenario = launch(MainActivity::class.java)
    }

    @After
    fun tearDown(){
        scenario.close()
    }

    @Test
    fun checkUI(){
        onView(withId(R.id.SBar)).check(matches(isDisplayed()))
        onView(withId(R.id.SCount)).check(matches(isDisplayed()))
        onView(withId(R.id.Xfind)).check(matches(isDisplayed()))
        onView(withId(R.id.Yfind)).check(matches(isDisplayed()))
        onView(withId(R.id.Zfind)).check(matches(isDisplayed()))
    }

    @Test
    fun texttest(){
        onView(ViewMatchers.withText("Significant Distance")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}