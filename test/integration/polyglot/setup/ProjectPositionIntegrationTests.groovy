package polyglot.setup

import org.junit.Test


class ProjectPositionIntegrationTests extends GroovyTestCase {

    @Test
    void hibernateFromAnIntegrationTest() {
        def project = new Project(name: "Project 1", startDate: new Date() -2, endDate: new Date())
        def position1 = new ProjectPosition(name: "ProjectPosition 1", project: project, startDate: new Date() - 2, endDate: new Date(), hoursPerDay: 8.0)
        def position2 = new ProjectPosition(name: "ProjectPosition 2", project: project, startDate: new Date() - 2, endDate: new Date(), hoursPerDay: 8.0)
        /*
        From an integration test, instead of calling mockDomain as you would from a unit test, you simply save the objects.
        One drawback is your domain objects have to be valid as far as your domain constraints and database constraints are concerned.
        Adding failOnError:true to your save call will throw an exception if your object is invalid.
         */
        project.save(failOnError:true)
        position1.save(failOnError:true)
        position2.save(failOnError:true)

        def hibernateResults = ProjectPosition.findAllByProject(project)

        assert 2 == hibernateResults.size()
        assert "ProjectPosition 1" == hibernateResults[0].name
        assert "ProjectPosition 2" == hibernateResults[1].name
    }
}
