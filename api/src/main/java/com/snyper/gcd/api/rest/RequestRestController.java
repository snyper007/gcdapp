package com.snyper.gcd.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.snyper.gcd.api.impl.CustomMessageSender;
import com.snyper.gcd.api.jpa.RequestRepository;
import com.snyper.gcd.api.jpa.entity.Request;
import com.snyper.gcd.api.rest.dto.InputRequestDTO;
import com.snyper.gcd.api.rest.dto.InputRequestWithIdDTO;
import com.snyper.gcd.api.rest.dto.ResultOfRequestDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "GCD")
@RestController
@RequestMapping("/gcd")
public class RequestRestController {

    private final RequestRepository requestRepository;
    private final CustomMessageSender messageSender;

    @Autowired
    RequestRestController(RequestRepository requestRepository, CustomMessageSender messageSender) {
        this.requestRepository = requestRepository;
        this.messageSender = messageSender;
    }

    @ApiOperation(value = "Requests the new calculation.", response = Long.class)
    @RequestMapping(path = "/calculate-gcd", method = RequestMethod.POST)
    ResponseEntity<?> requestCalculation(@RequestBody InputRequestDTO input) {

        Request r = Request.createNotCompleted(input.getFirst(), input.getSecond());
        r = requestRepository.save(r);
        
        InputRequestWithIdDTO message = new InputRequestWithIdDTO();
        message.setId(r.getId());
        message.setFirst(r.getFirst());
        message.setSecond(r.getSecond());
        messageSender.sendMessage(message);

        return ResponseEntity.ok(r.getId());
    }

    @ApiOperation(value = "Requests the new calculation.", response = ResultOfRequestDTO.class)
    @RequestMapping(path = "/get-result/{id}", method = RequestMethod.GET)
    ResponseEntity<?> getCalculationResult(@PathVariable Long id) {

        Request r = requestRepository.getOne(id);

        ResultOfRequestDTO output = new ResultOfRequestDTO();
        output.setId(r.getId());
        output.setStatus(r.getStatus());
        output.setResult(r.getResult());
        output.setError(r.getError());

        return ResponseEntity.ok(output);
    }

}