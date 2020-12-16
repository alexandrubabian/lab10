package commands;

import diagram.DiagramCanvas;
import diagram.DiagramComponent;

public class Resize implements DrawCommand{

    private DiagramCanvas canvas;

    private String id;

    private int percentage;

    public Resize(DiagramCanvas canvas, String id, int percentage) {
        this.canvas = canvas;
        this.id = id;
        this.percentage = percentage;
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

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    @Override
    public void execute() {
        canvas.getComponent(Integer.parseInt(id)).setWeight(canvas.getComponent(
                Integer.parseInt(id)).getWeight()*percentage/100);
        canvas.getComponent(Integer.parseInt(id)).setHeight(canvas.getComponent(
                Integer.parseInt(id)).getHeight()*percentage/100);
    }

    @Override
    public void undo() {
        canvas.getComponent(Integer.parseInt(id)).setWeight(canvas.getComponent(
                Integer.parseInt(id)).getWeight()*100/percentage);
        canvas.getComponent(Integer.parseInt(id)).setHeight(canvas.getComponent(
                Integer.parseInt(id)).getHeight()*100/percentage);
    }

    @Override
    public String toString() {
        return "Resize{" +
                "canvas=" + canvas +
                ", id=" + id +
                ", percentage=" + percentage +
                '}';
    }
}
