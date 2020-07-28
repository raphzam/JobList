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
    public void run(String... strings) throws Exception {

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

        Category infoTech = new Category();
        infoTech.setTitle("Information Technology");
        categoryRepository.save(infoTech);

        Job jobOne = new Job();
        jobOne.setName("Help Desk");
        jobOne.setPhone("202-555-1122");
        jobOne.setPostedDate("12/12/19");
        jobOne.setAuthor(authorOne);
        jobOne.setDescription("GDIT is seeking a Desktop Support Specialist with " +
                "Mac and Windows expertise to provide a " +
                "variety of hands on technical support and exceptional customer " +
                "service.");
        jobOne.addCategory(infoTech);
        jobRepository.save(jobOne);

        Job jobTwo = new Job();
        jobTwo.setName("Full Stack Developer");
        jobTwo.setPhone("202-555-1122");
        jobTwo.setPostedDate("12/15/19");
        jobTwo.setAuthor(authorOne);
        jobTwo.setDescription("As a full stack developer supporting the customer, " +
                "you will be trusted to solve complex IT " +
                "issues and provide exceptional customer service");
        jobTwo.addCategory(infoTech);
        jobRepository.save(jobTwo);

        Job jobThree = new Job();
        jobThree.setName("Salesforce Trainer");
        jobThree.setPhone("443-555-1122");
        jobThree.setPostedDate("12/22/19");
        jobThree.setAuthor(authorTwo);
        jobThree.setDescription("We are looking for an experienced Salesforce professional to join our team. " +
                "Our passionate trainers create a collaborative and innovative on-the-job learning " +
                "environment for our apprentices.");
        jobThree.addCategory(sales);
        jobRepository.save(jobThree);

        Job jobFour = new Job();
        jobFour.setName("Entry Level - Software Developer");
        jobFour.setPhone("443-555-1122");
        jobFour.setPostedDate("12/29/19");
        jobFour.setAuthor(authorTwo);
        jobFour.setDescription("We are looking for developers who want to engage in challenging " +
                "projects in futuristic technology, software development, and much more within a " +
                "variety of sectors such as financial, health care, energy and federal.");
        jobFour.addCategory(infoTech);
        jobRepository.save(jobFour);


    }

}
