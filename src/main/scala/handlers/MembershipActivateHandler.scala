package handlers

import services.NotificationService
import repositories.MembershipRepository
import domain.ProductCategory
import domain.Payment

class MembershipActivateHandler(notificaitonService : NotificationService, membershipRepository: MembershipRepository ) {
  
    var _notificationService : NotificationService = notificaitonService
    var _membershipRepository : MembershipRepository = membershipRepository

    def run(payment : Payment) = {
        var customer = payment.order.customer
        var items = payment.order.items

        items.filter(_.hasCategory(ProductCategory.Membership))
            .map(item => _membershipRepository.findBySku(item.sku))
            .filter(_.isDefined)
            .foreach { membership =>
                payment.order.customer.addMembership(membership.get)
                _notificationService.notify(customer, membership.get)
            }
    }
}
