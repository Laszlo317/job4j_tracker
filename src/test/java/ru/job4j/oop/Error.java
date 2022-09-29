package ru.job4j.oop;

public class Error {
    boolean active;
    int status;
    String message;

    public Error() { }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void getStatus() {
        System.out.println("active: " + active + "\nstatus: " + status + "\nmessage: "
                + message);
    }

    public static void main(String[] args) {
        Error errEmpty = new Error();
        Error err1 = new Error(false, 0, "...fine");
        Error err2 = new Error(true, 1, "Error!");
        errEmpty.getStatus();
        err1.getStatus();
        err2.getStatus();
    }
}
