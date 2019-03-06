package com.spring.bean;

/**
 * @author restyhap
 * @date 2019年03月02日 00:00
 * <pre>
 *
 * </pre>
 */
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void say(){
        System.out.println("User===say()");

    }
}
