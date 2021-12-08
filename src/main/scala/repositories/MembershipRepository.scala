package repositories

import domain.Membership

class MembershipRepository {
    def findBySku(sku : String) : Option[Membership] = {
       throw new NotImplementedError()
    }
}
