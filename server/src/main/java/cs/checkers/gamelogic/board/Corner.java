package cs.checkers.gamelogic.board;

import cs.checkers.gamelogic.field.Field;

import java.util.ArrayList;
import java.util.List;

public class Corner {
    private Corner oppositeCorner;
    private List<Field> fields = new ArrayList<>();

    public void setOppositeCorner(Corner oppositeCorner) {
        this.oppositeCorner = oppositeCorner;
    }

    public Corner getOppositeCorner() {
        return oppositeCorner;
    }

    public void addField(Field field) {
        fields.add(field);
    }

    public List<Field> getFields() {
        return fields;
    }
}