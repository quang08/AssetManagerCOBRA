package com.example.AssetManagement.repo;

import com.example.AssetManagement.entities.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepo extends JpaRepository<Asset, Long> {
}
