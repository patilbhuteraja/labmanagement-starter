package com.demo.labmanagement.labmanagement.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.labmanagement.labmanagement.models.Author;
import com.demo.labmanagement.labmanagement.models.Category;
import com.demo.labmanagement.labmanagement.models.Lab;
import com.demo.labmanagement.labmanagement.models.LabDto;
import com.demo.labmanagement.labmanagement.repositories.AuthorRepository;
import com.demo.labmanagement.labmanagement.repositories.CategoryRepository;
import com.demo.labmanagement.labmanagement.repositories.LabRepository;

@RestController
@RequestMapping("/")
public class LabController {

    private final LabRepository labRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

    public LabController(LabRepository labRepository,
            AuthorRepository authorRepository,
            CategoryRepository categoryRepository) {
        this.labRepository = labRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
    }

    @PostMapping("/lab")
    @ResponseStatus(HttpStatus.CREATED)
    public Lab CreateLab(@RequestBody Lab lab) {
        LabDto labDto = labRepository.save(
                new LabDto(lab.getName(), lab.getDescription(), lab.getCategory().getId(), lab.getAuthor().getId()));
        return constructLab(labDto);
    }

    @GetMapping("/lab")
    public Iterable<Lab> getLabs() {
        ArrayList<Lab> labs = new ArrayList<>();
        Iterable<LabDto> labDtos = labRepository.findAll();
        for (LabDto labDto : labDtos) {
            labs.add(constructLab(labDto));
        }
        return labs;
    }

    @GetMapping("/lab/{id}")
    public Lab getLab(@PathVariable("id") Long id) {
        Optional<LabDto> labDto = labRepository.findById(id);
        return labDto.isPresent() ? constructLab(labDto.get()) : null;
    }

    @DeleteMapping("/lab/{id}")
    public void deleteLab(@PathVariable("id") Long id) {
        labRepository.deleteById(id);
    }

    @PutMapping("/lab/{id}")
    public Lab updateLab(@RequestBody Lab lab, @PathVariable("id") Long id) {
        if (!lab.getId().equals(id)) {
            throw new IllegalArgumentException("Lab Id mismatch!");
        }
        LabDto labDto = new LabDto(lab.getName(), lab.getDescription(), lab.getCategory().getId(),
                lab.getAuthor().getId());
        labDto.setId(id);
        labDto = labRepository.save(labDto);
        return constructLab(labDto);
    }

    private Lab constructLab(LabDto labDto) {
        Optional<Author> author = authorRepository.findById(labDto.getAuthorId());
        Optional<Category> category = categoryRepository.findById(labDto.getCategoryId());
        return new Lab(labDto.getId(), labDto.getName(), labDto.getDescription(),
                author.isPresent() ? author.get() : null,
                category.isPresent() ? category.get() : null);
    }
}
