
package handlers

import domain.*

class AgentCommissionHandler extends PaymentHandler {

    def run(payment : Payment) = {

        var isCommissionable = payment.order.items
            .exists(item => item.hasCategory(ProductCategory.Books) || item.hasCategory(ProductCategory.Physical))

        if (isCommissionable) payment.order.agent.generateCommission{payment.order};
    }
}