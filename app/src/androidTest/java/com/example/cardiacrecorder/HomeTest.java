package com.example.cardiacrecorder;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class HomeTest {

    @Rule
    public ActivityScenarioRule<Home> activityScenarioRule = new ActivityScenarioRule<>(Home.class);

    @Test
    public void homeactivitytest()
    {
        onView(withId(R.id.homeactivityid)).check(matches(isDisplayed()));
        onView(withId(R.id.textView)).check(matches(withText("Your Records")));
        onView(withId(R.id.insertdataid)).check(matches(isDisplayed()));
        onView(withId(R.id.insertdataid)).perform(click());
        onView(withId(R.id.adddataactivityid)).check(matches(isDisplayed()));
    }

}