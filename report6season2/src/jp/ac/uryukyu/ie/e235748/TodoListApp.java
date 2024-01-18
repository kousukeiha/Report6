package jp.ac.uryukyu.ie.e235748;
import java.util.ArrayList;
import java.util.Scanner;

public class TodoListApp {
    private ArrayList<Task>tasks;//タスクのリスト
    public Scanner scanner;//ユーザー入力を受け取る

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
            //もしタスクが空の場合
            System.out.println("タスクはありません");
        }else{
            System.out.println("\nタスク一覧:");
            for (int i = 0; i < tasks.size(); i++){
                Task task = tasks.get(i);
                System.out.println((i + 1) + "." + task.getName() + " \n- 完了:" + task.isCompleted());
            }
        }
    }

    //タスクを削除するメソッド
    public void removeTask(int index){
        if (index >= 0 && index < tasks.size()){
            //タスクの番号があった場あお
            Task removedTask = tasks.remove(index);
            System.out.println("タスクを削除しました:" + removedTask.getName());
        } else{
            //タスクの番号がない場合
            System.out.println("この番号のタスクはありません。");
        }
    }

    public void closeScanner(){
        scanner.close();
    }
}

