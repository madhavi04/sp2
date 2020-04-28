package com.capgemini.inventorymanagement.services;


import java.util.List;
import com.capgemini.inventorymanagement.entities.RawMaterialDetails;

public interface RawMaterialDetailsService
{

	RawMaterialDetails addDetails(RawMaterialDetails r);
     
     List<RawMaterialDetails>getAllDetails();
     
     RawMaterialDetails getRawMaterialDetailById(int rm_id);
     
     RawMaterialDetails deleteRawMaterialDetail(int rm_id);
     
     RawMaterialDetails updateDetails(RawMaterialDetails r);
}


