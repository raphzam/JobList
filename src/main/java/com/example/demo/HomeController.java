package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    JobRepository jobRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    AuthorRepository authorRepository;

    @RequestMapping("/")
    public String loadHomePage(Model model){
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("authors", authorRepository.findAll());
        return "home";
    }

//    @GetMapping("/index")
//    public String loadLandingPage(Model model){
//        model.addAttribute("authors", authorRepository.findAll());
//        return "frag";
//    }

//    SORT

    @RequestMapping("/alljobs")
    public String showAllJobs(Model model){
        model.addAttribute("jobs", jobRepository.findAll());
        model.addAttribute("authors", authorRepository.findAll());
        return "alljobs";
    }

    @RequestMapping("/jobsByAuthor/{id}")
    public String showAuthorJobs(@PathVariable("id") long id, Model model){
        model.addAttribute("author", authorRepository.findById(id).get());
        model.addAttribute("authors", authorRepository.findAll());
        return "jobsByAuthor";
    }

//    AUTHOR METHODS

    @GetMapping("/newauthor")
    public String loadAuthorForm(Model model){
        model.addAttribute("author", new Author());
        return "authorform";
    }

    @PostMapping("/processauthor")
    public String processAuthorForm(@ModelAttribute Author author, Model model){
        authorRepository.save(author);
        return "redirect:/";
    }

    @RequestMapping("/updateauthor/{id}")
    public String updateAuthor(@PathVariable("id") long id, Model model){
        model.addAttribute("author", authorRepository.findById(id).get());
        return "authorform";
    }

    @RequestMapping("/deleteauthor/{id}")
    public String deleteAuthor(@PathVariable("id") long id, Model model){
        authorRepository.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping("/profile/{id}")
    public String showAuthorDetail(@PathVariable("id") long id, Model model){
        model.addAttribute("author", authorRepository.findById(id).get());
        model.addAttribute("authors", authorRepository.findAll());
        return "profile";
    }

//    CATEGORY METHODS

    @GetMapping("/newcategory")
    public String loadCategoryForm(Model model){
        model.addAttribute("category", new Category());
        return "categoryform";
    }

    @PostMapping("/processcategory")
    public String processCategoryForm(@ModelAttribute Category category, Model model){
        categoryRepository.save(category);
        return "redirect:/";
    }

    @RequestMapping("/updatecategory/{id}")
    public String updateCategory(@PathVariable("id") long id, Model model){
        model.addAttribute("category", categoryRepository.findById(id).get());
        return "categoryform";
    }

    @RequestMapping("/deletecategory/{id}")
    public String deleteCategory(@PathVariable("id") long id, Model model){
        categoryRepository.deleteById(id);
        return "redirect:/";
    }


//   JOB METHODS

    @GetMapping("/newjob")
    public String loadJobForm(Model model){
        model.addAttribute("job", new Job());
        model.addAttribute("categories",categoryRepository.findAll());
        model.addAttribute("authors", authorRepository.findAll());
        return "jobform";
    }

    @PostMapping("/processjob")
    public String processJobForm(@ModelAttribute Job job, Model model){
        jobRepository.save(job);
        return "redirect:/";
    }

    @RequestMapping("/updatejob/{id}")
    public String updateJob(@PathVariable("id") long id, Model model){
        model.addAttribute("job", jobRepository.findById(id).get());
        model.addAttribute("categories", categoryRepository.findAll());

        model.addAttribute("authors", authorRepository.findAll());
        return "jobform";
    }

    @RequestMapping("/deletejob/{id}")
    public String deleteJob(@PathVariable("id") long id, Model model){
        jobRepository.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping("/detailjob/{id}")
    public String showJobDetail(@PathVariable("id") long id, Model model){
        model.addAttribute("job", jobRepository.findById(id).get());
        model.addAttribute("jobAuthor", jobRepository.findById(id).get().getAuthor());
        model.addAttribute("authors", authorRepository.findAll());
        return "jobdetail";
    }

}
