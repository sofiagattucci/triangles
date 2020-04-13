package it.unimi.di.vec.extensions;

import org.junit.jupiter.api.extension.ExtendWith;

import static java.lang.annotation.ElementType.*;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({TYPE, METHOD, ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(SystemOutputExtension.class)
public @interface SystemOutLog {
}
