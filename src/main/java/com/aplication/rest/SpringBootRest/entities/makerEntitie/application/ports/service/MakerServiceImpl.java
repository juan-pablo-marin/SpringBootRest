package com.aplication.rest.SpringBootRest.entities.makerEntitie.application.ports.service;

import com.aplication.rest.SpringBootRest.entities.makerEntitie.application.ports.in.*;
import com.aplication.rest.SpringBootRest.entities.makerEntitie.dto.MakerDTO;
import com.aplication.rest.SpringBootRest.entities.makerEntitie.domain.model.Maker;
import com.aplication.rest.SpringBootRest.entities.makerEntitie.application.ports.out.MakerOutputPort;
import com.aplication.rest.SpringBootRest.entities.productEntiti.domain.model.Product;
import com.aplication.rest.SpringBootRest.mappers.MakerMapper;
import com.aplication.rest.SpringBootRest.mappers.ProductMapper;
import com.aplication.rest.SpringBootRest.persistence.IMakerDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MakerServiceImpl implements GetUseCase, DeleteByIdUseCase , GetByIdUseCase , GetAllUseCase//, SaveMakerUseCase
{

    private final MakerOutputPort makerOutputPort;

    @Autowired
    private final MakerMapper makerMapper;

    @Override
    public void deleteById(Long id) {
        makerOutputPort.deleteById(id);
    }

    @Override
    public Maker getById(Long id){
        return makerOutputPort.getById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public MakerDTO getId(Long id) {
        return makerOutputPort.getId(id);
    }

//
//    @Override
//    public MakerDTO saveMaker(MakerDTO makerDTO){
//        return makerOutputPort.saveMaker(makerDTO);
//    }
//
    @Override
    public List<MakerDTO> getAll(){
      return  makerOutputPort.getAll()
              .stream().toList();
    }


//
//    //@Override
//    public Optional<Maker> findById (Long id) {
//        return makerOutputPort.findById(id) ;
//    }

//    public List<UserDTO> getAllUsers() {
//        return port.findAll()
//                .stream()
//                .map(mapper::toDto)
//                .toList();
//    }

//    public UserDTO getById(Long id) {
//        return port.findById(id)
//                .map(mapper::toDto)
//                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
//


}
