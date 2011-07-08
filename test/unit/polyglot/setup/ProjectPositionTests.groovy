package polyglot.setup

import grails.test.*
import org.junit.Test

class ProjectPositionTests extends GrailsUnitTestCase {

    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    @Test
    void calculateTotalHoursReturnsStartDateMinusEndDateTimesHoursPerDay_PrettyJava() {
        Date startDate = new Date() - 2
        Date endDate = new Date()
        ProjectPosition position = new ProjectPosition()
        position.setStartDate(startDate)
        position.setEndDate(endDate)
        position.setHoursPerDay(8.0)

        Double totalHours = position.calculateTotalHours()

        assert 16.0 == totalHours
    }

    @Test
    void calculateTotalHoursReturnsStartDateMinusEndDateTimesHoursPerDay_NoticeNotCallingGettersAndSetters() {
        Date startDate = new Date() - 2
        Date endDate = new Date()
        ProjectPosition position = new ProjectPosition()
        position.startDate = startDate
        position.endDate = endDate
        position.hoursPerDay = 8.0

        Double totalHours = position.calculateTotalHours()

        assert 16.0 == totalHours
    }

    @Test
    void calculateTotalHoursReturnsStartDateMinusEndDateTimesHoursPerDay_UsingConstructorThatTakesAMapOfProperties() {
        def position = new ProjectPosition(startDate: new Date() - 2, endDate: new Date(), hoursPerDay: 8.0)

        def totalHours = position.calculateTotalHours()

        assert 16.0 == totalHours
    }

    @Test
    void instanceLevelMetaClassingWillOnlyApplyToTheInstanceBeingMetaClassed() {
        Date date1 = new Date()
        date1.metaClass.someNewCoolMethodThatReturnsMyName = {return "Jarred"}
        assert "Jarred" == date1.someNewCoolMethodThatReturnsMyName()
        assert Date.class == date1.getClass()
        Date date2 = new Date()
        try {
            date2.someNewCoolMethodThatReturnsMyName()
            fail "should not get here"
        } catch (Exception ex) {}
    }

    @Test
    void classLevelMetaClassingWillApplyToAllInstanceOfTheTypeBeingMetaClassed() {
        Date.metaClass.'static'.someNewCoolMethodThatReturnsMyName = {return "Jarred"}
        
        Date date1 = new Date()
        assert "Jarred" == date1.someNewCoolMethodThatReturnsMyName()
        Date date2 = new Date()
        assert "Jarred" == date2.someNewCoolMethodThatReturnsMyName()
        assert Date.class == date1.getClass()
    }

    @Test
    void hibernateFromUnitTest() {
        def project = new Project(name:"Project 1")
        def position1 = new ProjectPosition(name:"ProjectPosition 1", project: project)
        def position2 = new ProjectPosition(name:"ProjectPosition 2", project: project)
        /*
        mockDomain adds all of the dynamic Hibernate finder methods to domain classes in unit tests.
        The second parameter a list of objects adds them to your in memory hibernate session.
         */
        mockDomain ProjectPosition, [position1, position2]

        def hibernateResults = ProjectPosition.findAllByProject(project)

        assert 2 == hibernateResults.size()
        assert "ProjectPosition 1" == hibernateResults[0].name
        assert "ProjectPosition 2" == hibernateResults[1].name
    }
}
