package com.itbulls.learnit.javacore.multithreading.executors.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class DefaultRecursiveTask1  extends RecursiveTask<Integer> {

    private int workload = 0;

    public DefaultRecursiveTask1(int workload) {
        this.workload = workload;
    }

    @Override
    protected Integer compute() {
        if (this.workload < 18) {
            System.out.println("Doing workLoad myself in thread " + Thread.currentThread().getName()
                    + " with workload: " + this.workload);
            return  workload;
        } else {
            System.out.println("Splitting workLoad in thread " + Thread.currentThread().getName()
                    + " with workload: " + this.workload);


            return ForkJoinTask.invokeAll(createSubtasks()).stream()
                    .mapToInt(ForkJoinTask::join).sum();

        }

    }

    private List<DefaultRecursiveTask> createSubtasks() {
        List<DefaultRecursiveTask> subtasks = new ArrayList<>();
        DefaultRecursiveTask subtask1 = null;
        DefaultRecursiveTask subtask2 = null;
        if (workload % 2 == 0) {
            subtask1 = new DefaultRecursiveTask(this.workload / 2);
            subtask2 = new DefaultRecursiveTask(this.workload / 2);
        } else {
            subtask1 = new DefaultRecursiveTask(this.workload / 2 + 1);
            subtask2 = new DefaultRecursiveTask(this.workload / 2);
        }
        subtasks.add(subtask1);
        subtasks.add(subtask2);

        return subtasks;
    }
}
