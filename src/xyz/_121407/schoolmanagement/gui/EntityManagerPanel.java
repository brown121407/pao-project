package xyz._121407.schoolmanagement.gui;

import xyz._121407.schoolmanagement.entities.Identifiable;
import xyz._121407.schoolmanagement.repositories.IRepository;

import javax.swing.*;
import java.awt.*;
import java.util.Comparator;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public abstract class EntityManagerPanel<T extends Identifiable> extends JPanel implements Refreshable {
    protected IRepository<T> repository;

    protected JSplitPane splitPane = new JSplitPane();
    protected JList<T> list = new JList<>();
    protected DefaultListModel<T> model = new DefaultListModel<>();
    protected FormPanel<T> formPanel;

    protected void configureUI() {
        setLayout(new BorderLayout());

        add(splitPane, BorderLayout.CENTER);

        model.addAll(repository.getAllSortedBy(Comparator.comparingInt(Identifiable::getId)));

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


        splitPane.setLeftComponent(leftPanel);
        splitPane.setRightComponent(new JScrollPane(formPanel));
    }

    protected void configureFormEvents() {
        formPanel.onSubmit(entity -> {
            list.clearSelection();

            model.clear();
            model.addAll(repository.getAllSortedBy(Comparator.comparingInt(Identifiable::getId)));

            OptionalInt selectedIndex = IntStream.range(0, model.size())
                    .filter(i -> model.get(i).getId() == entity.getId())
                    .findFirst();

            if (selectedIndex.isPresent()) {
                list.setSelectedIndex(selectedIndex.getAsInt());
            } else {
                list.setSelectedIndex(0);
            }
        });

        formPanel.onDelete(() -> {
            list.clearSelection();

            model.clear();
            model.addAll(repository.getAllSortedBy(Comparator.comparingInt(Identifiable::getId)));
        });
    }

    @Override
    public void refresh() {
        formPanel.refresh();
    }
}
