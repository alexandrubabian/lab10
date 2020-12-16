package commands;

import diagram.DiagramCanvas;

public class ChangeColor implements DrawCommand{

    private DiagramCanvas canvas;

    private String id;

    private String beforeColor;

    private String color;

    public ChangeColor(DiagramCanvas canvas, String id, String color) {
        this.canvas = canvas;
        this.id = id;
        this.color = color;
    }

    public String getBeforeColor() {
        return beforeColor;
    }

    public void setBeforeColor(String beforeColor) {
        this.beforeColor = beforeColor;
    }

    public DiagramCanvas getCanvas() {
        return canvas;
    }

    public void setCanvas(DiagramCanvas canvas) {
        this.canvas = canvas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void execute() {
        beforeColor = canvas.getComponent(Integer.parseInt(id)).getColor();
        canvas.getComponent(Integer.parseInt(id)).setColor(this.color);
    }

    @Override
    public void undo() {
    canvas.getComponent(Integer.parseInt(id)).setColor(beforeColor);
    }

    @Override
    public String toString() {
        return "ChangeColor{" +
                "canvas=" + canvas +
                ", id='" + id + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
