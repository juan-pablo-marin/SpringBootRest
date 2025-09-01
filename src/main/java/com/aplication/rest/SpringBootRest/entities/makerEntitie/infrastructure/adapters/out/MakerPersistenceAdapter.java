package com.aplication.rest.SpringBootRest.entities.makerEntitie.infrastructure.adapters.out;

import com.aplication.rest.SpringBootRest.entities.makerEntitie.application.ports.out.MakerOutputPort;
import com.aplication.rest.SpringBootRest.entities.makerEntitie.domain.model.Maker;
import com.aplication.rest.SpringBootRest.entities.makerEntitie.dto.MakerDTO;
import com.aplication.rest.SpringBootRest.entities.makerEntitie.infrastructure.adapters.out.persistence.MakerRepository;
import com.aplication.rest.SpringBootRest.mappers.MakerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MakerPersistenceAdapter implements  MakerOutputPort {

    private final MakerRepository repository;

    @Autowired
    private final MakerMapper makerMapper;

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<MakerDTO> getById(Long id) {
        return repository.findById(id)
                .map(makerMapper::toMakerDto);
    }

    @Override
    public List<MakerDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(makerMapper::toMakerDto)
                .toList();
    }

    @Override
    public MakerDTO getId(Long id) {
        return repository.findById(id)
                .map(makerMapper::toMakerDto)
                .orElseThrow();
    }

    @Override
    public MakerDTO saveMaker(MakerDTO makerDTO) {
        Maker entity = makerMapper.toMaker(makerDTO);
        Maker saved = repository.save(entity);
        return makerMapper.toMakerDto(saved);
    }

    @Override
    public MakerDTO update(MakerDTO makerDTO) {
        Maker entity = makerMapper.toMaker(makerDTO);
        Maker saved = repository.save(entity);
        return makerMapper.toMakerDto(saved);
    }
}