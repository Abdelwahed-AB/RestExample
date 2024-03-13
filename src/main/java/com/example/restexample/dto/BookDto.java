package com.example.restexample.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record BookDto(
        Long id,
        @NotNull(message = "Book must have a title")
        @Size(min = 1, max = 200, message = "Book title length must be between 1 and 200")
        String title,
        @NotNull(message = "Book must have a description")
        @NotEmpty(message = "Book description must not be empty")
        String description,
        @NotNull(message = "Book must have a publishing date")
        LocalDate publishDate,

        @NotNull(message = "Book must have an author")
        Long authorId
) {
}
