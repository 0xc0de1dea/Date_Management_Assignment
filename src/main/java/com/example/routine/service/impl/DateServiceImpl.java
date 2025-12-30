package com.example.routine.service.impl;

import com.example.routine.dto.DateDto;
import com.example.routine.entity.Date;
import com.example.routine.exception.CustomException;
import com.example.routine.repository.DateRepository;
import com.example.routine.service.DateService;
import com.example.routine.type.ErrorCode;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DateServiceImpl implements DateService {
    private final DateRepository dateRepository;

    @Override
    @Transactional
    public DateDto.Response createDate(DateDto.Request request) {
        Date date = request.toEntity();
        date.setModifiedAt(LocalDateTime.now());
        dateRepository.save(date);

        return DateDto.Response.fromEntity(date);
    }

    @Override
    @Transactional
    public List<DateDto.Response> searchDateByAuthor(String author) {
        List<Date> dateList = dateRepository.findAllByAuthor(author);

        if (dateList.isEmpty()) {
            throw new CustomException(ErrorCode.NOT_FOUND_AUTHOR);
        }

        List<DateDto.Response> respList = new ArrayList<>();

        for (Date date : dateList) {
            respList.add(DateDto.Response.fromEntity(date));
        }

        respList.sort(new Comparator<DateDto.Response>() {
            @Override
            public int compare(DateDto.Response o1, DateDto.Response o2) {
                return o2.getModifiedAt().compareTo(o1.getModifiedAt());
            }
        });

        return respList;
    }

    @Override
    @Transactional
    public DateDto.Response searchDateById(Long id) {
        Date date = dateRepository.findById(id).orElseThrow(() ->
                new CustomException(ErrorCode.NOT_FOUND_ID));

        return DateDto.Response.fromEntity(date);
    }

    @Override
    @Transactional
    public DateDto.Response updateDate(Long id, DateDto.Request request) {
        Date date = dateRepository.findById(id).orElseThrow(() ->
                new CustomException(ErrorCode.NOT_FOUND_ID));

        if (!date.getPassword().equals(request.getPassword())) {
            throw new CustomException(ErrorCode.UN_MATCH_CONFIRM_PASSWORD);
        }

        date.setAuthor(request.getAuthor());
        date.setName(request.getName());
        date.setContent(request.getContent());

        return DateDto.Response.fromEntity(dateRepository.save(date));
    }

    @Override
    @Transactional
    public void deleteDate(Long id, String password) {
        Date date = dateRepository.findById(id).orElseThrow(() ->
                new CustomException(ErrorCode.NOT_FOUND_ID));

        if (!date.getPassword().equals(password)) {
            throw new CustomException(ErrorCode.UN_MATCH_CONFIRM_PASSWORD);
        }

        dateRepository.delete(date);
    }
}
