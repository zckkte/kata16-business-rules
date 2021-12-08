package services

import domain.PackingSlip;
import domain.Order;

trait PackingSlipService {
    def generate(order : Order): PackingSlip
}
