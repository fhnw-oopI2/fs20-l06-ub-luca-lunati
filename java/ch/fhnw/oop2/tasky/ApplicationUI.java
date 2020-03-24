package ch.fhnw.oop2.tasky;

import javafx.scene.layout.HBox;

public class ApplicationUI extends HBox{
	private TasksUI tasksUI;
private CreateTaskUI createTaskUI;
public ApplicationUI(){
	initializeControls();
	layoutControls();
}
private void initializeControls() {
	tasksUI = new TasksUI();
	createTaskUI = new CreateTaskUI();
}
private void layoutControls() {
	// TODO Auto-generated method stub
	this.getChildren().addAll(tasksUI,createTaskUI);
	
}
}
