package bookstore

class Order {

    String orderId
    BigDecimal shippingCost
    Date orderPlaced = new Date()
    Address shippingAddress

    static hasMany = [ products: Product ]

    static belongsTo = [ customer: Customer ]

    static mapping = {
        table 'CUS_ORDER'
    }

    BigDecimal getTotalPrice() {
        shippingCost + products*.price.sum()
    }
}