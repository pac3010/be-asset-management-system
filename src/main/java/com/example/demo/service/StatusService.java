package com.example.demo.service;

import com.example.demo.model.Status;
import com.example.demo.service.generic.GenericService;

public interface StatusService extends GenericService<Status, Integer>{
    public Status getIdByName(String statusName);
}
