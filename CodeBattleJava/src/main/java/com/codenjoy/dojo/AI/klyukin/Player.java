package com.codenjoy.dojo.AI.klyukin;

import com.codenjoy.dojo.AI.klyukin.figure.*;
import com.codenjoy.dojo.services.Command;
import com.codenjoy.dojo.tetris.client.Board;
import java.util.List;

public final class Player {
    private final Board board;

    public Player(Board board) {
        this.board = board;
    }

    public List<Command> play() {
        DIFigure di = new DIFigure(this.board.getGlass());

        FigureInterface figure = di.getFigure(this.board.getCurrentFigureType());

        figure.setX(this.board.getCurrentFigurePoint().getX());
        figure.setY(this.board.getCurrentFigurePoint().getY());

        return figure.getAnswer();
    }
}
