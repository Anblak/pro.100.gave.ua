package ua.com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ua.com.library.entity.Book;
import ua.com.library.service.BookService;

@RestController
@RequestMapping("/")
public class BookController {

	@Autowired
	private BookService bookService;
	
//	@RequestMapping(value = "/newBook", method = RequestMethod.GET)
//	public String newBook(Model model) {
//		
//		List<Book> booksFromDB = bookService.findAll();
//		
//		model.addAttribute("books", booksFromDB);
//		model.addAttribute("book", new Book());
//		
//		return "newBook";
//	}
	
	@RequestMapping(value = "/saveBook", method = RequestMethod.POST)
	public void saveBook(@RequestBody Book book) {
		
		
			
		
		bookService.save(book);

		
		
	}	
	
//	@RequestMapping(value = "/deleteBook/{id}", method = RequestMethod.GET)
//	public String newBook(@PathVariable int id) {
//		
//		bookService.delete(id);
//		
//		return "redirect:/newBook";
//	}
//	
	
	
	
	
}