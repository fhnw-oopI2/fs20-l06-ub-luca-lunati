package ch.fhnw.oop2.tasky;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TasksUI extends VBox {
	private Button buttonNew;
	private Button buttonRefresh;
	private HBox buttons;
	private HBox tasks;
	private static final int WIDTH = Starter.WIDTH * 2 / 3;

	public TasksUI() {
		initializeControls();
		layoutControls();
	}

	private void initializeControls() {
		tasks = new HBox();
		buttons = new HBox();
		buttonNew = new Button("New");
		buttonRefresh = new Button("Resfresh");

	}

	private void layoutControls() {
		setPadding(new Insets(10));

		buttons.setSpacing(10);
		buttons.getChildren().addAll(buttonNew, buttonRefresh);

		tasks.setPrefWidth(WIDTH);
		tasks.getChildren().addAll(
				Stream.of("Todo", "Doing", "Done").map(state -> createTaskList(state)).collect(Collectors.toList()));

		getChildren().addAll(tasks, buttons);
	}

	private VBox createTaskList(String state) {
		VBox listVBox = new VBox();
		listVBox.setPrefWidth(WIDTH / 3);
		listVBox.setPadding(new Insets(10));
		Label stateLabel = new Label(state);
		VBox taskVBox = new VBox();
		taskVBox.setId(state);

		//Fill with randomly generated tasks for fun
		List<TaskUI> randomList = new ArrayList<>();
		int number = (int)(Math.random()*7);
		Stream.iterate(0, n -> n + 1)
		.limit(number)
		.forEach(n -> randomList.add(new TaskUI("Title"+n,""+n,"Beschreibung...")));
		taskVBox.getChildren().addAll(randomList);

		taskVBox.setPrefHeight(Starter.HEIGHT * 0.8);
		taskVBox.setStyle(
				"-fx-padding: 10;" + "-fx-spacing: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 1;");
		listVBox.getChildren().addAll(stateLabel, taskVBox);
		return listVBox;
	}

}
