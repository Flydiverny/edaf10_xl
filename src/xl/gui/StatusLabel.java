package xl.gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import xl.model.Status;

public class StatusLabel extends ColoredLabel implements Observer {
	private Status status;
	
    public StatusLabel(Status status) {
        super("", Color.WHITE);
        this.status = status;
        status.addObserver(this);
    }

    public void update(Observable observable, Object object) {
        this.setText(status.toString());
    }
}