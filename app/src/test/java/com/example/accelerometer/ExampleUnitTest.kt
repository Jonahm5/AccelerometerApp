package com.example.accelerometer

import androidx.lifecycle.SavedStateHandle
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    private var testViewModel = MainActivityViewModel()
    @Test
    fun sigAxisWorks1() {
        testViewModel.Signif = 1f
        assertEquals(testViewModel.sigAxis(1.0f, 1.1f, 0.9f), "Y")
    }
    @Test
    fun sigAxisWorks2() {
        testViewModel.Signif = 5f
        assertEquals(testViewModel.sigAxis(5.1f, 6.0f, 7.0f), "X")

    }

    }