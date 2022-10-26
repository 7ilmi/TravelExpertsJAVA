package com.example.travelexpertsjava;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.util.ArrayList;

abstract class Table<O> {
    protected final String displayName;
    protected final ArrayList<String> columnNames;
    protected final AbstractDAO<?> dao;

    public Table(String displayName, AbstractDAO<?> dao) {
        this.dao = dao;
        this.displayName = displayName;
        columnNames = new ArrayList<String>();
    }

    public void setTableColumns(TableView<ObservableList<?>> tv){
        tv.getColumns().clear();
        for(int index=0; index<this.columnNames.size(); index++){
            final int j = index;
            String col = this.columnNames.get(index);
            TableColumn<ObservableList<?>, String> column = new TableColumn<ObservableList<?>, String>(col);
            //column.setCellValueFactory(new PropertyValueFactory<ObservableList<?>, String>(col));

            column.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList<?>, String>, ObservableValue<String>>) param -> {
                if(param.getValue().get(j) != null) { return new SimpleStringProperty(param.getValue().get(j).toString()); }
                else { return new SimpleStringProperty(""); }
            });

            column.setVisible(true);
            tv.getColumns().addAll(column);
        }
    }

    public void setTable(TableView<ObservableList<?>> tv, ObservableList<ObservableList<?>> data){
        data.clear();
        tv.getItems().clear();
        this.setTableColumns(tv);
        this.setTableData(data);
    }

    public abstract void setTableData(ObservableList<ObservableList<?>> data);

    public abstract void add(Stage stage) throws IOException;

    public abstract void edit(int id, Stage stage) throws IOException;

    public abstract void delete(int index);

    @Override
    public final String toString() {
        return displayName;
    }
}
