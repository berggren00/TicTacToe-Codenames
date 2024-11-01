import java.util.List;
import static utils.Ansi.*;

public abstract class Board {
    protected List<List<Cell>> cells;
    protected int padding = 2;

    public Board() {
    }

    public Board(int numRows, int numCols) {
        this.cells = initialize(numRows, numCols);
    }

    protected abstract List<List<Cell>> initialize(int numRows, int numCols);

    public Cell getCell(int row, int col) {

        return cells.get(row).get(col);
    }
    public Cell getCellById(int id) {
        int numCols = cells.getFirst().size();
        int cellsCount = numCols * cells.size();
        if (id < cellsCount || id > 1) {
            int row = (id - 1) / numCols;
            int col = (id - 1) % numCols;
            return cells.get(row).get(col);
        } else {
            throw new IllegalArgumentException("Invalid cell id: " + id);
        }
    }

    public List<List<Cell>> getAllCells() {
        return cells;
    }

    protected int getLongestCellLength() {
        int maxStringLength = 0;
        for (List<Cell> cellRow : cells) {
            for (Cell cell : cellRow) {
                if (cell != null) {
                    maxStringLength = Math.max(maxStringLength, cell.toString().length());
                }
            }
        }
        return maxStringLength + padding * 2;
    }

    @Override
    public String toString() {
        String spacer = "\u00A0";
        StringBuilder out = new StringBuilder();
        int longestCellLength = getLongestCellLength();
        for (int i = 0; i < cells.size() * 3; i++) { //iterate 3 times for every cellrow of the board
                for (int j = 0; j < cells.getFirst().size(); j++) { //iterate once for every column
                    String colorCode = cells.get(i / 3).get(j).getColor();
                    out.append(BG + BOLD).append(colorCode);
                    if (i % 3 == 0) { //first row in cell
                        String cellId = cells.get(i / 3).get(j).getId()+"";
                        out.append(cellId);
                        out.append(spacer.repeat(longestCellLength-cellId.length()));
                    } else if (i % 3 == 1) { // Place original cell row in the middle of each block of three rows
                        int cellPaddingLeft = (longestCellLength - cells.get(i / 3).get(j).toString().length()) / 2;
                        int cellPaddingRight = (longestCellLength - cells.get(i / 3).get(j).toString().length()) - cellPaddingLeft;
                        out.append(spacer.repeat(cellPaddingRight));
                        out.append(cells.get(i / 3).get(j));
                        out.append(spacer.repeat(cellPaddingLeft));
                    } else { //third row in cell
                        out.append(spacer.repeat(longestCellLength)); //output the number of spacers equal to the length of the cell content
                    }
                    out.append(RESET).append(spacer);
                }
            out.append("\n");
            if (i % 3 == 2) {
                out.append("\n");
            }
        }
        return out.toString();
    }
}