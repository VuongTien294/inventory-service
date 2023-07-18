package tien.baseproject.inventoryservice.service;

import lombok.SneakyThrows;
import org.springframework.transaction.annotation.Transactional;
import tien.baseproject.inventoryservice.dto.InventoryRequest;
import tien.baseproject.inventoryservice.dto.InventoryResponse;

import java.util.List;

public interface InventoryService {
    @Transactional(readOnly = true)
    @SneakyThrows
    List<InventoryResponse> isInStock(List<String> skuCodes);

    Boolean createInventory(InventoryRequest inventory);
}
