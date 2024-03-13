package com.example.restexample.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record AuthorDto(
        @NotNull(message = "Id cannot be null")
        Long id,
        @NotNull(message = "Firstname cannot be null")
        @NotEmpty(message = "Firstname cannot be empty")
        String firstName,
        @NotNull(message = "Firstname cannot be null")
        @NotEmpty(message = "Firstname cannot be empty")
        String lastName
) {
}
