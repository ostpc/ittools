package ua.org.ostpc.ittools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.org.ostpc.ittools.dao.FormRepository;
import ua.org.ostpc.ittools.entity.Book;
import ua.org.ostpc.ittools.entity.Form;

import java.util.List;

@RestController
@RequestMapping("/api/form")
public class FormAPIController {

    @Autowired
    private FormRepository formRepository;

    @GetMapping
    public Iterable findAll() {
        return formRepository.findAll();
    }

    @GetMapping("/find/{name}")
    public List findByName(@PathVariable String name) {
        return formRepository.findByName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Form create(@RequestBody Form form) {
        return formRepository.save(form);
    }

    @GetMapping("/{id}")
    public Form findOne(@PathVariable Long id) throws Exception {
        return formRepository.findById(id)
                .orElseThrow(Exception::new);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws Exception {
        formRepository.findById(id)
                .orElseThrow(Exception::new);
        formRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Form updateForm(@RequestBody Form form, @PathVariable Long id) throws Exception {
        if (form.getId() != id) {
            throw new Exception();
        }
        formRepository.findById(id)
                .orElseThrow(Exception::new);
        return formRepository.save(form);
    }

    @GetMapping("/create/{name}/{mobilePhone}/{email}/{level}/{resumePath}/{speciality}")
    @ResponseStatus(HttpStatus.CREATED)
    public Form createDefault(@PathVariable String name, @PathVariable String mobilePhone, @PathVariable String email, @PathVariable String resumePath, @PathVariable String speciality, @PathVariable int level){

        Form form=new Form();
        form.setName(name);
        form.setEmail(email);
        form.setMobilePhone(mobilePhone);
        form.setResumePath(resumePath);
        form.setSpeciality(speciality);
        form.setLevel(level);

        return formRepository.save(form);
    }
}
