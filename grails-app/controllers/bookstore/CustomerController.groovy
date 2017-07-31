package bookstore


import grails.rest.*
import grails.converters.*

class CustomerController extends RestfulController {
    static responseFormats = ['json']

    CustomerController() {
        super(Customer)
    }

    @Override
    Object index(Integer max) {
        params.max = Math.min(max ?: 10, 100)

        [
                customerList: listAllResources(params),
                customerCount: countResources(),
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
