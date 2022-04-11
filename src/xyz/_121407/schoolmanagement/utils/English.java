package xyz._121407.schoolmanagement.utils;

public class English {
    public static String toOrdinal(int cardinal) {
        if (cardinal % 100 < 10 || cardinal % 100 > 19) {
            return cardinal + switch (cardinal % 10) {
                case 1 -> "st";
                case 2 -> "nd";
                case 3 -> "rd";
                default -> "th";
            };
        } else {
            return cardinal + "th";
        }
    }

    public static <T> String toHumanReadable(Class<T> klass) {
        return klass.getSimpleName().replaceAll(
                String.format("%s|%s|%s",
                        "(?<=[A-Z])(?=[A-Z][a-z])",
                        "(?<=[^A-Z])(?=[A-Z])",
                        "(?<=[A-Za-z])(?=[^A-Za-z])"
                ),
                " "
        );
    }
}
