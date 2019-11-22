package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private HashMap <Long, TimeEntry> timeEntries = new HashMap<>();

    private long currentID = 1L;
    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        long id = currentID++;
        TimeEntry newTimeEntry;
        newTimeEntry = new TimeEntry(id,
                timeEntry.getProjectId(),
                timeEntry.getUserId(),
                timeEntry.getDate(),
                timeEntry.getHours());

        timeEntries.put(id,newTimeEntry);

        return  newTimeEntry;

    }

    @Override
    public TimeEntry find(long id) {
        return timeEntries.get(id);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(timeEntries.values());
    }

    @Override
    public void delete(long id) {

        timeEntries.remove(id);

    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        if (find(id)==null) return null;
        TimeEntry updatedTimeEntry = new TimeEntry(id,
                timeEntry.getProjectId(),
                timeEntry.getUserId(),
                timeEntry.getDate(),
                timeEntry.getHours());

        timeEntries.replace(id,updatedTimeEntry);
        return updatedTimeEntry;



    }
}
