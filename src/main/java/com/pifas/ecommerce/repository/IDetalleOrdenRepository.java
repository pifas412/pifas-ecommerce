package com.pifas.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pifas.ecommerce.model.DetalleOrden;

@Repository
public interface IDetalleOrdenRepository  extends JpaRepository<DetalleOrden, Integer>{

}
