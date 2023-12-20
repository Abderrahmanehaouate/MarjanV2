package com.youcode.marjanv2.Services;

import com.youcode.marjanv2.Models.Entity.ResponsableCenter;
import com.youcode.marjanv2.Repositories.ResponsableCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponsableCenterService {
    private final ResponsableCenterRepository repository;
    @Autowired
    public ResponsableCenterService(ResponsableCenterRepository repository) {
        this.repository = repository;
    }

    public List<ResponsableCenter> getAllResponsables() {
        return repository.findAll();
    }

    public Optional<ResponsableCenter> getResponsableById(Long id) {
        return repository.findById(id);
    }

    public ResponsableCenter createResponsable(ResponsableCenter responsableCenter) {
        return repository.save(responsableCenter);
    }

    public void deleteResponsableById(Long id) {
        repository.deleteById(id);
    }

    public ResponsableCenter updateResponsable(Long responsableId, ResponsableCenter responsable) {
//        ResponsableCenter existingResponsable = repository.findById(responsableId)
//                .orElseThrow(() -> new EntityNotFoundException("Responsable rayon not found"));
        return repository.save(responsable);

    }
}
