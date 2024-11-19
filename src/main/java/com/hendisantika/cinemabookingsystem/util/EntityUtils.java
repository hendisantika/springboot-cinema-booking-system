package com.hendisantika.cinemabookingsystem.util;

import com.hendisantika.cinemabookingsystem.model.BaseEntity;
import jakarta.persistence.EntityNotFoundException;
import lombok.experimental.UtilityClass;

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

    public static <T extends BaseEntity> T safeGetEntity(T object) {
        return safeGetEntity(object, "Entity not found");
    }

    public static <T extends BaseEntity> List<T> safeGetEntityCollection(List<T> entityCollection) {
        return safeGetEntityCollection(entityCollection, "Entities collection is empty");
    }

    public static <T extends BaseEntity> T getDummyEntityById(Long id, Class<T> entityClass) {
        T entity;

        try {
            entity = entityClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e.getMessage());
        }

        entity.setId(id);
        return entity;
    }
}
