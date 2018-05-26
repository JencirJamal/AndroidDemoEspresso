package com.mytaxi.android_demo;

import android.support.annotation.NonNull;

import com.mytaxi.android_demo.models.Driver;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public final class TestsHelper {

    /**
     * Returns a matcher that matches {@link Driver}s based on name property value.
     *
     * @param stringMatcher {@link Matcher} of {@link String} with text to match
     */
    @NonNull
    public static Matcher getDriverWithName(final Matcher<String> stringMatcher) {

        return new TypeSafeMatcher<Driver>() {

            @Override
            public void describeTo(final Description description) {
                description.appendText("with driver name: ");
                stringMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(final Driver driver) {
                return stringMatcher.matches(driver.getName());
            }
        };
    }
}
