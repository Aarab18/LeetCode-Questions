class TaskManager {
    private final HashMap<Integer, int[]> taskMap;
    private final TreeSet<int[]> sortedTasks;

    public TaskManager(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        sortedTasks = new TreeSet<>((t1, t2) -> t2[2] != t1[2] ? t2[2] - t1[2] : t2[1] - t1[1]);

        for (List<Integer> task : tasks) {
            add(task.getFirst(), task.get(1), task.getLast());
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        int[] task = new int[] {userId, taskId, priority};
        taskMap.put(taskId, task);
        sortedTasks.add(task);
    }
    
    public void edit(int taskId, int newPriority) {
        int[] task = taskMap.get(taskId);
        sortedTasks.remove(task);
        task[2] = newPriority;
        sortedTasks.add(task);
    }
    
    public void rmv(int taskId) {
        int[] task = taskMap.remove(taskId);
        sortedTasks.remove(task);
    }
    
    public int execTop() {
        if (sortedTasks.isEmpty()) return -1;
        int[] task = sortedTasks.removeFirst();
        taskMap.remove(task[1]);
        return task[0];
    }
}
