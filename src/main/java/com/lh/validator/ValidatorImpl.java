package com.lh.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by LH 2446059046@qq.com on 2017/5/18.
 */
public class ValidatorImpl implements Validator {
    @Override
    public <T> void validate(T t, Class<? extends T> tClass) throws Exception {
        Field[] fields = tClass.getDeclaredFields();

        if (!EmptyUtil.isEmpty(fields)) {
            String messages = "";
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(t);
                try {
                    this.validate(field, value);
                } catch (Exception e) {
                    if (EmptyUtil.isEmpty(messages))
                        messages += e.getMessage();
                    else
                        messages += "\n" + e.getMessage();
                }

            }
            if (!EmptyUtil.isEmpty(messages))
                throw new Exception(messages);
        }

    }

    private void validate(Field field, Object value) throws Exception {
        Annotation[] annotations = field.getAnnotations();
        if (!EmptyUtil.isEmpty(annotations)) {
            AnnotationValidator annotationValidator;
            String messages = "";
            for (Annotation annotation : annotations) {
                try {
                    //非空判断
                    if (annotation instanceof NotNull) {
                        annotationValidator = new NotNullValidator();
                        annotationValidator.validate(annotation, value);
                    }

                    //最大值判断
                    if (annotation instanceof Max) {
                        annotationValidator = new MaxValidator();
                        annotationValidator.validate(annotation, value);
                    }

                    //最小值判断
                    if (annotation instanceof Min) {
                        annotationValidator = new MinValidator();
                        annotationValidator.validate(annotation, value);
                    }

                    //正则判断
                    if (annotation instanceof Patern) {
                        annotationValidator = new PaternValidator();
                        annotationValidator.validate(annotation, value);
                    }
                } catch (Exception e) {
                    if (EmptyUtil.isEmpty(messages))
                        messages += e.getMessage();
                    else
                        messages += "\n" + e.getMessage();
                }

                if (!EmptyUtil.isEmpty(messages))
                    throw new Exception(messages);
            }
        }
    }
}
