package com.chnic.demo.util;

import org.springframework.beans.BeanUtils;

/**
 * @author xxx
 */
public class ModelMapper {

    public static <T, R> R map(T source, Class<R> targetClass) {
        R target;
        try {
            target = targetClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        BeanUtils.copyProperties(source, target);
        return target;
    }

    public static <T, R> R map(T source, Class<R> targetClass, String... ignoreProperties) {
        R target;
        try {
            target = targetClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        BeanUtils.copyProperties(source, target, ignoreProperties);
        return target;
    }
}
