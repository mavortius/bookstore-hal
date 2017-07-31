package bookstore


import grails.rest.*
import grails.converters.*

class ProductController extends RestfulController {
    static responseFormats = ['json']

    ProductController() {
        super(Product)
    }

    @Override
    Object index(Integer max) {
        params.max = Math.min(max ?: 10, 100)

        [
                productList :   listAllResources(params),
                productCount:   countResources(),
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
