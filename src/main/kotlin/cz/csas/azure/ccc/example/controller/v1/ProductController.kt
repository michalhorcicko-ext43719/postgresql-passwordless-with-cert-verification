package cz.csas.azure.ccc.example.controller.v1

import cz.csas.azure.ccc.example.model.ProductDTO
import cz.csas.azure.ccc.example.service.ProductService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/products")
class ProductController(
    private val productService: ProductService
) {

    @GetMapping
    fun getAllProducts(): Collection<ProductDTO> {
        return productService.findAllProducts()
    }

    @PostMapping
    fun addProduct(@RequestBody product: ProductDTO): ProductDTO {
        if (product.id != null) {
            throw IllegalArgumentException("A new Product cannot have an ID")
        }
        return productService.addProduct(product)
    }

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable(value = "id", required = true) id: Long) {
        if (productService.productExists(id)) {
            productService.deleteProduct(id)
        } else {
            throw IllegalArgumentException("Product with id '$id' does not exist.")
        }
    }
}
