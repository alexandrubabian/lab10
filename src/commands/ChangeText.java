package commands;

import diagram.DiagramCanvas;

public class ChangeText implements DrawCommand{

    private DiagramCanvas canvas;

    private String id;

    private String text;

    private String beforeText;

    public ChangeText(DiagramCanvas canvas, String id, String text) {
        this.canvas = canvas;
        this.id = id;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public String getBeforeText() {
        return beforeText;
    }

    public void setBeforeText(String beforeText) {
        this.beforeText = beforeText;
    }

    public DiagramCanvas getCanvas() {
        return canvas;
    }

    public void setCanvas(DiagramCanvas canvas) {
        this.canvas = canvas;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void execute() {
        beforeText = canvas.getComponent(Integer.parseInt(id)).getText();
        canvas.getComponent(Integer.parseInt(id)).setText(this.text);
    }

    @Override
    public void undo() {
        canvas.getComponent(Integer.parseInt(id)).setText(beforeText);
    }

    @Override
    public String toString() {
        return "ChangeText{" +
                "canvas=" + canvas +
                ", id='" + id + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
