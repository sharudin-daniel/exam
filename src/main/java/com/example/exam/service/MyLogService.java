package com.example.exam.service;

import com.example.exam.mapper.MyLogMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;


@Slf4j
@Service
@RequiredArgsConstructor
public class MyLogService {

    private final MyLogMapper myLogMapper;

    public void insert(String message) {
        log.info(message);
        myLogMapper.insert(message, LocalDate.parse(LocalDate.now()
                .format(DateTimeFormatter.ofPattern( "uuuu-MM-dd" , Locale.UK ))));
    }


}
