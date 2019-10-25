package devanir.soaresjunior.zasterchallenge

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import devanir.soaresjunior.zasterchallenge.ui.MainActivity
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LogInFragTest {
    private val activityTestRule = ActivityTestRule<MainActivity>(
        MainActivity::class.java)

    @Before
    fun setUp() {
        activityTestRule.launchActivity(Intent())
    }

    @After
    fun tearDown() {
    }

    @Test
    fun test_login(){
        onView(withId(R.id.etUsername)).perform(ViewActions.clearText())
        onView(withId(R.id.etUsername)).perform(ViewActions.typeText("devanir"))
        onView(withId(R.id.etPassword)).perform(ViewActions.clearText())
        onView(withId(R.id.etPassword)).perform(ViewActions.typeText("123devanir123"))
        Thread.sleep(1000)
        onView(withId(R.id.etPassword)).check(matches(withText("123devanir123")))
        onView(withId(R.id.btn_login)).perform(ViewActions.click())

    }
}