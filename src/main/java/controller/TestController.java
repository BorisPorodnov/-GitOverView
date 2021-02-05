package controller;

import model.HelloResponse;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
    @GetMapping("/")
    public String helloWorld() {
        return "Hello World";
    }

    @PostMapping("/hello")
    public HelloResponse hello(@RequestBody String name) {
        HelloResponse response = new HelloResponse();
        response.setMassage("Hello " + name);
        return response;
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public HelloResponse helloVersion(@PathVariable String name, @RequestParam(value = "v", required = false) Integer version) {
        HelloResponse response = new HelloResponse();
        if (version == null) {
            response.setMassage("Unknown version");
        } else if (version == 1) {
            response.setMassage("Hello " + name);
        } else if (version == 2) {
            response.setMassage("Hi " + name);
        }
        return response;
    }
}
