package commands;

import diagram.DiagramCanvas;
import diagram.DiagramComponent;

public class DrawRectangle implements DrawCommand{

    private DiagramCanvas canvas;

    public DrawRectangle(DiagramCanvas canvas) {
        this.canvas = canvas;
    }

    public DiagramCanvas getCanvas() {
        return canvas;
    }

    public void setCanvas(DiagramCanvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void execute() {
        canvas.addComponent(new DiagramComponent());
    }

    @Override
    public void undo() {
        canvas.removeComponent(canvas.getComponent(canvas.getComponents().size()-1));
    }

    @Override
    public String toString() {
        return "DrawRectangle{" +
                "canvas=" + canvas +
                '}';
    }
}
