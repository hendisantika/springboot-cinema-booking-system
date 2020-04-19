package com.hendisantika.cinemabookingsystem.util;

import lombok.experimental.UtilityClass;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * Created by IntelliJ IDEA.
 * Project : cinema-booking-system
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/04/20
 * Time: 06.31
 */
@UtilityClass
public class CommonUtils {

    public <T> T safeGet(T object, Supplier<? extends RuntimeException> exceptionSupplier) {
        return Optional.ofNullable(object).orElseThrow(exceptionSupplier);
    }
}
