/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.CA2_API.BookService;

import com.mycompany.CA2_API.model.Book;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Null;



/**
 *
 * @author x14532757
 */
public class BookService {
    
    public static List<Book> list = new ArrayList<>();
    
    public List<Book> GetAllBooks(){
        
        if(list.isEmpty()){
        Book book1 = new Book(1L, "Lean for Life", "Louise Parker", "BeazlyBooks");
        Book book2 = new Book(2L, "The Midnight Gang", "David Walliams", "HarperCollinsChildren’s books");
        Book book3 = new Book(3L, "Born to Run", "Bruce Springsteen", "Simon&Schuster UK");
        Book book4 = new Book(4L, "A life in parts", "Bryan Cranston", "“Orion");
        Book book5 = new Book(5L, "My Name Is Lucy Barton", " Elizabeth Strout", "Viking");
        
        list.add(book1);
        list.add(book2);
        list.add(book3);
        list.add(book4);
        list.add(book5);
        }
        return list;
    }
    
    public Book getBook(int id){
        return list.get(id-1);
    }
    
    public Book deleteBook(int id){
        return list.remove(id-1);
    }

    public Book createBook(Book book){
    list.add(book);
    return book;
    }

    
}
    
    

   
    
    

