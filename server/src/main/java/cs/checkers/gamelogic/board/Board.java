package cs.checkers.gamelogic.board;

import cs.checkers.gamelogic.field.Field;
import cs.checkers.gamelogic.field.PlainField;
import cs.checkers.gamelogic.field.UnavailableField;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents board.
 */
public class Board {
    /**
     * Number of board's rows.
     */
    private int rows;
    /**
     * Number of board's columns.
     */
    private int cols;
    /**
     * Single instance of class object.
     */
    private static Board instance = new Board();
    /**
     * Array of fields which board has.
     * @see cs.checkers.gamelogic.field.Field
     */
    private Field[][] fields;

    /**
     * ArrayList of corners which belongs to board.
     * @see cs.checkers.gamelogic.board.Corner
     */
    private ArrayList<Corner> corners = new ArrayList<>();

    /**
     * Private constructor.
     */
    private Board() {}

    /**
     * Method to get a single instance of class.
     * @return signle instance of this class
     */
    public static Board getInstance() {
        return instance;
    }

    /**
     * Method which creates ArrayList of fields.
     * @param rows number of board's rows
     * @param cols number of board's columns
     */
    public void initializeFields(int rows, int cols) {
        fields = new Field[rows][cols];
        corners.clear();
    }

    /**
     * Method which sets proper field types (proper classes) for board.
     * @param row row of field to be set
     * @param col columns of field to be set
     * @param type type of field
     * @see cs.checkers.gamelogic.field.PlainField
     * @see cs.checkers.gamelogic.field.UnavailableField
     */
    public void setFieldType(int row, int col, String type) {
        if (type.equals("plain")) {
            fields[row][col] = new PlainField();
        } else if (type.equals("unavailable")) {
            fields[row][col] = new UnavailableField();
        }
        fields[row][col].setXY(row, col);
    }

    /**
     * Method that adds corners to board.
     * @param corner corner to be added
     */
    public void addCorner(Corner corner) {
        corners.add(corner);
    }

    /**
     * Getter for specified field.
     * @param row row of field to be returned
     * @param col column of field to be returned
     * @return field or null if row, col are wrong sizes
     */
    public Field getField(int row, int col) {

        if(row < rows && col < cols) {
            return fields[row][col];
        }
        return null;
    }

    /**
     * Getter for list which contains corners.
     * @return list of corners which belongs to board
     */
    public List<Corner> getCorners() {
        return corners;
    }

    /**
     * Setter for rows and columns.
     * @param rows rows of board
     * @param cols columns of board
     */
    public void setRowsAndCols(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }
}
