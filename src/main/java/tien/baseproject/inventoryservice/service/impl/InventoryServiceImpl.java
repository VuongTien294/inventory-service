package tien.baseproject.inventoryservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tien.baseproject.inventoryservice.dto.InventoryRequest;
import tien.baseproject.inventoryservice.dto.InventoryResponse;
import tien.baseproject.inventoryservice.entity.BaseEntity;
import tien.baseproject.inventoryservice.entity.Inventory;
import tien.baseproject.inventoryservice.repository.InventoryRepository;
import tien.baseproject.inventoryservice.service.InventoryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;

    @Override
    @Transactional(readOnly = true)
    @SneakyThrows
    public List<InventoryResponse> isInStock(List<String> skuCodes) {
        log.info("Checking Inventory");

        List<Inventory> inventorys = inventoryRepository.findBySkuCodeIn(skuCodes);
        List<InventoryResponse> responses = new ArrayList<>();
        for (Inventory element : inventorys) {
            responses.add(InventoryResponse.builder()
                            .skuCode(element.getSkuCode())
                    .isInStock(element.getQuantity() > 0).build());
        }

        return responses;
    }

    @Override
    public Boolean createInventory(InventoryRequest inventory) {
        Inventory save =  inventoryRepository.save(
                Inventory.builder()
                        .skuCode(inventory.getSkuCode())
                        .quantity(inventory.getQuantity())
                        .build());
        if(Objects.nonNull(save)){
            return true;
        }
        return false;
    }

}
