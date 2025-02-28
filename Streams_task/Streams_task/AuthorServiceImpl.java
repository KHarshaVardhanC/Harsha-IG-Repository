package com.Java.Collections.streams;


import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AuthorServiceImpl implements AuthorService {

    
    @Override
    public Set<String> getUniqueSurnames(List<Author> authorList) {
        return authorList.stream()
                .map(author -> author.getSurname().toUpperCase()) 
                .collect(Collectors.toSet()); 
    }

    @Override
    public List<Author> getAuthorsByCity(List<Author> authorList, String city) {
        return authorList.stream()
                .filter(author -> author.getCity().equalsIgnoreCase(city)) 
                .collect(Collectors.toList()); 
    }

    @Override
    public double femaleAverageAge(List<Author> authorList) {
        LocalDate today = LocalDate.now();
        return authorList.stream()
                .filter(author -> "female".equalsIgnoreCase(author.getGender())) 
                .mapToInt(author -> Period.between(author.getBirthdate(), today).getYears()) 
                .average() 
                .orElse(0.0); 
    }
    
    @Override
    public Long getMobileByAdhar(List<Author> authorList, Long adharCard) {
        return authorList.stream()
                .filter(author -> author.getAdharCard().equals(adharCard)) 
                .map(Author::getMobile) 
                .findFirst() 
                .orElse(null); 
    }
}
