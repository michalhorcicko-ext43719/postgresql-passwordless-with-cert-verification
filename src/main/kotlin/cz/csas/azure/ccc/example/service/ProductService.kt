package cz.csas.azure.ccc.example.service

import cz.csas.azure.ccc.example.model.ProductDTO
import cz.csas.azure.ccc.example.model.ProductEntity
import cz.csas.azure.ccc.example.model.toDTO
import cz.csas.azure.ccc.example.model.toEntity
import cz.csas.azure.ccc.example.repository.ProductRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ProductService(
    private val productRepository: ProductRepository
) {

    fun findAllProducts(): Collection<ProductDTO> {
        return productRepository
            .findAll()
            .map(ProductEntity::toDTO)
    }

    fun addProduct(product: ProductDTO): ProductDTO {
        return productRepository
            .save(product.toEntity())
            .toDTO()
    }

    fun productExists(id: Long): Boolean {
        return productRepository.existsById(id)
    }

    fun deleteProduct(id: Long) {
        productRepository.deleteById(id)
    }
}
