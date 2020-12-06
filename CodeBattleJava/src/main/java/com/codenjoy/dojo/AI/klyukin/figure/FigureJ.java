package com.codenjoy.dojo.AI.klyukin.figure;

import com.codenjoy.dojo.services.Command;
import com.codenjoy.dojo.tetris.client.GlassBoard;
import java.util.List;

public final class FigureJ extends Figure implements FigureInterface {
    public FigureJ(GlassBoard glass) {
        super(glass);
    }

    private void rotate(Command command) {
        if (!this.glass.isFree(x, y)
                && !this.glass.isFree(x, y - 1)
                && !this.glass.isFree(x - 1, y - 1)
                && !this.glass.isFree(x, y + 1)) {
            result.add(command);
        }
    }

    public List<Command> getAnswer() {

        for (int iy = 0; iy < matrix.length; iy++) {

            for (int cx = 0; cx < matrix[iy].length; cx++) {

                if (this.glass.isFree(cx, iy)) {

                    if (iy == 0) {

                        /**
                         *  000
                         *  ###
                         *  11#
                         *
                         */

                        if (this.glass.isFree(cx, iy + 1)
                                && this.glass.isFree(cx-1, iy + 1)
                                && this.glass.isFree(cx-2, iy + 1)
                                && this.glass.isFree(cx, iy + 2)
                                && this.glass.isFree(cx-1, iy + 2)
                                && this.glass.isFree(cx-2, iy + 2)
                                && !this.glass.isFree(cx - 1, iy)
                                && !this.glass.isFree(cx - 2, iy)
                        ) {
                            rotate(Command.ROTATE_CLOCKWISE_270);
                            x += 1;
                            freePoint = true;
                        }

                        /**
                         *  00
                         *  ##
                         *  #1
                         *  #1
                         */
                        if (!freePoint) {
                            if (this.glass.isFree(cx, iy + 1)
                                    && this.glass.isFree(cx, iy + 2)
                                    && this.glass.isFree(cx + 1, iy + 2)
                                    && this.glass.isFree(cx, iy + 3)
                                    && this.glass.isFree(cx + 1, iy + 3)
                                    && !this.glass.isFree(cx + 1, iy)
                                    && !this.glass.isFree(cx + 1, iy + 1)
                            ) {
                                rotate(Command.ROTATE_CLOCKWISE_180);
                                freePoint = true;
                            }
                        }

                        /**
                         *
                         *  000
                         *  #00
                         *  ###
                         */
                        if (!freePoint) {
                            if (
                                    this.glass.isFree(cx + 1, iy)
                                            && this.glass.isFree(cx + 2, iy)
                                            && this.glass.isFree(cx, iy + 1)
                                            && this.glass.isFree(cx, iy + 2)
                                            && this.glass.isFree(cx+1, iy + 1)
                                            && this.glass.isFree(cx+1, iy + 2)
                                            && this.glass.isFree(cx+2, iy + 1)
                                            && this.glass.isFree(cx+2, iy + 2)
                            ) {
                                rotate(Command.ROTATE_CLOCKWISE_90);
                                x -= 1;
                                freePoint = true;
                            }
                        }

                        /**
                         *
                         *  00
                         *  0#
                         *  0#
                         *  ##
                         */
                        if (!freePoint) {
                            if (
                                    this.glass.isFree(cx + 1, iy)
                                    && this.glass.isFree(cx + 1, iy + 1)
                                    && this.glass.isFree(cx + 1, iy + 2)
                                    && this.glass.isFree(cx, iy + 1)
                                    && this.glass.isFree(cx, iy + 2)
                                    && this.glass.isFree(cx, iy + 3)
                                    && this.glass.isFree(cx + 1, iy + 3)
                            ) {
                                x -= 1;
                                freePoint = true;
                            }
                        }


                    } else {

                        /**
                         *
                         *  000
                         *  ###
                         *  11#
                         *  111
                         *
                         */

                        if (
                                this.glass.isFree(cx, iy + 1)
                                        && this.glass.isFree(cx-1, iy + 1)
                                        && this.glass.isFree(cx-2, iy + 1)
                                        && this.glass.isFree(cx-2, iy + 2)
                                        && this.glass.isFree(cx-1, iy + 2)
                                        && this.glass.isFree(cx, iy + 2)
                                        && !this.glass.isFree(cx - 1, iy)
                                        && !this.glass.isFree(cx - 2, iy)
                                        && !this.glass.isFree(cx, iy-1)
                        ) {
                            rotate(Command.ROTATE_CLOCKWISE_270);
                            x += 1;
                            freePoint = true;
                        }

                        /**
                         *  000
                         *  #00
                         *  ###
                         * 1111
                         */
                        if (!freePoint) {
                            if (this.glass.isFree(cx + 1, iy)
                                    && this.glass.isFree(cx + 2, iy)
                                    && this.glass.isFree(cx, iy + 1)
                                    && this.glass.isFree(cx, iy + 2)
                                    && this.glass.isFree(cx + 1, iy + 1)
                                    && this.glass.isFree(cx + 1, iy + 2)
                                    && this.glass.isFree(cx + 2, iy + 1)
                                    && this.glass.isFree(cx + 2, iy + 2)
                                    && !this.glass.isFree(cx, iy - 1)
                                    && !this.glass.isFree(cx + 1, iy - 1)
                                    && !this.glass.isFree(cx + 2, iy - 1)
                            ) {
                                rotate(Command.ROTATE_CLOCKWISE_90);
                                x -= 1;
                                freePoint = true;
                            }
                        }

                        /**
                         *
                         *  00
                         *  0#
                         *  0#
                         *  ##
                         * 111
                         */
                        if (!freePoint) {
                            if (
                                this.glass.isFree(cx + 1, iy)
                                && this.glass.isFree(cx + 1, iy + 1)
                                && this.glass.isFree(cx + 1, iy + 2)
                                && this.glass.isFree(cx, iy + 1)
                                && this.glass.isFree(cx, iy + 2)
                                && this.glass.isFree(cx, iy + 3)
                                && this.glass.isFree(cx + 1, iy + 3)
                                && !this.glass.isFree(cx, iy - 1)
                                && !this.glass.isFree(cx+1, iy - 1)
                            ) {
                                x -= 1;
                                freePoint = true;
                            }
                        }

                        /**
                         *
                         *  00
                         *  ##
                         *  #1
                         *  #1
                         * 111
                         *
                         * или
                         *
                         *  00
                         *  ##
                         *  #1
                         *  #1
                         * 101
                         * 111
                         *
                         */
                        if (!freePoint) {
                            if (
                                    this.glass.isFree(cx, iy + 1)
                                            && this.glass.isFree(cx, iy + 2)
                                            && this.glass.isFree(cx + 1, iy + 2)
                                            && this.glass.isFree(cx, iy + 3)
                                            && this.glass.isFree(cx + 1, iy + 3)
                                            //&& !this.glass.isFree(cx, iy - 1)
                                            //&& (!this.glass.isFree(cx, iy - 1) || (this.glass.isFree(cx, iy - 1) && this.glass.isFree(cx, iy - 2) && this.glass.isFree(cx, iy - 3)))
                                            && (!this.glass.isFree(cx, iy - 1) || this.glass.isFree(cx, iy - 1))
                                            && !this.glass.isFree(cx+1, iy)
                                            && !this.glass.isFree(cx+1, iy+1)
                                            //&& !this.glass.isFree(cx, iy-2)

                            ) {
                                rotate(Command.ROTATE_CLOCKWISE_180);
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
