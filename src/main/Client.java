package main;

import commands.*;
import diagram.DiagramCanvas;

/**
 * Receives commands in clear text from the user and transforms them in DrawCommand objects. It uses the Invoker to
 * execute the given commands.
 */
public class Client {

    private Invoker invoker;
    private DiagramCanvas diagramCanvas;

    Client() {
        invoker = new Invoker();
        diagramCanvas = new DiagramCanvas();
    }

    public void showDiagram() {
        this.diagramCanvas.show();
        // TODO
    }

    public void newDiagram() {
        invoker.restart();
        this.diagramCanvas = new DiagramCanvas();
        // TODO
    }

    public void executeAction(String commandName, String ...args) {
        // TODO - uncomment:
        DrawCommand command;
        try {
            CommandType commandType = CommandType.fromString(commandName);
            command = getCommand(commandType, args);
            if (command == null) {
                throw new IllegalArgumentException();
            }

        } catch(IllegalArgumentException ex) {
            System.out.println("Invalid command: " + commandName);
            System.out.println("Available commands:");
            for (CommandType type : CommandType.values()) {
                System.out.println("\t- " + type.text);
            }
            return;
        }
        command.execute();
        invoker.execute(command);
        // TODO - Execute the action

    }

    private DrawCommand getCommand(CommandType type, String ...args) throws IllegalArgumentException {
        // TODO factory method to create DrawCommand subclasses.
        // If there is an exception when parsing the string arguments (NumberFormatException) catch it and
        // throw an IllegalArgumentException
        try {
            if(type.equals(CommandType.CHANGE_COLOR)) {
                return new ChangeColor(diagramCanvas, args[0],args[1]);
            } else if(type.equals(CommandType.CONNECT)) {
                return new ConnectComponents(diagramCanvas, args[0], args[1]);
            } else if(type.equals(CommandType.CHANGE_TEXT)) {
                return new ChangeText(diagramCanvas,args[0], args[1]);
            } else if(type.equals(CommandType.DRAW_RECTANGLE)) {
                return new DrawRectangle(diagramCanvas);
            } else if(type.equals(CommandType.RESIZE)) {
                return new Resize(diagramCanvas, args[0], Integer.parseInt(args[1]));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Not good");
        }
        return null;
    }

    public void undo(){
        // TODO
        invoker.undo();
    }

    public void redo() {
        // TODO
        invoker.redo();
    }
}
