package cz.csas.azure.ccc.example.model

import jakarta.persistence.*

@Entity
@Table(name = "product")
data class ProductEntity(
    @Id
    @GeneratedValue(generator = "productSeqGen")
    @SequenceGenerator(name = "productSeqGen", sequenceName = "product_seq")
    @Column(name = "id")
    val id: Long?,

    @Column(name = "name", nullable = false, length = 255)
    val name: String
)

data class ProductDTO(
    val id: Long?,
    val name: String
)

fun ProductEntity.toDTO() = ProductDTO(id, name)
fun ProductDTO.toEntity() = ProductEntity(id, name)
