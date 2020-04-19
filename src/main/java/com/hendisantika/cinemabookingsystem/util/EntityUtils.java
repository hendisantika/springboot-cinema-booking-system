package com.hendisantika.cinemabookingsystem.util;

import com.hendisantika.cinemabookingsystem.model.BaseEntity;
import lombok.experimental.UtilityClass;

import javax.persistence.EntityNotFoundException;
import java.util.List;

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
public class EntityUtils {
    public static <T extends BaseEntity> T safeGetEntity(T object, String msg) {
        return CommonUtils.safeGet(object, () -> new EntityNotFoundException(msg));
    }

    public static <T extends BaseEntity> List<T> safeGetEntityCollection(List<T> entityCollection, String msg) {
        return CommonUtils.safeGet(entityCollection, () -> new EntityNotFoundException(msg));
    }
}
