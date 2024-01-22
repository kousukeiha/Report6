package jp.ac.uryukyu.ie.e235748;
//import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        TodoListApp todoListApp = new TodoListApp();
        boolean exit = false;
        

        while(!exit){
            System.out.println("\n番号を選択してください");
            System.out.println("①.タスク追加");
            System.out.println("②.タスク一覧表示");
            System.out.println("③.終了");
            System.out.println("④.タスクを削除");
            System.out.print("選択 >>>> ");

            int choice = todoListApp.scanner.nextInt();//選択した番号を受け取る

            switch(choice){
                
                //タスク追加
                case 1:
                System.out.print("タスク名を入力してください:");
                todoListApp.scanner.nextLine();//改行読み飛ばし
                String taskName = todoListApp.scanner.nextLine();//入力内容を取得
                todoListApp.addTask(taskName);
                break;

                //タスク一覧表示
                case 2:
                todoListApp.showTasks();
                break;

                //終了
                case 3:
                exit = true;
                System.out.println("アプリケーションを終了します。");
                break;

                case 4:
                System.out.printf("\n削除するタスクの番号を入力してください:");
                int taskIndexToRemove = todoListApp.scanner.nextInt();
                todoListApp.removeTask(taskIndexToRemove - 1); 
                break;

                //1~4以外の番号を選択したとき
                default:
                System.out.println("無効な選択です。1~3のいずれかを選択してください。");
            }
        }

        //scannerをクローズ
        todoListApp.closeScanner();
    }

}