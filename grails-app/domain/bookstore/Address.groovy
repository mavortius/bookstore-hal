package bookstore

class Address {

    String street
    String street2
    String city
    State state
    Integer zip

    static constraints = {
        street2 nullable: true
    }
}
