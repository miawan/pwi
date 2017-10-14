package com.pwi.mapper.institution;

import java.util.ArrayList;
import java.util.List;

import com.pwi.dto.address.AddressDTO;
import com.pwi.dto.brand.BrandDTO;
import com.pwi.dto.brand.CompanyDTO;
import com.pwi.dto.brand.ProductDTO;
import com.pwi.dto.brand.ProductSizeDTO;
import com.pwi.dto.request.QuantityUpdaterDTO;
import com.pwi.dto.response.WarehouseDetails;
import com.pwi.model.brand.Brand;
import com.pwi.model.brand.Item;
import com.pwi.model.brand.Product;
import com.pwi.model.brand.ProductSize;

public class ProductMapper {

	public static List<ProductDTO> productsToDTO(List<Product> products) {
		if (null == products || products.size() < 1)
			return null;
		List<ProductDTO> retVal = new ArrayList<ProductDTO>();
		BrandDTO brand = new BrandDTO();
		brandToDTO(products.get(0).getBrand(), brand, null);
		for (Product pro : products) {
			retVal.add(productToDTO(pro));
		}
		return retVal;
	}

	public static ProductDTO productToDTO(Product pro) {
		BrandDTO brand = new BrandDTO();
		brandToDTO(pro.getBrand(), brand, null);
		ProductDTO dto = new ProductDTO();
		dto.setId(pro.getId());
		dto.setBrand(brand);
		dto.setName(pro.getName());
		dto.setDescription(pro.getDescription());
		dto.setType(pro.getType());
//		dto.setSize(pro.getSize());
		dto.setIsActive(pro.getIsActive());
		dto.setCreatedAt(pro.getCreatedAt());
		dto.setCreatedBy(pro.getCreatedBy());
		dto.setModifiedAt(pro.getModifiedAt());
		dto.setModifiedBy(pro.getModifiedBy());
		// dto.setInStock(pro.getInStock());
		// dto.setAvailableQuantity(pro.getAvailableQuantity());
		// dto.setInTransit(dto.getInTransit());
		// dto.setMoq(dto.getMoq());
		// dto.setQpb(dto.getQpb());
		// dto.setReOrderPoint(dto.getReOrderPoint());
		return dto;
	}

	public static Product dtoToProduct(ProductDTO pro) {
		Brand brand = new Brand();
		if (null != pro.getBrand())
			brand.setId(pro.getBrand().getId());
		Product dto = new Product();
		dto.setBrand(brand);
		dto.setId(pro.getId());
		dto.setBrand(brand);
		dto.setName(pro.getName());
		dto.setDescription(pro.getDescription());
		dto.setType(pro.getType());
		dto.setIsActive(null != pro.getIsActive() ? pro.getIsActive() : Boolean.TRUE);
		dto.setCreatedAt(pro.getCreatedAt());
		dto.setCreatedBy(pro.getCreatedBy());
		dto.setModifiedAt(pro.getModifiedAt());
		dto.setModifiedBy(pro.getModifiedBy());
		List<ProductSize> psizes= new ArrayList<ProductSize>();
		if(null != pro.getProductSizes() && !pro.getProductSizes().isEmpty()){
			for(ProductSizeDTO size : pro.getProductSizes()){
				ProductSize ps = new ProductSize();
				ps.setId(size.getId());
				ps.setSize(size.getSize());
				ps.setProduct(dto);
				psizes.add(ps);
			}
		}
		dto.setProductSizes(psizes);
		return dto;
	}

	public static void setProductQuantity(Item item, QuantityUpdaterDTO dto) {
		if (null != dto.getInStock())
			item.setInStock(dto.getInStock());
		if (null != dto.getAvailableQuantity())
			item.setAvailableQuantity(dto.getAvailableQuantity());
		if (null != dto.getInTransit())
			item.setInTransit(dto.getInTransit());
		if (null != dto.getMoq())
			item.setMoq(dto.getMoq());
		if (null != dto.getQpb())
			item.setQpb(dto.getQpb());
		if (null != dto.getReOrderPoint())
			item.setReOrderPoint(dto.getReOrderPoint());
	}

	public static void brandToDTO(Brand brand, BrandDTO dto, String company) {
		if (null != brand) {
			dto.setId(brand.getId());
			CompanyDTO comp = new CompanyDTO();
			if (null != company)
				comp.setName(company);
			dto.setCompany(comp);
			dto.setName(brand.getName());
			dto.setDescription(brand.getDescription());
			dto.setCreatedAt(brand.getCreatedAt());
			dto.setCreatedBy(brand.getCreatedBy());
			dto.setModifiedAt(brand.getModifiedAt());
			dto.setModifiedBy(brand.getModifiedBy());
		}
	}

	public static List<WarehouseDetails> itemToWarehouseDetails(List<Item> items) {
		List<WarehouseDetails> retVal = new ArrayList<WarehouseDetails>();
		if (null != items && items.size() > 0) {
			for (Item item : items) {
				WarehouseDetails detail = new WarehouseDetails();
				detail.setInStock(item.getInStock());
				detail.setAvailableQuantity(item.getAvailableQuantity());
				detail.setInTransit(item.getInTransit());
				detail.setMoq(item.getMoq());
				detail.setQpb(item.getQpb());
				detail.setReOrderPoint(item.getReOrderPoint());
				detail.setId(item.getId());
				detail.setIsActive(item.getIsActive());
				AddressDTO address = new AddressDTO();
				if (null != item.getWarehouse()) {
					detail.setName(item.getWarehouse().getName());
					detail.setDescription(item.getWarehouse().getDescription());
					if (null != item.getWarehouse().getAddress()) {
						LocationMapper.addressToDTO(address, item.getWarehouse().getAddress());
					}
				}
				detail.setAddress(address);
				retVal.add(detail);
			}
		}
		return retVal;
	}

}
