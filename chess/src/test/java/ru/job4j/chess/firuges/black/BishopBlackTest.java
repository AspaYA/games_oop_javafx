package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.FigureNotFoundException;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.OccupiedCellException;
import ru.job4j.chess.firuges.Cell;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void positionC1wayTrue() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.position(), is(Cell.C1));
    }

    @Test
    public void copyD2wayTrue() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.copy(Cell.D2).position(), is(Cell.D2));
    }

    @Test
    public void wayTrue() throws ImpossibleMoveException {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] cells = bishopBlack.way(Cell.G5);
        assertThat(cells[0], is(Cell.D2));
        assertThat(cells[1], is(Cell.E3));
        assertThat(cells[2], is(Cell.F4));
        assertThat(cells[3], is(Cell.G5));
//        assertThat(1, is(1));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void wayFalse() throws ImpossibleMoveException {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] cells = bishopBlack.way(Cell.C2);
    }

    @Test
    public void isDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.isDiagonal(Cell.C1, Cell.G5), is(true));
    }

    @Test
    public void isDiagonalFalse() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.isDiagonal(Cell.C1, Cell.C2), is(false));
    }
}