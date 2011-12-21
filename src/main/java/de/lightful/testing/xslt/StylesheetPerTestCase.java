package de.lightful.testing.xslt;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, METHOD})
public @interface StylesheetPerTestCase {

  String xsltSnippet() default "";

  ImportStylesheet[] imports() default {};
}
