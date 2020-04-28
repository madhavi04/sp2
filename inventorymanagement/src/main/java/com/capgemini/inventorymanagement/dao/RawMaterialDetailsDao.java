package com.capgemini.inventorymanagement.dao;

import java.util.List;

import com.capgemini.inventorymanagement.entities.RawMaterialDetails;

public interface RawMaterialDetailsDao {

           RawMaterialDetails addDetails(RawMaterialDetails r);
           
           List<RawMaterialDetails>getAllDetails();
           
           RawMaterialDetails getRawMaterialDetailById(int rm_id);
           
           RawMaterialDetails deleteRawMaterialDetail(int rm_id);
         
           RawMaterialDetails updateDetails(RawMaterialDetails r);
}
