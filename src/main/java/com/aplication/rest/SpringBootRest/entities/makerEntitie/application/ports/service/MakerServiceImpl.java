package com.aplication.rest.SpringBootRest.entities.makerEntitie.application.ports.service;

import com.aplication.rest.SpringBootRest.entities.makerEntitie.application.ports.in.*;
import com.aplication.rest.SpringBootRest.entities.makerEntitie.dto.MakerDTO;
import com.aplication.rest.SpringBootRest.entities.makerEntitie.application.ports.out.MakerOutputPort;
import com.aplication.rest.SpringBootRest.mappers.MakerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MakerServiceImpl implements  GetUseCase, DeleteByIdUseCase , GetByIdUseCase , GetAllUseCase, SaveMakerUseCase, UpdateMakerUseCase
{

    private final MakerOutputPort makerOutputPort;

    @Autowired
    private final MakerMapper makerMapper;

    @Override
    public void deleteById(Long id) {
        makerOutputPort.deleteById(id);
    }

    @Override
    public Optional<MakerDTO> getById(Long id){
        return makerOutputPort.getById(id);
    }

    @Override
    public MakerDTO getId(Long id) {
        return makerOutputPort.getId(id);
    }

    @Override
    public List<MakerDTO> getAll(){
      return  makerOutputPort.getAll()
              .stream()
              .toList();
    }

    @Override
    public MakerDTO saveMaker(MakerDTO makerDTO) {
        return makerOutputPort.saveMaker(makerDTO);
    }

    @Override
    public MakerDTO update(MakerDTO makerDTO) {
        return makerOutputPort.update(makerDTO);
    }
}
