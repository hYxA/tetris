package com.codenjoy.dojo.AI.klyukin.figure;

import com.codenjoy.dojo.services.Command;
import com.codenjoy.dojo.tetris.client.GlassBoard;
import java.util.List;

public final class FigureI extends Figure implements FigureInterface {
    public FigureI(GlassBoard glass) {
        super(glass);
    }

    private void rotate(Command command) {
        if (
                !this.glass.isFree(x, y)
                        && !this.glass.isFree(x, y - 1)
                        && !this.glass.isFree(x, y - 2)
                        && !this.glass.isFree(x, y + 1)
        ) {
            result.add(command);
        }
    }

    public List<Command> getAnswer() {

        for (int iy = 0; iy < matrix.length; iy++) {

            for (int cx = 0; cx < matrix[iy].length; cx++) {

                if (this.glass.isFree(cx, iy)) {

                    if (iy == 0) {

                        /**
                         *
                         *  0000
                         *  ####
                         *
                         */

                        if (
                                this.glass.isFree(cx+1, iy)
                                && this.glass.isFree(cx+2, iy)
                                && this.glass.isFree(cx+3, iy)

                                && this.glass.isFree(cx, iy+1)
                                && this.glass.isFree(cx+1, iy+1)
                                && this.glass.isFree(cx+2, iy+1)
                                && this.glass.isFree(cx+3, iy+1)
                        ) {
                            rotate(Command.ROTATE_CLOCKWISE_90);
                            x -= 2;
                            freePoint = true;
                        }

                        /**
                         *
                         *  0
                         *  0
                         *  0
                         *  0
                         *  #
                         *  #
                         *  #
                         *  #
                         *
                         */

                        if (!freePoint) {
                            if (
                                    this.glass.isFree(cx, iy + 1)
                                    && this.glass.isFree(cx, iy + 2)
                                    && this.glass.isFree(cx, iy + 3)
                                    && this.glass.isFree(cx, iy + 4)
                                    && this.glass.isFree(cx, iy + 5)
                                    && this.glass.isFree(cx, iy + 6)
                                    && this.glass.isFree(cx, iy + 7)
                            ) {
                                freePoint = true;
                            }
                        }
                    } else {

                        /**
                         *
                         *  0000
                         *  ####
                         *  1111
                         *
                         */

                        if (
                                this.glass.isFree(cx+1, iy)
                                        && this.glass.isFree(cx+2, iy)
                                        && this.glass.isFree(cx+3, iy)
                                        && this.glass.isFree(cx, iy+1)
                                        && this.glass.isFree(cx+1, iy+1)
                                        && this.glass.isFree(cx+2, iy+1)
                                        && this.glass.isFree(cx+3, iy+1)
                                        && !this.glass.isFree(cx, iy-1)
                                        && !this.glass.isFree(cx+1, iy-1)
                                        && !this.glass.isFree(cx+2, iy-1)
                                        && !this.glass.isFree(cx+3, iy-1)
                        ) {
                            rotate(Command.ROTATE_CLOCKWISE_90);
                            x -= 2;
                            freePoint = true;
                        }

                        /**
                         *
                         *  0
                         *  0
                         *  0
                         *  0
                         *  #
                         *  #
                         *  #
                         *  #
                         *  1
                         *
                         */

                        if (!freePoint) {
                            if (
                                    this.glass.isFree(cx, iy + 1)
                                    && this.glass.isFree(cx, iy + 2)
                                    && this.glass.isFree(cx, iy + 3)
                                    && this.glass.isFree(cx, iy + 4)
                                    && this.glass.isFree(cx, iy + 5)
                                    && this.glass.isFree(cx, iy + 6)
                                    && this.glass.isFree(cx, iy + 6)
                                    && !this.glass.isFree(cx, iy -1)
                            ) {
                                freePoint = true;
                            }
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
