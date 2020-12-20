package cs.checkers.gamelogic.board;

import cs.checkers.gamelogic.field.Field;

import java.util.ArrayList;
import java.util.List;

/**
 * Class which represents corner of board (represented by {@Link Board Board}).
 */
public class Corner {
    /**
     * Corner which is 'home' for player with this corner.
     */
    private Corner oppositeCorner;

    /**
     * List of fields which belong to this corner.
     * @see cs.checkers.gamelogic.board.Board
     */
    private List<Field> fields = new ArrayList<>();

    /**
     * Setter for oppositeCorner.
     * @param oppositeCorner opposite corner to be set for this one
     */
    public void setOppositeCorner(Corner oppositeCorner) {
        this.oppositeCorner = oppositeCorner;
    }

    /**
     * Getter for opposite corner.
     * @return oppositeCorner
     */
    public Corner getOppositeCorner() {
        return oppositeCorner;
    }

    /**
     * Method to add new fields to corner.
     * @param field field to be added
     */
    public void addField(Field field) {
        fields.add(field);
    }

    /**
     * Getter for list of fields.
     * @return list of fields that belongs to this corner.
     */
    public List<Field> getFields() {
        return fields;
    }

    /**
     * Method wchich determines if field belongs to this corner.
     * @param fieldToCheck field to check
     * @return true if field belongs to corner, false otherwise
     */
    public boolean ifFieldIsInCorner(Field fieldToCheck) {
        for (Field field: fields) {
            if (field.equals(fieldToCheck)) {
                return true;
            }
        }
        return false;
    }
}