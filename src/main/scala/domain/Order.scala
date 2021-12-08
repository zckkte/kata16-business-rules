
package domain

class Order(initCustomer : Customer, intiItems : List[OrderItem], initAgent : Agent) {

    var customer : Customer = initCustomer

    var items : List[OrderItem] = intiItems

    var agent : Agent = initAgent;

}
