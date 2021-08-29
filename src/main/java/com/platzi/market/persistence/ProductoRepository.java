package com.platzi.market.persistence;

import com.platzi.market.persistence.crud.ProductoCrudRepository;
import com.platzi.market.persistence.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

   public List<Producto> getByCategoria(int idCategoria){
        return  productoCrudRepository.findByIdCategoria(idCategoria);
   }
   public List<Producto> getByCategoriaOrder(int idCategoria){
        return  productoCrudRepository.findByIdCategoriaOOrderByNombreAsc(idCategoria);
   }
   public Optional<List<Producto>> getEscasos(int categoria){
        return  productoCrudRepository.findByCantidadStockLessThanAndEstado(categoria,true);
   }

}
