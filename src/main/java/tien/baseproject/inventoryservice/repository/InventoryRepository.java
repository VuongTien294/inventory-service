package tien.baseproject.inventoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tien.baseproject.inventoryservice.entity.Inventory;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findBySkuCodeIn(List<String> skuCode);
}
