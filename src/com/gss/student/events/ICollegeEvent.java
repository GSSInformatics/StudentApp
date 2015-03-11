/**
 * 
 */
package com.gss.student.events;

import java.util.List;

/**
 * @author VAMSI KRISHNA
 *
 */
public interface ICollegeEvent {
	
	String getDate();
	
	List<IEventTime> getEvents();
}
