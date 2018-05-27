package com.mytaxi.android_demo;

import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;
import android.support.test.runner.AndroidJUnit4;

import com.mytaxi.android_demo.activities.MainActivity;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentationTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);
    @Rule
    public GrantPermissionRule permissionRule = GrantPermissionRule.grant(android.Manifest.permission.ACCESS_FINE_LOCATION);

    @Before
    public void registerIdleResources(){
        IdlingRegistry.getInstance().register(mainActivityTestRule.getActivity().getEspressoIdlingResourceForMainActivity());

    }

    @After
    public void deregisterIdleResources(){
        IdlingRegistry.getInstance().unregister(mainActivityTestRule.getActivity().getEspressoIdlingResourceForMainActivity());
    }

    /**
     * Test case that evaluates following instructions
     * 1. search for a driver matching his name containing specific characters.
     * 2. select a specific driver from the search results
     * 3. tap on the call button of searched driver to make a call
     *
     */
    @Test
    public void testSearchDriverAndCall() {

        onView(withId(R.id.textSearch)).check(matches(isDisplayed()));
        onView(withId(R.id.textSearch)).perform(typeText(InstrumentationTestsHelper.getResourceString(R.string.search_text)));
        onData(InstrumentationTestsHelper.getDriverWithName(Matchers.containsString(InstrumentationTestsHelper.getResourceString(R.string.selected_driver_name))))
                .inRoot(RootMatchers.isPlatformPopup())
                .perform(click());
        onView(withId(R.id.fab)).perform(click());

    }
}
