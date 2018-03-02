package com.apress.bgn.ch3;

import com.apress.bgn.ch0.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

/**
 * Created by iuliana.cosmina on 2/26/18
 */
public class Main {
    //testing to classes in transitive module slf4j.org
    private static Logger LOGGER = LoggerFactory.getLogger(Base.class);

    public static void main(String... args) {
        //testing access to Base class from module chapter.zero
        Base base = new Base();
        LOGGER.info("Base object was created? >  {} ", (base != null));

        //testing reflection
        try {
            Field field = base.getClass().getDeclaredField("secret");
            field.setAccessible(true);
            field.set(base, 1);
            base.printSecret();
        } catch (NoSuchFieldException nsf) {
            LOGGER.error("Field 'secret' cannot be accessed!" );
        } catch (IllegalAccessException e) {
            LOGGER.error("Field 'secret' cannot be set!" );
        }
    }
}