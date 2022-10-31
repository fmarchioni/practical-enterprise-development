 

package com.itbuzzpress.cdi.qualifier;

import com.itbuzzpress.cdi.enums.Language;
import jakarta.inject.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Qualifier
@Retention(RUNTIME)
@Target({ FIELD, TYPE, METHOD })

public @interface Anagram {
	Language value();

}