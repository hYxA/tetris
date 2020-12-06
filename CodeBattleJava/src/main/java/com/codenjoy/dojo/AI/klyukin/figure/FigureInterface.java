package com.codenjoy.dojo.AI.klyukin.figure;

import com.codenjoy.dojo.services.Command;
import com.codenjoy.dojo.services.Point;
import com.codenjoy.dojo.tetris.client.GlassBoard;

import java.util.List;

public interface FigureInterface {

    List<Command> getAnswer();

    void setX(int x);

    void setY(int y);
}
