package com.lh.validator;

import java.lang.annotation.Annotation;

/**
 * Created by LH 2446059046@qq.com on 2017/5/19.
 */
public class NotNullValidator implements AnnotationValidator {
    @Override
    public void validate(Annotation annotation, Object value) throws Exception {
        if (annotation instanceof NotNull) {
            if (EmptyUtil.isEmpty(value))
                throw new Exception(((NotNull) annotation).message());
        }
    }
}
