package com.miromori.portifolio.mapper;

import com.miromori.portifolio.data.vo.v1.PersonVO;
import com.miromori.portifolio.model.Person;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonVO personToPersonVO(Person person);

    Person personVOToPerson(PersonVO personVO);

    List<PersonVO> personsToPersonVOs(List<Person> persons);
}
