package com.jbm.spring_boot_crud_mysql.mapping.one_to_one;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/person-adhar")
@RestController
public class PersonAdharController {

	private final PersonAdharDao personAdharDao;
	
	public PersonAdharController(PersonAdharDao personAdharDao) {
		super();
		this.personAdharDao = personAdharDao;
	}
	
	@PostMapping("/savePersonAdhar")
	public Person savePersonWithAdhar(@RequestBody Person person) {
		return personAdharDao.savePersonWithAdhar(person);
	}
}
