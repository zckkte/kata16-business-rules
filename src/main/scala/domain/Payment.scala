
package domain

import handlers.PaymentHandler

class Payment(o: Order) {

    var order: Order = o

    def process(rules : List[PaymentHandler]) = rules foreach (_.run(this))
}