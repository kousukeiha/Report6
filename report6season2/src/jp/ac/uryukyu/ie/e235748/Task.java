package jp.ac.uryukyu.ie.e235748;

public class Task {
    private String name;
    private boolean completed;

    //タスクのコンストラクタ
    public Task(String name){
        this.name = name;
        this.completed = false;
    }

    //タスクの名前を取得するメソッド
    public String getName(){
        return name;
    }

    //タスクが完了しているか判定する
    public boolean isCompleted(){
        return completed;
    }

    //タスクを完了状態にする
    public void complete(){
        completed = true;
    }

}
