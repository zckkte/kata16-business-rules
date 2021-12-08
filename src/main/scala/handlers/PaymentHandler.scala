
package handlers

import domain.Payment

trait PaymentHandler {

    def run(payment : Payment): Unit
}