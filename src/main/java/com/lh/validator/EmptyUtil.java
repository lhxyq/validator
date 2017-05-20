package com.lh.validator;

import java.util.List;

/**
 * Created by LH 2446059046@qq.com on 2017/5/18.
 */
public class EmptyUtil {
    public static final <T> boolean isEmpty(T t) {
        boolean flag = false;

        if (null == t)
            flag = true;

        if (null != t && t instanceof String) {
            if (0 == ((String) t).length())
                flag = true;
        }

        if (null != t && t instanceof List) {
            if (0 == ((List) t).size())
                flag = true;
        }

        return flag;
    }
}
