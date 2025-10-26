import java.util.*;


class Spreadsheet {
    private Map<String, Integer> spreadsheet;

    public Spreadsheet(int rows) {
        spreadsheet = new HashMap<>();
    }

    public void setCell(String cell, int value) {
        spreadsheet.put(cell, value);
    }

    public void resetCell(String cell) {
        spreadsheet.put(cell, 0);
    }

    public int getValue(String formula) {
        int plus = formula.indexOf('+');
        String left = formula.substring(1, plus);
        String right = formula.substring(plus + 1);
        return getToken(left) + getToken(right);
    }

    private int getToken(String token) {
        if (Character.isDigit(token.charAt(0))) {
            return Integer.parseInt(token);
        } else {
            return spreadsheet.getOrDefault(token, 0);
        }
    }
}
