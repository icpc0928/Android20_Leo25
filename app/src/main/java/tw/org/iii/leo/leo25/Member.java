package tw.org.iii.leo.leo25;

import java.util.LinkedList;

public class Member {

    private LinkedList<String> names;
    private String name;
    private int age;


    Member(){
        names = new LinkedList<String>();
        age = 0;

    }

    public void addName(String name){
        names.add(name);
    }

    public LinkedList<String> getNames(){
        return names;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }
}
