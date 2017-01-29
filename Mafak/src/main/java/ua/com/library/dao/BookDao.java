package ua.com.library.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.library.entity.Book;

public interface BookDao extends JpaRepository<Book, Integer> {

}