package polyglot.setup

class Position {

    String name
    Double hoursPerDay
    Date startDate
    Date endDate

    static constraints = {
    }

    private def calculateTotalHours() {
        (endDate - startDate) * hoursPerDay
    }

}
