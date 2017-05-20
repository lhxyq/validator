package com.lh.validator;

/**
 * Created by LH 2446059046@qq.com on 2017/5/18.
 */
public class Demo {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("刘辉");
        person.setUsername("LH1234");
        person.setAge(18);

        Validator validator = new ValidatorImpl();
        try {
            validator.validate(person, person.getClass());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
