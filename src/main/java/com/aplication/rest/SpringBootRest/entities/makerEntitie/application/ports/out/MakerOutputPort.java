package com.aplication.rest.SpringBootRest.entities.makerEntitie.application.ports.out;

import com.aplication.rest.SpringBootRest.entities.makerEntitie.dto.MakerDTO;
import com.aplication.rest.SpringBootRest.entities.makerEntitie.dto.PageResult;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public interface MakerOutputPort {

    void deleteById(Long id);
    List<MakerDTO> getAll();
    Optional<MakerDTO>getById(Long id);
    MakerDTO getId(Long id);
    MakerDTO saveMaker (MakerDTO makerDTO);
    MakerDTO update (MakerDTO makerDTO);
    PageResult<MakerDTO> listAll(int page, int size);
}
