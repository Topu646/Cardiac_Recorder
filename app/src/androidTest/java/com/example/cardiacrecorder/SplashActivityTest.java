package com.example.cardiacrecorder;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
//import static org.junit.Assert.*;

//import static java.util.regex.Pattern.matches;

import android.view.View;

//import androidx.annotation.ContentView;
//import androidx.test.core.app.ActivityScenario;
//import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAssertion;
//import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Objects;

@RunWith(JUnit4.class)

public class SplashActivityTest {

    @Rule
    public ActivityScenarioRule<Splash_Activity> activityActivityScenarioRule = new ActivityScenarioRule<>(Splash_Activity.class);

    @Test
    public void splashactivityUItest() {
        onView(withId(R.id.splashactivityid)).check(matches(isDisplayed()));
    }
}