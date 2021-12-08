package handlers

import services.ShippingService
import services.PackingSlipService
import services.RoyaltyService
import domain.Payment
import domain.ProductCategory

class PackingSlipHandler (shippingService: ShippingService, 
    packingSlipService: PackingSlipService,
    royaltyService : RoyaltyService) {

        var _shippingService = shippingService;
        var _packingSlipService = packingSlipService;
        var _royaltyService = royaltyService;
  
        def run(payment: Payment) = {
            var generatePackingSlipForShipping = payment.order.items
                .exists(_.hasCategory(ProductCategory.Physical))

            var generatePackingSlipForRoyalty = payment.order.items
                .exists(_.hasCategory(ProductCategory.Books))

            if (generatePackingSlipForRoyalty) _shippingService.generate(payment.order)

            if (generatePackingSlipForShipping) _royaltyService.generate(payment.order)
        }
}
