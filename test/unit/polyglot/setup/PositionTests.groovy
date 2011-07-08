package polyglot.setup

import grails.test.*
import org.junit.Test

class PositionTests extends GrailsUnitTestCase {

    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    @Test
    void calculateTotalHoursReturnsStartDateMinusEndDateTimesHoursPerDay() {
        Date startDate = new Date() - 2
        Date endDate = new Date()
        Position position = new Position()
        position.setStartDate(startDate)
        position.setEndDate(endDate)
        position.setHoursPerDay(8.0)

        Double totalHours = position.calculateTotalHours()

        assert 16.0 == totalHours
    }

    @Test
    void calculateTotalHoursReturnsStartDateMinusEndDateTimesHoursPerDay2() {
        Date startDate = new Date() - 2
        Date endDate = new Date()
        Position position = new Position()
        position.startDate = startDate
        position.endDate = endDate
        position.hoursPerDay = 8.0

        Double totalHours = position.calculateTotalHours()

        assert 16.0 == totalHours
    }

    @Test
    void calculateTotalHoursReturnsStartDateMinusEndDateTimesHoursPerDay3() {
        def position = new Position(startDate: new Date() - 2, endDate: new Date(), hoursPerDay: 8.0)

        def totalHours = position.calculateTotalHours()

        assert 16.0 == totalHours
    }

    @Test
    void someMetaClassingStuff() {
        Date date = new Date()
        date.metaClass.someNewCoolMethodThatReturnsMyName = {return "Jarred"}
        assert Date.class == date.getClass()
        assert "Jarred" == date.someNewCoolMethodThatReturnsMyName()
        assert Date.class == date.getClass()
    }

    @Test
    void someMetaClassingStuff2() {
        Date.metaClass.'static'.someNewCoolMethodThatReturnsMyName = {return "Jarred"}
        Date date = new Date()
        assert Date.class == date.getClass()
        assert "Jarred" == date.someNewCoolMethodThatReturnsMyName()
        assert Date.class == date.getClass()
    }
}
