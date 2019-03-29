package hello;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloController {

    @Autowired
    CustomerRepository repository;

    @RequestMapping("/")
    List<Customer> home() {
        List<Customer> list = new ArrayList<>();

        repository.deleteAll();

        repository.save(new Customer("Jack", "Bauer"));
        repository.save(new Customer("Chloe", "O'Brian"));
        for (Customer customer : repository.findAll()) {
            list.add(customer);
        }

        return list;
    }

}