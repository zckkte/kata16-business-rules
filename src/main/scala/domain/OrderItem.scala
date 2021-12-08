
package domain

class OrderItem (initSku : String, initName : String, productCategories : List[ProductCategory]) {

    var categories : List[ProductCategory] = productCategories;
    var sku : String = initSku;
    var name : String = initName;

    def hasCategory(productCategory : ProductCategory) = categories.contains(productCategory)
}