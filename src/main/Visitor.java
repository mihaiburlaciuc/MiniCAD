package main;

public interface Visitor {
    void visit(Line e);
    void visit(Square e);
    void visit(Rectangle e);
    void visit(Circle e);
    void visit(Triangle e);
    void visit(Diamond e);
    void visit(Polygon e);
}
