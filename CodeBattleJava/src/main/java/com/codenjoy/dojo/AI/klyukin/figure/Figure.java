package com.codenjoy.dojo.AI.klyukin.figure;

import com.codenjoy.dojo.services.Command;
import com.codenjoy.dojo.services.Point;
import com.codenjoy.dojo.tetris.client.GlassBoard;

import java.util.ArrayList;
import java.util.List;

abstract class Figure {
    protected GlassBoard glass;

    protected List<Command> result = new ArrayList<Command>();

    protected boolean freePoint = false;

    protected static int[][] matrix = new int[18][18];

    protected int x;
    protected int y;

    public Figure(GlassBoard glass) {
        this.glass = glass;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    protected void commandControl(int freeX) {

        if (x != freeX) {
            int distance = x - freeX;

            Command command = Command.LEFT;

            if (distance < 0) {
                command = Command.RIGHT;
            }

            distance = Math.abs(distance);

            while (distance > 0) {
                result.add(command);
                distance--;
            }
        }

        result.add(Command.DOWN);
    }
}
