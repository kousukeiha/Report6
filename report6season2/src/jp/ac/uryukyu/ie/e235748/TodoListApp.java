package jp.ac.uryukyu.ie.e235748;
import java.util.ArrayList;
import java.util.Scanner;

public class TodoListApp {
    private ArrayList<Task>tasks;//タスクのリスト
    private Scanner scanner;//ユーザー入力を受け取る

    public TodoListApp(){
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    //タスクを追加するメソッド
    public void addTask(String taskName){
        Task newTask = new Task(taskName);
        tasks.add(newTask);
        System.out.println("新しいタスクを追加しました:" + taskName);
    }

    //タスクを表示するメソッド
    public void showTasks(){
        if(tasks.isEmpty()){
            System.out.println("タスクはありません");
        }else{
            System.out.println("タスク一覧:");
            for (int i = 0; i < tasks.size(); i++){
                Task task = tasks.get(i);
                System.out.println((i + 1) + "." + task.getName() + " - 完了:" + task.isCompleted());
            }
        }
    }
    

    //タスクを完了状態にするメソッド
    public void completeTask(int index){
        if (index >= 0 && index < tasks.size()){
            Task task = tasks.get(index);
            task.complete();
            System.out.println("タスクを完了しました:" + task.getName());
        }else{
            System.out.println("無効なインデックスです");
        }
    }

    public void closeScanner(){
        scanner.close();
    }
}

