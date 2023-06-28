package com.example.cardiacrecorder;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class edit_deleteTest {

    @Rule
    public ActivityScenarioRule<edit_delete> activityScenarioRule = new ActivityScenarioRule<>(edit_delete.class);

    @Test
    public void editdeleteactivitytest(){
        onView(withId(R.id.editdeleteactivityid)).check(matches(isDisplayed()));
        onView(withId(R.id.datetextView)).check(matches(isDisplayed()));
        onView(withId(R.id.timetextView)).check(matches(isDisplayed()));
        onView(withId(R.id.systolictextview)).check(matches(isDisplayed()));
        onView(withId(R.id.diastolicpressuretextview)).check(matches(isDisplayed()));
        onView(withId(R.id.heartratetextview)).check(matches(isDisplayed()));
        onView(withId(R.id.commenttextview)).check(matches(isDisplayed()));
        onView(withId(R.id.editbutton)).check(matches(isDisplayed()));
        onView(withId(R.id.deletebutton)).check(matches(isDisplayed()));


        onView(withId(R.id.editbutton)).perform(click());
        onView(withId(R.id.editrecordactivityid)).check(matches(isDisplayed()));
        Espresso.pressBack();

        onView(withId(R.id.deletebutton)).perform(click());
        onView(withId(R.id.homeactivityid)).check(matches(isDisplayed()));
    }
}