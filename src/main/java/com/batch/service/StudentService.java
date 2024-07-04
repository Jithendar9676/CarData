package com.batch.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.batch.entiry.Student;
import com.batch.repository.StudentRepository;
import com.batch.dto.StudentDto;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Integer upload(MultipartFile file) {
        Set<Student> setStudents = parseCsv(file);
        studentRepository.saveAll(setStudents);
        return setStudents.size();
    }

    public Set<Student> parseCsv(MultipartFile file) {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            HeaderColumnNameMappingStrategy<StudentDto> strategy = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(StudentDto.class);
            
            CsvToBean<StudentDto> csvToBean = new CsvToBeanBuilder<StudentDto>(reader)
                    .withMappingStrategy(strategy)
                    .withIgnoreEmptyLine(true)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            

            
            return csvToBean.parse().stream()
                    .map(csvLine ->  Student.builder()
                            .firstname(csvLine.getFname())
                            .lastname(csvLine.getLname())
                            .age(csvLine.getAge())
                            .build()
                    )
                    .collect(Collectors.toSet());
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to parse CSV file: " + e.getMessage());
        }
    }
}
