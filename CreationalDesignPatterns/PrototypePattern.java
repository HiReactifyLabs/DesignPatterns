import java.util.*;

interface Document {
    Document clone();
    void print();
}



class Report implements Document {
    private String title;
    private String content;

    public Report(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public Document clone() {
        return new Report(this.title, this.content);
    }

    @Override
    public void print() {
        System.out.println("Report: " + title);
        System.out.println("Content: " + content);
    }
}

class Spreadsheet implements Document {
    private String title;
    private int[][] data;

    public Spreadsheet(String title, int[][] data) {
        this.title = title;
        this.data = data;
    }

    @Override
    public Document clone() {
        // Deep copy the data array
        int[][] dataCopy = new int[data.length][];
        for (int i = 0; i < data.length; i++) {
            dataCopy[i] = data[i].clone();
        }
        return new Spreadsheet(this.title, dataCopy);
    }

    @Override
    public void print() {
        System.out.println("Spreadsheet: " + title);
        System.out.print("Data: ");
        for (int[] row : data) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}


public class PrototypePattern {
    public static void main(String[] args) {
        // Create a Report instance
        Report originalReport = new Report("Annual Report", "This is the content of the annual report.");
        originalReport.print();

        // Clone the Report
        Report clonedReport = (Report) originalReport.clone();
        clonedReport.print();

        // Create a Spreadsheet instance
        int[][] data = {{1, 2, 3}, {4, 5, 6}};
        Spreadsheet originalSpreadsheet = new Spreadsheet("Financial Data", data);
        originalSpreadsheet.print();

        // Clone the Spreadsheet
        Spreadsheet clonedSpreadsheet = (Spreadsheet) originalSpreadsheet.clone();
        clonedSpreadsheet.print();
    }
}
