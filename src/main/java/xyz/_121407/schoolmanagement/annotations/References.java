package xyz._121407.schoolmanagement.annotations;

import xyz._121407.schoolmanagement.entities.Identifiable;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface References {
    Class<? extends Identifiable> table();
    String field();
}
