package com.spring.di;

/**
 * @author restyhap
 * @date 2019年03月02日 00:54
 * <pre>
 *
 * </pre>
 */
public class IBookServiceImpl implements IBookService {
    private IBook ibook;

    public void setIbook(IBook ibook) {
        this.ibook = ibook;
    }

    public void addBook(){
        this.ibook.add();
    }
}
