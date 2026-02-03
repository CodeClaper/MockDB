package mockdb.statements;

import mockdb.exception.UnsupportedColumnTypeException;
import mockdb.meta.ColumnType;
import mockdb.meta.MetaColumn;
import mockdb.meta.MetaTable;
import mockdb.store.Table;
import mockdb.utils.Assert;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.create.table.ColDataType;
import net.sf.jsqlparser.statement.create.table.ColumnDefinition;
import net.sf.jsqlparser.statement.create.table.CreateTable;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Create {

    public boolean createTable(Statement statement) {
        Assert.isTrue(statement instanceof CreateTable, "Statement type error.");
        Table table = this.generateTable((CreateTable) statement);
        return true;
    }

    private Table generateTable(CreateTable createTable) {
        return new Table()
                .setMetaTable(this.generateMetaTable(createTable));
    }

    private MetaTable generateMetaTable(CreateTable createTable) {
        return new MetaTable().setTableName(createTable.getTable().getName())

                .setMetaColumnList(this.generateMetaColumnList(createTable));}

    private List<MetaColumn> generateMetaColumnList(CreateTable createTable) {
        return createTable.getColumnDefinitions().stream()
                .map(this::convertMetaColumn)
                .collect(Collectors.toList());
    }

    public MetaColumn convertMetaColumn(ColumnDefinition columnDefinition) {
        return new MetaColumn()
                .setColumnName(columnDefinition.getColumnName())
                .setColumnType(this.convertColumnType(columnDefinition.getColDataType()))
                .setColumnLength(this.convertColumnLength(columnDefinition.getColDataType()));
    }

    private ColumnType convertColumnType(ColDataType colDataType) {
        String dataType = colDataType.getDataType().toUpperCase(Locale.ROOT);
        switch (dataType) {
            case "INT": return ColumnType.INT;
            case "VARCHAR": return ColumnType.VARCHAR;
            case "CHAR": return ColumnType.CHAR;
            default: throw new UnsupportedColumnTypeException("Unsupported column data: " + dataType);
        }
    }

    private int convertColumnLength(ColDataType colDataType) {
        if (colDataType.getArgumentsStringList() == null) return 0;
        else return Integer.parseInt(colDataType.getArgumentsStringList().get(0));
    }
}
