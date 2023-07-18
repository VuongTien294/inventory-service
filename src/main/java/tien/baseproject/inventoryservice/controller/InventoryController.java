package tien.baseproject.inventoryservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import tien.baseproject.inventoryservice.dto.InventoryRequest;
import tien.baseproject.inventoryservice.dto.InventoryResponse;
import tien.baseproject.inventoryservice.entity.Inventory;
import tien.baseproject.inventoryservice.service.InventoryService;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
@Slf4j
public class InventoryController {

    private final InventoryService inventoryService;

    // http://localhost:8084/api/inventory/iphone-13,iphone13-red

    // http://localhost:8084/api/inventory?skuCode=iphone-13&skuCode=iphone13-red

    @PostMapping("/create-inventory")
    @ResponseStatus(HttpStatus.OK)
    public Boolean createInventory(@RequestBody InventoryRequest inventoryRequest) {
        return inventoryService.createInventory(inventoryRequest);
    }


    @GetMapping("/check-quantity")
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode) {
        log.info("Received inventory check request for skuCode: {}", skuCode);
        return inventoryService.isInStock(skuCode);
    }
}
