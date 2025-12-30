package com.example.routine.service;

import com.example.routine.dto.DateDto;

import java.util.List;

public interface DateService {
    DateDto.Response createDate(DateDto.Request request);

    List<DateDto.Response> searchDateByAuthor(String author);

    DateDto.Response searchDateById(Long id);

    DateDto.Response updateDate(Long id, DateDto.Request request);

    void deleteDate(Long id, String password);
}
