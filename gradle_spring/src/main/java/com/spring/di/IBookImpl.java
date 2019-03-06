package com.spring.di;

/**
 * @author restyhap
 * @date 2019年03月02日 00:52
 * <pre>
 *
 * </pre>
 */
public class IBookImpl implements IBook {
    @Override
    public void add(){
        System.out.println("IBook === IBookImpl --->addBook()");
    }
}
