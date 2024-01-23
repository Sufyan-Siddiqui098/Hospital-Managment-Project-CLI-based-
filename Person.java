abstract public class Person {
    String name, sex, id;
    int age;

    abstract void showInfo();

    
    Person (String name, String sex, String id,int age){
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    Person() {
        name = null;
        id = null;
    }
    
}
