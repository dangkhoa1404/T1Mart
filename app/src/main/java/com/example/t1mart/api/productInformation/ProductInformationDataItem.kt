package quicktype

data class ResponseDetailProduct (
    val id: Long? = null,
    val title: String? = null,
    val description: String? = null,
    val price: Long? = null,
    val discountPercentage: Double? = null,
    val rating: Double? = null,
    val stock: Long? = null,
    val brand: String? = null,
    val category: String? = null,
    val thumbnail: String? = null,
    val images: List<String>? = null
)
