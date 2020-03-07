package fii.practic.yonder.demo.controller;

import fii.practic.yonder.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @Autowired
    private TestService testService; // = new TestServiceImpl();

    @GetMapping
    @RequestMapping(value = "/test")
    public String getMessage() {
        return testService.getTestMessage();
    }

    /*@GetMapping
    @RequestMapping(value = "/test/{id}")
    public String getTestMessage(@RequestParam(value = "name", required = false) String name, @PathVariable Long id) {
        return "Am primit ID: " + id + " si numele: " + name;
    }*/

    @GetMapping
    public String getNames() {
        return testService.getAll();
    }

    @PostMapping
    public void save(@RequestBody String name) {
        testService.save(name);
    }

    @PutMapping
    @RequestMapping(value = "/{id}")
    // alternativ @PutMapping(value = "/{id}")
    public void update(@PathVariable Integer id, @RequestBody String newValue) {
        testService.update(id, newValue);
    }

    @DeleteMapping
    @RequestMapping(value = "/delete/{id}")
    // alternativ @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id) {
        testService.delete(id);
    }
}
