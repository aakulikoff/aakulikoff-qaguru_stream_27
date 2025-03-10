package pages.components;

import static com.codeborne.selenide.Selenide.$;
import static pages.RegistrationPage.*;

public class CalendarComponent {
    public void setDate (String year, String month, String day, String dayOfWeek) {
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
//        $(String.format("[aria-label='Choose %s, %s %s, %s']",
//                dayOfWeek, month, day, year)).click();
        $("[aria-label='Choose Sunday, August 2nd, 1987']").click();
    }
}
