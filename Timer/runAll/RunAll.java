package runAll;

import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextPane;
import stacks.StackRunner;
import arrayList.ArrayListRunner;
import hashTables.HashTableRunner;
import linkedLists.LinkedListRunner;
import maps.MapRunner;
import queues.QueueRunner;
import sets.SetRunner;
import trees.TreeRunner;

public class RunAll {

    public static double[] _ArrayList;
    public static double[] _HashTable;
    public static double[] _LinkedList;
    public static double[][] _Map;
    public static double[][] _Queue;
    public static double[][] _Set;
    public static double[] _Stack;
    public static double[] _Tree;

    public static void main(String[] args) throws FileNotFoundException {

        int ran = (int) ((Math.random() * 9999) + 1);
        Scanner scan = new Scanner(new FileReader("Timer\\MassiveFile.txt"));
        for (int index = 0; index < ran; index++) {
            scan.next();
        }
        String x = scan.next();
        scan.close();

        // ArrayList
        Thread arrayList = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    ArrayListRunner.main(new String[] { x });
                    _ArrayList = ArrayListRunner.time();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

        });
        // HashTable
        Thread hashTable = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    HashTableRunner.main(new String[] { x });
                    _HashTable = HashTableRunner.time();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        // LinkedList
        Thread linkedList = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    LinkedListRunner.main(new String[] { x });
                    _LinkedList = LinkedListRunner.time();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

        });
        // Map
        Thread map = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    MapRunner.main(new String[] { x });
                    _Map = MapRunner.time();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        // Queue
        Thread queue = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    QueueRunner.main(new String[] { x });
                    _Queue = QueueRunner.time();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        // Set
        Thread set = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    SetRunner.main(new String[] { x });
                    _Set = SetRunner.time();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        // stack
        Thread stack = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    StackRunner.main(new String[] { x });
                    _Stack = StackRunner.time();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        // Tree
        Thread tree = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TreeRunner.main(new String[] { x });
                    _Tree = TreeRunner.time();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        // ************************************ \\
        System.out.println("Array List");
        arrayList.start();
        while (arrayList.isAlive()) {
        }

        // ************************************ \\
        System.out.println("---------------------------");
        System.out.println("Hash Table");
        hashTable.start();
        while (hashTable.isAlive()) {
        }

        // ************************************ \\
        System.out.println("---------------------------");
        System.out.println("Linked List");
        linkedList.start();
        while (linkedList.isAlive()) {
        }

        // ************************************ \\
        System.out.println("---------------------------");
        System.out.println("Map");
        map.start();
        while (map.isAlive()) {
        }

        // ************************************ \\
        System.out.println("---------------------------");
        System.out.println("Queue");
        queue.start();
        while (queue.isAlive()) {
        }

        // ************************************ \\
        System.out.println("---------------------------");
        System.out.println("Set");
        set.start();
        while (set.isAlive()) {
        }

        // ************************************ \\
        System.out.println("---------------------------");
        System.out.println("Stack");
        stack.start();
        while (stack.isAlive()) {
        }

        // ************************************ \\
        System.out.println("---------------------------");
        System.out.println("Tree");
        tree.start();
        while (tree.isAlive()) {
        }

        // Builds the window
        buildWindow();
    }

    private static void buildWindow() {
        Map<String, Double> addTo = new TreeMap<String, Double>();
        Map<String, Double> getFrom = new TreeMap<String, Double>();
        // Adds everything to addTo
        addTo.put("ArrayList", _ArrayList[0]);
        addTo.put("HashTable", _HashTable[0]);
        addTo.put("LinkedList", _HashTable[0]);
        addTo.put("HashTableMap", _Map[0][0]);
        addTo.put("LinkedHashMap", _Map[1][0]);
        addTo.put("TreeMap", _Map[2][0]);
        addTo.put("LinkedListQueue", _Queue[0][0]);
        addTo.put("PriorityQueue", _Queue[1][0]);
        addTo.put("HashSet", _Set[0][0]);
        addTo.put("LinkedHashSet", _Set[1][0]);
        addTo.put("TreeSet", _Set[2][0]);
        addTo.put("Stack", _Stack[0]);
        addTo.put("Tree", _Tree[0]);

        // Adds everything to getFrom
        getFrom.put("ArrayList", _ArrayList[1]);
        getFrom.put("HashTable", _HashTable[1]);
        getFrom.put("LinkedList", _HashTable[1]);
        getFrom.put("HashTableMap", _Map[0][1]);
        getFrom.put("LinkedHashMap", _Map[1][1]);
        getFrom.put("TreeMap", _Map[2][1]);
        getFrom.put("LinkedListQueue", _Queue[0][1]);
        getFrom.put("PriorityQueue", _Queue[1][1]);
        getFrom.put("HashSet", _Set[0][1]);
        getFrom.put("LinkedHashSet", _Set[1][1]);
        getFrom.put("TreeSet", _Set[2][1]);
        getFrom.put("Stack", _Stack[1]);
        getFrom.put("Tree", _Tree[1]);

        // Draws the frame
        init(addTo, getFrom);
    }

    private static void init(Map<String, Double> addTo, Map<String, Double> getFrom) {
        addTo = sortByComparator(addTo);
        getFrom = sortByComparator(getFrom);

        Object[] addToKeyObj = addTo.keySet().toArray();
        Object[] getFromKeyObj = getFrom.keySet().toArray();

        String[] addToKey = new String[addToKeyObj.length];
        String[] getFromKey = new String[getFromKeyObj.length];
        for (int index = 0; index < addToKeyObj.length; index++) {
            addToKey[index] = (String) addToKeyObj[index];
            getFromKey[index] = (String) getFromKeyObj[index];
        }

        String[] _addList = new String[addToKey.length];
        String[] _getFrom = new String[addToKey.length];
        for (int index = 0; index < addToKeyObj.length; index++) {
            _addList[index] = addToKey[index] + " Time: " + addTo.get(addToKey[index]) + " ms";
        }

        for (int index = 0; index < addToKeyObj.length; index++) {
            _getFrom[index] = getFromKey[index] + " Time: " + getFrom.get(getFromKey[index]) + " ms";
        }

        JFrame frmTime = new JFrame();
        frmTime.setTitle("Data Structure Timer");
        frmTime.getContentPane().setFont(new Font("Arial Black", Font.PLAIN, 12));
        frmTime.setBounds(100, 100, 576, 352);
        frmTime.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmTime.getContentPane().setLayout(null);

        JList<String> addList = new JList<String>();
        addList.setFont(new Font("Arial Black", Font.PLAIN, 12));
        addList.setModel(new AbstractListModel<String>() {
            private static final long serialVersionUID = 1L;
            String[] values = _addList;

            public int getSize() {
                return values.length;
            }

            public String getElementAt(int index) {
                return values[index];
            }
        });
        addList.setBounds(0, 38, 276, 275);
        frmTime.getContentPane().add(addList);

        JTextPane txtAdd = new JTextPane();
        txtAdd.setText("Time to add to data structures");
        txtAdd.setFont(new Font("Arial Black", Font.PLAIN, 16));
        txtAdd.setBounds(0, 0, 276, 37);
        txtAdd.setEditable(false);
        frmTime.getContentPane().add(txtAdd);

        JTextPane txtGet = new JTextPane();
        txtGet.setText("Time to get from structure\r\n");
        txtGet.setFont(new Font("Arial Black", Font.PLAIN, 16));
        txtGet.setBounds(284, 0, 276, 37);
        txtGet.setEditable(false);
        frmTime.getContentPane().add(txtGet);

        JList<String> getList = new JList<String>();
        getList.setFont(new Font("Arial Black", Font.PLAIN, 12));
        getList.setModel(new AbstractListModel<String>() {
            private static final long serialVersionUID = 1L;
            String[] values = _getFrom;

            public int getSize() {
                return values.length;
            }

            public String getElementAt(int index) {
                return values[index];
            }
        });
        getList.setBounds(284, 38, 276, 275);
        frmTime.getContentPane().add(getList);
        frmTime.setVisible(true);
    }

    private static Map<String, Double> sortByComparator(Map<String, Double> unsortMap) {

        // Convert Map to List
        List<Map.Entry<String, Double>> list = new LinkedList<Map.Entry<String, Double>>(unsortMap.entrySet());

        // Sort list with comparator, to compare the Map values
        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // Convert sorted map back to a Map
        Map<String, Double> sortedMap = new LinkedHashMap<String, Double>();
        for (Iterator<Map.Entry<String, Double>> it = list.iterator(); it.hasNext();) {
            Map.Entry<String, Double> entry = it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
}