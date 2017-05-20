package com.lh.validator;

import java.lang.annotation.Annotation;

/**
 * Created by LH 2446059046@qq.com on 2017/5/19.
 */
public class MaxValidator implements AnnotationValidator {
    @Override
    public void validate(Annotation annotation, Object value) throws Exception {
        if (annotation instanceof Max && value instanceof Number) {
            double max = ((Max) annotation).value();
            double tem = 0;
            switch (value.getClass().getTypeName()) {
                case "java.lang.Integer":
                    tem = (double) ((int) value);
                    break;
                case "java.lang.Float":
                    tem = (double) ((float) value);
                    break;
                case "java.lang.Double":
                    tem = (double) value;
                    break;
                default:
                    throw new ClassNotFoundException("最大值注解暂不支持这种类型的值");
            }

            if (tem > max)
                throw new Exception(((Max) annotation).message());

        }
    }
}
