package com.codenjoy.dojo.AI.klyukin;

import com.codenjoy.dojo.AI.klyukin.figure.*;
import com.codenjoy.dojo.tetris.client.GlassBoard;
import com.codenjoy.dojo.tetris.model.Elements;

import java.util.HashMap;

public class DIFigure {
    private final HashMap<Elements, FigureInterface> hashMapFigure = new HashMap<Elements, FigureInterface>();

    public DIFigure(GlassBoard glass) {
        hashMapFigure.put(Elements.YELLOW, new FigureO(glass));
        hashMapFigure.put(Elements.BLUE, new FigureI(glass));
        hashMapFigure.put(Elements.CYAN, new FigureJ(glass));
        hashMapFigure.put(Elements.ORANGE, new FigureL(glass));
        hashMapFigure.put(Elements.GREEN, new FigureS(glass));
        hashMapFigure.put(Elements.RED, new FigureZ(glass));
        hashMapFigure.put(Elements.PURPLE, new FigureT(glass));
    }


    public FigureInterface getFigure(Elements s) {
        return hashMapFigure.get(s);
    }
}
