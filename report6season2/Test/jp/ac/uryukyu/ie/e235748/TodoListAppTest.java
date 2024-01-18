package jp.ac.uryukyu.ie.e235748;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;


public class TodoListAppTest{
    
    /*public void testTodoListApp(){
        TodoListApp todoListApp = new TodoListApp();

        //tasksリストが初期化され、空であることを確認
        assertNotNull(todoListApp.tasks);
        assertTrue(todoListApp.tasks.isEmpty());

        //scannerが初期化されているを確認
        assertNotNull(todoListApp.scanner);
        assertTrue(todoListApp.scanner instanceof Scanner);
    }*/

    private final InputStream systemin = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayOutputStream testOut;
    private TodoListApp todoListApp;

    @Before
    public void setUp(){
        ///System.inとSystem.outをテストのために設定
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
        
        //TodoListAppを初期化
        todoListApp = new TodoListApp();
    }

    @After
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
        //タスクが正常に追加されたかを確認
        assertEquals("新しいタスクを追加しました:Task 1\n" , testOut.toString());//左が期待値で右が実装値
    }

    @Test
    public void testShowTasksEmpty(){
        todoListApp.showTasks();
        //タスクがない場合の出力を確認  
        String expected = "タスクはありません";
        String actual = testOut.toString();
        assertEquals(expected, actual);

    }


    @Test
    public void testShowTasksNonEmpty(){
        todoListApp.addTask("Task 1");
        todoListApp.addTask("Task 2");

        //出力をキャプチャするためにSystem.outをリダイレクト
        System.setOut(new PrintStream(testOut));

        todoListApp.showTasks();
        //タスクがある場合の出力を確認
        assertEquals("新しいタスクを追加しました:Task 1\n" +  "新しいタスクを追加しました:Task 2");
        assertEquals("タスク一覧:\n1.Task 1 - 完了:false\n2.Task 2 - 完了:false\n");
    }

    @Test
    public void testRemoveTask(){
        TodoListApp todoListApp = new TodoListApp();
        
        //テスト用のタスクを追加
        todoListApp.addTask("Task1");
        todoListApp.addTask("Task2");

        //タスクが正しく追加されたことを確認
        assertEquals(3,todoListApp.tasks.size());

        //タスクを削除する
        todoListApp.removeTask(0);//Task1

        //タスクが正しく削除されたことを確認
        assertEquals(2,todoListApp.tasks.size());

        //存在しないインデックスのタスクを削除する場合のテスト
        todoListApp.removeTask(5);
        assertEquals(2,todoListApp.tasks.size());
    }

    private void assertEquals(String string) {
        throw new UnsupportedOperationException("Unimplemented method 'assertEquals'");
    }
}