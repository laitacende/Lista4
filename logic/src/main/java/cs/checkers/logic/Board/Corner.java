package cs.checkers.logic.Board;

import cs.checkers.logic.Field.Field;

import java.util.ArrayList;
import java.util.List;

public class Corner {
    private Corner oppositeCorner;
    private ArrayList<Field> fields = new ArrayList<>();

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