package com.example.cardiacrecorder;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class Add_dataTest {

    @Rule
    public ActivityScenarioRule<Add_data> activityScenarioRule = new ActivityScenarioRule<>(Add_data.class);

    @Test
    public void adddataactivitytest()
    {
        onView(withId(R.id.adddataactivityid)).check(matches(isDisplayed()));
        onView(withId(R.id.adddataid)).check(matches(withText("Add new record")));
        onView(withId(R.id.titleid)).check(matches(isDisplayed()));
        onView(withId(R.id.descid)).check(matches(isDisplayed()));
        onView(withId(R.id.systolicpressureid)).check(matches(isDisplayed()));
        onView(withId(R.id.diastolicpressureid)).check(matches(isDisplayed()));
        onView(withId(R.id.heartrateid)).check(matches(isDisplayed()));
        onView(withId(R.id.commentid)).check(matches(isDisplayed()));
        onView(withId(R.id.uploadid)).check(matches(isDisplayed()));


        onView(withId(R.id.titleid)).perform(ViewActions.typeText("27-06-2023"));
        onView(withId(R.id.descid)).perform(ViewActions.typeText("5:15 pm"));
        Espresso.pressBack();
        onView(withId(R.id.systolicpressureid)).perform(ViewActions.typeText("80 mmHg"));
        Espresso.pressBack();
        onView(withId(R.id.diastolicpressureid)).perform(ViewActions.typeText("120 mmHg"));
        Espresso.pressBack();
        onView(withId(R.id.heartrateid)).perform(ViewActions.typeText("72 bpm"));
        Espresso.pressBack();
        onView(withId(R.id.commentid)).perform(ViewActions.typeText("You are absolutely ok."));
        Espresso.pressBack();
        onView(withId(R.id.uploadid)).perform(click());
    }
}