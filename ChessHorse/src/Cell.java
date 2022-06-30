public class Cell {
    private final int rowNumber;
    private final int columnNumber;
    private int cellWeight; // игровой вес ячейки на доске, т.е. на сколько соседних ячеек может пойти конь
    // например, для "угловых" ячеек, это поле будет = 2
    private boolean use = false;  // по умолчанию, ячейка игровой доски не использавалась
/*
    public Cell() {
        this.rowNumber = 0;
        this.columnNumber = 0;
    }*/
    public Cell(int initRow, int initColumn) {
        rowNumber = initRow;
        columnNumber = initColumn;
    } // конструкторы

    void setUseTrue() {
        use = true;
    }

    boolean getUse() {
        return use;
    }

    void showCellProp() {
        if(use) {
            System.out.print(" H " +  " | ");               // " H  | "
        } // end if
        else {
            System.out.print(rowNumber + "," + columnNumber + " | ");  // "X,Y | "
        } // end else
    } // end showCellProp

    int getRow() {
        return rowNumber;
    } // end getRow

    int getColumn() {
        return columnNumber;
    } // end getRow

    void setCellWeight(int cellWeight) {
        this.cellWeight = cellWeight;
    }
    int getCellWeight() {
        return cellWeight;
    }
}
