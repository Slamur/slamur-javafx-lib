package com.slamur.lib.javafx.table.cell;

import java.awt.Color;
import java.util.function.Function;

import com.slamur.lib.javafx.InterfaceUtils;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.util.StringConverter;

public class ActivatingComboboxCell<ValueType, ItemType> extends ComboBoxTableCell<ValueType, ItemType> {

    private final Function<ValueType, Boolean> activatingCondition;

    public ActivatingComboboxCell(
            ObservableList<ItemType> items,
            Function<ValueType, Boolean> activatingCondition
    ){
        super(items);

        this.activatingCondition = activatingCondition;
    }

    public ActivatingComboboxCell(
            StringConverter<ItemType> converter,
            ObservableList<ItemType> items,
            Function<ValueType, Boolean> activatingCondition
            ){
        super(converter, items);

        this.activatingCondition = activatingCondition;
    }

    private void activate() {
        setEditable(true);
        InterfaceUtils.setBackgroundColor(this, Color.WHITE, 0.0);
    }

    private void deactivate() {
        setEditable(false);
        InterfaceUtils.setBackgroundColor(this, Color.BLACK, 0.5);
    }

    @Override
    public void updateItem(ItemType item, boolean empty) {
        super.updateItem(item, empty);

        activate();

        if (!empty && getTableRow() != null) {
            ValueType value = (ValueType) getTableRow().getItem();
            if (value != null && !activatingCondition.apply(value)) {
                deactivate();
            }
        }
    }
}
