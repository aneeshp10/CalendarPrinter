
//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: CalendarPrinter
// Files: CalendarPrinter.java, CalendarTester.java
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
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class takes input from the user, and according to inputs creates and prints a month
 * calendar.
 * 
 * @author Tavish Vats, Aneesh Patil
 *
 */
public class CalendarPrinter {

  /**
   * Calculates the number of centuries (rounded down) between year 0 and the specified year. For
   * example, the year 2034 has the century index of 20 (as do the other years 2000-2099).
   * 
   * @param year to compute the century offset for
   * @return number of centuries between year 0 and the specified year
   */
  public static int fullCenturiesContained(Year year) {
    int num = year.intValue(); // gets the int value of the year
    int num2 = num / 100; // divide year by 100 and floors the value obtained
    return num2;
  }

  /**
   * Calculates the number of years between the specified year and the first year of its century.
   * For example, the year 2034 has the offset within its century of 34 (as do 1234 and 9999934).
   * 
   * @param year to compute the offset within century for
   * @return number of years between the specified year and the first year of century
   */
  public static int yearOffsetWithinCentury(Year year) {
    // yearOffset stores the difference between the year and the century times 100
    // For example if year = 2020, then yearOffset store 2020 - (20 * 100) = 20
    int yearOffset = year.intValue() - (CalendarPrinter.fullCenturiesContained(year) * 100);
    return yearOffset;
  }

  /**
   * This method computes whether the specified year is a leap year or not.
   * 
   * @param year is the year is being checked for leap-year-ness
   * @return true when the specified year is a leap year, and false otherwise
   */
  public static boolean isLeapYear(Year year) {
    int leapYear = year.intValue();
    // checks of every 4th year and every 4th century is divisible by 4 and 100
    // which also implies its divisible by 400. If tihs isn't true, the year is not
    // a leap year
    if (((leapYear % 4 == 0) && (leapYear % 100 != 0)) || (leapYear % 400 == 0)) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Calculates the number of days in the specified month, while taking into consideration whether
   * or not the specified month is in a leap year. Note: that this is calculated based on the
   * month's monthOfYear and year, and is NOT retrieved from the month's getDayCount() method. This
   * is because this method is used to generate the day objects that are stored within each month.
   * 
   * @param month to determine the number of days within (within its year)
   * @return the number of days in the specified month (between 28-31)
   */
  public static int numberOfDaysInMonth(Month month) {
    int numOfDays = 0; // stores the number of days
    // switch statement that assigns the number of days based on the month.
    switch (month.getMonthOfYear()) {
      case January:
        numOfDays = 31;
        break;
      case February:
        // if the year is a leap year. Assign numOfDays to be 29. If not then assign
        // numOfDays to be 28.
        if (isLeapYear(month.getYear())) {
          numOfDays = 29;
        } else {
          numOfDays = 28;
        }
        break;
      case March:
        numOfDays = 31;
        break;
      case April:
        numOfDays = 30;
        break;
      case May:
        numOfDays = 31;
        break;
      case June:
        numOfDays = 30;
        break;
      case July:
        numOfDays = 31;
        break;
      case August:
        numOfDays = 31;
        break;
      case September:
        numOfDays = 30;
        break;
      case October:
        numOfDays = 31;
        break;
      case November:
        numOfDays = 30;
        break;
      case December:
        numOfDays = 31;
        break;
    }
    return numOfDays;
  }

  /**
   * Calculates which day of the week the first day of the specified month falls on. Note: that this
   * is calculated based on the month's monthOfYear and year, and is NOT retrieved from the month's
   * getDayByDate(1) day. This is because this method is used to generate the day objects that are
   * stored within each month.
   * 
   * @param month within which we are calculate the day of week for the first day
   * @return DayOfWeek corresponding to the first day within the specified month
   */
  public static DayOfWeek calcFirstDayOfWeekInMonth(Month month) {
    int h = 0; // the day of the week, (0 = Saturday, 1 = Sunday, 2 = Monday, ..., 6 = Friday).
    int mInd = 0; // represents months (3 = March, 4 = April, 5 = May, ..., 14 = February).
    int firstDayInd = 0; // stores the index of the days array to be returned.
    DayOfWeek[] days = DayOfWeek.values(); // days array.
    int k = yearOffsetWithinCentury(month.getYear()); // century value
    int j = fullCenturiesContained(month.getYear()); // offset value
    // assigns mInd using a switch statemement based on the month.
    switch (month.getMonthOfYear()) {
      case January:
        mInd = 13;
        // if the month is January, decrement the value of offset
        // if offest is 0, make offest 99 and decrement century
        if (k == 0) {
          k = 99;
          j--;
        } else {
          k--;
        }
        break;
      case February:
        mInd = 14;
        // if the month is February, decrement the value of offset
        // if offest is 0, make offest 99 and decrement century
        if (k == 0) {
          k = 99;
          j--;
        } else {
          k--;
        }
        break;
      case March:
        mInd = 3;
        break;
      case April:
        mInd = 4;
        break;
      case May:
        mInd = 5;
        break;
      case June:
        mInd = 6;
        break;
      case July:
        mInd = 7;
        break;
      case August:
        mInd = 8;
        break;
      case September:
        mInd = 9;
        break;
      case October:
        mInd = 10;
        break;
      case November:
        mInd = 11;
        break;
      case December:
        mInd = 12;
        break;
    }
    // calculates the first day of a month.
    h = ((1 + ((13 * (mInd + 1)) / 5) + k + (k / 4) + (j / 4) + (5 * j)) % 7);
    // the following if statements assign the index of the day to be returned based
    // on the value of h.
    if (h == 0) {
      firstDayInd = DayOfWeek.Saturday.ordinal();
    }
    if (h == 1) {
      firstDayInd = DayOfWeek.Sunday.ordinal();
    }
    if (h == 2) {
      firstDayInd = DayOfWeek.Monday.ordinal();
    }
    if (h == 3) {
      firstDayInd = DayOfWeek.Tuesday.ordinal();
    }
    if (h == 4) {
      firstDayInd = DayOfWeek.Wednesday.ordinal();
    }
    if (h == 5) {
      firstDayInd = DayOfWeek.Thursday.ordinal();
    }
    if (h == 6) {
      firstDayInd = DayOfWeek.Friday.ordinal();
    }
    return days[firstDayInd];
  }

  /**
   * Calculates the day of the week that follows the specified day of week. For example, Thursday
   * comes after Wednesday, and Monday comes after Sunday.
   * 
   * @param dayBefore is the day of week that comes before the day of week returned
   * @return day of week that comes after dayBefore
   */
  public static DayOfWeek dayOfWeekAfter(DayOfWeek dayBefore) {
    DayOfWeek[] days = DayOfWeek.values(); // days array
    DayOfWeek theDay = DayOfWeek.Monday; // theDay stores the value to be returned
    // traverses through the days array. If dayBefore matches a value at index 'i'
    // in the array, then
    // make theDay equal to the day at index 'i + 1' and break
    // if dayBefore is the last index in the array. Then assign theDay to the day at
    // inex 0 and break.
    for (int i = 0; i < days.length; i++) {
      if (days[i] == dayBefore) {
        if (days[i] == days[(days.length) - 1]) {
          theDay = days[0];
          break;
        }
        theDay = days[i + 1];
        break;
      }
    }
    return theDay;
  }

  /**
   * Calculates the month of the year that follows the specified month. For example, July comes
   * after June, and January comes after December.
   * 
   * @param monthBefore is the month that comes before the month that is returned
   * @return month of year that comes after monthBefore
   */
  public static MonthOfYear monthOfYearAfter(MonthOfYear monthBefore) {
    MonthOfYear[] months = MonthOfYear.values();
    MonthOfYear theMonth = MonthOfYear.January;
    // traverses through the months array. If monthBefore matches a value at index
    // 'i' in the array, then
    // make theMonth equal to the month at index 'i + 1' and break
    // if monthBefore is the last index in the array. Then assign themonth to the
    // day at inex 0 and break.
    for (int i = 0; i < months.length; i++) {
      if (months[i] == monthBefore) {
        if (months[i] == months[(months.length) - 1]) {
          theMonth = months[0];
          break;
        }
        theMonth = months[i + 1];
        break;
      }
    }
    return theMonth;
  }

  /**
   * Creates a new month object and fully initializes with its corresponding days.
   * 
   * @param monthOfYear which month of the year this new month represents
   * @param year        in which this month is a part
   * @return reference to the newly created month object
   */
  public static Month createNewMonth(MonthOfYear monthOfYear, Year year) {
    int nxtDate = 1; // the first day of the month
    Month month = new Month(monthOfYear, year); // month object created
    DayOfWeek nextDay = calcFirstDayOfWeekInMonth(month); // the first day of the month
    Day days;
    // traverses through the for loop based on the number of days in that month
    // days object is created and the day is added to month, the nxtDate is incremented
    // and the nextDay is calculated using the dayOfWeekAfter method at every iteration
    for (int i = 0; i < numberOfDaysInMonth(month); i++) {
      days = new Day(nextDay, nxtDate, month);
      nextDay = dayOfWeekAfter(nextDay);
      month.addDay(days);
      nxtDate++;
    }
    return month;
  }

  /**
   * Prints the contents of the specified month object in calendar form. This printout should begin
   * with the Month an year of the month. The next line should contain the three letter
   * abbreviations for the seven days of the week. And then the dates of each day of that month
   * should follow: one week per line, with periods in positions of days that are a part of the
   * month before or after. For example, January 2020 should be printed as follows:
   *
   * January 2020 MON TUE WED THU FRI SAT SUN . . 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
   * 21 22 23 24 25 26 27 28 29 30 31 . .
   *
   * @param month which is to be printed by this method
   */
  public static void printMonth(Month month) {
    // prints the month and year.
    System.out.println(createNewMonth(month.getMonthOfYear(), month.getYear()));
    // prints the days of a week.
    System.out.println("MON TUE WED THU FRI SAT SUN");
    int num = 0; // stores total number of dots and dates
    int week = 0; // stores a value that indicates when to go to the next line.
    DayOfWeek day = calcFirstDayOfWeekInMonth(month); // stores the first day of that month.
    int dayInd = day.ordinal(); // stores index of the days in the days array
    // traverses through the array and adds dots before the first day of the week if necessary
    for (int i = 0; i < dayInd; i++) {
      System.out.print(" . " + " ");
    }
    // traverses through the array based on the number of days in the the month.
    // prints the value of j and goes to the next line based on
    // when the sum of dayInd and the current date j is divisible by 7
    // increments week every time new line is printed.
    for (int j = 1; j <= numberOfDaysInMonth(month); j++) {
      if (j < 10) {
        System.out.print(" " + j + "  ");
      } else {
        System.out.print(" " + j + " ");
      }
      if (((dayInd + j) % 7) == 0) {
        System.out.println("");
        week++;
      }
    }
    // num stores the total number of days in month
    // plus the dots before the first day in that month
    num = numberOfDaysInMonth(month) + dayInd;
    // if num is 35, no dots are needed at the end of the calendar.
    if (num != 35) {
      // week + 1 gives us the number of rows in the calender, calendar always has 7 columns
      // So, (week + 1) * 7 is the number of spaces in the calendar. The difference betweeen
      // total spaces and num will give us the number of dots to be printed at the end of the
      // calendar
      // for loop traverses through and prints out the dots at the end
      for (int j = 0; j < (((week + 1) * 7) - num); j++) {
        System.out.print(" . " + " ");
      }
      System.out.println(""); // goes to a new line at the end of the calendar
    }
    System.out.println(""); // goes to a new line at the end of the calendar
  }

  /**
   * Creates an array list of months that are initialized with their full complement of days. Prints
   * out each of these months in calendar form, and then returns the resulting ArrayList.
   * 
   * @param month of the year for the first month that is created and printed
   * @param year  that the first month created and printed is a part of
   * @param count is the total number of sequential months created and printed
   * @return the array list of months that this method generates and prints.
   */
  public static ArrayList<Month> createAndPrintMonths(MonthOfYear month, Year year, int count) {
    ArrayList<Month> months = new ArrayList<Month>(); // months array to be returned
    Month calendarMonth;
    // for loop runs based on the count
    // adds the new month using the creatNewMonth() to the ArrayList, creates a
    // new month object and prints it using the printMonth()
    // if the end of year has been reached, increment the the year
    // assign the month to the following month using monthOfYearAfter()
    for (int i = 0; i < count; i++) {
      months.add(createNewMonth(month, year));
      calendarMonth = new Month(month, year);
      printMonth(calendarMonth);
      if (month.ordinal() == 11) {
        year = new Year(year.intValue() + 1);
      }
      month = monthOfYearAfter(month);
    }
    return months;
  }

  /**
   * Driver for the CalendarPrinter Application. This program asks the user to enter an initial
   * month, an initial year, and the total number of months to create and display in calendar form.
   * 
   * @param args is not used by this program
   */
  public static void main(String[] args) {
    // print welcome message
    Scanner in = new Scanner(System.in);
    System.out.println("Welcome to the Calendar Printer.");
    System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
    // read input from the user
    System.out.print("Enter the month to begin calendar: ");
    String monthString = in.nextLine().trim();
    System.out.print("Enter the year to begin calendar: ");
    String yearString = in.nextLine().trim();
    System.out.print("Enter the number of months to include in this calendar: ");
    String countString = in.nextLine().trim();
    // convert user input into usable form
    monthString = monthString.substring(0, 3).toUpperCase();
    MonthOfYear month = null;
    for (int i = 0; i < MonthOfYear.values().length; i++)
      if (monthString.equals(MonthOfYear.values()[i].name().substring(0, 3).toUpperCase()))
        month = MonthOfYear.values()[i];
    Year year = new Year(Integer.parseInt(yearString.trim()));
    int count = Integer.parseInt(countString.trim());
    // create months and display them in calendar form
    System.out.println();
    createAndPrintMonths(month, year, count);
    // display thank you message
    System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
    System.out.println("Thanks, and have a nice day.");
    in.close();
  }
}
