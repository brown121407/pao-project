package xyz._121407.school_management.gui;

import xyz._121407.school_management.entities.Identifiable;
import xyz._121407.school_management.repositories.IRepository;

import javax.swing.*;
import java.awt.*;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class EntityManagerPanel<T extends Identifiable> extends JPanel {
    protected IRepository<T> repository;

    protected JSplitPane splitPane = new JSplitPane();
    protected JList<T> list = new JList<>();
    protected DefaultListModel<T> model = new DefaultListModel<>();
    protected FormPanel<T> formPanel;

    protected void configureUI() {
        setLayout(new BorderLayout());

        add(splitPane, BorderLayout.CENTER);

        model.addAll(repository.getAll());

        list.setModel(model);
        list.getSelectionModel().addListSelectionListener(e -> {
            if (list.getSelectedValue() != null) {
                formPanel.fill(list.getSelectedValue());
            }
        });

        JButton createButton = new JButton("Create");
        createButton.addActionListener(e -> {
            list.getSelectionModel().clearSelection();
            formPanel.clear();
        });

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(createButton, BorderLayout.NORTH);
        leftPanel.add(new JScrollPane(list), BorderLayout.CENTER);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(new JScrollPane(formPanel), BorderLayout.NORTH);


        splitPane.setLeftComponent(leftPanel);
        splitPane.setRightComponent(rightPanel);
    }

    protected void configureFormEvents() {
        formPanel.onSubmit(entity -> {
            list.clearSelection();

            model.clear();
            model.addAll(repository.getAll());

            OptionalInt selectedIndex = IntStream.range(0, model.size())
                    .filter(i -> model.get(i).getId() == entity.getId())
                    .findFirst();

            if (selectedIndex.isPresent()) {
                list.setSelectedIndex(selectedIndex.getAsInt());
            }

            list.setSelectedIndex(entity.getId());
        });

        formPanel.onDelete(() -> {
            list.clearSelection();

            model.clear();
            model.addAll(repository.getAll());
        });
    }
}
