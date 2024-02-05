package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(job instanceof Job);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue());
        assertEquals("Quality control", job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Phil", new Employer("Government"), new Location("North Pole"), new PositionType("Snow Tester"), new CoreCompetency("Can bite into snow with teeth"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Phil", new Employer("Government"), new Location("North Pole"), new PositionType("Snow Tester"), new CoreCompetency("Can bite into snow with teeth"));
        String expectedString = "\n  \n";
        String actualString = job.toString();
        assertTrue(expectedString, actualString.startsWith("\n"));
        assertTrue(expectedString, actualString.endsWith("\n"));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Phil", new Employer("Government"), new Location("North Pole"), new PositionType("Snow Tester"), new CoreCompetency("Can bite into snow with teeth"));
        String expectedString = "\nID: 4\nName: Phil\nEmployer: Government\nLocation: North Pole\nPosition Type: Snow Tester\nCore Competency: Can bite into snow with teeth\n";
        String actualString = job.toString();
        assertEquals(expectedString, actualString);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("", new Employer("Government"), new Location("North Pole"), new PositionType("Snow Tester"), new CoreCompetency("Can bite into snow with teeth"));
        String expectedString = "\nID: 3\nName: Data not available\nEmployer: Government\nLocation: North Pole\nPosition Type: Snow Tester\nCore Competency: Can bite into snow with teeth\n";
        String actualString = job.toString();
        assertEquals(expectedString, actualString);
    }
}
