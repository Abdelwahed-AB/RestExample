package com.example.restexample.dto;

import java.time.LocalDate;

public record BookDto(
        Long id,
        String title,
        String description,
        LocalDate publishDate,
        Long authorId
) {}
