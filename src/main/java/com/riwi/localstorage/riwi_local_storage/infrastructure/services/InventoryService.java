package com.riwi.localstorage.riwi_local_storage.infrastructure.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.InventoryRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.request.update.InventoryRequestUpdate;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.InventoryResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Branch;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Inventory;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Product;
import com.riwi.localstorage.riwi_local_storage.domain.repositories.BranchRepository;
import com.riwi.localstorage.riwi_local_storage.domain.repositories.InventoryRepository;
import com.riwi.localstorage.riwi_local_storage.domain.repositories.ProductRepository;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.IInventoryService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.inventoryMappers.InventoryCreateMapper;
import com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.inventoryMappers.InventoryMapper;
import com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.inventoryMappers.InventoryUpdateMapper;
import com.riwi.localstorage.riwi_local_storage.util.exeptions.IdNotFoundException;
import com.riwi.localstorage.riwi_local_storage.util.exeptions.InventoryExpirationDatePassed;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InventoryService implements IInventoryService {
	
	@Autowired
	private final InventoryMapper inventoryMapper;

	@Autowired
	private final InventoryCreateMapper createMapper;
	
	@Autowired
	private final InventoryRepository inventoryRepository;

	@Autowired
	private final ProductRepository productRepository;

	@Autowired
	private final BranchRepository branchRepository;

	@Autowired
	private final InventoryUpdateMapper updateMapper;

	@Override
	public InventoryResponse create(InventoryRequest request) {
		Date today = new Date();

		if (request.getExpirationDate().before(today)) {
			throw new InventoryExpirationDatePassed("The expiration date of the item in the inventory has passed");
		}


		Product product = productRepository.findById(request.getProductId())
				.orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + request.getProductId()));

		Branch branch = branchRepository.findById(request.getBranchId())
				.orElseThrow(() -> new EntityNotFoundException("Branch not found with id: " + request.getBranchId()));

		Inventory inventory = createMapper.toEntity(request);
		inventory.setProduct(product);
		inventory.setBranch(branch);

		Inventory savedInventory = inventoryRepository.save(inventory);

		return createMapper.toResponse(savedInventory);
	}
	@Override
	public InventoryResponse update(String id, InventoryRequestUpdate request) {
		
		Inventory inventory = this.find(id);

		Inventory toUpdate= this.updateMapper.toEntity(request);
		
		toUpdate.setId(inventory.getId());
		toUpdate.setLastUpdateDate(new Date());

		if (toUpdate.getQuantity() < 0 || toUpdate.getQuantity() <= inventory.getQuantity()) {
			return null;
		}

		return this.updateMapper.toResponse(this.inventoryRepository.save(toUpdate));
	}

	
	@Override
	public Page<InventoryResponse> getAll(Pageable pageable) {
		return this.inventoryRepository.findAll(pageable).map(this.inventoryMapper::toResponse);
	}

	@Override
	public Optional<InventoryResponse> getById(String id) {
		return Optional.ofNullable(this.inventoryMapper.toResponse(this.find(id)));
	}

	private Inventory find(String id){
		return this.inventoryRepository.findById(id).orElseThrow(()->new IdNotFoundException("Inventory", id));
	}

}
