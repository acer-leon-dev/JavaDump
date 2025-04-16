package com.lacerdev.statistics;

import java.io.IOException;
import java.util.List;

public class ListUI {
    private ListTable listTable = new ListTable();

    ListUI(ListTable table) {
        listTable = table;
    }
    
    enum ListOption {
        SET("Set", "set"),
        APPEND("Append", "append to"),
        DELETE("Delete", "delete"),
        BACK(null, null),
        NONE(null, null);

        public final String bareInfiniteForm;
        public final String infinitiveForm;
        ListOption(String bareInfiniteForm, String infinitiveForm) {
            this.bareInfiniteForm = bareInfiniteForm;
            this.infinitiveForm = infinitiveForm;
        }
    }

    ListOption getListOption() throws IOException {
        char optionChar = (char)System.in.read();
        
        int optionID = optionChar - '0';
        return switch (optionID) {
            case 1 -> ListOption.SET;
            case 2 -> ListOption.APPEND;
            case 3 -> ListOption.DELETE;
            case 0 -> ListOption.BACK;
            default -> {
                System.err.println("Error: '" + optionChar + "' is not a valid option");
                yield ListOption.NONE;
            }
        };
    }

    public void promptListModifiction(String[] args) throws IOException {
        System.out.println(
            """
            1. Set
            2. Append
            3. Delete
            0. Back""");

        ListOption option = getListOption();
        switch (option) {
            case ListOption.SET:
                promptSet();
                break;
            case ListOption.APPEND:
                promptAppend();
                break;
            case ListOption.DELETE:
                promptDelete();
                break;
            case ListOption.BACK:
                return;
            default:
                System.err.println();
                return;
        }

//        if (option) {
//
//        }
    }

    private String queryListName() throws IOException {
        StringBuilder errorMessage = new StringBuilder();
        boolean error = false;

        SystemInputBufferedReader reader = new SystemInputBufferedReader();
        String name = reader.readLine();
        if (!listTable.hasList(name)) {
            error = true;
            errorMessage
                .append("Error: List ")
                .append(name)
                .append(" does not exist.\n");
        }
        
        if (error) {
            errorMessage.append("Couldn't find list. Going back to previous command.\n");
            System.err.print(errorMessage);
            return null;
        }

        return name;
    }

    private boolean promptSet() throws IOException {
        String name = queryListName();

        if (name == null) {
            System.err.println();
            return false;
        }

        List<Double> oldList = listTable.getList(name);
        oldList = queryList();
        return true;
    }

    private List<Double> queryList() throws IOException {
        NumberInputParser parser = new NumberInputParser();
        return parser.readNumbersAsList();
    }
    
    private boolean promptAppend() throws IOException {
        String name = queryListName();
        if (name == null) {
            return false;
        }

        List<Double> list = listTable.getList(name);
        return true;
    }

    private boolean promptDelete() throws IOException {
        String name = queryListName();
        if (name == null) {
            return false;
        }

        if (!listTable.deleteList(name)) {
            System.err.println("Error: Could not delete list.");
            return false;
        }

        return true;
    }
    
}