package com.example.bookapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class BookDTO {

    private Integer id;

    @NotBlank(message = "Title cannot be blank")
    @Size(min = 3, max = 50, message = "Title must be between 3 and 50 characters")
    private String title;

    @NotBlank(message = "Author cannot be blank")
    @Size(min = 3, max = 40, message = "Author must be between 3 and 40 characters")
    private String author;

    @NotNull(message = "Price cannot be null")
    @Positive(message = "Price must be greater than 0")
    private Double price;  // ✅ double → Double

    public BookDTO() {}

    public BookDTO(Integer id, String title, String author, Double price) {  // ✅
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {  // ✅
        return price;
    }

    public void setPrice(Double price) {  // ✅
        this.price = price;
    }
}

//
//import jakarta.validation.constraints.Negative;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Positive;
//import jakarta.validation.constraints.Size;
//
//public class BookDTO {
//
//
//    private Integer id;
//    @NotNull(message = "Title cannot be blank")
//    @Size(min=3,max=30,message="Title should be between 3 and 30 words")
//    private  String title;
//
//    @NotNull(message="Author cannot be blank")
//    @Size(min=3,max=40,message = "Author should be between 3 and 40 characters")
//    private String author;
//
//    @NotNull(message = "Price cannot be blank")
//    @Positive(message = "Price cannot be less then 0")
//    private Double price;
//
//    public BookDTO(Integer id,String title,String author,Double price) {
//        this.id=id;
//        this.title=title;
//        this.author=author;
//        this.price=price;
//
//    }
//    public BookDTO() {
//
//    }
//
//}
//














































