package com.pissouri;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.AliasFor;
import org.springframework.test.context.ActiveProfiles;

import java.lang.annotation.*;

/**
 * Meta annotation for use in tests testing the web layer/API.
 * Not about checking that the service actually works, so the service layer may be mocked.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles({"test", "fast"})
public @interface ApiTest {

    /**
     * The configuration classes to use. Alias for {@link SpringBootTest#classes()}.
     */
    @SuppressWarnings("unused")
    @AliasFor(annotation = SpringBootTest.class, attribute = "classes")
    Class<?>[] config() default {};
}
