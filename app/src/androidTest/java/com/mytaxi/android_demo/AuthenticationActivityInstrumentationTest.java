package com.mytaxi.android_demo;

import android.support.test.espresso.IdlingRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;
import android.support.test.runner.AndroidJUnit4;

import com.mytaxi.android_demo.activities.AuthenticationActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class AuthenticationActivityInstrumentationTest{


    @Rule
    public ActivityTestRule<AuthenticationActivity> authenticationActivityTestRule =
            new ActivityTestRule<>(AuthenticationActivity.class);

    @Rule
    public GrantPermissionRule permissionRule = GrantPermissionRule.grant(android.Manifest.permission.ACCESS_FINE_LOCATION);

    @Before
    public void registerIdleResources(){
        IdlingRegistry.getInstance().register(authenticationActivityTestRule.getActivity().getEspressoIdlingResourceForAuthenticationActivity());

    }

    @After
    public void deregisterIdleResources(){
        IdlingRegistry.getInstance().unregister(authenticationActivityTestRule.getActivity().getEspressoIdlingResourceForAuthenticationActivity());

    }


    /**
     * Test case that evaluates following instructions
     * 1. Enter valid username
     * 2. Enter valid password
     * 3. tap on login button for the user to signIn
     *
     */
    @Test
    public void testEnterValidLoginCredentials() throws InterruptedException {
        // Type text and then press the button.
        onView(withId(R.id.edt_username))
                .perform(typeText(InstrumentationTestsHelper.getResourceString(R.string.valid_name)), closeSoftKeyboard());
        onView(withId(R.id.edt_password))
                .perform(typeText(InstrumentationTestsHelper.getResourceString(R.string.valid_pword)), closeSoftKeyboard());

        onView(withId(R.id.btn_login)).perform(click());

    }

}
