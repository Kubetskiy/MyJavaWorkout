public class GameBoard {
    Cell board[][];   // двумерный массив "игральная доска", состоящий из ячеек объектов типа Cell
    final int boardSize;

    // конструктор имеет параметр, размерность доски 5x5, 4x4 для шахматной 8x8, т.е. делает только
    // симметричны игральные доски
    GameBoard(int sizeBoard) {
        board = new Cell[sizeBoard][sizeBoard];   // двумерный массив --> доска
        boardSize = sizeBoard;

        for(int i=0; i < sizeBoard; i++)      {
            for(int j=0; j < sizeBoard; j++) {
                board[i][j] = new Cell(i,j);       // заполняем доску объектами типа Cell.
            } // end for j
        } // end for i

        setIgrWes();   // расставляет игровые веса (сколько ходов можно сделать с данной позиции) для
        // клеток доски. например, с угловых полей, конь может сделать 2 хода
        // на игровых весах строится стратегимя обхода всей доски
    } // end constructor

    final void setIgrWes() {    // i - строки, j - столбцы
        int tmpWes = 0;

        for(int i = 0; i < boardSize; i++)      {
            for(int j = 0; j < boardSize; j++) {
                // если (i -+ 2 то j -+ 1) и (i -+ 1 то j -+ 2) - условие хождения коня
                //  --------------------------------------------------------------------------------  направление дальний верх  (i - 2)
                if((i - 2 >= 0) && (j - 1 >= 0)) {
                    if(!getCell(i - 2,j - 1).getUse()) {   // если там ячейка, то ее getUse() = false
                        ++tmpWes;
                    } // end if !getCell
                } // end i-2, j-1 верх, лево
                if((i - 2 >= 0) && (j + 1 <= boardSize - 1)) {
                    if(!getCell(i - 2,j + 1).getUse()) {   // если там ячейка, то ее getUse() = false
                        ++tmpWes;
                    } // end if !getCell
                } // end i-2, j-1 верх, право
                //  -----------------------------------------------------------------------------------  направление дальний низ  (i + 2)
                if((i + 2 <= boardSize - 1) && (j - 1 >= 0)) {
                    if(!getCell(i + 2,j - 1).getUse()) {    // если там ячейка, то ее getUse() = false т.к. доска еще пуста
                        ++tmpWes;
                    } // end if !getCell
                } // end i-2, j-1 вниз, лево
                if((i + 2 <= boardSize - 1) && (j + 1 <= boardSize - 1)) {
                    if(!getCell(i + 2,j + 1).getUse()) {   // если там ячейка, то ее getUse() = false
                        ++tmpWes;
                    } // end if !getCell
                } // end i-2, j-1 вниз, право

                //  ------------------------------------  направление ближний вверх  (i - 1)
                if((i - 1 >= 0) && (j - 2 >= 0)) {
                    if(!getCell(i - 1,j - 2).getUse()) {   // если там ячейка, то ее getUse() = false
                        ++tmpWes;
                    } // end if !getCell
                } // end i-1, j-2 ближний верх, лево
                if((i - 1 >= 0) && (j + 2 <= boardSize - 1)) {
                    if(!getCell(i - 1, j + 2).getUse()) {   // если там ячейка, то ее getUse() = false
                        ++tmpWes;
                    } // end if !getCell
                } // end i-1, j +2  ближний верх, право
                //  ------------------------------------  направление ближний низ  (i + 1)
                if((i + 1 <= boardSize - 1) && (j - 2 >= 0)) {
                    if(!getCell(i + 1,j - 2).getUse()) {   // если там ячейка, то ее getUse() = false
                        ++tmpWes;
                    } // end if !getCell
                } // end i+1, j-2 ближний низ, лево
                if((i + 1 <= boardSize - 1) && (j + 2 <= boardSize - 1)) {
                    if(!getCell(i + 1, j + 2).getUse()) {   // если там ячейка, то ее getUse() = false
                        ++tmpWes;
                    } // end if !getCell
                } // end i+1, j +2  ближний низ, право

                getCell(i, j).setCellWeight(tmpWes);
                tmpWes = 0;
            } // end for j
        } // end for i
    } // end setIgrWes

    void printBoard() {
        for(int i = 0; i < boardSize; i++)      {
            for(int j = 0; j < boardSize; j++) {
                board[i][j].showCellProp();
            } // end for j
            System.out.println("\n");
        } // end for i
    } // end printBoard

    Cell getCell(int row, int col) {
        return board[row][col];
    } // end getCell

}
