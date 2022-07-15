package ru.job4j.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.job4j.domain.Employee;
import ru.job4j.domain.Person;
import ru.job4j.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employees;
    @Autowired
    private RestTemplate rest;

    public EmployeeController(EmployeeService employees) {
        this.employees = employees;
    }

    private static final String API = "http://localhost:8080/person/";
    private static final String API_ID = "http://localhost:8080/person/{id}";

    /**
     * Получение всех сотрудников, со всеми их аккаунтами.
     * @return Список сотрудников и их аккаунты.
     */
    @GetMapping("/")
    public List<Employee> findAll() {
        return employees.findAll();
    }

    /**
     * Добавление нового аккаунта
     * @param person Добавляемый аккаунт
     * @return Получаем аккаунт со сгенерированным Id
     */
    @PostMapping("/")
    public ResponseEntity<Person> create(@RequestBody Person person) {
        Person rsl = rest.postForObject(API, person, Person.class);
        return new ResponseEntity<>(
                rsl,
                HttpStatus.CREATED
        );
    }

    /**
     * Изменение аккаунта
     * @param person Аккаунт
     * @return Статус выполнения
     */
    @PutMapping("/")
    public ResponseEntity<Void> update(@RequestBody Person person) {
        rest.put(API, person);
        return ResponseEntity.ok().build();
    }

    /**
     * Удаление аккаунта
     * @param id аккаунта
     * @return Статус выполнения
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        rest.delete(API_ID, id);
        return ResponseEntity.ok().build();
    }
}
