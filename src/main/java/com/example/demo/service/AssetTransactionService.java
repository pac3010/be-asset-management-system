package com.example.demo.service;

import java.util.List;

import com.example.demo.model.AssetTransaction;
import com.example.demo.model.dto.AssetTransactionIdBorrowTimeDTO;
import com.example.demo.service.generic.GenericService;

public interface AssetTransactionService extends GenericService<AssetTransaction, Integer>{
    AssetTransaction updateStatus(Integer id, Integer statusId);
    public List<AssetTransactionIdBorrowTimeDTO> getIdAndBorrowTime();
    public List<AssetTransactionIdBorrowTimeDTO> getIdAndBorrowTimeBorrower(Integer userId);

}
    