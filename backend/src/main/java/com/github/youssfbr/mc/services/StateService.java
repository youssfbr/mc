package com.github.youssfbr.mc.services;

import com.github.youssfbr.mc.entities.State;
import com.github.youssfbr.mc.repositories.IStateRepository;
import com.github.youssfbr.mc.services.exceptions.ResourceNotFoundException;
import com.github.youssfbr.mc.services.interfaces.IStateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StateService implements IStateService {

    private final IStateRepository stateRepository;

    public StateService(IStateRepository stateRepository) { this.stateRepository = stateRepository; }
    @Override
    @Transactional(readOnly = true)
    public List<State> listAllStates() {
        return stateRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public State findStateById(Long stateId) {
        return stateRepository
                .findById(stateId)
                .orElseThrow (() -> new ResourceNotFoundException("Estado não encontrado com id " + stateId));
    }

    @Override
    @Transactional
    public State insertState(State state) {
        return stateRepository.save(state);
    }
}
