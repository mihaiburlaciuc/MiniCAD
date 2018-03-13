package main;

public enum FormTypes {
    LINE("LINE"),
    SQUARE("SQUARE"),
    RECTANGLE("RECTANGLE"),
    CIRCLE("CIRCLE"),
    TRIANGLE("TRIANGLE"),
    DIAMOND("DIAMOND"),
    POLYGON("POLYGON");

    private final String formName;

    FormTypes(final String formName) {
        this.formName = formName;
    }

    @Override
    public String toString() {
        return formName;
    }
}
