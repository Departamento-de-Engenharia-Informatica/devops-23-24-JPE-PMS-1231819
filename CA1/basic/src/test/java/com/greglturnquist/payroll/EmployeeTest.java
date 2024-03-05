package com.greglturnquist.payroll;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    private void assertInvalidEmployeeParameters_Exception(String firstName, String lastName, String description, int jobYears) {
        // Arrange
        String expected = "Invalid Parameters";

        // Act
        Exception exception = assertThrows(InstantiationException.class, () ->
                new Employee(firstName, lastName, description, jobYears));

        String result = exception.getMessage();

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void NullNameEmployee_InstantiationExceptionShouldBeThrown() {
        assertInvalidEmployeeParameters_Exception(null, "Smith", "Janitor", 20);
    }

    @Test
    void EmptyNameEmployee_InstantiationExceptionShouldBeThrown() {
        assertInvalidEmployeeParameters_Exception("", "Smith", "Janitor", 20);
    }

    @Test
    void EmptyTrimmedNameEmployee_InstantiationExceptionShouldBeThrown() {
        assertInvalidEmployeeParameters_Exception(" ", "Smith", "Janitor", 20);
    }

    @Test
    void NullLastNameEmployee_InstantiationExceptionShouldBeThrown() {
        assertInvalidEmployeeParameters_Exception("John", null, "Janitor", 20);
    }

    @Test
    void EmptyLastNameEmployee_InstantiationExceptionShouldBeThrown() {
        assertInvalidEmployeeParameters_Exception("John", "", "Janitor", 20);
    }

    @Test
    void EmptyTrimmedLastNameEmployee_InstantiationExceptionShouldBeThrown() {
        assertInvalidEmployeeParameters_Exception("John", " ", "Janitor", 20);
    }

    @Test
    void NullDescriptionEmployee_InstantiationExceptionShouldBeThrown() {
        assertInvalidEmployeeParameters_Exception("John", "Smith", null, 20);
    }

    @Test
    void EmptyDescriptionEmployee_InstantiationExceptionShouldBeThrown() {
        assertInvalidEmployeeParameters_Exception("John", "Smith", "", 20);
    }

    @Test
    void EmptyTrimmedDescriptionEmployee_InstantiationExceptionShouldBeThrown() {
        assertInvalidEmployeeParameters_Exception("John", "Smith", " ", 20);
    }

    @Test
    void NegativeJobYearsEmployee_InstantiationExceptionShouldBeThrown() {
        assertInvalidEmployeeParameters_Exception("John", "Smith", "Janitor", -1);
    }

    @Test
    void getFirstName() throws InstantiationException {
        String firstName = "John";
        String lastName = "Smith";
        String description = "Janitor";
        int jobYears = 7;
        // Arrange
        Employee employee = new Employee(firstName,lastName,description,jobYears);
        // Act
        String result = employee.getFirstName();
        // Assert
        assertEquals(firstName, result);
    }
    @Test
    void setAndGetFirstName()  {
        String firstName = "John";
        // Arrange
        Employee employee = new Employee();
        // Act
       employee.setFirstName(firstName);
       String result = employee.getFirstName();
        // Assert
        assertEquals(firstName, result);
    }

    @Test
    void setFirstName_InvalidName()  {
        String firstName = "";
        // Arrange
        Employee employee = new Employee();
        // Act
        employee.setFirstName(firstName);
        String result = employee.getFirstName();
        // Assert
        assertNull(result);
    }


    @Test
    void getAndSetLastName() {
        // Arrange
        Employee employee = new Employee();

        // Act
        employee.setLastName("Smith");
        String result = employee.getLastName();

        // Assert
        assertEquals("Smith", result);
    }

    @Test
    void setLastName_InvalidLastName()  {
        String lastName = "";
        // Arrange
        Employee employee = new Employee();
        // Act
        employee.setLastName(lastName);
        String result = employee.getLastName();
        // Assert
        assertNull(result);
    }

    @Test
    void getAndSetDescription() {
        // Arrange
        Employee employee = new Employee();

        // Act
        employee.setDescription("Janitor");
        String result = employee.getDescription();

        // Assert
        assertEquals("Janitor", result);
    }

    @Test
    void setDescription_InvalidDescription()  {
        String description = "";
        // Arrange
        Employee employee = new Employee();
        // Act
        employee.setDescription(description);
        String result = employee.getDescription();
        // Assert
        assertNull(result);
    }

    @Test
    void getAndSetJobYears() {
        // Arrange
        Employee employee = new Employee();

        // Act
        employee.setJobYears(5);
        int result = employee.getJobYears();

        // Assert
        assertEquals(5, result);
    }

    @Test
    void setJobYears_InvalidYear()  {
        int jobYear = -9;
        int expected = 0;
        // Arrange
        Employee employee = new Employee();
        // Act
        employee.setJobYears(jobYear);
        int result = employee.getJobYears();
        // Assert
        assertEquals(expected,result);
    }
}