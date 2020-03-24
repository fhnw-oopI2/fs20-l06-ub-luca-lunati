package ch.fhnw.oop2.tasky;

import javafx.scene.control.Button;

public class TaskUI extends Button {

	public TaskUI(String title, String id, String Description) {
		setText(title, id, Description);
		setMaxWidth(Double.MAX_VALUE);
	}
	private void setText(String title, String id, String Description) {
		setText("Title: " + title + "\n" + "ID: " + id + "\n" + Description);
	}

}
