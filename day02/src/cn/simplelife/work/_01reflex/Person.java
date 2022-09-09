package cn.simplelife.work._01reflex;

/**
 * @ClassName Person
 * @Description
 * @Author simplelife
 * @Date 2022/9/9 11:03
 * @Version 1.0
 */

public class Person {
    private String name;
    private int age;

    private Person(String name) {
        this.name = name;
    }

    private Person(int age) {
        this.age = age;
    }

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
