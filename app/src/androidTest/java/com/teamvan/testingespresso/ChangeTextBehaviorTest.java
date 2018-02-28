package com.teamvan.testingespresso;

import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.espresso.contrib.NavigationViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerMatchers.isOpen;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by allan on 26/02/2018.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ChangeTextBehaviorTest {
    private String mStringToBetyped;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void initValidString() {
        // Specify a valid string.
        mStringToBetyped = "Espresso";
    }
/*
    @Test
    public void changeText_sameActivity() {

        // This works!

        onView(withId(R.id.drawer_layoutDL)).perform(swipeUp());

        // This doesn't.
//        onView(withId(R.id.drawer_layoutDL))
//                .perform( actionOnItemAtPosition(5, click()));

        onView(allOf(
                withText(R.string.scan),
                hasSibling(withText(R.string.report_lost_asset)),
                isDisplayed()))
                .perform(scrollTo(), click());


//        onData(instanceOf(NavigationMenuItemView.class))
//                .inAdapterView(anything(View.class))
//                .atPosition(6)
//                .check(matches(isDisplayed()));


        onData(is(instanceOf(NavigationMenuItemView.class)))
                .inAdapterView(withId(R.id.navigation_viewNV))
                .atPosition(2)
                .check(matches(isDisplayed()))
                .perform(click());

//        Espresso.onView(Matchers.allOf(
//                ViewMatchers.withId(R.id.drawerItemNameTextView),
//                ViewMatchers.hasSibling(ViewMatchers.withText(((NavDrawerItem)item).getItemName())))).perform(ViewActions.click());

        // Type text and then press the button.
//        onView(withId(R.id.editTextUserInput))
//                .perform(typeText(mStringToBetyped), closeSoftKeyboard());
//        onView(withId(R.id.changeTextBt)).perform(click());
//
//        // Check that the text was changed.
//        onView(withId(R.id.textToBeChanged))
//                .check(matches(withText(mStringToBetyped)));
    }*/

    @Test
    public void testDrawerOpens() throws Exception {
        onView(withId(R.id.drawer_layoutDL)).perform(DrawerActions.open());
        onView(withId(R.id.drawer_layoutDL)).check(matches(isOpen()));
        onView(withId(R.id.navigation_viewNV)).perform(NavigationViewActions.navigateTo(R.id.mn_scan));
    }

    @Test
    public void testNavigationViewItemAvailable() throws Exception {
        onView(withId(R.id.drawer_layoutDL)).perform(DrawerActions.open());
        onView(withId(R.id.navigation_viewNV)).perform(NavigationViewActions.navigateTo(R.id.mn_scan));
    }
}
