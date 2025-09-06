package com.aplication.rest.SpringBootRest.configuration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageResult<T> {
    private List<T> content;
    private long totalElements;
    private int totalPages;
}
