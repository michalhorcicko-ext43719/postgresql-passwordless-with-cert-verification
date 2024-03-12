package cz.csas.azure.ccc.example.repository

import cz.csas.azure.ccc.example.model.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface ProductRepository : JpaRepository<ProductEntity, Long>
