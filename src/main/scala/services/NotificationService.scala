package services

import domain.Customer
import domain.Membership

class NotificationService {

    def notify(customer: Customer, membership: Membership) : Boolean = {
        throw new NotImplementedError()
    }
}
