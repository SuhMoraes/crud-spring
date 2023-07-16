package com.suhmoraes.crud.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BooksDTO {

    private String id;
    private String name_book;
    private String author;
    private String theme;
    private Integer number_pages;

}
