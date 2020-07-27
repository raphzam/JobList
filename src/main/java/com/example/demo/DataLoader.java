package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    JobRepository jobRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public void run(String...strings) throws Exception{

        Author authorOne = new Author();
        authorOne.setName("GDIT");
        authorRepository.save(authorOne);

        Author authorTwo = new Author();
        authorTwo.setName("Smooth Stack");
        authorRepository.save(authorTwo);

        Category sales = new Category();
        sales.setTitle("Sales");
        categoryRepository.save(sales);

        Category generalLabor = new Category();
        generalLabor.setTitle("General Labor");
        categoryRepository.save(generalLabor);

        Category transport = new Category();
        transport.setTitle("Information Technology");
        categoryRepository.save(transport);


    }

}
