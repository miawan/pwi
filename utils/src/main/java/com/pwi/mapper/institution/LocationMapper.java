package com.pwi.mapper.institution;

import java.util.ArrayList;
import java.util.List;

import com.pwi.dto.address.AddressDTO;
import com.pwi.dto.address.CountryDTO;
import com.pwi.dto.company.WarehouseDTO;
import com.pwi.model.address.Address;
import com.pwi.model.address.Country;
import com.pwi.model.company.Warehouse;

public class LocationMapper {

	public static List<WarehouseDTO> warehouseToDTOs(List<Warehouse> whs) {
		List<WarehouseDTO> retVal = new ArrayList<WarehouseDTO>();
		if (null != whs) {
			for (Warehouse wh : whs) {
				retVal.add(LocationMapper.warehouseToDTO(wh));
			}
		} else {
			return null;
		}
		return retVal;
	}

	public static WarehouseDTO warehouseToDTO(Warehouse wh) {
		WarehouseDTO dto = new WarehouseDTO();
		dto.setId(wh.getId());
		dto.setName(wh.getName());
		dto.setDescription(wh.getDescription());
		dto.setIsActive(wh.getIsActive());
		AddressDTO address = new AddressDTO();
		if (null != dto.getAddress() && null != dto.getAddress().getId()) {
			LocationMapper.addressToDTO(address, wh.getAddress());
		}
		dto.setAddress(address);
		return dto;
	}

	public static Warehouse dtoToWarehouse(WarehouseDTO dto) {
		Warehouse wh = new Warehouse();
		wh.setId(dto.getId());
		wh.setName(dto.getName());
		wh.setDescription(dto.getDescription());
		wh.setIsActive(dto.getIsActive());
		Address address = new Address();
		if (null != dto.getAddress()) {
			LocationMapper.dtoToAddress(address, dto.getAddress());
		}
		wh.setAddress(address);
		return wh;
	}

	public static Address dtoToAddress(Address res, AddressDTO dto) {

		res.setId(dto.getId());
		res.setAddress1(dto.getAddress1());
		res.setAddress2(dto.getAddress2());
		res.setCity(dto.getCity());
		res.setState(dto.getState());
		res.setZipCode(dto.getZipCode());
		res.setIsPrimary(dto.getIsPrimary());
		res.setActive(dto.getActive());
		res.setCreatedBy(dto.getCreatedBy());
		res.setCreatedAt(dto.getCreatedAt());
		res.setModifiedBy(dto.getModifiedBy());
		res.setModifiedAt(dto.getModifiedAt());
		Country country = new Country();
		if (null != dto.getCountry() && null != dto.getCountry().getId()) {
			country.setId(dto.getCountry().getId());
			country.setCode(dto.getCountry().getCode());
			country.setName(dto.getCountry().getName());
		}
		res.setCountry(country);
		return res;
	}

	public static AddressDTO addressToDTO(AddressDTO res, Address dto) {

		res.setId(dto.getId());
		res.setAddress1(dto.getAddress1());
		res.setAddress2(dto.getAddress2());
		res.setCity(dto.getCity());
		res.setState(dto.getState());
		res.setZipCode(dto.getZipCode());
		res.setIsPrimary(dto.getIsPrimary());
		res.setActive(dto.getActive());
		res.setCreatedBy(dto.getCreatedBy());
		res.setCreatedAt(dto.getCreatedAt());
		res.setModifiedBy(dto.getModifiedBy());
		res.setModifiedAt(dto.getModifiedAt());
		CountryDTO country = new CountryDTO();
		if (null != dto.getCountry() && null != dto.getCountry().getId()) {
			country.setId(dto.getCountry().getId());
			country.setCode(dto.getCountry().getCode());
			country.setName(dto.getCountry().getName());
		}
		res.setCountry(country);
		return res;
	}

	public static boolean deactivateWarehouse(Warehouse wh) {
		if (null == wh)
			return false;
		try {
			wh.setIsActive(false);
			if (null != wh.getAddress())
				wh.getAddress().setActive(false);
			// if(null != wh.getProducts() && wh.getProducts().size() > 0){
			// for(Product pro : wh.getProducts()){
			// pro.setIsActive(false);
			// }
			// }
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
