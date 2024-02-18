package com.example.AssetManagement.services.impl;

import com.example.AssetManagement.services.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetManagerImpl {
    private final AssetService assetService;

    @Autowired
    public AssetManagerImpl(AssetService assetService) {
        this.assetService = assetService;
    }



}
