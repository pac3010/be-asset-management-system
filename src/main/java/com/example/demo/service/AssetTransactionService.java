package com.example.demo.service;

import com.example.demo.model.AssetTransaction;
import com.example.demo.service.generic.GenericService;

public interface AssetTransactionService extends GenericService<AssetTransaction, Integer>{
    AssetTransaction updateStatus(Integer id, Integer statusId);
    
}
    