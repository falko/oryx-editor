package de.hpi.bpmn;

import java.util.ArrayList;
import java.util.List;

public abstract class Event extends Node {
	
	protected List<Assignment> assignments;
	
	public List<Assignment> getAssignments() {
		if (assignments == null)
			assignments = new ArrayList<Assignment>();
		return assignments;
	}
}
