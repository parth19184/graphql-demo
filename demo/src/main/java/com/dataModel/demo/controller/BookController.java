package com.dataModel.demo.controller;

import com.dataModel.demo.model.Author;
import com.dataModel.demo.model.Book;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {
    @QueryMapping
    public Book bookById(@Argument String id) {
        return Book.getById(id);
    }

    @QueryMapping
    public List<Book> booksByIds(@Argument List<String> ids){
        return Book.getByIds(ids);
    }


    @SchemaMapping
    public Author author(Book book) {
        return Author.getById(book.authorId());
    }
}