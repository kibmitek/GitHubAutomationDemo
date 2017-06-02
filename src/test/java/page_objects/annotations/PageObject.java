/*
 */
package page_objects.annotations;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Classes marked this annotation will be initialized
 * with WebDriver as page objects
 */
@Target(TYPE)
@Retention(RUNTIME)
@Component @Lazy
public @interface PageObject {
}
