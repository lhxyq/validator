package com.lh.validator;

import java.lang.annotation.Annotation;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by LH 2446059046@qq.com on 2017/5/19.
 */
public class PaternValidator implements AnnotationValidator {
    @Override
    public void validate(Annotation annotation, Object value) throws Exception {
        if (annotation instanceof Patern && value instanceof String) {
            String patern = ((Patern) annotation).value();
            if (!matchRegx(patern, (String) value))
                throw new Exception(((Patern) annotation).message());
        }
    }

    private boolean matchRegx(String parttern, String value) {
        Pattern p = Pattern.compile(parttern);
        Matcher m = p.matcher(value);
        return m.matches();
    }
}
