package com.lh.validator;


/**
 * Created by LH 2446059046@qq.com on 2017/5/18.
 */
public class Person {
    @NotNull(message = "姓名不能为空")
    private String name;


    @Max(value = 100, message = "年龄不能大于100岁")
    @Min(value = 18, message = "年龄不能小于18岁")
    private float age;

    @NotNull(message = "用户名不能为空")
    @Patern(value = "^\\w{6}", message = "用户名必须由6位的字母，数字和下划线组成")
    private String username;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
