package com.pissouri;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.comparator.CustomComparator;
import org.skyscreamer.jsonassert.comparator.JSONComparator;

/**
 * A Hamcrest matcher for JSON content, using {@link JSONAssert}
 */
public final class JsonMatcher extends BaseMatcher<String> {

    private String expected;
    private JSONComparator comparator; // could be passed as a parameter, if needed

    public JsonMatcher(String expected) {

        this.expected = expected;
        this.comparator = new CustomComparator(JSONCompareMode.STRICT);
    }

    @Override
    public boolean matches(Object item) {

        if (item instanceof String) {
            try {
                String actual = (String) item;
                JSONAssert.assertEquals(expected, actual, comparator);

            } catch (JSONException e) {
                throw new AssertionError(e);
            }

            return true;
        }

        return false;
    }

    @Override
    public void describeTo(Description description) {

        description.appendText(expected);
    }

    public static JsonMatcher equalToJson(String expected) {

        return new JsonMatcher(expected);
    }
}
