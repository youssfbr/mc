package com.github.youssfbr.mc.resources;

import com.github.youssfbr.mc.entities.State;
import com.github.youssfbr.mc.services.interfaces.IStateService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/states")
public class StateResource {

    private final IStateService stateService;

    public StateResource(IStateService stateService) { this.stateService = stateService; }

    @GetMapping
    public List<State> listAllStates() {
        return stateService.listAllStates();
    }

    @GetMapping("{stateId}")
    public State listStateById(@PathVariable Long stateId) { return stateService.findStateById(stateId); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public State insertState(@RequestBody State state) {
        return stateService.insertState(state);
    }

}
