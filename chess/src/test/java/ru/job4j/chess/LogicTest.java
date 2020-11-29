package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.KingBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LogicTest {

    @Ignore()
    @Test
    public void move()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C2));
        logic.move(Cell.C1, Cell.H6);
    }

    @Test(expected = FigureNotFoundException.class)
    public void FigureNotFound()
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        Logic logic = new Logic();
        logic.move(Cell.C1, Cell.C2);
    }

    @Test(expected = OccupiedCellException.class)
    public void OccupiedCellException()
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        Logic logic = new Logic();
        logic.add(new KingBlack(Cell.G5));
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.G5);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void ImpossibleMoveException()
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.C2);
    }
}