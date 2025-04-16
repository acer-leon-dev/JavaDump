package com.lacerdev.statistics;

import java.io.IOException;
import java.util.List;

public class ListUI {
    private ListTable table = new ListTable();

    ListUI(ListTable table) {
        this.table = table;
    }
    
    enum ListOption {
        SET,
        APPEND,
        DELETE,
        BACK,
        NONE;
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

    public void promptListModification(String[] args) throws IOException {
        System.out.printf("1. Set\n2. Append\n3. Delete\n0. Back\n");
        switch (getListOption()) {
            case ListOption.SET:
                promptSet();
                return;
            case ListOption.APPEND:
                promptAppend();
                return;
            case ListOption.DELETE:
                promptDelete();
                return;
            case ListOption.BACK:
                return;
            default:
                System.err.println();
                return;
        }
    }

    private String queryListName() throws IOException {
        final SystemInputBufferedReader reader = new SystemInputBufferedReader();
        final String name = reader.readLine();

        if (!table.hasList(name)) {
            System.err.printf("Error: List %s does not exist\n", name);
            System.err.printf("Couldn't find list. Going back to previous command.\n");
            return null;
        }

        return name;
    }

    private List<Double> queryListNumbers() throws IOException {
        NumberInputParser parser = new NumberInputParser();
        return parser.readNumbersAsList();
    }

    private boolean promptSet() throws IOException {
        // Get list name
        System.out.printf("Name of list to set:\n> ");
        String name = queryListName();

        // Null check
        if (name == null) {
            return false;
        }
        
        List<Double> oldList = table.getList(name);
        System.out.printf("Enter data to set (ctrl + d (Linux) or ctrl + z (Windows) to stop):\n");
        oldList = queryList();
        return true;
    }

    
    private boolean promptAppend() throws IOException {
        // Get list name
        System.out.printf("Name of list to append data to:\n> ");
        String name = queryListName();

        // Null check
        if (name == null) {
            return false;
        }

        // Add new stuff to list
        return table.getList(name).addAll(queryListNumbers());
    }

    private boolean promptDelete() throws IOException {
        // Get list name
        System.out.printf("Name of list to delete:\n> ");
        String name = queryListName();

        // Null check
        if (name == null) {
            return false;
        }

        if (!table.deleteList(name)) {
            System.err.printf("Error: Could not delete list.\n");
            return false;
        }

        return true;
    }

    private printList(String name) {
        list = table.getList(name);
        StringBuilder()

        int numColumns = Math.floor(table.length() / 10);
        for (int i = 0; i < numColumns; i++) {
            System.out.printf("\t")
            for (int j = 0; j < 10; j++) {
                list.at(i * 10 + j);
            }
        }

        System.out.printf("\t");
        for (int i = 0; i < table.length() % 10; i++) {
            System.out(list.at(numColumns * 10 + i));
        }

        
    }
    
}