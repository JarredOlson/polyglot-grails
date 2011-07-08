package polyglot.setup

class ProjectPosition {

    String name
    Double hoursPerDay
    Date startDate
    Date endDate
    Project project

    static constraints = {
    }

    private def calculateTotalHours() {
        (endDate - startDate) * hoursPerDay
    }

}
