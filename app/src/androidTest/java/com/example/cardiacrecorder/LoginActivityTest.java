package com.example.cardiacrecorder;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
//import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
//import static org.junit.Assert.*;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)

public class LoginActivityTest {
@Rule
    public ActivityScenarioRule<LoginActivity> activityActivityScenarioRule = new ActivityScenarioRule<>(LoginActivity.class);
@Test
    public void loginpagetest()
    {
        onView(withId(R.id.loginactivityid)).check(matches(isDisplayed()));
        onView(withId(R.id.logintextid)).check(matches(withText("Please Login")));
        onView(withId(R.id.emailid)).check(matches(isDisplayed()));
        onView(withId(R.id.passwordid)).check(matches(isDisplayed()));
        onView(withId(R.id.loginbtn)).check(matches(isDisplayed()));
        onView(withId(R.id.signupid)).check(matches(withText("or Register")));

        onView(withId(R.id.emailid)).perform(ViewActions.typeText("topu@gmail.com"));
        Espresso.onIdle();
        onView(withId(R.id.passwordid)).perform(ViewActions.replaceText("123456"));
        Espresso.closeSoftKeyboard();
        Espresso.onIdle();
        onView(withId(R.id.loginbtn)).perform(click());
        //onView(withId(R.id.homeactivityid)).check(matches(isDisplayed()));
    }

    private ViewAction typetext(String s) {

    return null;
    }


}