package com.fuse.hibernate.example.app;
import com.fuse.hibernate.example.model.Person;
import com.fuse.hibernate.example.service.PersonService;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ExchangeProcessor implements Processor {

    private final PersonService personService;
    static Logger LOG = LoggerFactory.getLogger(ExchangeProcessor.class);

    public ExchangeProcessor(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public void process(Exchange exchange) {

        LOG.info("INSIDE PROCESS:##:"+ exchange.getIn().getBody(Person.class));

        Person p = exchange.getIn().getBody(Person.class);
        if (p == null) {
            p = new Person();
            p.setCity("OrdaSosite");
            p.setCountry("Country");
            p.setName("Person");
        }
        personService.createPerson(p);

        List<Person> list = personService.findPersons();
        LOG.info("output list.size::::::"+list.size());
        LOG.info("output list.size::::::" + list.get(0).toString());
    }
}
