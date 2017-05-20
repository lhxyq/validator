package com.lh.validator;

/**
 * Created by LH 2446059046@qq.com on 2017/5/18.
 */
public interface Validator {
    <T> void validate(T t, Class<? extends T> tClass) throws Exception;
}
