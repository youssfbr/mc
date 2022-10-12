package com.github.youssfbr.mc.services.interfaces;

import com.github.youssfbr.mc.entities.State;

import java.util.List;

public interface IStateService {

    List<State> listAllStates();
    State findStateById(Long stateId);
    State insertState(State state);

}
