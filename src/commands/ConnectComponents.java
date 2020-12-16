package commands;

import diagram.DiagramCanvas;

public class ConnectComponents implements DrawCommand{

    private DiagramCanvas canvas;

    private String id1;

    private String id2;

    public ConnectComponents(DiagramCanvas canvas, String id1, String id2) {
        this.canvas = canvas;
        this.id1 = id1;
        this.id2 = id2;
    }

    @Override
    public void execute() {
        canvas.getComponent(Integer.parseInt(id1)).connectTo(id2);
        canvas.getComponent(Integer.parseInt(id2)).connectTo(id1);
    }

    @Override
    public void undo() {
        canvas.getComponent(Integer.parseInt(id1)).removeConnection(id2);
        canvas.getComponent(Integer.parseInt(id2)).removeConnection(id1);
    }

    @Override
    public String toString() {
        return "ConnectComponents{" +
                "canvas=" + canvas +
                ", id1='" + id1 + '\'' +
                ", id2='" + id2 + '\'' +
                '}';
    }
}
