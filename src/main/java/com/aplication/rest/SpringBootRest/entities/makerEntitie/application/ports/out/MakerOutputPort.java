package com.aplication.rest.SpringBootRest.entities.makerEntitie.application.ports.out;

import com.aplication.rest.SpringBootRest.entities.makerEntitie.dto.MakerDTO;
import com.aplication.rest.SpringBootRest.entities.makerEntitie.domain.model.Maker;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public interface MakerOutputPort {

   // Optional<Maker> findById (Long id);
   Optional<Maker>getById(Long id);
   // MakerDTO saveMaker (MakerDTO makerDTO);
   //void save(Maker maker);
   List<MakerDTO> getAll();
   //List<Maker> findAll ();
    MakerDTO getId(Long id);
   void deleteById(Long id);

   // Optional<Object> finById(Long id);
}
