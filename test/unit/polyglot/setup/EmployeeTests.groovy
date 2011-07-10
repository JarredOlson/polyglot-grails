package polyglot.setup

import grails.test.GrailsUnitTestCase
import org.junit.Test
import com.legacy.java.Employee


class EmployeeTests extends GrailsUnitTestCase {

    @Test
    void employeeNameCanBe5Characters() {
        mockDomain Employee
        def employee = new Employee(name:"12345")

        employee.validate()

        assert null == employee.errors["name"]
    }
    
    @Test
    void employeeNameCanNotBeLongerThan5Characters() {
        mockDomain Employee
        def employee = new Employee(name:"123456")

        employee.validate()

        assert "maxSize" == employee.errors["name"]
    }
}
