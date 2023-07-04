package com.example.cardiacrecorder;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RegisterActivityTest {

    @Rule
    public ActivityScenarioRule<RegisterActivity> activityActivityScenarioRule = new ActivityScenarioRule<>(RegisterActivity.class);

    @Test
    public void registeractivitytest()
    {
        onView(withId(R.id.registeractivityid)).check(matches(isDisplayed()));
        onView(withId(R.id.registertextid)).check(matches(withText("Create New Account")));
        onView(withId(R.id.namneid)).check(matches(isDisplayed()));
        onView(withId(R.id.emailid)).check(matches(isDisplayed()));
        onView(withId(R.id.passwordid)).check(matches(isDisplayed()));
        onView(withId(R.id.registerbtn)).check(matches(isDisplayed()));


        onView(withId(R.id.namneid)).perform(ViewActions.typeText("Proloy Karmakar"));
        Espresso.onIdle();
        onView(withId(R.id.emailid)).perform(ViewActions.typeText("topu@gmail.com"));
        Espresso.onIdle();
        Espresso.pressBack();
        onView(withId(R.id.passwordid)).perform(ViewActions.replaceText("123456"));
        Espresso.onIdle();
        onView(withId(R.id.registerbtn)).perform(click());
    }
}