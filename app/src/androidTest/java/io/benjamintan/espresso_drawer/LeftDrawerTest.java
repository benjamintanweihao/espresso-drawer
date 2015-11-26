package io.benjamintan.espresso_drawer;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerActions.open;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LeftDrawerTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void leftDrawerMenuItemsAreDisplayed() {

        onView(withId(R.id.drawer_layout))
                .check(matches(isDisplayed()))
                .perform(open());

        onView(withText("Import"))
                .check(matches(isDisplayed()));

        onView(withText("Settings"))
                .check(matches(isDisplayed()));

        onView(withId(R.id.drawer_layout))
                .perform(swipeUp());

        onView(withText("About"))
                .check(matches(isDisplayed()));
    }
}
