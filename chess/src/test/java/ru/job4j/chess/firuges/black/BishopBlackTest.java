package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.job4j.chess.firuges.Cell.*;

public class BishopBlackTest {
    @Test
    public void position() {
        Cell cell = C8;
        Figure bishopBlack = new BishopBlack(cell);
        assertThat(cell).isEqualTo(bishopBlack.position());
    }

    @Test
    public void copy() {
        Cell cell = F8;
        Figure start = new BishopBlack(cell);
        Figure dest = start.copy(cell);
        assertThat(cell).isEqualTo(dest.position());
    }

    @Test
    public void wayOK() {
        Figure bishopBlack = new BishopBlack(C1);
        Cell[] path = bishopBlack.way(G5);
        assertThat(path).isEqualTo(new Cell[]{D2, E3, F4, G5});
    }

    @Test
    public void wayException() {
        Cell startCell = C1;
        Cell finishCell = H5;
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> new BishopBlack(startCell).way(finishCell));
        assertThat(exception.getMessage()).isEqualTo(String.format(
                "Could not move by diagonal from %s to %s", startCell, finishCell));
    }
}
