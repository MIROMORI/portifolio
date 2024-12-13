package com.miromori.portifolio.mapper;

import com.miromori.portifolio.data.vo.v1.PersonVO;
import com.miromori.portifolio.data.vo.v2.PersonVOV2;
import com.miromori.portifolio.model.Person;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonVO personToPersonVO(Person person);

    Person personVOToPerson(PersonVO personVO);

    List<PersonVO> personsToPersonVOs(List<Person> persons);

    PersonVOV2 personToPersonVOV2(Person person);

    List<PersonVOV2> personsToPersonsVOV2(List<Person> persons);

    Person personVOV2ToPerson(PersonVOV2 personVO);
}
