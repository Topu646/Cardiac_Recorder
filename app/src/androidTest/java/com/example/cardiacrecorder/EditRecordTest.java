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
public class EditRecordTest {
    @Rule
    public ActivityScenarioRule<EditRecord> activityScenarioRule = new ActivityScenarioRule<>(EditRecord.class);

    @Test
    public void editrecordactivitytest()
    {
        onView(withId(R.id.editrecordactivityid)).check(matches(isDisplayed()));
        onView(withId(R.id.titleid)).check(matches(isDisplayed()));
        onView(withId(R.id.descid)).check(matches(isDisplayed()));
        onView(withId(R.id.systolicpressureid)).check(matches(isDisplayed()));
        onView(withId(R.id.diastolicpressureid)).check(matches(isDisplayed()));
        onView(withId(R.id.heartrateid)).check(matches(isDisplayed()));
        onView(withId(R.id.commentid)).check(matches(isDisplayed()));
        onView(withId(R.id.uploadid)).check(matches(isDisplayed()));

        onView(withId(R.id.titleid)).perform(ViewActions.typeText("05-05-2022"));
        onView(withId(R.id.descid)).perform(ViewActions.typeText("11:00 am"));

        Espresso.pressBack();
        onView(withId(R.id.systolicpressureid)).perform(ViewActions.typeText("75 mmHg"));
        Espresso.pressBack();
        onView(withId(R.id.diastolicpressureid)).perform(ViewActions.typeText("110 mmHg"));
        Espresso.pressBack();
        onView(withId(R.id.heartrateid)).perform(ViewActions.typeText("72 bpm"));
        Espresso.pressBack();
        onView(withId(R.id.commentid)).perform(ViewActions.typeText("OK"));
        Espresso.pressBack();
        onView(withId(R.id.uploadid)).perform(click());
    }
}