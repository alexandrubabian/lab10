package main;

import commands.*;

import java.util.Deque;
import java.util.LinkedList;

/**
 * The layer between the client and the commands that need to be executed on the receivers (DiagramCanvas and DiagramComponent).
 * <br>
 * It is independent of the subtypes of commands, it just receives a command, runs it and implements a redo/undo mechanism.
 */
public class Invoker {

    LinkedList<DrawCommand> orderList = new LinkedList<>();
    LinkedList<DrawCommand> undoList = new LinkedList<>();
    /**
     * Clear up all the used resources, start fresh :D
     */
    public void restart() {
      // TODO
    orderList.clear();
    undoList.clear();
    }

    /**
     * Executes a given command
     * @param command
     */
    public void execute(DrawCommand command) {
        orderList.add(command);
        undoList.clear();
    }

    /**
     * Undo the latest command
     */
    public void undo() {
        DrawCommand undone;
        if(orderList.size()>0) {
            undone = orderList.removeLast();
            undoList.add(undone);
            undone.undo();
        }
        // TODO
        // Hint: use data structures to keep track of commands
        // Do not use the java.util.Stack, its implementation is based on vector which is inefficient and deprecated.
        // Use a class that implements the Deque interface, e.g. LinkedList https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Deque.html
    }

    /**
     * Redo command previously undone. Cannot perform a redo after an execute, only after at least one undo.
     */
    public void redo() {
        // TODO
        DrawCommand redone;
        if(undoList.size()>0) {
            redone = undoList.removeLast();
            redone.execute();
            orderList.add(redone);
        }
    }
}
