package jp.ac.uryukyu.ie.e235748;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
public class TodoListAppTest {

    private final InputStream systemin = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayOutputStream testOut;
    private TodoListApp todoListApp;

    @BeforeEach
    public void setUp(){
        ///System.inとSystem.outをテストのために設定
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
        
        //TodoListAppを初期化
        todoListApp = new TodoListApp();
    }

    @AfterEach
    public void tearDown(){
        //テスト後にSystem.inとSystem.outをリセット
        System.setIn(systemin);
        System.setOut(systemOut);

        //scannerをクローズ
        todoListApp.closeScanner();
    }

    @Test
    public void testAddTask(){
        todoListApp.addTask("Task 1");
        //タスクが正常にjava追加されたかを確認
        //assertEquals("新しいタスクを追加しました:Task 1\n" , testOut.toString());//左が期待値で右が実装値
        Assertions.assertEquals("新しいタスクを追加しました:Task 1\n" , testOut.toString());
    }

    @Test
    //タスクの中身が空の時のテスト
    public void testShowTasksEmpty(){
        todoListApp.showTasks();
        //タスクがない場合の出力を確認  
        String expected = "タスクはありません\n";
        String actual = testOut.toString();
        actual.equals(expected);
        Assertions.assertEquals(expected, actual);

    }


    @Test
    //タスクの中身がある時のテスト
    public void testShowTasksNonEmpty(){
        
        todoListApp.addTask("Task 1");

        //出力をキャプチャするためにSystem.outをリダイレクト
        System.setOut(new PrintStream(testOut));
        todoListApp.showTasks();
        Assertions.assertEquals("新しいタスクを追加しました:Task 1\n\nタスク一覧:\n1.Task 1\n",testOut.toString());
    }

    @Test
    //タスクを削除できるかを確認するテスト
    public void testRemoveTask(){
        TodoListApp todoListApp = new TodoListApp();
        
        todoListApp.addTask("Task1");
        todoListApp.addTask("Task2");

        //タスクが正しく追加されたことを確認
        Assertions.assertEquals(2,todoListApp.tasks.size());
        //タスクを削除する
        todoListApp.removeTask(0);
        //タスクが正しく削除されたことを確認
        Assertions.assertEquals(1,todoListApp.tasks.size());
    }
}