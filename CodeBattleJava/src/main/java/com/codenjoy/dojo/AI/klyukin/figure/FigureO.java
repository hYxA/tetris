package com.codenjoy.dojo.AI.klyukin.figure;

import com.codenjoy.dojo.services.Command;
import com.codenjoy.dojo.tetris.client.GlassBoard;

import java.util.List;

public final class FigureO extends Figure implements FigureInterface {

    public FigureO(GlassBoard glass) {
        super(glass);
    }

    public List<Command> getAnswer() {

        for (int iy = 0; iy < matrix.length; iy++) {

            for (int cx = 0; cx < matrix[iy].length; cx++) {

                if (this.glass.isFree(cx, iy)) {

                    if (iy == 0) {

                        /**
                         *
                         *  00
                         *  ##
                         *  ##
                         *
                         */

                        if (
                                this.glass.isFree(cx, iy+1)
                                && this.glass.isFree(cx+1, iy+1)
                                && this.glass.isFree(cx+1, iy)
                                && this.glass.isFree(cx, iy+2)
                                && this.glass.isFree(cx+1, iy+2)
                        ) {
                            freePoint = true;
                        }
                    } else {

                        /**
                         *
                         *  00
                         *  ##
                         *  ##
                         *  11
                         *
                         */

                        if (this.glass.isFree(cx+1, iy)
                                && this.glass.isFree(cx+1, iy+1)
                                && this.glass.isFree(cx, iy+1)
                                && this.glass.isFree(cx, iy+2)
                                && this.glass.isFree(cx+1, iy+2)
                                && !this.glass.isFree(cx, iy-1)
                                && !this.glass.isFree(cx+1, iy-1)
                        ) {
                            freePoint = true;
                        }
                    }

                    if (freePoint) {
                        commandControl(cx);
                        break;
                    }

                }
            }

            if (freePoint) break;
        }

        return result;
    }
}
