package com.aplication.rest.SpringBootRest.mappers;


import com.aplication.rest.SpringBootRest.entities.makerEntitie.dto.MakerDTO;
import com.aplication.rest.SpringBootRest.entities.makerEntitie.domain.model.Maker;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MakerMapper {

//    @Mapper(componentModel = "spring")
//    public interface UserMapper {
//        MakerDTO toDto(Maker user);
//        Maker toDomain(MakerDTO dto);
//    }

    MakerMapper makerMapper = Mappers.getMapper(MakerMapper.class);

   // @Mapping(target = "names", source = "name")
    MakerDTO toMakerDto(Maker maker);
    Maker toMaker(MakerDTO dto);
    List<MakerDTO> toDtos(List<Maker> makers);

}
