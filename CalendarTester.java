//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: CalendarTester
// Files: CalendarTester.java, CalendarPrinter.java
// Course: CS 300
//
// Author: Tavish Vats
// Email: tvats@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name: Aneesh Patil
// Partner Email: apatil6@wisc.edu
// Partner Lecturer's Name: Gary Dahl
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X_ Write-up states that pair programming is allowed for this assignment.
// _X_ We have both read and understood the course Pair Programming Policy.
// _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Students who get help from sources other than their partner and the course
// staff must fully acknowledge and credit those sources here. If you did not
// receive any help of any kind from outside sources, explicitly indicate NONE
// next to each of the labels below.
//
// Persons: TA - Vanshika Baoni
// Online Sources: None
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This class implements test methods, that checks if the methods implemented in
 * CalendarPrinter.java are working as expected If the methods in the CalendarPrinter.java fail, the
 * test methods return false, otherwise they return true.
 * 
 * @author Tavish Vats, Aneesh Patil
 *
 */
public class CalendarTester {

  /**
   * Checks whether CalendarPrinter.fullCenturiesContained() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testFullCenturiesContained() {
    // Scenario 1 - Year is 2
    if (CalendarPrinter.fullCenturiesContained(new Year(2)) != 0) {
      System.out.println(
          "Test failed. fullCenturiesContained() did not return the expected value for Year: 2");
      return false;
    }

    // Scenario 2 - Year is 20
    if (CalendarPrinter.fullCenturiesContained(new Year(2020)) != 20) {
      System.out.println(
          "Test failed. fullCenturiesContained() did not return the expected value for Year: 2020");
      return false;
    }

    // Scenario 3 - Year is 44444
    if (CalendarPrinter.fullCenturiesContained(new Year(44444)) != 444) {
      System.out.println(
          "Test failed. fullCenturiesContained() did not return the expected value for Year: 44444");
      return false;
    }

    return true;
  }

  /**
   * Checks whether CalendarPrinter.yearOffsetWithinCentury() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testYearOffsetWithinCentury() {
    // Scenario 1 - Year is 100
    if (CalendarPrinter.yearOffsetWithinCentury(new Year(100)) != 0) {
      System.out.println(
          "Test Failed. yearOffsetWithinCentury() did not return the expected value for Year: 100");
      return false;
    }

    // Scenario 2 - Year is 88887734
    if (CalendarPrinter.yearOffsetWithinCentury(new Year(88887734)) != 34) {
      System.out.println(
          "Test Failed. yearOffsetWithinCentury() did not return the expected value for Year: 88887734");
      return false;
    }

    // Scenario 3 - Year is 203333
    if (CalendarPrinter.yearOffsetWithinCentury(new Year(203333)) != 33) {
      System.out.println(
          "Test Failed. yearOffsetWithinCentury() did not return the expected value for Year: 203333");
      return false;
    }

    return true;
  }

  /**
   * Checks whether CalendarPrinter.fullCenturiesContained() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testIsLeapYear() {
    // Scenario 1 - Year is 2020 which is a leap year
    if (CalendarPrinter.isLeapYear(new Year(2020)) != true) {
      System.out
          .println("Test Failed. isLeapYear() did not return the expected value for Year: 2020");
      return false;
    }

    // Scenario 2 - Year is 3000 which isn't a leap year
    if (CalendarPrinter.isLeapYear(new Year(3000)) != false) {
      System.out
          .println("Test Failed. isLeapYear() did not return the expected value for Year: 3000");
      return false;
    }

    // Scenario 3 - Year is 12000 which is a leap year
    if (CalendarPrinter.isLeapYear(new Year(12000)) != true) {
      System.out
          .println("Test Failed. isLeapYear() did not return the expected value for Year: 12000");
      return false;
    }

    return true;
  }

  /**
   * Checks whether CalendarPrinter.numberOfDaysInMonth() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testNumberOfDaysInMonth() {
    // Scenario 1 - February 2020 should have 29 days
    Year year = new Year(2020);
    Month month = new Month(MonthOfYear.February, year);
    if (CalendarPrinter.numberOfDaysInMonth(month) != 29) {
      System.out.println(
          "Test Failed. numberOfDaysInMonth() did not return the expected value for - February 2020");
      return false;
    }

    // Scenario 2 - February 3000 should have 28 days
    Year year2 = new Year(3000);
    Month month2 = new Month(MonthOfYear.February, year2);
    if (CalendarPrinter.numberOfDaysInMonth(month2) != 28) {
      System.out
          .println("Test Failed. isLeapYear() did not return the expected value for February 3000");
      return false;
    }

    // Scenario 3 - December 24420 should have 31 days
    Year year3 = new Year(24420);
    Month month3 = new Month(MonthOfYear.December, year3);
    if (CalendarPrinter.numberOfDaysInMonth(month3) != 31) {
      System.out.println(
          "Test Failed. isLeapYear() did not return the expected value for December 24420");
      return false;
    }

    // Scenario 4 - April 2050 should have 30 days
    Year year4 = new Year(2050);
    Month month4 = new Month(MonthOfYear.April, year4);
    if (CalendarPrinter.numberOfDaysInMonth(month4) != 30) {
      System.out
          .println("Test Failed. isLeapYear() did not return the expected value for April 2050");
      return false;
    }

    return true;
  }

  /**
   * Checks whether CalendarPrinter.calcFirstDayOfWeekInMonth() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testCalcFirstDayOfWeekInMonth() {
    // Scenario 1 - August 2020 first day should be Saturday
    Year year = new Year(2020);
    Month month = new Month(MonthOfYear.August, year);
    if (CalendarPrinter.calcFirstDayOfWeekInMonth(month) != DayOfWeek.Saturday) {
      System.out.println(
          "Test Failed. calcFirstDayOfWeekInMonth() did not return the expected value for August 2020");
      return false;
    }

    // Scenario 2 - January 2016 first day should be Friday
    Year year2 = new Year(2016);
    Month month2 = new Month(MonthOfYear.January, year2);
    if (CalendarPrinter.calcFirstDayOfWeekInMonth(month2) != DayOfWeek.Friday) {
      System.out.println(
          "Test Failed. calcFirstDayOfWeekInMonth() did not return the expected value for January 2016");
      return false;
    }

    // Scenario 3 - February 2012 first day should be Wednesday
    Year year3 = new Year(2012);
    Month month3 = new Month(MonthOfYear.February, year3);
    if (CalendarPrinter.calcFirstDayOfWeekInMonth(month3) != DayOfWeek.Wednesday) {
      System.out.println(
          "Test Failed. calcFirstDayOfWeekInMonth() did not return the expected value for February 2012");
      return false;
    }

    // Scenario 4 - October 2019 first day should be Tuesday
    Year year4 = new Year(2019);
    Month month4 = new Month(MonthOfYear.October, year4);
    if (CalendarPrinter.calcFirstDayOfWeekInMonth(month4) != DayOfWeek.Tuesday) {
      System.out.println(
          "Test Failed. calcFirstDayOfWeekInMonth() did not return the expected value for June 2019");
      return false;
    }

    return true;
  }

  /**
   * Checks whether CalendarPrinter.dayOfWeekAfter() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testDayOfWeekAfter() {
    // Scenario 1 - The day after Friday should be Saturday
    if (CalendarPrinter.dayOfWeekAfter(DayOfWeek.Friday) != DayOfWeek.Saturday) {
      System.out
          .println("Test Failed. dayOfWeekAfter() did not return the expected value for Friday");
      return false;
    }

    // Scenario 2 - The day after Sunday should be Monday
    if (CalendarPrinter.dayOfWeekAfter(DayOfWeek.Sunday) != DayOfWeek.Monday) {
      System.out
          .println("Test Failed. dayOfWeekAfter() did not return the expected value for Saturday");
      return false;
    }

    // Scenario 3 - The day after Tuesday should be Wednesday
    if (CalendarPrinter.dayOfWeekAfter(DayOfWeek.Tuesday) != DayOfWeek.Wednesday) {
      System.out
          .println("Test Failed. dayOfWeekAfter() did not return the expected value for Monday");
      return false;
    }

    return true;
  }

  /**
   * Checks whether CalendarPrinter.monthOfYearAfter() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testMonthOfYearAfter() {
    // Scenario 1 - The month after April should be May
    if (CalendarPrinter.monthOfYearAfter(MonthOfYear.April) != MonthOfYear.May) {
      System.out
          .println("Test Failed. dayOfWeekAfter() did not return the expected value for April");
      return false;
    }

    // Scenario 2 - The month after December should be January
    if (CalendarPrinter.monthOfYearAfter(MonthOfYear.December) != MonthOfYear.January) {
      System.out
          .println("Test Failed. dayOfWeekAfter() did not return the expected value for December");
      return false;
    }

    // Scenario 3 - The month after July should be August
    if (CalendarPrinter.monthOfYearAfter(MonthOfYear.July) != MonthOfYear.August) {
      System.out
          .println("Test Failed. dayOfWeekAfter() did not return the expected value for November");
      return false;
    }

    return true;
  }

  /**
   * Checks whether CalendarPrinter.createNewMonth() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testCreateNewMonth() {
    // Scenario 1 - create April 2020
    Year year = new Year(2020);
    if (CalendarPrinter.createNewMonth(MonthOfYear.April, year)
        .equals(new Month(MonthOfYear.April, year))) {
      System.out.println(
          "Test Failed. createNewMonth() did not return the expected value for April 2020");
      return false;
    }

    // Scenario 2 - create January 1876
    Year year2 = new Year(1876);
    if (CalendarPrinter.createNewMonth(MonthOfYear.January, year2)
        .equals(new Month(MonthOfYear.January, year2))) {
      System.out.println(
          "Test Failed. dayOfWeekAfter() did not return the expected value for January 1876");
      return false;
    }

    // Scenario 3 - create February 2012
    Year year3 = new Year(2012);
    if (CalendarPrinter.createNewMonth(MonthOfYear.February, year3)
        .equals(new Month(MonthOfYear.February, year3))) {
      System.out.println(
          "Test Failed. dayOfWeekAfter() did not return the expected value for February 2012");
      return false;
    }

    return true;
  }

  /**
   * Calls the test methods implemented in this class and displays their output
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out.println("testFullCenturiesContained(): " + testFullCenturiesContained());
    System.out.println("testYearOffsetWithinCentury(): " + testYearOffsetWithinCentury());
    System.out.println("testIsLeapYear(): " + testIsLeapYear());
    System.out.println("testNumberOfDaysInMonth(): " + testNumberOfDaysInMonth());
    System.out.println("testcalcFirstDayOfWeekInMonth(): " + testCalcFirstDayOfWeekInMonth());
    System.out.println("testDayOfWeekAfter(): " + testDayOfWeekAfter());
    System.out.println("testMonthOfYearAfter(): " + testMonthOfYearAfter());
    System.out.println("testCreateNewMonth(): " + testCreateNewMonth());
  }
}