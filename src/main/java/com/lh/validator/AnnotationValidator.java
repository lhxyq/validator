package com.lh.validator;

import java.lang.annotation.Annotation;

/**
 * Created by LH 2446059046@qq.com on 2017/5/19.
 */
public interface AnnotationValidator {
    void validate(Annotation annotation, Object value) throws Exception;
}
