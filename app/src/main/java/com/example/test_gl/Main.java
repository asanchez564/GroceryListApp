package com.example.test_gl;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Scanner;
public class Main extends AppCompatActivity {
    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();
    private EditText mItemEdit;
    private ListView mShoppingListy;
    private Button mAddButton;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShoppingListy = (ListView) findViewById(R.id.shopping_listView);
        mItemEdit = (EditText) findViewById(R.id.item_editText);
        mAddButton = (Button) findViewById(R.id.add_button);
    }

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while(!quit) {
            System.out.println("Enter Your Choice");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3 :
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    processArrayList();
                    break;
                case 7:
                    quit= true;
                    break;
            }
        }
        System.out.println("*********************************************************\r");
        ArrayList<String> myToDoList = new ArrayList<String>();
        myToDoList.add("Write an article");
        myToDoList.add("Make a Youtube Video");
        myToDoList.add("Make a salad for dinner");
        System.out.println(myToDoList.size());
        myToDoList.set(0, "Don't forget things");
        myToDoList.set(1, "Buy milk and orange juice");
        myToDoList.remove(0);
        for(int i = 0; i < myToDoList.size(); i++) {
            System.out.println("Item No " + (i) + " - "+ myToDoList.get(i));
        }
    }
    public static void printInstructions() {
        System.out.println("\nPress");
        System.out.println("\t 0 - To Print The Instructions ");
        System.out.println("\t 1 - To Print GroceryList ");
        System.out.println("\t 2 - To Add Item ");
        System.out.println("\t 3 - To Modify item ");
        System.out.println("\t 4 - To Remove Item ");
        System.out.println("\t 5 - To Search for an Item ");
        System.out.println("\t 6 - To Process Array List. ");
        System.out.println("\t 7 - To Not Continue");
    }
    public static void addItem() {
        System.out.print("Add : Please enter the grocery Item : ");
        groceryList.addGroceryItem(scanner.nextLine());
    }
    public static void modifyItem() {
        System.out.print("Modify : Enter the Item: ");
        String curItem = scanner.nextLine();
        System.out.print("Modify : Enter the Replacement Item");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(curItem, newItem);
    }
    public static void removeItem() {
        System.out.print("Remove : Enter the Item: ");
        String itemNo = scanner.nextLine();
        groceryList.removeItem(itemNo);
        System.out.print("msg: The Item has been removed");
        groceryList.printGroceryList();
    }
    public static void searchForItem() {
        System.out.print("Item to search for: ");
        String searchItem = scanner.nextLine();
        if(groceryList.onFile(searchItem)) {
            System.out.println("Item " + searchItem + " is on the list");
        }else{
            System.out.println(searchItem + " is not in the list");
        }
    }

    public static void processArrayList() {
        ArrayList<String> newArrayList = new ArrayList<String>();
        newArrayList.addAll(groceryList.getGroceryList());
        ArrayList<String> anotherArrayList = new ArrayList<>(groceryList.getGroceryList());
        String[] myArray = new String[groceryList.getGroceryList().size()];
        myArray = groceryList.getGroceryList().toArray(myArray);
    }
}
<string name = "action+settings"> Settings</string>
<string name = "abb_button_text">Add</string>
<string name = "item_editText_hint"</string>
