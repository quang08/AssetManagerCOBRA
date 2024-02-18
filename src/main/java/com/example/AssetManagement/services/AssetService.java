package com.example.AssetManagement.services;

import com.example.AssetManagement.entities.Asset;
import com.example.AssetManagement.repo.AssetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import AssetManagementIDL.AssetData;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AssetService {
    private final AssetRepo assetRepo;

    @Autowired
    public AssetService(AssetRepo assetRepo) {
        this.assetRepo = assetRepo;
    }

    public List<Asset> getAllAssets() {
        List<Asset> assets = assetRepo.findAll();
        System.out.println("Retrieved " + assets.size() + " assets from the database.");
        return assets;
    }

    public boolean addAsset(Asset asset) {
        try {
            assetRepo.save(asset);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateAsset(long assetId, Asset assetData) {
        Optional<Asset> optionalAsset = assetRepo.findById(assetId);
        if (optionalAsset.isPresent()) {
            Asset existingAsset = optionalAsset.get();
            // Update existingAsset with new data
            existingAsset.setAssetName(assetData.getAssetName());
            existingAsset.setPurchaseDate(new Date(String.valueOf(assetData.getPurchaseDate())));
            existingAsset.setPurchasePrice(assetData.getPurchasePrice());
            existingAsset.setCurrentValue(assetData.getCurrentValue());
            existingAsset.setStatus(assetData.getStatus());
            existingAsset.setVendorId((long) assetData.getVendorId());
            // Save the updated asset
            assetRepo.save(existingAsset);
            return true;
        } else {
            return false; // Asset with the given ID not found
        }
    }

    public boolean deleteAsset(long assetId) {
        if (assetRepo.existsById(assetId)) {
            assetRepo.deleteById(assetId);
            return true;
        } else {
            return false;
        }
    }

    public AssetData getAssetDetails(long assetId) {
        Optional<Asset> optionalAsset = assetRepo.findById(assetId);
        if (optionalAsset.isPresent()) {
            Asset assetEntity = optionalAsset.get();
            // Convert Asset to AssetData
            return convertToAssetData(assetEntity);
        } else {
            return null; // Asset with the given ID not found
        }
    }

    // Helper method to convert Asset to AssetData
    private AssetData convertToAssetData(Asset assetEntity) {
        AssetData assetData = new AssetData();
        assetData.assetName = assetEntity.getAssetName();
        assetData.purchaseDate = (int) assetEntity.getPurchaseDate().getTime();
        assetData.purchasePrice = assetEntity.getPurchasePrice();
        assetData.currentValue = assetEntity.getCurrentValue();
        assetData.status = assetEntity.getStatus();
        assetData.vendorId = Math.toIntExact(assetEntity.getVendorId());
        return assetData;
    }
}
