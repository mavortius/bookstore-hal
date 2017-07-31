package bookstore


import grails.rest.*
import grails.converters.*

class OrderController extends RestfulController {
    static responseFormats = ['json']

    OrderController() {
        super(Order)
    }

    @Override
    Object index(Integer max) {
        params.max = Math.min(max ?: 10, 100)

        [
                orderList: listAllResources(params),
                orderCount: countResources(),
                max         :   params.max,
                offset      :   params.int("offset") ?: 0,
                sort        :   params.sort,
                order       :   params.order
        ]
    }

    @Override
    boolean getReadOnly() {
        true
    }
}
